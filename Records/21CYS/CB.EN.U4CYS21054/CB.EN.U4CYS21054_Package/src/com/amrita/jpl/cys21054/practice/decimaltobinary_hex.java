package com.amrita.jpl.cys21054.practice;

import java.util.Scanner;

/**
 * A program to convert a decimal number to its binary and hexadecimal representations.
 */
public class decimaltobinary_hex {
    /**
     * Reads a non-negative integer in decimal form from the user and converts it to binary and hexadecimal.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer in decimal: ");

        if (scanner.hasNextInt()) {
            int decimal = scanner.nextInt();

            if (decimal >= 0) {
                String binary = Integer.toBinaryString(decimal);
                String hexadecimal = Integer.toHexString(decimal);

                System.out.println("Decimal " + decimal + " is equivalent to binary " + binary + " and hexadecimal " + hexadecimal);
            } else {
                System.out.println("Error: Input must be a non-negative integer.");
            }
        } else {
            System.out.println("Error: Invalid input.");
        }

        scanner.close();
    }
}
