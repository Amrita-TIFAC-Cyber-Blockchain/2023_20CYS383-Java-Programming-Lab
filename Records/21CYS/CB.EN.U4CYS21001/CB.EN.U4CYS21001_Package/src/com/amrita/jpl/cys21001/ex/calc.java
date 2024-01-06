package com.amrita.jpl.cys21001.ex;

import java.util.Scanner;

/**
 * This program is  implementation of a calculator.
 *
 * @author Abi G
 * @param args command line arguments
 */

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;


        num1 = scanner.nextDouble();


        num2 = scanner.nextDouble();


        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));

        if (num2 !=0){
            System.out.println("Division: " + (num1 / num2));
        } else {
            System.out.println("Error: Division by zero! ");
            System.out.println("Division: -1");
            return;
        }


    }
}