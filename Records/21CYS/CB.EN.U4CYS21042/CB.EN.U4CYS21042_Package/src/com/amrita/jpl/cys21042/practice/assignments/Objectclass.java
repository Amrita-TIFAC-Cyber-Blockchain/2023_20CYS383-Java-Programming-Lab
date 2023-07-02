package com.amrita.jpl.cys21042.practice.assignments;

import java.util.Scanner;

/**
 * @Author: Mittul R - CB.EN.U4CYS21042
 */
public class Objectclass {

    static double assignGrade;
    float avg,j;
    public void publishResult(){
        System.out.println("Results are Out !");
    }

    public void displayMarks(String j,float a,float b,float c){ /*HEllo*/
        System.out.println("Name of the Student: " + j);
        System.out.println("Mark Scored in First Subject: " + a);
        System.out.println("Mark Scored in Second Subject : " + b);
        System.out.println("Mark Scored in Third Subject: " + c);
    }
    public void calculateAverage(float a,float b,float c){
        avg=(a+b+c)/3;
        System.out.println("The average is " + avg);
    }
    public void feedback(){
        if (avg>90){
            System.out.println("Good Performance !");
        }
        else{
            System.out.println("Bad Performance ; Do Hardwork!");
        }}

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println("Enter mark 1 : ");
        float a= sc.nextFloat();
        System.out.println("Enter mark 2 : ");
        float b= sc.nextFloat();
        System.out.println("Enter mark 3 : ");
        float c= sc.nextFloat();
        Objectclass Student = new Objectclass();
        Student.publishResult();
        Student.displayMarks(s,a,b,c);
        Student.calculateAverage(a,b,c);
        Student.feedback();
}
}
