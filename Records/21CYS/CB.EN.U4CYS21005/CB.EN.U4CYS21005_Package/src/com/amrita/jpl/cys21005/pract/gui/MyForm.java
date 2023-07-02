package com.amrita.jpl.cys21005.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alagu Soundarya G
 * @version 1.0
 * GUI form created for practice
 */

public class MyForm extends JFrame {

    public MyForm() {
        setTitle("My Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7, 2));

        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Date Of Birth", JLabel.CENTER);
        JLabel label3 = new JLabel("Age", JLabel.CENTER);
        JLabel label4 = new JLabel("Email id", JLabel.CENTER);
        JLabel label5 = new JLabel("Course", JLabel.CENTER);
        JLabel label6 = new JLabel("Parents", JLabel.CENTER);
        JLabel label7 = new JLabel("College", JLabel.CENTER);

        JTextArea tarea1 = new JTextArea("Alagu Soundarya G");
        JTextArea tarea2 = new JTextArea("23/02/2004");
        JTextArea tarea3 = new JTextArea("19");
        JTextArea tarea4 = new JTextArea("alagusoundaryag@gmail.com");
        JTextArea tarea5 = new JTextArea("B Tech CSE (CYS)");
        JTextArea tarea6 = new JTextArea("Govindasamy N & Balamani G");
        JTextArea tarea7 = new JTextArea("Amrita Vishwa Vidyapeetham - Coimbatore");

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
        add(label6);
        add(tarea6);
        add(label7);
        add(tarea7);

        setVisible(true);

    }
    public static void main(String[] args) {
        new MyForm();
    }
}