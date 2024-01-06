package com.amrita.jpl.cys21042.practice.assignments;
import java.util.*;
/**
 * @Author Mittul R CB.EN.U4CYS21042
 */
public class Switchcase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Value of First Number ");
        int a=sc.nextInt();
        if(a>=0){
            System.out.print("Enter the Value of Second Number ");
            int b=sc.nextInt();
            if(b>=0){
                System.out.print("Enter the Operation to be Performed ");
                String c=sc.next();
                if(c.equals("+")){
                    int t=a+b;
                    System.out.println("Addition of Two Numbers is : "+t);
                }
                else if(c.equals("-")){
                    int t=a-b;
                    System.out.println("Subtraction of Two Numbers is : "+t);
                }
                else if(c.equals("*")){
                    int t=a*b;
                    System.out.println("Multiplication of Two Numbers is : "+t);
                }
                else if(c.equals("/")){
                    int t=a/b;
                    System.out.println("Division of Two Numbers is : "+t);
                }
                else{
                    System.out.println("Enter a Valid Operator !");
                }
            }else{
                System.out.println("Enter a Positive Integer ! ");
            }
        }else{
            System.out.println("Enter a Positive Integer ! ");
        }
    }
}
