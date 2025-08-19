package com.info.SwingsProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ecommerce {
    
    // cart list
    static ArrayList<String[]> cart = new ArrayList<>();

    // user details
    static String userName = "";
    static String userEmail = "";
    static String userContact = "";

    public static void main(String[] args) {
        askUserDetails();
    }

    // Asking user details
    public static void askUserDetails() {
        JFrame userFrame = new JFrame("User Details");
        userFrame.setSize(400, 220);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel contactLabel = new JLabel("Contact:");
        JTextField contactField = new JTextField();

        JButton submitBtn = new JButton("Submit");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(contactLabel);
        panel.add(contactField);
        panel.add(new JLabel("")); // empty cell
        panel.add(submitBtn);

        userFrame.add(panel);

        submitBtn.addActionListener(e -> {
            userName = nameField.getText().trim();
            userEmail = emailField.getText().trim();
            userContact = contactField.getText().trim();

            if (userName.isEmpty() || userEmail.isEmpty() || userContact.isEmpty()) {
                JOptionPane.showMessageDialog(userFrame, "Please fill all details!");
            } else {
                JOptionPane.showMessageDialog(userFrame, "Welcome " + userName + "!");
                userFrame.dispose();
                openMainWindow();
            }
        });

        userFrame.setVisible(true);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Main Window
    public static void openMainWindow() {
        JFrame frame= new JFrame("Welcome to yannam's online Shopping Website");
        frame.setSize(1000,700);
        
        ImageIcon ic = new ImageIcon("C:\\Users\\yanna\\Downloads\\EcommerceProjectImage1.png");
        JLabel jl_mainImg = new JLabel(ic);
        frame.add(jl_mainImg);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add menu bar
        frame.setJMenuBar(new MenuBuilder().createMainMenu());
    }

    // function to display items 
    public static void showItemsPage(String category, String[][] items) {
        JFrame itemsFrame = new JFrame(category + " Page");
        itemsFrame.setSize(600,500);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (String[] i : items) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new GridLayout(4,1));
            productPanel.setBorder(BorderFactory.createLineBorder(Color.black));

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
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // for spacing
        }

        // checkout button logic
        JButton checkoutBtn = new JButton("Checkout");
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

    // to show bill
    public static void showBill() {
        JFrame billFrame = new JFrame("Your Bill");
        billFrame.setSize(400,400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int total = 0;
        panel.add(new JLabel("Customer: " + userName));
        panel.add(new JLabel("Email: " + userEmail));
        panel.add(new JLabel("Contact: " + userContact));
        panel.add(new JLabel("------------------------"));

        for (String[] item : cart) {
            panel.add(new JLabel(item[0] + " - " + item[1]));
            // removing commas for calculation
            String priceDigits = item[1].replaceAll("[^0-9]", "");
            if(!priceDigits.isEmpty()) {
                total += Integer.parseInt(priceDigits);
            }
        }

        panel.add(new JLabel("------------------------"));
        panel.add(new JLabel("Total: ₹" + total));

        billFrame.add(panel);
        billFrame.setVisible(true);
    }
}
