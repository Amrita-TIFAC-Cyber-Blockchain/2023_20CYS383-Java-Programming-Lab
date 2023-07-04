package com.amrita.jpl.cys21023.pract.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculatorGUI extends JFrame implements ActionListener {

    private JTextField inputField;

    public ScientificCalculatorGUI() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Create input field
        inputField = new JTextField();
        add(inputField, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
                "7", "8", "9", "4",
                "/", "5", "6", "2",
                "1", "*", "3", "0",
                "-", ".", "=", "+",
                "sin", "cos", "tan", "C",
                "mod"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("=")) {
            // Evaluate the expression
            String expression = inputField.getText();
            double result = evaluateExpression(expression);
            inputField.setText(Double.toString(result));
        } else if (action.equals("C")) {
            // Clear the input field
            inputField.setText("");
        } else if (action.equals("mod")) {
            // Calculate modulus
            String expression = inputField.getText();
            String[] numbers = expression.split(" ");
            if (numbers.length != 2) {
                JOptionPane.showMessageDialog(this, "Invalid mod expression");
                return;
            }

            try {
                double dividend = Double.parseDouble(numbers[0].trim());
                double divisor = Double.parseDouble(numbers[1].trim());
                double result = dividend % divisor;
                inputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid mod expression");
            }
        } else {
            // Append the button's label to the input field
            inputField.setText(inputField.getText() + action);
        }
    }

    private double evaluateExpression(String expression) {
        // Implement your own expression evaluation logic here
        // This is just a placeholder implementation
        return 0.0;
    }

    public static void main(String[] args) {
        new ScientificCalculatorGUI();
    }
}
