package com.amrita.jpl.cys21020.ex;

import java.util.Scanner;

interface Calculator {
    double calculate(double num1, double num2);

    String getOperationSymbol();
}

class Addition implements Calculator {  //Class for calculating Addition of two numbers
    @Override
    public double calculate(double num1, double num2) {  // Function for
        return num1 + num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Addition";
    }
}

class Subtraction implements Calculator { //Class calculating Subtraction between two numbers
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Subtraction";
    }
}

class Multiplication implements Calculator {  //Class that calculates multiplication between two number
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Multiplication";
    }
}

class Division implements Calculator { //Class for Dividing one number with another
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Division by zero error!");
            return -1;
        }
        return num1 / num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Division";
    }
}


public class Calculater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2  = scanner.nextDouble();
        scanner.close();

        Calculator[] calculators = {new Addition(), new Subtraction(), new Multiplication(), new Division()};

        for (Calculator calculator : calculators) {
            try {
                double result = calculator.calculate(num1, num2);
                String operation = calculator.getOperationSymbol();
                System.out.println(operation + ": " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
