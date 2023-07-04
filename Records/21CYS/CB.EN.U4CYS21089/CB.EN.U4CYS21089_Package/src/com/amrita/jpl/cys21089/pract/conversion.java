/**
 * The Conversion class provides methods to convert a decimal number to binary and hexadecimal representation.
 * It takes a decimal number as input from the user and performs the conversions.
 * The binary and hexadecimal representations are then displayed.
 *
 * @author Yaswanth Gadamsetti
 */
package com.amrita.jpl.cys21089.pract;

import java.util.Scanner;

public class conversion {

    /**
     * Converts the given decimal number to binary representation.
     *
     * @param decimal The decimal number to be converted
     */
    public static void toBinary(int decimal){
        int[] binary = new int[50];
        int index = 0;
        while(decimal > 0){
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        System.out.println("Binary of the input is ");
        for(int i = index - 1; i >= 0; i--){
            System.out.print(binary[i]);
        }
    }

    /**
     * Converts the given decimal number to hexadecimal representation.
     *
     * @param decimal The decimal number to be converted
     */
    public static void toHex(int decimal){
        int i;
        StringBuilder hex = new StringBuilder();
        char[] hexchars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal > 0){
            i = decimal % 16;
            hex.insert(0, hexchars[i]);
            decimal = decimal / 16;
        }
        System.out.println("\n");
        System.out.println("Hexadecimal of the input is " + hex);
    }

    /**
     * The entry point of the program.
     * It prompts the user to enter a decimal number, performs the conversions, and displays the results.
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args){
        int decimal;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the decimal number: ");
        decimal = myObj.nextInt();
        toBinary(decimal);
        toHex(decimal);
    }
}
