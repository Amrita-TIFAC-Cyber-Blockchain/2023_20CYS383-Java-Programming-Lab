package com.amrita.jpl.cys21066.pract.gui;

import javax.swing.*;
import java.awt.*;

public class FormLayoutAnokha extends JFrame {
    public FormLayoutAnokha() {
        setTitle("Anokha Form");
        setSize(400, 220); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed
        setLayout(new FlowLayout()); // Set the layout manager to FlowLayout

        // Labels
        JLabel label1 = new JLabel(" Full Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("College Mail id");
        JLabel label4 = new JLabel("Department");

        // Buttons
        JButton button1 = new JButton("D Sanjai Prashad");
        JButton button2 = new JButton("CB.EN.U4CYS21066");
        JButton button3 = new JButton("cb.en.u4cys21066@cb.students.amrita.edu");
        JButton button4 = new JButton("CYS");
        JButton button5 = new JButton("Submit");

        // Add components to the content pane
        add(label1);
        add(button1);
        add(label2);
        add(button2);
        add(label3);
        add(button3);
        add(label4);
        add(button4);
        add(button5);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormLayoutAnokha();
    }
}
