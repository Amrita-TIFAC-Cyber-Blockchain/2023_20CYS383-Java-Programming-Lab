package com.amrita.jpl.cys21012.endsem;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class FileManagementSystemUI extends FileManagerImpl{
    /**
     * @author : Ashwin Anand
     * @project : File management system with gui
     */
    private JTable table;
    private JFrame frame;
    private DefaultTableModel tableModel;

    /**
     * Write a basic java swing GUI application that takes inputs and adds to an array
     */
    public void init() {
        frame = new JFrame("File Manager");
        frame.setBounds(150, 150, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());


        // Create the table with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("FIle Type");
        JTable doc_tab = new JTable(tableModel);
        JScrollPane SP = new JScrollPane(doc_tab);
        frame.getContentPane().add(SP, BorderLayout.CENTER);

        // Input panel
        JPanel inpPanel = new JPanel();
        frame.getContentPane().add(inpPanel,BorderLayout.NORTH);
        JLabel fn1 = new JLabel("File name: ");
        inpPanel.add(fn1);
        JTextField fileName1 = new JTextField("                                 ");
        inpPanel.add(fileName1);
        JLabel fn2 = new JLabel("File size: ");
        inpPanel.add(fn2);
        JTextField fileName3 = new JTextField("                                 ");
        inpPanel.add(fileName3);
        JLabel fn3 = new JLabel("File type: ");
        inpPanel.add(fn3);

        String choices[] = {"Document","Image","Video"};
        JComboBox<String> choice = new JComboBox<>(choices);
        inpPanel.add(choice);



        // Create buttons
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add Files");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fnf = fileName1.getText().trim();
                String fsf = fileName3.getText().trim();
                String fcf = choice.getSelectedItem().toString().trim();
                int chk = 0;
                if (fcf.equals("Document")){
                    Document test = new Document();
                    chk = test.getDocumentType();
                } else if (fcf.equals("Image")) {
                    Image test = new Image();
                    chk = test.getResolution();
                } else{
                    Video test = new Video();
                    chk = test.getDuration();
                }

                if (chk == 1) {
                    file FILE = new file(fnf, fsf);
//                  files.add(FILE);
                    tableModel.addRow(new Object[]{fnf, fsf, fcf});
                }
            }
        });
        buttonPanel.add(addButton);

        JButton remButt = new JButton("Remove file");
        remButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = doc_tab.getSelectedRow();
                if (selectedRow >= 0) {
//                    files.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a file to delete.");
                }
            }
        });
        buttonPanel.add(remButt);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        buttonPanel.add(refresh);

        frame.setVisible(true);

    }

    public static void main(String args[]){
        FileManagementSystemUI Fs = new FileManagementSystemUI();
        Fs.init();
    }
}
