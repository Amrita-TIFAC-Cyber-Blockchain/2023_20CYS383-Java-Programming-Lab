package com.amrita.jpl.cys21083.Assignments.ass01;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        int number1, number2, total;
        char operator;

        Scanner input = new Scanner(System.in); // Scanner Object

        System.out.println("Enter first number: ");
        if (input.hasNextInt()) {
            number1 = input.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        System.out.println("Enter second number: ");
        if (input.hasNextInt()) {
            number2 = input.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        System.out.println("Enter Operator for Calculation:  +, -, *, /: ");
        operator = input.next().charAt(0);

        switch (operator) {
            case '+':
                total = number1 + number2;
                System.out.println("Addition of " + number1 + " + " + number2 + " = " + total);
                break;

            case '-':
                total = number1 - number2;
                System.out.println("Subtraction of " + number1 + " - " + number2 + " = " + total);
                break;

            case '*':
                total = number1 * number2;
                System.out.println("Multiplication of " + number1 + " * " + number2 + " = " + total);
                break;

            case '/':
                if (number2 != 0) {
                    total = number1 / number2;
                    System.out.println("Division of " + number1 + " / " + number2 + " = " + total);
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;

            default:
                System.out.println("Invalid operator. Please choose one of the four operators.");
                break;
        }
    }
}
