package com.amrita.jpl.cys21028.Practice.operations;

import java.util.Scanner;
public class Subtraction{
    public static void main(String[] args){
        /**
         * @param args takes in arguements
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 integers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int total = a - b;
        System.out.print(total);
    }
}