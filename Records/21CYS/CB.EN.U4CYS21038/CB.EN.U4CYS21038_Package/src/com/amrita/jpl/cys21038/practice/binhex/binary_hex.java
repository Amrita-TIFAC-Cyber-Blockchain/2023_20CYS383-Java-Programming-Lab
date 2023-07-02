package com.amrita.jpl.cys21038.practice.binhex;
/**
 * @author Madhav H
 */

import java.util.*;
public class binary_hex {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        if (input.hasNextInt()) {
            int decimal = input.nextInt();
            if (decimal < 0) {
                System.out.println("Error: Input must be a non-negative integer.");
                return;
            }
            String binary = Integer.toBinaryString(decimal);
            String hex = Integer.toHexString(decimal).toUpperCase();
            System.out.println("Binary: " + binary);
            System.out.println("Hexadecimal: " + hex);
        } else {
            System.out.println("Error: Input must be a non-negative integer.");
        }
    }
}