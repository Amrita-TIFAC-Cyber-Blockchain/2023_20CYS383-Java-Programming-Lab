package com.amrita.jpl.cys21033.Assignments;

import java.util.Scanner;

/**
 * This class represents a simple calculator application that performs addition, subtraction, multiplication, and division.
 * It demonstrates the concept of abstraction by using abstract classes and methods.
 *
 * @author Suhitha
 * @version 0.5
 */
abstract class operation {
    protected double num1;
    protected double num2;

    public operation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Calculates the result of the operation.
     *
     * @return the calculated result
     */
    public abstract double calculate();
}

/**
 * Represents the addition operation.
 */
class addition extends operation {
    public addition(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 + num2;
    }
}

/**
 * Represents the subtraction operation.
 */
class subtraction extends operation {
    public subtraction(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 - num2;
    }
}

/**
 * Represents the multiplication operation.
 */
class multiplication extends operation {
    public multiplication(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        return num1 * num2;
    }
}

/**
 * Represents the division operation.
 */
class division extends operation {
    public division(double num1, double num2) {
        super(num1, num2);
    }

    public double calculate() {
        if (num2 == 0) {
            System.out.println("A Number Cannot be Divided by Zero");
        }
        return num1 / num2;
    }
}

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        double num1 = input.nextDouble();
        System.out.println("Enter Second Number: ");
        double num2 = input.nextDouble();

        operation addition = new addition(num1, num2);
        System.out.println("\nAddition:");
        System.out.println("Sum of " + num1 + " & " + num2 + " is " + addition.calculate());

        operation subtraction = new subtraction(num1, num2);
        System.out.println("\nSubtraction:");
        System.out.println("Subtraction of " + num1 + " & " + num2 + " is " + subtraction.calculate());

        operation multiplication = new multiplication(num1, num2);
        System.out.println("\nMultiplication:");
        System.out.println("Multiplication of " + num1 + " & " + num2 + " is " + multiplication.calculate());

        operation division = new division(num1, num2);
        System.out.println("\nDivision:");
        System.out.println("Division of " + num1 + " & " + num2 + " is " + division.calculate());
    }
}
