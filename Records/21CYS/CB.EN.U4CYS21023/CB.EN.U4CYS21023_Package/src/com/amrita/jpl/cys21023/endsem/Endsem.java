package com.amrita.jpl.cys21023.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public abstract void displayFileDetails();

    public String getFileType() {
        if (this instanceof Document) {
            return "Document";
        } else if (this instanceof Image) {
            return "Image";
        } else if (this instanceof Video) {
            return "Video";
        } else {
            return "";
        }
    }
}


class Document extends File {
    public Document(String fileName, long fileSize) {
        super(fileName, fileSize);
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Document Name: " + getFileName());
        System.out.println("File Size: " + getFileSize() + " bytes");
        System.out.println();
    }
}

class Image extends File {
    public Image(String fileName, long fileSize) {
        super(fileName, fileSize);
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Image Name: " + getFileName());
        System.out.println("File Size: " + getFileSize() + " bytes");
        System.out.println();
    }
}

class Video extends File {
    public Video(String fileName, long fileSize) {
        super(fileName, fileSize);
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Video Name: " + getFileName());
        System.out.println("File Size: " + getFileSize() + " bytes");
        System.out.println();
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
            System.out.println("File " + fileName + " deleted.");
        } else {
            System.out.println("File " + fileName + " not found.");
        }
    }



    @Override
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("save_file.txt"))) {
            for (File file : files) {
                if (file instanceof Document) {
                    Document document = (Document) file;
                    writer.write("Document :" + document.getFileName() + ":" + document.getFileSize());
                } else if (file instanceof Image) {
                    Image image = (Image) file;
                    writer.write("Image :" + image.getFileName() + ":" + image.getFileSize());
                } else if (file instanceof Video) {
                    Video video = (Video) file;
                    writer.write("Video : " + video.getFileName() + ":" + video.getFileSize());
                }
                writer.newLine();
            }
            System.out.println("Saved.");
        } catch (IOException e) {
            System.out.println("Error :  " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("save_file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 3) {
                    String fileType = parts[0];
                    String fileName = parts[1];
                    long fileSize = Long.parseLong(parts[2]);

                    switch (fileType) {
                        case "Document":
                            files.add(new Document(fileName, fileSize));
                            break;
                        case "Image":
                            files.add(new Image(fileName, fileSize));
                            break;
                        case "Video":
                            files.add(new Video(fileName, fileSize));
                            break;
                    }
                }
            }
            System.out.println("Loaded save_file.txt.");
        } catch (IOException e) {
            System.out.println("Error :  " + e.getMessage());
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI {
    private JFrame frame;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeComboBox;
    private JButton addButton;
    private JButton deleteButton;
    private JButton refreshButton;

    private FileManager fileManager;
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initialize();
    }
    private void initialize() {
        frame = new JFrame("21UCYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nameLabel = new JLabel("File Name:");
        fileNameField = new JTextField(10);
        JLabel sizeLabel = new JLabel("File Size:");
        fileSizeField = new JTextField(10);
        JLabel typeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});

        inputPanel.add(nameLabel);
        inputPanel.add(fileNameField);
        inputPanel.add(sizeLabel);
        inputPanel.add(fileSizeField);
        inputPanel.add(typeLabel);
        inputPanel.add(fileTypeComboBox);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add File");
        deleteButton = new JButton("Delete File");
        refreshButton=new JButton("Refresh");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });


        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        fileTable = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(fileTable);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addFile() {
        String fileName = fileNameField.getText();
        long fileSize = Long.parseLong(fileSizeField.getText());
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        File file;
        switch (fileType) {
            case "Document":
                file = new Document(fileName, fileSize);
                break;
            case "Image":
                file = new Image(fileName, fileSize);
                break;
            case "Video":
                file = new Video(fileName, fileSize);
                break;
            default:
                file = null;
        }

        if (file != null) {
            fileManager.addFile(file);
            tableModel.addRow(new Object[]{fileName, fileSize, fileType});
            clearInputFields();
            fileManager.saveToFile();
        } else {
            JOptionPane.showMessageDialog(frame, "Not a valid type", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void deleteFile() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String) tableModel.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            tableModel.removeRow(selectedRow);
        }
    }



    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
    }



    private String getFileType(File file) {
        if (file instanceof Document) {
            return "Document";
        } else if (file instanceof Image) {
            return "Image";
        } else if (file instanceof Video) {
            return "Video";
        } else {
            return "";
        }
    }
}

public class Endsem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}

