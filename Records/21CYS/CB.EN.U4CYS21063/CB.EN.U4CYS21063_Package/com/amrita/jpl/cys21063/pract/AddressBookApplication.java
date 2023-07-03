package com.amrita.jpl.cys21063.pract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddressBookApplication extends JFrame {
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    private List<Contact> contacts;

    public AddressBookApplication() {
        contacts = new ArrayList<>();

        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel(new BorderLayout());

        // Create the table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Create the buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddContactDialog();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    Contact selectedContact = contacts.get(selectedRow);
                    showEditContactDialog(selectedContact);
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this,
                            "Please select a contact to edit.",
                            "Edit Contact",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    contacts.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this,
                            "Please select a contact to delete.",
                            "Delete Contact",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the main frame
        add(panel);
    }

    private void showAddContactDialog() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        int result = JOptionPane.showConfirmDialog(AddressBookApplication.this, panel,
                "Add Contact", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();

            if (validateContactData(name, phoneNumber, email)) {
                Contact contact = new Contact(name, phoneNumber, email);
                contacts.add(contact);
                tableModel.addRow(contact.toArray());
            } else {
                JOptionPane.showMessageDialog(AddressBookApplication.this,
                        "Invalid contact data. Please enter valid information.",
                        "Add Contact",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showEditContactDialog(Contact contact) {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField(contact.getName());
        panel.add(nameField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField(contact.getPhoneNumber());
        panel.add(phoneNumberField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(contact.getEmail());
        panel.add(emailField);

        int result = JOptionPane.showConfirmDialog(AddressBookApplication.this, panel,
                "Edit Contact", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();

            if (validateContactData(name, phoneNumber, email)) {
                contact.setName(name);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);

                int selectedRow = contactTable.getSelectedRow();
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(phoneNumber, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(AddressBookApplication.this,
                        "Invalid contact data. Please enter valid information.",
                        "Edit Contact",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateContactData(String name, String phoneNumber, String email) {
        if (name.isEmpty()) {
            return false;
        }

        if (!Pattern.matches("\\d{10}", phoneNumber)) {
            return false;
        }

        if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email)) {
            return false;
        }

        return true;
    }

    private class Contact {
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

        public Object[] toArray() {
            return new Object[]{name, phoneNumber, email};
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddressBookApplication();
            }
        });
    }
}
