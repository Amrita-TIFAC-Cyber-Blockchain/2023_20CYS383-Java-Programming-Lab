package com.amrita.jpl.cys21087.pract.gui;

/**
 * - This is a simple forms using grid layout using java swing.
 * @author Vishnu
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
public class FormsUsingGridLayout extends JFrame {


    public FormsUsingGridLayout(){
        /**
         * this contains the program for teh forms
         */
        setTitle("Simple Form");
        setSize(400, 200);
        setLayout(new GridLayout(7, 2));


        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Roll no", JLabel.CENTER);
        JLabel label3 = new JLabel("Email", JLabel.CENTER);
        JLabel label4 = new JLabel("Phone no", JLabel.CENTER);
        JLabel label5 = new JLabel("Age", JLabel.CENTER);
        JLabel label6 = new JLabel("Address", JLabel.CENTER);

        JTextArea tarea1 = new JTextArea("");
        JTextArea tarea2 = new JTextArea("");
        JTextArea tarea3 = new JTextArea("");
        JTextArea tarea4 = new JTextArea("");
        JTextArea tarea5 = new JTextArea("");
        JTextArea tarea6 = new JTextArea("");

        JButton submitbutton = new JButton("Submit");

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

        add(submitbutton);
        setVisible(true);

    }
    public static void main(String[] args) {
        new FormsUsingGridLayout();
    }
}

