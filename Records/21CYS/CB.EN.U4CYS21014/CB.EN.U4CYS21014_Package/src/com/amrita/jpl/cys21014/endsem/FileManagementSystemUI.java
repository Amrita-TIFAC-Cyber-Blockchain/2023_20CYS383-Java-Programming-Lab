package com.amrita.jpl.cys21014.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * @author Deepthi J, CB.EN.U4CYS21014
 * @version 1.0
 */


/**
 * Implementing Main function that demonstrates the functionality of the file management system.
 *
 */
class FileManagementSystem extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeField;
    private JTextField attributeField;

    public FileManagementSystem() {
        fileManager = new FileManagerImpl();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        fileNameField = new JTextField(15);
        fileSizeField = new JTextField(10);
        attributeField = new JTextField(15);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        JButton refreshButton = new JButton("Refresh ");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllFiles();
            }
        });

        inputPanel.add(new JLabel("File Name: "));
        inputPanel.add(fileNameField);
        inputPanel.add(new JLabel("File Size: "));
        inputPanel.add(fileSizeField);
        String[] options = {"Document", "Image", "Video"};
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeField = new JComboBox<String>(options);
        inputPanel.add(fileTypeLabel);
        inputPanel.add(fileTypeField);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addFile() {
        String fileName = fileNameField.getText();
        int fileSize = Integer.parseInt(fileSizeField.getText());
        String attribute = String.valueOf(fileTypeField.getSelectedItem());

        if (attribute.equalsIgnoreCase("document")) {
            String documentType = JOptionPane.showInputDialog(this, "Enter Document Type:");
            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
        } else if (attribute.equalsIgnoreCase("image")) {
            String resolution = JOptionPane.showInputDialog(this, "Enter Resolution:");
            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
        } else if (attribute.equalsIgnoreCase("video")) {
            String duration = JOptionPane.showInputDialog(this, "Enter Duration:");
            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Attribute!");
            return;
        }

        clearFields();
        updateTable();
    }

    private void deleteFile() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String fileName = (String) table.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to delete!");
        }
    }

    private void displayAllFiles() {
        fileManager.displayAllFiles();
    }

    private void clearFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        fileTypeField.setSelectedIndex(0);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), document.getDocumentType()});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "image"});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "video"});
            }
        }
    }
}

/**
 * this is the main class
 */
public class FileManagementSystemUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystem();
            }
        });
    }
}





