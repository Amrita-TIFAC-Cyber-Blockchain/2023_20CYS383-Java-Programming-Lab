package com.amrita.jpl.cys21023.ex;

import java.util.Scanner;

interface Calculator {
    void add(double a, double b);
    void subtract(double a, double b);
    void multiply(double a, double b);
    void divide(double a, double b);
}

class BasicCalculator implements Calculator {
    public void add(double a, double b) {
        double result = a + b;
        System.out.println("Addition: " + result);
    }

    public void subtract(double a, double b) {
        double result = a - b;
        System.out.println("Subtraction: " + result);
    }

    public void multiply(double a, double b) {
        double result = a * b;
        System.out.println("Multiplication: " + result);
    }

    public void divide(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Division by zero error!");
            }

            double result = a / b;
            System.out.println("Division: " + result);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class BasicCalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter  number 1:");
        double num1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter  number 2:");
        double num2 = scanner.nextDouble();

        Calculator calculator = new BasicCalculator();
        calculator.add(num1, num2);
        calculator.subtract(num1, num2);
        calculator.multiply(num1, num2);
        calculator.divide(num1, num2);
    }
}