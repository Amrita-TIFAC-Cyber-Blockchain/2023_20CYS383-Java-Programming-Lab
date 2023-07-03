package com.amrita.jpl.cys21061.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

abstract class File {
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
}

class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }
}

class Video extends File {
    private String duration;

    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}

interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void saveToFile();

    void loadFromFile();

    ArrayList<File> getFiles();
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        this.files = new ArrayList<>();
    }

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

    public void saveToFile() {
        // Implement the saveToFile method here
    }

    public void loadFromFile() {
        // Implement the loadFromFile method here
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI {
    private FileManager fileManager;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeDropdown;
    private JTable fileTable;
    private DefaultTableModel tableModel;

    public FileManagementSystemUI() {
        JFrame frame = new JFrame("21UCYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel headingLabel = new JLabel("21UCYS End Semester Assignment File Manager");
        frame.add(headingLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new FlowLayout());

        fileNameField = new JTextField(15);
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileNameField);

        fileSizeField = new JTextField(10);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(fileSizeField);

        fileTypeDropdown = new JComboBox<>(new String[]{"Document", "Image", "Video"});
        inputPanel.add(new JLabel("File Type:"));
        inputPanel.add(fileTypeDropdown);

        frame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String fileType = (String) fileTypeDropdown.getSelectedItem();

                if (fileType.equals("Document")) {
                    String documentType = JOptionPane.showInputDialog(frame, "Enter Document Type:");
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (fileType.equals("Image")) {
                    String resolution = JOptionPane.showInputDialog(frame, "Enter Resolution:");
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (fileType.equals("Video")) {
                    String duration = JOptionPane.showInputDialog(frame, "Enter Duration:");
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }

                updateFileTable();
                clearInputFields();
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    updateFileTable();
                    clearInputFields();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFileTable();
                clearInputFields();
            }
        });
        buttonPanel.add(refreshButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // File Table
        tableModel = new DefaultTableModel(new String[]{"File Name", "File Size", "File Type"}, 0);
        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        // Initialize the FileManager
        fileManager = new FileManagerImpl();
    }

    private void updateFileTable() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            String fileName = file.getFileName();
            long fileSize = file.getFileSize();
            String fileType = getFileType(file);

            tableModel.addRow(new Object[]{fileName, fileSize, fileType});
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

    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        fileTypeDropdown.setSelectedIndex(0);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
