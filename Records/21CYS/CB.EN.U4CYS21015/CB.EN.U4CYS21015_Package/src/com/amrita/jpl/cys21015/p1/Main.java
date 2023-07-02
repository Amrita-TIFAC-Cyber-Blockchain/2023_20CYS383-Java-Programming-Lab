package com.amrita.jpl.cys21015.p1;

import java.util.Scanner;

/**
 * @author Dyanesh S (CB.EN.U4CYS21015)
 * @version 1.0
 * @since 02-05-2023
 */
public class Main
{

    /**
     * This method is used to reverse a given number
     * This program takes mod 10 and adds to another variable and later divides the number by 10
     * @param n an integer, only one argument
     * @return rev - returns the reversed number
     */

    public int reverse_num(int n)
    {
        int tmp = n;
        int rev = 0;
        while(tmp > 0)
        {
            rev = rev*10 + tmp%10;
            tmp = tmp/10;
        }

        return rev;
    }

    /**
     * This method is used to find the largest of three numbers
     * It uses Math.max(a predefined function) twice to get the largest number
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return one of the given arguments
     */

    public int large3num(int a, int b, int c)
    {
        return Math.max(Math.max(a,b),c);
    }

    /**
     * Checks whether the given number is a prefect square or not
     * Uses Math.sqrt() to calculate the square root of the number and
     * Compares with the type casted value of the output to check whether the output is an integer or not
     * @param n an integer, only one argument
     */

    public void perfect_square_check(int n)
    {
        if (n <= 0)
            System.out.println("Enter a number greater than zero");
        else
        {
            if (Math.sqrt(n) == (int) Math.sqrt(n))
                System.out.println("The given number is a perfect square number");
            else
                System.out.println("The given number is not a perfect square number");
        }
    }

    /**
     * Checks whether the given number is prime or not
     * Iterates from 2 to sqrt(n) and if n modulus any number is zero then it is not prime, else it is a prime number
     * @param n an integer, only one argument
     */

    public void prime_test(int n)
    {
        if (n <= 0)
            System.out.println("Enter a number greater than 0");
        else if (n == 1)
            System.out.println("The number 1 is neither prime nor composite");
        else
        {
            for (int i = 2; i < (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println("The given number is not a prime number");
                    return;
                }
            }
            System.out.println("The given number is not a prime number");
        }
    }

    /**
     * This main method creates an object and calls all the above four methods
     * Designed as a menu-driven program
     * @param args Not used
     */

    public static void main(String[] args)
    {
        int choice = 1,num;
        Scanner scanner = new Scanner(System.in);
        Main obj = new Main();

        do
        {
            System.out.println("JPL Lab Evaluation Program");
            System.out.println("1. Reverse of a number\n2. Largest of three numbers\n3. Perfect Square\n4. Prime Test\n");
            System.out.print("Enter a number between 1 and 4 ");
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter a number to reverse: ");
                    num = scanner.nextInt();
                    System.out.println("Reverse of the given number is " + obj.reverse_num(num));
                    break;
                case 2:
                    System.out.print("Enter the three numbers: ");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int c = scanner.nextInt();
                    System.out.println("The largest of the three numbers is " + obj.large3num(a,b,c));
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    num = scanner.nextInt();
                    obj.perfect_square_check(num);
                    break;
                case 4:
                    System.out.println("Enter a number: ");
                    num = scanner.nextInt();
                    obj.prime_test(num);
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        }while(1 <= choice && choice <= 4);

    }
}
