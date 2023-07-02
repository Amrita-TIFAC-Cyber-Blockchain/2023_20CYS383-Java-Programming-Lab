package com.amrita.jpl.cys21012.ex;


import java.util.*;

/**
 * The Calculator interface defines the basic arithmetic operations.
 * @author Ashwin Anand
 */


/**
 * The BasicCalculator class implements the Calculator interface and provides the basic arithmetic operations.
 */
abstract class basicCalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
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
public class abs_calc extends basicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1, n2;
        n1 = scanner.nextDouble();
        n2 = scanner.nextDouble();

        double a, b, c, d;
        a = add(n1, n2);
        b = subtract(n1, n2);
        c = multiply(n1, n2);
        d = divide(n1, n2);

        System.out.println("Addition: " + a);
        System.out.println("Subtraction: " + b);
        System.out.println("Multiplication: " + c);
        if (d == -1.0){
            System.out.println("Division by zero error!");
        }
        System.out.println("Division: " + d);

    }
}

