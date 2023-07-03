package com.amrita.jpl.cys21080.practice.gui.swing.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 * A Swing application that concatenates two text inputs and displays the result.
 * @author T Pavan Kumar Reddy
 */
public class concat implements ActionListener {

    private JTextField textField1;
    private JTextField textField2;
    private JButton button;
    private JLabel label;

    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        concat concatenator = new concat();
        concatenator.createGUI();
    }

    /**
     * Creates the graphical user interface (GUI) for the application.
     */
    private void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setTitle("Text Concatenation");

        // Create the text fields
        textField1 = new JTextField(20);
        textField1.setBounds(110, 20, 190, 25);
        textField2 = new JTextField(20);
        textField2.setBounds(110, 60, 190, 25);

        // Create the button
        button = new JButton("Concatenate");
        button.setBounds(135, 120, 140, 20);
        button.setFocusable(false);
        button.addActionListener(this);

        label = new JLabel();
        label.setBounds(155, 180, 140, 20);

        // Add the components to the frame
        frame.add(textField1);
        frame.add(textField2);
        frame.add(button);
        frame.add(label);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * Handles the button click event.
     *
     * @param e the ActionEvent representing the button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Concatenate the text from the text fields
            String text1 = textField1.getText();
            String text2 = textField2.getText();
            String concatenatedText = text1 + " " + text2;

            // Display the result in the label
            label.setText(concatenatedText);
        }
    }
}
