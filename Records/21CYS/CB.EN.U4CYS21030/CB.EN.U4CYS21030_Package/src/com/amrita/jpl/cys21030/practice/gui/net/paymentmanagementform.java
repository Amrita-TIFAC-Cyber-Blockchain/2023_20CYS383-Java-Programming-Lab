package com.amrita.jpl.cys21030.practice.gui.net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paymentmanagementform extends JFrame implements ActionListener {
    private JTextField nameTextField, amountTextField;
    private JButton submitButton, clearButton;

    public paymentmanagementform() {
        // Set frame properties
        setTitle("Payment Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField(10);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // Add action listeners
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Create panel and add components
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(amountLabel);
        panel.add(amountTextField);
        panel.add(submitButton);
        panel.add(clearButton);

        // Add panel to the frame
        getContentPane().add(panel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new paymentmanagementform();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameTextField.getText();
            String amount = amountTextField.getText();

            // Perform further actions with the name and amount, such as saving to a database or performing calculations

            // Show a confirmation message
            JOptionPane.showMessageDialog(this, "Payment submitted successfully!");

            // Clear the text fields
            nameTextField.setText("");
            amountTextField.setText("");
        } else if (e.getSource() == clearButton) {
            // Clear the text fields
            nameTextField.setText("");
            amountTextField.setText("");
        }
    }
}

