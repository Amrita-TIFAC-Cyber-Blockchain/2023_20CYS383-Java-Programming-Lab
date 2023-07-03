package com.amrita.jpl.cys21055.prac.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Penugonda V S Ganasekhar
 * @version 0.1
 * A general form example with text fields, radio buttons, and a submit button.
 * The entered data is displayed in a text area.
 */
public class GeneralFormExample extends JFrame {
    private JTextField[] fields;
    private JTextArea resultArea;
    private JRadioButton radioButton;

    /**
     * Constructs a GeneralFormExample object.
     */
    public GeneralFormExample() {
        setTitle("General Form Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create the form components
        String[] labels = {"First Name:", "Last Name:", "Age:", "E-mail:", "Roll Number:", "Height:", "University:",
                "Mobile Number:"};
        fields = new JTextField[labels.length];
        JPanel formPanel = new JPanel(new GridLayout(labels.length, 2));

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(2);
            formPanel.add(label);
            formPanel.add(fields[i]);
        }

        JLabel radioLabel = new JLabel("Gender:");
        radioButton = new JRadioButton("Male");
        radioButton.setSelected(true);
        JRadioButton radioButton2 = new JRadioButton("Female");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton);
        buttonGroup.add(radioButton2);

        formPanel.add(radioLabel);
        formPanel.add(radioButton);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(radioButton2);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle form submission
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < labels.length; i++) {
                    String fieldValue = fields[i].getText();
                    result.append(labels[i]).append(" ").append(fieldValue).append("\n");
                }

                String selectedOption = radioButton.isSelected() ? "Male" : "Female";
                result.append("Selected Option: ").append(selectedOption).append("\n");

                // Display the entered data in the result area
                resultArea.setText(result.toString());
            }
        });

        // Create the form layout
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);

        resultArea = new JTextArea(10, 1);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        add(submitButton, BorderLayout.SOUTH);
    }

    /**
     * The main method creates an instance of the GeneralFormExample class and makes it visible.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeneralFormExample form = new GeneralFormExample();
                form.setVisible(true);
            }
        });
    }
}
