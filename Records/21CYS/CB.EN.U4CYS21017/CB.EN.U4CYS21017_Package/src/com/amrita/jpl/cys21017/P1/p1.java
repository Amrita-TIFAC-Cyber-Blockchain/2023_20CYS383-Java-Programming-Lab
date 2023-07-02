package com.amrita.jpl.cys21017.P1;

import java.util.Scanner;

public class p1 {

    /**
    * created fact method
    */
    public void fact(){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial: ");
        int num1 = input1.nextInt();

        int i, fact = 1;
        if(num1 < 0){
            System.out.print("Factorial can't be calculated for negative indices!");
        }
        else{
            for( i = 1; i <= num1; i++){
                fact = fact * i;
            }
        }
        System.out.print("Factorial of the number " + num1 + " is " + fact);

    }

    /**
     *created fibo method
     */

    public void fibo(){
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter a number to calculate fibonacci: ");
        int num2 = input2.nextInt();

        int i, fib = 0 , a = 0, b = 1;
        int c = a + b;
        if(num2 < 0){
            System.out.print("Fibonacci can't be calculated for negative indices!");
        } else{
            System.out.print("Fibonacci series: 0");
            for(i = 0; i < num2; i++){
                System.out.print(" "+c);
                a = b;
                b = c;
                c = a + b;
            }
        }
    }

    /**
     *created sum of n numbers method
     */

    public void sum_n_no(){
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter a number to calculate sum of N numbers: ");
        int num3 = input3.nextInt();
        if( num3 < 0){
            System.out.println("Enter a number greater than 0!");
        } else {
            int i, sum = 0;
            for( i = 0; i <= num3; i++){
                sum += i;
            }
            System.out.print("Sum of N natural numbers till " + num3 + " is " + sum);
        }
    }

    //created prime test method
    public void prime_test(){
        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter a number to check prime condition: ");
        int num4 = input4.nextInt();
        if( num4 < 0){
            System.out.println("Enter a number greater than 0!");
        } else {
            int i, res, flag = 1;
            for( i = 2; i < (num4/2); i++ ){
                if( num4 % i == 0 ){
                    flag = 0;
                }
            }

            if(flag == 0){
                System.out.println("It's a Composite Number");
            } else {
                System.out.println("It's a Prime Number");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------MENU----------");
        System.out.println("1.Factorial");
        System.out.println("2.Fibonacci");
        System.out.println("3.Sum of N numbers");
        System.out.println("4.Prime Test");
        System.out.println("------------------------");
        System.out.print("Enter a number: ");
        int choice = input.nextInt();
        p1 obj = new p1(); //Object created
        switch (choice){
            case 1:
                obj.fact(); //Fact method called
                break;
            case 2:
                obj.fibo(); //Fibo method called
                break;
            case 3:
                obj.sum_n_no(); //Sum method called
                break;
            case 4:
                obj.prime_test(); //Prime method called
                break;
            default:
                System.out.println("Enter a valid choice");
        }
    }
}
