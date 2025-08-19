package com.info.SwingsProject;

import javax.swing.*;

public class MenuBuilder {

    public JMenuBar createMainMenu() {
        JMenuBar mb = new JMenuBar();

        mb.add(createElectronicsMenu());
        mb.add(createFurnitureMenu());
        mb.add(createClothingMenu());
        mb.add(createGroceriesMenu());

        return mb;
    }

    private JMenu createElectronicsMenu() {
        JMenu electronicsMenu = new JMenu("Electronics");

        String[][] mobiles = {
            {"iPhone 14", "Rs 80000", "Latest Apple smartphone"},
            {"Samsung Galaxy S23", "Rs 70000", "Samsung phone"},
            {"OnePlus 11", "Rs 60000", "Smooth performance phone"},
            {"Realme 12 Pro", "Rs 30000", "Mid-range with good camera"},
            {"Redmi Note 12", "Rs 20000", "Affordable smartphone"}
        };

        String[][] laptops = {
            {"MacBook Air", "Rs 100000", "Lightweight Apple laptop"},
            {"Dell XPS", "Rs 90000", "Powerful ultrabook"},
            {"HP Pavilion", "Rs 60000", "Budget friendly laptop"},
            {"Lenovo ThinkPad", "Rs 75000", "Business laptop"},
            {"Asus ROG", "Rs 120000", "Gaming laptop"}
        };

        String[][] cameras = {
            {"Canon EOS 1500D", "Rs 40000", "DSLR Camera"},
            {"Nikon D3500", "Rs 45000", "Entry level DSLR"},
            {"Sony Alpha", "Rs 60000", "Mirrorless camera"},
            {"Fujifilm X-T4", "Rs 120000", "Professional camera"},
            {"GoPro Hero", "Rs 30000", "Action camera"}
        };

        String[][] headphones = {
            {"Sony WH-1000XM4", "Rs 25000", "Noise cancelling"},
            {"Bose QC 45", "Rs 30000", "Premium headphones"},
            {"JBL Tune", "Rs 5000", "Bass boosted"},
            {"Boat Rockerz", "Rs 2000", "Budget headphones"},
            {"Apple AirPods Pro", "Rs 25000", "Wireless earbuds"}
        };

        String[][] mice = {
            {"Logitech MX Master", "Rs 8000", "Ergonomic mouse"},
            {"HP Wireless Mouse", "Rs 1500", "Basic wireless"},
            {"Razer DeathAdder", "Rs 6000", "Gaming mouse"},
            {"Dell Optical", "Rs 700", "Simple wired mouse"},
            {"Microsoft Surface Mouse", "Rs 5000", "Premium mouse"}
        };

        JMenuItem mobilesItem = new JMenuItem("Mobiles");
        mobilesItem.addActionListener(e -> Ecommerce.showItemsPage("Mobiles", mobiles));

        JMenuItem laptopsItem = new JMenuItem("Laptops");
        laptopsItem.addActionListener(e -> Ecommerce.showItemsPage("Laptops", laptops));

        JMenuItem camerasItem = new JMenuItem("Cameras");
        camerasItem.addActionListener(e -> Ecommerce.showItemsPage("Cameras", cameras));

        JMenuItem headphonesItem = new JMenuItem("Headphones");
        headphonesItem.addActionListener(e -> Ecommerce.showItemsPage("Headphones", headphones));

        JMenuItem miceItem = new JMenuItem("Mouse");
        miceItem.addActionListener(e -> Ecommerce.showItemsPage("Mouse", mice));

        electronicsMenu.add(mobilesItem);
        electronicsMenu.add(laptopsItem);
        electronicsMenu.add(camerasItem);
        electronicsMenu.add(headphonesItem);
        electronicsMenu.add(miceItem);

        return electronicsMenu;
    }

