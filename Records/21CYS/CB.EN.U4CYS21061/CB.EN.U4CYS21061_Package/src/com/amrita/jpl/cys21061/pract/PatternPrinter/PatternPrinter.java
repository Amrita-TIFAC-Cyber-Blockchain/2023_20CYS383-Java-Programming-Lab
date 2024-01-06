package com.amrita.jpl.cys21061.pract.PatternPrinter;
public class PatternPrinter {
    public static void main(String[] args) {
        int rowCount = 15;
        int columnCount = 46;

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    System.out.print("= ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
