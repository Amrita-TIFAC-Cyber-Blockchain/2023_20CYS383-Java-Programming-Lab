package com.amrita.jpl.cys21080.practice.gui;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * The RegistrationForm class represents a simple registration form GUI.
 * It creates a JFrame with various input fields and a register button.
 * This class demonstrates the use of Swing components to create a graphical user interface.
 *
 * Usage:
 * - Create an instance of the RegistrationForm class to display the registration form GUI.
 * - Users can enter their name, email, password, and other fields.
 * - Clicking the register button triggers an action (implementation not shown).
 *
 * Note: This is a basic example and does not handle advanced validation or form submission.
 *
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
public class RegistrationForm extends JFrame {

    /**
     * Constructs a RegistrationForm object and initializes the GUI components.
     */
    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(0, 2)); // Automatic rows, 2 columns

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();

        JLabel field5Label = new JLabel("Field 5:");
        JTextField field5Field = new JTextField();

        JLabel field6Label = new JLabel("Field 6:");
        JTextField field6Field = new JTextField();

        JLabel field7Label = new JLabel("Field 7:");
        JTextField field7Field = new JTextField();

        JLabel field8Label = new JLabel("Field 8:");
        JTextField field8Field = new JTextField();

        JLabel field9Label = new JLabel("Field 9:");
        JTextField field9Field = new JTextField();

        JLabel field10Label = new JLabel("Field 10:");
        JTextField field10Field = new JTextField();

        JButton registerButton = new JButton("Register");

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(field5Label);
        add(field5Field);
        add(field6Label);
        add(field6Field);
        add(field7Label);
        add(field7Field);
        add(field8Label);
        add(field8Field);
        add(field9Label);
        add(field9Field);
        add(field10Label);
        add(field10Field);
        add(new JLabel()); // Empty label for spacing
        add(registerButton);

        pack();
        setVisible(true);
    }

    /**
     * The main method is the entry point of the program.
     * It creates an instance of the RegistrationForm class to display the registration form GUI.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new RegistrationForm();
    }
}
