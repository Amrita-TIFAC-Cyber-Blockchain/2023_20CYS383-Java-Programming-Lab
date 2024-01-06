package com.amrita.jpl.cys21028.Practice.operations;

import java.util.Scanner;
public class Converter {
    public static void main(String args[])
    {
        /**
         * @param args used for taking arguements
         *
         */
        int dec, quotient, i=1, j;
        int bin[] = new int[100];
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Decimal Number : ");
        dec = scan.nextInt();

        quotient = dec;

        while(quotient != 0)
        {
            bin[i++] = quotient%2;
            quotient = quotient/2;
        }

        System.out.print("Binary number is: ");
        for(j=i-1; j>0; j--)
        {
            System.out.print(bin[j]);
        }
        System.out.print("\n");
    }
}