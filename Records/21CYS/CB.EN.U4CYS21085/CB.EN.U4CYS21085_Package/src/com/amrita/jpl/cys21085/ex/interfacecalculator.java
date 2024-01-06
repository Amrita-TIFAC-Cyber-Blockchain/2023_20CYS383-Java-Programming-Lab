package com.amrita.jpl.cys21085.ex;

import java.util.Scanner;

/**
 * An interface-based calculator program that performs basic arithmetic operations.
 */
class interfaceCalculator {
    /**
     * Calculator interface with basic arithmetic operations.
     */
    interface Calculator {
        /**
         * Adds two numbers.
         *
         * @param num1 the first number
         * @param num2 the second number
         * @return the sum of num1 and num2
         */
        double add(double num1, double num2);

        /**
         * Subtracts one number from another.
         *
         * @param num1 the number to subtract from
         * @param num2 the number to subtract
         * @return the difference between num1 and num2
         */
        double subtract(double num1, double num2);

        /**
         * Multiplies two numbers.
         *
         * @param num1 the first number
         * @param num2 the second number
         * @return the product of num1 and num2
         */
        double multiply(double num1, double num2);

        /**
         * Divides one number by another.
         *
         * @param num1 the dividend
         * @param num2 the divisor
         * @return the quotient of num1 divided by num2
         * @throws ArithmeticException if num2 is zero
         */
        double divide(double num1, double num2) throws ArithmeticException;
    }

    /**
     * BasicCalculator class that implements the Calculator interface.
     */
    static class BasicCalculator implements Calculator {
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
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return num1 / num2;
        }
    }

    /**
     * Entry point of the calculator program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        double num1, num2;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        double sum = calculator.add(num1, num2);
        double difference = calculator.subtract(num1, num2);
        double product = calculator.multiply(num1, num2);
        double quotient;

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + difference);
        System.out.println("Multiplication: " + product);

        try {
            quotient = calculator.divide(num1, num2);
            System.out.println("Division: " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        }

        scanner.close();
    }
}
