package com.amrita.jpl.cys21074.pract.gui;
import javax.swing.*;
import java.awt.*;

/**
 * The {@code flow_form} class represents a GUI form using FlowLayout.
 */
public class flow_form extends JFrame {

    /**
     * Constructs a new flow_form object.
     * Sets up the frame and adds components using FlowLayout.
     */
    public flow_form() {
        setTitle("FlowLayout");
        setSize(600, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the FlowLayout as the layout manager for the frame
        setLayout(new FlowLayout());

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel(" Full Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("age");
        JLabel label4 = new JLabel("Vote for");

        // TextAreas
        JTextArea tarea1 = new JTextArea("Name");
        JTextArea tarea2 = new JTextArea("roll no.");
        JTextArea tarea3 = new JTextArea("Age in no.");
        JTextArea tarea4 = new JTextArea("Candidate's name");

        // Button
        JButton button = new JButton("Submit");

        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);
        add(label4);
        add(tarea4);
        add(button);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new flow_form();
    }
}
