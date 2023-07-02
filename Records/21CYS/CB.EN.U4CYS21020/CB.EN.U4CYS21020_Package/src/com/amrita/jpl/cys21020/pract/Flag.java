/**
 * @author Hemesh sai
 * @version 1.0
 * The Flag class prints a flag pattern using asterisks (*) and equals (=) symbols.
 */
package com.amrita.jpl.cys21020.pract;
public class Flag {
    /**
     * The main method of the Flag class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Printing the flag pattern
        for (int i = 0; i < 9; i++) {
            for (int f = 0; f < 39; f++) {
                if (f < 6) {
                    System.out.print("* ");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();
            for (int f = 0; f < 40; f++) {
                if (f < 5) {
                    System.out.print("* ");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 6; i++) {
            for (int f = 0; f < 45; f++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
