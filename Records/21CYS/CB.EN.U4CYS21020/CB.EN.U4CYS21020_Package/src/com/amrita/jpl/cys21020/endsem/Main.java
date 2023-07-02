import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Hemesh sai
 * @version 1.0
 * The abstract class File represents a generic file with basic properties such as file name, file size, and file type.
 */
abstract class File {
    private String fileName;
    private long fileSize;
    private String fileType;

    /**
     * Constructs a File object with the specified file name, file size, and file type.
     *
     * @param fileName  The name of the file.
     * @param fileSize  The size of the file in bytes.
     * @param fileType  The type of the file.
     */
    public File(String fileName, long fileSize, String fileType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    /**
     * Returns the name of the file.
     *
     * @return The name of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns the size of the file in bytes.
     *
     * @return The size of the file in bytes.
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Returns the type of the file.
     *
     * @return The type of the file.
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Displays the details of the file.
     */
    public abstract void displayFileDetails();
}

/**
 * The Document class represents a document file, which is a subclass of File.
 */
class Document extends File {
    private String documentType;

    /**
     * Constructs a Document object with the specified file name, file size, file type, and document type.
     *
     * @param fileName      The name of the document file.
     * @param fileSize      The size of the document file in bytes.
     * @param fileType      The type of the document file.
     * @param documentType  The type of the document.
     */
    public Document(String fileName, long fileSize, String fileType, String documentType) {
        super(fileName, fileSize, fileType);
        this.documentType = documentType;
    }

    /**
     * Returns the type of the document.
     *
     * @return The type of the document.
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the type of the document.
     *
     * @param documentType The type of the document.
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Displays the details of the document file, including its name, size, and document type.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Document: " + getFileName());
        System.out.println("Size: " + getFileSize() + " bytes");
        System.out.println("Type: " + getDocumentType());
    }
}

/**
 * The Image class represents an image file, which is a subclass of File.
 */
class Image extends File {
    private String resolution;

    /**
     * Constructs an Image object with the specified file name, file size, file type, and resolution.
     *
     * @param fileName    The name of the image file.
     * @param fileSize    The size of the image file in bytes.
     * @param fileType    The type of the image file.
     * @param resolution  The resolution of the image.
     */
    public Image(String fileName, long fileSize, String fileType, String resolution) {
        super(fileName, fileSize, fileType);
        this.resolution = resolution;
    }

    /**
     * Returns the resolution of the image.
     *
     * @return The resolution of the image.
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the resolution of the image.
     *
     * @param resolution The resolution of the image.
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * Displays the details of the image file, including its name, size, and resolution.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Image: " + getFileName());
        System.out.println("Size: " + getFileSize() + " bytes");
        System.out.println("Resolution: " + getResolution());
    }
}

/**
 * The Video class represents a video file, which is a subclass of File.
 */
class Video extends File {
    private String duration;

    /**
     * Constructs a Video object with the specified file name, file size, file type, and duration.
     *
     * @param fileName   The name of the video file.
     * @param fileSize   The size of the video file in bytes.
     * @param fileType   The type of the video file.
     * @param duration   The duration of the video.
     */
    public Video(String fileName, long fileSize, String fileType, String duration) {
        super(fileName, fileSize, fileType);
        this.duration = duration;
    }

    /**
     * Returns the duration of the video.
     *
     * @return The duration of the video.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the video.
     *
     * @param duration The duration of the video.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Displays the details of the video file, including its name, size, and duration.
     */
    @Override
    public void displayFileDetails() {
        System.out.println("Video: " + getFileName());
        System.out.println("Size: " + getFileSize() + " bytes");
        System.out.println("Duration: " + getDuration());
    }
}

/**
 * The FileManager interface defines operations for managing files such as adding, deleting, saving, loading, and retrieving files.
 */
interface FileManager {
    /**
     * Adds a file to the file manager.
     *
     * @param file The file to be added.
     */
    void addFile(File file);

