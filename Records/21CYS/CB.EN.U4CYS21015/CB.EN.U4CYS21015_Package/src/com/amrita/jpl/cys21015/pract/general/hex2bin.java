package com.amrita.jpl.cys21015.pract.general;

import java.util.Scanner;

/**
 * @author Dyanesh S [CB.EN.U4CYS21015]
 */

public class hex2bin {

    /**
     * Converts decimal to hexadecimal and binary
     */

    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = read.nextInt();

        System.out.println(n+" in binary is : "+Integer.toBinaryString(n));
        System.out.println(n+" in hexadecimal is : "+Integer.toHexString(n));
    }
}