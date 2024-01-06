package com.amrita.jpl.cys21017.pract.misc;

import java.util.Scanner;

/**
 * calculator class defined
 */
public class calculator {

    //add function created
    static void add(){
        Scanner input = new Scanner(System.in);
        int num1, num2, ans;
        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();
        ans = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + ans);
    }

    //subraction function created
    static void sub(){
        Scanner input = new Scanner(System.in);
        int num1, num2, ans;
        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();
        ans = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + ans);
    }

    //multiplication function created
    static void mul(){
        Scanner input = new Scanner(System.in);
        int num1, num2, ans;
        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();
        ans = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + ans);
    }

    //division function created
    static void div(){
        Scanner input = new Scanner(System.in);
        float num1, num2, ans;
        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();
        if( num2 != 0){
            ans = num1 / num2;
            System.out.println(num1 + " / " + num2 + " = " + ans);
        }
        else{
            System.out.println("The denominator cannot be zero!");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Menu Driven Functions");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Division");
        System.out.println("5.Exit");

        int choice;

        do {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice){

                case 1:
                    add();
                    break;
                case 2:
                    sub();
                    break;
                case 3:
                    mul();
                    break;
                case 4:
                    div();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter a valid choice!");
            }
        }while(choice != 5);
    }
}
