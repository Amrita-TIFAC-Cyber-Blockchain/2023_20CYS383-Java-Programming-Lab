package com.amrita.jpl.cys21035.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParcelManagementSystemGUI extends JFrame {

    private JPanel loginPanel;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel statusLabel;
    private JTextField statusTextField;
    private JLabel otpLabel;
    private JTextField otpTextField;
    private JButton pickupButton;
    private JButton loginButton;
    private JTable recordsTable;
    private DefaultTableModel tableModel;

    public ParcelManagementSystemGUI() {
        setTitle("Amrita Parcel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        createLoginPanel();
        createMainPanel();

        add(loginPanel);
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameTextField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel());
        inputPanel.add(loginButton);

        loginPanel.add(inputPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(loginPanel);
                add(mainPanel);
                revalidate();
                repaint();
            }
        });
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tracking Number");
        tableModel.addColumn("Delivery Status");
        tableModel.addColumn("Recipient Name");
        recordsTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(recordsTable);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Welcome to Amrita Parcel Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel = new JLabel("Recipient Name:");
        nameTextField = new JTextField(20);
        statusLabel = new JLabel("Parcel Status:");
        statusTextField = new JTextField(20);
        otpLabel = new JLabel("OTP:");
        otpTextField = new JTextField(10);
        pickupButton = new JButton("Pickup Parcel");

        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(statusLabel);
        inputPanel.add(statusTextField);
        inputPanel.add(otpLabel);
        inputPanel.add(otpTextField);
        inputPanel.add(new JLabel());
        inputPanel.add(pickupButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        pickupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String status = statusTextField.getText();
                String otp = otpTextField.getText();

                updateDeliveryStatus(name, status, otp);
            }
        });
    }

    private void updateDeliveryStatus(String name, String status, String otp) {
        System.out.println("Recipient Name: " + name);
        System.out.println("Delivery Status: " + status);
        System.out.println("OTP: " + otp);

        String trackingNumber = "12345";
        String deliveryStatus = status;
        String recipientName = name;
        Object[] record = {trackingNumber, deliveryStatus, recipientName};
        tableModel.addRow(record);

        nameTextField.setText("");
        statusTextField.setText("");
        otpTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ParcelManagementSystemGUI().setVisible(true);
            }
        });
    }
}

