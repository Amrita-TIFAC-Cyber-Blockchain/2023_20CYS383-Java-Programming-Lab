package com.amrita.jpl.cys21044.endsem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author ravi
 */
public interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}



class File {
    private String fileName;
    private long fileSize;

    /**
     *
     * @param fileName -name of the file
     * @param fileSize -size of the file
     */

    public File(String fileName, long fileSize) {
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}


class Document extends File {
    private String documentType;

    /**
     *
     * @param fileName -file name
     * @param fileSize - file size
     * @param documentType - type of the document
     */

    public Document(String fileName, long fileSize, String documentType) {
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    /**
     *
     * @param fileName - file name
     * @param fileSize -file size
     * @param resolution -resolution of file
     */

    public Image(String fileName, long fileSize, String resolution) {
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}


class Video extends File {
    private String duration;

    /**
     *
     * @param fileName -file name
     * @param fileSize -file size
     * @param duration -duration of video
     */
    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    // Getters and setters
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
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }
}


class FileManagementSystemUI {
    private JFrame frame;
    private JTextField nameTextField, sizeTextField, typeTextField, resolutionTextField, durationTextField;
    private JButton addDocumentButton, addImageButton, addVideoButton, deleteButton, displayButton;
    private JTextArea fileDetailsTextArea;

    private FileManager fileManager;


    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initialize();
    }

    private void initialize() {

        frame = new JFrame("File Management System");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(100, 10, 180, 25);
        frame.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(sizeLabel);

        sizeTextField = new JTextField();
        sizeTextField.setBounds(100, 40, 180, 25);
        frame.getContentPane().add(sizeTextField);
        sizeTextField.setColumns(10);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(typeLabel);

        typeTextField = new JTextField();
        typeTextField.setBounds(100, 70, 180, 25);
        frame.getContentPane().add(typeTextField);
        typeTextField.setColumns(10);

        JLabel resolutionLabel = new JLabel("Resolution:");
        resolutionLabel.setBounds(10, 100, 80, 25);
        frame.getContentPane().add(resolutionLabel);

        resolutionTextField = new JTextField();
        resolutionTextField.setBounds(100, 100, 180, 25);
        frame.getContentPane().add(resolutionTextField);
        resolutionTextField.setColumns(10);

        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setBounds(10, 130, 80, 25);
        frame.getContentPane().add(durationLabel);

        durationTextField = new JTextField();
        durationTextField.setBounds(100, 130, 180, 25);
        frame.getContentPane().add(durationTextField);
        durationTextField.setColumns(10);

        addDocumentButton = new JButton("Add Document");
        addDocumentButton.setBounds(10, 170, 140, 25);
        frame.getContentPane().add(addDocumentButton);
        addDocumentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDocument();
            }
        });

        addImageButton = new JButton("Add Image");
        addImageButton.setBounds(160, 170, 120, 25);
        frame.getContentPane().add(addImageButton);
        addImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addImage();
            }
        });

        addVideoButton = new JButton("Add Video");
        addVideoButton.setBounds(290, 170, 120, 25);
        frame.getContentPane().add(addVideoButton);
        addVideoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addVideo();
            }
        });

        deleteButton = new JButton("Delete File");
        deleteButton.setBounds(10, 210, 120, 25);
        frame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        displayButton = new JButton("Display Files");
        displayButton.setBounds(140, 210, 120, 25);
        frame.getContentPane().add(displayButton);
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFiles();
            }
        });



        fileDetailsTextArea = new JTextArea();
        fileDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fileDetailsTextArea);
        scrollPane.setBounds(10, 290, 460, 160);
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);
    }

    private void addDocument() {
        String name = nameTextField.getText();
        long size = Long.parseLong(sizeTextField.getText());
        String type = typeTextField.getText();
        Document document = new Document(name, size, type);
        fileManager.addFile(document);
        appendToFileDetailsTextArea("Added Document: " + name);
        clearTextFields();
        
    }

    private void addImage() {
        String name = nameTextField.getText();
        long size = Long.parseLong(sizeTextField.getText());
        String resolution = resolutionTextField.getText();
        Image image = new Image(name, size, resolution);
        fileManager.addFile(image);
        appendToFileDetailsTextArea("Added Image: " + name);
        clearTextFields();
    }

    private void addVideo() {
        String name = nameTextField.getText();
        long size = Long.parseLong(sizeTextField.getText());
        String duration = durationTextField.getText();
        Video video = new Video(name, size, duration);
        fileManager.addFile(video);
        appendToFileDetailsTextArea("Added Video: " + name);
        clearTextFields();
    }

    private void deleteFile() {
        String fileName = nameTextField.getText();
        fileManager.deleteFile(fileName);
        appendToFileDetailsTextArea("Deleted File: " + fileName);
        clearTextFields();
    }

    private void displayFiles() {
        fileDetailsTextArea.setText("");
        fileManager.displayAllFiles();
    }


    private void appendToFileDetailsTextArea(String text) {
        fileDetailsTextArea.append(text + "\n");
    }

    private void clearTextFields() {
        nameTextField.setText("");
        sizeTextField.setText("");
        typeTextField.setText("");
        resolutionTextField.setText("");
        durationTextField.setText("");
    }
}

class Main {
    public static void main(String[] args) {
        FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
    }
}
