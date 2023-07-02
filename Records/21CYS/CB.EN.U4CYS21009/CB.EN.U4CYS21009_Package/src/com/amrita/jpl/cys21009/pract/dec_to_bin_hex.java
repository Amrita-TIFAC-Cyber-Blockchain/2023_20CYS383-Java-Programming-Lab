package com.amrita.jpl.cys21009.pract;
import java.util.*;

/**
 *
 * Decimal to Binary and hexadecimal converter
 *
 * @author Aravind
 * @version 1
 */
public class dec_to_bin_hex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the decimal number to convert: ");
        int dec = sc.nextInt();
        if (dec < 0) {
            System.out.println("Decimal number cannot be negative");
        } else {
            String bin = Integer.toBinaryString(dec);
            String hex = Integer.toHexString(dec);
            System.out.println("Binary equivalent: " + bin);
            System.out.println("Hexadecimal equivalent: " + hex);
        }
        /**
         * @param dec stores decimal input
         * @param bin stores binary value of input
         * @param hex stores hexadecimal value of input
         */
    }
}
