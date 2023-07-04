package com.amrita.jpl.cys21023.ex;

public class Pattern {


    public static void main(String[] args) {
        for(int i = 0; i < 15; ++i) {
            for(int j = 0; j < 46; ++j) {
                if (i < 9) {
                    if (i % 2 == 0 && j < 12) {
                        if (j % 2 == 0) {
                            System.out.print('*');
                        } else {
                            System.out.print(' ');
                        }
                    } else if (j < 11) {
                        if (j % 2 == 0 && j != 10) {
                            System.out.print('*');
                        } else {
                            System.out.print(' ');
                        }
                    } else {
                        System.out.print('=');
                    }
                } else {
                    System.out.print("=");
                }
            }

            System.out.println();
        }

    }
}
