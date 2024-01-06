package com.amrita.jpl.cys21022.endsem;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * @author:Harshitha
 * Creating file management system that handles different types of files.
 */

abstract class File {
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void displayFileDetails(){
        System.out.println("File Name = " + fileName + "File Size = " + fileSize);
    }
}

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void saveToFile();
    void loadFromFile();
    ArrayList<File> getFiles();
}

class Document extends File{
    private String documentType;

    public Document(String documentType){
        this.documentType = documentType;
    }

    public String getdocumenttype(){
        return documentType;
    }

    public void displayFileDetails(){
        System.out.println("Document Type = " + documentType);
    }
}

class Image extends File{
    private String resolution;

    public Image (String documentType){
        this.resolution = resolution;
    }

    public String getdocumenttype(){
        return resolution;
    }

    public void displayFileDetails(){
        System.out.println("Image Resolution = " + resolution);
    }

}

class Video extends File{
    private String duration;

    public Image(String documentType){
        this.duration = duration;
    }

    public String getdocumenttype(){
        return duration;
    }

    public void displayFileDetails(){
        System.out.println("Video Duration = " + duration);
    }
}

class FileManagerImpl implements FileManager{
    private List<File> files;

    public FileManagerImpl(){
        files = new ArrayList<>();
    }

    public void addFile(File file){
        file.add(file);
    }

    public void deleteFile(String fileName) {
        File fileToRemove = null;
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToRemove = file;
                break;
            }
        }
        if (fileToRemove != null) {
            files.remove(fileToRemove);
        }
        else{
            System.out.println("No files are there.");

        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("The file details are saved in " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (List<File>) ois.readObject();
            System.out.println("The file details were loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
