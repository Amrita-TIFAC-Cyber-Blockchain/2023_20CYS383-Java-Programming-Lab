package com.amrita.jpl.cys21062.ex;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressBookApplication extends JFrame {
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private List<Contact> contacts;

    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    public AddressBookApplication() {
        contacts = new ArrayList<>();

        setTitle("21CYS Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        createTable();
        createForm();
        createButtons();

        setVisible(true);
    }

    private void createTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");

        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void createForm() {
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");

        nameField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumberField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        getContentPane().add(formPanel, BorderLayout.NORTH);
    }

    private void createButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addContact() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();

        if (validateInput(name, phoneNumber, email)) {
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);
            tableModel.addRow(new Object[]{name, phoneNumber, email});
            clearForm();
        }
    }

    private void editContact() {
        int selectedRow = contactTable.getSelectedRow();

        if (selectedRow >= 0) {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();

            if (validateInput(name, phoneNumber, email)) {
                Contact contact = contacts.get(selectedRow);
                contact.setName(name);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(phoneNumber, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
                clearForm();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to edit.");
        }
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();

        if (selectedRow >= 0) {
            contacts.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to delete.");
        }
    }

    private boolean validateInput(String name, String phoneNumber, String email) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name.");
            return false;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number.");
            return false;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            return false;
        }

        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Add your phone number validation logic here
        // For example, you can use regular expressions to check the format
        return true;
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        // For example, you can use regular expressions to check the format
        return true;
    }

    private void clearForm() {
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
    }

    private static class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddressBookApplication();
            }
        });
    }
}
