package com.amrita.jpl.cys21026.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class RegistrationPage {
    private JPanel panel;
    private JTextField nameTextField;
    private JTextField voterIdTextField;
    private JTextField ageTextField;

    private Set<String> registeredVoters;

    public RegistrationPage() {
        panel = new JPanel(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();
        JLabel voterIdLabel = new JLabel("Voter ID:");
        voterIdTextField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageTextField = new JTextField();
        JButton registerButton = new JButton("Register");

        registeredVoters = new HashSet<>();

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(voterIdLabel);
        panel.add(voterIdTextField);
        panel.add(ageLabel);
        panel.add(ageTextField);
        panel.add(new JLabel());
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String voterId = voterIdTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());

                // Check age and uniqueness of voter ID
                if (age < 18) {
                    JOptionPane.showMessageDialog(panel, "You must be at least 18 years old to register.");
                } else if (registeredVoters.contains(name)) {
                    JOptionPane.showMessageDialog(panel, "User already voted.");
                } else {
                    // Perform registration
                    registeredVoters.add(name);

                    // Redirect to voting page
                    JOptionPane.showMessageDialog(panel, "Registration successful! You can now proceed to vote.");
                    new VotingPage();
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
