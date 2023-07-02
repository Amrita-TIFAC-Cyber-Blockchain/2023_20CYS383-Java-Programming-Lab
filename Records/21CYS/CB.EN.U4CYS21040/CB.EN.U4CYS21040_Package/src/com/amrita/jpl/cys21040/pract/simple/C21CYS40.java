package com.amrita.jpl.cys21040.pract.simple;
import java.util.Scanner;

/**
 * The class C21CYS40 publishes results, displays marks of student,
 * calculates average of student and according to the average
 * gives the feedback. C21CYS40 contains the functions,
 * publishResult, displayMarks, calculateAverage and feedback
 */

public class C21CYS40 {

    static double assignGrade;
    float avg,j;
    public void publishResult(){
        System.out.println("Results are published");
    }

    public void displayMarks(String j,float a,float b,float c){
        System.out.println("Student Name : " + j);
        System.out.println("Mark 1 : " + a);
        System.out.println("Mark 2 : " + b);
        System.out.println("Mark 3 : " + c);
    }
    public void calculateAverage(float a,float b,float c){
            avg=(a+b+c)/3;
            System.out.println("The average is " + avg);
    }
    public void feedback(){
        if (avg>90){
            System.out.println("Very Good");
        }
        else{
        System.out.println("Very Bad");
    }}
/**
 * The main function creates an object of C21CYS21040
 * and also takes in the values of marks for 3 different subjects
 * and calls the functions of C21CYS40 to publish result, calculate average,
 * display marks and give the feedback*/
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println("Enter mark 1 : ");
        float a= sc.nextFloat();
        System.out.println("Enter mark 2 : ");
        float b= sc.nextFloat();
        System.out.println("Enter mark 3 : ");
        float c= sc.nextFloat();
        C21CYS40 Student = new C21CYS40();
        Student.publishResult();
        Student.displayMarks(s,a,b,c);
        Student.calculateAverage(a,b,c);
        Student.feedback();
    }
}
