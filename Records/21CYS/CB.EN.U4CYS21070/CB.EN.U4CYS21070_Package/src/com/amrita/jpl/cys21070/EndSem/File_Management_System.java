package com.amrita.jpl.cys21070.EndSem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

abstract class File {
    protected String name;
    protected long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public abstract String getFileDetails();
}

// com.amrita.jpl._21cys21070.endsem.Document class
class Document extends File {
    private String type;

    public Document(String name, long size, String type) {
        super(name, size);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getFileDetails() {
        return "Name: " + name + " | Size: " + size + " | Type: " + type;
    }
}

// com.amrita.jpl._21cys21070.endsem.Image class
class Image extends File {
    private String resolution;

    public Image(String name, long size, String resolution) {
        super(name, size);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public String getFileDetails() {
        return "Name: " + name + " | Size: " + size + " | Resolution: " + resolution;
    }
}

// com.amrita.jpl._21cys21070.endsem.Video class
class Video extends File {
    private int duration;

    public Video(String name, long size, int duration) {
        super(name, size);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getFileDetails() {
        return "Name: " + name + " | Size: " + size + " | Duration: " + duration + " seconds";
    }
}



class FileManagerGUI extends JFrame{

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField FileSizeField;

    private JComboBox<String> typeComboBox;
    private JTextField TypeField;

    private JTextField SizeField;
    public FileManagerGUI(){
        JButton addButton = new JButton("Add com.amrita.jpl._21cys21070.endsem.File");
        JButton deleteButton = new JButton("Delete com.amrita.jpl._21cys21070.endsem.File");
        JButton RefreshButton = new JButton("Refresh");
        tableModel = new DefaultTableModel(new Object[]{"com.amrita.jpl._21cys21070.endsem.File Name", "com.amrita.jpl._21cys21070.endsem.File Size", "com.amrita.jpl._21cys21070.endsem.File Type"}, 0);
        table = new JTable(tableModel);

        JScrollPane scroll = new JScrollPane(table);
        JPanel form = new JPanel(new GridLayout(1, 6));
        form.add(new JLabel("com.amrita.jpl._21cys21070.endsem.File Name:"));
        nameField = new JTextField();
        form.add(nameField);
        form.add(new JLabel("com.amrita.jpl._21cys21070.endsem.File Size:"));
        FileSizeField = new JTextField();
        form.add(FileSizeField);
        form.add(new JLabel("com.amrita.jpl._21cys21070.endsem.File Type:"));
        typeComboBox = new JComboBox<>(new String[]{"com.amrita.jpl._21cys21070.endsem.Document", "com.amrita.jpl._21cys21070.endsem.Image", "com.amrita.jpl._21cys21070.endsem.Video"});
        form.add(typeComboBox);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        RefreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(RefreshButton);
        add(buttonPanel, BorderLayout.SOUTH);


        setTitle("21UCYS End Semester Assignment com.amrita.jpl._21cys21070.endsem.File Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}
public class File_Management_System{
        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagerGUI();
            }
        });
    }
}