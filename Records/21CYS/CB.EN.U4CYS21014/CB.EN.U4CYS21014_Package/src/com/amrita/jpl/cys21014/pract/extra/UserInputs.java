 package com.amrita.jpl.cys21014.pract.extra;
/**
 * @author Deepthi Jayanth
 */

import java.util.Scanner;
public class UserInputs
{
    public static void main(String args[])
    {
        int x, y, sum;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        x = sc.nextInt();
        System.out.print("Enter the second number: ");
        y = sc.nextInt();
        sum = sum(x, y);
        System.out.println("The sum of two numbers x and y is: " + sum);
    }
    //method that calculates the sum
    public static int sum(int a, int b)
    {
        int sum = a + b;
        return sum;
    }
}  