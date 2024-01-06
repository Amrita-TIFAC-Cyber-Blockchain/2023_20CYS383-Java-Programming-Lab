package com.amrita.jpl.cys21054.practice;

import java.util.Scanner;

abstract class  ACalculator {
    public abstract double calculate(double num1, double num2);
}

class Addition extends ACalculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtraction extends ACalculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiplication extends ACalculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class Division extends ACalculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }
}

public class SimpleCalculator_using_Abstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        ACalculator calculator;

        switch (choice) {
            case 1:
                calculator = new Addition();
                break;
            case 2:
                calculator = new Subtraction();
                break;
            case 3:
                calculator = new Multiplication();
                break;
            case 4:
                calculator = new Division();
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        try {
            double result = calculator.calculate(num1, num2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
