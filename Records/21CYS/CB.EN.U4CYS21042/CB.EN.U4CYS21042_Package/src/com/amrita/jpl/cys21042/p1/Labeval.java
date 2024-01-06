package com.amrita.jpl.cys21042.p1;

import java.util.Scanner;

/**
 * @Author : Mittul R
 * CB.EN.U4CYS21042
 */
public class Labeval {
    public static int fact(int n) {
        if (n < 0) {
            System.out.println("Factorial for Negative Number Cannot be Found ");
            return -1;
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return n * fact(n-1); // Using Recursive Function
        }
    }
    public static void fibo(int count) {
        if (count <= 0) {
            System.out.println("Number of terms should be positive.");
            return;
        }
        int num1 = 0, num2 = 1, num3, i;
        System.out.print("The Fibonacci Series upto " + count + " terms is : " + num1 + " " + num2);
        for (i = 2; i < count; ++i)
        {
            num3 = num1 + num2;
            System.out.print(" " + num3);
            num1 = num2;
            num2 = num3;
        }
        System.out.println();
    }
    public static int sum_n_no(int n) {
        if (n <= 0) {
            System.out.println("Count of numbers should be positive.");
            return 0;
        }
        int sum = 0;
        int i;
        for (i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static int prime_test(int n)
    {
        if (n <= 1) {
            System.out.println("Prime Number for Negative Number cannot be Found ");
            return -1;
        }
        int i,count=0;
        for(i=2; i<n; i++)
        {
            if(n % i == 0)
            {
                count++;
                break;
            }
        }
        if(count==0) {
            System.out.println("Given Number is : " + n);
            System.out.println("\nIt is a Prime Number.");
        }
        else if (n > 0)
        {
            System.out.println("Prime Number for Negative Number cannot be found !");
        }
        else {
            System.out.println("Given Number is : " + n);
            System.out.println("\nIt is not a Prime Number.");
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("1.Factorial ");
        System.out.println("2.Fibonacci ");
        System.out.println("3.Sum of N numbers ");
        System.out.println("4.Prime Test ");
        System.out.println("Enter your Choice : ");
        choice= scanner.nextInt();

        if(choice == 1)
        {
            int n;
            System.out.print("Enter a number for Factorial: ");
            n = scanner.nextInt();
            System.out.println("Factorial of a Given Number " + n + " is : " + fact(n));
        } else if (choice == 2) {
            int count;
            System.out.print("Enter the No: of Terms for Fibonacci : ");
            count = scanner.nextInt();
            fibo(count);
        } else if (choice == 3) {
            int n;
            System.out.print("Enter the Number to Calculate Sum: ");
            n = scanner.nextInt();
            System.out.println("Sum of First " + n + " Numbers is : " + sum_n_no(n));
        }
        else{
            int n;
            System.out.print("Enter a Number to Check : ");
            n = scanner.nextInt();
            prime_test(n);
        }
    }
}
