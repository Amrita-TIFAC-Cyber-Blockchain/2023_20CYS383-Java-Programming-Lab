package com.amrita.jpl.cys21030.practice;


import java.util.Scanner;
        public class simple_calculator {
            public static void main(String[] args) {



                System.out.println("\n");
                Scanner scanner = new Scanner(System.in);



                System.out.print("Enter the first number(X): ");
                int X = scanner.nextInt();
                System.out.print("Enter the second number(Y): ");
                int Y = scanner.nextInt();

                System.out.print("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n\n");

                System.out.print("Enter a valid choice: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    int addition = X + Y;
                    System.out.println(addition);
                }
                if (option == 2) {
                    int subtraction = X -Y;
                    System.out.println(subtraction);
                }
                if (option == 3) {
                    int multiply = X * Y;
                    System.out.println(multiply);
                }
                if (option == 4) {
                    if (Y == 0) {
                        System.out.println("Infinity\n");
                    }
                    else {
                        int div = X / Y;
                        System.out.println(X + "/ " + Y + "=" + div);
                    }
                }
        }}
