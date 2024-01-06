package com.amrita.jpl.cys21073.practice;


import javax.swing.*;
import java.awt.*;


public class borderlayout extends JFrame {


    public borderlayout() {
        setTitle("BorderLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the BorderLayout as the layout manager for the frame
        setLayout(new BorderLayout());

        // Create and add components to the content pane

        // Header Label at the top (North) of the window
        JLabel headerLabel = new JLabel("Welcome to Java Programming Lab", JLabel.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Content TextArea in the center of the window
        JTextArea contentTextArea = new JTextArea();
        add(contentTextArea, BorderLayout.CENTER);

        // Submit Button at the bottom (South) of the window
        JButton submitButton = new JButton("Submit Feedback");
        add(submitButton, BorderLayout.SOUTH);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new borderlayout();
    }
}