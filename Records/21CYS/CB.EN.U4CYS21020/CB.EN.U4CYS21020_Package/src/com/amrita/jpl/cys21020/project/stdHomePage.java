package com.amrita.jpl.cys21020.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stdHomePage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel LMSLabel = new JLabel("Leave Management System");
    JLabel welcomeLabel = new JLabel("Hello!");
    JLabel logo = new JLabel();
    JButton applyLeavebtn = new JButton("Apply Leave");

    JButton logout = new JButton();
    JButton attendence = new JButton();
    JButton leaveHistory = new JButton();
    JButton announcement = new JButton();
    JButton od = new JButton();

    JButton ac = new JButton();

    String userID;

    private JFrame parentFrame;
    stdHomePage(String userID,JFrame parentframe){

        this.parentFrame = parentframe;
        this.userID = userID;
        ImageIcon icon = new ImageIcon("/home/pavan_9999/IdeaProjects/java programming lab final/src/com/amrita/jpl/cys21080/com.amrita.jpl.cys21013.project/images/3889524.png");
        ImageIcon amritalogo = new ImageIcon("/home/pavan_9999/IdeaProjects/java programming lab final/src/com/amrita/jpl/cys21080/com.amrita.jpl.cys21013.project/images/AMRIT-removebg-preview_2.png");

        logo.setIcon(amritalogo);
        logo.setBounds(30,0,350,100);

        LMSLabel.setBounds(130,120,400,30);
        LMSLabel.setFont(new Font("MV Boli",Font.BOLD,25));


        welcomeLabel.setBounds(320,35,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,18));
        welcomeLabel.setText("Hello "+userID);

        applyLeavebtn.setBounds(310, 320, 150, 30);
        applyLeavebtn.addActionListener(this);

        attendence.setText("View Attendance");
        attendence.setBounds(140,270,150,30);

        announcement.setText("Annoncements");
        announcement.setBounds(140,220,150,30);

        leaveHistory.setText("Leave History");
        leaveHistory.setBounds(310,220,150,30);

        od.setText("Apply Duty Leave");
        od.setBounds(310,270,150,30);

        ac.setText("Academic Calender");
        ac.setBounds(140,320,150,30);

        logout.setIcon(icon);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.setBounds(500,35,100,35);



        frame.add(od);
        frame.add(ac);
        frame.add(announcement);
        frame.add(leaveHistory);
        frame.add(attendence);
        frame.add(logo);
        frame.add(LMSLabel);
        frame.add(welcomeLabel);
        frame.add(applyLeavebtn);
        frame.add(logout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logout successful.", "Information", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();

                parentFrame.setVisible(true);
            }
        });

//        attendence.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AttendanceReportUI a = new AttendanceReportUI(userID);
//                a.show();
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==applyLeavebtn) {
            applyLeave al = new applyLeave(frame,"Student " );
            al.show();
            frame.setVisible(false);
        }



    }
}