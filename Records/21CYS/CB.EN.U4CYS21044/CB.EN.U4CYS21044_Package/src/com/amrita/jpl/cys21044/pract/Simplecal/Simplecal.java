package com.amrita.jpl.cys21044.pract.Simplecal;

import java.util.Scanner;

/**
 * @author ravi
 * @version 1.0
 */
public class Simplecal {
    /**
     * @param args - command line arguments
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
