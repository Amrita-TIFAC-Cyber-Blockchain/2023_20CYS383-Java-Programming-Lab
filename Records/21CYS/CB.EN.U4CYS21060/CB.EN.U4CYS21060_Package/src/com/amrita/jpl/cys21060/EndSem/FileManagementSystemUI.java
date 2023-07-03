package com.amrita.jpl.cys21060.EndSem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FileManagementSystemUI extends JFrame {
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private JTextField fileNameField, fileSizeField;
    private JComboBox<String> fileTypeBox;
    private FileManagerImpl fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();

        setTitle("21UCYS End Semester Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        fileNameField = new JTextField(10);
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileNameField);

        fileSizeField = new JTextField(10);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(fileSizeField);

        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeBox = new JComboBox<>(fileTypes);
        inputPanel.add(new JLabel("File Type:"));
        inputPanel.add(fileTypeBox);

        JButton addFileButton = new JButton("Add File");
        addFileButton.addActionListener(e -> {
            String fileName = fileNameField.getText();
            String fileSize = fileSizeField.getText();
            String fileType = fileTypeBox.getSelectedItem().toString();

            if (fileType.equals("Document")) {
                // Ask for document type
                String documentType = JOptionPane.showInputDialog(
                        FileManagementSystemUI.this,
                        "Enter document type:",
                        "Add File",
                        JOptionPane.PLAIN_MESSAGE
                );

                // Add the row to the table with document type and file type
                tableModel.addRow(new Object[]{
                        fileName,
                        fileSize,
                        documentType,
                        documentType
                });

            } else if (fileType.equals("Image")) {
                // Ask for resolution
                String resolution = JOptionPane.showInputDialog(
                        FileManagementSystemUI.this,
                        "Enter resolution:",
                        "Add File",
                        JOptionPane.PLAIN_MESSAGE
                );

                // Add the row to the table
                tableModel.addRow(new Object[]{
                        fileName,
                        fileSize,
                        fileType,
                        resolution
                });

            } else if (fileType.equals("Video")) {
                // Ask for duration
                String duration = JOptionPane.showInputDialog(
                        FileManagementSystemUI.this,
                        "Enter duration:",
                        "Add File",
                        JOptionPane.PLAIN_MESSAGE
                );

                // Add the row to the table
                tableModel.addRow(new Object[]{
                        fileName,
                        fileSize,
                        fileType,
                        duration
                });

            }

            // Clear the input fields
            fileNameField.setText("");
            fileSizeField.setText("");
        });


        JButton deleteFileButton = new JButton("Delete File");
        deleteFileButton.addActionListener(e -> {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(
                        FileManagementSystemUI.this,
                        "Please select a file to delete.",
                        "Delete File",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e ->{
            fileNameField.setText("");
            fileSizeField.setText("");
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addFileButton);
        buttonPanel.add(deleteFileButton);
        buttonPanel.add(refreshButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileManagementSystemUI::new);
    }
}


