package com.amrita.jpl.cys21031.p1;

import java.util.Scanner;

/**
 * @author Kishanth K
 * @version 0.5
 */
public class periodical1 {
    public void reverse_num()
    {

        int n, reverse = 0;

        System.out.println("Enter an integer to reverse");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        while(n != 0)
        {
            reverse = reverse * 10;
            reverse = reverse + n%10;
            n = n/10;
        }
        System.out.println("Reverse of the number is " + reverse);

    }
    public void large3num() {
        int x, y, z;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number:");
        x = s.nextInt();
        System.out.print("Enter the second number:");
        y = s.nextInt();
        System.out.print("Enter the third number:");
        z = s.nextInt();
        if(x > y && x > z)
        {
            System.out.println("Largest number is:"+x);
        }
        else if(y > z)
        {
            System.out.println("Largest number is:"+y);
        }
        else
        {
            System.out.println("Largest number is:"+z);
        }

    }

    public static void perfect_square_check() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Error: Number must be positive!");
            return;
        }

        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
    }

    public void prime_test() {
        int num, i, count=0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        num = s.nextInt();
        for(i=2; i<num; i++)
        {
            if(num%i == 0)
            {
                count++;
                break;
            }
        }
        if(count==0)
            System.out.println("\nIt is a Prime Number.");
        else
            System.out.println("\nIt is not a Prime Number.");
    }
    public static void main(String[] args) {
        periodical1 myClass = new periodical1();
        Scanner input = new Scanner(System.in);
        System.out.println("enter choice: ");
        int choice = input.nextInt();

        switch (choice) {

            case 1:
                if (choice == 1 ){
                    myClass.reverse_num();}
                break;
            case 2:
                if(choice == 2 ){
                    myClass.large3num();}
                break;
            case 3:
                if(choice == 3){
                    myClass.perfect_square_check();}
                break;
            case 4:
                if (choice == 4){
                    myClass.prime_test();}
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

}

