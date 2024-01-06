package com.amrita.jpl.cys21042.practice.assignments;

import java.util.Scanner;

/**
 * @Author : Mittul R
 * @Rollno : CB.EN.U4CYS21042
 */

public class Condition{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter your Roll Number : ");
        String rollno = scanner.nextLine();
        System.out.println("Your Name : " + name );
        System.out.println("Your Roll Number : " + rollno);
        int marks1,marks2;
            System.out.println("Enter the Marks for Subject 1 : ");
            marks1 = scanner.nextInt();
            System.out.println("Enter the Marks for Subject 2 : ");
            marks2 = scanner.nextInt();
        int avg;
        avg = marks1 + marks2;
        avg /= 2;
        if(avg>90) {
            System.out.println("Your Avg Score is : " + avg + "you have passed with distinction !");
        }
            else if(avg<89 && avg>70){
                System.out.println("Your Avg Score is : " + avg + "you have passed with First Class !");
            }
            else{
                if(avg<69 && avg>50){
                    System.out.println("Your Avg Score is : " + avg + "you have passed with Second Class !");
                }
                else {
                    System.out.println("Your Avg Score is : " + avg + "you have passed with Avg Score !");
                }
            }

        }
    }