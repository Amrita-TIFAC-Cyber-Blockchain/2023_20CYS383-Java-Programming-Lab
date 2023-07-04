package com.amrita.jpl.cys21075.ex;



public class binary2decimal{

    public static void decimalToBinaryAndHexadecimal(int decimal) {
        if (decimal < 0) {
            System.out.println("Error: input must be a non-negative integer.");
            return;
        }

        String binary = Integer.toBinaryString(decimal);
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();

        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hexadecimal);
    }

    public static void main(String[] args) {
        decimalToBinaryAndHexadecimal(10);
        decimalToBinaryAndHexadecimal(255);
        decimalToBinaryAndHexadecimal(-10);
    }
}
