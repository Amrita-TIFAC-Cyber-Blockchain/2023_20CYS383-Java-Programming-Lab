package com.amrita.jpl.cys21035.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:Copyright © 2022-2023 Amrita Parcel Management System, Gokulachselvan C D, V.M.Sushmanth, M C Vivek Veera, II B.Tech CSE (CYS)
 */

/**
 * The APMS (Amrita Parcel Management System) class represents the main program for managing parcel records.
 * It provides functionality to update delivery status, add records, and delete records.
 */
public class APMS extends JFrame {

    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel statusLabel;
    private JTextField statusTextField;
    private JLabel otpLabel;
    private JTextField otpTextField;
    private JButton pickupButton;
    private JButton deleteButton; // New button for deleting record
    private JTable recordsTable;
    private DefaultTableModel tableModel;
    private static  Boolean isAdminUser;

    private String filePath = "table_data.txt";

    /**
     * Creates a new instance of the APMS class.
     *
     * @param isAdminUser a boolean indicating whether the user is an admin or not
     */
    public APMS(Boolean isAdminUser) {
        this.isAdminUser = isAdminUser;
        setTitle("Amrita Parcel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        createMainPanel();

        add(mainPanel);

        // Load table data from file
        loadTableDataFromFile();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Save table data to file when the program exits
                saveTableDataToFile();
            }
        });
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tracking Number");
        tableModel.addColumn("Recipient Name");
        tableModel.addColumn("Courier/E-commerce Name");
        tableModel.addColumn("Delivery Status");

        recordsTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(recordsTable);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Welcome to Amrita Parcel Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel = new JLabel("Recipient Name:");
        nameTextField = new JTextField(20);
        otpLabel = new JLabel("Courier/E-commerce Name:");
        otpTextField = new JTextField(20);
        statusLabel = new JLabel("Status");
        statusTextField = new JTextField(20);
        pickupButton = new JButton("Update Parcel");
        deleteButton = new JButton("Delete Record"); // New button for deleting record

        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(otpLabel);
        inputPanel.add(otpTextField);
        inputPanel.add(statusLabel);
        inputPanel.add(statusTextField);
        inputPanel.add(deleteButton); // Add delete button to the input panel
        inputPanel.add(pickupButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        if(isAdminUser){
            mainPanel.add(inputPanel, BorderLayout.SOUTH);
        }

        // Pickup button click listener
        pickupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions on pickup button click
                String name = nameTextField.getText();
                String status = statusTextField.getText();
                String otp = otpTextField.getText();

                // Update delivery status and perform further actions
                updateDeliveryStatus(name, status, otp);
            }
        });

        // Delete button click listener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = recordsTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });
        if(isAdminUser){
            recordsTable.setEnabled(true);
        }
        else{
            recordsTable.setEnabled(false);
        }
    }

    /**
     * Updates the delivery status of a parcel record and performs further actions.
     *
     * @param name   the recipient name
     * @param status the delivery status
     * @param otp    the courier/e-commerce name
     */
    private void updateDeliveryStatus(String name, String status, String otp) {
        System.out.println("Recipient Name: " + name);
        System.out.println("Delivery Status: " + status);
        System.out.println("Courier/E-commerce Name: " + otp);

        Object[] record = {generateTrackingNumber(), name, otp, status};
        tableModel.addRow(record);

        nameTextField.setText("");
        statusTextField.setText("");
        otpTextField.setText("");
    }

    /**
     * Generates a random tracking number.
     *
     * @return the generated tracking number
     */
    private String generateTrackingNumber() {
        int randomNumber = (int) (Math.random() * 90000000) + 10000000;
        return String.valueOf(randomNumber);
    }

    /**
     * Saves the table data to a file.
     */
    private void saveTableDataToFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    Object value = tableModel.getValueAt(i, j);
                    bufferedWriter.write(value.toString());
                    bufferedWriter.write("\t");
                }
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Table data saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the table data from a file.
     */
    private void loadTableDataFromFile() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Object[]> rowDataList = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\t");
                rowDataList.add(values);
            }

            bufferedReader.close();
            fileReader.close();

            // Clear existing table data
            tableModel.setRowCount(0);

            // Add loaded data to the table
            for (Object[] rowData : rowDataList) {
                tableModel.addRow(rowData);
            }

            System.out.println("Table data loaded from file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new APMS(isAdminUser).setVisible(true);
            }
        });
    }
}
