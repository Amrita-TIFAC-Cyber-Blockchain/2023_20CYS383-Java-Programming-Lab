package com.amrita.jpl.cys21044.pract.gradeassign;
/**
*@author ravi
*/
public class C21CYS44 {
    double Assigngrade;
    String Name;
    String Roll;
    String Branch;


    public C21CYS44() {
    }

    public static void details(String Name, String Roll, String Branch) {
        System.out.println("Name:" + Name);
        System.out.println("Roll:" + Roll);
        System.out.println("Branch:" + Branch);
    }

    public static void publishresult() {
        System.out.println("results published");
    }

    public void grade(double grade) {
        System.out.println("grade:" + grade);
    }

    public static void main(String[] args) {
        C21CYS44 myclass = new C21CYS44();
        myclass.Name = "Ravi";
        myclass.Roll = "CB.EN.U4CYS21044";
        myclass.Branch = "CYS";
        details(myclass.Name, myclass.Roll, myclass.Branch);
        myclass.Assigngrade = 7.93;
        myclass.grade(myclass.Assigngrade);
        publishresult();
        System.out.println();
        new C21CYS44();
        myclass.Name = "chandra";
        myclass.Roll = "CB.EN.U4EEE21044";
        myclass.Branch = "EEE";
        details(myclass.Name, myclass.Roll, myclass.Branch);
        myclass.Assigngrade = 8.56;
        myclass.grade(myclass.Assigngrade);
        publishresult();

    }
}

