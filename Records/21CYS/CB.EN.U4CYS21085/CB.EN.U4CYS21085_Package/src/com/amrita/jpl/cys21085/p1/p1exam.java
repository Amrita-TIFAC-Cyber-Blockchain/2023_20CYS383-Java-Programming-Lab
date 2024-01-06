package com.amrita.jpl.cys21085.p1;

import java.util.Scanner;
/**
 * @author cb.en.u4cys21085 - Vinoth Kumar C
 * Periodicals 1 - Java Programming lab
 */

/**
 * This class is used to perform the following operations
 * 1. Reverse of a number (reverse num)
 * 2. Largest of three numbers (large3num)
 * 3. Perfect Square (perfect square check)
 * 4. Prime Test (prime test)
 */
public class p1exam {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * @param choice is used to select the operation
         */
        System.out.println("1. Reverse of a number (reverse_num)\n2.Largest of three numbers\n" +
                "(large3Num)\n3. Perfect Square (perfect_Square_Check)\n4. Prime Test (prime_test)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        /**
         * @param num is used to store the input for Reverse of a number (reverse_num)
         * @param num1 num2 num3  is used to store the input for Largest of three numbers (large3num)
         * @param squareInt is used to store the input for Perfect Square (perfect square check)
         * @param primeInt is used to store the input for prime test
         */
        switch (choice) {
            case 1:
                System.out.print("Enter a positive number: ");
                int num = scanner.nextInt();
                int revNum = reverse_num(num);
                System.out.println("The reverse of " + num + " is " + revNum);
                break;
            case 2:
                System.out.print("Enter three positive numbers: ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();
                int largestNum = largest3Num(num1, num2, num3);
                System.out.println("The largest number is " + largestNum);
                break;
            case 3:
                System.out.print("Enter a positive number: ");
                int squareInt = scanner.nextInt();
                perfect_square_check(squareInt);
                break;
            case 4:
                System.out.print("Enter a positive number: ");
                int primeInt = scanner.nextInt();
                prime_test(primeInt);
                break;
            default:
                System.out.println("Error: Invalid choice.");
        }
    }
    public static int reverse_num(int num) {
        /*
         * Returns the reverse of a given number.
         */
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }
    public static int largest3Num(int num1, int num2, int num3) {
        /*
         * Returns the largest of three given numbers.
         */
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void perfect_square_check(int num) {
        /*
         * Checks if a given number is a perfect square or not.
         */
        if (num < 0) {
            System.out.println("Error: The number cannot be negative.");
            return;
        }
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
    }
    public static void prime_test(int num) {
        /*
         * Checks if a given number is a prime number or not.
         */
        if (num < 2) {
            System.out.println("Error: The number should be greater than or equal to 2.");
            return;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(num + " is not a prime number.");
                return;
            }
        }
        System.out.println(num + " is a prime number.");
    }
}