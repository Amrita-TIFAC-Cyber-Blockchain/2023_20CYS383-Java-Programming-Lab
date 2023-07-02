package com.amrita.jpl.cys21019.ex;


import java.util.Scanner;

interface Calculator {
    /**
     * Adds two numbers.
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    double add(double a, double b);

    /**
     * Subtracts two numbers.
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    double multiply(double a, double b);

    /**
     * Divides two numbers.
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the two numbers
     */
    double divide(double a, double b);
}

class BasicCalculator implements Calculator {
    /**
     * Adds two numbers.
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the two numbers
     */
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero error!");
            return -1.0;
        } else {
            return a / b;
        }
    }
}

public class BasicCalculatorExample_interface {
    /**
     * Filetransfer method to demonstrate the usage of the BasicCalculator class.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);
        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();

        double addition = calculator.add(n1, n2);
        double subtraction = calculator.subtract(n1, n2);
        double multiplication = calculator.multiply(n1, n2);
        double division;

        if (n2 == 0) {
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        } else {
            division = calculator.divide(n1, n2);
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division: " + division);
        }
    }
}
