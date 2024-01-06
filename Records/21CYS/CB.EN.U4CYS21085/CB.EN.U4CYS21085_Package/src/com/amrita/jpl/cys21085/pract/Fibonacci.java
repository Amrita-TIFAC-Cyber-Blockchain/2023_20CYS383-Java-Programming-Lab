package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program generates the Fibonacci series up to a specified number of terms.
 * The Fibonacci series is a sequence of numbers where each number is the sum of the two preceding ones.
 */
public class Fibonacci {

    /**
     * The main method allows the user to input the number of terms and generates the Fibonacci series.
     * It initializes the first and second terms of the series as 0 and 1 respectively.
     * It then iterates from the 3rd term up to the specified number of terms, calculating each term
     * as the sum of the two preceding terms and printing the series.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        int firstTerm = 0, secondTerm = 1;
        System.out.print("Fibonacci Series: " + firstTerm + ", " + secondTerm);

        // Generate the Fibonacci series
        for (int i = 3; i <= n; i++) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(", " + nextTerm);
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
