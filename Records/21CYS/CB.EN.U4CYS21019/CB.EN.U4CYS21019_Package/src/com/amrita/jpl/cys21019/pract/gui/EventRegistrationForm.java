package com.amrita.jpl.cys21019.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 * The window contains a student sign-up form for college event registration.
 *
 * @author Gokulachselvan C D
 * @version 0.5
 */
public class EventRegistrationForm extends JFrame {

    /**
     * Constructs the EventRegistrationForm window.
     */
    public EventRegistrationForm() {
        setTitle("Event Registration Form");
        setSize(800, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create and add components to the content pane

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel eventLabel = new JLabel("Event:");
        JLabel emergencyContactLabel = new JLabel("Emergency Contact Name:");
        JLabel emergencyPhoneLabel = new JLabel("Emergency Contact Phone:");
        JLabel bloodGroupLabel = new JLabel("Blood Group:");

        // Text fields
        JTextField nameField = new JTextField(20);
        JTextField rollNumberField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField eventField = new JTextField(20);
        JTextField emergencyContactField = new JTextField(20);
        JTextField emergencyPhoneField = new JTextField(20);
        JTextField bloodGroupField = new JTextField(20);

        // Button
        JButton signUpButton = new JButton("Sign Up");

        // Add components to the content pane
        add(nameLabel);
        add(nameField);
        add(rollNumberLabel);
        add(rollNumberField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(eventLabel);
        add(eventField);
        add(emergencyContactLabel);
        add(emergencyContactField);
        add(emergencyPhoneLabel);
        add(emergencyPhoneField);
        add(bloodGroupLabel);
        add(bloodGroupField);
        add(signUpButton);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Filetransfer method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new EventRegistrationForm();
    }
}
