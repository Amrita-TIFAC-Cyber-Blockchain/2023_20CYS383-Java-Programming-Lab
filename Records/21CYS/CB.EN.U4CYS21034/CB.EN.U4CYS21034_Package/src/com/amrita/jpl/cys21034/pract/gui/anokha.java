package com.amrita.jpl.cys21034.prac.gui;

import javax.swing.*;
import java.awt.*;

/**
 * anokha class inheriting JFrame
 */
public class anokha extends JFrame{
    public anokha()
    {
        setTitle("Anokha Register Page");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));

        JLabel label1 = new JLabel(" First Name");
        JLabel label5 = new JLabel("Last Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("DOB");
        JLabel label4 = new JLabel(" Mail");

        JTextArea area1 = new JTextArea();
        JTextArea area2 = new JTextArea();
        JTextArea area3 = new JTextArea();
        JTextArea area4 = new JTextArea();
        JTextArea area5 = new JTextArea();
        JButton button6 = new JButton("register");

        add(label1);
        add(area1);

        add(label2);
        add(area2);

        add(label3);
        add(area3);
        add(label4);
        add(area4);

        add(label5);
        add(area5);

        add(button6);

        setVisible(true);
    }
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        new anokha();
    }
}
