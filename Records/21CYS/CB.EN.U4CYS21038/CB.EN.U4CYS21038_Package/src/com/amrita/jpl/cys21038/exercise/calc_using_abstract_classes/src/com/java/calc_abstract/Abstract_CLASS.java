package com.amrita.jpl.cys21038.exercise.calc_using_abstract_classes.src.com.java.calc_abstract;
/**
 * @author Madhav H
 */
import java.util.Scanner;
abstract class Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    abstract double calculate(double n1, double n2);
}
class Addition extends Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    double calculate(double n1, double n2) {
        return n1 + n2;
    }
}

class Subtraction extends Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    double calculate(double n1, double n2) {
        return n1 - n2;
    }
}

class Multiplication extends Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    double calculate(double n1, double n2) {
        return n1 * n2;
    }
}

class Division extends Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    double calculate(double n1, double n2) {
        if (n2 != 0) {
            return n1 / n2;
        } else {
            System.out.println("Cannot divide by zero");
        }
        return 0;
    }
}
public class Abstract_CLASS {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int choice;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number:    ");
        num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. com.java.calc_abstract.Addition");
        System.out.println("2. com.java.calc_abstract.Subtraction");
        System.out.println("3. com.java.calc_abstract.Multiplication");
        System.out.println("4. com.java.calc_abstract.Division");
        System.out.print("Enter your choice : ");
        choice = scanner.nextInt();
        Calculator calculator;
        switch (choice) {
            case 1:
                calculator = new Addition();
                break;
            case 2:
                calculator = new Subtraction();
                break;
            case 3:
                calculator = new Multiplication();
                break;
            case 4:
                calculator = new Division();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);
    }
}

