package com.amrita.jpl.cys21030.practice;
public class PatternPrint {
    public static void main(String[] args) {
        int rows = 5; // Number of rows in the pattern

        for (int i = 1; i <= rows; i++) {
            if (i % 2 == 0) {
                System.out.println("=======");
            } else {
                System.out.println("********");
            }
        }
    }
}
