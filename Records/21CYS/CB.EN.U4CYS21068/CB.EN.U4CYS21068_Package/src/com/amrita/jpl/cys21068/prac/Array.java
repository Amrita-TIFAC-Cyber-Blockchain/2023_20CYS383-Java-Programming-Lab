package com.amrita.jpl.cys21068.prac;

public class Array {

    public static void main(String args[]) {
        String rollNumber[] = new String[5];

        rollNumber[0] = "sara";
        rollNumber[1] = "sana";
        rollNumber[2] = "rushil";
        rollNumber[3] = "tanmay";
        rollNumber[4] = "sanjay";

        for (int i = 0; i < rollNumber.length; i++) {
            System.out.println(rollNumber[i]);
        }
    }
}
