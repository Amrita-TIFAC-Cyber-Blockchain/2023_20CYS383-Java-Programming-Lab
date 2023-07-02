package com.amrita.jpl.cys21022.pract.calc;

import java.util.Scanner;

abstract class AbstractCalculator {
    protected double number1;
    protected double number2;

    public void readNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        number1 = scanner.nextDouble();
        System.out.print("Enter number 2: ");
        number2 = scanner.nextDouble();
    }

    public abstract double performCalculation();

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}

class AddCalculator extends AbstractCalculator {
    @Override
    public double performCalculation() {
        return number1 + number2;
    }
}

class SubtractCalculator extends AbstractCalculator {
    @Override
    public double performCalculation() {
        return number1 - number2;
    }
}

class MultiplyCalculator extends AbstractCalculator {
    @Override
    public double performCalculation() {
        return number1 * number2;
    }
}

class DivideCalculator extends AbstractCalculator {
    @Override
    public double performCalculation() {
        if (number2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return number1 / number2;
    }
}

public class abstractcalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = scanner.nextInt();

        AbstractCalculator calculator;

        switch (choice) {
            case 1:
                calculator = new AddCalculator();
                break;
            case 2:
                calculator = new SubtractCalculator();
                break;
            case 3:
                calculator = new MultiplyCalculator();
                break;
            case 4:
                calculator = new DivideCalculator();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        calculator.readNumbers();
        double result = calculator.performCalculation();
        calculator.displayResult(result);
    }
}
