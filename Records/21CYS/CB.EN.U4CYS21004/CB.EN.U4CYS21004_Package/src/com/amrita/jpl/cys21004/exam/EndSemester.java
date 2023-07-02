package com.amrita.jpl.cys21004.exam;

/**
 * @author: Aishwarya GS
 * CB.EN.U4CYS21004
 * End Semester Lab Evaluation (20CYS283)
 * Implementation of File Management System
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EndSemester {

    /**
     * @param args default argument
     */
    public static void main(String[] args) {
        EndSemester ui = new EndSemester();
        ui.run();
    }

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<File> files;
    private FileManager fileManager;

    public void run() {
        files = new ArrayList<>();
        fileManager = new FileManagerImpl();

        createAndShowGUI();
    }

    /**
     * Main UI
     */

    private void createAndShowGUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 400));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel fileDetailsPanel = new JPanel();
        fileDetailsPanel.setLayout(new GridLayout(1, 1));

        JLabel nameLabel = new JLabel("File Name:");
        JTextField nameField = new JTextField();
        JLabel sizeLabel = new JLabel("File Size:");
        JTextField sizeField = new JTextField();
        JLabel typeLabel = new JLabel("File Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});

        typeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typeComboBox.getSelectedItem();
                switch (selectedType) {
                    case "Document" -> {
                        String documentType = showInputDialog("Enter document type:");
                        if (documentType != null) {
                            addDocument(nameField.getText(), sizeField.getText(), documentType);
                        }
                    }
                    case "Image" -> {
                        String resolution = showInputDialog("Enter resolution:");
                        if (resolution != null) {
                            addImage(nameField.getText(), sizeField.getText(), resolution);
                        }
                    }
                    case "Video" -> {
                        String duration = showInputDialog("Enter duration:");
                        if (duration != null) {
                            addVideo(nameField.getText(), sizeField.getText(), duration);
                        }
                    }
                }
            }
        });

        fileDetailsPanel.add(nameLabel);
        fileDetailsPanel.add(nameField);
        fileDetailsPanel.add(sizeLabel);
        fileDetailsPanel.add(sizeField);
        fileDetailsPanel.add(typeLabel);
        fileDetailsPanel.add(typeComboBox);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = nameField.getText();
                String fileSize = sizeField.getText();
                String fileType = (String) typeComboBox.getSelectedItem();

                switch (fileType) {
                    case "Document" -> {
                        String documentType = showInputDialog("Enter document type:");
                        if (documentType != null) {
                            addDocument(fileName, fileSize, documentType);
                        }
                    }
                    case "Image" -> {
                        String resolution = showInputDialog("Enter resolution:");
                        if (resolution != null) {
                            addImage(fileName, fileSize, resolution);
                        }
                    }
                    case "Video" -> {
                        String duration = showInputDialog("Enter duration:");
                        if (duration != null) {
                            addVideo(fileName, fileSize, duration);
                        }
                    }
                }

                nameField.setText("");
                sizeField.setText("");
            }
        });

        panel.add(fileDetailsPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = table.getValueAt(selectedRow, 0).toString();
                    fileManager.deleteFile(fileName);
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadTableData();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private String showInputDialog(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    private void reloadTableData() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getAllFiles()) {
            tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize(), file.getFileType()});
        }
    }

    private void addDocument(String fileName, String fileSize, String documentType) {
        Document document = new Document(fileName, Long.parseLong(fileSize), documentType);
        fileManager.addFile(document);
        files.add(document);
        tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), document.getFileType()});
    }

    private void addImage(String fileName, String fileSize, String resolution) {
        Image image = new Image(fileName, Long.parseLong(fileSize), resolution);
        fileManager.addFile(image);
        files.add(image);
        tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), image.getFileType()});
    }

    private void addVideo(String fileName, String fileSize, String duration) {
        Video video = new Video(fileName, Long.parseLong(fileSize), Integer.parseInt(duration));
        fileManager.addFile(video);
        files.add(video);
        tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), video.getFileType()});
    }

    public interface FileManager {
        void addFile(File file);

        void deleteFile(String fileName);

        List<File> getAllFiles();
    }

    public static class FileManagerImpl implements FileManager {
        private List<File> files;

        public FileManagerImpl() {
            files = new ArrayList<>();
        }

        @Override
        public void addFile(File file) {
            files.add(file);
        }

        @Override
        public void deleteFile(String fileName) {
            File fileToDelete = null;
            for (File file : files) {
                if (file.getFileName().equals(fileName)) {
                    fileToDelete = file;
                    break;
                }
            }

            if (fileToDelete != null) {
                files.remove(fileToDelete);
                System.out.println("File deleted: " + fileName);
            } else {
                System.out.println("File not found: " + fileName);
            }
        }

        @Override
        public List<File> getAllFiles() {
            return files;
        }
    }

    public static class File {
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

    public static class Document extends File {
        private String documentType;

        public Document(String fileName, long fileSize, String documentType) {
            super(fileName, fileSize, "Document");
            this.documentType = documentType;
        }
    }

    public static class Image extends File {
        private String resolution;

        public Image(String fileName, long fileSize, String resolution) {
            super(fileName, fileSize, "Image");
            this.resolution = resolution;
        }
    }

    public static class Video extends File {
        public Video(String fileName, long fileSize, int duration) {
            super(fileName, fileSize, "Video");
        }
    }
}

/**
 * End of code
 */
