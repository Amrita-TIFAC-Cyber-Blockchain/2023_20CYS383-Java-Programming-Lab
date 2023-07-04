package com.amrita.jpl.cys21085.pract;

import java.io.*;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * A program to print the elements of a 2D array or matrix.
 */
class Array2D {
    /**
     * Prints the elements of a 2D array.
     *
     * @param mat the 2D array to print
     */
    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String args[]) throws IOException {
        int mat[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        print2D(mat);
    }
}
