package com.amrita.jpl.cys21020.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class facHomePage implements ActionListener {

    private JFrame frame;
    private JLabel LMSLabel;
    private JLabel welcomeLabel;

    private JButton applyLeavebtn;
    private JButton logout;
    JLabel logo = new JLabel();

    private JFrame parentFrame;

    ImageIcon icon = new ImageIcon("C:/Users/HAI/IdeaProjects/Java final Cys 21020/src/com/amrita/jpl/cys21020/project/images/logout.jpeg");
    ImageIcon amritalogo = new ImageIcon("C:/Users/HAI/IdeaProjects/Java final Cys 21020/src/com/amrita/jpl/cys21020/project/images/Amritalogo.jpeg");


    public facHomePage(String userID, JFrame parentframe){
        this.parentFrame = parentframe;
        logo.setIcon(amritalogo);
        logo.setBounds(30,0,350,100);

        frame = new JFrame();
        LMSLabel = new JLabel("Leave Management System");
        welcomeLabel = new JLabel("Hello!");
        applyLeavebtn = new JButton();
        logout = new JButton();

        LMSLabel.setBounds(130,100,400,30);
        LMSLabel.setFont(new Font("MV Boli",Font.BOLD,25));


        welcomeLabel.setBounds(320,35,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,20));
        welcomeLabel.setText("Hello "+userID);


        logout.setIcon(icon);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.setBounds(500,35,100,35);

        applyLeavebtn.setText("Apply Leave");
        applyLeavebtn.setBounds(245, 450, 90, 30);
        applyLeavebtn.addActionListener(this);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==applyLeavebtn) {
            applyLeave al = new applyLeave(frame,"Faculty ");
            al.show();
            frame.setVisible(false);
        }

        if (e.getSource()==logout) {

        }
    }



}