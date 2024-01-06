package com.amrita.jpl.cys21010.practice.files;
import java.io.File;
import java.io.IOException;


public class FileCreate {

    /**
     *
     * It creates a new file with a specified name and displays a success message if the file is created successfully.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Change the file path if required
            File myObj = new File("./20cys3833.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}