    /**
     * Deletes a file from the file manager based on the specified file name.
     *
     * @param fileName The name of the file to be deleted.
     */
    void deleteFile(String fileName);

    /**
     * Saves the file details to a file.
     */
    void saveToFile();

    /**
     * Loads file details from a file.
     */
    void loadFromFile();

    /**
     * Returns a list of all files managed by the file manager.
     *
     * @return A list of all files managed by the file manager.
     */
    ArrayList<File> getFiles();
}

/**
 * The FileManagerImpl class implements the FileManager interface and provides an implementation for managing files.
 */
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    /**
     * Constructs a FileManagerImpl object.
     */
    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    /**
     * Adds a file to the file manager.
     *
     * @param file The file to be added.
     */
    @Override
    public void addFile(File file) {
        files.add(file);
    }

    /**
     * Deletes a file from the file manager based on the specified file name.
     *
     * @param fileName The name of the file to be deleted.
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
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    /**
     * Saves the file details to a file named "file_details.txt".
     */
    @Override
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream("file_details.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("File details saved to file_details.txt");
        } catch (IOException e) {
            System.out.println("Error saving file details: " + e.getMessage());
        }
    }

    /**
     * Loads file details from a file named "file_details.txt".
     */
    @Override
    public void loadFromFile() {
        try (FileInputStream fis = new FileInputStream("file_details.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (ArrayList<File>) ois.readObject();
            System.out.println("File details loaded from file_details.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file details: " + e.getMessage());
        }
    }

    /**
     * Returns a list of all files managed by the file manager.
     *
     * @return A list of all files managed by the file manager.
     */
    @Override
    public ArrayList<File> getFiles() {
        return files;
    }
}

/**
 * The FileManagementSystemUI class represents the user interface for the file management system.
 */
class FileManagementSystemUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private FileManager fileManager;

    /**
     * Constructs a FileManagementSystemUI object and initializes the file manager and user interface.
     */
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        createUI();
    }

    /**
     * Creates the user interface for the file management system.
     */
    private void createUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField fileNameField = new JTextField(10);
        JTextField fileSizeField = new JTextField(10);
        JComboBox<String> fileTypeComboBox = new JComboBox<>(new String[]{"Text", "Image", "Video"});

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                if (fileType.equals("Text")) {
                    // Add text file
                    String documentType = ".txt";
                    Document document = new Document(fileName, fileSize, fileType, documentType);
                    fileManager.addFile(document);
                } else if (fileType.equals("Image")) {
                    // Add image file
                    String resolution = JOptionPane.showInputDialog(frame, "Enter the resolution:");
                    Image image = new Image(fileName, fileSize, fileType, resolution);
                    fileManager.addFile(image);
                } else if (fileType.equals("Video")) {
                    // Add video file
                    String duration = JOptionPane.showInputDialog(frame, "Enter the duration:");
                    Video video = new Video(fileName, fileSize, fileType, duration);
                    fileManager.addFile(video);
                }

                refreshTable();
            }
        });
        panel.add(new JLabel("File Name:"));
        panel.add(fileNameField);
        panel.add(new JLabel("File Size:"));
        panel.add(fileSizeField);
        panel.add(new JLabel("File Type:"));
        panel.add(fileTypeComboBox);
        panel.add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) table.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(frame, "No file selected.");
                }
            }
        });
        panel.add(deleteButton);

        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.saveToFile();
            }
        });
        panel.add(saveButton);

        JButton loadButton = new JButton("Load from File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.loadFromFile();
                refreshTable();
            }
        });
        panel.add(loadButton);

        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /**
     * Refreshes the file table with the latest file details.
     */
    private void refreshTable() {
        tableModel.setRowCount(0);
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            Object[] rowData = {file.getFileName(), file.getFileSize(), file.getFileType()};
            tableModel.addRow(rowData);
        }
    }
}

/**
 * The Main class is the entry point of the file management system application.
 */
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
