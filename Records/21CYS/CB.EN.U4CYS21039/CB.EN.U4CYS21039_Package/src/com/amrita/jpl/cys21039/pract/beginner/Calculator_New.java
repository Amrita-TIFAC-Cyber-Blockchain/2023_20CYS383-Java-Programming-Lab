package com.amrita.jpl.cys21039.pract.beginner;

import java.util.Scanner;

/**
 * This program is a simple calculator that performs basic arithmetic operations.
 *
 * @author Manbendra Satpathy
 */
public class Calculator_New {
    /**
     * The main method is the entry point of the program.
     * It takes user input for two numbers and an operation, performs the operation, and prints the result.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.print("Select operation (+, -, *, /): ");
        char operation = input.next().charAt(0);

        double result;
        switch (operation) {
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
                    System.out.println("Error: Cannot divide by zero.");
                    return;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("Error: Invalid operation selected.");
                return;
        }

        System.out.println("Result: " + result);

        input.close();
    }
}
