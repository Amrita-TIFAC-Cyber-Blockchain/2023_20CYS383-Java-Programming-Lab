package com.amrita.jpl.cys21066.EX;

public class PatternProgram {
    public static void printPattern() {
        // Loop to print the pattern rows
        for (int i = 0; i < 6; i++) {
            // Print asterisks and equal signs pattern
            System.out.println("* * * * * * ==================================");
            // Print spaces and equal signs pattern
            System.out.println(" * * * * *  ==================================");
        }
        // Print the final row of equal signs
        System.out.println("* * * * * * ==================================");

        // Loop to print the remaining rows of equal signs
        for (int i = 0; i < 7; i++) {
            System.out.println("==============================================");
        }
    }

    public static void main(String[] args) {
        // Call the printPattern method to print the pattern
        printPattern();
    }
}
