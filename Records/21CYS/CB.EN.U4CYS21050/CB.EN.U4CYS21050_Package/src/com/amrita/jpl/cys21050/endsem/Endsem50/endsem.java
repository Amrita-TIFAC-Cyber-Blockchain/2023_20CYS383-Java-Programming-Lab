package com.amrita.jpl.cys21050.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endsem extends JFrame {
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton refreshButton;
    private JTextField fileNameTextField;
    private JTextField fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;

    public endsem() {

        setTitle("21CYS End Semester Assignment File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");


        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);


        JPanel inputPanel = new JPanel(new GridLayout(1, 6, 10, 10));


        JLabel fileNameLabel = new JLabel("File Name:");
        inputPanel.add(fileNameLabel);

        fileNameTextField = new JTextField();
        inputPanel.add(fileNameTextField);


        JLabel fileSizeLabel = new JLabel("File Size:");
        inputPanel.add(fileSizeLabel);

        fileSizeTextField = new JTextField();
        inputPanel.add(fileSizeTextField);


        JLabel fileTypeLabel = new JLabel("File Type:");
        inputPanel.add(fileTypeLabel);

        fileTypeComboBox = new JComboBox<>(new String[]{"Video", "Document", "Image"});
        inputPanel.add(fileTypeComboBox);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));


        addButton = new JButton("Add File");
        buttonPanel.add(addButton);


        deleteButton = new JButton("Delete File");
        buttonPanel.add(deleteButton);

        refreshButton = new JButton("Refresh");
        buttonPanel.add(refreshButton);


        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshFileList();
            }
        });
    }

    private void addFile() {
        String fileName = fileNameTextField.getText();
        String fileSizeString = fileSizeTextField.getText();
        int fileSize;
        try {
            fileSize = Integer.parseInt(fileSizeString);
            if (fileSize <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid file size!");
            return;
        }

        String fileType = (String) fileTypeComboBox.getSelectedItem();
        String additionalInfo = "";

        switch (fileType) {
            case "Document":
                additionalInfo = JOptionPane.showInputDialog(this, "Enter Document Type:");
                break;
            case "Video":
                additionalInfo = JOptionPane.showInputDialog(this, "Enter Video Duration:");
                break;
            case "Image":
                additionalInfo = JOptionPane.showInputDialog(this, "Enter Image Resolution:");
                break;
        }

        if (fileName != null && !fileName.isEmpty()) {
            Object[] rowData = {fileName, fileSize, fileType, additionalInfo};
            tableModel.addRow(rowData);
        }
    }

    private void deleteFile() {
        int selectedIndex = fileTable.getSelectedRow();
        if (selectedIndex != -1) {
            tableModel.removeRow(selectedIndex);
        }
    }

    private void refreshFileList() {
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new endsem();
            }
        });
    }
}
