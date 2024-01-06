package com.amrita.jpl21037.prac.FileManagementSystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile();
    void loadFromFile();

    File[] getFiles();
}

class File implements Serializable {
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
        System.out.println("File Size: " + fileSize + " KB");
    }
}

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
        System.out.println("Duration: " + duration + " seconds");
    }
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;
    private DefaultTableModel tableModel;

    public FileManagerImpl(DefaultTableModel tableModel) {
        this.files = new ArrayList<>();
        this.tableModel = tableModel;
    }

    @Override
    public void addFile(File file) {
        files.add(file);
        String[] rowData = {file.getFileName(), Integer.toString(file.getFileSize())};
        tableModel.addRow(rowData);
    }

    @Override
    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                tableModel.removeRow(i);
                break;
            }
        }
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    @Override
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream("files.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("File details saved to files.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        try (FileInputStream fis = new FileInputStream("files.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (ArrayList<File>) ois.readObject();
            System.out.println("File details loaded from files.txt");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File[] getFiles() {
        return new File[0];
    }
}

class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private JTextField nameField, sizeField, resolutionField, durationField;
    private JComboBox<String> fileTypeComboBox;
    private JTable fileTable;
    private DefaultTableModel tableModel;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl(tableModel);
        createUI();
    }

    private void createUI() {
        setTitle("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);

        JPanel tablePanel = createTablePanel();
        add(tablePanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Add File"));

        String[] fileTypes = {"Image", "Video", "Text"};
        fileTypeComboBox = new JComboBox<>(fileTypes);

        JLabel fileTypeLabel = new JLabel();
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        panel.add(new JLabel("Size (KB):"));
        sizeField = new JTextField();
        panel.add(sizeField);
        panel.add(new JLabel("Type:"));
        panel.add(fileTypeComboBox);

        panel.add(new JLabel("File Type:"));
        panel.add(fileTypeLabel);
        panel.add(new JLabel());  // Empty cell for spacing

        fileTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) fileTypeComboBox.getSelectedItem();
                fileTypeLabel.setText(selectedType);
            }
        });

        return panel;
    }

    private JPanel createButtonPanel() {
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

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

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFiles();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(displayButton);
        panel.add(saveButton);
        panel.add(loadButton);
        return panel;
    }

    private JPanel createTablePanel() {
        String[] columnNames = {"Name", "Size (KB)"};
        tableModel = new DefaultTableModel(columnNames, 0);
        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Files"));
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void addFile() {
        String name = nameField.getText();
        int size = Integer.parseInt(sizeField.getText());
        String fileType = (String) fileTypeComboBox.getSelectedItem();

        switch (fileType.toLowerCase()) {
            case "image":
                String resolution = JOptionPane.showInputDialog(this, "Enter resolution:");
                if (resolution != null) {
                    Image image = new Image(name, size, resolution);
                    fileManager.addFile(image);
                }
                break;
            case "video":
                String durationStr = JOptionPane.showInputDialog(this, "Enter duration (seconds):");
                if (durationStr != null) {
                    try {
                        int duration = Integer.parseInt(durationStr);
                        Video video = new Video(name, size, duration);
                        fileManager.addFile(video);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid duration format.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "text":
                Document document = new Document(name, size, "Text");
                fileManager.addFile(document);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid file type.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        clearFields();
    }

    private void deleteFile() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String) tableModel.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayFiles() {
        DefaultTableModel tableModel = (DefaultTableModel) fileTable.getModel();
        tableModel.setRowCount(0);

        File[] files = fileManager.getFiles();
        for (File file : files) {
            String[] rowData = {file.getFileName(), String.valueOf(file.getFileSize())};
            tableModel.addRow(rowData);
        }
    }


    private void saveToFile() {
        fileManager.saveToFile();
    }

    private void loadFromFile() {
        fileManager.loadFromFile();
        updateTable();
    }

    private void clearFields() {
        nameField.setText("");
        sizeField.setText("");
        fileTypeComboBox.setSelectedIndex(0);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            String[] rowData = {file.getFileName(), Integer.toString(file.getFileSize())};
            tableModel.addRow(rowData);
        }
    }
}

public class FileManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}