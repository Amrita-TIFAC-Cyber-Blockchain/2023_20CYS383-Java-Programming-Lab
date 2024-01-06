package com.amrita.jpl.cys21080.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendanceReportUI {
    private JFrame frame;
    private JTable table;
    private JLabel rollNumberLabel;
    private JFrame parentFrame;


    private JButton exit;

    public AttendanceReportUI(String rollNumber, JFrame parentframe) {
        this.parentFrame = parentframe;
        initialize(rollNumber);
    }

    private void initialize(String rollNumber) {
        frame = new JFrame();
        frame.setTitle("Attendance Report - Student: " + rollNumber);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Create a panel to hold the roll number label
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the roll number label and set its position
        rollNumberLabel = new JLabel(rollNumber);
        rollNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        topPanel.add(rollNumberLabel, BorderLayout.NORTH);


        exit = new JButton("Exit");
        exit.setBounds(280,200,100,30);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                parentFrame.setVisible(true);
            }
        });

        // Table data
        String[] columnNames = {"Course", "Total Days", "Days Present","Percentage(%)"};
        Object[][] data = {
                {"20AVP211", 30, 30,100.00},
                {"20CYS211", 30, 25,83.33},
                {"20CYS212", 30, 28,93.33},
                {"20CYS213", 30, 26,86.33},
                {"20CYS214", 30, 29,96.33},
                {"20CYS215", 30, 27,90.00}

        };

        // Create a table model with data
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a table with the model
        table = new JTable(model);
        table.setEnabled(false); // Disable editing

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(exit);
        // Add the scroll pane to the frame
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setResizable(false);
    }



    public void show() {
        frame.setVisible(true);
    }

}