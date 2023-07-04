package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * A simple calculator program that performs basic arithmetic operations on two numbers.
 */
public class calculator {
    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Take input for second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Take input for operation
        System.out.print("Enter operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Perform calculation based on the operation
        double result = 0.0;
        boolean validInput = true; // flag to check if input is valid

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            // Check for division by zero
            if (num2 == 0) {
                System.out.println("Error: division by zero");
                validInput = false;
            } else {
                result = num1 / num2;
            }
        } else {
            System.out.println("Error: invalid operation");
            validInput = false;
        }

        // Print result if input is valid
        if (validInput) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
    }
}
