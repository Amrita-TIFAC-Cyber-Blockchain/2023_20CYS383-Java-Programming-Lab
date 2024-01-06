package com.amrita.jpl.cys21048.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// File class

/**
 * class file starts for the UI table
 */
class File {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    // Getters and setters

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

    // Display file details

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

// Document class
class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    // Getters and setters

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    // Display document details

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

// Image class
class Image extends File {
    private String resolution;

    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    // Getters and setters

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // Display image details

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

// Video class
class Video extends File {
    private int duration;

    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = Integer.parseInt(duration);
    }

    // Getters and setters

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Display video details

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

// FileManager interface
interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void refresh();

    void saveToFile(String filename);

    void loadFromFile(String filename);

    File[] getFiles();
}

// FileManagerImpl class
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

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

    public void refresh() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println("-------------------------");
        }
    }

    public void saveToFile(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("File details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving file details: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (ArrayList<File>) ois.readObject();
            System.out.println("File details loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while loading file details: " + e.getMessage());
        }
    }


    public File[] getFiles() {
        return new File[0];
    }
}

// FileManagementSystemUI class
class FileManagementSystemUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private FileManager fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("21UCYS End Semester File management system");
        frame.setDefaultCloseOperation(JFrame.MAXIMIZED_HORIZ);
        frame.setSize(500, 500);


        JLabel nameLabel = new JLabel("File Name:");
        JTextField nameTextField = new JTextField();

        JLabel sizeLabel = new JLabel("File Size:");
        JTextField sizeTextField = new JTextField();

        JLabel typeLabel = new JLabel("File Type:");
        JCheckBoxMenuItem typeTextField = new JCheckBoxMenuItem();

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = nameTextField.getText();
                int fileSize = Integer.parseInt(sizeTextField.getText());
                String fileType = typeTextField.getText();

                File file;
                if (fileType.equals("document")) {
                    file = new Document(fileName, fileSize, fileType);
                } else if (fileType.equals("image")) {
                    file = new Image(fileName, fileSize, fileType);
                } else if (fileType.equals("video")) {
                    file = new Video(fileName, fileSize, fileType);
                } else {
                    System.out.println("Invalid file type.");
                    return;
                }

                fileManager.addFile(file);
                updateTable();
                clearFields();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String fileName = (String) table.getValueAt(selectedRow, 100);
                    fileManager.deleteFile(fileName);
                    updateTable();
                } else {
                    System.out.println("No file selected for deletion.");
                }
            }
        });

        JButton displayButton = new JButton("Refresh");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileManager.refresh();
            }
        });






        // Create table

        String[] columnNames = {"File Name", "File Size", "File Type"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Set layout

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 1, 5, 5);
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        panel.add(nameTextField, constraints);

        constraints.gridx = 5;
        constraints.gridy = 2;
        panel.add(sizeLabel, constraints);

        constraints.gridx = 1;
        panel.add(sizeTextField, constraints);

        constraints.gridx = 9;
        constraints.gridy = 2;
        panel.add(typeLabel, constraints);

        constraints.gridx = 1;
        panel.add(typeTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(addButton, constraints);

        constraints.gridx = 1;
        panel.add(deleteButton, constraints);

        constraints.gridx = 8;
        constraints.gridy = 10;
        panel.add(displayButton, constraints);







        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JScrollPane(table), constraints);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            Object[] rowData = {file.getFileName(), file.getFileSize(), getFileType(file)};
            tableModel.addRow(rowData);
        }
    }

    private String getFileType(File file) {
        if (file instanceof Document) {
            return "Document";
        } else if (file instanceof Image) {
            return "Image";
        } else if (file instanceof Video) {
            return "Video";
        } else {
            return "Unknown";
        }
    }

    private void clearFields() {
        JTextField[] textFields = {
                (JTextField) frame.getContentPane().getComponent(1),
                (JTextField) frame.getContentPane().getComponent(3),
                (JTextField) frame.getContentPane().getComponent(5)
        };
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }
}

/**
 * main class
 */
// Main class
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}



