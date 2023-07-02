package com.amrita.jpl.cys21017.pract.addressBookApp;
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
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    private List<Contact> contacts;

    public AddressBookApplication() {
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        contacts = new ArrayList<>();

        // Initialize the table
        String[] columnNames = {"Name", "Phone Number", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(contactTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Initialize the buttons
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add button click listener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showContactDialog(null);
            }
        });

        // Edit button click listener
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    Contact selectedContact = contacts.get(selectedRow);
                    showContactDialog(selectedContact);
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this, "Please select a contact to edit.",
                            "Edit Contact", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Delete button click listener
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    int confirmResult = JOptionPane.showConfirmDialog(AddressBookApplication.this,
                            "Are you sure you want to delete this contact?", "Delete Contact",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmResult == JOptionPane.YES_OPTION) {
                        contacts.remove(selectedRow);
                        tableModel.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this, "Please select a contact to delete.",
                            "Delete Contact", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void showContactDialog(Contact contact) {
        JDialog dialog = new JDialog(this, "Contact Details", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");
        nameField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();

        if (contact != null) {
            nameField.setText(contact.getName());
            phoneNumberField.setText(contact.getPhoneNumber());
            emailField.setText(contact.getEmail());
        }

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumberField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String email = emailField.getText();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Please enter a name.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidPhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(dialog, "Please enter a valid phone number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(dialog, "Please enter a valid email address.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (contact == null) {
                    Contact newContact = new Contact(name, phoneNumber, email);
                    contacts.add(newContact);
                    tableModel.addRow(new String[]{name, phoneNumber, email});
                } else {
                    contact.setName(name);
                    contact.setPhoneNumber(phoneNumber);
                    contact.setEmail(email);
                    int selectedRow = contactTable.getSelectedRow();
                    tableModel.setValueAt(name, selectedRow, 0);
                    tableModel.setValueAt(phoneNumber, selectedRow, 1);
                    tableModel.setValueAt(email, selectedRow, 2);
                }

                dialog.dispose();
            }
        });

        dialog.add(formPanel, BorderLayout.CENTER);
        dialog.add(saveButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement your own validation logic for phone numbers
        // This is just a basic example
        return phoneNumber.matches("\\d{10}");
    }

    private boolean isValidEmail(String email) {
        // Implement your own validation logic for email addresses
        // This is just a basic example
        return email.matches("\\w+@\\w+\\.\\w+");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddressBookApplication addressBook = new AddressBookApplication();
                addressBook.setVisible(true);
            }
        });
    }
}

class Contact {
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

