package com.amrita.jpl.cys21058.endsem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class File {
    private String fileName;
    private String fileSize;

    public File(String fileName, String fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, String fileSize, String documentType) {
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

class Image extends File {
    private String resolution;

    public Image(String fileName, String fileSize, String resolution) {
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

class Video extends File {
    private String duration;

    public Video(String fileName, String fileSize, String duration) {
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

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    List<File> getFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}

class FileManagerImpl implements FileManager {
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
        File fileToRemove = null;
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToRemove = file;
                break;
            }
        }
        if (fileToRemove != null) {
            files.remove(fileToRemove);
        }
    }

    @Override
    public List<File> getFiles() {
        return files;
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

    @Override
    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (List<File>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTextField fileNameTextField;
    private JTextField fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;

    public FileManagementSystemUI() {
        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        fileManager = new FileManagerImpl();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        JTable fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(1, 6));

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameTextField = new JTextField();
        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameTextField);

        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeTextField = new JTextField();
        inputPanel.add(fileSizeLabel);
        inputPanel.add(fileSizeTextField);

        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>();
        fileTypeComboBox.addItem("Document");
        fileTypeComboBox.addItem("Image");
        fileTypeComboBox.addItem("Video");
        inputPanel.add(fileTypeLabel);
        inputPanel.add(fileTypeComboBox);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
                String fileSize = fileSizeTextField.getText();
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                File file;
                switch (fileType) {
                    case "Document":
                        String documentType = JOptionPane.showInputDialog("Enter Document Type:");
                        file = new Document(fileName, fileSize, documentType);
                        break;
                    case "Image":
                        String resolution = JOptionPane.showInputDialog("Enter Image Resolution:");
                        file = new Image(fileName, fileSize, resolution);
                        break;
                    case "Video":
                        String duration = JOptionPane.showInputDialog("Enter Video Duration:");
                        file = new Video(fileName, fileSize, duration);
                        break;
                    default:
                        file = new File(fileName, fileSize);
                        break;
                }

                fileManager.addFile(file);
                refreshTable();
                clearInputFields();
            }
        });
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = fileTable.getSelectedRow();
                deleteFile(rowIndex);
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        loadFileData(); // Load previously saved file data
        refreshTable(); // Refresh the table to display loaded data

        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void refreshTable() {
        clearTable();
        List<File> files = fileManager.getFiles();
        for (File file : files) {
            String[] row = {file.getFileName(), file.getFileSize(), file instanceof Document ? "Document" :
                    file instanceof Image ? "Image" :
                            file instanceof Video ? "Video" : "File"};
            tableModel.addRow(row);
        }
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }

    private void clearInputFields() {
        fileNameTextField.setText("");
        fileSizeTextField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
    }

    private void deleteFile(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            String fileName = (String) tableModel.getValueAt(rowIndex, 0);
            fileManager.deleteFile(fileName);
            refreshTable();
        }
    }

    private void loadFileData() {
        fileManager.loadFromFile("file_data.txt");
    }

    public void saveFileData() {
        fileManager.saveToFile("file_data.txt");
    }
}

public class FileManagementSystemApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
                fileManagementSystemUI.setVisible(true);
                fileManagementSystemUI.saveFileData(); // Save file data before closing the application
            }
        });
    }
}
