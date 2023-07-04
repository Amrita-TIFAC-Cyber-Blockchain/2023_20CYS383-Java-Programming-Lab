package com.amrita.jpl.cys21066.endsem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// File class
class File {
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + " bytes");
    }
}

// Document class
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

// Image class
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

// Video class
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

// FileManager interface
interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile(String fileName);
}

// FileManagerImpl class
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                files.remove(file);
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// FileManagementSystemUI class
class FileManagementSystemUI {
    private FileManager fileManager;

    // Constructor
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
    }

    // Create and show the UI
    public void createUI() {
        JFrame frame = new JFrame("21UCYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // UI components
        JTextField fileNameTextField = new JTextField();
        JTextField fileSizeTextField = new JTextField();
        JTextField typeOrResolutionTextField = new JTextField();
        JButton addButton = new JButton("Add File");
        JButton deleteButton = new JButton("Delete File");
        JButton displayButton = new JButton("Display Files");
        JButton saveButton = new JButton("Save to File");
        JTextArea outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("File Name:"));
        panel.add(fileNameTextField);
        panel.add(new JLabel("File Size:"));
        panel.add(fileSizeTextField);
        panel.add(new JLabel("Type/Resolution:"));
        panel.add(typeOrResolutionTextField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(displayButton);
        panel.add(saveButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
                long fileSize = Long.parseLong(fileSizeTextField.getText());
                String typeOrResolution = typeOrResolutionTextField.getText();

                // Determine the file type based on the entered details
                File file;
                if (typeOrResolution.contains("x")) {
                    file = new Image(fileName, fileSize, typeOrResolution);
                } else if (typeOrResolution.contains(":")) {
                    file = new Video(fileName, fileSize, typeOrResolution);
                } else {
                    file = new Document(fileName, fileSize, typeOrResolution);
                }

                fileManager.addFile(file);
                outputTextArea.append("File added: " + file.getFileName() + "\n");
                clearTextFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
                fileManager.deleteFile(fileName);
                outputTextArea.append("File deleted: " + fileName + "\n");
                clearTextFields();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextArea.setText("");
                fileManager.displayAllFiles();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter a file name to save:");
                fileManager.saveToFile(fileName);
                outputTextArea.append("File details saved to: " + fileName + "\n");
            }
        });

        // Show the frame
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    // Clear input text fields
    private JTextField fileNameTextField; // Assuming JTextField is the type of these text fields
    private JTextField fileSizeTextField;
    private JTextField typeOrResolutionTextField;

    private void clearTextFields() {
        if (fileNameTextField != null) {
            fileNameTextField.setText("");
        }
        if (fileSizeTextField != null) {
            fileSizeTextField.setText("");
        }
        if (typeOrResolutionTextField != null) {
            typeOrResolutionTextField.setText("");
        }
    }

    // Main class
    public static class Main {
        public static void main(String[] args) {
            FileManagementSystemUI ui = new FileManagementSystemUI();
            ui.createUI();
        }
    }
}
