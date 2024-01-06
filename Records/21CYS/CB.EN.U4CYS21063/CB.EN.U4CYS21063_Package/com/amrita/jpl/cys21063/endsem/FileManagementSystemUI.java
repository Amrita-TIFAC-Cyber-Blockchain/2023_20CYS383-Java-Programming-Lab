package com.amrita.jpl.cys21063.endsem;

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

        setTitle("21UCYS End Semester Assignment File Manager");
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


        JPanel inputPanel = new JPanel();

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

            tableModel.addRow(new Object[]{
                    fileNameField.getText(),
                    fileSizeField.getText(),
                    fileTypeBox.getSelectedItem().toString()
            });

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

        inputPanel.add(addFileButton);
        inputPanel.add(deleteFileButton);

        panel.add(inputPanel, BorderLayout.SOUTH);


        add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileManagementSystemUI::new);
    }
}
