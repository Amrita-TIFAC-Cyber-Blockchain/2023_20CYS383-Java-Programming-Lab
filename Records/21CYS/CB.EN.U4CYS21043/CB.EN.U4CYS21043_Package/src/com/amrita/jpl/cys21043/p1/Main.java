package com.amrita.jpl.cys21043.p1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose An Correct Option:");
            System.out.println("1. Reverse of a Number");
            System.out.println("2. Largest of Three Numbers");
            System.out.println("3. Perfect Square");
            System.out.println("4. Prime Test");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice (1-5): ");

            choice = input.nextInt();

            switch (choice) {
                case 1 -> reverseNum();
                case 2 -> large3Num();
                case 3 -> perfectSquareCheck();
                case 4 -> primeTest();
                case 5 -> System.out.println("Exit Program");
                default -> System.out.println("Invalid Choice.Give Correct Number Between 1-5");
            }

        } while (choice !=5);
    }
    /**
     * Reverses a given number.
     */
    public static void reverseNum() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        System.out.println("Reverse of the number: " + reversedNumber);
    }
    /**
     * Finds the largest of three numbers.
     */
    public static void large3Num() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        int largest = num1;
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }

        System.out.println("Largest of the three numbers: " + largest);
    }
    /**
     * Checks if a given number is a perfect square.
     */
    public static void perfectSquareCheck() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int sqrt = (int) Math.sqrt(number);
        if (sqrt * sqrt == number) {
            System.out.println(number + " is a perfect square.");
        } else {
            System.out.println(number + " is not a perfect square.");
        }
    }
    /**
     * Checks if a given number is prime.
     */
    public static void primeTest() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        boolean isPrime = true;
        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is prime");
        } else {
            System.out.println(number + " is not prime");
        }
    }

}

