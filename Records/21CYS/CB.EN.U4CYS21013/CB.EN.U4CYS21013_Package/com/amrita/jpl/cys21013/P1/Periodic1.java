package com.amrita.jpl.cys21013.P1;

import java.util.*;

/**
 * The following program is menu-driven.
 * It can do reversing a number, finding largest of three numbers, perfect square check, prime number test
 *
 * @author rohith
 * @version 1.0
 */
public class Periodic1 {

    /**
     *
     * @param args It takes the command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option from the following: ");
        System.out.println("1. Reverse a number");
        System.out.println("2. Largest of three numbers");
        System.out.println("3. Perfect Square Check");
        System.out.println("4. Prime Number Test");
        int choice=scanner.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter the number: ");
                int n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Invalid number.");
                    return;
                }
                int reverse = reverse_num(n);
                System.out.println("The reverse of " + n + " is: " + reverse);
                break;

            case 2:
                System.out.println("Enter the 1st number: ");
                int a = scanner.nextInt();
                System.out.println("Enter the 2nd number: ");
                int b = scanner.nextInt();
                System.out.println("Enter the 3rd number: ");
                int c = scanner.nextInt();
                int max=large3num(a,b,c);
                System.out.println("The largest of the three numbers  is: " + max);
                break;

            case 3:
                System.out.println("Enter the number: ");
                int num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("Invalid number.");
                    return;
                }
                perfect_square_check(num);
                break;

            case 4:
                System.out.println("Enter the number: ");
                int n1 = scanner.nextInt();
                if (n1 <= 0) {
                    System.out.println("Invalid number.");
                    return;
                }
                prime_test(n1);
                break;

            default:
                System.out.println("Please enter a number between 1 to 4.");
                break;
        }
    }

    /**
     *
     * @param n takes the number to be reversed
     * @return the reversed number
     */
    public static int reverse_num(int n){
        int rev=0;
        while(n>0)
        {
            rev=rev*10;
            rev=rev+n%10;
            n=n/10;
        }
        return rev;
    }

    /**
     * @param a the first number
     * @param b the second number
     * @param c the third number
     * @return the largest number of the three numbers that are passed as parameters.
     */
    public static int large3num(int a,int b,int c){
        int max;
        if(a>b){
            if(a>c){
                return a;
            }
            else{
                return c;
            }
        }
        else if (b>c) {
            return b;

        }
        else{
            return c;
        }

    }

    /**
     *
     * @param n The number that is being checked whether it is a perfect square or not.
     */
    public static void perfect_square_check(int n){
        int i,flag=0;
        if(n==1)
        {
            flag=1;
        }
        for(i=0;i<=n/2;i++)
        {
            if(i*i==n)
            {
                flag=1;
            }
        }
        if(flag==1) {
            System.out.println( n + " is a perfect square number.");
        }
        else {
            System.out.println( n + " is not a perfect square number.");
        }
    }

    /**
     *
     * @param n The number that is being checked whether it is a prime or not.
     */
    public static void prime_test(int n){
        int i,flag=0;
        if(n==1)
        {
            System.out.println( n + " is not a prime number.");
            return;
        }
        else if (n==2) {
            System.out.println( n + " is a prime number.");
            return;
        }
        for(i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                System.out.println( n + " is not a prime number.");
                return;
            }
        }
        System.out.println( n + " is a prime number.");
        return;
    }
}