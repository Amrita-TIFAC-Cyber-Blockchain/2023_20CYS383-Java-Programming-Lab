package com.amrita.jpl.cys21008.Ex.Addressbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A class representing an Address Book application user interface.
 * @Author:Anuvarshini M K
 */
public class AddressBookApplication extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    private List<Contact> contacts;

    /**
     * Constructs a new AddressBookApplication object.
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
             * ActionListener implementation for the Add button.
             */
            public void actionPerformed(ActionEvent e) {
                showContactDialog(null);
            }
        });

        editButton.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for the Edit button.
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
             * ActionListener implementation for the Delete button.
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
             * ActionListener implementation for the Save button.
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

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.getName(), contact.getPhoneNumber(), contact.getEmail()});
        }
    }

    private boolean isValidPhoneNumber(String phone) {
        // Implement your phone number validation logic here
        return true;
    }

    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * The entry point of the AddressBookApplication program.
             */
            public void run() {
                AddressBookApplication addressBook = new AddressBookApplication();
                addressBook.setVisible(true);
            }
        });
    }
}

/**
 * A class representing a contact with a name, phone number, and email.
 */
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a new Contact object with the specified name, phone number, and email.
     *
     * @param name        the name of the contact
     * @param phoneNumber the phone number of the contact
     * @param email       the email address of the contact
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Retrieves the name of the contact.
     *
     * @return the name of the contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the contact.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the contact.
     *
     * @return the phone number of the contact
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the email address of the contact.
     *
     * @return the email address of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the contact.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}




