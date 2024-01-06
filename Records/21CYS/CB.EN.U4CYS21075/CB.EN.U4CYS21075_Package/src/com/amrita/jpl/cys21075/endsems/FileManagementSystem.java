package com.amrita.jpl.cys21075.endsems;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

abstract class File {
    private String fileName;
    private double fileSize;

    public File(String fileName, double fileSize){
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() { return this.fileName; }
    public double getFileSize() { return this.fileSize; }

    public double getFiles() { return this.fileSize; }

    public void setFileName(String name) { this.fileName = name; }
    public void setFileSize(double size) { this.fileSize = size; }

    public void setFiles(String name) { this.fileName = name; }

    public abstract void displayFileDetails();
}

//Document.java (class):


class Document extends File {
    private String documentType;

    public Document(String fileName, double fileSize, String documentType){
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() { return this.documentType; }
    public void setDocumentType(String type) { this.documentType = type; }

    @Override
    public void displayFileDetails() {
        System.out.println("Document: " + getFileName() + ", Size: " + getFileSize() + ", Type: " + getDocumentType());
    }
}

//Image.java (class):

class Image extends File {
    private String resolution;

    public Image(String fileName, double fileSize, String resolution){
        super(fileName, fileSize);
        this.resolution=resolution;
    }

    public String getresolution() { return this.resolution; }
    public void setDocumentType(String type) { this.resolution = type; }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + getFileName() + ", File Size: " + getFileSize() + ", Resolution: " + getresolution());
    }
}


class Video extends File {
    private double duration;

    public Video(String fileName, double fileSize, double duration){
        super(fileName, fileSize);
        this.duration=duration;
    }

    public double getduration() { return this.duration; }
    public void setduration(String type) { this.duration = Double.parseDouble(type); }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + getFileName() + ", File Size: " + getFileSize() + ", Duration: " + getduration());
    }
}

//Interface Filemanager (Interface):

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}



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
        Iterator<File> it = files.iterator();
        while(it.hasNext()) {
            File f = it.next();
            if(f.getFileName().equals(fileName)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File f : files) {
            f.displayFileDetails();
        }
    }
}

//FileManagementSystemUI.java (class):


class FileManagementSystemUI extends JFrame {
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private JTextField fileNameField, fileSizeField;
    private JComboBox<String> fileTypeBox;
    public FileManagementSystemUI() {
        new FileManagerImpl();

        setTitle("21UCYS End Semester Assignment File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel(new BorderLayout());


        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);

        panel.add(scrollPane, BorderLayout.CENTER);


        JPanel inputPanel = new JPanel();

        fileNameField = new JTextField(10);
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileNameField);

        fileSizeField = new JTextField(10);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(fileSizeField);

        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeBox = new JComboBox<>(fileTypes);
        inputPanel.add(new JLabel("File Type:"));
        inputPanel.add(fileTypeBox);

        JButton addFileButton = new JButton("Add File");
        addFileButton.addActionListener(e -> {

            tableModel.addRow(new Object[]{
                    fileNameField.getText(),
                    fileSizeField.getText(),
                    fileTypeBox.getSelectedItem().toString()
            });

        });

        JButton deleteFileButton = new JButton("Delete File");
        deleteFileButton.addActionListener(e -> {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {

                tableModel.removeRow(selectedRow);

            } else {
                JOptionPane.showMessageDialog(
                        FileManagementSystemUI.this,
                        "Please select a file to delete.",
                        "Delete File",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        inputPanel.add(addFileButton);
        inputPanel.add(deleteFileButton);

        panel.add(inputPanel, BorderLayout.SOUTH);


        add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileManagementSystemUI::new);
    }
}



public class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI().setVisible(true);
            }
        });
    }
}
