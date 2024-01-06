package com.amrita.jpl.cys21054.exercise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple address book application that allows users to add, edit, and delete contacts.
 */
public class AddressBookApplication extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    private List<Contact> contacts;

    /**
     * Constructs an AddressBookApplication object.
     */
    public AddressBookApplication() {
        contacts = new ArrayList<>();

        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the add button is clicked.
             * Shows the contact dialog for adding a new contact.
             *
             * @param e the action event
             */
            public void actionPerformed(ActionEvent e) {
                showContactDialog(null);
            }
        });

        editButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the edit button is clicked.
             * Shows the contact dialog for editing the selected contact.
             *
             * @param e the action event
             */
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Contact selectedContact = contacts.get(selectedRow);
                    showContactDialog(selectedContact);
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this, "Please select a contact to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the delete button is clicked.
             * Deletes the selected contact from the address book.
             *
             * @param e the action event
             */
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    contacts.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(AddressBookApplication.this, "Please select a contact to delete.");
                }
            }
        });
    }

    /**
     * Shows the contact dialog for adding or editing a contact.
     *
     * @param contact the contact to edit (null if adding a new contact)
     */
    private void showContactDialog(Contact contact) {
        JDialog dialog = new JDialog(this, "Contact Details", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        if (contact != null) {
            nameField.setText(contact.getName());
            phoneField.setText(contact.getPhoneNumber());
            emailField.setText(contact.getEmail());
        }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the save button is clicked.
             * Saves the contact details and updates the address book.
             *
             * @param e the action event
             */
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Name cannot be empty.");
                } else if (!isValidPhoneNumber(phone)) {
                    JOptionPane.showMessageDialog(dialog, "Invalid phone number.");
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(dialog, "Invalid email.");
                } else {
                    if (contact != null) {
                        contact.setName(name);
                        contact.setPhoneNumber(phone);
                        contact.setEmail(email);
                        refreshTable();
                    } else {
                        Contact newContact = new Contact(name, phone, email);
                        contacts.add(newContact);
                        tableModel.addRow(new Object[]{name, phone, email});
                    }
                    dialog.dispose();
                }
            }
        });

        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(phoneLabel);
        dialog.add(phoneField);
        dialog.add(emailLabel);
        dialog.add(emailField);
        dialog.add(new JLabel());
        dialog.add(saveButton);

        dialog.setVisible(true);
    }

    /**
     * Refreshes the table by updating the displayed contact data.
     */
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.getName(), contact.getPhoneNumber(), contact.getEmail()});
        }
    }

    /**
     * Checks if a phone number is valid.
     * (Implement your phone number validation logic here)
     *
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    private boolean isValidPhoneNumber(String phone) {
        // Implement your phone number validation logic here
        return true;
    }

    /**
     * Checks if an email address is valid.
     * (Implement your email validation logic here)
     *
     * @param email the email address to validate
     * @return true if the email address is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        return true;
    }

    /**
     * The entry point of the address book application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddressBookApplication addressBook = new AddressBookApplication();
                addressBook.setVisible(true);
            }
        });
    }
}

/**
 * Represents a contact in the address book.
 */
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a Contact object with the specified name, phone number, and email.
     *
     * @param name        the name of the contact
     * @param phoneNumber the phone number of the contact
     * @param email       the email of the contact
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Returns the name of the contact.
     *
     * @return the name of the contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the contact.
     *
     * @param name the name of the contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return the phone number of the contact
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phoneNumber the phone number of the contact
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email of the contact.
     *
     * @return the email of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the contact.
     *
     * @param email the email of the contact
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
