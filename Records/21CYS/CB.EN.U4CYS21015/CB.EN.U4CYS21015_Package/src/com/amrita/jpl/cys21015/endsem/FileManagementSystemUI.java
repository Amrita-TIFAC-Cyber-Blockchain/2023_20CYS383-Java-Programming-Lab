package com.amrita.jpl.cys21015.endsem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @author Dyanesh S [CB.EN.U4CYS21015]
 * @version 1.0
 */

abstract class File
{
    private String fileName;
    private String fileSize;

    public File(String fileName, String fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileSize() {
        return fileSize;
    }
}

class Document extends File {
    String documentType;

    public Document(String fileName, String fileSize, String filetype) {
        super(fileName, fileSize);
        setDocumentType(filetype);
    }

    public void setDocumentType(String filetype)
    {
        documentType = filetype;
    }

    public String getDocumentType()
    {
        return documentType;
    }
}

class Image extends File
{
    String resolution;

    public Image(String fileName, String fileSize) {
        super(fileName, fileSize);
    }

    public String getResolution()
    {
        return resolution;
    }
}

class Video extends File
{
    String duration;

    public Video(String fileName, String fileSize) {
        super(fileName, fileSize);
    }

    public String getDuration()
    {
        return duration;
    }
}

interface FileManager
{
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}

class FileManagerImpl implements FileManager
{
    private ArrayList<File> files = new ArrayList<>();


    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                files.remove(file);
                return;
            }
        }

    }

    @Override
    public void displayAllFiles() {


    }

    public void saveToFile() {}


    public void loadFromFile()
        {}
}

public class FileManagementSystemUI extends FileManagerImpl
{

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public void addRecord(String filename, String filesize, String doctype)
    {
        if (filename.equals("") || filesize.equals(""))
        {
            JOptionPane.showMessageDialog(frame, "Please enter proper data.");
        }
        else {
            JTextField documentTypeField = new JTextField();
            JPanel docPanel = new JPanel(new GridLayout(0, 2));
            docPanel.add(new JLabel("Document Type:"));
            docPanel.add(documentTypeField);
            int result = JOptionPane.showConfirmDialog(frame, docPanel, "Add Document",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String documentType = documentTypeField.getText();
                Document document = new Document(filename, filesize, documentType);
            }
            tableModel.addRow(new Object[]{filename, filesize, doctype});
        }
    }


    public FileManagementSystemUI()
    {

        frame = new JFrame("File Management System");
        frame.setBounds(100, 100, 700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel fileDetailsPanel = new JPanel();
        fileDetailsPanel.setLayout(new GridLayout(1, 6));
        frame.getContentPane().add(fileDetailsPanel, BorderLayout.NORTH);

        JLabel nameLabel = new JLabel("File Name: ");
        JTextField nameText = new JTextField(2);

        JLabel sizeLabel = new JLabel("File Size: ");
        JTextField sizeText = new JTextField(2);

        JLabel typeLabel = new JLabel("File Type: ");
        String[] items = {"Document", "Image", "Video"};
        JComboBox<String> typeText = new JComboBox<>(items);

        fileDetailsPanel.add(nameLabel);
        fileDetailsPanel.add(nameText);
        fileDetailsPanel.add(sizeLabel);
        fileDetailsPanel.add(sizeText);
        fileDetailsPanel.add(typeLabel);
        fileDetailsPanel.add(typeText);


        // Create the table with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel actionButtonPanel = new JPanel();
        frame.getContentPane().add(actionButtonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecord(nameText.getText().trim(),sizeText.getText().trim(), (String) typeText.getSelectedItem());
            }
        });
        actionButtonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete File");
        deleteButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        //removefiles()
                        tableModel.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please select an entry to delete.");
                    }

        }});
        actionButtonPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
    //  refreshButton.addActionListener(new ActionListener() {

        actionButtonPanel.add(refreshButton);

        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        try
        {
            new FileManagementSystemUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
