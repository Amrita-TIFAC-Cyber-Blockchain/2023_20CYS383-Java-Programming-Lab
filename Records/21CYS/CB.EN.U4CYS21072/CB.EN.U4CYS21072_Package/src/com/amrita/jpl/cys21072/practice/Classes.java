package com.amrita.jpl.cys21072.practice;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public void setStudentInfo(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void assignGrade(char grade) {
        this.grade = grade;
    }

    public void publishResult() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}
public class Classes {
    public static void main(String[] args) {
        // Create instances of Student
        Student student1 = new Student();
        Student student2 = new Student();

        // Set attributes for student1
        student1.setStudentInfo("ABHINESH", 1);
        student1.assignGrade('A');

        // Set attributes for student2
        student2.setStudentInfo("ACHYUTH ", 2);
        student2.assignGrade('B');

        // Display results for student1
        System.out.println("Student 1 Result:");
        student1.publishResult();
        System.out.println();

        // Display results for student2
        System.out.println("Student 2 Result:");
        student2.publishResult();
    }
}

