package com.amrita.jpl.cys21049.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
 
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
        String txt = ".txt";
        System.out.println("File Name: " + fileName + txt );
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
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

    private JTextField fileNameField, fileSizeField, fileTypeField, resolutionField, durationField;
    private JButton addDocumentButton, addImageButton, addVideoButton, deleteButton, displayButton,
            saveButton, loadButton;
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

        JLabel fileTypeLabel = new JLabel("Document Type:");
        fileTypeField = new JTextField(10);

        addDocumentButton = new JButton("Add Document");
        addDocumentButton.addActionListener(this);

        addImageButton = new JButton("Add Image");
        addImageButton.addActionListener(this);

        addVideoButton = new JButton("Add Video");
        addVideoButton.addActionListener(this);

        fileInputPanel.add(fileNameLabel);
        fileInputPanel.add(fileNameField);
        fileInputPanel.add(fileSizeLabel);
        fileInputPanel.add(fileSizeField);

        fileInputPanel.add(addDocumentButton);
        fileInputPanel.add(addImageButton);
        fileInputPanel.add(addVideoButton);

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
        if (e.getSource() == addDocumentButton) {
            String fileName = fileNameField.getText() + ".txt";
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String documentType = fileTypeField.getText();

            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
            addFileToTable(document);
        } else if (e.getSource() == addImageButton) {
            String fileName = fileNameField.getText() + ".jpeg";
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String resolution = fileTypeField.getText();

            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
            addFileToTable(image);
        } else if (e.getSource() == addVideoButton) {
            String fileName = fileNameField.getText() + ".mp4";
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String duration = fileTypeField.getText();

            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);
            addFileToTable(video);
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
            updateTableWithLoadedFiles();
        }
    }

    private void addFileToTable(File file) {
        Object[] rowData = new Object[3];
        rowData[0] = file.getFileName();
        rowData[1] = file.getFileSize();

        if (file instanceof Document) {
            rowData[2] = "Document";
        } else if (file instanceof Image) {
            rowData[2] = "Image";
        } else if (file instanceof Video) {
            rowData[2] = "Video";
        }

        tableModel.addRow(rowData);
    }

    private void updateTableWithLoadedFiles() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            addFileToTable(file);
        }
    }
}

public class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}