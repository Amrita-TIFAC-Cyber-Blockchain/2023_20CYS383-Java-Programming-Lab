package com.amrita.jpl.cys21031.practice.simple;

/**
 * @author Kishanth K
 * @version 0.5
 */
public class StudentGrade {
    double assignGrade;        //if u didn't declare assigngrades as static then
    //variable name should not have static
    String name;
    String roll;
    public static void publishResult() {
        System.out.println("Results are published");
    }
    public void grades(double grade) {
        System.out.println("Grade is:" + grade);
    }
    public void nameOfStud(String name) {
        System.out.println("Name:" + name);
    }
    public void RollNo(String roll) {
        System.out.println("Roll Number:" + roll);
    }
    public static void main(String[] args) {
        StudentGrade myclass=new StudentGrade();
        publishResult();
        myclass.assignGrade=9.69;
        myclass.name="Kishanth K";
        myclass.roll="CB.EN.U4CYS21031";
        myclass.nameOfStud(myclass.name);
        myclass.RollNo(myclass.roll);
        myclass.grades(myclass.assignGrade);

        StudentGrade myclass2=new StudentGrade();
        publishResult();
        myclass2.assignGrade=9.00;
        myclass2.name="Alooysius Vitalian";
        myclass2.roll="CB.EN.U4CYS21006";
        myclass2.nameOfStud(myclass2.name);
        myclass2.RollNo(myclass2.roll);
        myclass2.grades(myclass2.assignGrade);

    }
}
