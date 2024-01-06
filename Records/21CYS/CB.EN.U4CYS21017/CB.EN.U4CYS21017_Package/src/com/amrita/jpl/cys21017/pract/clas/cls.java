package com.amrita.jpl.cys21017.pract.clas;

import java.util.Scanner;

public class cls {

    /**
     *Declared member variables
     */

    String name;
    int roll;
    int mark1;
    int mark2;
    int mark3;
    char grade;

    /**
     * Member function to get input
     */

    public void getInp(){
        Scanner input =new Scanner(System.in);
        System.out.println("Enter Name: ");
        name = input.next();
        System.out.println("Enter Roll No: ");
        roll = input.nextInt();
        System.out.println("Enter Mark 1: ");
        mark1 = input.nextInt();
        System.out.println("Enter Mark 2: ");
        mark2 = input.nextInt();
        System.out.println("Enter Mark 3: ");
        mark3 = input.nextInt();
    }

    /**
     * Member function to calculate the grade
     */

    public void calcGrade(){
        int avg = (mark1+mark2+mark3)/3;
        if(avg > 90){
            grade = 'A';
        } else if (avg > 80 && avg < 90) {
            grade = 'B';
        } else if (avg > 70 && avg < 80) {
            grade = 'C';
        } else if (avg > 60 && avg < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    /**
     * Member function to display
     */

    public void display(){
        System.out.println();
        System.out.println("Name: "+name);
        System.out.println("Roll no: "+roll);
        System.out.println("Mark 1: "+mark1);
        System.out.println("Mark 2: "+mark2);
        System.out.println("Mark 3: "+mark3);
        System.out.println("Grade: "+grade);
    }

    public static void main(String[] args){
        cls obj = new cls(); //Object created
        obj.getInp(); 
        obj.calcGrade();
        obj.display();
    }

}