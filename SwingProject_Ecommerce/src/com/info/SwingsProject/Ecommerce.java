package com.info.SwingsProject;

import javax.swing.*;
import java.awt.event.*;   // for ActionListener
import java.awt.*;

public class Ecommerce {

    public static void main(String[] args) {
        
        //creating a Main Frame with a title 
        JFrame frame= new JFrame("Welcome to yannam's online Shopping Website");
        //the size of a frame
        frame.setSize(1500,1500);
        
        ImageIcon ic = new ImageIcon("C:\\Users\\yanna\\Downloads\\EcommerceProjectImage1.png");
        JLabel jl_mainImg = new JLabel(ic);
        frame.add(jl_mainImg);
        
        //Making Frame Visible
        frame.setVisible(true);
        
        //To close Frame when user Click on Cross Button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set Menu Bar
        frame.setJMenuBar(new MenuBuilder().createMainMenu());
    }
}
