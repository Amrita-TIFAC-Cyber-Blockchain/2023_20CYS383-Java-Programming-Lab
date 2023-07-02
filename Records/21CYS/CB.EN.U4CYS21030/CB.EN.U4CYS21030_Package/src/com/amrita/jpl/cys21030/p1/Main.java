package com.amrita.jpl.cys21030.p1;
import java.util.Scanner;
/*
@author Sai Suvarchala Kavali
Java Programming Lab Periodical 1
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        // read user's choice and load it

        System.out.print("Enter your choice (1. Factorial of a number , 2. Fibonacci, 3. Sum of n numbers, 4. Prime Test): ");
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid choice. Please enter a number.");
            return;
        }
        Main question= new Main();

        switch (choice) {


            case 1:
                // factorial of a number
                System.out.print("Enter a positive integer: ");
                int n1 = scanner.nextInt();
                if (n1 < 0) {
                    System.out.println("Error: The input number should be positive.");
                    return;
                }
                long result1 = question.fact(n1);
                System.out.println("Factorial of " + n1 + " is " + result1);
                break;
            case 2:
                // fibonacci of the number
                System.out.print("Enter the number of terms you want to display: ");
                int n2 = scanner.nextInt();
                if (n2 < 1) {
                    System.out.println("Error: The input number should be greater than or equal to 1.");
                    return;
                }
                fibo(n2);
                break;
            case 3:
                // sum of n numbers
                System.out.print("Enter the numbers that  you want to add: ");
                int n3 = scanner.nextInt();
                if (n3 < 1) {
                    System.out.println("Error: The input number should be greater than or equal to 1.");
                    return;
                }
                int result3 = sum_n_no(n3);
                System.out.println("Sum of first " + n3 + " numbers is " + result3);
                break;
            case 4:
                // prime test
                System.out.print("Enter a positive integer: ");

                int n4 = scanner.nextInt();
                if (n4 < 1) {
                    System.out.println("Error: The input number should be greater than or equal to 1.");
                    return;
                }

                break;

            default:
                System.out.println("Invalid choice. Please choose a number of choice from 1 to 4.");
                return;
        }
    }

    // function to calculate factorial
    public long fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    // function to display fibonacci series
    public void fibo(int n) {
        int n1 = 0, n2 = 1, n3;
        System.out.print(n1 + " " + n2);
        for (int i = 2; i < n; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    // function to calculate sum of n numbers
    public int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }



    }

