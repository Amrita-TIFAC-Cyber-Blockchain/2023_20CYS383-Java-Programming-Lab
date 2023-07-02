package com.amrita.jpl.cys21042.exercises;
//package com.ramaguru.amrita.cys.jpl.datastructures;

/**
 * The ArrayExample class demonstrates the usage of an array to store and display roll numbers.
 * It creates an array of roll numbers and prints each roll number using a for loop.
 * This class provides a basic example of working with arrays in Java.
 *
 * Usage:
 * - The program creates an array of roll numbers with a specified size.
 * - It assigns roll numbers to array elements.
 * - It uses a for loop to iterate through the array and print each roll number.
 *
 * Note: This example assumes a fixed size for the array and assigns values manually.
 *
 * Dependencies:
 * - None
 *
 * @author Mittul R
 * @version 1.1
 */
public class ArrayExample {
    /**
     * The main method is the entry point of the program.
     * It creates an array of roll numbers and prints each roll number using a for loop.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        String rollNumber[] = new String[5];

        rollNumber[0] = "CB.EN.U4CYS21041";
        rollNumber[1] = "CB.EN.U4CYS21042";
        rollNumber[2] = "CB.EN.U4CYS21043";
        rollNumber[3] = "CB.EN.U4CYS21044";
        rollNumber[4] = "CB.EN.U4CYS21045";

        for (int i = 0; i < rollNumber.length; i++) {
            System.out.println(rollNumber[i]);
        }

        System.out.println("....Print the reverse order of roll numbers...");
        for (int i = rollNumber.length - 1; i >= 0; i--) {
            System.out.println(rollNumber[i]);
        }

        String longestRollNumber = rollNumber[0];
        for (int i = 1; i < rollNumber.length; i++) {
            if (rollNumber[i].length() > longestRollNumber.length()) {
                longestRollNumber = rollNumber[i];
            }
        }
        System.out.println("Roll number with the longest length: " + longestRollNumber);

        String substring = "U4CYS4";
        int count = 0;
        for (String roll : rollNumber) {
            if (roll.contains(substring)) {
                count++;
            }
        }
        System.out.println("Number of Roll numbers containing '" + substring + "': " + count);

        String targetRollNumber = "CB.EN.U4CYS21043";
        boolean exists = false;
        for (String roll : rollNumber) {
            if (roll.equals(targetRollNumber)) {
                exists = true;
                break;
            }
        }
        System.out.println("Roll number " + targetRollNumber + " exists: " + exists);

        String searchSubstring = "CB.EN";
        String replaceSubstring = "EN.CB";
        for (int i = 0; i < rollNumber.length; i++) {
            rollNumber[i] = rollNumber[i].replace(searchSubstring, replaceSubstring);
            System.out.println(rollNumber[i]);
        }


    }
}
