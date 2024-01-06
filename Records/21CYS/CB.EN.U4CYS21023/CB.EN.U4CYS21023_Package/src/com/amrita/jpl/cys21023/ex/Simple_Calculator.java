package com.amrita.jpl.cys21023.ex;

import java.util.Scanner;

public class Simple_Calculator {



        public static void main() {
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the first number : ");
            int a = input.nextInt();
            System.out.print("Enter the Second number : ");
            int b = input.nextInt();
            Scanner string_input = new Scanner(System.in);
            System.out.print("Enter the operator : ");
            switch (string_input.nextLine()) {
                case "+":
                    int c = a + b;
                    System.out.println("Addition value is : " + c + ".");
                    break;
                case "-":
                    int d = a - b;
                    System.out.println("Subtraction value is : " + d + ".");
                    break;
                case "*":
                    int e = a * b;
                    System.out.println("Multiplication value is : " + e + ".");
                case "/":
                    int f = a / b;
                    System.out.println("Division value is : " + f + ".");
            }

        }


}
