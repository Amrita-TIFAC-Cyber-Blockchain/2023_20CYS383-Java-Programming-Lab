package com.amrita.jpl.cys21019.p1;

/**
 * Author: C.D.Gokulachselvan
 */
import java.util.Scanner;

public class p1_missed {

    /**
     * This is main function.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Reverse of a number");
        System.out.println("2. Largest of three numbers");
        System.out.println("3. Perfect Square");
        System.out.println("4. Prime Test");
        System.out.print("Enter your choice : ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                reversenum();
                break;
            case 2:
                large3num();
                break;
            case 3:
                perfect_square_check();
                break;
            case 4:
                prime_test();
                break;
            default:
                System.out.println("Invalid choice only (1-4) is allowed.");
        }
    }

    /**
     * This function prints the reverse of the given number.
     */
    public static void reversenum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        System.out.println("Reverse of given number is : " + rev);
    }

    /**
     * This function prints the largest of three entered numbers.
     */
    public static void large3num() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int largest = n1;
        if (n2 > largest) {
            largest = n2;
        }
        if (n3 > largest) {
            largest = n3;
        }

        System.out.println("Largest of entered three numbers is : " + largest);
    }


    /**
     * This function checks if the input is a perfect square or not.
     */
    public static void perfect_square_check() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number you need to check : ");
        int num = scanner.nextInt();
        if (num < 0) {
            System.out.println("ERROR: Number must be non-negative.");
            return;
        }
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
    }

    /**
     * This function checks if the input is prime or not.
     */
    public static void prime_test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number you need to check : ");
        int num = scanner.nextInt();

        if (num < 2) {
            System.out.println(num + " is not a prime number.");
            return;
        }

        boolean prime = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

    }
}