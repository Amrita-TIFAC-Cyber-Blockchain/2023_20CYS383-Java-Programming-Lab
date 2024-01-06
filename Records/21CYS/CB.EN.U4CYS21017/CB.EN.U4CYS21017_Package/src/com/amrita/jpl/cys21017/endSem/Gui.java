package com.amrita.jpl.cys21017.endSem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.io.*;

// File class
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

    // Override displayFileDetails method
    @Override
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

    // Override displayFileDetails method
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

// Video class
class Video extends File {
    private int duration;

    public Video(String fileName, int fileSize, int duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    // Getters and setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Override displayFileDetails method
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

// FileManager interface
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}

// FileManagerImpl class implementing FileManager interface
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    // Implement methods from the FileManager interface
    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    public void saveToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (File file : files) {
                writer.println(file.getClass().getSimpleName());
                writer.println(file.getFileName());
                writer.println(file.getFileSize());
                if (file instanceof Document) {
                    writer.println(((Document) file).getDocumentType());
                } else if (file instanceof Image) {
                    writer.println(((Image) file).getResolution());
                } else if (file instanceof Video) {
                    writer.println(((Video) file).getDuration());
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String fileType = line.trim();
                String fileDetails = reader.readLine();
                int fileSize = Integer.parseInt(reader.readLine());
                if (fileType.equals("Document")) {
                    String documentType = reader.readLine();
                    Document document = new Document(fileDetails, fileSize, documentType);
                    files.add(document);
                } else if (fileType.equals("Image")) {
                    String resolution = reader.readLine();
                    Image image = new Image(fileDetails, fileSize, resolution);
                    files.add(image);
                } else if (fileType.equals("Video")) {
                    int duration = Integer.parseInt(reader.readLine());
                    Video video = new Video(fileDetails, fileSize, duration);
                    files.add(video);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
}

// FileManagementSystemUI class with Swing-based user interface
class FileManagementSystemUI {
    private JFrame frame;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> documentTypeComboBox;
    private DefaultTableModel tableModel;
    private JTable table;
    private FileManagerImpl fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("21CYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel fileDetailsPanel = new JPanel(new GridLayout(1, 3));
        fileDetailsPanel.add(new JLabel("File Name:"));
        fileNameField = new JTextField();
        fileDetailsPanel.add(fileNameField);
        fileDetailsPanel.add(new JLabel("File Size:"));
        fileSizeField = new JTextField();
        fileDetailsPanel.add(fileSizeField);
        fileDetailsPanel.add(new JLabel("File Type:"));
        documentTypeComboBox = new JComboBox<>(new String[]{"Image", "Video", "Document"});
        fileDetailsPanel.add(documentTypeComboBox);

        JPanel buttonsPanel = new JPanel();
        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });
        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFiles();
            }
        });

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(saveButton);
        buttonsPanel.add(refreshButton);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(fileDetailsPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addFile() {
        String fileName = fileNameField.getText();
        String fileSizeStr = fileSizeField.getText();

        if (fileName.isEmpty() || fileSizeStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter file name and size.");
            return;
        }

        int fileSize;
        try {
            fileSize = Integer.parseInt(fileSizeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid file size. Please enter a numeric value.");
            return;
        }

        String fileType = documentTypeComboBox.getSelectedItem().toString();

        if (fileType.equals("Document")) {
            String[] options = {"PDF", "DOC", "TXT"};
            int option = JOptionPane.showOptionDialog(frame, "Select document type:", "Document Type",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (option == JOptionPane.CLOSED_OPTION) {
                return;
            }

            String documentType = options[option];
            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
        } else if (fileType.equals("Image")) {
            String resolution = JOptionPane.showInputDialog(frame, "Enter the resolution:");
            if (resolution == null || resolution.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter resolution.");
                return;
            }
            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
        } else if (fileType.equals("Video")) {
            String durationStr = JOptionPane.showInputDialog(frame, "Enter the duration (in seconds):");
            if (durationStr == null || durationStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter duration.");
                return;
            }

            int duration;
            try {
                duration = Integer.parseInt(durationStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid duration. Please enter a numeric value.");
                return;
            }
            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);
        }

        fileNameField.setText("");
        fileSizeField.setText("");

        displayFiles();
    }

    private void deleteFile() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
            return;
        }

        String fileName = table.getValueAt(selectedRow, 0).toString();
        fileManager.deleteFile(fileName);
        tableModel.removeRow(selectedRow);
    }

    private void displayFiles() {
        tableModel.setRowCount(0);

        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            String fileName = file.getFileName();
            int fileSize = file.getFileSize();
            String fileType = "";

            if (file instanceof Document) {
                fileType = "Document";
            } else if (file instanceof Image) {
                fileType = "Image";
            } else if (file instanceof Video) {
                fileType = "Video";
            }

            tableModel.addRow(new Object[]{fileName, fileSize, fileType});
        }
    }

    private void saveToFile() {
        String fileName = JOptionPane.showInputDialog(frame, "Enter the file name to save:");

        if (fileName != null && !fileName.isEmpty()) {
            fileManager.saveToFile(fileName);
            JOptionPane.showMessageDialog(frame, "File details saved successfully.");
        }
    }

    private void loadFromFile() {
        String fileName = JOptionPane.showInputDialog(frame, "Enter the file name to load:");

        if (fileName != null && !fileName.isEmpty()) {
            fileManager.loadFromFile(fileName);
            displayFiles();
            JOptionPane.showMessageDialog(frame, "File details loaded successfully.");
        }
    }
}

// Main class
public class Gui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
