package com.amrita.jpl.cys21019.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @Author:Copyright © 2022-2023 Amrita Parcel Management System, Gokulachselvan C D, V.M.Sushmanth, M C Vivek Veera, II B.Tech CSE (CYS)
 */

/**
 * The ForgotPasswordForm class represents a form for resetting the password.
 * It allows users to enter their email, new password, and confirm password to reset the password.
 */
public class ForgotPasswordForm extends JFrame {

    private JLabel emailLabel, passwordLabel, confirmPasswordLabel;
    private JTextField emailTextField;
    private JPasswordField passwordTextField, confirmPasswordTextField;
    private JButton submitButton, backButton;

    /**
     * Creates a new instance of the ForgotPasswordForm class.
     * Sets up the GUI components and handles the password reset functionality.
     */
    public ForgotPasswordForm() {
        super("Forgot Password Form");

        // Initialize GUI components
        emailLabel = new JLabel("Email");
        passwordLabel = new JLabel("New Password");
        confirmPasswordLabel = new JLabel("Confirm Password");
        emailTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);
        confirmPasswordTextField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        backButton = new JButton("Back");

        JPanel contentPane = new JPanel(new GridLayout(0, 2, 10, 10));
        contentPane.add(emailLabel);
        contentPane.add(emailTextField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordTextField);
        contentPane.add(confirmPasswordLabel);
        contentPane.add(confirmPasswordTextField);
        contentPane.add(submitButton);
        contentPane.add(backButton);

        add(contentPane);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = new String(passwordTextField.getPassword());
                String confirmPassword = new String(confirmPasswordTextField.getPassword());

                // Validate password and confirm password
                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
                    return;
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Password updated! Go back to the login page");
                    dispose(); // Close the forgot password form
                    new LoginForm();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the forgot password form
                new LoginForm();
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The main method creates a new instance of the ForgotPasswordForm class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ForgotPasswordForm();
    }
}
