package com.amrita.jpl.cys21019.end_sem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * File Management System Application.
 * File Management that handles different types of files such as documents, images, and videos.
 * Author: Gokulachselvan C D
 */

abstract class File {
    /*
     *Class representing a file with basic attributes.
     */
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

    public abstract String getFileType();

    public abstract Object[] getFileDetails();
}

class Document extends File {
    /*
     *Class representing a document file.
     */
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

    public String getFileType() {
        return "Document";
    }

    public Object[] getFileDetails() {
        return new Object[]{getFileName(), getFileSize(), getDocumentType()};
    }
}

class Image extends File {
    /*
     *Class representing an image file.
     */
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

    public String getFileType() {
        return "Image";
    }

    public Object[] getFileDetails() {
        return new Object[]{getFileName(), getFileSize(), getResolution()};
    }
}

class Video extends File {
    /*
     Class representing a video file.
     */
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

    public String getFileType() {
        return "Video";
    }

    public Object[] getFileDetails() {
        return new Object[]{getFileName(), getFileSize(), getDuration()};
    }
}

interface FileManager {
    /*
     *Interface defining operations for file management.
     */
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile();

    void loadFromFile();

    ArrayList<File> getFiles();
}

class FileManagerImpl implements FileManager {
    /*
     *Implementation of the FileManager interface.
     */
    private ArrayList<File> files;
    private String dataFilePath;

    public FileManagerImpl(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        files = new ArrayList<>();
        loadFromFile();
    }

    public void addFile(File file) {
        String fileName = file.getFileName();
        File existingFile = getFileByName(fileName);

        if (existingFile != null) {
            int option = JOptionPane.showConfirmDialog(null, "A file with the same name already exists. Do you want to replace it?", "File Exists", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                files.remove(existingFile);
            } else {
                return;
            }
        }

        files.add(file);
    }

    public void deleteFile(String fileName) {
        File fileToDelete = getFileByName(fileName);
        if (fileToDelete != null) {
            files.remove(fileToDelete);
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            Object[] fileDetails = file.getFileDetails();
            System.out.println("File Name: " + fileDetails[0] + ", File Size: " + fileDetails[1] + ", File Type: " + file.getFileType());
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))) {
            for (File file : files) {
                writer.println(file.getFileName() + "," + file.getFileSize() + "," + file.getFileType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String fileName = parts[0];
                    long fileSize = Long.parseLong(parts[1]);
                    String fileType = parts[2];

                    if (fileType.equals("Document")) {
                        String documentType = JOptionPane.showInputDialog("Enter the Document Type for '" + fileName + "':");
                        Document document = new Document(fileName, fileSize, documentType);
                        files.add(document);
                    } else if (fileType.equals("Image")) {
                        String resolution = JOptionPane.showInputDialog("Enter the Resolution for '" + fileName + "':");
                        Image image = new Image(fileName, fileSize, resolution);
                        files.add(image);
                    } else if (fileType.equals("Video")) {
                        String duration = JOptionPane.showInputDialog("Enter the Duration for '" + fileName + "':");
                        Video video = new Video(fileName, fileSize, duration);
                        files.add(video);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    private File getFileByName(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}

class FileManagementSystemUI extends JFrame {
    /*
     *GUI class for the file management system.
     */
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeComboBox;
    private JLabel fileTypeSelectedLabel;
    private static final String DATA_FILE_PATH = "file_details.txt";

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl(DATA_FILE_PATH);

        setTitle("File Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel fileDetailsPanel = new JPanel(new GridLayout(1, 6));
        JLabel fileNameLabel = new JLabel("File Name:");
        JLabel fileSizeLabel = new JLabel("File Size:");
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileNameField = new JTextField();
        fileSizeField = new JTextField();
        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeComboBox = new JComboBox<>(fileTypes);
        fileTypeSelectedLabel = new JLabel();

        fileTypeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedFileType = (String) fileTypeComboBox.getSelectedItem();
                fileTypeSelectedLabel.setText("Selected File Type: " + selectedFileType);
            }
        });

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFileToList();
            }
        });

        fileDetailsPanel.add(fileNameLabel);
        fileDetailsPanel.add(fileNameField);
        fileDetailsPanel.add(fileSizeLabel);
        fileDetailsPanel.add(fileSizeField);
        fileDetailsPanel.add(fileTypeLabel);
        fileDetailsPanel.add(fileTypeComboBox);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) table.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    refreshTable();
                    fileManager.saveToFile();
                }
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        JButton addFileButton = new JButton("Add File");
        addFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFileToList();
            }
        });
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(addFileButton);

        panel.add(fileDetailsPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
        loadFileDetails();
        refreshTable();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            Object[] fileDetails = file.getFileDetails();
            tableModel.addRow(fileDetails);
        }
    }

    private void addFileToList() {
        String fileName = fileNameField.getText();
        long fileSize = Long.parseLong(fileSizeField.getText());
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        if (fileType.equals("Document")) {
            String documentType = JOptionPane.showInputDialog("Enter the Document Type:");
            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
        } else if (fileType.equals("Image")) {
            String resolution = JOptionPane.showInputDialog("Enter the Resolution:");
            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
        } else if (fileType.equals("Video")) {
            String duration = JOptionPane.showInputDialog("Enter the Duration:");
            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);
        }

        refreshTable();
        fileNameField.setText("");
        fileSizeField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
        fileManager.saveToFile();
    }

    private void loadFileDetails() {
        fileManager.loadFromFile();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI().setVisible(true);
            }
        });
    }
}

/*
*This is main class for GUI program
 */
public class fms {
    public static void main(String[] args) {
        FileManagementSystemUI.main(args);
    }
}
