package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program checks if a given number is an Armstrong number.
 * An Armstrong number is a number that is equal to the sum of its digits raised to the power of the number of digits.
 */
public class ArmstrongNumber {

    /**
     * The main method allows the user to input a number and checks if it is an Armstrong number.
     * It calculates the sum of the digits raised to the power of the number of digits,
     * and compares it with the original number to determine if it is an Armstrong number.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int result = 0;
        int digits = String.valueOf(number).length();

        // Calculate the sum of the digits raised to the power of the number of digits
        while (number != 0) {
            int remainder = number % 10;
            result += Math.pow(remainder, digits);
            number /= 10;
        }

        // Check if the result is equal to the original number
        if (result == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}

