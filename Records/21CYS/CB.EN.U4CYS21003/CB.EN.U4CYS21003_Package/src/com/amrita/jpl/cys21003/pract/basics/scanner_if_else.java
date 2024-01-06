package com.amrita.jpl.cys21003.pract.basics;

import java.util.Scanner;
/**
 * Program that gets mark as input and say whose mark is greater
 *
 * @author Aishwarya G
 * @version 1.0
 */

public class scanner_if_else {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Aishwarya total mark");
        int aish = input.nextInt();  // Read user input
        System.out.println("Aishwarya Mark is: " + aish);
        System.out.println("Enter Soundarya total mark");
        int soundh = input.nextInt();  // Read user input
        System.out.println("Soundarya Mark is: " + soundh);

        if(aish>soundh) {
            System.out.println("Aishwarya scored greater");
        }
        else {
            System.out.println("Soundarya scored greater");
        }
    }
}
