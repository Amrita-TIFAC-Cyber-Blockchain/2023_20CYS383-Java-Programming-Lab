package com.amrita.jpl.cys21036.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

abstract class File {
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public abstract void displayFileDetails();
}

class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21036.endsem.Document Details:");
        System.out.println("Name: " + getFileName());
        System.out.println("Size: " + getFileSize());
        System.out.println("Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21036.endsem.Image Details:");
        System.out.println("Name: " + getFileName());
        System.out.println("Size: " + getFileSize());
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private String duration;

    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21036.endsem.Video Details:");
        System.out.println("Name: " + getFileName());
        System.out.println("Size: " + getFileSize());
        System.out.println("Duration: " + duration);
    }
}

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
    ArrayList<File> getFiles();
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
        files.removeIf(file -> file.getFileName().equals(fileName));
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(files);
            System.out.println("com.amrita.jpl.cys21036.endsem.File details saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            files = (ArrayList<File>) objectInputStream.readObject();
            System.out.println("com.amrita.jpl.cys21036.endsem.File details loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI extends JFrame {
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JTextField documentTypeField;
    private JTextField resolutionField;
    private JTextField durationField;
    private DefaultTableModel tableModel;

    private FileManager fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();

        setTitle("com.amrita.jpl.cys21036.endsem.File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("com.amrita.jpl.cys21036.endsem.File Name:"));
        fileNameField = new JTextField();
        inputPanel.add(fileNameField);
        inputPanel.add(new JLabel("com.amrita.jpl.cys21036.endsem.File Size:"));
        fileSizeField = new JTextField();
        inputPanel.add(fileSizeField);
        inputPanel.add(new JLabel("com.amrita.jpl.cys21036.endsem.Document Type:"));
        documentTypeField = new JTextField();
        inputPanel.add(documentTypeField);
        inputPanel.add(new JLabel("Resolution:"));
        resolutionField = new JTextField();
        inputPanel.add(resolutionField);
        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        add(inputPanel, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addDocumentButton = new JButton("Add com.amrita.jpl.cys21036.endsem.Document");
        addDocumentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String documentType = documentTypeField.getText();
                Document document = new Document(fileName, fileSize, documentType);
                fileManager.addFile(document);
                refreshTable();
                clearInputFields();
            }
        });
        buttonPanel.add(addDocumentButton);

        JButton addImageButton = new JButton("Add com.amrita.jpl.cys21036.endsem.Image");
        addImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String resolution = resolutionField.getText();
                Image image = new Image(fileName, fileSize, resolution);
                fileManager.addFile(image);
                refreshTable();
                clearInputFields();
            }
        });
        buttonPanel.add(addImageButton);

        JButton addVideoButton = new JButton("Add com.amrita.jpl.cys21036.endsem.Video");
        addVideoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String duration = durationField.getText();
                Video video = new Video(fileName, fileSize, duration);
                fileManager.addFile(video);
                refreshTable();
                clearInputFields();
            }
        });
        buttonPanel.add(addVideoButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    refreshTable();
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton displayAllButton = new JButton("Display All Files");
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileManager.displayAllFiles();
            }
        });
        buttonPanel.add(displayAllButton);

        JButton saveButton = new JButton("Save to com.amrita.jpl.cys21036.endsem.File");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter file name:");
                if (fileName != null && !fileName.isEmpty()) {
                    fileManager.saveToFile(fileName);
                }
            }
        });
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Load from com.amrita.jpl.cys21036.endsem.File");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter file name:");
                if (fileName != null && !fileName.isEmpty()) {
                    fileManager.loadFromFile(fileName);
                    refreshTable();
                }
            }
        });
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Create table
        tableModel = new DefaultTableModel(new Object[]{"com.amrita.jpl.cys21036.endsem.File Name", "com.amrita.jpl.cys21036.endsem.File Size"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.SOUTH);

        pack();
    }

    private int getSelectedRow() {
        JTable table = (JTable) ((JViewport) ((JScrollPane) getContentPane().getComponent(2)).getComponent(0)).getComponent(0);
        return table.getSelectedRow();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            Object[] rowData = {file.getFileName(), file.getFileSize()};
            tableModel.addRow(rowData);
        }
    }

    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        documentTypeField.setText("");
        resolutionField.setText("");
        durationField.setText("");
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
                fileManagementSystemUI.setVisible(true);
            }
        });
    }
}





