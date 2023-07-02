package com.amrita.jpl.cys21010.practice.mathmatical;

import java.util.*;
public class calc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Calculator");
        System.out.println("Enter the First Number:-");
        float x = sc.nextInt();
        System.out.println("Enter the Second Number:-");
        float y = sc.nextInt();
        System.out.println("1.Add\n2.Subtract\n3.Multiply\n4.Divide");
        System.out.println("Enter your choose :-");
        int cho = sc.nextInt();

        if (cho == 1){
            System.out.println(x+y);
        }
        else if(cho == 2){
            System.out.println(x-y);
        }
        else if (cho == 3){
            System.out.println(x*y);
        }
        else  if (cho == 4){
            if (y == 0){
                System.out.println("Can not divide by 0!!");
            }
            else{
                System.out.println(x/y);
            }
        }
        else{
            System.out.println("Enter a valid choice");
        }

    }
}