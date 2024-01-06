package com.amrita.jpl.cys21064.ex;

import java.util.*;

import java.util.Scanner;

/**
 * This class represents a simple calculator program in Java.
 * It allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, and division.
 * The calculator provides a menu-driven interface for selecting the desired operation.
 * The program continues until the user chooses to exit.
 *
 * Note: The division operation checks for a non-zero divisor to avoid division by zero.
 *
 * @author Rajendraprasad S
 */
public class simple_calculator {
    /**
     * The main method of the simple_calculator class.
     * It displays a menu and performs arithmetic operations based on user input.
     * The program continues until the user chooses to exit.
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        System.out.println("Java Calculator");
        int choice;
        do {
            System.out.println("Option 1: Add two numbers");
            System.out.println("Option 2: Subtract two numbers");
            System.out.println("Option 3: Multiply two numbers");
            System.out.println("Option 4: Divide numbers");
            System.out.println("Option 5: Exit");

            System.out.println("Select your choice");
            choice = read.nextInt();
            if (choice == 1) {
                System.out.print("Enter two numbers: ");
                int a = read.nextInt();
                int b = read.nextInt();
                System.out.println("Sum is " + (a + b));
            } else if (choice == 2) {
                System.out.print("Enter two numbers: ");
                int a = read.nextInt();
                int b = read.nextInt();
                System.out.println("Difference is " + (a - b));
            } else if (choice == 3) {
                System.out.print("Enter two numbers: ");
                int a = read.nextInt();
                int b = read.nextInt();
                System.out.println("Product is " + (a * b));
            } else if (choice == 4) {
                System.out.print("Enter two numbers: ");
                int a = read.nextInt();
                int b = read.nextInt();

                while (b == 0) {
                    System.out.println("Second number cannot be 0. Try again.");
                    b = read.nextInt();
                }
                System.out.println("Ratio is " + (a / (float) b));
            } else if (choice != 5) {
                System.out.println("Enter a valid choice.");
            }
        } while (choice != 5);
    }
}
