package com.amrita.jpl.cys21034.pract.basic;

import java.util.Scanner;

public class convertingDecimal {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();
        /**
         *converting Decimal to Binary
         */

        String binary = Integer.toBinaryString(num);
        /**
         *converting Decimal to Hexadecimal
         */

        String hex = Integer.toHexString(num).toUpperCase();

        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hex);
    }
}
