package com.amrita.jpl.cys21080.practice.basics;

import java.util.Scanner;

/**
 * This class determines whether an input integer is even or odd.
 * @author T Pavan Kumar Reddy
 */
public class eve_odd {
    /**
     * Main method of the program.
     * Takes user input for an integer and prints whether it is even or odd.
     *
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any integer: ");
        int i = scanner.nextInt();

        int result = (i % 2 == 0) ? 0 : 1;

        if (result == 0) {
            System.out.println(i + " is even.");
        } else {
            System.out.println(i + " is odd.");
        }

        scanner.close();
    }
}
