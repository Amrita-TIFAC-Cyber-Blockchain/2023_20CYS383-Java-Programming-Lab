package com.amrita.jpl.cys21033.ENDSEM;




import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Suhitha K cb.en.u4cys21033
 */
abstract class File {
    private String fileName;
    private int fileSize;

    /**
     * @param fileName Name of the file that we are adding it is a abstract class variable
     * @param fileSize Size of the file that we are adding it is a abstract class variable
     */
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

    /**
     *
     * @param fileSize Size of the file that we are adding
     */
    public void setFileSize(int fileSize) {
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
     * @param fileName name of the file that we are adding
     * @param fileSize size of the file that we are entering in UI
     * @param documentType Type of the document that we are adding like pdf or docx.... in case type of file is document
     */
    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    /**
     *
     * @param documentType it sets the type of the document that we gave
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Document Type: " + documentType);
        super.displayFileDetails();
    }
}

class Image extends File {
    private String resolution;

    /**
     *
     * @param fileName Name of the file that we are adding in GUI
     * @param fileSize Size of the file
     * @param resolution Resolution of teh picture in case type of file is image
     */
    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    /**
     *
     * @param resolution resolution of the image we enter in popup dialog box
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Resolution: " + resolution);
        super.displayFileDetails();
    }
}

class Video extends File {
    private String duration;

    /**
     *
     * @param fileName name of the video file
     * @param fileSize siz eof the video
     * @param duration in case of video duration of the video
     */
    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    /**
     *
     * @param duration duration of the video
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("Duration: " + duration);
        super.displayFileDetails();
    }
}

interface FileManager {
    /**
     *
     * @param file name of the file that we are going to add to list
     */
    void addFile(File file);

    /**
     *
     * @param fileName name of the file that we eant to delete from list
     */
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String filePath);
    void loadFromFile(String filePath);
    ArrayList<File> getFiles();
}

class FileManagerImpl implements FileManager {

    //ArrayList<File> to store the files. It overrides the interface methods.
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    /**
     *
     * @param file name of the file that we are going to add to list it is a override function
     */
    @Override
    public void addFile(File file) {
        files.add(file);
    }

    /**
     *
     * @param fileName name of the file that we want to delete from list and it is a ovverride function
     */
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
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println("\n");
        }
    }


    @Override
    public void saveToFile(String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(files);
            System.out.println("File details saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            files = (ArrayList<File>) objectInputStream.readObject();
            System.out.println("File details loaded from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }
}

// FileManagementSystemUI class
class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;

    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;

    /**
     *
     * @param fileManager a variable of type FileManager. it is a interface for managing files.
     */
    public FileManagementSystemUI(FileManager fileManager) {
        this.fileManager = fileManager;
        setTitle("21UCYS End Semester Assignment File Manager");
        setSize(900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameField = new JTextField(10);
        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeField = new JTextField(10);
        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});
        topPanel.add(fileNameLabel);
        topPanel.add(fileNameField);
        topPanel.add(fileSizeLabel);
        topPanel.add(fileSizeField);
        topPanel.add(fileTypeLabel);
        topPanel.add(fileTypeComboBox);

        JButton addButton = new JButton("Add File");
        JButton deleteButton = new JButton("Delete File");
        JButton displayButton = new JButton("Refresh");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);

        fileTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(fileTable);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"File Name", "File Size ", "File Type"}, 0);
        fileTable.setModel(tableModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                int fileSize = Integer.parseInt(fileSizeField.getText());
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                if (fileType.equals("Document")) {
                    String documentType = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter document type");
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (fileType.equals("Image")) {
                    String resolution = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter image resolution:");
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (fileType.equals("Video")) {
                    String duration = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter video duration:");
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }

                updateFileTable();
                clearInputFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    updateFileTable();
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.displayAllFiles();
            }
        });
    }

    private void updateFileTable() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), "Document", document.getDocumentType()});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "Image", image.getResolution()});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "Video", video.getDuration()});
            }
        }
    }

    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
    }
}


public class java {
    public static void main(String[] args) {
        FileManager fileManager = new FileManagerImpl();
        FileManagementSystemUI FSUI = new FileManagementSystemUI(fileManager);
        FSUI.setVisible(true);
    }
}
