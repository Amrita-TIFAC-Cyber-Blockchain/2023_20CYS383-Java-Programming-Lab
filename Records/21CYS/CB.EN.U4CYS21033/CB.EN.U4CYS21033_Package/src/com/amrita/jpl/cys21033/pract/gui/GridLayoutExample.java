package com.amrita.jpl.cys21033.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 * @author Suhitha K
 * @version 0.5
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("Anokha Form");
        setSize(20, 40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(5, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);
        JLabel label3 = new JLabel("Rollno", JLabel.CENTER);
        JLabel label4 = new JLabel("Department", JLabel.CENTER);
        JLabel label5 = new JLabel("Semester", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("Suhitha K");
        JTextArea tarea2 = new JTextArea("Suhitha@jpl.in");
        JTextArea tarea3 = new JTextArea("cys21033");
        JTextArea tarea4 = new JTextArea("CyberSecurity");
        JTextArea tarea5 = new JTextArea("4th");




        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label3);
        add(tarea3);
        add(label2);
        add(tarea2);
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

