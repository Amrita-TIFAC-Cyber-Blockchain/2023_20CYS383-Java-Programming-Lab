package com.amrita.jpl.cys21004.practice.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aishwarya GS
 */

public class Forms extends JFrame {

    /**
     * Basic Student form
     * @param args default argument
     */

    public Forms() {
        setTitle("Fields in New Lines");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        JLabel courseLabel = new JLabel("Course:");
        JLabel emailLabel = new JLabel("Email:");

        // Text fields
        JTextField nameTextField = new JTextField(20);
        JTextField rollNumberTextField = new JTextField(10);
        JTextField courseTextField = new JTextField(15);
        JTextField emailTextField = new JTextField(25);

        // Add components to the content pane with line breaks
        add(nameLabel);
        add(nameTextField);
        add(new JLabel("\n"));
        add(rollNumberLabel);
        add(rollNumberTextField);
        add(new JLabel("\n"));
        add(courseLabel);
        add(courseTextField);
        add(new JLabel("\n"));
        add(emailLabel);
        add(emailTextField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Forms();
    }
}

