package com.amrita.jpl.cys21016.pract.datastructures;
/**
 * An array list implementation
 * @author G H Hem Sagar
 * @version 1.0
 * */
import java.util.*;
public class arrayList {
    public static void main(String[] args){
        /**
         * It is the main function that instantiates the ArrayList class and performs the operations.a
         * @param args -> Commandline arguments
         * */
        Scanner input = new Scanner(System.in);
        ArrayList<String> Name = new ArrayList<String>();
        //Iterator<String> it1 = Name.iterator();
        ArrayList<String> Roll = new ArrayList<String>();
        //Iterator<String> it2 = Roll.iterator();
        ArrayList<Integer> Age = new ArrayList<Integer>();
        //Iterator<Integer> it3 = Age.iterator();


        System.out.print("Enter the number of students: ");
        int n = input.nextInt();
        input.nextLine();

        for(int i=0;i<n;i++){
            System.out.print("\nEnter the name of the student: ");
            String name = input.nextLine();
            Name.add(name);
            System.out.print("Enter the Roll no: ");
            String roll = input.nextLine();
            Roll.add(roll);
            System.out.print("Enter the age: ");
            Age.add(input.nextInt());
            input.nextLine();
        }

        System.out.println("Names of students: "+Name);
        System.out.println("Roll no. of students: "+Roll);
        System.out.println("Age of students: "+Age);

        System.out.println("\n");
/*
        while(it1.hasNext() && it2.hasNext() && it3.hasNext()){
            System.out.println("Name: "+it1.next());
            System.out.println("Roll: "+it2.next());
            System.out.println("Age: "+it3.next());
        }
        */

        for(int i=0;i<n;i++){
            System.out.println("Name: "+Name.get(i));
            System.out.println("Roll: "+Roll.get(i));
            System.out.println("Age: "+Age.get(i));
            System.out.print("\n");
        }
    }
}
