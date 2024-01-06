package com.amrita.jpl.cys21048.pract.gui;

import javax.swing.*;
import java.awt.*;

public class grid {


    /**

     *gridlayout practice
     */
    public class Grid extends JFrame {

        /**
         * Constructs the GridLayoutExample window.
         */
        public Grid() {
            setTitle("GridLayout Example");
            setSize(320, 80);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the GridLayout as the layout manager for the frame
            setLayout(new GridLayout(2, 2));

            // Create and add components to the content pane

            // Labels
            JLabel label1 = new JLabel("Name", JLabel.CENTER);
            JLabel label2 = new JLabel("Email", JLabel.CENTER);
            JLabel label3 = new JLabel("college", JLabel.CENTER);
            JLabel label4 = new JLabel("place", JLabel.CENTER);


            // TextArea
            JTextArea tarea1 = new JTextArea("Niran R");
            JTextArea tarea2 = new JTextArea("niranmovene@gmail.com");
            JTextArea tarea3 = new JTextArea("amrita");
            JTextArea tarea4 = new JTextArea("coimbatore");


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
            new grid();
        }
    }


}
