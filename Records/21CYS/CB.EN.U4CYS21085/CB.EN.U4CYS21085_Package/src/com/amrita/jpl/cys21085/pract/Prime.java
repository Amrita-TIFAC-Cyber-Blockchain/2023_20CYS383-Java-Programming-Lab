package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;

/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program checks if a given number is a prime number.13
 * A prime number is a number that is only divisible by 1 and itself.
 */
public class Prime {

    /**
     * The main method allows the user to input a number and checks if it is a prime number.
     * It checks if the number is less than or equal to 1, in which case it is not prime.
     * Otherwise, it iterates from 2 to the square root of the number and checks if any of those
     * values divide the number. If a divisor is found, the number is not prime.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        // Check if the number is less than or equal to 1
        if (number <= 1) {
            isPrime = false;
        } else {
            // Iterate from 2 to the square root of the number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                // Check if the current value divides the number
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Print the result
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
