package com.amrita.jpl.cys21067.endsem;

/**
 * The FileManager interface represents a file management system that allows adding, deleting, and displaying files.
 */
public interface FileManager {

    /**
     * Adds a file to the file management system.
     *
     * @param file the file to be added
     */
    void addFile(File file);

    /**
     * Deletes a file from the file management system based on the file name.
     *
     * @param fileName the name of the file to be deleted
     */
    void deleteFile(String fileName);

    /**
     * Displays all files in the file management system.
     */
    void displayAllFiles();
}
