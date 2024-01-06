package com.amrita.jpl.cys21014.p1;

import java.util.Scanner;

/**
 * @author Deepthi J, CB.EN.U4CYS21014
 */
class Main {
        int value;
        Scanner input1 = new Scanner(System.in);

    /**
     * fact function has return type int
     * @return type int
     */
    public int fact(){

        System.out.println("Enter the value: ");
        value = input1.nextInt();
        int factorial=1, i;
        if(value<0) return 0;
        else{
            for(i=1;i<=value;i++) factorial = factorial*(i);

        }
        return factorial;
    }

    /**
     * fibo function has return type void
     */
    public void fibo(){
        System.out.println("Enter no. of terms to be printed from the Fibonacci Series: ");
        System.out.println("Required Fibonacci Series: ");
        value = input1.nextInt();
        int f0=0, f1=1, f2, i;
        if(value<=0) System.out.println("No. of terms should be a whole number between 1-100.");
        else{
            System.out.println(f0+"\t");
            System.out.println(f1+"\t");
            for(i=3;i<=value;i++) {
                f2=f0+f1;
                System.out.println(f2+"\t");
                f0=f1;
                f1=f2;
        }

        }
    }

    /**
     * sum_n_no function has return type int
     * @return type int
     */
    public int sum_n_no() {
        System.out.println("Enter value of n: ");
        value = input1.nextInt();
        int sum=0, i;
        if(value<0) return -1;
        else{
            for(i=1;i<=value;i++) sum=sum+i;
        }
        return sum;
    }

    /**
     * prime_test function has return type int
     * @return type int
     */
    public int prime_test() {
        System.out.println("Enter the value: ");
        value = input1.nextInt();
        int i=1, count=0;
        if(value<0) return -1;
        if(value==0 || value==1) return 2;
        else {
            while (i <= value) {
                if (value % i == 0) {
                    count++;
                }
                i++;
            }
            if (count == 2) return 1;
            else return 0;

        }
       // return 0;
    }

    /**
     * com.amrita.jpl.fourteen.p1.com.amrita.jpl.fourteen.p1.Main function is a menu-driven program
     * @param args Default
     */
    public static void  main(String[] args) {
        int return_value;
        Scanner input = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("Enter your choice: \n'1' Factorial\n'2' Fibonacci\n'3' Sum of n numbers\n'4' Prime test\n");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                return_value = obj.fact();
                if (return_value==0) System.out.println("Please enter a positive value.\n");
                else System.out.println("Factorial = " + return_value);

            }
            case 2 -> obj.fibo();
            case 3 -> {
                return_value = obj.sum_n_no();
                if(return_value==-1) System.out.println("Value should be a positive integer.");
                else System.out.println("Sum = " + return_value);
            }
            case 4 -> {
                return_value = obj.prime_test();
                if(return_value==-1) System.out.println("Please enter a positive value.\n");
                if(return_value==0) System.out.println("Not a Prime Number.\n");
                if (return_value==1) System.out.println("Prime Number.\n");
                if (return_value==2)System.out.println("0 and 1 is neither prime nor composite.\n");

            }
            default -> System.out.println("Invalid choice. Try again.");
        }

    }
}