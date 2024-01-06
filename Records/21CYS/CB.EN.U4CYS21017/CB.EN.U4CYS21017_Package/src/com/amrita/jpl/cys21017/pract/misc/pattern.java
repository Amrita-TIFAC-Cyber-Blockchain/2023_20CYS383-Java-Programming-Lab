package com.amrita.jpl.cys21017.pract.misc;

/**
 * class pattern
 * it prints pattern given in the assignment
 */
public class pattern {
    public static void main(String[] args) {

        for(int i = 1; i <= 29; i++){
            for(int j = 1; j <= 47; j++){
                if( i == 19 || i == 21 || i == 23 || i == 25 || i == 27 || i == 29 ){
                    System.out.print("=");
                } else if ( (i == 1 || i == 5 || i == 9 || i == 13 || i == 17) && (j==1 || j==3 || j==5 ||j==7 ||j==9 ||j==11) ) {
                    System.out.print("* ");
                } else if ( (i == 3 || i == 7 || i == 11 || i == 15) && (j==1 || j==3 || j==5 ||j==7) ) {
                    System.out.print("* ");
                } else if ( (i == 1 || i == 5 || i == 9 || i == 13 || i == 17) && (j>=13) ) {
                    System.out.print("=");
                } else if ( (i == 3 || i == 7 || i == 11 || i == 15) && (j>=9) ) {
                    System.out.print("=");
                } else if (j == 47) {
                    System.out.println("=");
                }
            }
        }
    }
}
