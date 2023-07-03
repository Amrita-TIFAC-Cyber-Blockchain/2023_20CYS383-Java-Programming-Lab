package com.amrita.jpl.cys21074.ex;

import java.util.Scanner;

/**
 * The {@code calculator} interface defines basic arithmetic operations.
 */
interface calculator {
    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the sum of num1 and num2
     */
    double add(double num1, double num2);

    /**
     * Subtracts two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
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
     * Divides two numbers.
     *
     * @param num1 the dividend
     * @param num2 the divisor
     * @return the quotient of num1 divided by num2
     */
    double divide(double num1, double num2);
}

/**
 * The {@code basiccalculator} class implements the {@code calculator} interface.
 */
class basiccalculator implements calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Division by zero error!");
            return -1;
        }
        return num1 / num2;
    }
}

/**
 * The {@code basiccalculatorexample} class demonstrates the usage of the {@code basiccalculator}.
 */
public class basiccalculatorexample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        basiccalculator calculator = new basiccalculator();

        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));

        scanner.close();
    }
}
