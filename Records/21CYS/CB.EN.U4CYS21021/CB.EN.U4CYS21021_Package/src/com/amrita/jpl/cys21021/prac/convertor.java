package com.amrita.jpl.cys21021.prac;

import java.util.Scanner;

public class convertor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalInput = scanner.nextInt();
        scanner.close();

        if (decimalInput < 0) {
            System.out.println("Error: Negative numbers are not supported.");
            return;
        }

        String binaryOutput = Integer.toBinaryString(decimalInput);
        String hexadecimalOutput = Integer.toHexString(decimalInput);

        System.out.println("Binary equivalent: " + binaryOutput);
        System.out.println("Hexadecimal equivalent: " + hexadecimalOutput.toUpperCase());
    }

}
