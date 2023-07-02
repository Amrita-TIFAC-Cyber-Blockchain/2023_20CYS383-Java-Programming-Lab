package com.amrita.jpl.cys21003.pract.basics;
/**
 * Printing Student Grade.
 *
 * @author Aishwarya G
 * @version 1.0
 */

public class C21CYS {
    double assignGrade;
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
        C21CYS myclass=new C21CYS();
        publishResult();
        myclass.assignGrade=9.69;
        myclass.name="Aishwarya G";
        myclass.roll="CB.EN.U4CYS21003";
        myclass.nameOfStud(myclass.name);
        myclass.RollNo(myclass.roll);
        myclass.grades(myclass.assignGrade);
    }
}
