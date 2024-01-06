package com.amrita.jpl.cys21027.exercise;


/**

 * AddressBookApplication is a Java Swing-based application that allows users to manage a simple address book.
 * It provides functionalities to add, edit, and delete contacts, including their name, phone number, and email.
 * @author: K Sri Sai Nitin
 * @version: 1.0

 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressBookApplication extends JFrame {
    // Instance variables
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    private List<Contact> contacts;

    /**
     * Constructs the AddressBookApplication object.
     * Initializes the GUI components and sets up event listeners.
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

        // Add button ActionListener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showContactDialog(null);
            }
        });

        // Edit button ActionListener
        editButton.addActionListener(new ActionListener() {
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

        // Delete button ActionListener
        deleteButton.addActionListener(new ActionListener() {
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
     * Displays the contact dialog for adding or editing a contact.
     * @param contact The contact object to be edited. Null for adding a new contact.
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
     * Refreshes the table with the updated contact list.
     */
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.getName(), contact.getPhoneNumber(), contact.getEmail()});
        }
    }

    /**
     * Checks if a phone number is valid.
     * @param phone The phone number to validate.
     * @return True if the phone number is valid, false otherwise.
     */
    private boolean isValidPhoneNumber(String phone) {
        // Implement your phone number validation logic here
        return true;
    }

    /**
     * Checks if an email address is valid.
     * @param email The email address to validate.
     * @return True if the email address is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        return true;
    }

    /**
     * The main entry point of the application.
     * @param args The command-line arguments.
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

 Contact class represents a contact with a name, phone number, and email.
 */
class Contact {
    // Instance variables
    private String name;
    private String phoneNumber;
    private String email;

    /**

     Constructs a Contact object with the specified name, phone number, and email.
     @param name The name of the contact.
     @param phoneNumber The phone number of the contact.
     @param email The email address of the contact.
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
// Getters and setters

    /**

     Gets the name of the contact.
     @return The name of the contact.
     */
    public String getName() {
        return name;
    }
    /**

     Sets the name of the contact.
     @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**

     Gets the phone number of the contact.
     @return The phone number of the contact.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**

     Sets the phone number of the contact.
     @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**

     Gets the email address of the contact.
     @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }
    /**

     Sets the email address of the contact.
     @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}