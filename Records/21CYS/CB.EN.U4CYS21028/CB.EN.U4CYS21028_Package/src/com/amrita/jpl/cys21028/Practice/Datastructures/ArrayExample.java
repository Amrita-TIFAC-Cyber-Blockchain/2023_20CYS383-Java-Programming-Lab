package com.amrita.jpl.cys21028.Practice.Datastructures;

/**
 * The ArrayExample class demonstrates the usage of an array to store and display roll numbers.
 * It creates an array of roll numbers and performs an operation to check if a specific roll number is present.
 * This class provides a basic example of working with arrays in Java.
 *
*/
public class ArrayExample {
    /**
     * The main method is the entry point of the program.
     * It creates an array of roll numbers and performs an operation to check if a specific roll number is present.
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

        String searchRollNumber = "CB.EN.U4CYS22025";

        boolean found = false;
        int i = 0;
        while (i < rollNumber.length) {
            if (rollNumber[i].equals(searchRollNumber)) {
                found = true;
                break;
            }
            i++;
        }

        if (found) {
            System.out.println("Roll number " + searchRollNumber + " is present in the array.");
        } else {
            System.out.println("Roll number " + searchRollNumber + " is not present in the array.");
        }
    }
}
