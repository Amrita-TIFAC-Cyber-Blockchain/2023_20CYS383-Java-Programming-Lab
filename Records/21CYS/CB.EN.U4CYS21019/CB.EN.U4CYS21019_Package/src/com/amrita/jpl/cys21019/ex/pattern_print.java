package com.amrita.jpl.cys21019.ex;

/**
 * This program prints a pattern consisting of asterisks (*) and equal signs (=).
 * Author: Gokulachselvan C D
 */

public class pattern_print {
    public static void main(String[] args) {

        // Print the top section of the pattern
        for (int i = 0; i < 4; i++) {
            System.out.println("* * * * * * ==================================");
            System.out.println("* * * * *  ===================================");
        }
        System.out.println("* * * * * * ==================================");

        // Print the bottom section of the pattern
        for (int i = 0; i < 6; i++) {
            System.out.println("==============================================");
        }
    }
}
