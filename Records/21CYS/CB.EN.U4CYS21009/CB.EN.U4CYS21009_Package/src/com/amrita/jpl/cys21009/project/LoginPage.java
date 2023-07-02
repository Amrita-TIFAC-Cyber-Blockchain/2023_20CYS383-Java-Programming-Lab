package com.amrita.jpl.cys21009.project;
/**
 * JAVA SEMESTER PROJECT
 * simple login system that allows the users to access the database(GUI) according to their roles
 *
 * RBAC implementation
 *
 * @author Aravind S
 * @author Hem Sagar
 * @author Seran Pandiyan
 * @version 1.0
 * */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Map<String, String> userRoleMap;

    public LoginPage() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);

        // Mapping the users with roles.
        userRoleMap = new HashMap<>();
        userRoleMap.put("Harry Potter", "manager");
        userRoleMap.put("Eren Yeager", "admin");
        userRoleMap.put("Percy Jackson", "user");
        userRoleMap.put("guest", "guest");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:",SwingConstants.CENTER);
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:",SwingConstants.CENTER);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check the username and password
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");

                    String userRole = userRoleMap.get(username);
                    openHomePage(userRole);
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid username or password. Please try again.");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        return username.equals("Eren Yeager") && password.equals("password123")
                || username.equals("Percy Jackson") && password.equals("password456")
                || username.equals("Harry Potter") && password.equals("password000")
                || username.equals("guest") && password.equals("password789");
    }

    private void openHomePage(String userRole) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage(userRole);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage();
            }
        });
    }
}

class HomePage extends JFrame {
    private String userRole;
    private DefaultTableModel tableModel;
    private JTable table;

    public HomePage(String userRole) {
        this.userRole = userRole;
        setTitle("Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a table to display data
        String[] columnNames = {"ID", "Name", "Age", "Role"};
        Object[][] data = {
                {1, "Eren Yeager", 19,"admin"},
                {2, "Percy Jackson", 30,"user"},
                {3, "Harry Potter", 45,"manager"},
        };
        tableModel = new DefaultTableModel(data,columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonpanel = new JPanel(new GridLayout(1,3));

        JButton addButton = new JButton("Add Record");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userRole.equals("admin")){
                    addRecord();

                } else if (userRole.equals("manager")) {
                    addRecord();

                } else if (userRole.equals("normal")) {
                    JOptionPane.showMessageDialog(HomePage.this, "You are not permitted to alter the details.");
                }
                else{
                    JOptionPane.showMessageDialog(HomePage.this, "You are not permitted to alter the details.");
                }

            }
        });

        buttonpanel.add(addButton);

        JButton deleteButton = new JButton("Delete Record");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userRole.equals("admin")){
                    removeRecord();
                }
                else{
                    JOptionPane.showMessageDialog(HomePage.this, "You are not permitted to alter the details.");
                }
            }
        });
        buttonpanel.add(deleteButton);

        JButton editButton = new JButton("Edit Record");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userRole.equals("admin")){
                    editRecord();
                } else if (userRole.equals("manager")) {
                    editRecord();
                    System.out.println("Manager is not allowed to edit the roles assigned.");
                } else{
                    JOptionPane.showMessageDialog(HomePage.this, "You are not permitted to alter the details.");
                }

            }
        });
        buttonpanel.add(editButton);
        panel.add(buttonpanel,BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }
    private void addRecord() {
        JFrame addRecordFrame = new JFrame("Add Record");
        addRecordFrame.setSize(300, 400);
        addRecordFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel roleLabel = new JLabel("Role:");
        JTextField roleField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String age = ageField.getText();
                String role = roleField.getText();

                Vector<String> record = new Vector<>();
                record.add(id);
                record.add(name);
                record.add(age);
                record.add(role);

                tableModel.addRow(record);
                addRecordFrame.dispose();
            }
        });
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(roleLabel);
        panel.add(roleField);
        panel.add(new JLabel());
        panel.add(addButton);
        addRecordFrame.add(panel);
        addRecordFrame.pack();
        addRecordFrame.setVisible(true);
    }
    private void removeRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(HomePage.this, "Please select a record to remove.");
        }
    }
    private void editRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = table.getValueAt(selectedRow, 0).toString();
            String name = table.getValueAt(selectedRow, 1).toString();
            String age = table.getValueAt(selectedRow, 2).toString();
            String role = table.getValueAt(selectedRow,3).toString();

            // Create a new frame for editing
            JFrame editRecordFrame = new JFrame("Edit Record");
            editRecordFrame.setSize(300, 200);
            editRecordFrame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 2));

            JLabel idLabel = new JLabel("ID:");
            JTextField idField = new JTextField(id, 10);

            JLabel nameLabel = new JLabel("Name:");
            JTextField nameField = new JTextField(name, 20);

            JLabel ageLabel = new JLabel("Age:");
            JTextField ageField = new JTextField(age, 5);

            JLabel roleLabel = new JLabel("Role:");
            JTextField roleField = new JTextField(role,5);

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String newId = idField.getText();
                    String newName = nameField.getText();
                    String newAge = ageField.getText();
                    String newRole = roleField.getText().toLowerCase();

                    table.setValueAt(newId, selectedRow, 0);
                    table.setValueAt(newName, selectedRow, 1);
                    table.setValueAt(newAge, selectedRow, 2);
                    table.setValueAt(newRole, selectedRow, 3);

                    editRecordFrame.dispose();
                }
            });

            panel.add(idLabel);
            panel.add(idField);
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(ageLabel);
            panel.add(ageField);
            if(!userRole.equals("manager")){
                panel.add(roleLabel);
                panel.add(roleField);
            }
            panel.add(new JLabel());
            panel.add(saveButton);

            editRecordFrame.add(panel);
            editRecordFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(HomePage.this, "Please select a record to edit.");
        }
    }

}

