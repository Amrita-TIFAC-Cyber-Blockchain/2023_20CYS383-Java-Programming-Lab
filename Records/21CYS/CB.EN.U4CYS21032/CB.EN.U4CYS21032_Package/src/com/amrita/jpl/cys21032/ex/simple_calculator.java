package com.amrita.jpl.cys21032.ex;


import java.util.Scanner;
public class simple_calculator{
    public interface Calculator {
        double add(double a, double b);
        double subtract(double a, double b);
        double multiply(double a, double b);
        double divide(double a, double b) throws ArithmeticException;
    }

    public static class BasicCalculator implements Calculator {

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
        public double divide(double a, double b) throws ArithmeticException {
            if (b == 0) {
                throw new ArithmeticException("Division by zero error!");
            }
            return a / b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new BasicCalculator();

        double num1 = scanner.nextDouble();

        double num2 = scanner.nextDouble();

        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));

        try {
            double division = calculator.divide(num1, num2);
            System.out.println("Division: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error!");
        }
    }
}