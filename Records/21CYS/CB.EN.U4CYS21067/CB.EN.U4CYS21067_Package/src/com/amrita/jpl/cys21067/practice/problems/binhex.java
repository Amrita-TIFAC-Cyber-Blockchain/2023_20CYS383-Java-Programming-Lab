package com.amrita.jpl.cys21067.practice.problems;

import java.util.Scanner;


/**
 * The binhex class converts a decimal number to binary and hexadecimal formats.
 */
public class binhex {

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        if (decimal < 0) {
            System.out.println("Error: Only positive integers are allowed.");
            return;
        }

        String binary = Integer.toBinaryString(decimal);
        String hex = Integer.toHexString(decimal);

        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hex);
    }
}
