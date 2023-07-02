package com.amrita.jpl.cys21047.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 * @author = Vihal roy
 * @version 0.5
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("GridLayout Example");
        setSize(1250, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(8, 8));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Age", JLabel.CENTER);
        JLabel label3 = new JLabel("Sex", JLabel.CENTER);
        JLabel label4 = new JLabel("Email", JLabel.CENTER);
        JLabel label5 = new JLabel("Phone number",JLabel.CENTER);
        JLabel label6 = new JLabel("College Name", JLabel.CENTER);
        JLabel label7 = new JLabel("Department", JLabel.CENTER);
        JLabel label8 = new JLabel("Year of studying", JLabel.CENTER);

        // TextArea
        JTextArea tarea1 = new JTextArea("Vihal roy");
        JTextArea tarea2 = new JTextArea("19");
        JTextArea tarea3 = new JTextArea("MALE");
        JTextArea tarea4 = new JTextArea("roy@jbl.in");
        JTextArea tarea5 = new JTextArea("7702032499");
        JTextArea tarea6 = new JTextArea("Amrita");
        JTextArea tarea7 = new JTextArea("CYS");
        JTextArea tarea8 = new JTextArea("2");

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
        add(label6);
        add(tarea6);
        add(label7);
        add(tarea7);
        add(label8);
        add(tarea8);

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
