package com.amrita.jpl.cys21062.pract.clas;

/**
 * The C21cys class represents a student's information and their grades.
 * It provides methods to publish results, calculate grades, and display student details.
 */
public class C21cys {
    String name;
    String rollno;
    String branch;
    static double assaignGrade;

    /**
     * Default constructor for the C21cys class.
     */
    public C21cys() {
    }

    /**
     * Publishes the results.
     */
    public void publishResult() {
        System.out.println("Results are published");
    }

    /**
     * Prints the assigned grade.
     *
     * @param grade The grade to be printed.
     */
    public void graded(double grade) {
        System.out.println("Grade is: " + grade);
    }

    /**
     * Displays the student's name, roll number, and branch.
     *
     * @param name   The student's name.
     * @param rollno The student's roll number.
     * @param branch The student's branch.
     */
    public void name(String name, String rollno, String branch) {
        System.out.println("Name is: " + name);
        System.out.println("Roll number is: " + rollno);
        System.out.println("Branch is: " + branch);
    }

    /**
     * Calculates the average grade based on three subjects.
     *
     * @param sub1 Marks obtained in subject 1.
     * @param sub2 Marks obtained in subject 2.
     * @param sub3 Marks obtained in subject 3.
     * @return The calculated average grade.
     */
    public int marks(int sub1, int sub2, int sub3) {
        int grade = (sub1 + sub2 + sub3) / 3;
        return grade;
    }

    /**
     * The main method of the C21cys class.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        C21cys myClass = new C21cys();
        myClass.publishResult();
        myClass.name = "Ruthwik";
        myClass.rollno = "cb.en.u4cys21062";
        myClass.branch = "CYS";
        assaignGrade = 9.6;
        myClass.graded((double) myClass.marks(8, 9, 7));
        myClass.name(myClass.name, myClass.rollno, myClass.branch);
    }
}
