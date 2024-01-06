package com.amrita.jpl.cys21016.p1;
import java.util.*;
/**
 * P1 exam Date: 02-05-2023
 * @author Hem Sagar
 * @version 1.0
 * */
public class Cbenu4cys21016P1exam {
    public static int reverse_num(int number){
        /** A function to reverse the given number. It returns the reverse of the number.
         * @param number Number passed from the main function(User input)
         * */
        int reverse=0;
        while(number>0){
            reverse = (reverse*10) + number%10;
            number = number/10;
        }
        return reverse;
    }
    public static int large3num(int a,int b,int c){
        /** A function to find the largest of the three numbers. It returns the largest number.
         * @param a The first number
         * @param b The second number
         * @param c The third number
         * */
        return (a>b?(a>c?a:c):(b>c)?b:c);
    }
    public static void perfect_square_check(int number){
        /**
         * A function to check whether the number is perfect square or not. It prints the result.
         *  @param number Number passed from the main function(User input)
         */
        int product,i;
        for(i=1;i<=number/2;i++){
            product = i*i;
            if(product == number) {
                System.out.println("The number " + number + " is a perfect square");
                return;
            }
        }
        if(i==number/2){
            System.out.println("The number "+number+" is not a perfect square");
        }
    }
    public static void prime_test(int number){
        /** A function to check whether the number is prime or not. It prints the result.
         * @param number Number passed from the main function(User input)
         * */
        int i;
        for(i=2;i<number;i++){
            if(number%i==0) {
                System.out.println("The number " + number + " is not a prime.");
                return;
            }
        }
        if(i==number){
            System.out.println("The number "+number+" is a prime.");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice=0,number;
        while(choice!=5){
            System.out.println("\n1. Reverse of a number\n2. Largest of three numbers\n3. Perfect square check\n4. Primality test\n5. Exit");
            System.out.print("Enter the choice: ");
            choice=input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the number: ");
                    number = input.nextInt();
                    if(number<0)System.out.println("Enter a non-negative number.");
                    else System.out.println("The reverse of number "+number+" is "+reverse_num(number));
                    break;
                case 2:
                    System.out.print("Enter the 3 numbers: ");
                    int a = input.nextInt();
                    int b = input.nextInt();
                    int c = input.nextInt();
                    System.out.println("The largest of numbers "+a+" "+b+" "+c+" is :"+large3num(a,b,c));
                    break;
                case 3:
                    System.out.print("Enter the number: ");
                    number = input.nextInt();
                    if(number<0)System.out.println("Enter a non-negative number.");
                    else perfect_square_check(number);
                    break;
                case 4:
                    System.out.print("Enter the number: ");
                    number = input.nextInt();
                    if(number<0)System.out.println("Enter a non-negative number.");
                    else prime_test(number);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid choice.");
            }

        }
    }
}