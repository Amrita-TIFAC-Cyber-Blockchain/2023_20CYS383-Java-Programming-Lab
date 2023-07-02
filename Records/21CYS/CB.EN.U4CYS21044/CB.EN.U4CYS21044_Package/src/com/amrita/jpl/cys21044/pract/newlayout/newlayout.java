package com.amrita.jpl.cys21044.pract.newlayout;
import javax.swing.*;
import java.awt.*;

public class newlayout extends JFrame {

    public newlayout() {
        setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Anokha 2023", JLabel.CENTER);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.YELLOW); // Highlighting header with yellow background
        add(headerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(11, 2, 10, 10)); // Adjusted gap between components to improve spacing

        // Create and add form elements
        centerPanel.add(new JLabel("Name:"));
        centerPanel.add(new JTextField(20)); // Reduced size of text field

        centerPanel.add(new JLabel("Email:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("Address:"));
        centerPanel.add(new JTextArea(4, 20)); // Reduced size of text area

        centerPanel.add(new JLabel("Phone:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("City:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("State:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("Country:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("Username:"));
        centerPanel.add(new JTextField(20));

        centerPanel.add(new JLabel("Password:"));
        centerPanel.add(new JPasswordField(20));

        centerPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 2));
        genderPanel.add(new JRadioButton("Male"));
        genderPanel.add(new JRadioButton("Female"));
        centerPanel.add(genderPanel);

        add(centerPanel, BorderLayout.CENTER);


        // Set JFrame properties
        setTitle("Form Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JButton submitButton = new JButton("Submit");



        add(submitButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        new newlayout();
    }
}
