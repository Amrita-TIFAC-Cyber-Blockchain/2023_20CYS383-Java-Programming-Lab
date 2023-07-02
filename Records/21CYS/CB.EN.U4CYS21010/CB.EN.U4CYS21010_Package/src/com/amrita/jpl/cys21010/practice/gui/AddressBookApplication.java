package com.amrita.jpl.cys21010.practice.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressBookApplication extends JFrame {
    private List<Contact> contacts;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    public AddressBookApplication() {
        super("Address Book");
        contacts = new ArrayList<>();

        initializeUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        // Create the table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");
        table = new JTable(tableModel);

        // Create the buttons
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // Create the form fields
        nameField = new JTextField(10);
        phoneNumberField = new JTextField(10);
        emailField = new JTextField(10);

        // Create the labels for the form fields
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");

        // Create the main panel and set the layout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the top panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Create the left panel to hold the table
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create the right panel to hold the form
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumberField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        // Add the components to the main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.WEST);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Add event listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        // Add event listener to the table selection
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                displayContact(selectedRow);
            }
        });
    }

    private void addContact() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();

        if (validateFields(name, phoneNumber, email)) {
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);
            tableModel.addRow(new Object[]{name, phoneNumber, email});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter valid data for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();

            if (validateFields(name, phoneNumber, email)) {
                Contact contact = contacts.get(selectedRow);
                contact.setName(name);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(phoneNumber, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valid data for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            contacts.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayContact(int selectedRow) {
        Contact contact = contacts.get(selectedRow);
        nameField.setText(contact.getName());
        phoneNumberField.setText(contact.getPhoneNumber());
        emailField.setText(contact.getEmail());
    }

    private void clearFields() {
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        table.clearSelection();
    }

    private boolean validateFields(String name, String phoneNumber, String email) {
        return !name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return true;
    }

    private boolean isValidEmail(String email) {
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddressBookApplication();
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

    // Getters and setters
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
