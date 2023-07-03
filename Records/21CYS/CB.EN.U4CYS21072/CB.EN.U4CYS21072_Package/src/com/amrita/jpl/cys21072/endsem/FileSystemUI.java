package com.amrita.jpl.cys21072.endsem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.io.*;
/**
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */

abstract class File {
    private String fileName;
    private long fileSize;
    /**
     * The abstract class representing a file.
     *
     * @param fileName The name of the file.
     * @param fileSize The size of the file in bytes.
     */
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

    public abstract void displayFileDetails();
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

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    /**
     * Displays the details of the document file.
     */

    public void displayFileDetails() {
        System.out.println("Name of the Document: " + getFileName());
        System.out.println("Type of the Document:  " + getDocumentType());
        System.out.println("Size of the Document: " + getFileSize() + " bytes");
        System.out.println();
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

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    /**
     * Displays the details of the image file.
     */
    public void displayFileDetails() {
        System.out.println("Name of the Image: " + getFileName());
        System.out.println("Size of the Image: " + getFileSize() + " bytes");
        System.out.println("Resolution of the Image: " + getResolution());
        System.out.println();
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

    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Displays the details of the video file.
     */
    public void displayFileDetails() {
        System.out.println("Video Name: " + getFileName());
        System.out.println("Video Size: " + getFileSize() + " bytes");
        System.out.println("Video Duration: " + getDuration());
        System.out.println();
    }
}
/**
 * The FileManager interface provides methods for managing files.
 */
interface FileManager {
    /**
     * Adds a file to the file manager.
     *
     * @param file The file to be added.
     */
    void addFile(File file);
    /**
     * Deletes a file from the file manager based on the file name.
     *
     * @param fileName The name of the file to be deleted.
     */
    void deleteFile(String fileName);
    /**
     * Saves the file manager data to a file.
     */
    void saveToFile();
    /**
     * Loads the file manager data from a file.
     */
    void loadFromFile();
    /**
     * Retrieves the list of files managed by the file manager.
     *
     * @return The list of files.
     */
    ArrayList<File> getFiles();
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;
    public FileManagerImpl() {
        files = new ArrayList<>();
    }


    public void addFile(File file) {
        files.add(file);
    }


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
        }
    }

    /**
     * Refreshes the file manager.
     */
    public void refresh(){}

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("fileManager.txt"))) {
            for (File file : files) {
                if (file instanceof Document) {
                    Document document = (Document) file;
                    writer.println("Document," + document.getFileName() + "," + document.getFileSize() + "," + document.getDocumentType());
                } else if (file instanceof Image) {
                    Image image = (Image) file;
                    writer.println("Image," + image.getFileName() + "," + image.getFileSize() + "," + image.getResolution());
                } else if (file instanceof Video) {
                    Video video = (Video) file;
                    writer.println("Video," + video.getFileName() + "," + video.getFileSize() + "," + video.getDuration());
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadFromFile() {
        files.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("fileManager.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String fileType = parts[0];
                String fileName = parts[1];
                long fileSize = Long.parseLong(parts[2]);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nameTextField, sizeTextField;
    private JButton addButton, deleteButton, refreshButton;
    private ComboBoxModel<Object> selectField;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("21CYS End Semester Assignment File Manager");
        setSize(900, 300);

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);

        nameTextField = new JTextField();
        sizeTextField = new JTextField();

        DefaultComboBoxModel<String> selectField = new DefaultComboBoxModel<>();
        selectField.addElement("Document");
        selectField.addElement("Image");
        selectField.addElement("Video");

        addButton = new JButton("Add File");
        deleteButton = new JButton("Delete File");
        JButton refreshButton = new JButton("Refresh");



        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel inputPanel = new JPanel(new GridLayout(1, 3));
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(sizeTextField);
        inputPanel.add(new JLabel("File Type:"));



        JScrollPane scrollPane = new JScrollPane(table);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);


        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = nameTextField.getText();
                long fileSize = Long.parseLong(sizeTextField.getText());
                String details = (String) selectField.getSelectedItem();

                if (details.startsWith("Document")) {
                    String documentType = details.substring(details.indexOf(',') + 1);
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (details.startsWith("Image")) {
                    String resolution = details.substring(details.indexOf(',') + 1);
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (details.startsWith("Video")) {
                    String duration = details.substring(details.indexOf(',') + 1);
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }

                updateTable();
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = table.getValueAt(selectedRow, 1).toString();
                    fileManager.deleteFile(fileName);
                    updateTable();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void updateTable() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            String fileType = getFileType(file);
            String fileName = file.getFileName();
            long fileSize = file.getFileSize();
            tableModel.addRow(new Object[]{fileType, fileName, fileSize});
        }
    }

    private String getFileType(File file) {
        if (file instanceof Document) {
            return "Document";
        } else if (file instanceof Image) {
            return "Image";
        } else if (file instanceof Video) {
            return "Video";
        }
        return "";
    }

    private void clearFields() {
        nameTextField.setText("");
        sizeTextField.setText("");
        selectField.setSelectedItem("");
    }
}

public class FileSystemUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}




