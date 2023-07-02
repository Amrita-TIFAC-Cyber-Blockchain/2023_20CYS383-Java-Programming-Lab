package com.amrita.jpl.cys21002.prac.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 * @author Achyuth Anand
 * @version 0.5
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("Form");
        setSize(640, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        setLayout(gridLayout);
        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);
        JLabel label3 = new JLabel("Role", JLabel.CENTER);
        JLabel label4 = new JLabel("CompanyID", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("");
        JTextArea tarea2 = new JTextArea("");
        JTextArea tarea3 = new JTextArea("");
        JTextArea tarea4 = new JTextArea("");


        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);
        add(label4);
        add(tarea4);


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
