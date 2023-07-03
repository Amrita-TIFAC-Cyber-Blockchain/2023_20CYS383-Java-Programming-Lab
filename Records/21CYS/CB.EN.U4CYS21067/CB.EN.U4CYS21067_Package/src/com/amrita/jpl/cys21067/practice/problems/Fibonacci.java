package com.amrita.jpl.cys21067.practice.problems;

/**
 * The Fibonacci class generates and prints the Fibonacci sequence.
 */
public class Fibonacci {

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, n3, i, count = 10;

        System.out.print(n1 + " " + n2); // printing 0 and 1

        for (i = 2; i < count; ++i) { // loop starts from 2 because 0 and 1 are already printed
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
