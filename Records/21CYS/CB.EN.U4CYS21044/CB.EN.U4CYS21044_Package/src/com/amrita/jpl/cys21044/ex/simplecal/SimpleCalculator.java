package com.amrita.jpl.cys21044.ex.simplecal;
import java.util.Scanner;

/**
 * @author ravi
 */
interface Calculator {
    double calculate(double num1, double num2);

    String getOperationSymbol();
}

class Addition implements Calculator {
    /**
     *
     * @param num1 - input number1
     * @param num2 - input number2
     */
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Addition";
    }
}

class Subtraction implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Subtraction";
    }
}

class Multiplication implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Multiplication";
    }
}

class Division implements Calculator {
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


public class SimpleCalculator {
    /**
     * @param args - used to take input from command line
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter two numbers:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        scanner.close();

        Calculator[] calculators = {new Addition(), new Subtraction(), new Multiplication(), new Division()};

        for (Calculator calculator : calculators) {
            try {
                /**
                 * @param result- used to store the return value
                 */
                double result = calculator.calculate(num1, num2);
                String operation = calculator.getOperationSymbol();
                System.out.println(operation + ": " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}