/**
 @author Manomithran
 @version 1.0
 @since 2023-04-24
 */
package com.amrita.jpl.cys21040.p1;
import java.util.Scanner;
 /**
  *The Periodical1 class contains methods for finding factorial of a number,
  *generating fibonacci numbers, finding sum of numbers and checking if a number is prime or not.
  *It also contains a main function where the user is prompted to enter a choice and based on the choice selected.*/
public class Periodical1 {

    static Scanner sc= new Scanner(System.in);
    /**
     * This method is used to find factorial
     * of a number n
     * @return int This returns sum of numA and numB.
     */
    public int fact(){
        System.out.println("Enter the number whose factorial you want to find : ");
        int a=sc.nextInt();
        int c=1;
        for(int i=1;i<=a;i++){
            c=c*i;
        }
       return c;
    }
    /**
     * This method is used to print
     * n fibonacci numbers
     */
    public void fibo(){
        System.out.println("Enter n to print n fibonacci numbers ");
        int n = sc.nextInt();
        int c=0,b=1,a,i;
        System.out.print(c+" "+b);

        for(i=2;i<n;++i)
        {
            a=c+b;
            System.out.print(" "+a);
            c=b;
            b=a;
        }
    }
    /**
     * This method is used to print
     * sum of n numbers
     * @return int The sum of n numbers
     */
    public int sum_n_no(){
        System.out.println("Enter 'n' to find the sum of N numbers : ");
        int b=sc.nextInt();
        int c=0;
        for(int i=0;i<=b;i++){
                c=c+i;
        }
        return c;
    }
    /**
     * This method is used to find if
     * a number n is prime or composite.
     * @return int Flag c which shows if n is prime or composite
     */
    public int prime_test(){
        int c=0;
        System.out.println("Enter the number to check if it is prime or not : ");
        int b=sc.nextInt();
        if(b==1){
            System.out.println("Neither prime nor composite");
        }
        else{
        for(int i=2;i<b;i++){
                if(b%i==0){
                    c=c+1;
                    break;
                }
        }
    }
        return c;
    }
    /**
     * The main function where all the
     * functions are called according to the
     * user's choice
     */
    public static void main(String args[]){
        Periodical1 A = new Periodical1();
        int i=1;
        while(i!=0){
        System.out.println(" **** ENTER YOUR CHOICE **** ");
        System.out.println(" 1. Factorial of a number");
        System.out.println(" 2. Generating fibonacci numbers ");
        System.out.println(" 3. Finding sum of numbers ");
        System.out.println(" 4. To check if a number is prime or not ");
        System.out.println(" 5. Exit ");
        int choice= sc.nextInt();
        if(choice==1){
            System.out.println("The factorial of the number is " + A.fact());
        }
        else if(choice == 2){
            A.fibo();
        }
        else if(choice==3){
            System.out.println("The sum of numbers is " + A.sum_n_no());
        }
        else if(choice==4){
            if(A.prime_test()==0){
                System.out.println(" The nunber is a prime ");
            }
            else{
                System.out.println(" The number is composite ");
            }
        }
        else if(choice == 5){
            i=i-1;
        }
        else{
            System.out.println("Invalid Choice, try again");
        }
    }
    }
}
