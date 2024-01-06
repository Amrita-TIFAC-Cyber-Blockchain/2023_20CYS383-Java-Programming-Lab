package com.amrita.jpl.cys21022.ex;

import java.util.Scanner;

interface Calculator {
    double calculate(double num1, double num2);
}

class Addition implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        System.out.print("Addition: " + (num1 + num2));
        return 0;
    }
}

class Subtraction implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        System.out.print("Subtraction: " + (num1 - num2));
        return 0;
    }
}

class Multiplication implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        System.out.print("Multiplication: " + (num1 * num2));
        return 0;
    }
}

class Division implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            System.out.print("Addition: " + (num1 / num2));
            return 0;
        } else {
            throw new ArithmeticException("Division by zero error!");
        }
    }
}

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = scanner.nextDouble();

        double num2 = scanner.nextDouble();

        double result;

        Addition a = new Addition();
        result = a.calculate(num1, num2);

        Subtraction s = new Subtraction();
        result = s.calculate(num1, num2);

        Multiplication m = new Multiplication();
        result = m.calculate(num1, num2);

        Division d = new Division();
        result = d.calculate(num1, num2);
        if(result == -1.0){
            System.out.println("Division:" + result);
        }


        scanner.close();
}
}
