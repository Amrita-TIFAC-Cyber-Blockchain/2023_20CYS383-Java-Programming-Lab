package com.amrita.jpl.cys21060.P1;

import java.util.Scanner;

public class P1_LE {

    public static int reverse_num(int n){
        int x,k=0;
        int i=0;
        int z = n;
        int count = 0;
        while(z>0){
            z = z/10;
            count++;
        }
        int m = 1;
        for(int j=1; j<count; j++){
            m = m*10;
        }
        while(n>0){
            x = n%10;
            n = n/10;
            k = k + m*x;
            m = m/10;
        }
        return k;
    }

    public static int large3num(int a, int b, int c){
        int[] arr = {a, b, c};
        int max = a;
        for(int i=0; i<3; i++){
            if(max<=arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void perfect_square_check(int n){
        int flag = 0;
        for(int i=0; i<n/2; i++){
            if(i*i==n){
                System.out.println("The number is a perfect square");
                flag = 1;
                break;
            }
        }
        if(flag==0){
            System.out.println("The number is not a perfect square");
        }
    }

    public static void prime_test(int n) {
        int flag = 0;
        for(int i=2; i<n; i++){
            if(n%i==0){
                flag = 1;
                break;
            }
        }
        if(flag==0){
            System.out.println("The number is prime");
        }
        else {
            System.out.println("The number is composite");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Reverse of a number\n2. Largest of three numbers\n3. Perfect Square\n4. Prime Test");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the number: ");
                int n = scanner.nextInt();
                int x = reverse_num(n);
                System.out.println("The reversed number is: "+x);
                break;
            case 2:
                System.out.println("Enter the 1st number: ");
                int a = scanner.nextInt();
                System.out.println("Enter the 2nd number: ");
                int b = scanner.nextInt();
                System.out.println("Enter the 3rd number: ");
                int c = scanner.nextInt();
                int y = large3num(a, b, c);
                System.out.println("The largest of three numbers is: "+y);
                break;
            case 3:
                System.out.println("Enter the number: ");
                int m = scanner.nextInt();
                if(m==0 || m==1){
                    System.out.println("The number is a perfect square");
                    break;
                }
                perfect_square_check(m);
                break;
            case 4:
                System.out.println("Enter the number: ");
                int o = scanner.nextInt();
                if(o==0){
                    System.out.println("The number is neither prime nor composite");
                    break;
                }
                prime_test(o);
                break;
            default:
                System.out.println("Enter a valid choice");
        }
    }
}