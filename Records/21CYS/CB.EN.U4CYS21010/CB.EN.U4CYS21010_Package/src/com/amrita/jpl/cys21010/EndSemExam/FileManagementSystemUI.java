package com.amrita.jpl.cys21010.EndSemExam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


/***
 * Main class of the Code
 */
public class FileManagementSystemUI extends JFrame {

    DefaultTableModel tableModel;

    /**
     * constructor to start the ui
     */
    FileManagementSystemUI(){
        setTitle("EndSemExam");
        /**
         * define the size of the ui
         */
        setSize(590,520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * created a pane to strore upper part of the ui
         */
        JPanel pan1 = new JPanel(new  GridLayout(1,5));


        JLabel lab1 = new JLabel("File Name ");
        JTextArea txtArea1 = new JTextArea();


        JLabel lab2 = new JLabel("File Size ");
        JTextArea txtArea2 = new JTextArea();


        JLabel lab3 = new JLabel("File Type ");
        JComboBox jcb = new JComboBox<>(new String[]{"Document", "image","video"});

        pan1.add(lab1);
        pan1.add(txtArea1);

        pan1.add(lab2);
        pan1.add(txtArea2);

        pan1.add(lab3);
        pan1.add(jcb);

//        ------------------------------------------------------
        /**
         * the table to display the the content that has been added
         */
        JPanel pan2 = new JPanel(new GridLayout(1,3));
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(1,0);
        tableModel.addColumn("FileName");
        tableModel.addColumn("FileSize");
        tableModel.addColumn("FileType");
        table = new JTable(tableModel);



        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        pan2.add(tableScrollPane);


//        -----------------------------------------
        /**
         * button pannel
         */
        JPanel pan3 = new JPanel(new GridLayout(1,3));

        JButton but1 = new JButton("AddFile");
        JButton but2 = new JButton("DeleteFile");
        JButton but3 = new JButton("Refresh");


        pan3.add(but1);
        pan3.add(but2);
        pan3.add(but3);


//        ---------------------------------

        add(pan1,BorderLayout.NORTH);
        add(pan2);

        add(pan3,BorderLayout.SOUTH);
        setVisible(true);

        /**
         * action lisntaner for each button
         */
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField data = new JTextField(10);
                String fileName = txtArea1.getText();
                String fileSize = txtArea2.getText();
                String fileType = (String) jcb.getSelectedItem();
                System.out.println(fileType);
                if (fileType.equals("image")) {
                    int result = JOptionPane.showConfirmDialog(null, data, "Enter ImageRes", JOptionPane.OK_CANCEL_OPTION);
                }
                else if(fileType.equals("video")){
                    int result = JOptionPane.showConfirmDialog(null, data, "Enter video Duration", JOptionPane.OK_CANCEL_OPTION);

                }
                else if(fileType.equals("Document")){
                    int result = JOptionPane.showConfirmDialog(null, data, "Enter Document Type", JOptionPane.OK_CANCEL_OPTION);

                }
//                Object obj = new Object(){fileName,fileSize,fileType}
//                new Object[]{fileName,fileSize,fileType}
                tableModel.addRow(new Object[]{fileName,fileSize,fileType});
                try {
                    SaveFile(fileName,fileSize,fileType,data.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        /**
         * remove a row
         */
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableModel.removeRow(tableModel.getRowCount()-1);
            }
        });

        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });



    }

    /**
     * file handel to save the data create the file if it does not exist
     * @param fileName
     * @param fileSize
     * @param fileType
     * @param dsc
     */
    void SaveFile(String fileName,String fileSize,String fileType,String dsc) throws IOException {
        try {
            // Change the file path if required
            File obj = new File("./FileMangDataSet.txt");

            if (obj.createNewFile()) {

            } else {


            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter write = new FileWriter("FileMangDataSet.txt",true);
        write.write(fileName);
        write.write("\n");
        write.flush();
        write.close();


    }

    public static void main(String[] args) {
        new FileManagementSystemUI();
    }


}























