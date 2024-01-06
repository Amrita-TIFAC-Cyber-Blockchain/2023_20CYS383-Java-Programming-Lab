package com.amrita.jpl.CYS21053.Prac.AbstractCalculatetrial;

/**
 * An abstract class representing a calculator.
 */
abstract class Calculator {
    protected int num1;
    protected int num2;

    /**
     * Constructs a Calculator object with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Calculates and returns the result.
     *
     * @return The calculated result.
     */
    public abstract int calculate();
}

/**
 * A class representing an addition calculator.
 */
class Addition extends Calculator {
    /**
     * Constructs an Addition calculator with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Addition(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Calculates and returns the addition result.
     *
     * @return The addition result.
     */
    @Override
    public int calculate() {
        return num1 + num2;
    }
}

/**
 * A class representing a subtraction calculator.
 */
class Subtraction extends Calculator {
    /**
     * Constructs a Subtraction calculator with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Calculates and returns the subtraction result.
     *
     * @return The subtraction result.
     */
    @Override
    public int calculate() {
        return num1 - num2;
    }
}

/**
 * A class representing a multiplication calculator.
 */
class Multiplication extends Calculator {
    /**
     * Constructs a Multiplication calculator with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Calculates and returns the multiplication result.
     *
     * @return The multiplication result.
     */
    @Override
    public int calculate() {
        return num1 * num2;
    }
}

/**
 * A class representing a division calculator.
 */
class Division extends Calculator {
    /**
     * Constructs a Division calculator with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Division(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Calculates and returns the division result.
     * Throws an ArithmeticException if the second number is zero.
     *
     * @return The division result.
     * @throws ArithmeticException If the second number is zero.
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
 * A class representing the main entry point of the program.
 */
public class Main {
    /**
     * The main method that executes the program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        Calculator addition = new Addition(num1, num2);
        Calculator subtraction = new Subtraction(num1, num2);
        Calculator multiplication = new Multiplication(num1, num2);
        Calculator division = new Division(num1, num2);

        int result1 = addition.calculate();
        System.out.println("com.amrita.CYS21053.Addition result: " + result1);

        int result2 = subtraction.calculate();
        System.out.println("com.amrita.CYS21053.Subtraction result: " + result2);

        int result3 = multiplication.calculate();
        System.out.println("com.amrita.CYS21053.Multiplication result: " + result3);

        int result4 = division.calculate();
        System.out.println("com.amrita.CYS21053.Division result: " + result4);
    }
}
