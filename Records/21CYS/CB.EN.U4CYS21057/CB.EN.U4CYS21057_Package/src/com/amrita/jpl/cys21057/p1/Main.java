package com.amrita.jpl.cys21057.p1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Func call = new Func();

        int k =1;

        do{
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. Prime");
            System.out.println("4. Sum of natural numbers");
            System.out.println("5. Exit");

            Scanner obj = new Scanner(System.in);

            System.out.println("Enter your choice : ");
            int choice = obj.nextInt();

            switch (choice){
                case 1:
                    System.out.println("The factorial is : "+call.fact());
                    break;

                case 2:
                    call.fibo();
                    break;

                case 3:
                    int a = call.prime_test();
                    if(a == 0) {
                        System.out.println("It\'s prime");
                    }else {
                        System.out.println("Not a prime");
                    }
                    break;

                case 4 :
                    System.out.println("Sum of n numbers is : " + call.sum_n_no());
                    break;

                case 5:
                    k = 0;
                    break;

                default :
                    System.out.println("Wrong choice");
            }
        }while(k!=0);
    }
}
