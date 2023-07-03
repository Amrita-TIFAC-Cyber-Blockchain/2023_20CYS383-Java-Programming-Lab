package com.amrita.jpl.cys21078.pract.gui;

import javax.swing.*;

/**
 * This is the form using Flowlayout
 * @author suvetha
 * @version 0.1
 */

public class myFlowLayout extends JFrame {
    /**
     * This is the constructor for the myFlowLayout class
     */
    public myFlowLayout() {
        // Set the title and size of the JFrame
        setTitle("FlowLayout Example");
        setSize(600, 80);
        //setSize(40, 220);

        // Specify what happens when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager to FlowLayout
        setLayout(new java.awt.FlowLayout());

        // Create labels
        JLabel label1 = new JLabel("Name");
        JLabel label2 = new JLabel("Roll Number");
        JLabel label3 = new JLabel("Phone Number");
        JLabel label4 = new JLabel("Address");
        JLabel label5 = new JLabel("State");

        // Create buttons
        JButton button1 = new JButton("Suvetha D P");
        JButton button2 = new JButton("CB.EN.U4CYS21078");
        JButton button3 = new JButton("9385365451");
        JButton button4 = new JButton("Coimbatore");
        JButton button5 = new JButton("Tamilnadu");
        JButton button6 = new JButton("Submit");

        // Add labels and buttons to the frame
        add(label1);
        add(button1);
        add(label2);
        add(button2);
        add(label3);
        add(button3);
        add(label4);
        add(button4);
        add(label5);
        add(button5);
        add(button6);
        // Make the frame visible
        setVisible(true);

    }
    // Main method to create an instance of myFlowLayout
    public static void main(String[] args) {
        // Create an instance of myFlowLayout with the specified parameters
        new myFlowLayout();
    }
}
