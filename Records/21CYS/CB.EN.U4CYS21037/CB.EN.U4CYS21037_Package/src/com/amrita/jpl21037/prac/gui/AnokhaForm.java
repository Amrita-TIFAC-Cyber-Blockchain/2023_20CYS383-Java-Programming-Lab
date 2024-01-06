package com.amrita.jpl21037.prac.gui;


import javax.swing.*;
import java.awt.*;


/**
 * @author ganesh
 */

public class AnokhaForm extends JFrame {
    public AnokhaForm(){
        setTitle("Anokha Registration Form");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Phone number", JLabel.CENTER);
        JLabel label3 = new JLabel("Email", JLabel.CENTER);
        JLabel label4 = new JLabel("Gender", JLabel.CENTER);
        JLabel label5 = new JLabel("Age", JLabel.CENTER);
        JButton button4 = new JButton("Submit");


        JTextArea tarea1 = new JTextArea("ganesh");
        JTextArea tarea2 = new JTextArea("9550871799");
        JTextArea tarea3 = new JTextArea("ganesh@gmail.com");
        JTextArea tarea4 = new JTextArea("Male");
        JTextArea tarea5 = new JTextArea("20");

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
        add(button4);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnokhaForm();
    }
}