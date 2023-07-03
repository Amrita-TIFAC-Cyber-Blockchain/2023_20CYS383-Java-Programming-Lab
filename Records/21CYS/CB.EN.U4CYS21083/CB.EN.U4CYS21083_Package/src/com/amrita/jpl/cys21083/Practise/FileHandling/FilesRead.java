package com.amrita.jpl.cys21083.Practise.FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

public class FilesRead {
    public static void main(String[] args) {
        try {
            File myObj = new File("20cys383.txt");
            Scanner read = new Scanner(myObj);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
