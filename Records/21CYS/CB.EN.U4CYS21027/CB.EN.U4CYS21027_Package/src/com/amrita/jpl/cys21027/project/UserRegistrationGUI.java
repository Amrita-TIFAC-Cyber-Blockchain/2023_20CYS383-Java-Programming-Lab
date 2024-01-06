package com.amrita.jpl.cys21027.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationGUI extends JFrame {
    private JTextField nameField, voterIdField, ageField;

    public UserRegistrationGUI() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel voterIdLabel = new JLabel("Voter ID:");
        voterIdField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String voterId = voterIdField.getText();
                int age = Integer.parseInt(ageField.getText());

                if (age < 18) {
                    JOptionPane.showMessageDialog(null, "You must be 18 or older to register.");
                } else if (isVoterIdAlreadyRegistered(voterId)) {
                    JOptionPane.showMessageDialog(null, "Voter ID already registered.");
                } else {

                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(voterIdLabel);
        panel.add(voterIdField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(new JLabel());
        panel.add(registerButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    private boolean isVoterIdAlreadyRegistered(String voterId) {
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserRegistrationGUI();
            }
        });
    }
}
