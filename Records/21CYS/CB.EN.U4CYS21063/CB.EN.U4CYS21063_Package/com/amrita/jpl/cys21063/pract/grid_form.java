package com.amrita.jpl.cys21063.pract;


import javax.swing.*;
import java.awt.*;


public class grid_form extends JFrame {
    public grid_form() {
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
        JTextArea tarea1 = new JTextArea("S Adhwaith");
        JTextArea tarea2 = new JTextArea("adwaith@jpl.in");
        JTextArea tarea3 = new JTextArea("21-01-2004");
        JTextArea tarea4 = new JTextArea("8610619466");
        JTextArea tarea5 = new JTextArea("Enter Your Query");


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
        setVisible(true);
    }

    public static void main(String[] args) {
        new grid_form();}
}
