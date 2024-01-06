package com.amrita.jpl.cys21013.pract;

import java.util.Scanner;

/**
 * The DecimaltoBINtoHEX class converts a decimal number to its binary and hexadecimal equivalents.
 * @author Basi Reddy Rohith Reddy
 * @version 1.0
 *
 */
public class DecimaltoBINtoHEX {

    /**
     * The main method is the entry point of the program.
     * It takes a decimal number as input, converts it to binary and hexadecimal representations,
     * and prints the results to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalInput = scanner.nextInt();
        scanner.close();

        if (decimalInput < 0) {
            System.out.println("Error: Negative numbers are not supported.");
            return;
        }

        String binaryOutput = Integer.toBinaryString(decimalInput);
        String hexadecimalOutput = Integer.toHexString(decimalInput);

        System.out.println("Binary equivalent: " + binaryOutput);
        System.out.println("Hexadecimal equivalent: " + hexadecimalOutput.toUpperCase());
    }

}
