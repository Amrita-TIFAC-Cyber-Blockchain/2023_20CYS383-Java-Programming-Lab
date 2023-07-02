package com.amrita.jpl.cys21040.endsem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

abstract class File{
    private String fileName;
    private long fileSize;
    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    public abstract void displayFileDetails();
    public String getFileName(){
        return fileName;
    }
    public long getFileSize(){
        return fileSize;
    }
}
class Document extends File {
    public String type;
    public Document(String fileName, long fileSize, String type) {
        super(fileName, fileSize);
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void displayFileDetails() {
        System.out.println("Document Name : " + getFileName());
        System.out.println("Size : " + getFileSize());
        System.out.println("Type : " + type);
    }
}

class Image extends File {
    public String resolution;
    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }
    public String getResolution() {
        return resolution;
    }
    public void displayFileDetails() {
        System.out.println("Image Name : " + getFileName());
        System.out.println("Size : " + getFileSize());
        System.out.println("Resolution : " + resolution);
    }
}
class Video extends File {
    public String duration;
    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }
    public String getDuration() {
        return duration;
    }
    public void displayFileDetails() {
        System.out.println("Document Name : " + getFileName());
        System.out.println("Size : " + getFileSize());
        System.out.println("Type : " + duration);
    }
}
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void saveToFile();
    void loadFromFile();
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
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }
    public void saveToFile() {
        try (PrintWriter f = new PrintWriter(new FileWriter("File_Details.txt"))) {
            for (File file : files) {
                f.println(file.getClass().getSimpleName());
                f.println(file.getFileName());
                f.println(file.getFileSize());
                if (file instanceof Document) {
                    Document document = (Document) file;
                    f.println(document.getType());
                } else if (file instanceof Image) {
                    Image image = (Image) file;
                    f.println(image.resolution);
                } else if (file instanceof Video) {
                    Video video = (Video) file;
                    f.println(video.duration);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        files.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("File_Details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String type = line.trim();
                String name = reader.readLine().trim();
                long size = Long.parseLong(reader.readLine().trim());
                if (type.equals("Document")) {
                    String docType = reader.readLine().trim();
                    addFile(new Document(name, size, docType));
                } else if (type.equals("Image")) {
                    String resolution = reader.readLine().trim();
                    addFile(new Image(name, size, resolution));
                } else if (type.equals("Video")) {
                    String duration = reader.readLine().trim();
                    addFile(new Video(name, size, duration));
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
public class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable fileTable;
    private JTextField nameField;
    private JTextField sizeField;
    private JComboBox<String> typeComboBox;
    private JTextField resolutionField;
    private JTextField durationField;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Size");
        tableModel.addColumn("Type");

        fileTable = new JTable(tableModel);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) tableModel.getValueAt(selectedRow, 0);
                    String size = (String) tableModel.getValueAt(selectedRow, 1);
                    String type = (String) tableModel.getValueAt(selectedRow, 2);

                    nameField.setText(name);
                    sizeField.setText(size);
                    typeComboBox.setSelectedItem(type);
                }
            }
        });

        JScrollPane sp = new JScrollPane(fileTable);

        nameField = new JTextField(15);
        sizeField = new JTextField(10);
        typeComboBox = new JComboBox<>(new String[]{"Document", "Image", "Video"});


        add(nameField);
        add(sizeField);
        add(typeComboBox);
        typeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typeComboBox.getSelectedItem();
            }
        });
        resolutionField = new JTextField(10);
        durationField = new JTextField(10);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                long size = Long.parseLong(sizeField.getText());
                String type = (String) typeComboBox.getSelectedItem();

                String resolution = resolutionField.getText();
                String duration = durationField.getText();

                File file;
                if (type.equals("Document")) {
                    file = new Document(name, size, type);
                } else if (type.equals("Image")) {
                    file = new Image(name, size, resolution);
                } else {
                    file = new Video(name, size, duration);
                }
                fileManager.addFile(file);
                addvalue(file);
                clearFields();
            }
        });

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(name);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                }
            }
        });
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Size (KB):"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeComboBox);
        inputPanel.add(typeComboBox);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(deleteButton);
        Container cp = getContentPane();
        cp.add(sp, BorderLayout.CENTER);
        cp.add(inputPanel, BorderLayout.NORTH);
        cp.add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private void addvalue(File file) {
        Object[] Data = new Object[5];
        Data[0] = file.getFileName();
        Data[1] = file.getFileSize();
        if (file instanceof Document) {
            Data[2] = "Document";
        } else if (file instanceof Image) {
            Data[2] = "Image";
            durationField.setText("");
        } else if (file instanceof Video) {
            Data[2] = "Video";
            resolutionField.setText("");
        }
        tableModel.addRow(Data);
    }
    private void clearFields() {
        nameField.setText("");
        sizeField.setText("");
        typeComboBox.setSelectedIndex(0);
        resolutionField.setText("");
        durationField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}