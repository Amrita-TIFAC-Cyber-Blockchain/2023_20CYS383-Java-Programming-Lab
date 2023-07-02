package com.amrita.jpl.cys21046.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The FileManagementSystemUI class represents the user interface for the file management system.
 */
public class FileManagementSystemUI {
    private JFrame frame;
    private JTextField fileNameTextField;
    private JTextField fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private FileManagerImpl fileManager;

    /**
     * Constructs a FileManagementSystemUI object and initializes the file management system.
     */
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("21UCYS End Semester Assignment File Manager");
        frame.setBounds(100, 100, 600, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameLabel.setBounds(10, 5, 80, 20);
        frame.getContentPane().add(fileNameLabel);

        fileNameTextField = new JTextField();
        fileNameTextField.setBounds(80, 6, 140, 20);
        frame.getContentPane().add(fileNameTextField);
        fileNameTextField.setColumns(10);

        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeLabel.setBounds(230, 5, 70, 20);
        frame.getContentPane().add(fileSizeLabel);

        fileSizeTextField = new JTextField();
        fileSizeTextField.setBounds(290, 6, 95, 20);
        frame.getContentPane().add(fileSizeTextField);
        fileSizeTextField.setColumns(10);

        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeLabel.setBounds(400, 5, 70, 20);
        frame.getContentPane().add(fileTypeLabel);

        fileTypeComboBox = new JComboBox<String>();
        fileTypeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Document", "Image", "Video"}));
        fileTypeComboBox.setBounds(460, 6, 105, 20);
        frame.getContentPane().add(fileTypeComboBox);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 560, 200);
        frame.getContentPane().add(scrollPane);

        fileTable = new JTable();
        scrollPane.setViewportView(fileTable);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");
        fileTable.setModel(tableModel);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFileButtonClicked();
            }
        });
        addButton.setBounds(135, 260, 100, 20);
        frame.getContentPane().add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFileButtonClicked();
            }
        });
        deleteButton.setBounds(247, 260, 100, 20);
        frame.getContentPane().add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshButtonClicked();
            }
        });
        refreshButton.setBounds(357, 260, 100, 20);
        frame.getContentPane().add(refreshButton);

        frame.setVisible(true);
    }

    private void addFileButtonClicked() {
        String fileName = fileNameTextField.getText();
        int fileSize = Integer.parseInt(fileSizeTextField.getText());
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        File file;
        if (fileType.equals("Document")) {
            String documentType = JOptionPane.showInputDialog(frame, "Enter the document type:");
            file = new Document(fileName, fileSize, documentType);
        } else if (fileType.equals("Image")) {
            String resolution = JOptionPane.showInputDialog(frame, "Enter the image resolution:");
            file = new Image(fileName, fileSize, resolution);
        } else {
            String duration = JOptionPane.showInputDialog(frame, "Enter the video duration:");
            file = new Video(fileName, fileSize, duration);
        }

        fileManager.addFile(file);
        addRowToTable(file);
    }

    private void deleteFileButtonClicked() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow >= 0) {
            String fileName = (String) tableModel.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
        }
    }

    private void refreshButtonClicked() {
        clearTable();
        List<File> files = fileManager.getAllFiles();
        for (File file : files) {
            addRowToTable(file);
        }
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }

    private void addRowToTable(File file) {
        tableModel.addRow(new Object[] { file.getFileName(), file.getFileSize(), file.getClass().getSimpleName() });
    }

    /**
     * The main method creates an instance of FileManagementSystemUI and runs the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
