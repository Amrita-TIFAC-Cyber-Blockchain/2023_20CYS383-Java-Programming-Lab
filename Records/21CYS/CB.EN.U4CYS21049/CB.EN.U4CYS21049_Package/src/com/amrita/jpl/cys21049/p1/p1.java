/**
 * @author Nishant V
 * @param - n,reverse,num
 */


package com.amrita.jpl.cys21049.p1;
import java.util.Scanner;

public class p1 {

    Scanner num = new Scanner(System.in);
    public int reverse_num(){
        System.out.println("Enter the number that needed to be reversed: ");
        int n = num.nextInt();
        int reverse = 0;
        while (n != 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        return reverse;
    }

    public int large3num(){
        System.out.println("Enter the 1st number");
        int a = num.nextInt();
        System.out.println("Enter the 2nd number");
        int b = num.nextInt();
        System.out.println("Enter the 3rd number");
        int c = num.nextInt();

        if(a > b && a > c){
            return a;
        }
        else if (b > c) {
            return b;
        }

        else {
            return c;
        }


    }

    public void perfect_square_check() {
        System.out.println("Enter the number to check it is a perfect square or not:");
        int n = num.nextInt();
        if (n < 0) {
            System.out.println("Invalid Number");
        } else {
            int res = (int) Math.sqrt(n);
            if (res * res == n) {
                System.out.println("It is a perfect square");
            } else {
                System.out.println("Its not a perfect square");
            }
        }
    }

    public void prime_test(){
        System.out.println("Enter the number to check if it is a prime or not");
        int n = num.nextInt();
        boolean prime = true;
        if(n <= 1){
            prime = false;
        }
        else {
            for (int i = 2 ; i <= Math.sqrt(n) ; i++){
                if(n % i == 0){
                    prime = false;
                }
            }
        }
        if(prime){
            System.out.println("It is a prime number");
        }
        else{
            System.out.println("It is not a prime number");
        }
    }
    public static void main(String[] args){
        p1 ok = new p1();
        Scanner num = new Scanner(System.in);
        System.out.println("Enter the number from 1-4");
        int choice = num.nextInt();
        switch (choice){
            case 1:
                System.out.println(ok.reverse_num());
                break;
            case 2:
                System.out.println(ok.large3num() + " is the largest number");
                break;
            case 3:
                ok.perfect_square_check();
                break;
            case 4:
                ok.prime_test();
                break;
            default:
                System.out.println("Enter a valid number!");
        }


    }
}
