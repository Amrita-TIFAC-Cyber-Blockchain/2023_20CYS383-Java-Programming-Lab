package com.amrita.jpl.cys21087.pract.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class U21CYSAddressBook extends JFrame {

    private JTable contactTable;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private JButton addButton;
    private JButton deleteButton;

    public U21CYSAddressBook() {
        setTitle("21CYS Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);

        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        buttonPanel.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        buttonPanel.add(deleteButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        Container container = getContentPane();
        container.add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    private boolean isValidPhoneNumber(String phone) {
        // Perform validation logic for phone number (e.g., length, format, etc.)
        if (phone.length() != 10) {
            return false; // Phone number should be 10 digits long
        }
        // Add more validation checks if needed
        return true;
    }

    private boolean isValidEmail(String email) {
        // Perform validation logic for email (e.g., format, etc.)
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private void clearFormFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this, "Invalid phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this, "Invalid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Object[] rowData = {name, phone, email};
            tableModel.addRow(rowData);
            clearFormFields();
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this, "Please select a contact to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmDialogResult = JOptionPane.showConfirmDialog(U21CYSAddressBook.this, "Are you sure you want to delete this contact?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirmDialogResult == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new U21CYSAddressBook().setVisible(true);
            }
        });
    }
}
