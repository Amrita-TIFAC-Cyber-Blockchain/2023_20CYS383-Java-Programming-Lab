package com.amrita.jpl.cys21022.pract.gui;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    public GridLayoutExample() {
        JFrame frame = new JFrame("Feedback Form");
        frame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Full Name:");
        JLabel rollNoLabel = new JLabel("Roll No:");
        JLabel subjectLabel = new JLabel("Subject:");
        JLabel mentorLabel = new JLabel("Mentor:");
        JLabel messageLabel = new JLabel("Message:");

        JTextField nameField = new JTextField(20);
        JTextField rollNoField = new JTextField(20);
        JTextField subjectField = new JTextField(20);
        JTextField mentorField = new JTextField(20);
        JTextField messageField = new JTextField(20);

        JButton submitButton = new JButton("Submit");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollNoLabel);
        frame.add(rollNoField);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(mentorLabel);
        frame.add(mentorField);
        frame.add(messageLabel);
        frame.add(messageField);
        frame.add(submitButton);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
