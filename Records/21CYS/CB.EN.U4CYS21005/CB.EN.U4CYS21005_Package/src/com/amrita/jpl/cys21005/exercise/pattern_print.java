package com.amrita.jpl.cys21005.exercise;

/**
 * @author Alagu Soundarya G
 * @version 1.0
 * Question 2 Pattern Printing
 */

public class pattern_print {
    public static void main(String[] args) {
        int i,j;
        for(i=1;i<=15;i++){
            for(j=1;j<40;j++){
                if(i<10 && j<7){
                    if(i%2==0 && j==5){
                        continue;
                    }
                    System.out.print("*");
                }
                else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}