package com.amrita.jpl.cys21016.pract.gui;
/**
 * A sample GUI using swing
 * @author G H Hem Sagar
 * @versio 1.0
 * */
import javax.swing.*;
import java.awt.*;
class form extends JFrame {
    /**
    * class Form inherits the methods from JFrame class to implement a simple form GUI*/

    public form() {
        /**
         * Constructor for Form class that
         * - sets the title
         * - sets the size
         * - specifies the layout to be used
         * - sets the default close operation of the window
         * - creates all the labels
         * - creates the required text areas.
         * - adds all the labels and text areas to the Layout
         * - sets the visibility of the layout to true i.e make it visible. */
        setTitle("Feedback Form");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));

        JLabel label1 = new JLabel("Name:", JLabel.CENTER);
        JLabel label2 = new JLabel("Email:", JLabel.CENTER);
        JLabel label5 = new JLabel("Role:", JLabel.CENTER);
        JLabel label3 = new JLabel("RoleID:", JLabel.CENTER);
        JLabel label4 = new JLabel("Mobile:", JLabel.CENTER);


        JButton submitButton = new JButton("Submit");

        JTextField tarea1 = new JTextField();
        JTextField tarea2 = new JTextField();
        JTextField tarea3 = new JTextField();
        JTextField tarea4 = new JTextField();
        JTextField tarea5 = new JTextField();
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
        add(submitButton);

        setVisible(true);


    }


    public static void main(String[] args) {
        /**
        * Instantiates the form class
        * @param args -> command line arguments*/
        new form();
    }
}
