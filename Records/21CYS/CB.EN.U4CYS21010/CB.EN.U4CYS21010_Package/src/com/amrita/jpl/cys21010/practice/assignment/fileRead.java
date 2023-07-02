package com.amrita.jpl.cys21010.practice.assignment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fileRead {
    public static void main(String[] args) {
        FileReaderExample obj = new FileReaderExample();
        obj.fun();

    }
}


class FileReaderExample {
    public void fun() {

        String fileName = "./exmaple.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}