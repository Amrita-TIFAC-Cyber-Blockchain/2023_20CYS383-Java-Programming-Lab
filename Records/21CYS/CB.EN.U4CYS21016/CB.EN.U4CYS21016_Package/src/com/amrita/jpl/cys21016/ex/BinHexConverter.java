package com.amrita.jpl.cys21016.ex;
/**
 * Basic Decimal to Binary & Hex coverter
 * @author G H Hem Sagar
 * @version 1.0
 * */
import java.util.Scanner;
public class BinHexConverter {
    public static void main(String[] args) {
        /**
         * gets the decimal input from the user & converts it into Binary and Hexadecimal values.
         * @param args -> commandline arguments
        * */
        System.out.println("Decimal to Binary and Hex Converter.");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the decimal number to convert: ");
        int decimal = input.nextInt();
        if (decimal < 0) {
            // checks if the decimal values if 0.
            System.out.println("Decimal number cannot be negative!\n");
            System.exit(0);
        }
        String binary = Integer.toBinaryString(decimal);
        String hexadecimal = Integer.toHexString(decimal);
        System.out.println("Binary equivalent: " + binary);
        System.out.println("Hexadecimal equivalent: " + hexadecimal);
        input.close();
    }
}
