/**
 * The Basicfuntions class represents a basic implementation of student information and grade calculation.
 * It allows users to input student details and calculates the grade based on the marks obtained.
 * The results can be published for each student.
 */
package com.amrita.jpl.cys21089.pract;

import java.util.Scanner;

/**
 * @author Yaswanth Gadamsetti
 */

/**
 * The Basicfuntions class represents student information and grade calculation.
 */
public class Basicfuntions {

    float grade; // Represents the grade of the student
    String Name; // Represents the name of the student
    float Mark1, Mark2, Mark3; // Represents the marks obtained by the student in three subjects

    /**
     * Publishes the results of a student.
     * It displays the grade of the student along with their name.
     */
    public void publishresults(){
        System.out.println("The Grade of "+ Name + ": " + grade);
    }

    /**
     * Gets the details of a student from the user.
     * It prompts the user to enter the name and marks of the student.
     * It calculates the grade based on the entered marks.
     */
    public void Getdetails() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        Name = myObj.nextLine();
        System.out.print("Enter the marks obtained in three subjects (separated by spaces): ");
        Mark1 = myObj.nextFloat();
        Mark2 = myObj.nextFloat();
        Mark3 = myObj.nextFloat();
        calculated();
    }

    /**
     * Assigns the grade of the student based on the calculated average marks.
     */
    public void calculated() {
        grade = (Mark1 + Mark2 + Mark3) / 3;
    }

    /**
     * The entry point of the program.
     * It creates two instances of Basicfuntions class, gets details for each student, and publishes their results.
     */
    public static void main(String[] args) {
        Basicfuntions student14 = new Basicfuntions();
        Basicfuntions student89 = new Basicfuntions();
        System.out.println("Enter details for student 1:");
        student14.Getdetails();
        System.out.println("Enter details for student 2:");
        student89.Getdetails();
        System.out.println("Results for student 1:");
        student14.publishresults();
        System.out.println("Results for student 2:");
        student89.publishresults();
    }
}
