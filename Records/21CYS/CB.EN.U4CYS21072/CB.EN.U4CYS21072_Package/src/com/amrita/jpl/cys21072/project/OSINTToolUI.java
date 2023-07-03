package com.amrita.jpl.cys21072.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OSINTToolUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OSINT Tool");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JButton homeButton = new JButton("Home");
        JButton aboutButton = new JButton("About");
        JButton contactButton = new JButton("Contact");
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        topPanel.add(homeButton);
        topPanel.add(aboutButton);
        topPanel.add(contactButton);
        topPanel.add(loginButton);
        topPanel.add(signupButton);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        JLabel searchLabel = new JLabel("Search Details:");

        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Email", "Social Media Platform", "Phone Call"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);

        JLabel socialMediaLabel = new JLabel("Social Media:");
        String[] socialMediaOptions = {"Instagram", "Facebook", "Twitter", "Reddit"};
        JComboBox<String> socialMediaComboBox = new JComboBox<>(socialMediaOptions);
        socialMediaComboBox.setEnabled(false);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailTextField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField(20);

        JLabel searchWebLabel = new JLabel("Search Web:");
        JCheckBox searchWebCheckBox = new JCheckBox();

        JLabel traceIPLabel = new JLabel("Trace IP address:");
        JCheckBox traceIPCheckBox = new JCheckBox();

        JLabel enterIPLabel = new JLabel("Enter IP:");
        JTextField ipTextField = new JTextField(20);
        ipTextField.setEnabled(false);

        JLabel searchIndustryLabel = new JLabel("Search for industry:");
        JCheckBox searchIndustryCheckBox = new JCheckBox();

        JLabel enterDomainLabel = new JLabel("Enter possible domain:");
        JTextField domainTextField = new JTextField(20);
        domainTextField.setEnabled(false);

        JButton searchButton = new JButton("Search");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        centerPanel.add(searchLabel, gbc);

        gbc.gridy = 1;
        centerPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(typeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(socialMediaLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(socialMediaComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(usernameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(emailTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        centerPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(phoneTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        centerPanel.add(searchWebLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(searchWebCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        centerPanel.add(traceIPLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(traceIPCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        centerPanel.add(enterIPLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(ipTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        centerPanel.add(searchIndustryLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(searchIndustryCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        centerPanel.add(enterDomainLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(domainTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(searchButton, gbc);

        frame.add(centerPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog loginDialog = new JDialog(frame, "Login", true);
                loginDialog.setSize(300, 200);
                loginDialog.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameTextField = new JTextField(20);

                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameTextField = new JTextField(20);

                JLabel passwordLabel = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField(20);

                JButton loginDialogButton = new JButton("Log in");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);

                loginDialog.add(nameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(nameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.fill = GridBagConstraints.NONE;
                loginDialog.add(usernameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(usernameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.NONE;
                loginDialog.add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                loginDialog.add(loginDialogButton, gbc);

                loginDialog.setLocationRelativeTo(frame);
                loginDialogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(loginDialog, "Login Successful");
                        loginDialog.dispose();
                    }
                });

                loginDialog.setVisible(true);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog signupDialog = new JDialog(frame, "Sign Up", true);
                signupDialog.setSize(400, 350);
                signupDialog.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameTextField = new JTextField(20);

                JLabel ageLabel = new JLabel("Age:");
                JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));

                JLabel designationLabel = new JLabel("Designation:");
                String[] designations = {"Worker", "Student"};
                JComboBox<String> designationComboBox = new JComboBox<>(designations);

                JLabel phoneNumberLabel = new JLabel("Phone Number:");
                JTextField phoneNumberTextField = new JTextField(20);

                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameTextField = new JTextField(20);

                JLabel passwordLabel = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField(20);

                JLabel retypePasswordLabel = new JLabel("Retype Password:");
                JPasswordField retypePasswordField = new JPasswordField(20);

                JButton signupDialogButton = new JButton("Sign up");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);

                signupDialog.add(nameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(nameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(ageLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(ageSpinner, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(designationLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(designationComboBox, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(phoneNumberLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(phoneNumberTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(usernameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(usernameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 6;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(retypePasswordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(retypePasswordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 7;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                signupDialog.add(signupDialogButton, gbc);

                signupDialogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(signupDialog, "Successfully Signed Up!");
                        signupDialog.dispose();
                    }
                });

                signupDialog.setLocationRelativeTo(frame);
                signupDialog.setVisible(true);
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog contactDialog = new JDialog(frame, "Contact", true);
                contactDialog.setSize(300, 200);
                contactDialog.setLayout(new BorderLayout());

                JLabel contactLabel = new JLabel("<html>For further details, contact<br>XX, this is a dummy address,<br>for example purpose, PINXXX<br>email: 123example@gmail.com<br>phone: +91XXXXXXXXXX</html>");
                contactLabel.setHorizontalAlignment(JLabel.CENTER);

                contactDialog.add(contactLabel, BorderLayout.CENTER);
                contactDialog.setLocationRelativeTo(frame);
                contactDialog.setVisible(true);
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog aboutDialog = new JDialog(frame, "About", true);
                aboutDialog.setSize(300, 150);
                aboutDialog.setLayout(new BorderLayout());

                JLabel aboutLabel = new JLabel("<html>This is a simple Java based user interface for an OSINT tool model<br>Authors:<br>Aishwarya GS<br>Kishanth K<br>Sri Sai Tanvi Sonti</html>");
                aboutLabel.setHorizontalAlignment(JLabel.CENTER);

                aboutDialog.add(aboutLabel, BorderLayout.CENTER);
                aboutDialog.setLocationRelativeTo(frame);
                aboutDialog.setVisible(true);
            }
        });

        typeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typeComboBox.getSelectedItem();
                socialMediaComboBox.setEnabled(selectedType.equals("Social Media Platform"));
                emailTextField.setEnabled(selectedType.equals("Email"));
                usernameTextField.setEnabled(selectedType.equals("Social Media Platform") || selectedType.equals("Phone Call"));
                phoneTextField.setEnabled(selectedType.equals("Phone Call"));
            }
        });

        traceIPCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ipTextField.setEnabled(traceIPCheckBox.isSelected());
            }
        });

        searchIndustryCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                domainTextField.setEnabled(searchIndustryCheckBox.isSelected());
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform search based on the selected options
            }
        });

        frame.setVisible(true);
    }
}