    private JMenu createFurnitureMenu() {
        JMenu furnitureMenu = new JMenu("Furniture");

        String[][] sofas = {
            {"Leather Sofa", "Rs 30000", "3 Seater leather sofa"},
            {"Fabric Sofa", "Rs 20000", "Comfortable fabric sofa"},
            {"Recliner Sofa", "Rs 40000", "Adjustable recliner"},
            {"Wooden Sofa", "Rs 25000", "Classic wooden style"},
            {"Corner Sofa", "Rs 35000", "Space saving sofa"}
        };

        String[][] tables = {
            {"Dining Table", "Rs 20000", "6 Seater dining table"},
            {"Coffee Table", "Rs 5000", "Small wooden table"},
            {"Glass Table", "Rs 15000", "Modern glass top"},
            {"Study Table", "Rs 8000", "Compact study table"},
            {"Office Table", "Rs 12000", "Workstation table"}
        };

        String[][] chairs = {
            {"Office Chair", "Rs 7000", "Ergonomic chair"},
            {"Dining Chair", "Rs 2000", "Wooden dining chair"},
            {"Plastic Chair", "Rs 500", "Simple plastic chair"},
            {"Rocking Chair", "Rs 6000", "Relaxing chair"},
            {"Recliner Chair", "Rs 10000", "Comfort recliner"}
        };

        String[][] beds = {
            {"Single Bed", "Rs 10000", "Wooden single bed"},
            {"Double Bed", "Rs 20000", "King size bed"},
            {"Bunk Bed", "Rs 15000", "Kids bunk bed"},
            {"Sofa Bed", "Rs 25000", "Convertible sofa bed"},
            {"Storage Bed", "Rs 30000", "Bed with storage"}
        };

        String[][] couches = {
            {"Luxury Couch", "Rs 40000", "Premium couch"},
            {"Compact Couch", "Rs 15000", "Space saving"},
            {"Modern Couch", "Rs 25000", "Trendy couch"},
            {"Vintage Couch", "Rs 30000", "Classic style"},
            {"L-shaped Couch", "Rs 35000", "Spacious couch"}
        };

        JMenuItem sofasItem = new JMenuItem("Sofas");
        sofasItem.addActionListener(e -> Ecommerce.showItemsPage("Sofas", sofas));

        JMenuItem tablesItem = new JMenuItem("Tables");
        tablesItem.addActionListener(e -> Ecommerce.showItemsPage("Tables", tables));

        JMenuItem chairsItem = new JMenuItem("Chairs");
        chairsItem.addActionListener(e -> Ecommerce.showItemsPage("Chairs", chairs));

        JMenuItem bedsItem = new JMenuItem("Beds");
        bedsItem.addActionListener(e -> Ecommerce.showItemsPage("Beds", beds));

        JMenuItem couchesItem = new JMenuItem("Couches");
        couchesItem.addActionListener(e -> Ecommerce.showItemsPage("Couches", couches));

        furnitureMenu.add(sofasItem);
        furnitureMenu.add(tablesItem);
        furnitureMenu.add(chairsItem);
        furnitureMenu.add(bedsItem);
        furnitureMenu.add(couchesItem);

        return furnitureMenu;
    }

    private JMenu createClothingMenu() {
        JMenu clothingMenu = new JMenu("Clothing");

        String[][] women = {
            {"Saree", "Rs 2000", "Traditional Indian saree"},
            {"Kurti", "Rs 800", "Cotton Kurti"},
            {"Jeans", "Rs 1500", "Blue denim jeans"},
            {"Top", "Rs 1000", "Trendy top"},
            {"Dress", "Rs 2500", "Party wear dress"}
        };

        String[][] men = {
            {"Shirt", "Rs 1200", "Formal shirt"},
            {"T-Shirt", "Rs 800", "Casual t-shirt"},
            {"Jeans", "Rs 2000", "Slim fit jeans"},
            {"Suit", "Rs 5000", "Business suit"},
            {"Kurta", "Rs 1500", "Traditional kurta"}
        };

        String[][] kids = {
            {"Kids Frock", "Rs 1000", "Beautiful frock"},
            {"Kids Shirt", "Rs 600", "Cotton shirt"},
            {"Kids Shorts", "Rs 500", "Casual shorts"},
            {"Kids Jeans", "Rs 800", "Denim jeans"},
            {"Kids Kurta", "Rs 900", "Traditional kurta"}
        };

        String[][] girls = {
            {"Skirt", "Rs 700", "Stylish skirt"},
            {"Leggings", "Rs 500", "Comfort leggings"},
            {"Top", "Rs 800", "Trendy top"},
            {"Frock", "Rs 1200", "Party wear frock"},
            {"Jumpsuit", "Rs 1500", "Modern jumpsuit"}
        };

        String[][] boys = {
            {"Shirt", "Rs 1000", "Checked shirt"},
            {"T-Shirt", "Rs 600", "Sports t-shirt"},
            {"Jeans", "Rs 1200", "Casual jeans"},
            {"Shorts", "Rs 700", "Cotton shorts"},
            {"Blazer", "Rs 3000", "Formal blazer"}
        };

        JMenuItem womenItem = new JMenuItem("Women");
        womenItem.addActionListener(e -> Ecommerce.showItemsPage("Women", women));

        JMenuItem menItem = new JMenuItem("Men");
        menItem.addActionListener(e -> Ecommerce.showItemsPage("Men", men));

        JMenuItem kidsItem = new JMenuItem("Kids");
        kidsItem.addActionListener(e -> Ecommerce.showItemsPage("Kids", kids));

        JMenuItem girlsItem = new JMenuItem("Girls");
        girlsItem.addActionListener(e -> Ecommerce.showItemsPage("Girls", girls));

        JMenuItem boysItem = new JMenuItem("Boys");
        boysItem.addActionListener(e -> Ecommerce.showItemsPage("Boys", boys));

        clothingMenu.add(womenItem);
        clothingMenu.add(menItem);
        clothingMenu.add(kidsItem);
        clothingMenu.add(girlsItem);
        clothingMenu.add(boysItem);

        return clothingMenu;
    }

