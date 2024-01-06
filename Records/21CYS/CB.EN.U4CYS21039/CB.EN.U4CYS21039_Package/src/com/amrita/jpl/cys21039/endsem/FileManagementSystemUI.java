package com.amrita.jpl.cys21039.endsem;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
/**
 * @author Manbendra Satpathy
 */
/**
 * This program is a File Management System implemented using Java Swing.
 * It allows users to add and delete files of different types (Document, Image, Video) and displays the file details in a table.
 *
 * @args None
 */

abstract class File{
    private String fileName;
    private long fileSize;
    /**
     * Constructs a File object with the specified fileName and fileSize.
     *
     * @param fileName The name of the file.
     * @param fileSize The size of the file in bytes.
     */
    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    /**
     * Displays the details of the file.
     */
    public abstract void displayFileDetails();
    /**
     * Returns the name of the file.
     *
     * @return The name of the file.
     */
    public String getFileName(){
        return fileName;
    }
    /**
     * Returns the size of the file in bytes.
     *
     * @return The size of the file in bytes.
     */
    public long getFileSize(){
        return fileSize;
    }
}
/**
 * Represents a Document file.
 */
class Document extends File {
    public String type;
    /**
     * Constructs a Document object with the specified fileName, fileSize, and type.
     *
     * @param fileName The name of the document file.
     * @param fileSize The size of the document file in bytes.
     * @param type     The type of the document.
     */
    public Document(String fileName, long fileSize, String type) {
        super(fileName, fileSize);
        this.type = type;
    }
    /**
     * Returns the type of the document.
     *
     * @return The type of the document.
     */
    public String getType() {
        return type;
    }
    /**
     * Displays the details of the document file.
     */
    public void displayFileDetails() {
        System.out.println("Document Name : " + getFileName());
        System.out.println("Size : " + getFileSize() + "KB");
        System.out.println("Type : " + type);
    }
}
/**
 * Represents an Image file.
 */
class Image extends File {
    public String resolution;
    /**
     * Constructs an Image object with the specified fileName, fileSize, and resolution.
     *
     * @param fileName   The name of the image file.
     * @param fileSize   The size of the image file in bytes.
     * @param resolution The resolution of the image.
     */
    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }
    /**
     * Returns the resolution of the image.
     *
     * @return The resolution of the image.
     */
    public String getResolution() {
        return resolution;
    }
    /**
     * Displays the details of the image file.
     */
    public void displayFileDetails() {
        System.out.println("Image Name : " + getFileName());
        System.out.println("Size : " + getFileSize() + "KB");
        System.out.println("Resolution : " + resolution);
    }
}
/**
 * Represents a Video file.
 */
class Video extends File {
    public String duration;
    /**
     * Constructs a Video object with the specified fileName, fileSize, and duration.
     *
     * @param fileName The name of the video file.
     * @param fileSize The size of the video file in bytes.
     * @param duration The duration of the video.
     */
    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }
    /**
     * Returns the duration of the video.
     *
     * @return The duration of the video.
     */
    public String getDuration() {
        return duration;
    }
    /**
     * Displays the details of the video file.
     */
    public void displayFileDetails() {
        System.out.println("Document Name : " + getFileName());
        System.out.println("Size : " + getFileSize() + "KB");
        System.out.println("Type : " + duration);
    }
}
/**
 * Represents a FileManager interface for managing files.
 */
