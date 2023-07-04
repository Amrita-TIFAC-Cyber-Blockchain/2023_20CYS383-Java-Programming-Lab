package com.amrita.jpl.cys21089.endsem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Yaswanth Gadamsetti
 * @contributor Vishnu K
 * @version 2.0
 * */

/**
* file class that takes has filename, filesize and display file details functions
* */
class File1 {
    private String fileName;
    private int fileSize;

    public File1(String fileName, int fileSize) {
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
class Document1 extends File1 {
    private String documentType;

    public Document1(String fileName, int fileSize, String documentType) {
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
class Image1 extends File1 {
    private String resolution;

    public Image1(String fileName, int fileSize, String resolution) {
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
class Video1 extends File1 {
    private String duration;

    public Video1(String fileName, int fileSize, String duration) {
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
interface FileManager1 {
    void addFile(File1 file);
    void deleteFile(String fileName);
    void displayAllFiles();
    ArrayList<File1> getFiles();
}

/**
 * class for implementation of file manager
 */
class FileManagerImpl1 implements FileManager1 {
    private ArrayList<File1> files;

    public FileManagerImpl1() {
        files = new ArrayList<>();
    }


    @Override
    public ArrayList<File1> getFiles() {
        return files;
    }


    @Override
    public void addFile(File1 file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        File1 fileToDelete = null;
        for (File1 file : files) {
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
        for (File1 file : files) {
            file.displayFileDetails();
            System.out.println("------------------------");
        }
    }

}

/**
 * class for file management UI that has input panel, button panel, clear fields and refresh/display existing files
 */
class FileManagementSystemUI extends JFrame {
    private FileManager1 fileManager1;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox fileTyeField ;
    private JTextField attributeField;

    public FileManagementSystemUI() {
        fileManager1 = new FileManagerImpl1();
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
        String[] options = {"Document", "Image", "Video"};
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTyeField = new JComboBox<String>(options);
        inputPanel.add(fileTypeLabel);
        inputPanel.add(fileTyeField);
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
        String attribute = String.valueOf(fileTyeField.getSelectedItem());

        if (attribute.equalsIgnoreCase("Document")) {
            String documentType = JOptionPane.showInputDialog(this, "Enter Document Type:");
            Document1 document = new Document1(fileName, fileSize, documentType);
            fileManager1.addFile(document);
        } else if (attribute.equalsIgnoreCase("Image")) {
            String resolution = JOptionPane.showInputDialog(this, "Enter Resolution:");
            Image1 image = new Image1(fileName, fileSize, resolution);
            fileManager1.addFile(image);
        } else if (attribute.equalsIgnoreCase("Video")) {
            String duration = JOptionPane.showInputDialog(this, "Enter Duration:");
            Video1 video = new Video1(fileName, fileSize, duration);
            fileManager1.addFile(video);
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
            fileManager1.deleteFile(fileName);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to delete!");
        }
    }

    private void displayAllFiles() {
        fileManager1.displayAllFiles();
    }

    private void clearFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File1 file : fileManager1.getFiles()) {
            if (file instanceof Document1) {
                Document1 document = (Document1) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), document.getDocumentType()});
            } else if (file instanceof Image1) {
                Image1 image = (Image1) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "image"});
            } else if (file instanceof Video1) {
                Video1 video = (Video1) file;
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



