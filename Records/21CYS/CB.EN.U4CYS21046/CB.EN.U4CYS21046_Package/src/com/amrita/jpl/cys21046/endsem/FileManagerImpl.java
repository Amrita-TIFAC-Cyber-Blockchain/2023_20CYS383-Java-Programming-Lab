package com.amrita.jpl.cys21046.endsem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileManagerImpl class implements the FileManager interface and provides the functionality
 * to manage files, including adding, deleting, displaying, saving, and loading files.
 */
public class FileManagerImpl implements FileManager {
    private List<File> files;

    /**
     * Constructs a new instance of FileManagerImpl.
     */
    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
        System.out.println("File added successfully.");
    }

    @Override
    public void deleteFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                files.remove(file);
                System.out.println("File deleted successfully.");
                return;
            }
        }
        System.out.println("File not found.");
    }

    @Override
    public void displayAllFiles() {
        if (files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            for (File file : files) {
                file.displayFileDetails();
                System.out.println();
            }
        }
    }

    @Override
    public List<File> getAllFiles() {
        return files;
    }

    @Override
    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("File details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file details: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (List<File>) ois.readObject();
            System.out.println("File details loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file details: " + e.getMessage());
        }
    }
}
