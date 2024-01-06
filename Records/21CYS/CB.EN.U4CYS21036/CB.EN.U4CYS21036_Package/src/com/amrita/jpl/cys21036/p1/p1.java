package com.amrita.jpl.cys21036.p1;


import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;


        System.out.print("Enter a number: ");
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
            System.exit(0);
        }


        System.out.println("Choose an operation:");
        System.out.println("1. Reverse of a number (reverse num)");
        System.out.println("2. Largest of three numbers (large3num)");
        System.out.println("3. Perfect Square (perfect square check)");
        System.out.println("4. Prime Test (prime test)");


        switch (choice) {
            case 1:
                reverseNum();
                break;
            case 2:
                largest3Num();
                break;
            case 3:
                perfectSquareCheck();
                break;
            case 4:
                primeTest();
                break;
            default:
                System.out.println("Invalid choice! Please choose a valid option.");
        }

        sc.close();
    }


    public static int reverseNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return 0;
        }

        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        System.out.println("Reversed number: " + reversedNum);
        return reversedNum;
    }


    public static int largest3Num() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = 0, num2 = 0, num3 = 0;
        try {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            num3 = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter three valid numbers.");
            return 0;
        }

        int largestNum = num1;
        if (num2 > largestNum) {
            largestNum = num2;
        }
        if (num3 > largestNum) {
            largestNum = num3;
        }

        System.out.println("Largest number: " + largestNum);
        return largestNum;
    }


    public static void perfectSquareCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check if it's a perfect square: ");
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return;
        }

        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            System.out.println(num + " is a perfect square.");
        } else {

            System.out.println(num + " is not a perfect square.");
        }
    }


    public static void primeTest() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to test if it's prime: ");
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return;
        }
        if (num <= 1) {
            System.out.println(num + " is not a prime number.");
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}


