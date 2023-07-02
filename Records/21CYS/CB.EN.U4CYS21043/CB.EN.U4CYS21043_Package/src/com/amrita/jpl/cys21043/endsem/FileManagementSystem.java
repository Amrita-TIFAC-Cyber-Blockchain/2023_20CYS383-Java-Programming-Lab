package com.amrita.jpl.cys21043.endsem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @Author :MOHAMED JASIR FAIEZ M M
 * CB.EN.U4CYS21043
 */

class File {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private String duration;

    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile(String fileName);

    void loadFromFile(String fileName);

    File[] getFiles();
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(files);
            System.out.println("File details saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            files = (ArrayList<File>) inputStream.readObject();
            System.out.println("File details loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File[] getFiles() {
        return new File[0];
    }
}

class FileManagementSystemUI extends JFrame implements ActionListener {
    private FileManager fileManager;
    private DefaultTableModel tableModel;

    private JTextField fileNameField, fileSizeField;
    private JComboBox<String> fileTypeComboBox;
    private JButton addFileButton, deleteButton, displayButton, saveButton, loadButton;
    private JTable fileTable;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();

        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createFileInputPanel();
        createFileTable();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createFileInputPanel() {
        JPanel fileInputPanel = new JPanel();
        fileInputPanel.setLayout(new FlowLayout());

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameField = new JTextField(10);

        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeField = new JTextField(5);

        JLabel fileTypeLabel = new JLabel("File Type:");
        String[] fileTypes = {"mp4", "txt", "jpg"};
        fileTypeComboBox = new JComboBox<>(fileTypes);

        addFileButton = new JButton("Add File");
        addFileButton.addActionListener(this);

        fileInputPanel.add(fileNameLabel);
        fileInputPanel.add(fileNameField);
        fileInputPanel.add(fileSizeLabel);
        fileInputPanel.add(fileSizeField);
        fileInputPanel.add(fileTypeLabel);
        fileInputPanel.add(fileTypeComboBox);
        fileInputPanel.add(addFileButton);

        add(fileInputPanel, BorderLayout.NORTH);
    }

    private void createFileTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("Type");

        fileTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(fileTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        displayButton = new JButton("Display All");
        displayButton.addActionListener(this);

        saveButton = new JButton("Save to File");
        saveButton.addActionListener(this);

        loadButton = new JButton("Load from File");
        loadButton.addActionListener(this);

        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFileButton) {
            String fileName = fileNameField.getText();
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String fileType = (String) fileTypeComboBox.getSelectedItem();

            File file;
            if (fileType.equals("mp4")) {
                file = new Video(fileName, fileSize, "N/A");
            } else if (fileType.equals("txt")) {
                file = new Document(fileName, fileSize, "N/A");
            } else if (fileType.equals("jpg")) {
                file = new Image(fileName, fileSize, "N/A");
            } else {
                System.out.println("Invalid file type.");
                return;
            }

            fileManager.addFile(file);
            addFileToTable(file);
        } else if (e.getSource() == deleteButton) {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {
                String fileName = tableModel.getValueAt(selectedRow, 0).toString();
                fileManager.deleteFile(fileName);
                tableModel.removeRow(selectedRow);
            }
        } else if (e.getSource() == displayButton) {
            fileManager.displayAllFiles();
        } else if (e.getSource() == saveButton) {
            String fileName = JOptionPane.showInputDialog("Enter the file name:");
            fileManager.saveToFile(fileName);
        } else if (e.getSource() == loadButton) {
            String fileName = JOptionPane.showInputDialog("Enter the file name:");
            fileManager.loadFromFile(fileName);
            refreshTable();
        }
    }

    private void addFileToTable(File file) {
        String[] rowData = {file.getFileName(), String.valueOf(file.getFileSize()), getFileType(file)};
        tableModel.addRow(rowData);
    }

    private String getFileType(File file) {
        if (file instanceof Video) {
            return "mp4";
        } else if (file instanceof Document) {
            return "txt";
        } else if (file instanceof Image) {
            return "jpg";
        } else {
            return "Unknown";
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        File[] files = fileManager.getFiles();
        for (File file : files) {
            addFileToTable(file);
        }
    }
}

public class FileManagementSystem {
    public static void main(String[] args) {
        new FileManagementSystemUI();
    }
}


