package com.amrita.jpl.cys21085.pract;

/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * A program to demonstrate the usage of arrays in Java.
 */
public class ArrayExample {
    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] names = new String[4];

        // Assign values to array elements
        names[0] = "Vinoth";
        names[1] = "Santy";
        names[2] = "Laks";

        // Print the elements of the array
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
