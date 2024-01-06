package com.amrita.jpl.cys21007.ex;
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
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    
    private List<Contact> contacts;
    
    public AddressBookApplication() {
        contacts = new ArrayList<>();
        
        setTitle("Address Book");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        createComponents();
        addComponentsToFrame();
    }
    
    private void createComponents() {
        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Email");
        contactTable = new JTable(tableModel);
        
        // Buttons
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        
        // Form fields
        nameField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        emailField = new JTextField(20);
        
        // Button listeners
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
    }
    
    private void addComponentsToFrame() {
        // Main layout
        setLayout(new BorderLayout());
        
        // Create a panel for the form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Phone Number:"));
        formPanel.add(phoneNumberField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        
        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        // Add the table, form, and button panels to the frame
        add(new JScrollPane(contactTable), BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void addContact() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        
        if (name.isEmpty()) {
            showErrorDialog("Please enter a name.");
            return;
        }
        
        if (!isValidPhoneNumber(phoneNumber)) {
            showErrorDialog("Invalid phone number format.");
            return;
        }
        
        if (!isValidEmail(email)) {
            showErrorDialog("Invalid email format.");
            return;
        }
        
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        tableModel.addRow(new Object[]{contact.getName(), contact.getPhoneNumber(), contact.getEmail()});
        clearFormFields();
    }
    
    private void editContact() {
        int selectedRow = contactTable.getSelectedRow();
        
        if (selectedRow == -1) {
            showErrorDialog("Please select a contact to edit.");
            return;
        }
        
        Contact contact = contacts.get(selectedRow);
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        
        if (name.isEmpty()) {
            showErrorDialog("Please enter a name.");
            return;
        }
        
        if (!isValidPhoneNumber(phoneNumber)) {
            showErrorDialog("Invalid phone number format.");
            return;
        }
        
        if (!isValidEmail(email)) {
            showErrorDialog("Invalid email format.");
            return;
        }
        
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        tableModel.setValueAt(name, selectedRow, 0);
        tableModel.setValueAt(phoneNumber, selectedRow, 1);
        tableModel.setValueAt(email, selectedRow, 2);
        clearFormFields();
    }
    
    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        
        if (selectedRow == -1) {
            showErrorDialog("Please select a contact to delete.");
            return;
        }
        
        contacts.remove(selectedRow);
        tableModel.removeRow(selectedRow);
        clearFormFields();
    }
    
    private void clearFormFields() {
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
    }
    
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Add your phone number validation logic here
        return true;
    }
    
    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        return true;
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
                new AddressBookApplication().setVisible(true);
            }
        });
    }
}
