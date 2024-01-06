package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program checks if a given year is a leap year.
 * Leap years are those that are divisible by 4 but not divisible by 100,
 * except for years that are divisible by 400.
 */
public class LeapYearCheck {

    /**
     * The main method allows the user to input a year and checks if it is a leap year.
     * If the year is a leap year, it prints "is a leap year," otherwise it prints "is not a leap year."
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear = false;

        // Check if the year is divisible by 4
        if (year % 4 == 0) {
            // If divisible by 100, check if also divisible by 400
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        // Print the result
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
