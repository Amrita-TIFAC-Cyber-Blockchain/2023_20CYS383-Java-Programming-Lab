package com.amrita.jpl.cys21027.practice.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of FlowLayout in Java Swing.
 * It creates a simple GUI window with components arranged using FlowLayout.
 *
 * @author K Sri Sai Nitin
 * @version 0.5
 */
public class form extends JFrame {
    /**
     * Constructs the FlowLayoutExample window.
     */
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel rollNoLabel;
    private JTextField rollNoField;
    private JLabel genderLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private JLabel eventsLabel;
    private JTextField eventsField;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberField;
    private JLabel ageLabel;
    private JTextField ageField;
    private JLabel dobLabel;
    private JTextField dobField;
    private JLabel workshopsLabel;
    private JTextField workshopsField;
    private JLabel competitionsLabel;
    private JTextField competitionsField;
    private JButton submitButton;

    public form() {
        setTitle("Anokha Techfest Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        // Create components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        rollNoLabel = new JLabel("Roll No:");
        rollNoField = new JTextField(20);
        genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        eventsLabel = new JLabel("Events:");
        eventsField = new JTextField(20);
        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(20);
        ageLabel = new JLabel("Age:");
        ageField = new JTextField(20);
        dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField(20);
        workshopsLabel = new JLabel("Workshops:");
        workshopsField = new JTextField(20);
        competitionsLabel = new JLabel("Competitions:");
        competitionsField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(rollNoLabel);
        add(rollNoField);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(eventsLabel);
        add(eventsField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(ageLabel);
        add(ageField);
        add(dobLabel);
        add(dobField);
        add(workshopsLabel);
        add(workshopsField);
        add(competitionsLabel);
        add(competitionsField);
        add(submitButton);

        // Set frame properties
        //setSize(600, 80);
        setSize(450, 320);
        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        /**
         * Main method to launch the application.
         *
         * @param args command-line arguments (unused)
         */

        SwingUtilities.invokeLater(() -> new form());
    }
}
