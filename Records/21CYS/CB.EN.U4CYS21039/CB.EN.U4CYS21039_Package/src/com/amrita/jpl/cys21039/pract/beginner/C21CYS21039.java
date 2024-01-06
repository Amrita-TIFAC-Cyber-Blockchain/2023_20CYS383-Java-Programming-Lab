package com.amrita.jpl.cys21039.pract.beginner;

/**
 * The C21CYS21039 class represents a student with a name, roll number, and grade.
 *
 * @author Manbendra Satpathy
 * @since 17.04.2023
 */
public class C21CYS21039 {

    double grade; // Grade of the student
    int rollNumber; // Roll number of the student
    String name; // Name of the student

    /**
     * Displays the details of the student, including name, roll number, and grade.
     *
     * @param obj The object of C21CYS21039 class to display the details
     */
    public static void displayDetails(C21CYS21039 obj) {
        System.out.println("Name: " + obj.name);
        System.out.println("Roll number: " + obj.rollNumber);
        System.out.println("Grade : " + obj.grade);
    }

    /**
     * The entry point for the Java program.
     *
     * @param args The command-line arguments
     */
    public static void main(String args[]) {
        C21CYS21039 student1 = new C21CYS21039();
        student1.name = "Manbendra";
        student1.grade = 8.8;
        student1.rollNumber = 39;

        displayDetails(student1);
    }
}
