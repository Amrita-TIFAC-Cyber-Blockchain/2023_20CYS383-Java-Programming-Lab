package com.amrita.jpl.cys21022.p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your choice (1 for factorial, 2 for sum of 'n' numbers): ");
        int choice = sc.nextInt();


        System.out.println("Menu:");
        System.out.println("1. Factorial (fact)");
        System.out.println("2. Sum of 'n' numbers");


        switch (choice) {
            case 1:
                int n;
                long factorial = 1;

                System.out.print("Enter a positive integer: ");
                n = sc.nextInt();


                for (int i = 1; i <= n; i++) {
                    factorial *= i;
                }

                System.out.println("Factorial of " + n + " = " + factorial);
                break;

            case 2:
                int sum = 0;
                int count;

                System.out.print("Enter the count of numbers: ");
                count = sc.nextInt();


                for (int i = 1; i <= count; i++) {
                    System.out.print("Enter number " + i + ": ");
                    sum = sum + i;
                }

                System.out.println("Sum of " + count + " numbers = " + sum);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
