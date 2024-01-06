package com.amrita.jpl.cys21014.endsem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * FileManager: Interface that declares the following methods
 * void addFile(File file): Add a file to the file management system.
 * void deleteFile(String fileName): Delete a file from the file management system by providing the file name.
 * void displayAllFiles(): Display details of all the files in the file management system.
 */
interface FileManager{
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    ArrayList<File> getFiles();
}

public class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        File fileToDelete = null;
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToDelete = file;
                break;
            }
        }
        if (fileToDelete != null) {
            files.remove(fileToDelete);
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }


    @Override
    public ArrayList<File> getFiles() {
        return files;
    }

    @Override
    public void displayAllFiles() {
        for (File f : files) {
            f.displayFileDetails();
            System.out.println("------------------------");
        }
    }
}

