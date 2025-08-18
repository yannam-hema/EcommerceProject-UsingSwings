package com.info.SwingsProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ecommerce {
    
    // cart list
    static ArrayList<String[]> cart = new ArrayList<>();

    public static void main(String[] args) {
        
        JFrame frame= new JFrame("Welcome to yannam's online Shopping Website");
        frame.setSize(1000,700);
        
        ImageIcon ic = new ImageIcon("C:\\Users\\yanna\\Downloads\\EcommerceProjectImage1.png");
        JLabel jl_mainImg = new JLabel(ic);
        frame.add(jl_mainImg);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // menu bar
        frame.setJMenuBar(new MenuBuilder().createMainMenu());
    }

    // function to show items of a category
    public static void showItemsPage(String category, String[][] items) {
        JFrame itemsFrame = new JFrame(category + " Page");
        itemsFrame.setSize(600,500);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (String[] i : items) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new GridLayout(4,1,5,5)); // adds gaps
            productPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            JLabel nameLabel = new JLabel("Name: " + i[0]);
            JLabel priceLabel = new JLabel("Price: " + i[1]);
            JLabel descLabel = new JLabel("Description: " + i[2]);

            JButton addBtn = new JButton("Add to Cart");
            addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cart.add(i);
                    JOptionPane.showMessageDialog(null, i[0] + " added to cart!");
                }
            });

            productPanel.add(nameLabel);
            productPanel.add(priceLabel);
            productPanel.add(descLabel);
            productPanel.add(addBtn);

            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0,10))); // gap between products
        }

        // checkout button at bottom
        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBill();
            }
        });
        mainPanel.add(checkoutBtn);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        itemsFrame.add(scrollPane);
        itemsFrame.setVisible(true);
    }

    // function to show bill
    public static void showBill() {
        JFrame billFrame = new JFrame("Your Bill");
        billFrame.setSize(400,400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int total = 0;
        for (String[] item : cart) {
            panel.add(new JLabel(item[0] + " - " + item[1]));
            total += Integer.parseInt(item[1].replaceAll("[^0-9]", ""));
        }

        panel.add(new JLabel("------------------------"));
        panel.add(new JLabel("Total: " + total + " Rs"));

        billFrame.add(panel);
        billFrame.setVisible(true);
    }

    // function to view cart separately
    public static void viewCart() {
        JFrame cartFrame = new JFrame("Cart Items");
        cartFrame.setSize(400,400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (cart.isEmpty()) {
            panel.add(new JLabel("Your cart is empty!"));
        } else {
            for (String[] item : cart) {
                panel.add(new JLabel(item[0] + " - " + item[1]));
            }
        }

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBill();
            }
        });
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(checkoutBtn);

        cartFrame.add(panel);
        cartFrame.setVisible(true);
    }
}
