package com.amrita.jpl.cys21050.P1;
import java.util.*;
/**
 * @author nishanth
 */

    public class P1 {
        int reverse_num(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number to be reversed: ");
            int num=sc.nextInt();
            if(num<0){
                return 0;
            }
            int revnum=0;
            int r=0;
            while(num>0){
                r=num%10;
                num=num/10;
                revnum=revnum*10+r;
            }
            return revnum;
        }

        int large3num(){
            int largest=0;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 3 numbers");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a>=b){
                if(a>=c){
                    largest=a;
                }
                else{
                    largest=c;
                }
            }
            else{
                if(b>=c){
                    largest=b;
                }
                else {
                    largest = c;
                }
            }
            return largest;
        }

        void perfect_square_check(){
            System.out.print("Enter a number: ");
            Scanner sc=new Scanner(System.in);
            double num= sc.nextInt();
            if(Math.sqrt(num)==Math.floor(Math.sqrt(num))){
                System.out.println("The given number is a perfect square");
            }
            else{
                System.out.println("The given number is not a perfect square");
            }
        }

        void prime_test(){
            System.out.print("Enter a number: ");
            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();
            int flag=0;
            for(int i=2;i<num;i++){
                if(num%i==0){
                    flag++;
                }
            }
            if(flag==0){
                System.out.println("The given number is a prime number");
            }
            else{
                System.out.println("The given number is a composite number");
            }
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Select a Choice:");
            System.out.println("1. Reverse of a number");
            System.out.println("2. Largest of three numbers");
            System.out.println("3. Perfect square");
            System.out.println("4. Prime test");
            System.out.print("Enter Choice: ");
            int choice=sc.nextInt();
            P1 obj=new P1();
            if(choice==1){
                int reverse=obj.reverse_num();
                if(reverse==0){
                    System.out.println("Give an positive integer as input");
                }
                else{
                    System.out.println("Reverse of the given number is: "+reverse);
                }
            }
            else if(choice==2){
                int largest=obj.large3num();
                System.out.println("Largest of 3 numbers is: "+largest);
            }
            else if(choice==3){
                obj.perfect_square_check();
            }
            else if(choice==4){
                obj.prime_test();
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }



