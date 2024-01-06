package com.amrita.jpl.cys21007.pract.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 @author Abi G
  * @author Anu Priya P
 *
 * @parameters none
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("GridLayout Example");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(10, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Roll Number", JLabel.CENTER);
        JLabel label3 = new JLabel("Date Of Birth", JLabel.CENTER);
        JLabel label4 = new JLabel("College Name", JLabel.CENTER);
        JLabel label5 = new JLabel("Phone Number", JLabel.CENTER);
        JLabel label6 = new JLabel("Department", JLabel.CENTER);
        JLabel label7 = new JLabel("Email", JLabel.CENTER);
        JLabel label8 = new JLabel("Accommodation needed", JLabel.CENTER);
        JLabel label9 = new JLabel("Submit", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("Abinesh G");
        JTextArea tarea2 = new JTextArea("CB.EN.U4CYS21001");
        JTextArea tarea3 = new JTextArea("11/10/03");
        JTextArea tarea4 = new JTextArea("Amrita Vishwa Vidyapeetham");
        JTextArea tarea5 = new JTextArea("6385919032");
        JTextArea tarea6 = new JTextArea("CSE - CYS");
        JTextArea tarea7 = new JTextArea("abineshiba080@gmail.com");
        JTextArea tarea8 = new JTextArea("Yes");




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
        add(label9);




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

