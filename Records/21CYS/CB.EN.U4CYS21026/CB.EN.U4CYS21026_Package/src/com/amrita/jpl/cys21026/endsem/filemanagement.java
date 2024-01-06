package com.amrita.jpl.cys21026.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Represents a file in the file management system.
 */
class File {
    private String fileName;
    private int fileSize;

    /**
     * Constructs a File object with the specified file name and file size.
     *
     * @param fileName the name of the file
     * @param fileSize the size of the file in bytes
     */
    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    /**
     * Returns the name of the file.
     *
     * @return the name of the file
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns the size of the file in bytes.
     *
     * @return the size of the file in bytes
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * Displays the details of the file.
     */
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

/**
 * Represents a document file in the file management system.
 */
class Document extends File {
    private String documentType;

    /**
     * Constructs a Document object with the specified file name, file size, and document type.
     *
     * @param fileName     the name of the file
     * @param fileSize     the size of the file in bytes
     * @param documentType the type of the document
     */
    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    /**
     * Returns the type of the document.
     *
     * @return the type of the document
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Displays the details of the document file.
     */
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

/**
 * Represents an image file in the file management system.
 */
class Image extends File {
    private String resolution;

    /**
     * Constructs an Image object with the specified file name, file size, and resolution.
     *
     * @param fileName   the name of the file
     * @param fileSize   the size of the file in bytes
     * @param resolution the resolution of the image
     */
    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    /**
     * Returns the resolution of the image.
     *
     * @return the resolution of the image
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Displays the details of the image file.
     */
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

/**
 * Represents a video file in the file management system.
 */
class Video extends File {
    private String duration;

    /**
     * Constructs a Video object with the specified file name, file size, and duration.
     *
     * @param fileName  the name of the file
     * @param fileSize  the size of the file in bytes
     * @param duration  the duration of the video
     */
    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    /**
     * Returns the duration of the video.
     *
     * @return the duration of the video
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Displays the details of the video file.
     */
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

/**
 * Represents a file manager interface.
 */
interface FileManager {
    /**
     * Adds a file to the file manager.
     *
     * @param file the file to be added
     */
    void addFile(File file);

    /**
     * Deletes a file from the file manager based on the file name.
     *
     * @param fileName the name of the file to be deleted
     */
    void deleteFile(String fileName);

    /**
     * Displays the details of all files in the file manager.
     */
    void displayAllFiles();

    /**
     * Saves the file details to a file.
     *
     * @param fileName the name of the file to save to
     */
    void saveToFile(String fileName);

    /**
     * Loads file details from a file.
     *
     * @param fileName the name of the file to load from
     */
    void loadFromFile(String fileName);

    /**
     * Returns an array of files in the file manager.
     *
     * @return an array of files
     */
    File[] getFiles();
}

/**
 * Represents a file manager implementation.
 */
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    /**
     * Constructs a FileManagerImpl object.
     */
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
        return files.toArray(new File[0]);
    }
}

/**
 * Represents the user interface for the file management system.
 */
class FileManagementSystemUI extends JFrame implements ActionListener {
    private FileManager fileManager;
    private DefaultTableModel tableModel;

    private JTextField fileNameField, fileSizeField, fileTypeField, resolutionField, durationField;
    private JButton addDocumentButton, addImageButton, addVideoButton, deleteButton, displayButton,
            saveButton, loadButton;
    private JTable fileTable;

    /**
     * Constructs a FileManagementSystemUI object.
     */
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
        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeField = new JTextField(10);

        addDocumentButton = new JButton("Add Document file");
        addDocumentButton.addActionListener(this);

        addImageButton = new JButton("Add Image file");
        addImageButton.addActionListener(this);

        addVideoButton = new JButton("Add Video file");
        addVideoButton.addActionListener(this);

        fileInputPanel.add(fileNameLabel);
        fileInputPanel.add(fileNameField);
        fileInputPanel.add(fileSizeLabel);
        fileInputPanel.add(fileSizeField);
        fileInputPanel.add(fileTypeLabel);
        fileInputPanel.add(fileTypeField);
        fileInputPanel.add(addDocumentButton);
        fileInputPanel.add(addImageButton);
        fileInputPanel.add(addVideoButton);

        add(fileInputPanel, BorderLayout.NORTH);
    }

    private void createFileTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        fileTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(fileTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(this);

        displayButton = new JButton("Refresh");
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
            String fileName = fileNameField.getText();
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String documentType = fileTypeField.getText();

            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
            addFileToTable(document);
        } else if (e.getSource() == addImageButton) {
            String fileName = fileNameField.getText();
            int fileSize = Integer.parseInt(fileSizeField.getText());
            String resolution = fileTypeField.getText();

            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
            addFileToTable(image);
        } else if (e.getSource() == addVideoButton) {
            String fileName = fileNameField.getText();
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
            refreshTable();
        }
    }

    private void addFileToTable(File file) {
        tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize(), getFileType(file)});
    }

    private String getFileType(File file) {
        if (file instanceof Document) {
            return "Document";
        } else if (file instanceof Image) {
            return "Image";
        } else if (file instanceof Video) {
            return "Video";
        }
        return "";
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        File[] files = fileManager.getFiles();
        for (File file : files) {
            addFileToTable(file);
        }
    }
}

/**
 * Represents the main class for the file management system.
 */
class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
