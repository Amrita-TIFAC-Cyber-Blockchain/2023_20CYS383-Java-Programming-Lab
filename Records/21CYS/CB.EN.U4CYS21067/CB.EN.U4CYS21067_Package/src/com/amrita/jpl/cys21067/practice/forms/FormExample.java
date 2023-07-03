package com.amrita.jpl.cys21067.practice.forms;
import javax.swing.*;
import java.awt.*;

/**
 * The FormExample class represents a simple form GUI.
 */
public class FormExample extends JFrame {

    /**
     * Constructs a new FormExample object.
     */
    public FormExample() {
        // Set the layout manager to GridLayout with 7 rows and 2 columns
        setLayout(new GridLayout(7, 2, 10, 10)); // Adjusted gap between components to improve spacing

        // Create and add form elements
        add(new JLabel("Name:"));
        add(new JTextField(20)); // Reduced size of text field

        add(new JLabel("Email:"));
        add(new JTextField(20));

        add(new JLabel("Address:"));
        add(new JTextArea(4, 20)); // Reduced size of text area

        add(new JLabel("Phone:"));
        add(new JTextField(20));

        add(new JLabel("City:"));
        add(new JTextField(20));

        add(new JLabel("State:"));
        add(new JTextField(20));

        add(new JLabel("Country:"));
        add(new JTextField(20));

        add(new JLabel("Username:"));
        add(new JTextField(20));

        add(new JLabel("Password:"));
        add(new JPasswordField(20));

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 2));
        genderPanel.add(new JRadioButton("Male"));
        genderPanel.add(new JRadioButton("Female"));
        add(genderPanel);

        add(new JLabel("Interests:"));
        JPanel interestsPanel = new JPanel();
        interestsPanel.setLayout(new GridLayout(3, 1));
        interestsPanel.add(new JCheckBox("Sports"));
        interestsPanel.add(new JCheckBox("Music"));
        interestsPanel.add(new JCheckBox("Art"));
        add(interestsPanel);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        // Set JFrame properties
        setTitle("Form Example");
        setSize(917, 425);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The main method creates and shows an instance of the FormExample class.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormExample::new);
    }
}
