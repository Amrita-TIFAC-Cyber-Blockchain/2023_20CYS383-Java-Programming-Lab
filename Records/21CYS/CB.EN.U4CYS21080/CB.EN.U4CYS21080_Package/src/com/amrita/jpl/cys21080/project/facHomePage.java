package com.amrita.jpl.cys21080.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class facHomePage implements ActionListener {

    private JFrame frame;
    private JLabel LMSLabel;
    private JLabel welcomeLabel;

    private JButton applyLeavebtn;

    private JButton make_annoncementsbtn;
    private JButton app_leavebtn;
    private JButton logout;
    JLabel logo = new JLabel();

    private JFrame parentFrame;

    ImageIcon icon = new ImageIcon("src/com/amrita/jpl/cys21080/project/images/3889524.png");
    ImageIcon amritalogo = new ImageIcon("src/com/amrita/jpl/cys21080/project/images/AMRIT-removebg-preview_2.png");


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

        make_annoncementsbtn = new JButton();
        make_annoncementsbtn.setText("Make Annoncements");
        make_annoncementsbtn.setBounds(110,270,180,30);
        make_annoncementsbtn.addActionListener(this);

        applyLeavebtn.setText("Apply Leave");
        applyLeavebtn.setBounds(330,270,150,30);

        applyLeavebtn.addActionListener(this);

        app_leavebtn = new JButton();
        app_leavebtn.setText("Approve Leave");
        app_leavebtn.setBounds(220,325,150,30);
        app_leavebtn.addActionListener(this);



        frame.add(logo);
        frame.add(LMSLabel);
        frame.add(welcomeLabel);
        frame.add(applyLeavebtn);
        frame.add(logout);
        frame.add(app_leavebtn);
        frame.add(make_annoncementsbtn);


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

        if (e.getSource()==make_annoncementsbtn) {

                JOptionPane.showMessageDialog(null, "Comming Soon !!!", "Information", JOptionPane.INFORMATION_MESSAGE);

        }

        if (e.getSource()==app_leavebtn) {
            JOptionPane.showMessageDialog(null, "No Requests till now.", "Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }



}