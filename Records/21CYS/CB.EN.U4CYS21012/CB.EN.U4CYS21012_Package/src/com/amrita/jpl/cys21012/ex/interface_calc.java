package com.amrita.jpl.cys21012.ex;

import java.util.*;

/**
 * The Calculator interface defines the basic arithmetic operations.
 * @author Ashwin Anand
 */
interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

/**
 * The BasicCalculator class implements the Calculator interface and provides the basic arithmetic operations.
 */
class BasicCalculator implements Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            return -1.0;
        }
    }
}

/**
 * The interface_calc class is a program that performs basic arithmetic calculations using the Calculator interface.
 */
public class interface_calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calc = new BasicCalculator();

        double n1, n2;
        n1 = scanner.nextDouble();
        n2 = scanner.nextDouble();

        double a, b, c, d;
        a = calc.add(n1, n2);
        b = calc.subtract(n1, n2);
        c = calc.multiply(n1, n2);
        d = calc.divide(n1, n2);

        System.out.println("Addition: " + a);
        System.out.println("Subtraction: " + b);
        System.out.println("Multiplication: " + c);
        if (d == -1.0){
            System.out.println("Division by zero error!");
        }
        System.out.println("Division: " + d);

    }
}
