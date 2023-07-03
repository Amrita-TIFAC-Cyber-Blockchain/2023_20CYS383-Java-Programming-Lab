package com.amrita.jpl.cys21061.pract.Arrays;

public class ArrayExample {
    /**
     * The main method is the entry point of the program.
     * It creates an array of roll numbers and prints each roll number using a for loop.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        String rollNumber[] = new String[5];

        rollNumber[0] = "CB.EN.U4CYS22021";
        rollNumber[1] = "CB.EN.U4CYS22022";
        rollNumber[2] = "CB.EN.U4CYS22023";
        rollNumber[3] = "CB.EN.U4CYS22024";
        rollNumber[4] = "CB.EN.U4CYS22025";

        for (int i = 0; i < rollNumber.length; i++) {
            System.out.println(rollNumber[i]);
        }
    }
}