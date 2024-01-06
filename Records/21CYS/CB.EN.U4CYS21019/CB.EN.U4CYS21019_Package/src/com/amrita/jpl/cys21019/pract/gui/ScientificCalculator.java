package com.amrita.jpl.cys21019.ex;

/**
 * This program gives a basic GUI program for scientific calculator .
 * @Author: Gokulachselvan C D
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {

    private JTextField inputField;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "C",
                "mod", "log"
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
            String expression = inputField.getText();
            double result = evaluateExpression(expression);
            inputField.setText(Double.toString(result));
        } else if (action.equals("C")) {
            inputField.setText("");
        } else {
            inputField.setText(inputField.getText() + action);
        }
    }

    private double evaluateExpression(String expression) {
        try {
            if (expression.contains("+")) {
                String[] numbers = expression.split("\\+");
                double operand1 = Double.parseDouble(numbers[0]);
                double operand2 = Double.parseDouble(numbers[1]);
                return operand1 + operand2;
            } else if (expression.contains("-")) {
                String[] numbers = expression.split("-");
                double operand1 = Double.parseDouble(numbers[0]);
                double operand2 = Double.parseDouble(numbers[1]);
                return operand1 - operand2;
            } else if (expression.contains("*")) {
                String[] numbers = expression.split("\\*");
                double operand1 = Double.parseDouble(numbers[0]);
                double operand2 = Double.parseDouble(numbers[1]);
                return operand1 * operand2;
            } else if (expression.contains("/")) {
                String[] numbers = expression.split("/");
                double operand1 = Double.parseDouble(numbers[0]);
                double operand2 = Double.parseDouble(numbers[1]);
                return operand1 / operand2;
            } else if (expression.contains("mod")) {
                String[] numbers = expression.split("mod");
                double operand1 = Double.parseDouble(numbers[0]);
                double operand2 = Double.parseDouble(numbers[1]);
                return operand1 % operand2;
            } else if (expression.contains("log")) {
                String[] numbers = expression.split("log");
                double operand = Double.parseDouble(numbers[1]);
                return Math.log10(operand);
            } else {
                return 0.0;
            }
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
