package com.amrita.jpl.cys21042.project;

/**
 * @Author : Mittul R
 * @Version : 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

class SecureVotingSystem extends JFrame implements ActionListener {
    JLabel titleLabel, ageLabel, voterIdLabel, fullNameLabel, contactNumberLabel, genderLabel, cityLabel, partyLabel;
    JTextField ageTextField, voterIdTextField, fullNameTextField, contactNumberTextField;
    JRadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    JComboBox<String> cityComboBox;
    JButton submitButton;
    Set<Integer> voterIds = new HashSet<>();
    ImageIcon party1Icon = new ImageIcon("party1.jpg");
    ImageIcon party2Icon = new ImageIcon("party2.jpg");
    ImageIcon party3Icon = new ImageIcon("party3.jpg");

    JRadioButton party1RadioButton;
    JRadioButton party2RadioButton;
    JRadioButton party3RadioButton;
    JLabel party1Label;
    JLabel party2Label;
    JLabel party3Label;
    ButtonGroup partyButtonGroup;

    public SecureVotingSystem() {
        setTitle("Secure Voting System");
        setSize(600, 500);
        setLayout(null);

        titleLabel = new JLabel("Secure E - Voting System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(180, 10, 250, 40);
        add(titleLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(50, 60, 100, 20);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(200, 60, 150, 20);
        add(ageTextField);

        voterIdLabel = new JLabel("Voter ID");
        voterIdLabel.setBounds(50, 100, 150, 20);
        add(voterIdLabel);

        voterIdTextField = new JTextField();
        voterIdTextField.setBounds(200, 100, 150, 20);
        add(voterIdTextField);

        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setBounds(50, 140, 100, 20);
        add(fullNameLabel);

        fullNameTextField = new JTextField();
        fullNameTextField.setBounds(200, 140, 150, 20);
        add(fullNameTextField);

        contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setBounds(50, 180, 100, 20);
        add(contactNumberLabel);

        contactNumberTextField = new JTextField();
        contactNumberTextField.setBounds(200, 180, 150, 20);
        add(contactNumberTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 220, 60, 20);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 220, 60, 20);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280, 220, 80, 20);
        add(femaleRadioButton);

        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBounds(370, 220, 80, 20);
        add(otherRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        cityLabel = new JLabel("City");
        cityLabel.setBounds(50, 260, 100, 20);
        add(cityLabel);

        String[] cities = {"Delhi", "Bangalore", "Mumbai", "Hyderabad", "Kolkata", "Chennai", "Pune"};
        cityComboBox = new JComboBox<>(cities);
        cityComboBox.setBounds(200, 260, 150, 20);
        add(cityComboBox);

        partyLabel = new JLabel("Select Party");
        partyLabel.setBounds(50, 300, 100, 20);
        add(partyLabel);

        party1Label = new JLabel(party1Icon);
        party1Label.setBounds(180, 300, 100, 100);
        add(party1Label);

        party2Label = new JLabel(party2Icon);
        party2Label.setBounds(300, 300, 100, 100);
        add(party2Label);

        party3Label = new JLabel(party3Icon);
        party3Label.setBounds(420, 300, 100, 100);
        add(party3Label);

        party1RadioButton = new JRadioButton("Party 1");
        party1RadioButton.setBounds(200, 400, 100, 20);
        add(party1RadioButton);

        party2RadioButton = new JRadioButton("Party 2");
        party2RadioButton.setBounds(300, 400, 100, 20);
        add(party2RadioButton);

        party3RadioButton = new JRadioButton("Party 3");
        party3RadioButton.setBounds(400, 400, 100, 20);
        add(party3RadioButton);

        partyButtonGroup = new ButtonGroup();
        partyButtonGroup.add(party1RadioButton);
        partyButtonGroup.add(party2RadioButton);
        partyButtonGroup.add(party3RadioButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 450, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String ageText = ageTextField.getText();
        String voterIdText = voterIdTextField.getText();
        String fullName = fullNameTextField.getText();
        String contactNumber = contactNumberTextField.getText();
        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        }
        String city = (String) cityComboBox.getSelectedItem();

        ImageIcon selectedPartyIcon = null;
        String selectedParty = "";
        if (party1RadioButton.isSelected()) {
            selectedPartyIcon = party1Icon;
            selectedParty = "Party 1";
        } else if (party2RadioButton.isSelected()) {
            selectedPartyIcon = party2Icon;
            selectedParty = "Party 2";
        } else if (party3RadioButton.isSelected()) {
            selectedPartyIcon = party3Icon;
            selectedParty = "Party 3";
        }

        if (ageText.isEmpty() || voterIdText.isEmpty() || fullName.isEmpty() || contactNumber.isEmpty() || gender.isEmpty() || city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
        } else {
            int age = Integer.parseInt(ageText);
            int voterId = Integer.parseInt(voterIdText);

            if (age < 18) {
                JOptionPane.showMessageDialog(this, "Age below 18. Not eligible to vote.", "Age Restriction", JOptionPane.ERROR_MESSAGE);
            } else {
                if (voterIds.contains(voterId)) {
                    JOptionPane.showMessageDialog(this, "This voter ID is already registered. Please enter a unique voter ID.", "Duplicate Voter ID", JOptionPane.ERROR_MESSAGE);
                } else {
                    voterIds.add(voterId);
                    JOptionPane.showMessageDialog(this, "Thank you for your vote! The party you voted for is " + selectedParty + ".");
                }
            }
            // Clear the text fields
            ageTextField.setText("");
            voterIdTextField.setText("");
            fullNameTextField.setText("");
            contactNumberTextField.setText("");

            // Clear the radio buttons
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);

            // Clear the combo box selection
            cityComboBox.setSelectedIndex(0);

            // Clear the party selection
            partyButtonGroup.clearSelection();
        }
    }

    public static void main(String[] args) {
        new SecureVotingSystem();
}
}
