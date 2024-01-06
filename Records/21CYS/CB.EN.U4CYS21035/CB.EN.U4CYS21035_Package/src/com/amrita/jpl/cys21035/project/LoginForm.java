package com.amrita.jpl.cys21035.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @Author:Copyright © 2022-2023 Amrita Parcel Management System, Gokulachselvan C D, V.M.Sushmanth, M C Vivek Veera, II B.Tech CSE (CYS)
 */

/**
 * The LoginForm class represents a login page for the APMS application.
 * It allows users to enter their username and password to log in.
 */
public class LoginForm extends JFrame {

    private JLabel usernameLabel, passwordLabel, forgotPasswordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;

    /**
     * Creates a new instance of the LoginForm class.
     * Sets up the GUI components and handles the login functionality.
     */
    public LoginForm() {
        super("APMS Login Page");

        // Initialize GUI components
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        usernameTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);
        loginButton = new JButton("Login");
        forgotPasswordLabel = new JLabel("<html><u>Forgot Password?</u></html>");
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.setForeground(Color.BLUE);

        JPanel contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPane.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        contentPane.add(usernameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        contentPane.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        contentPane.add(passwordTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.PAGE_END;
        contentPane.add(loginButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.PAGE_START;
        contentPane.add(forgotPasswordLabel, constraints);

        add(contentPane);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());

                if (username.equals("admin") && password.equals("admin@123")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose(); // Close the login form
                    new APMS(true).setVisible(true); // Show the main program
                } else if (username.equals("student") && password.equals("welcome")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose(); // Close the login form
                    new APMS(false).setVisible(true); // Show the main program
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Close the login form
                new ForgotPasswordForm();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The main method creates a new instance of the LoginForm class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LoginForm();
    }
}