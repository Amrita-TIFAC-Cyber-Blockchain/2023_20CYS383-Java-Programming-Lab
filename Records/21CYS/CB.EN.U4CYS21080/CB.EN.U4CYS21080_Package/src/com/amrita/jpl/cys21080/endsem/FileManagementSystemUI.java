package com.amrita.jpl.cys21080.endsem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author T Pavan Kumar Reddy
 * @version 1.0
 * Abstract class which will have its abstract member functions overridden by its child classes.
 * It provides the common member functions among its child classes to reduce code redundancy.
 */
abstract class File implements Serializable{
    private String fileName;
    private long fileSize;

    /**
     * Assigns filename and file size to the object.
     *
     * @param fileName The name of the file
     * @param fileSize The size of the file
     */
    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    /**
     * @return returns the filename to where the function is called.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return returns the filesize to where the function is called.
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * The abstract class that will be overridden in the child classes before using the function.
     */
    public abstract void displayFileDetails();
}

/**
 * Provides an interface to be implemented.
 */
interface FileManager {
    /**
     * @param file the file to be added
     */
    void addFile(File file);

    /**
     * @param fileName the name of file to be deleted.
     */
    void deleteFile(String fileName);

    void saveToFile();

    void loadFromFile();

    ArrayList<File> getFiles();
}

/**
 * Document class is extended from the abstract class file
 */
class Document extends File implements Serializable{
    private String documentType;

    /**
     * Constructor of class Document
     *
     * @param fileName     The file name of the document
     * @param fileSize     The file size of the document
     * @param documentType The type of the document
     */
    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    /**
     * gets the document type when called
     *
     * @return the type of the document.
     */
    public String getDocumentType() {
        return documentType;
    }

    public String toString() {
        return "Document Name: " + getFileName() + "\n" +
                "File Size: " + getFileSize() + "\n" +
                "Document Type: " + getDocumentType() + "\n";
    }
    /**
     * sets or changes the document type
     *
     * @param documentType the type of the document
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Outputs the details of the document file on the command prompt.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Document Name: " + getFileName());
        System.out.println("File Size: " + getFileSize());
        System.out.println("Document Type: " + getDocumentType());
        System.out.println();
    }
}

class Image extends File implements Serializable{
    private String resolution;

    /**
     * constructor of class image
     *
     * @param fileName   The file name of the image
     * @param fileSize   The file size of the image
     * @param resolution The resolution of the image
     */
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

    /**
     * Outputs the details of the image file on the command prompt.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Image Name: " + getFileName());
        System.out.println("File Size: " + getFileSize());
        System.out.println("Resolution: " + getResolution());
        System.out.println();
    }
}


class Video extends File implements Serializable{
    private String duration;

    /**
     * constructor of video class
     *
     * @param fileName name of video
     * @param fileSize size of video
     * @param duration duration of video
     */
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

    /**
     * Outputs the details of the video file on the command prompt.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Video Name: " + getFileName());
        System.out.println("File Size: " + getFileSize());
        System.out.println("Duration: " + getDuration());
        System.out.println();
    }
}

// Class FileManagerImpl implements FileManager interface
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
    public void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file_details.txt");
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            ;
            for (File file : files) {
                printWriter.println(file.toString());
            }

            printWriter.close();
            fileOutputStream.close();
            System.out.println("File details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file details: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("file_details.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            files = (ArrayList<File>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("File details loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file details: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }
}

// Class FileManagementSystemUI
public class FileManagementSystemUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable fileTable;
    private JTextField nameField;
    private JTextField sizeField;
    private JComboBox<String> typeComboBox;
    private JButton addButton;
    private JButton deleteButton;
    private JButton displayButton;
    private JButton refreshButton;
    private JButton saveButton;

    private FileManager fileManager;

    /**
     * The gui is here
     */
    public FileManagementSystemUI() {
        setTitle("21UYS End Sem Assignment File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileManager = new FileManagerImpl();

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        fileTable = new JTable(tableModel);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileTable.getSelectionModel().addListSelectionListener(new FileSelectionListener());


        JScrollPane scrollPane = new JScrollPane(fileTable);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1, 6));

        JLabel nameLabel = new JLabel("File Name:");
        nameField = new JTextField();
        JLabel sizeLabel = new JLabel("File Size:");
        sizeField = new JTextField();
        JLabel typeLabel = new JLabel("Document Type:");
        typeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(sizeLabel);
        formPanel.add(sizeField);
        formPanel.add(typeLabel);
        formPanel.add(typeComboBox);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        deleteButton.setEnabled(false);
        displayButton = new JButton("Display");
        displayButton.addActionListener(new DisplayButtonListener());
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new RefreshButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(saveButton);


        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        Container container = getContentPane();
        container.add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * action on adding the file
     */
    private void addFile() {
        String name = nameField.getText();
        long size = Long.parseLong(sizeField.getText());
        String type = (String) typeComboBox.getSelectedItem();

        File file;
        switch (type) {
            case "Document":
                String documentType = JOptionPane.showInputDialog("Enter document type:");
                file = new Document(name, size, documentType);
                break;
            case "Image":
                String resolution = JOptionPane.showInputDialog("Enter image resolution:");
                file = new Image(name, size, resolution);
                break;
            case "Video":
                String duration = JOptionPane.showInputDialog("Enter video duration:");
                file = new Video(name, size, duration);
                break;
            default:
                System.out.println("Invalid file type");
                return;
        }

        fileManager.addFile(file);
        tableModel.addRow(new Object[]{name, size, type});

        nameField.setText("");
        sizeField.setText("");
        typeComboBox.setSelectedIndex(0);
    }

    /**
     * action on deleting file
     */
    private void deleteFile() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String) fileTable.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            tableModel.removeRow(selectedRow);
        }
    }

    /**
     * action on displaying file details
     */
    private void displayFileDetails() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String) fileTable.getValueAt(selectedRow, 0);
            for (File file : fileManager.getFiles()) {
                if (file.getFileName().equals(fileName)) {
                    file.displayFileDetails();
                    break;
                }
            }
        }
    }

    /**
     * action on refreshing the file list
     */
    private void refreshFileList() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            String fileType = "";
            if (file instanceof Document) {
                fileType = "Document";
            } else if (file instanceof Image) {
                fileType = "Image";
            } else if (file instanceof Video) {
                fileType = "Video";
            }
            tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize(), fileType});
        }
    }

    /**
     * action on saving file details to a file
     */
    private void saveFileDetails() {
        fileManager.saveToFile();
    }

    /**
     * action on loading file details from a file
     */
    private void loadFileDetails() {
        fileManager.loadFromFile();
        refreshFileList();
    }

    /**
     * Listener for the "Add" button
     */
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addFile();
        }
    }

    /**
     * Listener for the "Delete" button
     */
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteFile();
        }
    }

    /**
     * Listener for the "Display" button
     */
    private class DisplayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayFileDetails();
        }
    }

    /**
     * Listener for the "Refresh" button
     */
    private class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshFileList();
        }
    }

    /**
     * Listener for the "Save" button
     */
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveFileDetails();
        }
    }

    /**
     * Listener for the file selection in the table
     */
    private class FileSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = fileTable.getSelectedRow();
                deleteButton.setEnabled(selectedRow != -1);
            }
        }
    }

    /**
     * Main method to start the application
     */
    public static void main(String[] args) {
        FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
        fileManagementSystemUI.setVisible(true);
    }
}