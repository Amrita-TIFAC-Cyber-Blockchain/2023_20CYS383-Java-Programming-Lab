package com.amrita.jpl.cys21035.pract;

import java.util.Scanner;

public class sum {
    public static void main(String[] args){
        int a,b,sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st number: ");
        a = sc.nextInt();

        System.out.println("Enter the 2nd number: ");
        b = sc.nextInt();

        sc.close();
        sum = a+b;
        System.out.println("Sum : "+sum);
    }
}

