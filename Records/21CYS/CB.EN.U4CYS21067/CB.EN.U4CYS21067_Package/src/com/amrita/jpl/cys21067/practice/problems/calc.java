package com.amrita.jpl.cys21067.practice.problems;

import java.util.Scanner;

/**
 * The calc class performs basic arithmetic calculations.
 */
public class calc {

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        float num1 = input.nextFloat();

        System.out.print("Enter second number: ");
        float num2 = input.nextFloat();

        System.out.print("Select an operation (+, -, *, /): ");
        char opt = input.next().charAt(0);

        float result;

        switch (opt) {
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
                    System.out.println("Error: Division by zero");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                System.out.println("Error: Invalid operator");
                return;
        }

        System.out.println(num1 + " " + opt + " " + num2 + " = " + result);
    }
}
