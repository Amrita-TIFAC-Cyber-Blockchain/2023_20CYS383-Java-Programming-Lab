package com.amrita.jpl.cys21062.ex;

public class PatternPrinter {

        public static void main(String[] args) {
            int i;
            for (i = 0; i < 8; i++) {
                if (i % 2 == 0 ) {
                    System.out.print("* * * * * ");
                    System.out.println("====================================");
                }
                else if(i%2!=0) {
                    System.out.print("* * * *  ");
                    System.out.println("=====================================");
                }
            }
            for (i = 0; i < 6; i++) {
                System.out.println("==============================================");
            }
        }
    }