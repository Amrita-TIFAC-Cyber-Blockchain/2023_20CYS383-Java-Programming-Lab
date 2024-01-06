package com.amrita.jpl.cys21080.practice.oops.encapsulation;

import java.util.Scanner;

/**
 * Represents a human with a name and age.
 * @author T Pavan Kumar Reddy
 */
class Human {
    private int age;
    private String name;

    /**
     * Sets the age of the human.
     * @param a the age to set
     */
    public void setAge(int a) {
        age = a;
    }

    /**
     * Retrieves the age of the human.
     * @return the age of the human
     */
    public int getAge(){
        return age;
    }

    /**
     * Sets the name of the human.
     * @param n the name to set
     */
    public void setName(String n){
        name = n;
    }

    /**
     * Retrieves the name of the human.
     * @return the name of the human
     */
    public String getName(){
        return name;
    }
}

/**
 * A class to demonstrate basic encapsulation.
 */
public class basic_encapsulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Human obj = new Human();

        System.out.print("Enter Name: ");
        String name = input.nextLine();
        obj.setName(name);

        System.out.print("Enter Age: ");
        int age = input.nextInt();
        obj.setAge(age);

        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());

        input.close();
    }
}

