package com.amrita.jpl.cys21060.Ex;

import java.util.Scanner;


interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

// Implement the Calculator interface
class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Division by zero error!");
            return -1;
        }
    }
}

public class BasicCalculatorExample {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        a = scanner.nextDouble();
        b = scanner.nextDouble();

        // Addition
        double sum = calculator.add(a, b);
        System.out.println("Addition: " + sum);

        // Subtraction
        double difference = calculator.subtract(a, b);
        System.out.println("Subtraction: " + difference);

        // Multiplication
        double product = calculator.multiply(a, b);
        System.out.println("Multiplication: " + product);

        // Division
        double quotient = calculator.divide(a, b);
        System.out.println("Division: " + quotient);

    }
}