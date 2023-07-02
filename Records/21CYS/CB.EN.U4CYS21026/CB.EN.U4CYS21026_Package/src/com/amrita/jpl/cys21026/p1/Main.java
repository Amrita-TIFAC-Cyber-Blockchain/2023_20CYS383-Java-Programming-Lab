package com.amrita.jpl.cys21026.p1;

import java.util.Scanner;
/**
 * @author K manoj ram
 *
 */

class Program {

    /**
     * Function to reverse a given number
     */
    public static int reverseNum(int num) {
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return rev;
    }

    /**
     * Function to find the largest among three numbers
     */
    public static int largestNum(int num1, int num2, int num3) {
        int largest = num1;
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        return largest;
    }

    /**
     * Function to check if a number is a perfect square
     */
    public static void isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
    }

    /**
     * Function to check if a number is prime
     */
    public static void isPrime(int num) {
        boolean isPrime = true;
        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:\n1. Reverse of a number (reverse num)\n2. Largest of three numbers (large3num)\n3. Perfect Square (perfect square check)\n4. Prime Test (prime test)");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the number to reverse:");
                int numToReverse = sc.nextInt();
                int reversedNum = reverseNum(numToReverse);
                System.out.println("The reversed number is: " + reversedNum);
                break;

            case 2:
                System.out.println("Enter three numbers:");
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                int num3 = sc.nextInt();
                int largestNum = largestNum(num1, num2, num3);
                System.out.println("The largest number is: " + largestNum);
                break;

            case 3:
                System.out.println("Enter a number to check if it is a perfect square:");
                int numToCheck = sc.nextInt();
                isPerfectSquare(numToCheck);
                break;

            case 4:
                System.out.println("Enter a number to check if it is prime:");
                int numToTest = sc.nextInt();
                isPrime(numToTest);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
