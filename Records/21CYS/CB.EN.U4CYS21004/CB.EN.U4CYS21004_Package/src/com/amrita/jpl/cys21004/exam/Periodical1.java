package com.amrita.jpl.cys21004.exam;

import java.util.Scanner;

/**
 * @author Aishwarya GS
 */

public class Periodical1 {

    /**
     * Menu selection
     * @param args default argument
     */
    public static void main(String[] args) {
        System.out.println("Enter choice (1 to 4): ");
        Scanner sn = new Scanner(System.in);
        char ch = sn.next().charAt(0);

        switch (ch) {
            case '1':
                System.out.println("Factorial");
                int i,f=1;
                int n;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter number: ");
                n = sc.nextInt();
                for(i=1;i<=n;i++){
                    f=f*i;
                }
                System.out.println("Factorial of "+n+" is: "+f);
                break;
            case '2':
                System.out.println("Fibonacci");
                int num1=0,num2=1,num3,l, c;
                Scanner sa = new Scanner(System.in);
                System.out.println("Enter number: ");
                c = sa.nextInt();
                System.out.print(num1+" "+num2);
                for(l=2;l<c;++l){
                    num3=num1+num2;
                    System.out.print(" "+num3);
                    num1=num2;
                    num2=num3;
                }
                break;
            case '3':
                System.out.println("Sum of numbers");
                int j, s = 0;
                int num;
                Scanner sm = new Scanner(System.in);
                System.out.println("Enter number: ");
                num = sm.nextInt();
                for(j=1;j<=num;j++){
                    s=s+j;
                }
                System.out.println("Sum: "+s);
                break;
            case '4':
                System.out.println("Prime check");
                int k,m=0,flag=0;
                int n1;
                Scanner sr = new Scanner(System.in);
                System.out.println("Enter number: ");
                n1 = sr.nextInt();
                m=n1/2;
                if(n1==0||n1==1){
                    System.out.println(n1+" is not prime number");
                }
                else{
                    for(k=2;k<=m;k++){
                        if(n1%k==0){
                            System.out.println(n1+" is not prime number");
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0){
                        System.out.println(n1+" is prime number");
                    }
                }
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}