package com.amrita.jpl.cys21027.practice.decimalconvert;

/**

 * The DecimalConversion class converts a decimal value to binary and hexadecimal.

 * The class prompts the user to enter a decimal value, validates the input, and then converts the decimal value to its binary and hexadecimal representations.

 * The binary conversion is performed using the {@link Integer#toBinaryString(int)} method, and the hexadecimal conversion is performed using the {@link Integer#toHexString(int)} method.

 * Note: The class assumes the decimal value to be non-negative.
 * @author K Sri Sai Nitin
 * @version 0.5

 */

import java.util.Scanner;

public class DecimalConversion {
    /**
     * The main method prompts the user to enter a decimal value, validates the input,
     * and converts the decimal value to binary and hexadecimal representations.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Decimal Value: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid Input!! Please enter an integer value.");
            return;
        }

        int deci = input.nextInt();

        if (deci < 0) {
            System.out.println("Error: Please enter only non-negative values!!!");
            return;
        }

        String bin = Integer.toBinaryString(deci);
        String hex = Integer.toHexString(deci);

        System.out.println("Binary converted value of Decimal: " + bin);
        System.out.println("Hexadecimal converted value of Decimal: " + hex);
    }
}