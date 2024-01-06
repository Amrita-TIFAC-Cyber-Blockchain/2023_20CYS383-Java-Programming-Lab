package com.amrita.jpl.cys21008.Pract;

import java.util.Scanner;

public class digsum {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number to calculate sum: ");
            int a = sc.nextInt();
            int sum =0;
            int x;
            while(a>0){
                x = a%10;
                sum = sum + x;
                a = a/10;
            }
            System.out.println("The sum of the digit is: " + sum);
        }
    }

