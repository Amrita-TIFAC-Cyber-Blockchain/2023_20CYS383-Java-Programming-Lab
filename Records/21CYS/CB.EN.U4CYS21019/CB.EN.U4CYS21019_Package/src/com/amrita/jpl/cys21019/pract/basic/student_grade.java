package com.amrita.jpl.cys21019.pract.basic;

/**
 * This class represents a student and their grades.
 * Author: Gokulachselvan
 */
public class student_grade {

    private double assignGrade; // Grade assigned to the student
    private String studentName; // Name of the student

    /**
     * Publishes the result of the student.
     */
    public void publishResult() {
        System.out.println("Results are published.");
    }

    /**
     * Prints the graded score of the student.
     *
     * @param grade Grade of the student
     */
    public void graded(double grade) {
        System.out.println("Grade is: " + grade);
    }

    /**
     * Constructor to initialize the C21CYS_19 object with the assigned grade.
     *
     * @param assignGrade Grade assigned to the student
     */
    public student_grade(double assignGrade) {
        this.assignGrade = assignGrade;
    }

    /**
     * Retrieves the assigned grade of the student.
     *
     * @return Assigned grade of the student
     */
    public double getAssignGrade() {
        return assignGrade;
    }

    /**
     * Sets the assigned grade of the student.
     *
     * @param assignGrade Assigned grade of the student
     */
    public void setAssignGrade(double assignGrade) {
        this.assignGrade = assignGrade;
    }

    /**
     * Sets the name of the student.
     *
     * @param studentName Name of the student
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return Name of the student
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Calculates the grade of the student based on the percentage.
     *
     * @param percentage Percentage obtained by the student
     * @return Grade calculated based on the percentage
     */
    public char calculateGrade(double percentage) {
        if (percentage >= 90)
            return 'A';
        else if (percentage >= 80)
            return 'B';
        else if (percentage >= 70)
            return 'C';
        else if (percentage >= 60)
            return 'D';
        else
            return 'F';
    }

    /**
     * Filetransfer method to run the program.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        student_grade myclass;
        myclass = new student_grade(9.69);
        myclass.publishResult();
        myclass.setStudentName("Gokul");
        double grade = myclass.getAssignGrade();
        myclass.graded(grade);
        System.out.println("Student Name: " + myclass.getStudentName());
        char calculatedGrade;
        calculatedGrade = myclass.calculateGrade(85.5);
        System.out.println("Calculated Grade: " + calculatedGrade);
    }
}
