package com.amrita.jpl.cys21036.pract;


import javax.swing.*;
import java.awt.*;

public class form extends JFrame {


    public form() {
        setTitle("GridLayout Example");
        setSize(320, 200);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(5, 5));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);
        JLabel label3 = new JLabel("DOB", JLabel.CENTER);
        JLabel label4 = new JLabel("Phone number", JLabel.CENTER);
        JLabel label5 = new JLabel("query", JLabel.CENTER);

        // TextArea
        JTextArea tarea1 = new JTextArea("Ashwath");
        JTextArea tarea2 = new JTextArea("ashwath@jpl.in");
        JTextArea tarea3 = new JTextArea("22-10-2003");
        JTextArea tarea4 = new JTextArea("9344461823");
        JTextArea tarea5 = new JTextArea("enter your query");


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



        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new form();}
}