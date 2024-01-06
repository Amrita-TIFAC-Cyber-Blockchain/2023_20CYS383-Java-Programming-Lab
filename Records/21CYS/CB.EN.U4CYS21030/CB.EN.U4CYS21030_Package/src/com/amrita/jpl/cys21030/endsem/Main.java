package com.amrita.jpl.cys21030.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import com.amrita.jpl.cys21030.endsem;
// com.amrita.jpl.cys21030.endsem.File class
/**
 * The File Management System
 * Dependencies:
 * - Requires Java AWT and ImageIO libraries.
 *
 * Usage:
 * - Specify the path to the image file in the 'imagePath' variable.
 * Include components such as text fields, buttons, and a table to display file information.
 * Implement event listeners for the buttons to perform file operations and update the table accordingly.
 *
 * Note: This example includes a placeholder implementation for splicing detection that assumes all images are spliced.
 *
 * @author Kavali Sai Suvarchala
 * @version 1.5
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21030.endsem.File Name: " + fileName);
        System.out.println("com.amrita.jpl.cys21030.endsem.File Size: " + fileSize);
    }
}

// com.amrita.jpl.cys21030.endsem.Document class
class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
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
        System.out.println("com.amrita.jpl.cys21030.endsem.Document Type: " + documentType);
    }
}

// com.amrita.jpl.cys21030.endsem.Image class
class Image extends File {
    private String resolution;

    public Image(String fileName, int fileSize, String resolution) {
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

// com.amrita.jpl.cys21030.endsem.Video class
class Video extends File {
    private String duration;

    public Video(String fileName, int fileSize, String duration) {
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

// com.amrita.jpl.cys21030.endsem.FileManager interface
interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile(String filePath);

    void loadFromFile(String filePath);
}

// com.amrita.jpl.cys21030.endsem.FileManagerImpl class
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
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
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
    public void saveToFile(String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(files);
            System.out.println("com.amrita.jpl.cys21030.endsem.File details saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            files = (ArrayList<File>) objectInputStream.readObject();
            System.out.println("com.amrita.jpl.cys21030.endsem.File details loaded from: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// com.amrita.jpl.cys21030.endsem.FileManagementSystemUI class
class FileManagementSystemUI extends JFrame implements ActionListener {
    private JTextField fileNameTextField, fileSizeTextField, documentTypeTextField, resolutionTextField, durationTextField;
    private JButton addDocumentButton, addImageButton, addVideoButton, deleteFileButton, displayFilesButton, saveButton, loadButton;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private FileManagerImpl fileManager;

    public FileManagementSystemUI() {
        // Initialize file manager
        fileManager = new FileManagerImpl();

        // Create UI components
        fileNameTextField = new JTextField(20);
        fileSizeTextField = new JTextField(10);
        documentTypeTextField = new JTextField(10);
        resolutionTextField = new JTextField(10);
        durationTextField = new JTextField(10);

        addDocumentButton = new JButton("Add com.amrita.jpl.cys21030.endsem.Document");
        addImageButton = new JButton("Add com.amrita.jpl.cys21030.endsem.Image");
        addVideoButton = new JButton("Add com.amrita.jpl.cys21030.endsem.Video");
        deleteFileButton = new JButton("Delete com.amrita.jpl.cys21030.endsem.File");
        displayFilesButton = new JButton("Display Files");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");


        tableModel = new DefaultTableModel();
        fileTable = new JTable(tableModel);
        tableModel.addColumn("com.amrita.jpl.cys21030.endsem.File Name");
        tableModel.addColumn("com.amrita.jpl.cys21030.endsem.File Size");
        tableModel.addColumn("com.amrita.jpl.cys21030.endsem.Document Type/Resolution/Duration");

        // Set layout
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("com.amrita.jpl.cys21030.endsem.File Name:"));
        inputPanel.add(fileNameTextField);
        inputPanel.add(new JLabel("com.amrita.jpl.cys21030.endsem.File Size:"));
        inputPanel.add(fileSizeTextField);

        JPanel documentPanel = new JPanel(new FlowLayout());
        documentPanel.add(new JLabel("com.amrita.jpl.cys21030.endsem.Document Type:"));
        documentPanel.add(documentTypeTextField);

        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(new JLabel("Resolution:"));
        imagePanel.add(resolutionTextField);

        JPanel videoPanel = new JPanel(new FlowLayout());
        videoPanel.add(new JLabel("Duration:"));
        videoPanel.add(durationTextField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 2));
        buttonPanel.add(addDocumentButton);
        buttonPanel.add(addImageButton);
        buttonPanel.add(addVideoButton);
        buttonPanel.add(deleteFileButton);
        buttonPanel.add(displayFilesButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        JScrollPane scrollPane = new JScrollPane(fileTable);

        add(inputPanel, BorderLayout.NORTH);
        add(documentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // Add action listeners to buttons
        addDocumentButton.addActionListener(this);
        addImageButton.addActionListener(this);
        addVideoButton.addActionListener(this);
        deleteFileButton.addActionListener(this);
        displayFilesButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDocumentButton) {
            String fileName = fileNameTextField.getText();
            int fileSize = Integer.parseInt(fileSizeTextField.getText());
            String documentType = documentTypeTextField.getText();

            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);

            updateTable();
            clearFields();
        } else if (e.getSource() == addImageButton) {
            String fileName = fileNameTextField.getText();
            int fileSize = Integer.parseInt(fileSizeTextField.getText());
            String resolution = resolutionTextField.getText();

            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);

            updateTable();
            clearFields();
        } else if (e.getSource() == addVideoButton) {
            String fileName = fileNameTextField.getText();
            int fileSize = Integer.parseInt(fileSizeTextField.getText());
            String duration = durationTextField.getText();

            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);

            updateTable();
            clearFields();
        } else if (e.getSource() == deleteFileButton) {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {
                String fileName = (String) fileTable.getValueAt(selectedRow, 0);
                fileManager.deleteFile(fileName);
                updateTable();
            }
        } else if (e.getSource() == displayFilesButton) {
            fileManager.displayAllFiles();
        } else if (e.getSource() == saveButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                fileManager.saveToFile(filePath);
            }
        } else if (e.getSource() == loadButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                fileManager.loadFromFile(filePath);
                updateTable();
            }

        }
    }

    private void updateTable() {
        // Clear the table
        tableModel.setRowCount(0);

        // Add file details to the table
        FileManagerImpl fileManager = new FileManagerImpl();
//// Assuming the method is defined in a superclass or interface
List<File> files = ((SuperclassOrInterfaceType) fileManager).getFiles();

            String details = "";
            if (file instanceof Document) {
                details = ((Document) file).getDocumentType();
            } else if (file instanceof Image) {
                details = ((Image) file).getResolution();
            } else if (file instanceof Video) {
                details = ((Video) file).getDuration();
            }
            tableModel.addRow(new Object[]{fileName, fileSize, details});
        }
    }


private void clearFields(){
        fileNameTextField.setText("");
        fileSizeTextField.setText("");
        documentTypeTextField.setText("");
        resolutionTextField.setText("");
        durationTextField.setText("");
        }
}



// com.amrita.jpl.cys21030.endsem.Main class
/**
 * The main method is the entry point of the application.
 * It reads an image file, performs splicing detection, and outputs the result.
 *
 * @param args command line arguments
 */
public class Main {
    public static void main(String[] args) {
        FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
        fileManagementSystemUI.setTitle("com.amrita.jpl.cys21030.endsem.File Management System");
        fileManagementSystemUI.setSize(800, 400);
        fileManagementSystemUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileManagementSystemUI.setVisible(true);
    }
}

