package com.amrita.jpl.cys21087.endsem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* file class that takes has filename, filesize and display file details functions
* */
class File {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + " KB");
    }
}

/**
 * class for document that extends file
 */
class Document extends File {
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
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

/**
 * class for image that extends file
 */
class Image extends File {
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
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

/**
 * class for file that extends file
 */
class Video extends File {
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
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

/**
 * interface for addFile, deleteFile, and DisplayAllFiles
 */
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    ArrayList<File> getFiles();
}

/**
 * class for implementation of file manager
 */
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }


    @Override
    public ArrayList<File> getFiles() {
        return files;
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
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println("------------------------");
        }
    }

}

/**
 * class for file management UI that has input panel, button panel, clear fields and refresh/display existing files
 */
class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JTextField fileTypeField;
    private JTextField attributeField;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        fileNameField = new JTextField(15);
        fileSizeField = new JTextField(10);
        fileTypeField = new JTextField(15);
        attributeField = new JTextField(15);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        JButton refreshButton = new JButton("Refresh ");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllFiles();
            }
        });

        inputPanel.add(new JLabel("File Name: "));
        inputPanel.add(fileNameField);
        inputPanel.add(new JLabel("File Size: "));
        inputPanel.add(fileSizeField);
        inputPanel.add(new JLabel("File Type: "));
        inputPanel.add(fileTypeField);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addFile() {
        String fileName = fileNameField.getText();
        int fileSize = Integer.parseInt(fileSizeField.getText());
        String attribute = fileTypeField.getText();

        if (attribute.equalsIgnoreCase("document")) {
            String documentType = JOptionPane.showInputDialog(this, "Enter Document Type:");
            Document document = new Document(fileName, fileSize, documentType);
            fileManager.addFile(document);
        } else if (attribute.equalsIgnoreCase("image")) {
            String resolution = JOptionPane.showInputDialog(this, "Enter Resolution:");
            Image image = new Image(fileName, fileSize, resolution);
            fileManager.addFile(image);
        } else if (attribute.equalsIgnoreCase("video")) {
            String duration = JOptionPane.showInputDialog(this, "Enter Duration:");
            Video video = new Video(fileName, fileSize, duration);
            fileManager.addFile(video);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Attribute!");
            return;
        }

        clearFields();
        updateTable();
    }

    private void deleteFile() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String fileName = (String) table.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to delete!");
        }
    }

    private void displayAllFiles() {
        fileManager.displayAllFiles();
    }

    private void clearFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        fileTypeField.setText("");
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), document.getDocumentType()});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "image"});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "video"});
            }
        }
    }
}

/**
 * this is the main class
 */
public class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}



