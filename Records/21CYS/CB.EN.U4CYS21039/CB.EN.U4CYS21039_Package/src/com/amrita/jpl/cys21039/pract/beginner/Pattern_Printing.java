package com.amrita.jpl.cys21039.pract.beginner;

/**
 * A program to print a pattern using asterisks and equal signs.
 *
 * @author Manbendra Satpathy
 */
public class Pattern_Printing {
    /**
     * The main method is the entry point of the program.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                System.out.println("* * * * * * ==================================");
            } else {
                System.out.println(" * * * * *  ===================================");
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("==============================================");
        }
    }
}
