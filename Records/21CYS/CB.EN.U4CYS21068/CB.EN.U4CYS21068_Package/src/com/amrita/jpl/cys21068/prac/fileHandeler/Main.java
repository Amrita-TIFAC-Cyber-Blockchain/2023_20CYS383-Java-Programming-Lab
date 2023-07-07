package com.amrita.jpl.cys21068.prac.fileHandeler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new TextFileHandler();
        String filePath = "/Users/saranesh/Desktop/a.txt";

        fileHandler.uploadFile(filePath);
        fileHandler.readFile(filePath);
    }
}
