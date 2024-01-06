package com.amrita.jpl.cys21043.pract;



import javax.swing.*;
import java.awt.*;
public class gridlayout extends JFrame {
    public gridlayout() {
        setTitle("GridLayout Example");
        setSize(320, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(2, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);
        JLabel label3 = new JLabel("Age", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("Jasir");
        JTextArea tarea2 = new JTextArea("okok@gmail.com");
        JTextArea tarea3 = new JTextArea("");




        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);



        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new gridlayout();
    }
}

