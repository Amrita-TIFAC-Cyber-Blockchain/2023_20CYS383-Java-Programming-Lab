package com.amrita.jpl.cys21047.ex;


/**
 *
 * Decimal Converter from decimal to binary and hexa.
 *
 * @author N.vihal roy
 * @version 1
 */
import java.util.Scanner;

    public class DecimalConverter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a decimal number: ");
            int decimal = scanner.nextInt();

            if (decimal < 0) {
                System.out.println("Error: Only positive integers are accepted.");
            } else {
                String binary = Integer.toBinaryString(decimal);
                String hexadecimal = Integer.toHexString(decimal);

                System.out.println("The Binary number is: " + binary);
                System.out.println("The Hexadecimal number is: " + hexadecimal);
            }
        }
    }