    private JMenu createGroceriesMenu() {
        JMenu groceriesMenu = new JMenu("Grocery");

        String[][] fruits = {
            {"Apple", "Rs 200", "Fresh apples"},
            {"Banana", "Rs 50", "Yellow bananas"},
            {"Orange", "Rs 80", "Sweet oranges"},
            {"Mango", "Rs 120", "Seasonal mangoes"},
            {"Grapes", "Rs 90", "Green grapes"}
        };

        String[][] vegetables = {
            {"Potato", "Rs 40", "Fresh potatoes"},
            {"Tomato", "Rs 30", "Red tomatoes"},
            {"Onion", "Rs 50", "Farm onions"},
            {"Carrot", "Rs 60", "Orange carrots"},
            {"Spinach", "Rs 25", "Green spinach"}
        };

        String[][] dairy = {
            {"Milk", "Rs 50", "1 litre packet"},
            {"Curd", "Rs 40", "Fresh curd"},
            {"Cheese", "Rs 150", "Cheddar cheese"},
            {"Butter", "Rs 120", "Amul butter"},
            {"Paneer", "Rs 200", "Fresh paneer"}
        };

        String[][] rice = {
            {"Basmati Rice", "Rs 100", "Premium rice"},
            {"Brown Rice", "Rs 80", "Healthy rice"},
            {"Sona Masoori", "Rs 90", "Daily use rice"},
            {"Jasmine Rice", "Rs 150", "Aromatic rice"},
            {"Parboiled Rice", "Rs 70", "Boiled rice"}
        };

        String[][] snacks = {
            {"Chips", "Rs 20", "Potato chips"},
            {"Biscuits", "Rs 30", "Sweet biscuits"},
            {"Namkeen", "Rs 50", "Spicy mixture"},
            {"Chocolate", "Rs 100", "Milk chocolate"},
            {"Popcorn", "Rs 40", "Salted popcorn"}
        };

        JMenuItem fruitsItem = new JMenuItem("Fruits");
        fruitsItem.addActionListener(e -> Ecommerce.showItemsPage("Fruits", fruits));

        JMenuItem vegetablesItem = new JMenuItem("Vegetables");
        vegetablesItem.addActionListener(e -> Ecommerce.showItemsPage("Vegetables", vegetables));

        JMenuItem dairyItem = new JMenuItem("Dairy Products");
        dairyItem.addActionListener(e -> Ecommerce.showItemsPage("Dairy Products", dairy));

        JMenuItem riceItem = new JMenuItem("Rice");
        riceItem.addActionListener(e -> Ecommerce.showItemsPage("Rice", rice));

        JMenuItem snacksItem = new JMenuItem("Snacks");
        snacksItem.addActionListener(e -> Ecommerce.showItemsPage("Snacks", snacks));

        groceriesMenu.add(fruitsItem);
        groceriesMenu.add(vegetablesItem);
        groceriesMenu.add(dairyItem);
        groceriesMenu.add(riceItem);
        groceriesMenu.add(snacksItem);

        return groceriesMenu;
    }
}
