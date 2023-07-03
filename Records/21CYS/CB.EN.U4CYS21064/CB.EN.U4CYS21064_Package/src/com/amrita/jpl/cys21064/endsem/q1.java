package com.amrita.jpl.cys21064.endsem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Rajendraprasad S
 */

// File class
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + "KB");
    }
}

// Document class

class Document extends File implements Serializable{
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

// Image class
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

// Video class
class Video extends File {
    private int duration;

    public Video(String fileName, int fileSize, int duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration + " minutes");
    }
}

// FileManager interface
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile();
    void loadFromFile();
}

// FileManagerImpl class
class FileManagerImpl implements FileManager {
    ArrayList<File> files = new ArrayList<>();

    @Override
    public void addFile(File file) {
        files.add(file);
        saveToFile();
    }

    @Override
    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
        saveToFile();
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    @Override
    public void saveToFile() {

        try (FileOutputStream fileOutputStream = new FileOutputStream("files.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(files);
            System.out.println("File details saved to files.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream("files.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            files = (ArrayList<File>) objectInputStream.readObject();
            System.out.println("File details loaded from files.txt");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// FileManagementSystemUI class
class FileManagementSystemUI extends JFrame {
    private JTextField fileNameTextField, fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private FileManager fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();

        fileManager.loadFromFile();
        // Set up JFrame
        setTitle("21UCYS End Semester Assignment File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameTextField = new JTextField(15);
        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeTextField = new JTextField(10);
        JLabel fileTypeLabel = new JLabel("File Type:");
        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeComboBox = new JComboBox<>(fileTypes);

        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameTextField);
        inputPanel.add(fileSizeLabel);
        inputPanel.add(fileSizeTextField);
        inputPanel.add(fileTypeLabel);
        inputPanel.add(fileTypeComboBox);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add File");

        JButton refresh = new JButton("Refresh");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
                int fileSize = Integer.parseInt(fileSizeTextField.getText());
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                switch (fileType) {
                    case "Document":
                        String documentType = JOptionPane.showInputDialog("Enter Document Type:");
                        Document document = new Document(fileName, fileSize, documentType);
                        fileManager.addFile(document);
                        break;
                    case "Image":
                        String resolution = JOptionPane.showInputDialog("Enter Resolution:");
                        Image image = new Image(fileName, fileSize, resolution);
                        fileManager.addFile(image);
                        break;
                    case "Video":
                        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Duration (minutes):"));
                        Video video = new Video(fileName, fileSize, duration);
                        fileManager.addFile(video);
                        break;
                }

                updateTable();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    updateTable();
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refresh);

        // Create table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        String[] columnNames = {"File Name", "File Size", "File Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add components to JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(tablePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File file : ((FileManagerImpl) fileManager).files) {
            Object[] rowData = {file.getFileName(), file.getFileSize(), file.getClass().getSimpleName()};
            tableModel.addRow(rowData);
        }
    }
}

// Main class
public class q1 {
    public static void main(String[] args) {
        new FileManagementSystemUI();
    }
}
