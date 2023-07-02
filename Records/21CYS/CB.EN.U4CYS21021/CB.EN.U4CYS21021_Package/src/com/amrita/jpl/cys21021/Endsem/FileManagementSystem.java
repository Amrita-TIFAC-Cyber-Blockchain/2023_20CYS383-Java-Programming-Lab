package com.amrita.jpl.cys21021.Endsem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class File {
    private String fileName;
    private long fileSize;
    private String fileType;

    public File(String fileName, long fileSize, String fileType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileType() {
        return fileType;
    }
}

class FileManager {
    private ArrayList<File> files;

    public FileManager() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        files.removeIf(file -> file.getFileName().equals(fileName));
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable fileTable;

    private JTextField nameField, sizeField;
    private JComboBox<String> fileTypeComboBox;

    public FileManagementSystemUI() {
        fileManager = new FileManager();
        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);

        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("File Name:");
        nameField = new JTextField(10);

        JLabel sizeLabel = new JLabel("File Size:");
        sizeField = new JTextField(10);

        JLabel typeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>(new String[]{"Image", "Video", "Document"});

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);
        inputPanel.add(typeLabel);
        inputPanel.add(fileTypeComboBox);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                refreshFiles();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addFile() {
        String name = nameField.getText();
        long size = Long.parseLong(sizeField.getText());
        String type = (String) fileTypeComboBox.getSelectedItem();

        File file = new File(name, size, type);
        fileManager.addFile(file);

        nameField.setText("");
        sizeField.setText("");

        refreshFiles();
    }

    private void deleteFile() {
        int selectedRow = fileTable.getSelectedRow();

        if (selectedRow != -1) {
            String fileName = (String) fileTable.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            refreshFiles();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to delete.");
        }
    }

    private void refreshFiles() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();

        for (File file : files) {
            Object[] rowData = {file.getFileName(), file.getFileSize(), file.getFileType()};
            tableModel.addRow(rowData);
        }
    }
}

public class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}