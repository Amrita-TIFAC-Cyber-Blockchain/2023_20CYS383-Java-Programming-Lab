package com.amrita.jpl.cys21034.ex;

import java.util.Scanner;
/**
 *interface Calculator
 */
interface Calculator
{
    void add(double a, double b);
    void sub(double a, double b);
    void mul(double a, double b);
    void div(double a, double b);
}
/**
 *class BasicCalculator implementing Calculator interface
 */
class BasicCalculator implements Calculator {
    /**
     * adding two numbers
     * @param a,b numbers that are to be added
     */
    public void add(double a, double b) {
        double r = a + b;
        System.out.println("Addition: "+r);
    }
    /**
     * subtracting two numbers
     * @param a,b numbers that are to be subtracted
     */
    public void sub(double a, double b) {
        double r = a - b;
        System.out.println("Subtraction: "+r);
    }
    /**
     * multiplying two numbers
     * @param a,b numbers that are to be multiplied
     */
    public void mul(double a, double b) {
        double r = a * b;
        System.out.println("Multiplication: "+r);
    }
    /**
     * dividing two numbers
     * @param a,b numbers that are to be divided
     */
    public void div(double a, double b) {
        if (b != 0) {
            double r = a / b;
            System.out.println("Division: "+r);
        } else {
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        }
    }
}

public class calculator_interface {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        Calculator calculator = new BasicCalculator();

        calculator.add(num1, num2);
        calculator.sub(num1, num2);
        calculator.mul(num1, num2);
        calculator.div(num1, num2);

    }
}
