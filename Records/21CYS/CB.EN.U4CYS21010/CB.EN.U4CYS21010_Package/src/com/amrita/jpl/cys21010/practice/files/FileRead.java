package com.amrita.jpl.cys21010.practice.files;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileRead {
    /**
     *Reads File from given Filename
     * @param args
     */
    public static void main(String[] args) {
         try {
             File myFile  = new File("./20cys383.txt");
              Scanner myScan = new Scanner(myFile);
              while(myScan.hasNextLine()){
                  String d = myScan.nextLine();
                  System.out.println(d);
              }
        }
        catch (IOException e) {
            System.out.println("[ERROR] Input Output Exception");
            e.printStackTrace();
        }
    }
}