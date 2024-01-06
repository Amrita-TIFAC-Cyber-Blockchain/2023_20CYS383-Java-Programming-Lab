package com.amrita.jpl.cys21019.ex;

import java.util.Scanner;

/**
 * This class implements a simple calculator that performs basic arithmetic operations.
 *
 * @author Gokulachselvan C D
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.println("Select the operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = scanner.nextInt();
        double result = 0;

        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Error: Invalid operation selected!");
                System.exit(0);
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}
