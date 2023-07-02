package com.amrita.jpl.cys21035.ex;

import java.util.Scanner;

interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2) throws ArithmeticException;
}

class BasicCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return num1 / num2;
    }
}

public class BasicCalculatorExample {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        double addition = calculator.add(num1, num2);
        double subtraction = calculator.subtract(num1, num2);
        double multiplication = calculator.multiply(num1, num2);

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);

        double division;
        try {
            division = calculator.divide(num1, num2);
            System.out.println("Division: " + division);
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            division = -1.0;
        }

    }
}