package com.amrita.jpl.cys21022.pract.student;

//HARSHITHA RANJITH
//CB.EN.U4CYS21022
//create a class
public class CYS21022 {
    static double assignGrade;
    String name;
    int rollnum;

    public static void publishResult() {
        System.out.println("Results are published");
    }

    public void grades(double grade) {
        System.out.println("Grade is:" + grade);
    }

    public void showName(String name){
        System.out.println("Name is:"+name);
    }
    public void showNum(int rollnum){
        System.out.println("Number is:"+rollnum);
    }


    public static void main(String[] args) {
        CYS21022 myclass = new CYS21022();
        publishResult();
        myclass.assignGrade = 9.69;
        myclass.grades(myclass.assignGrade);
        myclass.name = "Harshi";
        myclass.showName(myclass.name);
        myclass.rollnum = 22;
        myclass.showNum(myclass.rollnum);
    }
}

