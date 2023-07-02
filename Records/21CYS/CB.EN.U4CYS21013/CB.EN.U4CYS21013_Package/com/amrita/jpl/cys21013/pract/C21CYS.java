package com.amrita.jpl.cys21013.pract;

import java.util.Scanner;

/**
 * This class defines methods to input and output information related to student grades.
 * @author ROHITH
 * @version 1.0
 */
public class C21CYS {

    static double assignGrade;
    String name;
    int ROLL;

    /**
     * Prompts user to input name
     */
    public void inputName() {
        Scanner myObj = new Scanner(System.in);
        name = myObj.nextLine();
    }

    /**
     * Prompts user to input roll number
     */
    public void inputROLL(){
        Scanner myObj = new Scanner(System.in);
        ROLL = myObj.nextInt();
    }

    /**
     * Prints out the name, roll number, and grade of a student
     * @param grade - the grade to be printed
     */
    public void graded(double grade){
        System.out.println("Student name is: "+ name);
        System.out.println("ROLL NO is: "+ ROLL);
        System.out.println("Grade is: "+ grade);
    }

    /**
     * Prints out a message indicating that results are published
     */
    public void publicResult(){
        System.out.println("Results are published.");
    }

    /**
     * Main function to create an instance of the C21CYS class, input student information, and print out the grade
     * @param args - default argument to main function
     */
    public static void main(String[] args) {
        C21CYS myClass = new C21CYS();
        myClass.publicResult();
        myClass.assignGrade=9.99;
        myClass.inputName();
        myClass.inputROLL();
        myClass.graded(assignGrade);
    }
}