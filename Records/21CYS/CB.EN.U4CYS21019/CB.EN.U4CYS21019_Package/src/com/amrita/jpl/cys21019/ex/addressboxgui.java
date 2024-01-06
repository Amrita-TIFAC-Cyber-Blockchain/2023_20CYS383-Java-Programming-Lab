package com.amrita.jpl.cys21019.ex;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Address Book Application GUI.
 * Allows users to manage contacts by adding, editing, and deleting them.
 * Author: Gokulachselvan C D
 */
public class addressboxgui {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Contact> contacts;

    /**
     * Initializes the AddressBookApplication by setting up the GUI.
     */
    public addressboxgui() {
        contacts = new ArrayList<>();
        initialize();
    }

    /**
     * Initializes the GUI components and sets up the main frame.
     */
    private void initialize() {
        frame = new JFrame("Address Book");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddContactDialog();
            }
        });
        buttonPanel.add(addButton);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Contact contact = contacts.get(selectedRow);
                    showEditContactDialog(contact);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a contact to edit.");
                }
            }
        });
        buttonPanel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    contacts.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a contact to delete.");
                }
            }
        });
        buttonPanel.add(deleteButton);

        frame.setVisible(true);
    }

    /**
     * Displays the dialog for adding a new contact.
     * Collects the input from the user and adds the contact to the address book.
     */
    private void showAddContactDialog() {
        JTextField nameField = new JTextField();
        JTextField phoneNumberField = new JTextField();
        JTextField emailField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Contact", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String phoneNumber = phoneNumberField.getText().trim();
            String email = emailField.getText().trim();

            if (validateFields(name, phoneNumber, email)) {
                Contact contact = new Contact(name, phoneNumber, email);
                contacts.add(contact);
                tableModel.addRow(new Object[]{name, phoneNumber, email});
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please check the fields and try again.");
            }
        }
    }

    /**
     * Displays the dialog for editing an existing contact.
     * Collects the input from the user and updates the contact in the address book.
     */
    private void showEditContactDialog(Contact contact) {
        JTextField nameField = new JTextField(contact.getName());
        JTextField phoneNumberField = new JTextField(contact.getPhoneNumber());
        JTextField emailField = new JTextField(contact.getEmail());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Edit Contact", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String phoneNumber = phoneNumberField.getText().trim();
            String email = emailField.getText().trim();

            if (validateFields(name, phoneNumber, email)) {
                contact.setName(name);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                int row = contacts.indexOf(contact);
                tableModel.setValueAt(name, row, 0);
                tableModel.setValueAt(phoneNumber, row, 1);
                tableModel.setValueAt(email, row, 2);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please check the fields and try again.");
            }
        }
    }

    /**
     * Validates the name, phone number, and email fields.
     * Displays an error message if any of the fields are invalid.
     * @param name The name of the contact.
     * @param phoneNumber The phone number of the contact.
     * @param email The email address of the contact.
     * @return true if all fields are valid, false otherwise.
     */
    private boolean validateFields(String name, String phoneNumber, String email) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty.");
            return false;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(frame, "Invalid phone number.");
            return false;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(frame, "Invalid email.");
            return false;
        }

        return true;
    }

    /**
     * Checks if the given phone number is valid.
     * Placeholder method - actual validation logic should be implemented.
     * @param phoneNumber The phone number to validate.
     * @return true if the phone number is valid, false otherwise.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement your phone number validation logic here
        return true;
    }

    /**
     * Checks if the given email address is valid.
     * Placeholder method - actual validation logic should be implemented.
     * @param email The email address to validate.
     * @return true if the email address is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        return true;
    }

    /**
     * Entry point of the application.
     * Creates a new instance of AddressBookApplication.
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addressboxgui();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

/**
 * Represents a contact with a name, phone number, and email address.
 */
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Creates a new instance of Contact with the given name, phone number, and email address.
     * @param name The name of the contact.
     * @param phoneNumber The phone number of the contact.
     * @param email The email address of the contact.
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Gets the name of the contact.
     * @return The name of the contact.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the contact.
     * @param name The new name of the contact.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the contact.
     * @return The phone number of the contact.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the contact.
     * @param phoneNumber The new phone number of the contact.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address of the contact.
     * @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the contact.
     * @param email The new email address of the contact.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
