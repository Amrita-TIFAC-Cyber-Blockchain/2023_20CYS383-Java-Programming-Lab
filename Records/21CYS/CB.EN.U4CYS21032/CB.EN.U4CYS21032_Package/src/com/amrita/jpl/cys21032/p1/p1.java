package com.amrita.jpl.cys21032.p1;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Enter your choice:");
        System.out.println("1. To print reverse of a number (reverse num)");
        System.out.println("2. largest of three numbers (large3num)");
        System.out.println("3. Perfect Square (perfect square check)");
        System.out.println("4. Prime Test (prime test)");

        choice = scan.nextInt();

        if(choice == 1) {
            reverseNumber();
        }
        else if (choice == 2){
            largestOfThreeNumbers();
        }
        else if (choice == 3){
            perfectSquareCheck();
        }
        else if (choice == 4){
            primeTest();
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void reverseNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();

        if (num < 0) {
            System.out.println("Invalid entry!!");
            return;
        }

        int reversedNum=0;
        while (num != 0){
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }

        System.out.println("The reversed number is: " + reversedNum);
    }

    public static void largestOfThreeNumbers(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Number:");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();


        int largestnumber = num1;

        if (num2 > largestnumber) {
            largestnumber = num2;
        }

        if (num3 > largestnumber) {
            largestnumber = num3;
        }

        System.out.println("The largest number is: " + largestnumber);
    }

    public static void perfectSquareCheck() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();

        if (num < 0) {
            System.out.println("Error: Number must be positive!");
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();

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