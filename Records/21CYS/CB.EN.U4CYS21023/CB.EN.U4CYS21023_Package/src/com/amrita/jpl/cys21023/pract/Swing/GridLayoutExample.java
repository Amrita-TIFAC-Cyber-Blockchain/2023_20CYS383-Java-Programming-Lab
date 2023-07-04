package com.amrita.jpl.cys21023.pract.Swing;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    public GridLayoutExample() {

        JFrame frame = new JFrame("Feedback Form");
        frame.setLayout(new GridLayout(8, 2)); // Adjusted grid layout to accommodate the additional components

        // Create JLabels for each input field
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel rollNoLabel = new JLabel("Roll No:");
        JLabel subjectLabel = new JLabel("Subject:");
        JLabel mentorLabel = new JLabel("Mentor:");
        JLabel messageLabel = new JLabel("Message:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel countryLabel = new JLabel("Country:");

        // Create JTextFields for each input field
        JTextField nameField = new JTextField(20);
        JTextField rollNoField = new JTextField(20);
        JTextField subjectField = new JTextField(20);
        JTextField mentorField = new JTextField(20);
        JTextField messageField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        // Create a JButton for submit
        JButton submitButton = new JButton("Submit");

        // Create a group of radio buttons for gender selection
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Create a checkbox for terms and conditions agreement
        JCheckBox agreeCheckBox = new JCheckBox("Agree to Terms and Conditions");

        // Create a text area for comments
        JTextArea commentsTextArea = new JTextArea(5, 20);
        JScrollPane commentsScrollPane = new JScrollPane(commentsTextArea);

        // Create a dropdown menu for country selection
        JComboBox<String> countryComboBox = new JComboBox<>();
        DefaultComboBoxModel<String> countryModel = new DefaultComboBoxModel<>();
        countryModel.addElement("USA");
        countryModel.addElement("Canada");
        countryModel.addElement("UK");
        countryModel.addElement("Australia");
        countryComboBox.setModel(countryModel);

        // Add all the components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollNoLabel);
        frame.add(rollNoField);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(mentorLabel);
        frame.add(mentorField);
        frame.add(messageLabel);
        frame.add(messageField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(genderLabel);
        frame.add(maleRadioButton);
        frame.add(new JLabel("")); // Empty label for layout consistency
        frame.add(femaleRadioButton);
        frame.add(countryLabel);
        frame.add(countryComboBox);
        frame.add(new JLabel("")); // Empty label for layout consistency
        frame.add(agreeCheckBox);
        frame.add(new JLabel("")); // Empty label for layout consistency
        frame.add(commentsScrollPane);
        frame.add(submitButton);

        // Set the size and visibility of the frame
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
