package com.amrita.jpl.cys21080.practice.basics;

import java.util.Scanner;

/**
 * The Main class represents a simple calculator program.
 * It takes two numbers and an operator from the user, performs the corresponding operation, and displays the result.
 *
 * Usage:
 * - Run the program and enter the first number when prompted.
 * - Enter the second number when prompted.
 * - Select the operation (+, -, *, /) when prompted.
 * - The program will display the result of the operation.
 *
 * Note: Division by zero is handled and an error message is displayed.
 * The program supports addition, subtraction, multiplication, and division operations.
 *
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
public class SimpleCalculator {
    /**
     * The main method is the entry point of the program.
     * It prompts the user for input, performs the operation, and displays the result.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator! Please give correct operator.");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}

