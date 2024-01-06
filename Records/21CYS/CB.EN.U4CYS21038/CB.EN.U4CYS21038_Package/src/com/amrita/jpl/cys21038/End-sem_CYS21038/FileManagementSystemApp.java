//package com.amrita.jpl21CYS21038.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Madhav Harikumar
 */

/**
 * Abstract com.amrita.jpl21CYS21038.endsem.File Class
 */
abstract class File {
    private String fileName;
    private long fileSize;

    /**
     * com.amrita.jpl21CYS21038.endsem.File Constructor
     * @param fileName name of the file
     * @param fileSize size of the file
     */
    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    /**
     * Getting the com.amrita.jpl21CYS21038.endsem.File Name
     * @return filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Getting the com.amrita.jpl21CYS21038.endsem.File Size
     * @return filesize
     */
    public long getFileSize() {
        return fileSize;
    }
}

/**
 * Class com.amrita.jpl21CYS21038.endsem.Document
 */
class Document extends File {
    private String documentType;

    /**
     * com.amrita.jpl21CYS21038.endsem.Document object constructor
     * @param fileName name of the file
     * @param fileSize size of the file
     * @param type file type
     */
    public Document(String fileName, long fileSize, String type) {
        super(fileName, fileSize);
        this.documentType = type;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}

/**
 * Class com.amrita.jpl21CYS21038.endsem.Image
 */

class Image extends File {
    private String resolution;

    /**
     * com.amrita.jpl21CYS21038.endsem.Image object constructor
     * @param fileName name of the file
     * @param fileSize size of the file
     * @param resolution file resolution in pixels
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
}

/**
 * Class com.amrita.jpl21CYS21038.endsem.Video
 */
class Video extends File {
    private int duration;

    /**
     * com.amrita.jpl21CYS21038.endsem.Video object Constructor
     * @param fileName name of the file
     * @param fileSize size of the file
     * @param duration duration of the video in seconds
     */
    public Video(String fileName, long fileSize, int duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

/**
 * Interface for com.amrita.jpl21CYS21038.endsem.FileManager
 */
interface FileManager {
    /**
     * Adding com.amrita.jpl21CYS21038.endsem.File declaration
     * @param file file
     */
    void addFile(File file);

    /**
     * Deleting com.amrita.jpl21CYS21038.endsem.File declaration
     * @param fileName fileName
     */
    void deleteFile(String fileName);

    /**
     * Function to save file
     */

    void saveToFile();

    /**
     * Function to load from file
     */

    void loadFromFile();

    ArrayList<File> getFiles();
}

/**
 * Class com.amrita.jpl21CYS21038.endsem.FileManager implementing the Interface
 */
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
            File f = files.get(i);
            if (f.getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    @Override
    public void saveToFile() {
        // Nothing
    }

    @Override
    public void loadFromFile() {
        // Nothing
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }
}

/**
 * UI for FileManagementSystem
 */
class FileManagementSystemUI {
    private JFrame frame;
    private JTextField fileNameTextField;
    private JTextField fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;
    private JButton addButton;
    private JButton deleteButton;
    private JButton displayButton;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private FileManager fileManager;

    /**
     * Constructor for the class com.amrita.jpl21CYS21038.endsem.FileManagementSystemUI
     */

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        start();
    }

    /**
     * Starts to display the UI of the Application
     */
    private void start() {
        frame = new JFrame("com.amrita.jpl21CYS21038.endsem.File Management System");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel fileNameLabel = new JLabel("com.amrita.jpl21CYS21038.endsem.File Name:");
        inputPanel.add(fileNameLabel);

        fileNameTextField = new JTextField();
        inputPanel.add(fileNameTextField);
        fileNameTextField.setColumns(10);

        JLabel fileSizeLabel = new JLabel("com.amrita.jpl21CYS21038.endsem.File Size:");
        inputPanel.add(fileSizeLabel);

        fileSizeTextField = new JTextField();
        inputPanel.add(fileSizeTextField);
        fileSizeTextField.setColumns(10);

        JLabel fileTypeLabel = new JLabel("com.amrita.jpl21CYS21038.endsem.File Type:");
        inputPanel.add(fileTypeLabel);

        String[] fileTypeOptions = {"com.amrita.jpl21CYS21038.endsem.Document", "com.amrita.jpl21CYS21038.endsem.Image", "com.amrita.jpl21CYS21038.endsem.Video"};
        fileTypeComboBox = new JComboBox<>(fileTypeOptions);
        inputPanel.add(fileTypeComboBox);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton = new JButton("Add com.amrita.jpl21CYS21038.endsem.File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = fileNameTextField.getText();
                long fSize = Long.parseLong(fileSizeTextField.getText());
                String fType = (String) fileTypeComboBox.getSelectedItem();

                if (fType.equalsIgnoreCase("document")) {
                    String docType = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl21CYS21038.endsem.Document Type: ");
                    Document document = new Document(fName, fSize, docType);
                    fileManager.addFile(document);
                } else if (fType.equalsIgnoreCase("image")) {
                    String resolution = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl21CYS21038.endsem.Image Resolution:");
                    Image image = new Image(fName, fSize, resolution);
                    fileManager.addFile(image);
                } else if (fType.equalsIgnoreCase("video")) {
                    int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl21CYS21038.endsem.Video Duration (in seconds):"));
                    Video video = new Video(fName, fSize, duration);
                    fileManager.addFile(video);
                }
                clearInputFields();
                refreshTable();
            }
        });
        buttonPanel.add(addButton);

        deleteButton = new JButton("Delete com.amrita.jpl21CYS21038.endsem.File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = fileNameTextField.getText();
                fileManager.deleteFile(fName);
                clearInputFields();
            }
        });
        buttonPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        buttonPanel.add(refreshButton);
        // Table
        String[] columnNames = {"FileName", "FileSize", "FileType"};
        tableModel = new DefaultTableModel(columnNames, 0);
        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Clears Input Fields being typed by the User
     */
    private void clearInputFields() {
        fileNameTextField.setText("");
        fileSizeTextField.setText("");
    }

    /**
     * Refreshes the Table
     */
    private void refreshTable() {
        ArrayList<File> files = fileManager.getFiles();
        tableModel.setRowCount(0);
        for (File f : files) {
            String fName = f.getFileName();
            long fSize = f.getFileSize();
            String fType = getFileType(f);
            Object[] L = {fName, fSize, fType};
            tableModel.addRow(L);
        }
    }

    /**
     * Returns the type of the file
     * @param file the file
     * @return type of the file
     */
    private String getFileType(File file) {
        if (file instanceof Document) {
            return "com.amrita.jpl21CYS21038.endsem.Document";
        } else if (file instanceof Image) {
            return "com.amrita.jpl21CYS21038.endsem.Image";
        } else if (file instanceof Video) {
            return "com.amrita.jpl21CYS21038.endsem.Video";
        } else {
            return "Nothing";
        }
    }
}

// Main class

/**
 * The main class for com.amrita.jpl21CYS21038.endsem.File Management System application
 */
public class FileManagementSystemApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
