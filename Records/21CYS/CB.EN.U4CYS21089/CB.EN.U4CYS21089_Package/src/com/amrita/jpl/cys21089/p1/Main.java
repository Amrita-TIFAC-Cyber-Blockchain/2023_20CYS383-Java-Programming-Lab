package com.amrita.jpl.cys21089.p1;
import java.util.Scanner;

/**
 * @author Yaswanth
 */
public class Main {
    static int choice, value, return_value;
    /**
     * factorial function
     */
    public int fact(int a){
        if(a < 0){
            System.out.println("Don't use negatives.");
            return 0;
        }
        else if(a == 0){
            return 1;
        }
        int factorial=1;
        while(a!=1){
            factorial = factorial*(a);
            a = a-1;
        }
        return factorial;
    }

    /**
     * Fibonacci function
     */
    public void fibo(int a){
        int a0 = 0, a1 = 1;
        System.out.println("The Fibinocci series: ");
        System.out.println(a0 + " ");
        for(int i=1;i<a;i++){
            System.out.println(a1 + " ");
            a1 = a0 + a1;
            a0 = a1;
        }
    }

    /**
     * Sum of 1st 'n' natural numbers function
     */
    public int sum_n_no(int a){
        return (a * (a + 1)) / 2;
    }

    /**
     * Prime Test function
     */
    public int prime_test(int a){
        if(a <= 0) {
            return 2;
        }
        else{

            for(int i=2;i<=a/2;i++){
                if(a%i == 0){
                    return 0;
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) {
        Main myObj = new Main();
        Scanner Obj = new Scanner(System.in);
        System.out.println("""
                1 -> Factorial
                2 -> Prime Test
                3 -> Fibinocci series
                4 -> Sum of "n" number

                """);
        System.out.println("Enter the choice: ");
        choice = Obj.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the number: ");
                value = Obj.nextInt();
                return_value = myObj.fact(value);
                if (return_value != 0) {
                    System.out.println("The factorial of " + value + " is " + return_value + ".");
                }
            }
            case 2 -> {
                System.out.println("Enter the number: ");
                value = Obj.nextInt();
                return_value = myObj.prime_test(value);
                if (return_value == 1) {
                    System.out.println("The number " + value + " is Prime.");
                } else if (return_value == 0) {
                    System.out.println("The number " + value + " is not Prime.");
                } else {
                    System.out.println("Don't use negatives or zero.");
                }
            }
            case 3 -> {
                System.out.println("Enter the length os series: ");
                value = Obj.nextInt();
                myObj.fibo(value);
            }
            case 4 -> {
                System.out.println("Enter the number: ");
                value = Obj.nextInt();
                return_value = myObj.sum_n_no(value);
                System.out.println("Sum of first " + value + " natural numbers is " + return_value + ".");
            }
            default -> System.out.println("Invalid Option. Choose carefully.");
        }
    }
}