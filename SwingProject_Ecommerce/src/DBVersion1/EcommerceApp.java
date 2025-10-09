package DBVersion1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EcommerceApp {
    
    static ArrayList<String[]> cart = new ArrayList<>();
    static String userName = "";
    static String userEmail = "";
    static String userContact = "";
    static int currentCustomerId = -1;

    public static void main(String[] args) {
        // Test database connection
        if (!DBConnection.testConnection()) {
            JOptionPane.showMessageDialog(null, 
                "❌ Database connection failed!\n\n" +
                "Please check:\n" +
                "1. MySQL is running\n" +
                "2. Database 'ecommerce_db' exists\n" +
                "3. Username/password in DBConnection.java\n" +
                "4. MySQL Connector JAR added",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        askUserDetails();
    }

    public static void askUserDetails() {
        JFrame userFrame = new JFrame("Customer Registration");
        userFrame.setSize(400, 220);
        userFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel contactLabel = new JLabel("Contact:");
        JTextField contactField = new JTextField();

        JButton submitBtn = new JButton("Start Shopping");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(contactLabel);
        panel.add(contactField);
        panel.add(new JLabel(""));
        panel.add(submitBtn);

        userFrame.add(panel);

        submitBtn.addActionListener(e -> {
            userName = nameField.getText().trim();
            userEmail = emailField.getText().trim();
            userContact = contactField.getText().trim();

            if (userName.isEmpty() || userEmail.isEmpty() || userContact.isEmpty()) {
                JOptionPane.showMessageDialog(userFrame, "Please fill all details!");
            } else {
                currentCustomerId = CustomerDAO.saveCustomer(userName, userEmail, userContact);
                
                if (currentCustomerId > 0) {
                    JOptionPane.showMessageDialog(userFrame, 
                        "Welcome " + userName + "!\nHappy Shopping!");
                    userFrame.dispose();
                    openMainWindow();
                } else {
                    JOptionPane.showMessageDialog(userFrame, 
                        "Error saving customer!\nCheck database.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        userFrame.setVisible(true);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void openMainWindow() {
        JFrame frame = new JFrame("E-Commerce Shopping Portal");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        
        // Try to load image, if fails show welcome text
        try {
            // CHANGE THIS PATH to your image location
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\YourUsername\\Downloads\\EcommerceProjectImage1.png");
            
            // Check if image loaded successfully
            if (imageIcon.getIconWidth() > 0) {
                JLabel imageLabel = new JLabel(imageIcon);
                frame.add(imageLabel, BorderLayout.CENTER);
            } else {
                // If image not found, show welcome text
                JLabel welcomeLabel = new JLabel("Welcome to Online Shopping!", JLabel.CENTER);
                welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
                frame.add(welcomeLabel, BorderLayout.CENTER);
            }
        } catch (Exception ex) {
            // If error loading image, show welcome text
            JLabel welcomeLabel = new JLabel("Welcome to Online Shopping!", JLabel.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(welcomeLabel, BorderLayout.CENTER);
        }

        frame.setJMenuBar(createMenuBar());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Electronics Menu
        JMenu electronicsMenu = new JMenu("Electronics");
        
        addMenuItem(electronicsMenu, "Mobiles", new String[][]{
            {"iPhone 14", "Rs 80000", "Latest Apple smartphone"},
            {"Samsung Galaxy S23", "Rs 70000", "Samsung phone"},
            {"OnePlus 11", "Rs 60000", "Smooth performance phone"},
            {"Realme 12 Pro", "Rs 30000", "Mid-range with good camera"},
            {"Redmi Note 12", "Rs 20000", "Affordable smartphone"}
        });
        
        addMenuItem(electronicsMenu, "Laptops", new String[][]{
            {"MacBook Air", "Rs 100000", "Lightweight Apple laptop"},
            {"Dell XPS", "Rs 90000", "Powerful ultrabook"},
            {"HP Pavilion", "Rs 60000", "Budget friendly laptop"},
            {"Lenovo ThinkPad", "Rs 75000", "Business laptop"},
            {"Asus ROG", "Rs 120000", "Gaming laptop"}
        });
        
        addMenuItem(electronicsMenu, "Cameras", new String[][]{
            {"Canon EOS 1500D", "Rs 40000", "DSLR Camera"},
            {"Nikon D3500", "Rs 45000", "Entry level DSLR"},
            {"Sony Alpha", "Rs 60000", "Mirrorless camera"},
            {"Fujifilm X-T4", "Rs 120000", "Professional camera"},
            {"GoPro Hero", "Rs 30000", "Action camera"}
        });
        
        addMenuItem(electronicsMenu, "Headphones", new String[][]{
            {"Sony WH-1000XM4", "Rs 25000", "Noise cancelling"},
            {"Bose QC 45", "Rs 30000", "Premium headphones"},
            {"JBL Tune", "Rs 5000", "Bass boosted"},
            {"Boat Rockerz", "Rs 2000", "Budget headphones"},
            {"Apple AirPods Pro", "Rs 25000", "Wireless earbuds"}
        });
        
        addMenuItem(electronicsMenu, "Mouse", new String[][]{
            {"Logitech MX Master", "Rs 8000", "Ergonomic mouse"},
            {"HP Wireless Mouse", "Rs 1500", "Basic wireless"},
            {"Razer DeathAdder", "Rs 6000", "Gaming mouse"},
            {"Dell Optical", "Rs 700", "Simple wired mouse"},
            {"Microsoft Surface Mouse", "Rs 5000", "Premium mouse"}
        });
        
        // Furniture Menu
        JMenu furnitureMenu = new JMenu("Furniture");
        
        addMenuItem(furnitureMenu, "Sofas", new String[][]{
            {"Leather Sofa", "Rs 30000", "3 Seater leather sofa"},
            {"Fabric Sofa", "Rs 20000", "Comfortable fabric sofa"},
            {"Recliner Sofa", "Rs 40000", "Adjustable recliner"},
            {"Wooden Sofa", "Rs 25000", "Classic wooden style"},
            {"Corner Sofa", "Rs 35000", "Space saving sofa"}
        });
        
        addMenuItem(furnitureMenu, "Tables", new String[][]{
            {"Dining Table", "Rs 20000", "6 Seater dining table"},
            {"Coffee Table", "Rs 5000", "Small wooden table"},
            {"Glass Table", "Rs 15000", "Modern glass top"},
            {"Study Table", "Rs 8000", "Compact study table"},
            {"Office Table", "Rs 12000", "Workstation table"}
        });
        
        addMenuItem(furnitureMenu, "Chairs", new String[][]{
            {"Office Chair", "Rs 7000", "Ergonomic chair"},
            {"Dining Chair", "Rs 2000", "Wooden dining chair"},
            {"Plastic Chair", "Rs 500", "Simple plastic chair"},
            {"Rocking Chair", "Rs 6000", "Relaxing chair"},
            {"Recliner Chair", "Rs 10000", "Comfort recliner"}
        });
        
        addMenuItem(furnitureMenu, "Beds", new String[][]{
            {"Single Bed", "Rs 10000", "Wooden single bed"},
            {"Double Bed", "Rs 20000", "King size bed"},
            {"Bunk Bed", "Rs 15000", "Kids bunk bed"},
            {"Sofa Bed", "Rs 25000", "Convertible sofa bed"},
            {"Storage Bed", "Rs 30000", "Bed with storage"}
        });
        
        addMenuItem(furnitureMenu, "Couches", new String[][]{
            {"Luxury Couch", "Rs 40000", "Premium couch"},
            {"Compact Couch", "Rs 15000", "Space saving"},
            {"Modern Couch", "Rs 25000", "Trendy couch"},
            {"Vintage Couch", "Rs 30000", "Classic style"},
            {"L-shaped Couch", "Rs 35000", "Spacious couch"}
        });
        
        // Clothing Menu
        JMenu clothingMenu = new JMenu("Clothing");
        
        addMenuItem(clothingMenu, "Women", new String[][]{
            {"Saree", "Rs 2000", "Traditional Indian saree"},
            {"Kurti", "Rs 800", "Cotton Kurti"},
            {"Jeans", "Rs 1500", "Blue denim jeans"},
            {"Top", "Rs 1000", "Trendy top"},
            {"Dress", "Rs 2500", "Party wear dress"}
        });
        
        addMenuItem(clothingMenu, "Men", new String[][]{
            {"Shirt", "Rs 1200", "Formal shirt"},
            {"T-Shirt", "Rs 800", "Casual t-shirt"},
            {"Jeans", "Rs 2000", "Slim fit jeans"},
            {"Suit", "Rs 5000", "Business suit"},
            {"Kurta", "Rs 1500", "Traditional kurta"}
        });
        
        addMenuItem(clothingMenu, "Kids", new String[][]{
            {"Kids Frock", "Rs 1000", "Beautiful frock"},
            {"Kids Shirt", "Rs 600", "Cotton shirt"},
            {"Kids Shorts", "Rs 500", "Casual shorts"},
            {"Kids Jeans", "Rs 800", "Denim jeans"},
            {"Kids Kurta", "Rs 900", "Traditional kurta"}
        });
        
        addMenuItem(clothingMenu, "Girls", new String[][]{
            {"Skirt", "Rs 700", "Stylish skirt"},
            {"Leggings", "Rs 500", "Comfort leggings"},
            {"Top", "Rs 800", "Trendy top"},
            {"Frock", "Rs 1200", "Party wear frock"},
            {"Jumpsuit", "Rs 1500", "Modern jumpsuit"}
        });
        
        addMenuItem(clothingMenu, "Boys", new String[][]{
            {"Shirt", "Rs 1000", "Checked shirt"},
            {"T-Shirt", "Rs 600", "Sports t-shirt"},
            {"Jeans", "Rs 1200", "Casual jeans"},
            {"Shorts", "Rs 700", "Cotton shorts"},
            {"Blazer", "Rs 3000", "Formal blazer"}
        });
        
        // Grocery Menu
        JMenu groceryMenu = new JMenu("Grocery");
        
        addMenuItem(groceryMenu, "Fruits", new String[][]{
            {"Apple", "Rs 200", "Fresh apples"},
            {"Banana", "Rs 50", "Yellow bananas"},
            {"Orange", "Rs 80", "Sweet oranges"},
            {"Mango", "Rs 120", "Seasonal mangoes"},
            {"Grapes", "Rs 90", "Green grapes"}
        });
        
        addMenuItem(groceryMenu, "Vegetables", new String[][]{
            {"Potato", "Rs 40", "Fresh potatoes"},
            {"Tomato", "Rs 30", "Red tomatoes"},
            {"Onion", "Rs 50", "Farm onions"},
            {"Carrot", "Rs 60", "Orange carrots"},
            {"Spinach", "Rs 25", "Green spinach"}
        });
        
        addMenuItem(groceryMenu, "Dairy Products", new String[][]{
            {"Milk", "Rs 50", "1 litre packet"},
            {"Curd", "Rs 40", "Fresh curd"},
            {"Cheese", "Rs 150", "Cheddar cheese"},
            {"Butter", "Rs 120", "Amul butter"},
            {"Paneer", "Rs 200", "Fresh paneer"}
        });
        
        addMenuItem(groceryMenu, "Rice", new String[][]{
            {"Basmati Rice", "Rs 100", "Premium rice"},
            {"Brown Rice", "Rs 80", "Healthy rice"},
            {"Sona Masoori", "Rs 90", "Daily use rice"},
            {"Jasmine Rice", "Rs 150", "Aromatic rice"},
            {"Parboiled Rice", "Rs 70", "Boiled rice"}
        });
        
        addMenuItem(groceryMenu, "Snacks", new String[][]{
            {"Chips", "Rs 20", "Potato chips"},
            {"Biscuits", "Rs 30", "Sweet biscuits"},
            {"Namkeen", "Rs 50", "Spicy mixture"},
            {"Chocolate", "Rs 100", "Milk chocolate"},
            {"Popcorn", "Rs 40", "Salted popcorn"}
        });
        
        // Cart Menu
        JMenu cartMenu = new JMenu("Cart");
        JMenuItem viewCartItem = new JMenuItem("View Cart & Checkout");
        viewCartItem.addActionListener(e -> showBill());
        cartMenu.add(viewCartItem);
        
        menuBar.add(electronicsMenu);
        menuBar.add(furnitureMenu);
        menuBar.add(clothingMenu);
        menuBar.add(groceryMenu);
        menuBar.add(cartMenu);
        
        return menuBar;
    }

    public static void addMenuItem(JMenu menu, String itemName, String[][] products) {
        JMenuItem menuItem = new JMenuItem(itemName);
        menuItem.addActionListener(e -> showItemsPage(itemName, products));
        menu.add(menuItem);
    }

    public static void showItemsPage(String category, String[][] items) {
        JFrame itemsFrame = new JFrame(category);
        itemsFrame.setSize(600, 500);
        itemsFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (String[] item : items) {
            JPanel productPanel = new JPanel(new GridLayout(4, 1));
            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel nameLabel = new JLabel("Name: " + item[0]);
            JLabel priceLabel = new JLabel("Price: " + item[1]);
            JLabel descLabel = new JLabel("Description: " + item[2]);

            JButton addBtn = new JButton("Add to Cart");
            addBtn.addActionListener(e -> {
                cart.add(item);
                JOptionPane.showMessageDialog(null, item[0] + " added to cart!");
            });

            productPanel.add(nameLabel);
            productPanel.add(priceLabel);
            productPanel.add(descLabel);
            productPanel.add(addBtn);

            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        itemsFrame.add(scrollPane);
        itemsFrame.setVisible(true);
    }

    public static void showBill() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Your cart is empty!");
            return;
        }
        
        JFrame billFrame = new JFrame("Your Bill");
        billFrame.setSize(400, 450);
        billFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        int total = 0;
        panel.add(new JLabel("=== ORDER SUMMARY ==="));
        panel.add(new JLabel("Customer: " + userName));
        panel.add(new JLabel("Email: " + userEmail));
        panel.add(new JLabel("Contact: " + userContact));
        panel.add(new JLabel("------------------------"));

        for (String[] item : cart) {
            panel.add(new JLabel(item[0] + " - " + item[1]));
            String priceDigits = item[1].replaceAll("[^0-9]", "");
            if (!priceDigits.isEmpty()) {
                total += Integer.parseInt(priceDigits);
            }
        }

        panel.add(new JLabel("------------------------"));
        JLabel totalLabel = new JLabel("Total: ₹" + total);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(totalLabel);
        
        final int finalTotal = total;
        JButton confirmBtn = new JButton("Confirm & Place Order");
        confirmBtn.addActionListener(e -> {
            boolean saved = OrderDAO.saveOrder(currentCustomerId, finalTotal);
            
            if (saved) {
                JOptionPane.showMessageDialog(billFrame, 
                    "Order placed successfully!\n" +
                    "Total: ₹" + finalTotal + "\n" +
                    "Thank you for shopping!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                
                cart.clear();
                billFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(billFrame, 
                    "Error saving order!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(confirmBtn);

        billFrame.add(panel);
        billFrame.setVisible(true);
    }
}