package com.amrita.jpl.cys21034.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
/**
 *abstract class Fileitem
 */
abstract class FileItem {
    private String fileName;
    private long fileSize;
    private String fileType;

    public FileItem(String fileName, long fileSize, String fileType) {
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
/**
 *interface  Filemanager
 */
interface FileManager {
    void addFile(FileItem file);
    void deleteFile(String fileName);
    void saveToFile();
    void loadFromFile();
    ArrayList<FileItem> getFiles();
    DefaultListModel<FileItem> getListModel();
}
/**
 *class FileManagerImpl implementing Filemanager
 */
class FileManagerImpl implements FileManager {
    private ArrayList<FileItem> files;
    private DefaultListModel<FileItem> listModel;

    public FileManagerImpl() {
        files = new ArrayList<>();
        listModel = new DefaultListModel<>();
    }

    @Override
    public void addFile(FileItem file) {
        files.add(file);
        listModel.addElement(file);
    }

    @Override
    public void deleteFile(String fileName) {
        FileItem fileToRemove = null;
        for (FileItem file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToRemove = file;
                break;
            }
        }
        if (fileToRemove != null) {
            files.remove(fileToRemove);
            listModel.removeElement(fileToRemove);
        }
    }

    @Override
    public void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file_details.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(files);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("file_details.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            files = (ArrayList<FileItem>) objectInputStream.readObject();
            listModel.clear();
            for (FileItem file : files) {
                listModel.addElement(file);
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<FileItem> getFiles() {
        return files;
    }

    @Override
    public DefaultListModel<FileItem> getListModel() {
        return listModel;
    }
}

class FileManagementSystemUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private FileManager fileManager;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("File Management System");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Create the table with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String fileName = (String) table.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
                }
            }
        });
        buttonPanel.add(deleteButton);

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField nameField = new JTextField(10);
        JTextField sizeField = new JTextField(5);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});

        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("File Type:"));
        inputPanel.add(typeComboBox);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String sizeString = sizeField.getText().trim();
                String type = (String) typeComboBox.getSelectedItem();

                if (!name.isEmpty() && !sizeString.isEmpty() && !type.isEmpty()) {
                    long size = Long.parseLong(sizeString);
                    FileItem file = new FileItem(name, size, type) {
                    };
                    fileManager.addFile(file);
                    nameField.setText("");
                    sizeField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the fields and try again.");
                }
            }
        });
        inputPanel.add(addButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FileManagementSystemUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}