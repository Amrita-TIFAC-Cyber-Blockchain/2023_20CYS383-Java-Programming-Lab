package com.amrita.jpl.cys21069.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This an simple gui program which stores an file type in an database.
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */

/**
 * We have declared an interface FileManager which is used to manage the file details we are giving.
 * FileManager has 3 functions aadFile,deleteFiles and displayFiles.
 */
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    List<File> getFiles();
}
/**
 * We have declared an abstract class File which is used to get the input from the user and passing it to database.
 * FileManager has 3 functions getFileType,getFileName,getFileSize.
 * it has an constructor also namely File which has 3 arguments fileName,fileSize, fileType.
 */
abstract class File {
    private String fileName;
    private int fileSize;
    private String fileType;

    public File(String fileName, int fileSize, String fileType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFileType() {
        return fileType;
    }
}

/**
 * Then we have an class DocumentFile which abstracts from the abstract class File.
 */
class DocumentFile extends File {
    private String documentType;

    public DocumentFile(String fileName, int fileSize, String fileType, String documentType) {
        super(fileName, fileSize, fileType);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }
}
/**
 * Then we have an class ImageFile which abstracts from the abstract class File.
 */
class ImageFile extends File {
    private String resolution;

    public ImageFile(String fileName, int fileSize, String fileType, String resolution) {
        super(fileName, fileSize, fileType);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }
}
/**
 * Then we have an class VideoFile which abstracts from the abstract class File.
 */
class VideoFile extends File {
    private String duration;

    public VideoFile(String fileName, int fileSize, String fileType, String duration) {
        super(fileName, fileSize, fileType);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}

/**
 * we have an class FileManagerImpl which implements from the interface FileManager
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
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                files.remove(file);
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            System.out.println("File Name: " + file.getFileName());
            System.out.println("File Size: " + file.getFileSize());
            System.out.println("File Type: " + file.getFileType());
            System.out.println();
        }
    }

    @Override
    public List<File> getFiles() {
        return files;
    }
}

/**
 * Now we have our main class FileManagementSystemUI
 */
public class FileManagementSystemUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTable table;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
/**
 * we are using BorderLayout and FlowLayout.
 * we are initializing an default Json table.
 */
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
/**
 * here we are initializing the buttons add file, delete file and refresh
 * each button has been been assigned to an function.
 */
        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddFileDialog();
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) table.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    ((DefaultTableModel)table.getModel()).removeRow(selectedRow);
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh ");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFileList();
            }
        });
        buttonPanel.add(refreshButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Set table column headers
        ((DefaultTableModel) table.getModel()).addColumn("File Name");
        ((DefaultTableModel) table.getModel()).addColumn("File Size");
        ((DefaultTableModel) table.getModel()).addColumn("File Type");
    }

    /**
     * when we click the button add files the showAddFileDialog function is invoked and it opens an dialog box and displays the required things.
     */
    private void showAddFileDialog() {
        JTextField nameField = new JTextField(20);
        JTextField sizeField = new JTextField(10);
        JComboBox<String> fileTypeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("File Name:"));
        panel.add(nameField);
        panel.add(new JLabel("File Size:"));
        panel.add(sizeField);
        panel.add(new JLabel("File Type:"));
        panel.add(fileTypeComboBox);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add File", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String fileName = nameField.getText();
            int fileSize = Integer.parseInt(sizeField.getText());
            String fileType = (String) fileTypeComboBox.getSelectedItem();

            File file;
            switch (fileType) {
                case "Document":
                    String documentType = JOptionPane.showInputDialog(frame, "Enter the Document Type:");
                    file = new DocumentFile(fileName, fileSize, fileType, documentType);
                    break;
                case "Image":
                    String resolution = JOptionPane.showInputDialog(frame, "Enter the Image Resolution:");
                    file = new ImageFile(fileName, fileSize, fileType, resolution);
                    break;
                case "Video":
                    String duration = JOptionPane.showInputDialog(frame, "Enter the Video Duration:");
                    file = new VideoFile(fileName, fileSize, fileType, duration);
                    break;
                default:
                    return;
            }

            fileManager.addFile(file);
            ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{file.getFileName(), file.getFileSize(), file.getFileType()});
        }
    }

    /**
     * we displaying all the data and referesh is used display all the files.
     */
    private void refreshFileList() {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        fileManager.displayAllFiles();
        List<File> files = fileManager.getFiles();
        for (int i = files.size() - 1; i >= 0; i--) {
            File file = files.get(i);
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{file.getFileName(), file.getFileSize(), file.getFileType()});
        }
    }

    public static void main(String[] args) {
        new FileManagementSystemUI();
    }
}
