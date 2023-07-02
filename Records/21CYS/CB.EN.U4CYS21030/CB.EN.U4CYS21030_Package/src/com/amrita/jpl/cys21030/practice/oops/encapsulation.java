package com.amrita.jpl.cys21030.practice.oops;
class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        } else {
            System.out.println("Age must be at least 18.");
        }
    }
}

public class encapsulation {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("John");
        emp.setAge(25);

        System.out.println("Employee: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
    }
}
