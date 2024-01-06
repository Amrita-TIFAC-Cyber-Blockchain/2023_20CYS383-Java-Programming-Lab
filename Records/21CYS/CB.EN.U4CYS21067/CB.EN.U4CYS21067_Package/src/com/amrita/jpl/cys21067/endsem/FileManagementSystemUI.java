package com.amrita.jpl.cys21067.endsem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileManagementSystemUI class represents a graphical user interface for a file management system.
 * It allows users to add and delete files, and displays the list of files in a table.
 */
public class FileManagementSystemUI {
    private JFrame frame;
    private JTextField nameTextField, sizeTextField;
    private JComboBox<String> fileTypeComboBox;
    private JButton addButton, deleteButton, refreshButton;
    private JTable fileListTable;
    private DefaultTableModel tableModel;
    private List<File> fileList;

    /**
     * Constructs a FileManagementSystemUI object.
     */
    public FileManagementSystemUI() {
        fileList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        // Create the main JFrame for the file management system UI
        frame = new JFrame("File Management System");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Create labels and text fields for file name and file size
        JLabel nameLabel = new JLabel("File Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(100, 10, 180, 25);
        frame.getContentPane().add(nameTextField);

        JLabel sizeLabel = new JLabel("File Size:");
        sizeLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(sizeLabel);

        sizeTextField = new JTextField();
        sizeTextField.setBounds(100, 40, 180, 25);
        frame.getContentPane().add(sizeTextField);

        // Create the file type combo box
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(fileTypeLabel);

        String[] fileTypes = { "Document", "Image", "Video" };
        fileTypeComboBox = new JComboBox<>(fileTypes);
        fileTypeComboBox.setBounds(100, 70, 180, 25);
        frame.getContentPane().add(fileTypeComboBox);

        // Create the Add button
        addButton = new JButton("Add File");
        addButton.setBounds(10, 110, 100, 25);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        // Create the Delete button
        deleteButton = new JButton("Delete File");
        deleteButton.setBounds(120, 110, 100, 25);
        frame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        // Create the Refresh button
        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(230, 110, 100, 25);
        frame.getContentPane().add(refreshButton);
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });

        // Create the file list table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        fileListTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileListTable);
        scrollPane.setBounds(10, 150, 460, 300);
        frame.getContentPane().add(scrollPane);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void addFile() {
        String name = nameTextField.getText();
        String size = sizeTextField.getText();
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        if (fileType.equals("Document")) {
            String documentType = JOptionPane.showInputDialog(frame, "Enter document type:");
            Document document = new Document(name, size, documentType);
            fileList.add(document);
        } else if (fileType.equals("Image")) {
            String resolution = JOptionPane.showInputDialog(frame, "Enter image resolution:");
            Image image = new Image(name, size, resolution);
            fileList.add(image);
        } else if (fileType.equals("Video")) {
            String duration = JOptionPane.showInputDialog(frame, "Enter video duration:");
            Video video = new Video(name, size, duration);
            fileList.add(video);
        }

        refreshFileList();
        clearTextFields();
    }

    private void deleteFile() {
        int selectedRow = fileListTable.getSelectedRow();
        if (selectedRow != -1) {
            fileList.remove(selectedRow);
            refreshFileList();
        }
    }

    private void refreshFileList() {
        tableModel.setRowCount(0);
        for (File file : fileList) {
            Object[] rowData = { file.getFileName(), file.getFileSize(), getFileTypeLabel(file) };
            tableModel.addRow(rowData);
        }
    }

    private String getFileTypeLabel(File file) {
        if (file instanceof Document) {
            return ((Document) file).getDocumentType();
        } else if (file instanceof Image) {
            return "Image";
        } else if (file instanceof Video) {
            return "Video";
        }
        return "";
    }

    private void clearTextFields() {
        nameTextField.setText("");
        sizeTextField.setText("");
    }
}
