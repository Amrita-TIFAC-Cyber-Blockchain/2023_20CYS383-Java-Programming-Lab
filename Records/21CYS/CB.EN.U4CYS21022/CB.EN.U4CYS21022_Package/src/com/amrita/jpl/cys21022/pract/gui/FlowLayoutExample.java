package com.amrita.jpl.cys21022.pract.gui;


import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class FlowLayoutExample extends JFrame {

    /**
     * Constructs the FlowLayoutExample window.
     */
    public FlowLayoutExample() {

        JFrame frame = new JFrame("Feedback Form");
        frame.setLayout(new FlowLayout());

        // Create JLabels for each input field
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel rollNoLabel = new JLabel("Roll No:");
        JLabel subjectLabel = new JLabel("Subject:");
        JLabel mentorLabel = new JLabel("Mentor:");
        JLabel messageLabel = new JLabel("Message:");

        // Create JTextFields for each input field
        JTextField nameField = new JTextField(20);
        JTextField rollNoField = new JTextField(20);
        JTextField subjectField = new JTextField(20);
        JTextField mentorField = new JTextField(20);
        JTextField messageField = new JTextField(20);

        // Create a JButton for submit
        JButton submitButton = new JButton("Submit");

        // Add all the components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollNoLabel);
        frame.add(rollNoField);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(mentorLabel);
        frame.add(mentorField);
        frame.add(messageLabel);
        frame.add(messageField);
        frame.add(submitButton);

        // Set the size and visibility of the frame
        frame.setSize(200, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


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

