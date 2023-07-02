package com.amrita.jpl.cys21044.pract.dectobinhex;
import java.util.Scanner;
/**
*@author ravi
*/
public class Decimaltobh {
    public Decimaltobh() {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        if (!s.hasNextInt()) {
            System.out.println("Error: Input is not an integer.");
            s.close();
        } else {
            int d = s.nextInt();
            /**
            *@param d- input number
            */
            if (d < 0) {
                System.out.println("Error: Negative numbers are not supported.");
                s.close();
            } else {
                String b = Integer.toBinaryString(d);
                String h = Integer.toHexString(d);
            /**
            *@param b-  binary number
            *@param h- hex number
            */
                System.out.println("Binary: " + b);
                System.out.println("Hexadecimal: " + h);
                s.close();
            }
        }
    }
}
