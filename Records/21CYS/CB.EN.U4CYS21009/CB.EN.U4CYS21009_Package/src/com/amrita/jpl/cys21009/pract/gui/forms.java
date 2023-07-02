package com.amrita.jpl.cys21009.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 *
 * @author Aravind
 * @version 1
 */
public class forms extends JFrame {

    /**
     * Constructs the FlowLayoutExample window.
     */
    public forms() {
        setTitle("RBAC FORM");
        //setSize(600, 80);
        setSize(200, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        /**
         * @param q1 Label 1
         * @param q2 Label 2
         * @param q3 Label 3
         */

        // Labels
        JLabel q1 = new JLabel("Name: ");
        JLabel q2 = new JLabel("Unique ID: ");
        JLabel q3 = new JLabel("Role: ");

        /**
         * @param TextArea1 Text Area 1
         * @param TextArea2 Text Area 2
         * @param TextArea3 Text Area 3
         * @param button Submit Button
         */

        // Text Area
        JTextArea TextArea1 = new JTextArea(1,10);
        JTextArea TextArea2 = new JTextArea(1,10);
        JTextArea TextArea3 = new JTextArea(1,10);

        // Submit Button
        JButton button = new JButton("Submit");

        // Add components to the content pane
        add(q1);
        add(TextArea1);
        add(q2);
        add(TextArea2);
        add(q3);
        add(TextArea3);
        add(button);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new forms();
    }
}
