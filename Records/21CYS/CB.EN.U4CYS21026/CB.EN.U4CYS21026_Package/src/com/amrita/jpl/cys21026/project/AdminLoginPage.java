package com.amrita.jpl.cys21026.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage {
    private JPanel panel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public AdminLoginPage() {
        panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Check admin credentials
                if (isAdminCredentialsValid(username, password)) {
                    // Redirect to create ballot page
                    new CreateBallotPage();
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid admin credentials!");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private boolean isAdminCredentialsValid(String username, String password) {
        // Check if admin credentials are valid
        // Return true if valid, false otherwise
        return username.equals("admin") && password.equals("password");
    }
}
