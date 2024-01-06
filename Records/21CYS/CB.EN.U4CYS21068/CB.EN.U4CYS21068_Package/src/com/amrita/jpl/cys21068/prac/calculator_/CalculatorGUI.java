package com.amrita.jpl.cys21068.prac.calculator_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a calculator GUI.
 */
public class CalculatorGUI extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        number1Field = new JTextField(10);
        number2Field = new JTextField(10);
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        resultLabel = new JLabel();

        setLayout(new FlowLayout());

        add(new JLabel("Number 1: "));
        add(number1Field);

        add(new JLabel("Number 2: "));
        add(number2Field);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        add(resultLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.ADD);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.SUBTRACT);
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.MULTIPLY);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.DIVIDE);
            }
        });
    }

    private void performOperation(Operation operation) {
        double number1 = Double.parseDouble(number1Field.getText());
        double number2 = Double.parseDouble(number2Field.getText());

        double result = 0.0;
        String operationName = "";

        switch (operation) {
            case ADD:
                result = number1 + number2;
                operationName = "Addition";
                break;
            case SUBTRACT:
                result = number1 - number2;
                operationName = "Subtraction";
                break;
            case MULTIPLY:
                result = number1 * number2;
                operationName = "Multiplication";
                break;
            case DIVIDE:
                if (number2 != 0) {
                    result = number1 / number2;
                    operationName = "Division";
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        resultLabel.setText(operationName + ": " + number1 + " " + operation.getSymbol() + " " + number2 + " = " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
    }

    /**
     * Represents the available calculator operations.
     */
    private enum Operation {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
