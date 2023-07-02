package com.amrita.jpl.cys21006.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 *
 * @author Alooysius Vitalian J
 * @version 0.5
 */
public class FlowLayoutExample extends JFrame {

    /**
     * Constructs the FlowLayoutExample window.
     */
    public FlowLayoutExample() {
        setTitle("FlowLayout Example");
        //setSize(600, 80);
        setSize(220, 920);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel(" Full Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("Date Of Birth");
        JLabel label4 = new JLabel("College Name");
        JLabel label5 = new JLabel("Phone Number");
        JLabel label6 = new JLabel("Department");
        JLabel label7 = new JLabel("Email");
        JLabel label8 = new JLabel("Accommodation needed");


        // Buttons
        JButton button1 = new JButton("Alooysius Vitalian J");
        JButton button2 = new JButton("CB.EN.U4CYS21006");
        JButton button3 = new JButton("28/06/03");
        JButton button4 = new JButton("Amrita Vishwa Vidyapeetham");
        JButton button5 = new JButton("7358972660");
        JButton button6 = new JButton("CSE - CYS");
        JButton button7 = new JButton("vitalianfernando@gmail.com");
        JButton button8 = new JButton("Yes");
        JButton button9 = new JButton("Submit");

        // Add components to the content pane
        add(label1);
        add(button1);
        add(label2);
        add(button2);
        add(label3);
        add(button3);
        add(label4);
        add(button4);
        add(label5);
        add(button5);
        add(label6);
        add(button6);
        add(label7);
        add(button7);
        add(label8);
        add(button8);

        add(button9);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
