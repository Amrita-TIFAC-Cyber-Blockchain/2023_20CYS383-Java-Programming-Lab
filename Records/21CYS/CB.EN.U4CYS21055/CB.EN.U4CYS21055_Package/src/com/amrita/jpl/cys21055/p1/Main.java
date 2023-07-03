package com.amrita.jpl.cys21055.p1;
import java.util.Scanner;

/**
 * @author Penugonda V S Ganasekhar
 * @version 0.1
 */
class ReverseNumber {
    /**
     * This is the function which gives the Reverse of the number.
     * @return this function returns the reversed value.
     */
    public int rev() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        int number = in.nextInt();
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }
}

class largest{
    /**
     * This function is used to give the largest among the three nummbers given.
     * @return this returns the largest number among the given to the caller class.
     */
    public int lar(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the three numbers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        if (n1>n2 && n1>n3){
            return n1;
        }
        else if (n2>n1 && n2>n3){
            return n2;
        }
        else if (n3>n1 && n3>n2) {
            return n3;
        }
        return 0;
    }
}

class sqrcheck{
    /**
     * This function is used to check whether the number given is perfect square or not.
     */
    public void sqr(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int flag=0;
        int n1 = in.nextInt();
        for(int i=1; i<n1/2; i++){
            if (i*i==n1){
                System.out.println(n1+" is a perfect square");
                flag=flag+1;
            }
        }
        if(flag==0){
            System.out.println(n1+" is not a perfect square");
        }
    }
}

class primetest{
    /**
     * This function is used for checking whether given number is prime or not.
     */
    public void prime(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int flag=0;
        int n1 = in.nextInt();
        for(int i=1; i<n1/2; i++){
            if(n1%i==0){
                flag=flag+1;
            }
        }
        if(flag>1){
            System.out.println(n1+" is not a prime number");
        }
        else{
            System.out.println(n1+" is a prime number");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose the options:");
        System.out.println("1. Reverse of a number (reverse num)");
        System.out.println("2. Largest of three numbers (large3num)");
        System.out.println("3. Perfect Square (perfect square check)");
        System.out.println("4. Prime Test (prime test)");

        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a option: ");
        int choice = inp.nextInt();
        switch (choice) {
            case 1:
                ReverseNumber a = new ReverseNumber();
                int b = a.rev();
                System.out.println(b+" is the Reversed number");
                break;

            case 2:
                largest c = new largest();
                int d = c.lar();
                if (d==0){
                    System.out.println("Give different numbers");
                }
                else {
                    System.out.println(d + " is the Largest number among the given numbers");
                }
                break;

            case 3:
                sqrcheck e = new sqrcheck();
                e.sqr();
                break;

            case 4:
                primetest f = new primetest();
                f.prime();
                break;

            default:
                System.out.println("Enter a valid option");
        }
    }
}

