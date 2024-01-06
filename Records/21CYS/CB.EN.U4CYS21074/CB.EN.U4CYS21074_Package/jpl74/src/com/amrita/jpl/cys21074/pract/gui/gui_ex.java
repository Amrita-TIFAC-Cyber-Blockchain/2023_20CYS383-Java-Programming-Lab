package com.amrita.jpl.cys21074.pract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code guiDemo} class represents a GUI demo with a button that changes the background color when clicked.
 */
class guiDemo implements ActionListener {
    JFrame frame = new JFrame("20CYS383 - Java Programming Lab");
    JButton button1 = new JButton("Welcome Demo");

    /**
     * Constructs a new guiDemo object.
     * Sets up the frame and button, and registers the ActionListener.
     */
    guiDemo() {
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,400,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.setBounds(130,200,150,40);
        frame.getContentPane().add(button1);
        frame.setVisible(true);

        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Changing Background Color
        frame.getContentPane().setBackground(Color.BLUE);
    }
}

/**
 * The {@code gui_ex} class is the main class to run the GUI demo.
 */
public class gui_ex {
    public static void main(String args[]){
        new guiDemo();
    }
}
