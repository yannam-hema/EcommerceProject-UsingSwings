package com.info.SwingsProject;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

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

        electronicsMenu.add(new JMenuItem("Mobiles"));
        electronicsMenu.add(new JMenuItem("Laptop"));
        electronicsMenu.add(new JMenuItem("Camera"));
        electronicsMenu.add(new JMenuItem("Head Phones"));
        electronicsMenu.add(new JMenuItem("Mouse"));

        return electronicsMenu;
    }

    private JMenu createFurnitureMenu() {
        JMenu furnitureMenu = new JMenu("Furniture");

        furnitureMenu.add(new JMenuItem("Sofa"));
        furnitureMenu.add(new JMenuItem("Table"));
        furnitureMenu.add(new JMenuItem("Chair"));
        furnitureMenu.add(new JMenuItem("Bed"));
        furnitureMenu.add(new JMenuItem("Couch"));

        return furnitureMenu;
    }

    private JMenu createClothingMenu() {
        JMenu clothingMenu = new JMenu("Clothing");

        clothingMenu.add(new JMenuItem("Women"));
        clothingMenu.add(new JMenuItem("Men"));
        clothingMenu.add(new JMenuItem("Kids"));
        clothingMenu.add(new JMenuItem("Girls"));
        clothingMenu.add(new JMenuItem("Boys"));

        return clothingMenu;
    }

    private JMenu createGroceriesMenu() {
        JMenu groceriesMenu = new JMenu("Grocery");

        groceriesMenu.add(new JMenuItem("Fruits"));
        groceriesMenu.add(new JMenuItem("Vegetables"));
        groceriesMenu.add(new JMenuItem("Dairy Products"));
        groceriesMenu.add(new JMenuItem("Rice"));
        groceriesMenu.add(new JMenuItem("Snacks"));

        return groceriesMenu;
    }
}
