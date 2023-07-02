package com.amrita.jpl.cys21035.endsem;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.util.List;

enum FileType {
    DOCUMENT, IMAGE, VIDEO
}
abstract class File {
    private String fileName;
    private long fileSize;
    private String fileType;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }
    public String getFileType() {
        return fileType;
    }

}
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void saveToFile();
    void displayAllFiles();
    void loadFromFile();
    ArrayList<File> getFiles();
}
class DocumentFile extends File {
    private static String documentType;

    public DocumentFile(String fileName, long fileSize, String fileType, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public static String getDocumentType() {
        return documentType;
    }

    public void displayFileDetails() {
        System.out.println("Document Name: " + getFileName());
        System.out.println("Document Size: " + getFileSize());
        System.out.println("Document Type: " + getDocumentType());
    }
}

class ImageFile extends File {
    private static String resolution;

    public ImageFile(String fileName, long fileSize, String fileType, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public static String getResolution() {
        return resolution;
    }

    public void displayFileDetails() {
        System.out.println("Image Name: " + getFileName());
        System.out.println("Image Size: " + getFileSize());
        System.out.println("Resolution: " + getResolution());
    }
}

class VideoFile extends File {
    private static String duration;

    public VideoFile(String fileName, long fileSize, String fileType, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public static String getDuration() {

        return duration;
    }

    public void displayFileDetails() {
        System.out.println("Video Name: " + getFileName());
        System.out.println("Video Size: " + getFileSize());
        System.out.println("Duration: " + getDuration());
    }
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
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream("D:\\Java\\cbenu4cys21035_jpl_final\\fileDetails.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("Saved to txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadFromFile() {
        try (FileInputStream fis = new FileInputStream("D:\\Java\\cbenu4cys21035_jpl_final\\fileDetails.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (ArrayList<File>) ois.readObject();
            System.out.println("Loaded from txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }

}
class FileManagementSystemUI {
    private JTextField nameField, sizeField, typeField;
    private JComboBox<FileType> fileTypeComboBox;
    private DefaultTableModel tableModel;
    private FileManager fileManager;
    private JTable table;
    private JFrame frame;
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        createUI();
    }
    private void createUI() {
        frame = new JFrame("21CYS End Semester Assignment File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"File Name", "File Size", "File Type"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());


        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddFileDialog();
            }
        });
        inputPanel.add(addButton);

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
        inputPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFileList();
            }
        });
        inputPanel.add(refreshButton);

        panel.add(inputPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.add(panel);
        frame.setVisible(true);

        fileManager = new FileManagerImpl();
    }

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


    private void deleteFile(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String) table.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            displayFiles();
        }
    }

    private void displayFiles() {
        ArrayList<File> files = fileManager.getFiles();
        tableModel.setRowCount(0);
        for (File file : files) {
            tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize()});
        }
    }


    private void loadFromFile() {
        fileManager.loadFromFile();
        displayFiles();
        JOptionPane.showMessageDialog(frame, "File details loaded from file.", "Load", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        nameField.setText("");
        sizeField.setText("");
        ((JTextField) ((JPanel) ((JPanel) fileTypeComboBox.getParent())
                .getComponent(2)).getComponent(0)).setText("");
    }
    private void refreshFileList() {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        fileManager.displayAllFiles();
        List<File> files = fileManager.getFiles();
        for (int i = files.size() - 1; i >= 0; i--) {
            File file = files.get(i);
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{file.getFileName(), file.getFileSize(), file.getFileType()});
        }
    }
}



public class FileManagementSystemDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileManagementSystemUI::new);
    }
}

