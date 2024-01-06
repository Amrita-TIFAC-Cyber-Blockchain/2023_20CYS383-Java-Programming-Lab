package com.amrita.jpl.cys21003.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 *
 * @author Aishwarya G
 * @version 1.0
 */
public class form extends JFrame {

    /**
     * Constructs the FlowLayoutExample window.
     */
    public form() {
        setTitle("FlowLayout Example");
        //setSize(600, 80);
        setSize(40, 220);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel(" Full Name:");
        JLabel label2 = new JLabel("Roll Number:");
        JLabel label3 = new JLabel("Course:");
        JLabel label4 = new JLabel("Father name:");
        JLabel label5 = new JLabel("Mother name:");
        JLabel label6 = new JLabel("City:");



        // Buttons
        JButton button1 = new JButton("Aishwarya G");
        JButton button2 = new JButton("CB.EN.U4CYS21003");
        JButton button3 = new JButton("B-TECH CYS");
        JButton button4 = new JButton("Govindasamy N");
        JButton button5 = new JButton("Balamani G");
        JButton button6 = new JButton("Namakkal");
        JButton button7 = new JButton("Submit");

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
        add(button7);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new form();
    }
}

