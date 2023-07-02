package com.amrita.jpl.cys21042.practice.assignments;

/**
 * @Author : Mittul R - CB.EN.U4CYS21042
 */
public class Arraywhile {
    public static void main(String args[]) {
        // Creating an array of roll numbers
        String rollNumbers[] = {"CB.EN.U4CYS22041", "CB.EN.U4CYS22042", "CB.EN.U4CYS22043", "CB.EN.U4CYS22044", "CB.EN.U4CYS22045"};

        // Printing the roll numbers using a while loop
        int i = 0;
        while (i < rollNumbers.length) {
            System.out.println(rollNumbers[i]);
            i++;
        }
    }
}
