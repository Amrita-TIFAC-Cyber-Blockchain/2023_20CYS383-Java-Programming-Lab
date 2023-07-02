package com.amrita.jpl.cys21041.prac.dsa;


public class ArrayExample {

    public static void main(String args[]) {
        int[] rollNumber = new int[5];

        rollNumber[0] = 22021;
        rollNumber[1] = 22022;
        rollNumber[2] = 22023;
        rollNumber[3] = 22024;
        rollNumber[4] = 22025;

        for (int i = 0; i < rollNumber.length; i++) {
            System.out.println(rollNumber[i]);
        }
    }
}