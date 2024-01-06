package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;

/**
 * This program checks if a given string is a palindrome.
 * A palindrome is a string that remains the same when its characters are reversed.
 */
public class Palindrome {

    /**
     * The main method allows the user to input a string and checks if it is a palindrome.
     * It compares the characters at corresponding positions from the beginning and end of the string
     * to determine if it is a palindrome.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean isPalindrome = true;

        // Compare characters from the beginning and end of the string
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Print the result
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}

