package com.info.SwingsProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBuilder {

    public JMenuBar createMainMenu() {
        JMenuBar mb = new JMenuBar();

        mb.add(createElectronicsMenu());
        mb.add(createFurnitureMenu());
        mb.add(createClothingMenu());
        mb.add(createGroceriesMenu());

        return mb;
    }

    // -------------------- ELECTRONICS --------------------
    private JMenu createElectronicsMenu() {
        JMenu electronicsMenu = new JMenu("Electronics");

        electronicsMenu.add(createMenuItem("Mobiles", new String[][]{
                {"iPhone 15 Pro", "₹1,20,000", "Latest Apple iPhone with A17 chip"},
                {"Samsung Galaxy S24", "₹95,000", "Flagship Samsung phone with AI features"},
                {"OnePlus 12", "₹65,000", "Fast performance and smooth display"},
                {"Google Pixel 9", "₹70,000", "Best Android camera with AI"},
                {"Realme X100", "₹25,000", "Budget phone with 5G support"}
        }));

        electronicsMenu.add(createMenuItem("Laptop", new String[][]{
                {"Dell XPS 15", "₹1,50,000", "Premium ultrabook with strong performance"},
                {"MacBook Air M3", "₹1,20,000", "Apple silicon laptop, light & fast"},
                {"HP Spectre x360", "₹1,10,000", "Convertible laptop with touchscreen"},
                {"Lenovo ThinkPad X1", "₹1,30,000", "Business laptop, durable build"},
                {"Asus ROG Strix", "₹1,60,000", "Gaming beast with RGB keyboard"}
        }));

        electronicsMenu.add(createMenuItem("Camera", new String[][]{
                {"Canon EOS R7", "₹80,000", "Professional DSLR with 24MP lens"},
                {"Nikon Z50", "₹85,000", "Compact mirrorless camera"},
                {"Sony Alpha A7", "₹1,20,000", "Full-frame mirrorless camera"},
                {"Fujifilm X-T4", "₹95,000", "Retro style mirrorless camera"},
                {"Panasonic Lumix G7", "₹60,000", "Great for video recording"}
        }));

        electronicsMenu.add(createMenuItem("Head Phones", new String[][]{
                {"Sony WH-1000XM5", "₹25,000", "Noise-cancelling headphones"},
                {"Bose QC 45", "₹30,000", "Comfortable and great sound"},
                {"Apple AirPods Max", "₹60,000", "Premium Apple headphones"},
                {"JBL Tune 760NC", "₹9,000", "Wireless with deep bass"},
                {"Boat Rockerz 550", "₹2,500", "Budget headphones"}
        }));

        electronicsMenu.add(createMenuItem("Mouse", new String[][]{
                {"Logitech MX Master 3", "₹7,000", "Ergonomic wireless mouse"},
                {"Razer DeathAdder V2", "₹5,000", "Gaming mouse with RGB"},
                {"HP Wireless Mouse", "₹1,200", "Compact and budget friendly"},
                {"Dell Bluetooth Mouse", "₹1,500", "Office use wireless mouse"},
                {"Corsair Harpoon RGB", "₹3,000", "Gaming mouse with lighting"}
        }));

        return electronicsMenu;
    }

    // -------------------- FURNITURE --------------------
    private JMenu createFurnitureMenu() {
        JMenu furnitureMenu = new JMenu("Furniture");

        furnitureMenu.add(createMenuItem("Sofa", new String[][]{
                {"3-Seater Sofa", "₹30,000", "Comfortable sofa with cushions"},
                {"Leather Sofa", "₹45,000", "Luxurious leather finish"},
                {"Recliner Sofa", "₹50,000", "Push-back recliner style"},
                {"Wooden Sofa", "₹35,000", "Solid teak wood sofa"},
                {"L-Shaped Sofa", "₹55,000", "Modern corner sofa"}
        }));

        furnitureMenu.add(createMenuItem("Table", new String[][]{
                {"Dining Table", "₹20,000", "6-seater wooden dining table"},
                {"Coffee Table", "₹10,000", "Glass-top living room table"},
                {"Study Table", "₹8,000", "Compact study/work desk"},
                {"Bedside Table", "₹5,000", "Small side table for bedroom"},
                {"Glass Top Table", "₹12,000", "Stylish table with glass finish"}
        }));

        furnitureMenu.add(createMenuItem("Chair", new String[][]{
                {"Office Chair", "₹5,000", "Adjustable height office chair"},
                {"Plastic Chair", "₹800", "Lightweight plastic chair"},
                {"Rocking Chair", "₹6,500", "Wooden rocking chair"},
                {"Dining Chair", "₹2,000", "Dining table chair set"},
                {"Armchair", "₹7,000", "Comfortable armchair"}
        }));

        furnitureMenu.add(createMenuItem("Bed", new String[][]{
                {"King Size Bed", "₹40,000", "Spacious and strong"},
                {"Queen Size Bed", "₹35,000", "Perfect for couples"},
                {"Single Bed", "₹15,000", "Compact for one person"},
                {"Bunk Bed", "₹20,000", "Best for kids"},
                {"Folding Bed", "₹10,000", "Easy to move and store"}
        }));

        furnitureMenu.add(createMenuItem("Couch", new String[][]{
                {"Fabric Couch", "₹25,000", "Soft and cozy"},
                {"Leather Couch", "₹40,000", "Stylish leather couch"},
                {"Sectional Couch", "₹55,000", "Spacious and modern"},
                {"Pull-out Couch", "₹35,000", "Can convert to bed"},
                {"Modern Couch", "₹30,000", "Trendy design"}
        }));

        return furnitureMenu;
    }

    // -------------------- CLOTHING --------------------
    private JMenu createClothingMenu() {
        JMenu clothingMenu = new JMenu("Clothing");

        clothingMenu.add(createMenuItem("Women", new String[][]{
                {"Kurti", "₹1,200", "Traditional cotton kurti"},
                {"Saree", "₹2,500", "Silk saree for occasions"},
                {"Salwar Suit", "₹1,800", "Comfortable daily wear"},
                {"Jeans", "₹1,500", "Denim stretch jeans"},
                {"Tops", "₹800", "Trendy western tops"}
        }));

        clothingMenu.add(createMenuItem("Men", new String[][]{
                {"Shirt", "₹1,800", "Formal cotton shirt"},
                {"T-Shirt", "₹700", "Casual wear"},
                {"Blazer", "₹4,500", "Perfect for office/parties"},
                {"Jeans", "₹1,600", "Slim fit jeans"},
                {"Formal Pants", "₹2,000", "Business trousers"}
        }));

        clothingMenu.add(createMenuItem("Kids", new String[][]{
                {"Kids Frock", "₹600", "Cute frock for girls"},
                {"Kids Jeans", "₹800", "Denim for kids"},
                {"Kids T-Shirt", "₹400", "Casual wear for kids"},
                {"Kids Jacket", "₹1,200", "Winter jacket"},
                {"Kids Shorts", "₹500", "Summer shorts"}
        }));

        clothingMenu.add(createMenuItem("Girls", new String[][]{
                {"Party Dress", "₹2,500", "Occasion wear"},
                {"School Uniform", "₹1,000", "Daily school uniform"},
                {"Jeans", "₹900", "Trendy jeans"},
                {"Top", "₹600", "Casual wear"},
                {"Skirt", "₹800", "Stylish skirt"}
        }));

        clothingMenu.add(createMenuItem("Boys", new String[][]{
                {"Boys Jeans", "₹900", "Trendy jeans for boys"},
                {"Boys Shirt", "₹700", "Formal shirt"},
                {"Boys T-Shirt", "₹500", "Casual T-Shirt"},
                {"Boys Hoodie", "₹1,200", "Winter hoodie"},
                {"Boys Shorts", "₹600", "Summer shorts"}
        }));

        return clothingMenu;
    }

    // -------------------- GROCERY --------------------
    private JMenu createGroceriesMenu() {
        JMenu groceriesMenu = new JMenu("Grocery");

        groceriesMenu.add(createMenuItem("Fruits", new String[][]{
                {"Apples", "₹200/kg", "Fresh organic apples"},
                {"Bananas", "₹60/dozen", "Ripe yellow bananas"},
                {"Oranges", "₹120/kg", "Juicy sweet oranges"},
                {"Grapes", "₹150/kg", "Green seedless grapes"},
                {"Mangoes", "₹250/kg", "Seasonal Alphonso mangoes"}
        }));

        groceriesMenu.add(createMenuItem("Vegetables", new String[][]{
                {"Carrots", "₹100/kg", "Farm-fresh carrots"},
                {"Tomatoes", "₹40/kg", "Fresh red tomatoes"},
                {"Potatoes", "₹35/kg", "Good quality potatoes"},
                {"Onions", "₹50/kg", "Kitchen essential onions"},
                {"Spinach", "₹30/bunch", "Green leafy spinach"}
        }));

        groceriesMenu.add(createMenuItem("Dairy Products", new String[][]{
                {"Amul Milk", "₹60/L", "Pure and fresh cow milk"},
                {"Paneer", "₹350/kg", "Soft cottage cheese"},
                {"Cheese", "₹400/kg", "Delicious dairy cheese"},
                {"Curd", "₹80/kg", "Thick and fresh curd"},
                {"Butter", "₹450/kg", "Amul butter pack"}
        }));

        groceriesMenu.add(createMenuItem("Rice", new String[][]{
                {"Basmati Rice", "₹700/5kg", "Premium quality rice"},
                {"Sona Masoori Rice", "₹500/5kg", "Popular South Indian rice"},
                {"Brown Rice", "₹600/5kg", "Healthy brown rice"},
                {"Steamed Rice", "₹550/5kg", "Everyday rice"},
                {"Idli Rice", "₹650/5kg", "Perfect for idli and dosa"}
        }));

        groceriesMenu.add(createMenuItem("Snacks", new String[][]{
                {"Lays Chips", "₹20", "Tasty potato chips"},
                {"Kurkure", "₹10", "Crispy snack"},
                {"Popcorn", "₹50", "Ready-to-eat popcorn"},
                {"Biscuits", "₹30", "Parle-G biscuits"},
                {"Namkeen", "₹40", "Indian namkeen mix"}
        }));

        return groceriesMenu;
    }

    // -------------------- HELPER METHOD --------------------
    private JMenuItem createMenuItem(String menuName, String[][] items) {
        JMenuItem item = new JMenuItem(menuName);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showItemsPage(menuName, items);
            }
        });
        return item;
    }

    private void showItemsPage(String category, String[][] items) {
        JFrame itemsFrame = new JFrame(category + " Page");
        itemsFrame.setSize(600, 500);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String[] i : items) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new GridLayout(3, 1));
            productPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            JLabel nameLabel = new JLabel("Name: " + i[0]);
            JLabel priceLabel = new JLabel("Price: " + i[1]);
            JLabel descLabel = new JLabel("Description: " + i[2]);

            productPanel.add(nameLabel);
            productPanel.add(priceLabel);
            productPanel.add(descLabel);

            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        itemsFrame.add(scrollPane);

        itemsFrame.setVisible(true);
    }
}
