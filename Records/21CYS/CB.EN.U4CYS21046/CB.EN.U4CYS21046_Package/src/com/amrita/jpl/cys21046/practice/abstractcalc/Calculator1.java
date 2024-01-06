package com.amrita.jpl.cys21046.practice.abstractcalc;

/**
 * Abstract class representing a calculator.
 */
abstract class Calculator {
    protected int num1;
    protected int num2;

    /**
     * Constructor for Calculator class.
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Abstract method for calculation.
     * @return The result of the calculation.
     */
    public abstract int calculate();
}

/**
 * Subclass representing the addition operation.
 */
class Addition extends Calculator {
    /**
     * Constructor for Addition class.
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Addition(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Performs addition operation.
     * @return The sum of num1 and num2.
     */
    @Override
    public int calculate() {
        return num1 + num2;
    }
}

/**
 * Subclass representing the subtraction operation.
 */
class Subtraction extends Calculator {
    /**
     * Constructor for Subtraction class.
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Performs subtraction operation.
     * @return The difference between num1 and num2.
     */
    @Override
    public int calculate() {
        return num1 - num2;
    }
}

/**
 * Subclass representing the multiplication operation.
 */
class Multiplication extends Calculator {
    /**
     * Constructor for Multiplication class.
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Performs multiplication operation.
     * @return The product of num1 and num2.
     */
    @Override
    public int calculate() {
        return num1 * num2;
    }
}

/**
 * Subclass representing the division operation.
 */
class Division extends Calculator {
    /**
     * Constructor for Division class.
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Division(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Performs division operation.
     * @return The result of dividing num1 by num2.
     * @throws ArithmeticException if num2 is zero.
     */
    @Override
    public int calculate() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}

/**
 * Main class to test the calculator.
 */
public class Calculator1 {
    /**
     * The main method to test the calculator operations.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        // Create instances of the calculator operations
        Calculator addition = new Addition(num1, num2);
        Calculator subtraction = new Subtraction(num1, num2);
        Calculator multiplication = new Multiplication(num1, num2);
        Calculator division = new Division(num1, num2);

        // Perform calculations
        int result1 = addition.calculate();
        System.out.println("Addition result: " + result1);

        int result2 = subtraction.calculate();
        System.out.println("Subtraction result: " + result2);

        int result3 = multiplication.calculate();
        System.out.println("Multiplication result: " + result3);

        int result4 = division.calculate();
        System.out.println("Division result: " + result4);
    }
}
