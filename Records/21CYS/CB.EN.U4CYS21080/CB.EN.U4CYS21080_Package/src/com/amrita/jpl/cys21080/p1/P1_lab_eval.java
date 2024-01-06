package com.amrita.jpl.cys21080.p1;

/**
 * @author T Pavan Kumar Reddy
 */

import java.util.Scanner;

public class P1_lab_eval {
    /**
     * The main method is the entry point of the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Choice : ");
        System.out.println("1. Reverse of a number");
        System.out.println("2. Largest of three numbers");
        System.out.println("3. Perfect Square");
        System.out.println("4. Prime Test");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter a number : ");
                int n1 = input.nextInt();
                System.out.println(reverse_num(n1));
                break;
            case 2:
                System.out.println("Enter three numbers : ");
                int n2 = input.nextInt();
                int n3 = input.nextInt();
                int n4 = input.nextInt();
                System.out.println(large3num(n2, n3, n4) + " is the largest among " + n2 + ", " + n3 + " & " + n4 + ".");
                break;
            case 3:
                System.out.println("Enter a number : ");
                int n5 = input.nextInt();
                perfect_square_check(n5);
                break;
            case 4:
                System.out.println("Enter a number : ");
                int n6 = input.nextInt();
                prime_test(n6);
                break;
            default:
                System.out.println("Enter a valid number.");
        }

    }

    /**
     * Returns the reverse of a given number.
     *
     * @param n the number to reverse
     * @return the reverse of the number
     */
    public static int reverse_num(int n) {
        int rev_num = 0;
        while (n != 0) {
            rev_num = rev_num * 10 + n % 10;
            n = n / 10;
        }
        return rev_num;
    }

    /**
     * Returns the largest among three numbers.
     *
     * @param n1 the first number
     * @param n2 the second number
     * @param n3 the third number
     * @return the largest number
     */
    public static int large3num(int n1, int n2, int n3) {
        int largest = n1;
        if (n2 > largest) {
            largest = n2;
        }
        if (n3 > largest) {
            largest = n3;
        }
        return largest;
    }

    /**
     * Checks if a number is a perfect square.
     *
     * @param n the number to check
     */
    public static void perfect_square_check(int n) {
        if (n < 0) {
            System.out.println("Error: Negative number");
            return;
        }
        int square_root = (int) Math.sqrt(n);
        if (square_root * square_root == n)
            System.out.println(n + " is a perfect square of number " + square_root + ".");
        else
            System.out.println(n + " is not a perfect square.");
    }

    /**
     * Checks if a number is prime.
     *
     * @param n the number to check
     */
    public static void prime_test(int n) {
        boolean is_prime = true;
        if (n < 0) {
            System.out.println("Error: Negative number");
            return;


        } else if ( n==0 || n==1) {
            System.out.println("Error: Neither Composite nor Prime.");
            return;

        }
            else{
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    is_prime = false;
                    break;
                }
            }
        }
        if (is_prime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
