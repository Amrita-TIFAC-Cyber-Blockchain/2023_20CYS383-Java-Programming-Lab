package com.amrita.jpl.cys21041.endsem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

interface FileManager {
    void addFile(File file);

    void deleteFile(String fileName);

    void displayAllFiles();

    void saveToFile(String fileName);

    void loadFromFile(String fileName);

    List<File> getFiles();
}

class File {
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
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

    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private int duration;

    public Video(String fileName, long fileSize, int duration) {
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
        System.out.println("Duration: " + duration);
    }
}

class FileManagerImpl implements FileManager {
    private List<File> files = new ArrayList<>();

    @Override
    public void addFile(File file) {
        files.add(file);
    }

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

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (File file : files) {
                writer.write(file.getFileName() + "," + file.getFileSize());
                if (file instanceof Document) {
                    writer.write(",document," + ((Document) file).getDocumentType());
                } else if (file instanceof Image) {
                    writer.write(",image," + ((Image) file).getResolution());
                } else if (file instanceof Video) {
                    writer.write(",video," + ((Video) file).getDuration());
                }
                writer.newLine();
            }
            System.out.println("File details saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save file details: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String fileType = parts[2];
                    if (fileType.equals("document")) {
                        String documentType = parts[3];
                        Document document = new Document(parts[0], Long.parseLong(parts[1]), documentType);
                        files.add(document);
                    } else if (fileType.equals("image")) {
                        String resolution = parts[3];
                        Image image = new Image(parts[0], Long.parseLong(parts[1]), resolution);
                        files.add(image);
                    } else if (fileType.equals("video")) {
                        int duration = Integer.parseInt(parts[3]);
                        Video video = new Video(parts[0], Long.parseLong(parts[1]), duration);
                        files.add(video);
                    }
                }
            }
            System.out.println("File details loaded from: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to load file details: " + e.getMessage());
        }
    }

    public List<File> getFiles() {
        return files;
    }
}

class FileManagementSystemUI {
    private JFrame frame;
    private JTable table;
    private FileManager fileManager = new FileManagerImpl();

    public FileManagementSystemUI() {
        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });
        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });
        JButton displayButton = new JButton("Display Files");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFiles();
            }
        });
        JButton saveButton = new JButton("Save File Details");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFileDetails();
            }
        });
        JButton loadButton = new JButton("Load File Details");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFileDetails();
            }
        });
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(displayButton);
        panel.add(saveButton);
        panel.add(loadButton);

        JLabel label = new JLabel("Files:");
        table = new JTable(new DefaultTableModel(new String[]{"File Name", "File Size", "File Type"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(label);
        panel.add(scrollPane);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addFile() {
        String[] options = {"Document", "Image", "Video"};
        String fileType = (String) JOptionPane.showInputDialog(frame, "Select File Type:", "Add File",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (fileType != null) {
            String fileName = JOptionPane.showInputDialog(frame, "Enter file name:");
            if (fileName != null && !fileName.isEmpty()) {
                long fileSize = Long.parseLong(JOptionPane.showInputDialog(frame, "Enter file size:"));
                if (fileType.equals("Document")) {
                    String documentType = JOptionPane.showInputDialog(frame, "Enter document type:");
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (fileType.equals("Image")) {
                    String resolution = JOptionPane.showInputDialog(frame, "Enter image resolution:");
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (fileType.equals("Video")) {
                    int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter video duration:"));
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }
                updateTable();
            }
        }
    }

    private void deleteFile() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String fileName = (String) model.getValueAt(selectedRow, 0);
            fileManager.deleteFile(fileName);
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a file to delete.", "Delete File",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void displayFiles() {
        fileManager.displayAllFiles();
    }

    private void saveFileDetails() {
        String fileName = JOptionPane.showInputDialog(frame, "Enter file name to save details:");
        if (fileName != null && !fileName.isEmpty()) {
            fileManager.saveToFile(fileName);
        }
    }

    private void loadFileDetails() {
        String fileName = JOptionPane.showInputDialog(frame, "Enter file name to load details:");
        if (fileName != null && !fileName.isEmpty()) {
            fileManager.loadFromFile(fileName);
            updateTable();
        }
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<File> files = fileManager.getFiles(); // Changed from getFileSize()
        for (File file : files) {
            if (file instanceof Document) {
                model.addRow(new Object[]{file.getFileName(), file.getFileSize(), "Document"});
            } else if (file instanceof Image) {
                model.addRow(new Object[]{file.getFileName(), file.getFileSize(), "Image"});
            } else if (file instanceof Video) {
                model.addRow(new Object[]{file.getFileName(), file.getFileSize(), "Video"});
            }
        }
    }
}
public class FileManagementSystemApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}