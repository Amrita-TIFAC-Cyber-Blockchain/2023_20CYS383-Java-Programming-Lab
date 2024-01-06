package com.amrita.jpl.cys21073.p1;


import java.util.Scanner;

public class p1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.print("Enter your choice (1.(reverse_num), 2.\n" +
                "(largest3num), 3.(perfect_square_check), 4.(prime_test)): ");
        choice = input.nextInt();

        if(choice == 1) {
            reverse_num();
        }
        else if (choice == 2){
            largest3num();
        }
        else if (choice == 3){
            perfect_square_check();
        }
        else if (choice == 4){
            prime_test();
        }
        else{
            System.out.println("Enter a Valid Choice");
        }
    }

    public static void reverse_num() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Error: Number must be positive!");
            return;
        }

        int reversedNum = 0;
        while (num != 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }

        System.out.println("The reversed number is: " + reversedNum);
    }
    public static void largest3num() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int largestNum = num1;

        if (num2 > largestNum) {
            largestNum = num2;
        }

        if (num3 > largestNum) {
            largestNum = num3;
        }

        System.out.println("The largest number is: " + largestNum);
    }

    public static void perfect_square_check() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

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

    public static void prime_test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

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
