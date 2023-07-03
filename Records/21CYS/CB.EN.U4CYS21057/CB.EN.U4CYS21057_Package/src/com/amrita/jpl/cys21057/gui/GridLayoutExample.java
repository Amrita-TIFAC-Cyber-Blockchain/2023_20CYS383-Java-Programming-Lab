package com.amrita.jpl.cys21057.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 * @author Pushpanth
 * @version 0.5
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("GridLayout Example");
        setSize(320, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(2, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name : ", JLabel.CENTER);
        JLabel label2 = new JLabel("Email : ", JLabel.CENTER);
        JLabel label3 = new JLabel("Phone No. : ", JLabel.CENTER);
        JLabel label4 = new JLabel("College : ", JLabel.CENTER);
        JLabel label5 = new JLabel("Course : ", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("Pushpanth");
        JTextArea tarea2 = new JTextArea("Push@jpl.in");
        JTextArea tarea3 = new JTextArea("123456789");
        JTextArea tarea4 = new JTextArea("Amrita");
        JTextArea tarea5 = new JTextArea("Cyber Security");


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
        new GridLayoutExample();
    }
}

