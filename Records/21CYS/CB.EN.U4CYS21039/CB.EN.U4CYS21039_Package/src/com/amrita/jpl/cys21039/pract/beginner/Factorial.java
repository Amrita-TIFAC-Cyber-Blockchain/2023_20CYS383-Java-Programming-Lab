package com.amrita.jpl.cys21039.pract.beginner;

import java.util.Scanner;

/**
 * A program to calculate the factorial of a given number.
 *
 * @author Manbendra Satpathy
 */
public class Factorial {
    /**
     * The main method is the entry point of the program.
     * It takes user input for a number and calculates its factorial.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }

        System.out.println("The factorial of " + num + " is " + fact);

        scanner.close();
    }
}
