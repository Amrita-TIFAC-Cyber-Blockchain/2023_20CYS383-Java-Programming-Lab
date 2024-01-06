package com.amrita.jpl.cys21080.practice.basics;


import java.util.Scanner;

/**
 * The Main class represents a program to convert a decimal number to binary and hexadecimal equivalents.
 * It takes a decimal number as input from the user, performs the conversion, and displays the results.
 *
 * Usage:
 * - Run the program and enter a decimal number when prompted.
 * - The program will convert the decimal number to its binary and hexadecimal equivalents.
 * - The results will be displayed on the console.
 *
 * Note: The program does not support negative numbers.
 *
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
public class converter {

    /**
     * The main method is the entry point of the program.
     * It prompts the user for a decimal number, performs the conversion, and displays the results.
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