interface FileManager {
    /**
     * Adds a file to the file manager.
     *
     * @param file The file to be added.
     */
    void addFile(File file);
    /**
     * Deletes a file from the file manager.
     *
     * @param fileName The name of the file to be deleted.
     */
    void deleteFile(String fileName);
    /**
     * Saves the file details to a file.
     */
    void saveToFile();
    /**
     * Loads the file details from a file.
     */
    void loadFromFile();
    /**
     * Returns the list of files managed by the file manager.
     *
     * @return The list of files.
     */
    ArrayList<File> getFiles();
}
/**
 * Represents an implementation of the FileManager interface.
 */

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;
    /**
     * Constructs a FileManagerImpl object.
     */
    public FileManagerImpl() {
        files = new ArrayList<>();
    }
    /**
     * Adds a file to the file manager.
     *
     * @param file The file to be added.
     */
    public void addFile(File file) {
        files.add(file);
    }
    /**
     * Deletes a file from the file manager.
     *
     * @param fileName The name of the file to be deleted.
     */
    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }
    /**
     * Saves the file details to a file.
     */
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("File_Details.txt"))) {
            for (File file : files) {
                writer.println(file.getClass().getSimpleName());
                writer.println(file.getFileName());
                writer.println(file.getFileSize());
                if (file instanceof Document) {
                    Document document = (Document) file;
                    writer.println(document.getType());
                } else if (file instanceof Image) {
                    Image image = (Image) file;
                    writer.println(image.resolution);
                } else if (file instanceof Video) {
                    Video video = (Video) file;
                    writer.println(video.duration);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Loads the file details from a file.
     */
    public void loadFromFile() {
        files.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("File_Details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String type = line.trim();
                String name = reader.readLine().trim();
                long size = Long.parseLong(reader.readLine().trim());
                if (type.equals("Document")) {
                    String docType = reader.readLine().trim();
                    addFile(new Document(name, size, docType));
                } else if (type.equals("Image")) {
                    String resolution = reader.readLine().trim();
                    addFile(new Image(name, size, resolution));
                } else if (type.equals("Video")) {
                    String duration = reader.readLine().trim();
                    addFile(new Video(name, size, duration));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the list of files managed by the file manager.
     *
     * @return The list of files.
     */
    public ArrayList<File> getFiles() {
        return files;
    }
}
/**
 * Represents the main GUI window of the File Management System.
 */
public class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable fileTable;
    private JTextField nameField;
    private JTextField sizeField;
    private JComboBox<String> typeComboBox;
    private JTextField resolutionField;
    private JTextField durationField;
    /**
     * Constructs the FileManagementSystemUI object.
     */
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Size");
        tableModel.addColumn("Type");
        tableModel.addColumn("Resolution");
        tableModel.addColumn("Duration");

        fileTable = new JTable(tableModel);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) tableModel.getValueAt(selectedRow, 0);
                    String size = (String) tableModel.getValueAt(selectedRow, 1);
                    String type = (String) tableModel.getValueAt(selectedRow, 2);
                    String resolution = (String) tableModel.getValueAt(selectedRow, 3);
                    String duration = (String) tableModel.getValueAt(selectedRow, 4);
                    nameField.setText(name);
                    sizeField.setText(size);
                    typeComboBox.setSelectedItem(type);
                    resolutionField.setText(resolution);
                    durationField.setText(duration);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(fileTable);

        nameField = new JTextField(15);
        sizeField = new JTextField(10);
        typeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});
        typeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typeComboBox.getSelectedItem();
                adjustFieldsBasedOnType(selectedType);
            }
        });
        resolutionField = new JTextField(10);
        durationField = new JTextField(10);
        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                long size = Long.parseLong(sizeField.getText());
                String type = (String) typeComboBox.getSelectedItem();
                String resolution = resolutionField.getText();
                String duration = durationField.getText();
                File file;
                if (type.equals("Document")) {
                    file = new Document(name, size, type);
                } else if (type.equals("Image")) {
                    file = new Image(name, size, resolution);
                } else {
                    file = new Video(name, size, duration);
                }
                fileManager.addFile(file);
                addToTable(file);
                clearFields();
            }
        });
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowCount = tableModel.getRowCount();
                if (rowCount > 0) {
                    tableModel.removeRow(0);
                    if (rowCount == 1) {
                        clearFields();
                    }
                }
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name :"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Size ( in KB ) :"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("Type :"));
        inputPanel.add(typeComboBox);
        inputPanel.add(new JLabel("Resolution ( in pixels ) : "));
        inputPanel.add(resolutionField);
        inputPanel.add(new JLabel("Duration ( in minutes ) : "));
        inputPanel.add(durationField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(deleteButton);
        Container contentPane = getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    /**
     * Adds a file to the table.
     * @param file the file to be added
     */
    private void addToTable(File file) {
        Object[] rowData = new Object[5];
        rowData[0] = file.getFileName();
        rowData[1] = file.getFileSize() + " KB";
        if (file instanceof Document) {
            rowData[2] = "Document";
        } else if (file instanceof Image) {
            rowData[2] = "Image" + " pixels";
            rowData[3] = ((Image) file).getResolution();
        } else if (file instanceof Video) {
            rowData[2] = "Video" + " minutes";
            rowData[4] = ((Video) file).getDuration();
        }
        tableModel.addRow(rowData);
    }
    /**
     * Clears all the input fields.
     */
    private void clearFields() {
        nameField.setText("");
        sizeField.setText("");
        typeComboBox.setSelectedIndex(0);
        resolutionField.setText("");
        resolutionField.setBackground(Color.WHITE);
        durationField.setText("");
        durationField.setBackground(Color.WHITE);
    }
    /**
     * Adjusts the input fields based on the selected file type.
     * @param selectedType the selected file type
     */
    private void adjustFieldsBasedOnType(String selectedType) {
        if (selectedType.equals("Document")) {
            resolutionField.setEnabled(false);
            resolutionField.setText("Resolution of the selected file type cannot be entered.");
            resolutionField.setBackground(Color.BLACK);
            durationField.setEnabled(false);
            durationField.setText("Duration of the selected file type cannot be entered.");
            durationField.setBackground(Color.BLACK);
        } else if (selectedType.equals("Image")) {
            resolutionField.setEnabled(true);
            resolutionField.setText("");
            resolutionField.setBackground(Color.WHITE);
            durationField.setEnabled(false);
            durationField.setText("Duration of the selected file type cannot be entered.");
            durationField.setBackground(Color.BLACK);
        } else if (selectedType.equals("Video")) {
            resolutionField.setEnabled(false);
            resolutionField.setText("Resolution of the selected file type cannot be entered.");
            resolutionField.setBackground(Color.BLACK);
            durationField.setEnabled(true);
            durationField.setText("");
            durationField.setBackground(Color.WHITE);
        }
    }
    /**
     * The entry point of the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}