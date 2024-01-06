package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program calculates the factorial of a given number.
 * The factorial of a non-negative integer 'n' is the product of all positive integers less than or equal to 'n'.
 */
public class Factorial {

    /**
     * The main method allows the user to input a number and calculates its factorial.
     * It initializes the factorial as 1 and then iterates from 1 to the given number,
     * multiplying each number with the factorial to calculate the final factorial value.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int factorial = 1;

        // Calculate the factorial of the number
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Print the factorial
        System.out.println("Factorial: " + factorial);
    }
}

