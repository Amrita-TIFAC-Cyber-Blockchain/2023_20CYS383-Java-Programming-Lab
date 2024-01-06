package com.amrita.jpl.cys21074.endsem;
/**
 * @author Sudhir.R.T
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// File class

/**
 * parent file class
 */
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

/**
 * for documents from file
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

// Image class

/**
 * for image from file
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

// Video class

/**
 * for video from file
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

// FileManager interface

/**
 * interface for file manager
 */
interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile();

    void loadFromFile();
}

// FileManagerImpl class

/**
 * implementation for file manager interface
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
            File file = files.get(i);
            if (file.getFileName().equals(fileName)) {
                files.remove(i);
                System.out.println("File " + fileName + " deleted successfully.");
                return;
            }
        }
        System.out.println("File " + fileName + " not found.");
    }

    @Override
    public void displayAllFiles() {
        if (files.isEmpty()) {
            System.out.println("No files found.");
            return;
        }
        System.out.println("File List:");
        for (File file : files) {
            file.displayFileDetails();
            System.out.println("------------------------");
        }
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("file_details.txt");
            for (File file : files) {
                writer.write(file.getFileName() + "," + file.getFileSize() + ",");
                if (file instanceof Document) {
                    writer.write("Document," + ((Document) file).getDocumentType());
                } else if (file instanceof Image) {
                    writer.write("Image," + ((Image) file).getResolution());
                } else if (file instanceof Video) {
                    writer.write("Video," + ((Video) file).getDuration());
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("File details saved to file_details.txt");
        } catch (IOException e) {
            System.out.println("Error saving file details: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file_details.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String fileName = parts[0];
                int fileSize = Integer.parseInt(parts[1]);
                String fileType = parts[2];
                if (fileType.equals("Document")) {
                    String documentType = parts[3];
                    Document document = new Document(fileName, fileSize, documentType);
                    files.add(document);
                } else if (fileType.equals("Image")) {
                    String resolution = parts[3];
                    Image image = new Image(fileName, fileSize, resolution);
                    files.add(image);
                } else if (fileType.equals("Video")) {
                    String duration = parts[3];
                    Video video = new Video(fileName, fileSize, duration);
                    files.add(video);
                }
            }
            reader.close();
            System.out.println("File details loaded from file_details.txt");
        } catch (IOException e) {
            System.out.println("Error loading file details: " + e.getMessage());
        }
    }
}
/*
class FileManagementSystemUI extends JFrame{
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public FileManagementSystemUI(){
        setTitle("21UCYS74 End Semester Assignment FIle Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);


        JTextField nameTextArea = new JTextField();
        JTextField sizeTextArea = new JTextField();

        JPanel txtPanel = new JPanel();
        txtPanel.add(nameTextArea);
        txtPanel.add(sizeTextArea);
        getContentPane().add(txtPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}*/

/**
 * main class
 */
public class end_sem {
    /**
     * Main function
     * @param args Default argument to main function
     */
    public static void main(String[] args) {
        FileManagerImpl fileManager = new FileManagerImpl();

        Document document = new Document("document.txt", 100, "Text");
        Image image = new Image("image.jpg", 500, "1920x1080");
        Video video = new Video("video.mp4", 2000, "10 minutes");

        fileManager.addFile(document);
        fileManager.addFile(image);
        fileManager.addFile(video);

        fileManager.displayAllFiles();

        fileManager.saveToFile();

        fileManager.deleteFile("image.jpg");

        fileManager.displayAllFiles();

        fileManager.loadFromFile();

        fileManager.displayAllFiles();
    }
}