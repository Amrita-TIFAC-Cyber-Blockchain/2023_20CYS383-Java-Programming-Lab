package com.amrita.jpl.cys21027.p1;

import java.util.Scanner;

/**
 * @author K Sri Sai Nitin
 * @version 1.0
 *
 */

//Creation of A Class
public class P1 {

    /**
     * This is a function written to find the factorial of a number
     * @return statement returns the value of the factorial
     */
    static int fact() {
        /**
         * @param factorial - iteration for the factorial
         * @param num - the num the user finds factorial for
         */
        int num;
        int factorial = 1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number for factorial: ");
        num = input.nextInt();
        if (num < 0) {
            System.out.println("Only Positive Values Allowed!!!");
            return -1;
        } else{
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;

            }
        }
        return factorial;
    }

    /**
     * This function is used to determine the fibonacci series
     * @return statement returns the fibonacci values
     */

    static int fibo(){
        int n1=0,n2=1,n3 = 0,count;
        System.out.println("Enter value for count: ");
        Scanner inp = new Scanner(System.in);
        count = inp.nextInt();
        if(count<0){
            System.out.println("Enter positive value!!!");
            return -1;
        }
        System.out.println(n1);
        System.out.println(n2);
        for(int i=0;i<=count;i++) {
            n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
        return 0;
    }

    /**
     * This function is used to determine the sum of n numbers
     * @return statement returns sum of n numbers
     */
    static int sum_n_no(){
        /**
         * num enters the num of the values you want to add
         * sum returns the sum of all the n numbers
         */
        System.out.println("Enter the number until you want to add: ");
        Scanner no = new Scanner(System.in);
        int i, num, sum = 0;
        num = no.nextInt();
        if(num<0){
            System.out.println("Enter only Positive Values!!!");
            return -1;
        }
        for(i = 1; i <= num; ++i)
        {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * This function is used to check if a number is prime or not
     * @param num is used to enter the number for checking
     * @return statement returns the boolean value for prime or not
     */
    static boolean prime_test(int num){
        if (num <= 1)
            return false;
        for (int i = 2; i < num; i++)
            if (num % i == 0) {
                return false;
            }
        return true;
    }

    /**
     * Main Function
     * @param args Default argument to main function
     */
    public static void main(String[] args) {
        int choice;
        /**
         * choice is used to enter which function to be called.
         */
        Scanner init = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        choice = init.nextInt();
        if(choice==1){
            P1 obj = new P1();
            int res = obj.fact();
            System.out.println("The Value of Factorial is: "+res);
        }
        else if(choice==2){
            fibo();
        }
        else if(choice==3){
            P1 obj1 = new P1();
            int result = obj1.sum_n_no();
            System.out.println("The sum of n numbers is: "+result);
        }
        else if(choice==4) {
            int n;
            System.out.println("Enter the Number to check for prime: ");
            Scanner st = new Scanner(System.in);
            n = st.nextInt();
            if (prime_test(n)) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number");
            }
        }
        else{
            System.out.println("Incorrect Choice!!!Please Enter the correct choice!!!!");
        }
    }
}
