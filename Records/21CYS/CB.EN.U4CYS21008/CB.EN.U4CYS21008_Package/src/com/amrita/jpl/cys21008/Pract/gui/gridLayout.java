package com.amrita.jpl.cys21008.Pract.gui;



import javax.swing.*;
import java.awt.*;




/**
 * The gridLayout class represents a window with a GridLayout layout.
 * @Author:Anuvarshini M K
 */
public class gridLayout extends JFrame {

    /**
     * Constructs the gridLayout window.
     */
    public gridLayout() {
        setTitle("GridLayout Example");
        setSize(320, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(4, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);
        JLabel label3 = new JLabel("Residency", JLabel.CENTER);
        JLabel label4 = new JLabel("Student of Amrita?", JLabel.CENTER);

        // TextArea
        JTextArea tarea1 = new JTextArea("Anuvarshini M K");
        JTextArea tarea2 = new JTextArea("anu@jpl.in");
        JTextArea tarea3 = new JTextArea("India");
        JTextArea tarea4 = new JTextArea("Yes");

        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);
        add(label4);
        add(tarea4);

        setVisible(true);
    }

    /**
     * The main method to create and display the gridLayout window.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new gridLayout();
    }
}
