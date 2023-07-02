package com.amrita.jpl.cys21022.pract.addressbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Contact> contacts;
    private JTextField nameField; // Declare nameField as an instance variable
    private JTextField phoneNumberField; // Declare phoneNumberField as an instance variable
    private JTextField emailField; // Declare emailField as an instance variable

    public AddressBook() {
        contacts = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Address Book");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);


        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String email = emailField.getText().trim();

                if (!name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
                    Contact contact = new Contact(name, phoneNumber, email);
                    contacts.add(contact);
                    tableModel.addRow(contact.toObjectArray());
                    clearInputFields();
                } else {
                    showErrorMessage("Invalid input. Please check the fields and try again.");
                }
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
                    showErrorMessage("Please select a contact to edit.");
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
                    showErrorMessage("Please select a contact to delete.");
                }
            }
        });
        buttonPanel.add(deleteButton);

        // Create the table with columns
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private void clearInputFields() {
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

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
                showErrorMessage("Invalid input. Please check the fields and try again.");
            }
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberRegex = "\\d{10}";
        return phoneNumber.matches(phoneNumberRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

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

    public Object[] toObjectArray() {
        return new Object[]{name, phoneNumber, email};
    }
}

