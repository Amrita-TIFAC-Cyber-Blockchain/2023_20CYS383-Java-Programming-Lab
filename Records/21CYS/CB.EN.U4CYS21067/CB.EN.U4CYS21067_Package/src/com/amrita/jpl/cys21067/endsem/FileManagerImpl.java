package com.amrita.jpl.cys21067.endsem;

import java.util.ArrayList;

/**
 * The FileManagerImpl class is an implementation of the FileManager interface.
 * It manages a collection of files and provides methods to add, delete, and display files.
 */
public class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    /**
     * Constructs a FileManagerImpl object with an empty list of files.
     */
    public FileManagerImpl() {
        this.files = new ArrayList<>();
    }

    /**
     * Adds a file to the file management system.
     *
     * @param file the file to be added
     */
    @Override
    public void addFile(File file) {
        files.add(file);
    }

    /**
     * Deletes a file from the file management system based on the file name.
     *
     * @param fileName the name of the file to be deleted
     */
    @Override
    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.getFileName().equals(fileName)) {
                files.remove(i);
                break;
            }
        }
    }

    /**
     * Displays all files in the file management system.
     */
    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }
}
