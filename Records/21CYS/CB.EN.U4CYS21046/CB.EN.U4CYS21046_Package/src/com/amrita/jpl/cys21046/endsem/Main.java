package com.amrita.jpl.cys21046.endsem;//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new FileManagementSystemUI();
//            }
//        });
//    }
//}
//
//abstract class File {
//    private String fileName;
//    private int fileSize;
//
//    public File(String fileName, int fileSize) {
//        this.fileName = fileName;
//        this.fileSize = fileSize;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public int getFileSize() {
//        return fileSize;
//    }
//
//    public void setFileSize(int fileSize) {
//        this.fileSize = fileSize;
//    }
//
//    public abstract void displayFileDetails();
//}
//
//class Document extends File {
//    private String documentType;
//
//    public Document(String fileName, int fileSize, String documentType) {
//        super(fileName, fileSize);
//        this.documentType = documentType;
//    }
//
//    public String getDocumentType() {
//        return documentType;
//    }
//
//    public void setDocumentType(String documentType) {
//        this.documentType = documentType;
//    }
//
//    @Override
//    public void displayFileDetails() {
//        super.displayFileDetails();
//        System.out.println("Document Type: " + documentType);
//    }
//}
//
//class Image extends File {
//    private String resolution;
//
//    public Image(String fileName, int fileSize, String resolution) {
//        super(fileName, fileSize);
//        this.resolution = resolution;
//    }
//
//    public String getResolution() {
//        return resolution;
//    }
//
//    public void setResolution(String resolution) {
//        this.resolution = resolution;
//    }
//
//    @Override
//    public void displayFileDetails() {
//        super.displayFileDetails();
//        System.out.println("Resolution: " + resolution);
//    }
//}
//
//class Video extends File {
//    private String duration;
//
//    public Video(String fileName, int fileSize, String duration) {
//        super(fileName, fileSize);
//        this.duration = duration;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    @Override
//    public void displayFileDetails() {
//        super.displayFileDetails();
//        System.out.println("Duration: " + duration);
//    }
//}
//
//class FileManagerImpl implements FileManager {
//    private List<File> files;
//
//    public FileManagerImpl() {
//        files = new ArrayList<>();
//    }
//
//    @Override
//    public void addFile(File file) {
//        files.add(file);
//        System.out.println("File added successfully.");
//    }
//
//    @Override
//    public void deleteFile(String fileName) {
//        for (File file : files) {
//            if (file.getFileName().equals(fileName)) {
//                files.remove(file);
//                System.out.println("File deleted successfully.");
//                return;
//            }
//        }
//        System.out.println("File not found.");
//    }
//
//    @Override
//    public void displayAllFiles() {
//        if (files.isEmpty()) {
//            System.out.println("No files found.");
//        } else {
//            for (File file : files) {
//                file.displayFileDetails();
//                System.out.println();
//            }
//        }
//    }
//
//    @Override
//    public List<File> getAllFiles() {
//        return files;
//    }
//
//    @Override
//    public void saveToFile(String fileName) {
//        // Implementation to save files to a file
//    }
//
//    public void loadFromFile(String fileName) {
//        // Implementation to load files from a file
//    }
//}
//
//interface FileManager {
//    void addFile(File file);
//    void deleteFile(String fileName);
//    void displayAllFiles();
//    List<File> getAllFiles();
//    void saveToFile(String fileName);
//    void loadFromFile(String fileName);
//}
//
//class FileManagementSystemUI {
//    private FileManager fileManager;
//    private JFrame frame;
//    private JTable table;
//    private DefaultTableModel tableModel;
//
//    public FileManagementSystemUI() {
//        fileManager = new FileManagerImpl();
//        initializeUI();
//    }
//
//    private void initializeUI() {
//        frame = new JFrame("File Management System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//
//        tableModel = new DefaultTableModel();
//        tableModel.addColumn("File Name");
//        tableModel.addColumn("File Size");
//
//        table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        frame.add(scrollPane, BorderLayout.CENTER);
//
//        JPanel buttonPanel = new JPanel();
//        JButton addButton = new JButton("Add File");
//        JButton deleteButton = new JButton("Delete File");
//        JButton displayButton = new JButton("Display Files");
//
//        addButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showAddFileDialog();
//            }
//        });
//
//        deleteButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showDeleteFileDialog();
//            }
//        });
//
//        displayButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                displayFiles();
//            }
//        });
//
//        buttonPanel.add(addButton);
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(displayButton);
//        frame.add(buttonPanel, BorderLayout.SOUTH);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void showAddFileDialog() {
//        JTextField fileNameField = new JTextField(10);
//        JTextField fileSizeField = new JTextField(10);
//
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("File Name:"));
//        panel.add(fileNameField);
//        panel.add(new JLabel("File Size:"));
//        panel.add(fileSizeField);
//
//        int result = JOptionPane.showConfirmDialog(null, panel, "Add File",
//                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//        if (result == JOptionPane.OK_OPTION) {
//            String fileName = fileNameField.getText();
//            int fileSize = Integer.parseInt(fileSizeField.getText());
//            File file = createFile(fileName, fileSize);
//            if (file != null) {
//                fileManager.addFile(file);
//                tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize()});
//            }
//        }
//    }
//
//    private void showDeleteFileDialog() {
//        int selectedRow = table.getSelectedRow();
//        if (selectedRow != -1) {
//            String fileName = (String) table.getValueAt(selectedRow, 0);
//            fileManager.deleteFile(fileName);
//            tableModel.removeRow(selectedRow);
//        }
//    }
//
//    private void displayFiles() {
//        fileManager.displayAllFiles();
//    }
//
//    private File createFile(String fileName, int fileSize) {
//        JComboBox<String> fileTypeCombo = new JComboBox<>(new String[]{"Document", "Image", "Video"});
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("File Type:"));
//        panel.add(fileTypeCombo);
//
//        int result = JOptionPane.showConfirmDialog(null, panel, "File Type",
//                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//        if (result == JOptionPane.OK_OPTION) {
//            String fileType = (String) fileTypeCombo.getSelectedItem();
//            switch (fileType) {
//                case "Document":
//                    JTextField documentTypeField = new JTextField(10);
//                    panel = new JPanel();
//                    panel.add(new JLabel("Document Type:"));
//                    panel.add(documentTypeField);
//
//                    result = JOptionPane.showConfirmDialog(null, panel, "Document Type",
//                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//                    if (result == JOptionPane.OK_OPTION) {
//                        String documentType = documentTypeField.getText();
//                        return new Document(fileName, fileSize, documentType);
//                    }
//                    break;
//
//                case "Image":
//                    JTextField resolutionField = new JTextField(10);
//                    panel = new JPanel();
//                    panel.add(new JLabel("Resolution:"));
//                    panel.add(resolutionField);
//
//                    result = JOptionPane.showConfirmDialog(null, panel, "Resolution",
//                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//                    if (result == JOptionPane.OK_OPTION) {
//                        String resolution = resolutionField.getText();
//                        return new Image(fileName, fileSize, resolution);
//                    }
//                    break;
//
//                case "Video":
//                    JTextField durationField = new JTextField(10);
//                    panel = new JPanel();
//                    panel.add(new JLabel("Duration:"));
//                    panel.add(durationField);
//
//                    result = JOptionPane.showConfirmDialog(null, panel, "Duration",
//                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//                    if (result == JOptionPane.OK_OPTION) {
//                        String duration = durationField.getText();
//                        return new Video(fileName, fileSize, duration);
//                    }
//                    break;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new FileManagementSystemUI();
//            }
//        });
//    }
//}
