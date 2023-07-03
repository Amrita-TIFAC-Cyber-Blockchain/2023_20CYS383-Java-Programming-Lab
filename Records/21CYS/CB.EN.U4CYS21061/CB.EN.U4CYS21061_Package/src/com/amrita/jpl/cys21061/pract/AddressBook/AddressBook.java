package com.amrita.jpl.cys21061.pract.AddressBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressBook extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable contactTable;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();

        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        // Create table model with columns: Name, Phone Number, Email
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");

        // Create contact table with the table model
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Create buttons
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Create form fields
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();

        // Create panel for form fields
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Phone Number:"));
        formPanel.add(phoneField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddressBook::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addContact();
        } else if (e.getSource() == editButton) {
            editContact();
        } else if (e.getSource() == deleteButton) {
            deleteContact();
        }
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        if (isValidContact(name, phone, email)) {
            Contact contact = new Contact(name, phone, email);
            contacts.add(contact);

            tableModel.addRow(new Object[]{name, phone, email});

            clearFormFields();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid contact details! Please enter valid information.");
        }
    }

    private void editContact() {
        int selectedRow = contactTable.getSelectedRow();

        if (selectedRow != -1) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (isValidContact(name, phone, email)) {
                Contact contact = contacts.get(selectedRow);
                contact.setName(name);
                contact.setPhoneNumber(phone);
                contact.setEmail(email);

                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(phone, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);

                clearFormFields();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid contact details! Please enter valid information.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No contact selected! Please select a contact to edit.");
        }
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();

        if (selectedRow != -1) {
            contacts.remove(selectedRow);
            tableModel.removeRow(selectedRow);

            clearFormFields();
        } else {
            JOptionPane.showMessageDialog(this, "No contact selected! Please select a contact to delete.");
        }
    }

    private void clearFormFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    private boolean isValidContact(String name, String phone, String email) {
        return !name.isEmpty() && isValidPhoneNumber(phone) && isValidEmail(email);
    }

    private boolean isValidPhoneNumber(String phone) {
        // Perform phone number validation logic
        // For simplicity, we assume any non-empty phone number is valid
        return !phone.isEmpty();
    }

    private boolean isValidEmail(String email) {
        // Perform email validation logic
        // For simplicity, we assume any non-empty email is valid
        return !email.isEmpty();
    }
}
