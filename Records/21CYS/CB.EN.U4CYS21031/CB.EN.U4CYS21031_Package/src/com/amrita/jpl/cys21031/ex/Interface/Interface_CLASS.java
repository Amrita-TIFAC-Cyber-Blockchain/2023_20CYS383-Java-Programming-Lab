package com.amrita.jpl.cys21031.ex.Interface;

/**
 * @author Kishanth K
 */
import java.util.Scanner;
interface Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    double calculate(double n1, double n2);
}
class Addition implements Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    public double calculate(double n1, double n2) {
        return n1 + n2;
    }
}

class Subtraction implements Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    public double calculate(double n1, double n2) {
        return n1 - n2;
    }
}

class Multiplication implements Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    public double calculate(double n1, double n2) {
        return n1 * n2;
    }
}

class Division implements Calculator {
    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    public double calculate(double n1, double n2) {
        if (n2 != 0) {
            return n1 / n2;
        } else {
            System.out.println("Cannot divide by zero");
        }
        return 0;
    }
}

// com.java.calc_interface.Main class to test the calculator
public class Interface_CLASS {
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

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
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
