package com.amrita.jpl.cys21003.pract.basics;

import java.util.Scanner;
/**
 * Program that says a number is palindrome or not
 *
 * @author Aishwarya G
 * @version 1.0
 */

public class Palindrome{
    public static void main(String args[]){
        int r,sum=0,temp;
        Scanner input = new Scanner(System.in); //It is the number variable to be checked for palindrome
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
        }
        if(temp==sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }
}