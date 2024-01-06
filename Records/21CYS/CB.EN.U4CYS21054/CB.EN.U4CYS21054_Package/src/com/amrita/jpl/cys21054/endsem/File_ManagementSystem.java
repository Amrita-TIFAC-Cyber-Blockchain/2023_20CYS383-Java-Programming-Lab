package com.amrita.jpl.cys21054.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a File.
 */
abstract class File {
    private String fileName;
    private double fileSize;
    private String fileType;

    /**
     * Constructor for the File class.
     *
     * @param fileName  the name of the file
     * @param fileSize  the size of the file
     * @param fileType  the type of the file
     */
    public File(String fileName, double fileSize, String fileType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    /**
     * Get the name of the file.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set the name of the file.
     *
     * @param fileName the file name to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the size of the file.
     *
     * @return the file size
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * Set the size of the file.
     *
     * @param fileSize the file size to set
     */
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Get the type of the file.
     *
     * @return the file type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Set the type of the file.
     *
     * @param fileType the file type to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * Convert the file details to a string representation.
     *
     * @return the string representation of the file
     */
    public abstract String toFileString();
}

/**
 * Class representing a Document file.
 */
class Document extends File {
    private String documentType;

    /**
     * Constructor for the Document class.
     *
     * @param fileName      the name of the document file
     * @param fileSize      the size of the document file
     * @param documentType  the type of the document
     */
    public Document(String fileName, double fileSize, String documentType) {
        super(fileName, fileSize, "Document");
        this.documentType = documentType;
    }

    /**
     * Get the type of the document.
     *
     * @return the document type
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Set the type of the document.
     *
     * @param documentType the document type to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toFileString() {
        return String.format("Document,%s,%.2f,%s", getFileName(), getFileSize(), getDocumentType());
    }
}

/**
 * Class representing an Image file.
 */
class Image extends File {
    private String resolution;

    /**
     * Constructor for the Image class.
     *
     * @param fileName   the name of the image file
     * @param fileSize   the size of the image file
     * @param resolution the resolution of the image
     */
    public Image(String fileName, double fileSize, String resolution) {
        super(fileName, fileSize, "Image");
        this.resolution = resolution;
    }

    /**
     * Get the resolution of the image.
     *
     * @return the image resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Set the resolution of the image.
     *
     * @param resolution the image resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toFileString() {
        return String.format("Image,%s,%.2f,%s", getFileName(), getFileSize(), getResolution());
    }
}

/**
 * Class representing a Video file.
 */
class Video extends File {
    private double duration;

    /**
     * Constructor for the Video class.
     *
     * @param fileName   the name of the video file
     * @param fileSize   the size of the video file
     * @param duration   the duration of the video
     */
    public Video(String fileName, double fileSize, double duration) {
        super(fileName, fileSize, "Video");
        this.duration = duration;
    }

    /**
     * Get the duration of the video.
     *
     * @return the video duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Set the duration of the video.
     *
     * @param duration the video duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toFileString() {
        return String.format("Video,%s,%.2f,%.2f", getFileName(), getFileSize(), getDuration());
    }
}

/**
 * Interface for managing files.
 */
interface FileManager {
    /**
     * Add a file to the file manager.
     *
     * @param file the file to add
     */
    void addFile(File file);

    /**
     * Delete a file from the file manager.
     *
     * @param fileName the name of the file to delete
     */
    void deleteFile(String fileName);

    /**
     * Get all the files in the file manager.
     *
     * @return a list of files
     */
    List<File> getAllFiles();
}

/**
 * Implementation of the FileManager interface.
 */
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
        files.removeIf(file -> file.getFileName().equals(fileName));
    }

    @Override
    public List<File> getAllFiles() {
        return files;
    }
}

/**
 * User interface for the file management system.
 */
class FileManagementSystemUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTextField fileNameTextField;
    private JTextField fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private File userFile;

    /**
     * Constructor for the FileManagementSystemUI class.
     *
     * @param fileManager the file manager instance
     */
    public FileManagementSystemUI(FileManager fileManager) {
        this.fileManager = fileManager;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameTextField = new JTextField(10);

        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeTextField = new JTextField(10);

        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeComboBox = new JComboBox<>(fileTypes);

        JButton addButton = new JButton("Add File");
        JButton deleteButton = new JButton("Delete File");
        JButton refreshButton = new JButton("Refresh");

        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameTextField);
        inputPanel.add(fileSizeLabel);
        inputPanel.add(fileSizeTextField);
        inputPanel.add(fileTypeComboBox);

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(refreshButton);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(tablePanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFiles();
                saveTableDetailsToFile();
            }
        });
    }

    private void addFile() {
        String fileName = fileNameTextField.getText();
        String fileSizeText = fileSizeTextField.getText();
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        if (fileName.isEmpty() || fileSizeText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double fileSize;
        try {
            fileSize = Double.parseDouble(fileSizeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid file size. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File file;
        switch (fileType) {
            case "Document":
                String documentType = JOptionPane.showInputDialog(frame, "Enter Document Type:");
                if (documentType == null || documentType.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid document type.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                file = new Document(fileName + " (" + fileType + ")", fileSize, documentType);
                break;
            case "Image":
                String resolution = JOptionPane.showInputDialog(frame, "Enter Image Resolution:");
                if (resolution == null || resolution.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid resolution.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                file = new Image(fileName + " (" + fileType + ")", fileSize, resolution);
                break;
            case "Video":
                String duration = JOptionPane.showInputDialog(frame, "Enter Video Duration (in seconds):");
                if (duration == null || duration.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid duration.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    double videoDuration = Double.parseDouble(duration);
                    file = new Video(fileName + " (" + fileType + ")", fileSize, videoDuration);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Invalid video duration. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Invalid file type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        fileManager.addFile(file);
        addFileToTable(file);
        saveTableDetailsToFile();

        fileNameTextField.setText("");
        fileSizeTextField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
    }

    private void deleteFile() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a file to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fileName = (String) fileTable.getValueAt(selectedRow, 0);
        fileManager.deleteFile(fileName);
        tableModel.removeRow(selectedRow);
        saveTableDetailsToFile();
    }

    private void refreshFiles() {
        tableModel.setRowCount(0);

        List<File> files = fileManager.getAllFiles();
        for (File file : files) {
            addFileToTable(file);
        }
    }

    private void addFileToTable(File file) {
        String[] rowData = {file.getFileName(), String.valueOf(file.getFileSize()), file.getFileType()};
        tableModel.addRow(rowData);
    }

    private void saveTableDetailsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("file_details.txt"))) {
            List<File> files = fileManager.getAllFiles();
            for (File file : files) {
                writer.println(file.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Main class to run the file management system.
 */
public class File_ManagementSystem {
    public static void main(String[] args) {
        FileManager fileManager = new FileManagerImpl();
        FileManagementSystemUI ui = new FileManagementSystemUI(fileManager);
    }
}
