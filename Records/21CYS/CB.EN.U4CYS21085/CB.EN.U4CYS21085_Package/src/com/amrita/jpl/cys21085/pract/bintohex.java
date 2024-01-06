package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * A program to convert a decimal number to binary and hexadecimal representation.
 */
public class bintohex {
    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get decimal input from user
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Check if the input is negative
        if (decimal < 0) {
            System.out.println("Error: Input must be a positive integer.");
            return;
        }

        // Convert to binary and hexadecimal
        String binary = Integer.toBinaryString(decimal);
        String hexadecimal = Integer.toHexString(decimal);

        // Print the results
        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hexadecimal);
    }
}
