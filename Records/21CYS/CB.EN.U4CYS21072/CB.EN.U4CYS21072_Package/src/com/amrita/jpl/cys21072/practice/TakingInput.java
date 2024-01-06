package com.amrita.jpl.cys21072.practice;
/**
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */
import java.util.Scanner;
public class TakingInput {
    public static void main(String[] args)
    {
        int num1,num2,sum;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        num1 =sc.nextInt();

        System.out.println("Enter Second Number: ");
        num2 =sc.nextInt();

        sc.close();
        sum=num1+num2;
        System.out.println("Sum of these numbers: "+sum);
    }
}