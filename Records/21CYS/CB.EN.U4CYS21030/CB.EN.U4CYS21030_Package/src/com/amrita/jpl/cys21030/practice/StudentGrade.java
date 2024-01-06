package com.amrita.jpl.cys21030.practice;
public class StudentGrade {
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
        StudentGrade myclass=new StudentGrade();
        publishResult();
        myclass.assignGrade=7.69;
        myclass.name="Sai Suvarchala K";
        myclass.roll="CB.EN.U4CYS21030";
        myclass.nameOfStud(myclass.name);
        myclass.RollNo(myclass.roll);
        myclass.grades(myclass.assignGrade);

        StudentGrade myclass2=new StudentGrade();
        publishResult();
        myclass2.assignGrade=10;
        myclass2.name="Sai";
        myclass2.roll="CB.EN.U4CYS21100";
        myclass2.nameOfStud(myclass2.name);
        myclass2.RollNo(myclass2.roll);
        myclass2.grades(myclass2.assignGrade);

    }
}