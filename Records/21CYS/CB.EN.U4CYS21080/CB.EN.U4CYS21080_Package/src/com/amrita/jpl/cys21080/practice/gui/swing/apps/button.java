package com.amrita.jpl.cys21080.practice.gui.swing.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI application that demonstrates the usage of a button and label.
 * When the button is clicked, the label is displayed.
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
public class button implements ActionListener {
    private JLabel label;
    private JButton button;

    public static void main(String[] args) {
        button example = new button();
        example.createUI();
    }

    /**
     * Creates the user interface for the application.
     */
    private void createUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle("My First Button");
        frame.setLayout(null);

        button = new JButton();
        button.setBounds(150, 170, 100, 50);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setText("Click me!");
        button.addActionListener(this);

        label = new JLabel();
        label.setText("Button Clicked");
        label.setOpaque(true);
        label.setBounds(155, 250, 200, 30);
        label.setVisible(false);

        frame.add(button);
        frame.add(label);
        frame.setVisible(true);
    }

    /**
     * Handles the button click event.
     *
     * @param e the ActionEvent representing the button click
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setVisible(true);
        }
    }
}
