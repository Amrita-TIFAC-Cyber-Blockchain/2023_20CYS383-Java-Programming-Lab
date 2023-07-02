package com.amrita.jpl.cys21039.pract.beginner;

import java.util.Scanner;

/**
 * A program to convert a decimal number to binary and hexadecimal representation.
 *
 * @author Manbendra Satpathy
 */
public class Decimal_Converter {
    /**
     * The main method is the entry point of the program.
     * It takes user input for a decimal number and converts it to binary and hexadecimal representations.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");

        if (input.hasNextInt()) {
            int decimal = input.nextInt();

            if (decimal < 0) {
                System.out.println("Error: Decimal number cannot be negative.");
            } else {
                String binary = Integer.toBinaryString(decimal);
                String hex = Integer.toHexString(decimal);

                System.out.println("Binary: " + binary);
                System.out.println("Hexadecimal: " + hex.toUpperCase());
            }
        } else {
            System.out.println("Error: Invalid input. Only integer input is accepted.");
        }

        input.close();
    }
}
