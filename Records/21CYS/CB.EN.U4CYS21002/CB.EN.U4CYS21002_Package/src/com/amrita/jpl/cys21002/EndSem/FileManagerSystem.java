/**
 *@Author: Achyuth Anand
 * Roll number: CB.EN.U4CYS21002
 * Version:0.5
 * **/
package com.amrita.jpl.cys21002.EndSem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**This interface accepts the file type from the user**/
interface FileType {
    String getType();
}

/** Abstract class for com.amrita.jpl.cys21002.EndSem.File**/
abstract class File {
    protected String name;
    protected int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public abstract String getFileDetails();
}

/** com.amrita.jpl.cys21002.EndSem.Document class**/
class Document extends File implements FileType {
    private String type;

    public Document(String name, int size, String type) {
        super(name, size);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFileDetails() {
        return "com.amrita.jpl.cys21002.EndSem.Document Name: " + name + ", Size: " + size + ", Type: " + type;
    }
}

/** com.amrita.jpl.cys21002.EndSem.Image class**/
class Image extends File implements FileType {
    private String resolution;

    public Image(String name, int size, String resolution) {
        super(name, size);
        this.resolution = resolution;
    }


    @Override
    public String getType() {
        return "com.amrita.jpl.cys21002.EndSem.Image";
    }

    @Override
    public String getFileDetails() {
        return "com.amrita.jpl.cys21002.EndSem.Image Name: " + name + ", Size: " + size + ", Resolution: " + resolution;
    }
}

/** com.amrita.jpl.cys21002.EndSem.Video class**/
class Video extends File implements FileType {
    private int duration;

    public Video(String name, int size, int duration) {
        super(name, size);
        this.duration = duration;
    }

    @Override
    public String getType() {
        return "com.amrita.jpl.cys21002.EndSem.Video";
    }

    @Override
    public String getFileDetails() {
        return "com.amrita.jpl.cys21002.EndSem.Video Name: " + name + ", Size: " + size + ", Duration: " + duration;
    }
}

/**com.amrita.jpl.cys21002.EndSem.File Management System class**/
class FileManager {
    private List<File> files;

    public FileManager() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(File file) {
        files.remove(file);
    }

    public List<File> getAllFiles() {
        return files;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (File file : files) {
                writer.println(file.getFileDetails());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        files.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].split(":")[0].trim();
                String name = parts[0].split(":")[1].trim();
                int size = Integer.parseInt(parts[1].split(":")[1].trim());

                if (type.equals("com.amrita.jpl.cys21002.EndSem.Document")) {
                    String docType = parts[2].split(":")[1].trim();
                    addFile(new Document(name, size, docType));
                } else if (type.equals("com.amrita.jpl.cys21002.EndSem.Image")) {
                    String resolution = parts[2].split(":")[1].trim();
                    addFile(new Image(name, size, resolution));
                } else if (type.equals("com.amrita.jpl.cys21002.EndSem.Video")) {
                    int duration = Integer.parseInt(parts[2].split(":")[1].trim());
                    addFile(new Video(name, size, duration));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**Swing user interface**/
class FileManagerUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTextArea fileDetailsTextArea;

    public FileManagerUI() {
        fileManager = new FileManager();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("com.amrita.jpl.cys21002.EndSem.File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        fileDetailsTextArea = new JTextArea();
        fileDetailsTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(fileDetailsTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add com.amrita.jpl.cys21002.EndSem.File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddFileDialog();
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete com.amrita.jpl.cys21002.EndSem.File");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeleteFileDialog();
            }
        });
        buttonPanel.add(deleteButton);

        JButton displayButton = new JButton("Display Files");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFiles();
            }
        });
        buttonPanel.add(displayButton);

        JButton saveButton = new JButton("Save to com.amrita.jpl.cys21002.EndSem.File");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSaveFileDialog();
            }
        });
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Load from com.amrita.jpl.cys21002.EndSem.File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoadFileDialog();
            }
        });
        buttonPanel.add(loadButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void showAddFileDialog() {
        String[] options = {"com.amrita.jpl.cys21002.EndSem.Document", "com.amrita.jpl.cys21002.EndSem.Image", "com.amrita.jpl.cys21002.EndSem.Video"};
        String selectedType = (String) JOptionPane.showInputDialog(frame, "Select com.amrita.jpl.cys21002.EndSem.File Type:",
                "Add com.amrita.jpl.cys21002.EndSem.File", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (selectedType != null) {
            String name = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl.cys21002.EndSem.File Name:");
            String sizeString = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl.cys21002.EndSem.File Size:");
            int size = Integer.parseInt(sizeString);

            if (selectedType.equals("com.amrita.jpl.cys21002.EndSem.Document")) {
                String docType = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl.cys21002.EndSem.Document Type:");
                fileManager.addFile(new Document(name, size, docType));
            } else if (selectedType.equals("com.amrita.jpl.cys21002.EndSem.Image")) {
                String resolution = JOptionPane.showInputDialog(frame, "Enter Resolution:");
                fileManager.addFile(new Image(name, size, resolution));
            } else if (selectedType.equals("com.amrita.jpl.cys21002.EndSem.Video")) {
                String durationString = JOptionPane.showInputDialog(frame, "Enter Duration:");
                int duration = Integer.parseInt(durationString);
                fileManager.addFile(new Video(name, size, duration));
            }

            displayFiles();
        }
    }

    private void showDeleteFileDialog() {
        List<File> files = fileManager.getAllFiles();
        if (files.size() > 0) {
            File[] options = new File[files.size()];
            for (int i = 0; i < files.size(); i++) {
                options[i] = files.get(i);
            }
            File selectedFile = (File) JOptionPane.showInputDialog(frame, "Select com.amrita.jpl.cys21002.EndSem.File to Delete:",
                    "Delete com.amrita.jpl.cys21002.EndSem.File", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (selectedFile != null) {
                fileManager.deleteFile(selectedFile);
                displayFiles();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No files to delete.", "Delete com.amrita.jpl.cys21002.EndSem.File",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayFiles() {
        List<File> files = fileManager.getAllFiles();
        StringBuilder sb = new StringBuilder();
        if (files.size() > 0) {
            for (File file : files) {
                sb.append(file.getFileDetails()).append("\n");
            }
        } else {
            sb.append("No files available.");
        }
        fileDetailsTextArea.setText(sb.toString());
    }

    private void showSaveFileDialog() {
        String filename = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl.cys21002.EndSem.File Name:");
        if (filename != null) {
            fileManager.saveToFile(filename);
        }
    }

    private void showLoadFileDialog() {
        String filename = JOptionPane.showInputDialog(frame, "Enter com.amrita.jpl.cys21002.EndSem.File Name:");
        if (filename != null) {
            fileManager.loadFromFile(filename);
            displayFiles();
        }
    }
}

// Main class
public class FileManagerSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagerUI();
            }
        });
    }
}
