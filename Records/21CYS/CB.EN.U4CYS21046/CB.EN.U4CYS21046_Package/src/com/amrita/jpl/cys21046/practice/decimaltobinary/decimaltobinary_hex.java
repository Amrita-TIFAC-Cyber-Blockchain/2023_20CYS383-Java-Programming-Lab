package com.amrita.jpl.cys21046.practice.decimaltobinary;

import java.util.Scanner;

/**
 * This class converts a decimal number to its binary and hexadecimal representations.
 */
public class decimaltobinary_hex {

    /**
     * The main method reads a decimal number from the user and converts it to binary and hexadecimal.
     *
     * @param args The command-line arguments (not used in this program)
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
    }
}
