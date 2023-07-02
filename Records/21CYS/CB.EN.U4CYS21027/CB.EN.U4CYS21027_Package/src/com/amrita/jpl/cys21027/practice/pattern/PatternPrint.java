/**

 * The PatternPrint class prints a pattern consisting of asterisks (*) and equal signs (=).

 * The class generates a pattern with alternating rows of asterisks and equal signs. The number of asterisks in each row is fixed, while the number of equal signs in each row decreases.

 * The class assumes a fixed size for the pattern and uses a loop to generate the pattern.

 * @Author: K Sri Sai Nitin
 * @version: 0.5

 */
package com.amrita.jpl.cys21027.practice.pattern;

public class PatternPrint {
    /**
     * Main method that prints factorial to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        int size = 10;
        for (int i = 1; i < size; i++) {
            if (i % 2 == 0) {
                System.out.println("* * * * * ===================================");
            } else {
                System.out.println("* * * * * * ==================================");
            }
        }
        for (int j = 0; j < 6; j++) {
            System.out.println("==============================================");
        }
        System.out.println();
    }
}