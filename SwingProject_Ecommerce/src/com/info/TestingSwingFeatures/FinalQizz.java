package com.info.TestingSwingFeatures;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

class Product {
    int id;
    String name, company, category, subcategory;
    double price, rating;

    Product(int id, String name, String company, double price, double rating, String category, String subcategory) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.rating = rating;
        this.category = category;
        this.subcategory = subcategory;
    }

    public String toString() {
        return name + " (" + company + ")";
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class JdbcEcommerce {
    static java.util.List<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {}
        SwingUtilities.invokeLater(JdbcEcommerce::showWelcomeScreen);
    }

    static void showWelcomeScreen() {
        JFrame frame = new JFrame("E-Commerce E-Card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 320);

        JLabel title = new JLabel("Welcome to the Ecommerce Shopping", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 22));

        JButton shopNowBtn = new JButton("Shop Now");
        JButton exitBtn = new JButton("Exit");

        shopNowBtn.addActionListener(e -> {
            frame.dispose();
            createAndShowGUI();
        });
        exitBtn.addActionListener(e -> frame.dispose());

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(title);
        panel.add(shopNowBtn);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void createAndShowGUI() {
        JFrame frame = new JFrame("E-Commerce Menu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton browseBtn = new JButton("Browse Categories");
        JButton cartBtn = new JButton("View Cart");
        JButton checkoutBtn = new JButton("Checkout");
        JButton exitBtn = new JButton("Exit");

        browseBtn.addActionListener(e -> browseCategories(frame));
        cartBtn.addActionListener(e -> viewCart(frame));
        checkoutBtn.addActionListener(e -> checkout(frame));
        exitBtn.addActionListener(e -> frame.dispose());

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(browseBtn);
        panel.add(cartBtn);
        panel.add(checkoutBtn);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // =================== BROWSE METHODS =====================

    static void browseCategories(JFrame parent) {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT DISTINCT category FROM products")) {

            java.util.List<String> categories = new ArrayList<>();
            while (rs.next()) categories.add(rs.getString(1));

            if (categories.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "No categories found.");
                return;
            }

            String cat = (String) JOptionPane.showInputDialog(parent, "Select Category:", "Categories",
                    JOptionPane.PLAIN_MESSAGE, null, categories.toArray(), categories.get(0));
            if (cat != null) browseSubCategories(parent, cat);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void browseSubCategories(JFrame parent, String category) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT DISTINCT subcategory FROM products WHERE category=?")) {

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            java.util.List<String> subs = new ArrayList<>();
            while (rs.next()) subs.add(rs.getString(1));

            if (subs.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "No subcategories found.");
                return;
            }

            String sub = (String) JOptionPane.showInputDialog(parent, "Select Subcategory:", "Subcategories",
                    JOptionPane.PLAIN_MESSAGE, null, subs.toArray(), subs.get(0));
            if (sub != null) browseProducts(parent, category, sub);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void browseProducts(JFrame parent, String category, String sub) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE category=? AND subcategory=?")) {

            ps.setString(1, category);
            ps.setString(2, sub);
            ResultSet rs = ps.executeQuery();

            java.util.List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "No products found.");
                return;
            }

            String[] arr = list.stream().map(Product::toString).toArray(String[]::new);
            String prod = (String) JOptionPane.showInputDialog(parent, "Select Product:", "Products",
                    JOptionPane.PLAIN_MESSAGE, null, arr, arr[0]);

            if (prod != null) {
                int index = Arrays.asList(arr).indexOf(prod);
                if (index >= 0) showProductDetails(parent, list.get(index));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showProductDetails(JFrame parent, Product p) {
        String msg = "Product: " + p.name +
                "\nCompany: " + p.company +
                "\nPrice: ₹" + p.price +
                "\nRating: " + p.rating + "\n\nAdd to cart?";
        int choice = JOptionPane.showConfirmDialog(parent, msg, "Details", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) addToCart(p, parent);
    }

    static void addToCart(Product p, JFrame parent) {
        for (CartItem item : cart) {
            if (item.product.id == p.id) {
                item.quantity++;
                JOptionPane.showMessageDialog(parent, "Increased quantity in cart.");
                return;
            }
        }
        cart.add(new CartItem(p, 1));
        JOptionPane.showMessageDialog(parent, "Added to cart!");
    }

    static void viewCart(JFrame parent) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Cart is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("--- Cart Items ---\n");
        double total = 0;
        for (CartItem item : cart) {
            double amt = item.product.price * item.quantity;
            total += amt;
            sb.append(item.product.name).append(" x ").append(item.quantity)
              .append(" = ₹").append(amt).append("\n");
        }
        sb.append("------------------------\nTotal: ₹").append(total);
        JOptionPane.showMessageDialog(parent, sb.toString());
    }

    static void checkout(JFrame parent) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Cart is empty.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            for (CartItem item : cart) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO cart(product_id, quantity) VALUES (?, ?)");
                ps.setInt(1, item.product.id);
                ps.setInt(2, item.quantity);
                ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(parent, "Checkout complete! Cart saved to database.");
            cart.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}}