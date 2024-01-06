package com.amrita.jpl.cys21008.Ex.Scientificcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A simple scientific calculator application.
 * @Author:Anuvarshini M K
 */
public class sciencalculator extends JFrame {

    private JTextField display;
    private String operator;
    private double operand1;
    private boolean isOperatorClicked;

    /**
     * Constructs an instance of sciencalculator.
     */
    public sciencalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the display field
        display = new JTextField(10);
        display.setEditable(false);

        // Create the number buttons
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");

        // Create the operator buttons
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonSine = new JButton("sin");
        JButton buttonCosine = new JButton("cos");
        JButton buttonTangent = new JButton("tan");
        JButton buttonExponential = new JButton("exp");
        JButton buttonSquareRoot = new JButton("sqrt");
        JButton buttonEquals = new JButton("=");

        // Create the clear button
        JButton buttonClear = new JButton("Clear");

        // Set layout
        setLayout(new BorderLayout());

        // Create panel for number buttons
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(4, 3));
        numberPanel.add(button1);
        numberPanel.add(button2);
        numberPanel.add(button3);
        numberPanel.add(button4);
        numberPanel.add(button5);
        numberPanel.add(button6);
        numberPanel.add(button7);
        numberPanel.add(button8);
        numberPanel.add(button9);
        numberPanel.add(button0);
        numberPanel.add(buttonClear);

        // Create panel for operator buttons
        JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(5, 1));
        operatorPanel.add(buttonPlus);
        operatorPanel.add(buttonMinus);
        operatorPanel.add(buttonMultiply);
        operatorPanel.add(buttonDivide);
        operatorPanel.add(buttonEquals);

        // Create panel for scientific buttons
        JPanel ScifiPanel = new JPanel();
        ScifiPanel.setLayout(new GridLayout(5, 1));
        ScifiPanel.add(buttonSine);
        ScifiPanel.add(buttonCosine);
        ScifiPanel.add(buttonTangent);
        ScifiPanel.add(buttonExponential);
        ScifiPanel.add(buttonSquareRoot);

        // Create panel for display and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.CENTER);
        mainPanel.add(operatorPanel, BorderLayout.EAST);
        mainPanel.add(ScifiPanel, BorderLayout.WEST);

        // Add main panel to the content pane
        Container container = getContentPane();
        container.add(mainPanel);

        // Add action listeners to buttons
        ActionListener numberListener = new NumberButtonListener();
        button1.addActionListener(numberListener);
        button2.addActionListener(numberListener);
        button3.addActionListener(numberListener);
        button4.addActionListener(numberListener);
        button5.addActionListener(numberListener);
        button6.addActionListener(numberListener);
        button7.addActionListener(numberListener);
        button8.addActionListener(numberListener);
        button9.addActionListener(numberListener);
        button0.addActionListener(numberListener);

        ActionListener operatorListener = new OperatorButtonListener();
        buttonPlus.addActionListener(operatorListener);
        buttonMinus.addActionListener(operatorListener);
        buttonMultiply.addActionListener(operatorListener);
        buttonDivide.addActionListener(operatorListener);
        buttonEquals.addActionListener(operatorListener);

        ActionListener scientificListener = new ScientificListener();
        buttonSine.addActionListener(scientificListener);
        buttonCosine.addActionListener(scientificListener);
        buttonTangent.addActionListener(scientificListener);
        buttonExponential.addActionListener(scientificListener);
        buttonSquareRoot.addActionListener(scientificListener);

        ActionListener clearListener = new ClearButtonListener();
        buttonClear.addActionListener(clearListener);

        // Add key listener to the display field
        KeyListener keyListener = new DisplayKeyListener();
        display.addKeyListener(keyListener);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * ActionListener implementation for number buttons.
     */
    private class NumberButtonListener implements ActionListener {
        /**
         * Invoked when a number button is clicked.
         * Appends the button's value to the display field.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            display.setText(display.getText() + buttonText);
        }
    }

    /**
     * ActionListener implementation for operator buttons.
     */
    private class OperatorButtonListener implements ActionListener {
        /**
         * Invoked when an operator button is clicked.
         * Handles the calculation based on the operator clicked.
         * Updates the display field with the result.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String currentText = display.getText();

            if (!isOperatorClicked) {
                operand1 = Double.parseDouble(currentText);
                operator = button.getText();
                display.setText("");
                isOperatorClicked = true;
            } else {
                double operand2 = Double.parseDouble(currentText);
                double result = performCalculation(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operand1 = result;
                operator = button.getText();
            }
        }

        /**
         * Performs the calculation based on the given operator and operands.
         *
         * @param operand1 the first operand
         * @param operand2 the second operand
         * @param operator the operator (+, -, *, /)
         * @return the result of the calculation
         */
        private double performCalculation(double operand1, double operand2, String operator) {
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }
            return result;
        }
    }

    /**
     * ActionListener implementation for scientific function buttons.
     */
    private class ScientificListener implements ActionListener {
        /**
         * Invoked when a scientific function button is clicked.
         * Calculates and updates the display field with the result of the function.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String function = button.getText();
            String currentText = display.getText();

            double operand = Double.parseDouble(currentText);
            double result = 0.0;

            switch (function) {
                case "sin":
                    result = Math.sin(Math.toRadians(operand));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(operand));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(operand));
                    break;
                case "sqrt":
                    result = Math.sqrt(operand);
                    break;
            }

            display.setText(String.valueOf(result));
        }
    }

    /**
     * ActionListener implementation for the clear button.
     */
    private class ClearButtonListener implements ActionListener {
        /**
         * Invoked when the clear button is clicked.
         * Clears the display field and resets the operator and operand values.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            operand1 = 0;
            operator = null;
            isOperatorClicked = false;
        }
    }

    /**
     * KeyListener implementation for the display field.
     */
    private class DisplayKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Not used
        }

        /**
         * Invoked when a key is pressed.
         * Handles numeric key inputs and operator key inputs.
         *
         * @param e the key event
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // Handle numeric key inputs
            if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                String digit = KeyEvent.getKeyText(keyCode);
                display.setText(display.getText() + digit);
            }

            // Handle operator key inputs
            if (keyCode == KeyEvent.VK_PLUS) {
                operatorButtonClicked("+");
            } else if (keyCode == KeyEvent.VK_MINUS) {
                operatorButtonClicked("-");
            } else if (keyCode == KeyEvent.VK_MULTIPLY) {
                operatorButtonClicked("*");
            } else if (keyCode == KeyEvent.VK_DIVIDE) {
                operatorButtonClicked("/");
            } else if (keyCode == KeyEvent.VK_EQUALS || keyCode == KeyEvent.VK_ENTER) {
                operatorButtonClicked("=");
            }
        }

        /**
         * Handles the operator button clicked based on the given operator.
         *
         * @param op the operator (+, -, *, /)
         */
        private void operatorButtonClicked(String op) {
            String currentText = display.getText();

            if (!isOperatorClicked) {
                operand1 = Double.parseDouble(currentText);
                operator = op;
                display.setText("");
                isOperatorClicked = true;
            } else {
                double operand2 = Double.parseDouble(currentText);
                double result = performCalculation(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operand1 = result;
                operator = op;
            }
        }

        /**
         * Performs the calculation based on the given operator and operands.
         *
         * @param operand1 the first operand
         * @param operand2 the second operand
         * @param operator the operator (+, -, *, /)
         * @return the result of the calculation
         */
        private double performCalculation(double operand1, double operand2, String operator) {
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }
            return result;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Not used
        }
    }

    /**

     The entry point of the calculator application.
     Creates an instance of the sciencalculator class and sets it to visible.
     /
     public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
     /*
     * Runs the calculator application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new sciencalculator().setVisible(true);
            }
        });
    }

}


