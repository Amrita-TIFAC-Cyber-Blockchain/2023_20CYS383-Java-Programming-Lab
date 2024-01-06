package com.amrita.jpl.cys21004.practice.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

/**
 * Scientific improved calculator
 *
 * @author Aishwarya GS
 *
 * @param operand1 the first operand
 * @param operand2 the second operand
 * @param operator the operator
 *@return the result of the calculation
 *
 */

public class scientificCalculator extends JFrame {

    private JTextField display;

    private String operator;
    private double operand1;
    private boolean isOperatorClicked;

    public scientificCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField(10);
        display.setEditable(false);

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

        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonSin = new JButton("Sin");
        JButton buttonCos = new JButton("Cos");
        JButton buttonTan = new JButton("Tan");
        JButton buttonEquals = new JButton("=");

        JButton buttonClear = new JButton("Clear");

        setLayout(new BorderLayout());

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

        JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(5, 1));
        operatorPanel.add(buttonPlus);
        operatorPanel.add(buttonMinus);
        operatorPanel.add(buttonMultiply);
        operatorPanel.add(buttonDivide);
        operatorPanel.add(buttonSin);
        operatorPanel.add(buttonCos);
        operatorPanel.add(buttonTan);
        operatorPanel.add(buttonEquals);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.CENTER);
        mainPanel.add(operatorPanel, BorderLayout.EAST);

        Container container = getContentPane();
        container.add(mainPanel);

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
        buttonSin.addActionListener(operatorListener);
        buttonCos.addActionListener(operatorListener);
        buttonTan.addActionListener(operatorListener);
        buttonEquals.addActionListener(operatorListener);

        ActionListener clearListener = new ClearButtonListener();
        buttonClear.addActionListener(clearListener);

        KeyListener keyListener = new DisplayKeyListener();
        display.addKeyListener(keyListener);

        pack();
        setLocationRelativeTo(null);
    }


    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            display.setText(display.getText() + buttonText);
        }
    }


    private class OperatorButtonListener implements ActionListener {
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
                case "sin":
                    result = Math.sin(operand1);
                    break;
                case "cos":
                    result = Math.cos(operand1);
                    break;
                case "tan":
                    result = Math.tan(operand1);
            }
            return result;
        }
    }


    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            operand1 = 0;
            operator = null;
            isOperatorClicked = false;
        }
    }

    private class DisplayKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Not used
        }

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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new scientificCalculator().setVisible(true);
            }
        });
    }
}
