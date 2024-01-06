package com.amrita.jpl.cys21067.practice.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `guiDemo` class demonstrates a simple GUI program using Swing.
 * It creates a JFrame window with a button, and when the button is clicked,
 * the background color of the window changes to blue.
 *
 * @author Dharmik S
 * @version 0.1
 */
class guiDemo implements ActionListener {
    JFrame frame = new JFrame("20CYS383 - Java Programming Lab");
    JButton button1 = new JButton("Welcome Demo");

    /**
     * Constructs a `guiDemo` object and initializes the GUI components.
     */
    guiDemo() {
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400, 400, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.setBounds(130, 200, 150, 40);
        frame.getContentPane().add(button1);
        frame.setVisible(true);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Changing Background Color
        frame.getContentPane().setBackground(Color.blue);
    }
}

/**
 * The `sampleUi` class serves as an entry point for the program and launches the GUI demo.
 */
public class sampleUi {
    /**
     * The main method creates an instance of the `guiDemo` class, triggering the GUI demo.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String args[]) {
        new guiDemo();
    }
}
