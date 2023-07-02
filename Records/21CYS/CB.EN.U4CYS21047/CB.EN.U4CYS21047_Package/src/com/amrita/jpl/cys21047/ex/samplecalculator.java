package com.amrita.jpl.cys21047.ex;

/**
 *
 * simple calculator.
 *
 * @author N.vihal roy
 * @version 1
 */

import java.util.Scanner;

    public class samplecalculator {
        public static void main(String[] args) {
            double number1;
            double number2;
            char operator;
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter the first number: ");
                number1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                number2 = scanner.nextDouble();

                System.out.print("Select the operation (+, -, *, /): ");
                operator = scanner.next().charAt(0);
            }

            double result;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = number1 - number2;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = number1 * number2;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        result = number1 / number2;
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator selected.");
                    break;
            }
        }
    }