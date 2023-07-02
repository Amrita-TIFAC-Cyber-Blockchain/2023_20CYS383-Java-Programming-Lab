package com.amrita.jpl.cys21010.practice.mathmatical;

import java.util.*;

class dec_to_bin_hex
{
    public static void main(String args[])
    {
        Scanner scan;
        int num;
        System.out.println("Decimal to Hexadecimal and Binary");
        scan = new Scanner(System.in);
        System.out.println("Enter the number :");
        num = Integer.parseInt(scan.nextLine());
        String hexa = Integer.toHexString(num);
        System.out.println("Hexadecimal Value is : " + hexa);;
        String binary = Integer.toBinaryString(num);
        System.out.println("Binary Value is : " + binary);
    }
}