package com.amrita.jpl.cys21001.pract.BasicClass;

public class c21cys {
    double assignGrade;
    String assignName;
    String assignRoll;

    public c21cys() {
    }

    public void publishResult() {
        System.out.println("Results are published");
    }

    public void Name(String Name) {
        System.out.println("Name: " + Name);
    }

    public void Roll(String Roll) {
        System.out.println("Roll no: " + Roll);
    }

    public void grade(double grade) {
        System.out.println("Grade is:" + grade);
    }

    public static void main(String[] args) {
        c21cys myclass = new c21cys();
        myclass.publishResult();
        myclass.assignName = "Abi";
        myclass.assignGrade = 8.0;
        myclass.assignRoll = "CYS21001";
        myclass.Name(myclass.assignName);
        myclass.Roll(myclass.assignRoll);
        myclass.grade(myclass.assignGrade);
    }
}
