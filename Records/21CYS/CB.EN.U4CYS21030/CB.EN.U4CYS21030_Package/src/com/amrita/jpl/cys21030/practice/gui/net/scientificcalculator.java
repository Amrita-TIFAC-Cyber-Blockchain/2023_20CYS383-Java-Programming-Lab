package com.amrita.jpl.cys21030.practice.gui.net;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class scientificcalculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel resultLabel;

    public scientificcalculator() {
        // Set frame properties
        setTitle("Scientific Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        inputField = new JTextField(20);
        resultLabel = new JLabel("Result:");

        JButton sinButton = new JButton("sin");
        JButton cosButton = new JButton("cos");
        JButton tanButton = new JButton("tan");
        JButton modButton = new JButton("mod");

        // Add action listeners
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        modButton.addActionListener(this);

        // Create panel and add components
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(modButton);

        // Add panel and result label to the frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputField, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(resultLabel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScientificCalculatorGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        double value = Double.parseDouble(input);
        double result = 0;

        if (e.getActionCommand().equals("sin")) {
            result = Math.sin(value);
        } else if (e.getActionCommand().equals("cos")) {
            result = Math.cos(value);
        } else if (e.getActionCommand().equals("tan")) {
            result = Math.tan(value);
        } else if (e.getActionCommand().equals("mod")) {
            result = Math.abs(value);
        }

        resultLabel.setText("Result: " + result);
    }
}
