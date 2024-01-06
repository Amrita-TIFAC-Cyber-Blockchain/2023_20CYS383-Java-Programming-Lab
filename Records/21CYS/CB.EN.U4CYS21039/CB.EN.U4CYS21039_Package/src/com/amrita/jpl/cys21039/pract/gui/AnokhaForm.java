package com.amrita.jpl.cys21039.pract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 * The window represents an Anokha Techfest Form.
 *
 * @author Manbendra Satpathy
 * @version 1.0
 */
public class AnokhaForm extends JFrame {

    // Fields
    private JTextField nameField;
    private JTextField classField;
    private JTextField rollNumberField;
    private JTextArea eventsArea;
    private JTextArea competitionsArea;
    private JTextField phoneNumberField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;

    /**
     * Constructs the Anokha Techfest Form window.
     */
    public AnokhaForm() {
        setTitle("Anokha Techfest Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Create a form panel with GridLayout
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Create and add components to the form panel

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel classLabel = new JLabel("Class:");
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        JLabel eventsLabel = new JLabel("Events:");
        JLabel competitionsLabel = new JLabel("Competitions:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel genderLabel = new JLabel("Gender:");

        // Text Fields
        nameField = new JTextField();
        classField = new JTextField();
        rollNumberField = new JTextField();
        phoneNumberField = new JTextField();

        // Text Areas
        eventsArea = new JTextArea();
        competitionsArea = new JTextArea();

        // Radio Buttons for Gender
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        otherRadioButton = new JRadioButton("Other");

        // Button Group for Radio Buttons
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions on submit button click
                String name = nameField.getText();
                String className = classField.getText();
                String rollNumber = rollNumberField.getText();
                String events = eventsArea.getText();
                String competitions = competitionsArea.getText();
                String phoneNumber = phoneNumberField.getText();
                String gender = "";

                // Determine selected gender
                if (maleRadioButton.isSelected()) {
                    gender = "Male";
                } else if (femaleRadioButton.isSelected()) {
                    gender = "Female";
                } else if (otherRadioButton.isSelected()) {
                    gender = "Other";
                }

                // Print the form data
                System.out.println("Name: " + name);
                System.out.println("Class: " + className);
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Events: " + events);
                System.out.println("Competitions: " + competitions);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Gender: " + gender);
            }
        });

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(classLabel);
        formPanel.add(classField);
        formPanel.add(rollNumberLabel);
        formPanel.add(rollNumberField);
        formPanel.add(eventsLabel);
        formPanel.add(eventsArea);
        formPanel.add(competitionsLabel);
        formPanel.add(competitionsArea);
        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumberField);
        formPanel.add(genderLabel);

        JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioButtonPanel.add(maleRadioButton);
        radioButtonPanel.add(femaleRadioButton);
        radioButtonPanel.add(otherRadioButton);
        formPanel.add(radioButtonPanel);

        // Create a panel for the submit button and center it
        JPanel submitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitButtonPanel.add(submitButton);
        mainPanel.add(submitButtonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {

        new AnokhaForm();
    }
}
