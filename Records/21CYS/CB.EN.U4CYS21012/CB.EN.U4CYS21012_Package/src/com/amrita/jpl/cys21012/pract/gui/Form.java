package com.amrita.jpl.cys21012.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * The Form class represents a GUI form window that allows the user to enter information
 * @author Ashwin Anand
 */
class Form extends JFrame {

    /**
     * Constructs a new Form object.
     * Configures the form window with title, size, and layout.
     * Adds labels, text areas, and a button to the form.
     */
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

        JTextArea tarea1 = new JTextArea("Ashwin Anand");
        JTextArea tarea2 = new JTextArea("mail2ashwina@gmail.com.com");
        JTextArea tarea3 = new JTextArea("CB.EN.U4CYS21012");
        JTextArea tarea4 = new JTextArea("_c4rdb04rd_");
        JTextArea tarea5 = new JTextArea("3");
        JOptionPane opt = new JOptionPane("");
        JButton button1 = new JButton("Submit");

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
//        add();
        add(button);

        setVisible(true);
    }

    /**
     * The main method is the entry point of the program.
     * It creates a new Form object to display the form window.
     *
     * @param args The command-line arguments passed to the program (not used in this code).
     */
    public static void main(String[] args) {
        new Form();
    }
}
