package com.amrita.jpl.cys21069.practice.assignments;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The AddressBook class represents a simple address book application.
 * It allows users to add, edit, and delete contacts with name, phone number, and email information.
 */
class AddressBook
{
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Contact> contacts;

    /**
     * Initializes the address book application.
     */
    public AddressBook() {
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

        // Create the table with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create buttons
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
     * Displays the dialog to add a new contact.
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

            if (!name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
                Contact contact = new Contact(name, phoneNumber, email);
                contacts.add(contact);
                tableModel.addRow(new Object[]{name, phoneNumber, email});
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please check the fields and try again.");
            }
        }
    }

    /**
     * Displays the dialog to edit an existing contact.
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

            if (!name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
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
     * Validates the phone number.
     * You can implement your phone number validation logic here.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement your phone number validation logic here
        return true;
    }

    /**
     * Validates the email address.
     * You can implement your email validation logic here.
     */
    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        return true;
    }

    /**
     * The main entry point of the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddressBook();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

/**
 * The Contact class represents a contact with name, phone number, and email information.
 */
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Creates a new instance of the Contact class.
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
     * Returns the email address of the contact.
     *
     * @return the email address of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the contact.
     *
     * @param email the email address of the contact
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
