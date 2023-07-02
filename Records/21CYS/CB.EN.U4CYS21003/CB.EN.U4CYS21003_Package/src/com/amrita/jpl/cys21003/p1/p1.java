package com.amrita.jpl.cys21003.p1;

import java.util.Scanner;


    /**
     * This class demonstrates the periodical lab exam.
     *
     *
     * @author Aishwarya G
     * @version 1.0
     */



    public class p1 {
        /**
         * function to factorial of a number
         */
        public static void fact() {
            int i, fact = 1;
            Scanner input = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            int number = input.nextInt();
            for (i = 1; i <= number; i++) {
                fact = fact * i;
            }
            System.out.println("Factorial of " + number + " is: " + fact);
            input.close();
        }
        /**
         * function to fibonacci series
         */
        public void fibo() {
            int f1 = 0, f2 = 1, f3, i, count = 20;
            System.out.print(f1 + " " + f2);//printing 0 and 1

            for (i = 2; i < count; ++i)//loop starts from 2 because 0 and 1 are already printed
            {
                f3 = f1 + f2;
                System.out.print(" " + f3);
                f1 = f2;
                f2 = f3;
            }
        }
        /**
         * function to sum of n numbers
         */
        public void sum_n_no() {
            int i, sum = 0;
            Scanner input = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            int number = input.nextInt();
            for(i = 1; i <= number; ++i)
            {
                sum = sum + i;
            }
            System.out.println("Sum of n Natural Numbers is = " + sum);
        }
        /**
         * function to check prime and non prime numbers
         */
        public void prime_test() {
            int num, i, count=0;
            Scanner s = new Scanner(System.in);
            System.out.print("Enter a Number: ");
            num = s.nextInt();
            for(i=2; i<num; i++)
            {
                if(num%i == 0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
                System.out.println("\nIt is a Prime Number.");
            else
                System.out.println("\nIt is not a Prime Number.");
        }

        public static void main(String[] args) {
            p1 mycClass = new p1();
            Scanner input = new Scanner(System.in);
            System.out.println("enter choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    if (choice == 1 ){
                        fact();}
                    break;
                case 2:
                    if(choice == 2 ){
                        mycClass.fibo();}
                    break;
                case 3:
                    if(choice == 3){
                        mycClass.sum_n_no();}
                    break;
                case 4:
                    if (choice == 4){
                        mycClass.prime_test();}
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }

    }