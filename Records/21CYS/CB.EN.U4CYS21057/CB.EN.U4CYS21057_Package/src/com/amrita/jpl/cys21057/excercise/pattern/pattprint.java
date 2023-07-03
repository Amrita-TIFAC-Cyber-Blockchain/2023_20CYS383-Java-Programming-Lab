package com.amrita.jpl.cys21057.excercise.pattern;

public class pattprint{
    public static void main(String[] args) {
        for(int i=1;i<=15;i++) {
            for (int j = 1; j < 40; j++) {
                if (i < 10 && j < 7) {
                    if (i % 2 == 0 && j == 5) {
                        continue;
                    }
                    System.out.print("*");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}