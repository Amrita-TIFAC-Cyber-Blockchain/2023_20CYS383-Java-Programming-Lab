package com.amrita.jpl.cys21015.ex;

import java.util.Scanner;

interface Calculator{
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);

}

class BasicCalculator implements Calculator {
    @Override public double add(double a, double b) {
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
            return -1.0;
        }
    }
}

public class BasicCalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calc = new BasicCalculator();

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        System.out.println("Addition: "+calc.add(a,b));
        System.out.println("Subtraction: "+calc.subtract(a,b));
        System.out.println("Multiplication: "+calc.multiply(a,b));
        if (calc.divide(a,b) == -1.0)
        {
            System.out.println("Division by zero error!");
        }
        System.out.println("Division: "+calc.divide(a,b));
    }
}