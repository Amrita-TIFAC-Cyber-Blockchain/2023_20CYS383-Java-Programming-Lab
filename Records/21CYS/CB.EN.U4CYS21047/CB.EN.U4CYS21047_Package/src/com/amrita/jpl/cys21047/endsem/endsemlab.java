package com.amrita.jpl.cys21047.endsem;
/**
 * end sem .
 * gui.
 *
 * @author = Vihal roy
 * @version 0.5
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        System.out.println("File Name: " + fileName + ", File Size: " + fileSize);
    }
}

// Document class
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

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

// Video class
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

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

// FileManager interface
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    ArrayList<File> getFiles();
}

// FileManagerImpl class
class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}

// FileManagementSystemUI class
class FileManagementSystemUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField fileNameTextField, fileSizeTextField;
    private JComboBox<String> fileTypeComboBox;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // File details panel
        JPanel fileDetailsPanel = new JPanel();
        fileDetailsPanel.setLayout(new BoxLayout(fileDetailsPanel, BoxLayout.X_AXIS));

        JPanel fileNamePanel = new JPanel();
        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameTextField = new JTextField(10);
        fileNamePanel.add(fileNameLabel);
        fileNamePanel.add(fileNameTextField);

        JPanel fileSizePanel = new JPanel();
        JLabel fileSizeLabel = new JLabel("File Size:");
        fileSizeTextField = new JTextField(10);
        fileSizePanel.add(fileSizeLabel);
        fileSizePanel.add(fileSizeTextField);

        JPanel fileTypePanel = new JPanel();
        JLabel fileTypeLabel = new JLabel("File Type:");
        String[] fileTypes = {"Document", "Image", "Video"};
        fileTypeComboBox = new JComboBox<>(fileTypes);
        fileTypePanel.add(fileTypeLabel);
        fileTypePanel.add(fileTypeComboBox);

        fileDetailsPanel.add(fileNamePanel);
        fileDetailsPanel.add(fileSizePanel);
        fileDetailsPanel.add(fileTypePanel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFileButtonClicked();
            }
        });
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFileButtonClicked();
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshButtonClicked();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        // Table
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(fileDetailsPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addFileButtonClicked() {
        String fileName = fileNameTextField.getText();
        int fileSize = Integer.parseInt(fileSizeTextField.getText());
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        if (fileType.equals("Document")) {
            String documentType = JOptionPane.showInputDialog(frame, "Enter Document Type:");
            if (documentType != null && !documentType.isEmpty()) {
                Document document = new Document(fileName, fileSize, documentType);
                fileManager.addFile(document);
                tableModel.addRow(new Object[]{fileName, fileSize, "Document"});
                clearFields();
            }
        } else if (fileType.equals("Image")) {
            String resolution = JOptionPane.showInputDialog(frame, "Enter Resolution:");
            if (resolution != null && !resolution.isEmpty()) {
                Image image = new Image(fileName, fileSize, resolution);
                fileManager.addFile(image);
                tableModel.addRow(new Object[]{fileName, fileSize, "Image"});
                clearFields();
            }
        } else if (fileType.equals("Video")) {
            String duration = JOptionPane.showInputDialog(frame, "Enter Duration:");
            if (duration != null && !duration.isEmpty()) {
                Video video = new Video(fileName, fileSize, duration);
                fileManager.addFile(video);
                tableModel.addRow(new Object[]{fileName, fileSize, "Video"});
                clearFields();
            }
        }
    }

    private void deleteFileButtonClicked() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String fileName = (String) table.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
        }
    }

    private void refreshButtonClicked() {
        clearTable();
        ArrayList<File> files = fileManager.getFiles();
        for (File file : files) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), "Document"});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "Image"});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "Video"});
            }
        }
    }

    private void clearFields() {
        fileNameTextField.setText("");
        fileSizeTextField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}