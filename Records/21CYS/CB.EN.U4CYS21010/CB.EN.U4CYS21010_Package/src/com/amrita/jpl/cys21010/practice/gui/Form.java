package com.amrita.jpl.cys21010.practice.gui;

import javax.swing.*;
import java.awt.*;

 class Form extends JFrame {


    public Form() {
        setTitle("Form ");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));

        JLabel label1 = new JLabel("Name:-", JLabel.CENTER);
        JLabel label2 = new JLabel("Email:-", JLabel.CENTER);
        JLabel label3 = new JLabel("RollNo", JLabel.CENTER);
        JLabel label4 = new JLabel("Team Name:-", JLabel.CENTER);
        JLabel label5 = new JLabel("Team size:-", JLabel.CENTER);

        JButton button = new JButton("Submit");

        JTextArea tarea1 = new JTextArea("Arjun C Santhosh");
        JTextArea tarea2 = new JTextArea("csarjun11@gmail.com");
        JTextArea tarea3 = new JTextArea("CB.EN.U4CYS21010");
        JTextArea tarea4 = new JTextArea("TheTeam");
        JTextArea tarea5 = new JTextArea("4");



        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);
        add(label4);
        add(tarea4);
        add(label5);
        add(tarea5);
        add(button);



        setVisible(true);
    }


    public static void main(String[] args) {
        new Form();
    }
}

