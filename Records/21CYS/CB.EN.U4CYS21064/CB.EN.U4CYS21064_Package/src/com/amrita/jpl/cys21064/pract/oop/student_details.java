package com.amrita.jpl.cys21064.pract.oop;

import java.util.*;
/**
 * This class is a blueprint to store student details.
 * It allows to manage student details including name, roll no and grade.
 * @author  Rajendraprasad S
 * @since   2023-04-17
 */
public class student_details {

    /**
     * Class contains 3 attributes to store name, roll number and grade.
     */
    double grade;
    int rollNumber;
    String name;

    /**
     * Funtion to display student details.
     * @param obj  The student object whose details are to be displayed.
     */
    public static void displayDetails(student_details obj)
    {
        System.out.println("Name: "+obj.name);
        System.out.println("Roll number: "+obj.rollNumber);
        System.out.println("Grade : "+obj.grade);
    }

    /**
     * Main function to write driver code.
     * @param args Not used
     */
    public static void main(String args[])
    {
        student_details student1 = new student_details();
        student1.name = "Rajendraprasad S";
        student1.grade = 9.46;
        student1.rollNumber = 64;

        displayDetails(student1);
    }
}
