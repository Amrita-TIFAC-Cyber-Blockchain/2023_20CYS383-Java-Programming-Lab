package com.amrita.jpl.cys21050.ex;
import java.util.Scanner;

interface Calci {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class Calculator1 implements Calci {
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

// Main class with menu-driven program
/**
 * @author nishanth
 */
public class simplecalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator1 calc = new Calculator1();

        double num1, num2;
        num1 = scanner.nextDouble();
        num2 = scanner.nextDouble();

        System.out.println("Addition: "+calc.add(num1,num2));
        System.out.println("Subtraction: "+calc.subtract(num1,num2));
        System.out.println("Multiplication: "+calc.multiply(num1,num2));
        System.out.println("Division: "+calc.divide(num1,num2));
    }
}