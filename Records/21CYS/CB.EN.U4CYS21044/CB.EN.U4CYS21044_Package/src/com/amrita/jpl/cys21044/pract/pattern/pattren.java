package com.amrita.jpl.cys21044.pract.pattern;

/**
*@author ravi
*/
public class pattren {
    public pattren() {
    }

    public static void main(String[] args) {
        int i;
        for(i = 0; i < 6; ++i) {
            if (i % 2 == 0) {
                System.out.println("* * * * * * ==================================");
            } else {
                System.out.println(" * * * * *  ===================================");
            }
        }

        for(i = 0; i < 6; ++i) {
            System.out.println("==============================================");
        }

    }
}

