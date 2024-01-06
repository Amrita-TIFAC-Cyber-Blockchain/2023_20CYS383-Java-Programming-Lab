package com.amrita.jpl.cys21027.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * File Management application for 21CYS
 * @author Karaka Sri Sai Nitin
 * @version 1.0
 */

abstract class File {

    /**
     * This abstract class File is created for storing info about the files that are created
     * @param fileName The name of the file
     * @param filePath The path of the file
     * @param fileType The type of file
     * @param fileSize The size of the file
     */

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
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + " KB");
    }
}

class Document extends File {

    /**
     * The class Document is a extended class of the abstract class File
     * @param documentType the type of document
     */
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
        System.out.println("Document Type: " + documentType);
        super.displayFileDetails();
    }
}

class Image extends File {

    /**
     * The Image file is another extension of the abstract class File
     * @param resolution gives the resolution of the image
     */
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
        System.out.println("Resolution: " + resolution);
        super.displayFileDetails();
    }
}

class Video extends File {

    /**
     * The Video file is another extension of the abstract class File
     * @param duration determines the duration of the video
     *
     */
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
        System.out.println("Duration: " + duration);
        super.displayFileDetails();
    }
}

interface FileManager {

    /**
     * Create an interface file to apply the specified options of the created files
     * @param file the file to be created and added to the manager
     */
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String filePath);
    void loadFromFile(String filePath);
    ArrayList<File> getFiles();
}

class FileManagerImpl implements FileManager {

    /**
     *FileManager implementation implements the interface FileManager
     */
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
        File fileToDelete = null;
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToDelete = file;
                break;
            }
        }
        if (fileToDelete != null) {
            files.remove(fileToDelete);
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println("================================================================");
        }
    }

    @Override
    public void saveToFile(String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(files);
            System.out.println("File details saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            files = (ArrayList<File>) objectInputStream.readObject();
            System.out.println("File details loaded from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI extends JFrame {

    /**
     * Constructs the File Management Application frame.
     * Initializes the GUI components and sets up the layout.
     */

    private FileManager fileManager;
    private DefaultTableModel tableModel;

    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;

    public FileManagementSystemUI(FileManager fileManager) {
        /**
         * Describes whatever the UI that has to be done within the folder.
         * @param fileManager does the filemanager.
         */
        this.fileManager = fileManager;
        setTitle("21UCYS End Semester Assignment File Manager");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameField = new JTextField(20);
        JLabel fileSizeLabel = new JLabel("File Size (KB):");
        fileSizeField = new JTextField(10);
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});
        topPanel.add(fileNameLabel);
        topPanel.add(fileNameField);
        topPanel.add(fileSizeLabel);
        topPanel.add(fileSizeField);
        topPanel.add(fileTypeLabel);
        topPanel.add(fileTypeComboBox);


        JButton addButton = new JButton("Add File");
        JButton deleteButton = new JButton("Delete File");
        JButton displayButton = new JButton("Refresh");


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);


        fileTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(fileTable);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"File Name", "File Size (KB) ", "File Type"}, 0);
        fileTable.setModel(tableModel);

        addButton.addActionListener(new ActionListener() {
            /**
             * Called when the add button is pressed and it is trying to add a new file
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                int fileSize = Integer.parseInt(fileSizeField.getText());
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                if (fileType.equals("Document")) {
                    String documentType = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter document type:");
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (fileType.equals("Image")) {
                    String resolution = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter image resolution:");
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (fileType.equals("Video")) {
                    String duration = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter video duration:");
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }

                updateFileTable();
                clearInputFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            /**
             * Called when the file is deleted from the table
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    updateFileTable();
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            /**
             * Called when the file is successfully displayed within the compiler
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.displayAllFiles();
            }
        });

    }

    private void updateFileTable() {
        /**
         * Update the table and store the file which are being added to the table.
         */
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), "Document", document.getDocumentType()});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "Image", image.getResolution()});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "Video", video.getDuration()});
            }
        }
    }

    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
    }
}

public class Main {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FileManager fileManager = new FileManagerImpl();
        FileManagementSystemUI ui = new FileManagementSystemUI(fileManager);
        ui.setVisible(true);
    }
}


