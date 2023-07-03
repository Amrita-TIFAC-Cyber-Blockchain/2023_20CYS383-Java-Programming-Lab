package com.amrita.jpl.cys21074.pract.misc;
import java.util.Scanner;

/**
 * The {@code Calculator} class performs basic arithmetic operations on two numbers.
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a = s.nextInt();
        System.out.println("Enter second number:");
        int b = s.nextInt();
        System.out.println("Choose an operation (addition, subtraction, multiplication, division):");
        String op = s.next();

        // Validate the operator
        if (!op.equals("addition") && !op.equals("subtraction")
                && !op.equals("multiplication") && !op.equals("division")) {
            System.out.println("Error! Operator is not correct");
            return;
        }

        // Perform division by zero check
        if (op.equals("division") && b == 0) {
            System.out.println("Error! Cannot divide by zero");
            return;
        }

        // Perform negative number check
        if (a < 0 || b < 0) {
            System.out.println("Error! Negative numbers are not allowed");
            return;
        }

        // Perform the selected operation
        switch (op) {
            case "addition":
                System.out.println(a + b);
                break;
            case "subtraction":
                System.out.println(a - b);
                break;
            case "multiplication":
                System.out.println(a * b);
                break;
            case "division":
                System.out.println(a / b);
                break;
        }
    }
}
