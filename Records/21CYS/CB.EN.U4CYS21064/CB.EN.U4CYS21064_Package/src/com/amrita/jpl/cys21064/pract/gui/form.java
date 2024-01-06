package com.amrita.jpl.cys21064.pract.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

/**
 * This class represents a simple form using Swing in Java.
 * It creates a form window with labels, text areas, and a submit button.
 * The form displays information such as name, email, roll number, team name, and team size.
 *
 * Note: The form is created using the GridLayout manager.
 *
 * @author Rajendraprasad S
 */
class form extends JFrame {

    /**
     * Constructs a form object and initializes the form window.
     * It sets the title, size, and default close operation of the form.
     * The form components such as labels, text areas, and button are added using the GridLayout manager.
     */
    public form() {
        setTitle("Anokha");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));

        JLabel label1 = new JLabel("Name: ", JLabel.CENTER);
        JLabel label2 = new JLabel("Email: ", JLabel.CENTER);
        JLabel label3 = new JLabel("Roll No: ", JLabel.CENTER);
        JLabel label4 = new JLabel("Team name: ", JLabel.CENTER);
        JLabel label5 = new JLabel("Team size: ", JLabel.CENTER);

        JButton button = new JButton("Submit");

        JTextArea tarea1 = new JTextArea("Rajendraprasad S");
        JTextArea tarea2 = new JTextArea("rajendraprasadsakthi@gmail.com");
        JTextArea tarea3 = new JTextArea("CB.EN.U4CYS21064");
        JTextArea tarea4 = new JTextArea("PotatoFirstSearch");
        JTextArea tarea5 = new JTextArea("4");

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
        add(button);

        setVisible(true);
    }

    /**
     * The main method of the form class.
     * It creates an instance of the form object.
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        new form();
    }
}
