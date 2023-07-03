package com.amrita.jpl.cys21083.Practise.DataStructures;

import java.util.Scanner;
public class ArrayEx {
    public ArrayEx() {
    }

    public static void main(String[] args) {
        String[] rollNumber = new String[]{"CB.EN.U4CYS22021", "CB.EN.U4CYS22022", "CB.EN.U4CYS22023", "CB.EN.U4CYS22024", "CB.EN.U4CYS22025"};

        for(int i = 0; i < rollNumber.length; ++i) {
            System.out.println(rollNumber[i]);
        }

        Integer[] indexno = new Integer[]{1,2,3};
        for(int i = 0; i < indexno.length; ++i) {
            System.out.println(indexno[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        float[] numbers = new float[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Array elements:");
        for (int i = 0; i < size; i++) {
            System.out.println(numbers[i]);
        }

        scanner.close();
    }
}


