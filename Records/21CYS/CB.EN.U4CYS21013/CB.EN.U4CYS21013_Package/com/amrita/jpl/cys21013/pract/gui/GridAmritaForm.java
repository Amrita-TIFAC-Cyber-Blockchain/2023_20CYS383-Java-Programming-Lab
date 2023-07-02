package com.amrita.jpl.cys21013.pract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 * @author Basi Reddy Rohith Reddy
 * @version 1.0
 */
public class GridAmritaForm extends JFrame {

    private List<JTextField> textFields;

    public GridAmritaForm() {
        setTitle("College Competition Application");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(0, 2, 10, 10));

        // Create and add components to the content pane

        // Form fields
        textFields = new ArrayList<>();
        addFormField("Full Name");
        addFormField("Roll Number");
        addFormField("Department");
        addFormField("Year of Study");
        addFormField("Email");
        addFormField("Phone Number");

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });
        add(submitButton);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Helper method to add a form field to the content pane.
     *
     * @param label the label of the form field
     */
    private void addFormField(String label) {
        JLabel formLabel = new JLabel(label);
        JTextField textField = new JTextField(20);
        textFields.add(textField);

        add(formLabel);
        add(textField);
    }

    /**
     * Retrieves the values from the form fields and displays them.
     */
    private void submitForm() {
        System.out.println("Form submitted!");

        for (int i = 0; i < textFields.size(); i++) {
            String label = textFields.get(i).getText();
            String value = textFields.get(++i).getText();
            System.out.println(label + ": " + value);
        }
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridAmritaForm();
            }
        });
    }
}
