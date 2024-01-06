package com.amrita.jpl.cys21055.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoterRegistrationUI extends JFrame {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel ageLabel;
    private JTextField ageTextField;
    private JButton registerButton;
    private JLabel footerLabel;

    public VoterRegistrationUI() {
        setTitle("Voter Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        ageLabel = new JLabel("Age:");
        ageTextField = new JTextField();

        registerButton = new JButton("Register");

        formPanel.add(nameLabel);
        formPanel.add(nameTextField);
        formPanel.add(ageLabel);
        formPanel.add(ageTextField);
        formPanel.add(new JLabel());
        formPanel.add(registerButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        footerLabel = new JLabel("© 2023 Your Voting System. All rights reserved.");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        footerPanel.add(footerLabel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // ActionListener for Register Button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());

                // Perform voter registration and verification logic here
                if (age >= 18) {
                    JOptionPane.showMessageDialog(VoterRegistrationUI.this, "Registration successful! You are eligible to vote.");
                } else {
                    JOptionPane.showMessageDialog(VoterRegistrationUI.this, "Registration unsuccessful! You must be at least 18 years old to vote.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VoterRegistrationUI();
            }
        });
    }
}
