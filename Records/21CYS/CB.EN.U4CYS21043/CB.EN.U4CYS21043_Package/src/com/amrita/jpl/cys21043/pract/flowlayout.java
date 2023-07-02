package com.amrita.jpl.cys21043.pract;


import javax.swing.*;
import java.awt.*;


public class flowlayout extends JFrame {

    public flowlayout() {
        setTitle("FlowLayout Example");
        //setSize(600, 80);
        setSize(40, 220);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel(" Full Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("Rate");


        // Buttons
        JButton button1 = new JButton("Jasir");
        JButton button2 = new JButton("CB.EN.U4CYS21043");
        JButton button3 = new JButton("4");
        JButton button4 = new JButton("Submit");

        // Add components to the content pane
        add(label1);
        add(button1);
        add(label2);
        add(button2);
        add(label3);
        add(button3);
        add(button4);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new flowlayout();
    }
}

