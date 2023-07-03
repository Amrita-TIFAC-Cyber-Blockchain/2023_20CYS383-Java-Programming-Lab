package com.amrita.jpl.cys21080.practice.gui.swing.apps;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * The HelloWorldGUI class represents a simple GUI application that displays "Hello World" in a JFrame window.
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
class HelloWorldGUI {
    /**
     * The main method is the entry point of the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame();

        // Set the size of the JFrame
        frame.setSize(300, 300);

        // Set the default close operation to exit the application when the JFrame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the title of the JFrame
        frame.setTitle("My First GUI in Java");

        // Create a new JLabel
        JLabel label = new JLabel();

        // Set the text of the label to "Hello World"
        label.setText("Hello World");

        // Set the foreground color of the label to white
        label.setForeground(Color.WHITE);

        // Set the horizontal alignment of the label to center
        label.setHorizontalAlignment(JLabel.CENTER);

        // Set the vertical alignment of the label to center
        label.setVerticalAlignment(JLabel.CENTER);

        // Set the background color of the label to a custom color
        label.setBackground(new Color(0x123456));

        // Enable opaque mode for the label to make the background color visible
        label.setOpaque(true);

        // Add the label to the JFrame
        frame.add(label);

        // Disable frame resizing
        frame.setResizable(false);

        // Make the JFrame visible
        frame.setVisible(true);
    }
}