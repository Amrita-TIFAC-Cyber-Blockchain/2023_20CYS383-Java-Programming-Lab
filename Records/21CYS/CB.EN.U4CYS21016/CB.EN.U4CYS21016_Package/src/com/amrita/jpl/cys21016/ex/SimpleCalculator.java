package com.amrita.jpl.cys21016.ex;
import java.util.Scanner;

/**
 * Simple calculator program
 * @author G H Hem sagar
 * @version 1.0
 * */
public class SimpleCalculator {
    public static void main(String[] args) {
        /**
         * gets input from the user and performs the specified operation that user selects.
         * @param args -> commandline arguments
         * */
        Double num1,num2,result;
        char opr;
        System.out.println("Simple Calculator Program !\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1st number :");
        num1 = input.nextDouble();
        System.out.println("Enter 2nd number :");
        num2 = input.nextDouble();
        if(num1>=0 && num2>=0){
            System.out.println("Choose an operator: +, -, *, or /");
            opr = input.next().charAt(0);
            switch (opr) {
                case '+':
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case '/':
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                    break;

                default:
                    System.out.println("Invalid operator!");
                    break;
            }
            input.close();
        }
        else if(num1<0){
          System.out.println("Enter a positive value for num1.\n");
        }
        else if(num2<0){
            System.out.println("Enter a positive value for num2.\n");
        }
    }
}