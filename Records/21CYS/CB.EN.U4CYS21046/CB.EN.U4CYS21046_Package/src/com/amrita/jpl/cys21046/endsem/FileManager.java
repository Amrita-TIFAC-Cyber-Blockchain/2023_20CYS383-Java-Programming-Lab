package com.amrita.jpl.cys21046.endsem;

import java.util.List;

/**
 * The FileManager interface represents the operations that can be performed on files.
 */
public interface FileManager {
    /**
     * Adds a file to the file management system.
     *
     * @param file the file to add
     */
    void addFile(File file);

    /**
     * Deletes a file from the file management system based on the file name.
     *
     * @param fileName the name of the file to delete
     */
    void deleteFile(String fileName);

    /**
     * Displays all the files in the file management system.
     */
    void displayAllFiles();

    /**
     * Retrieves a list of all the files in the file management system.
     *
     * @return a list of files
     */
    List<File> getAllFiles();

    /**
     * Saves the file management system to a file.
     *
     * @param fileName the name of the file to save to
     */
    void saveToFile(String fileName);

    /**
     * Loads the file management system from a file.
     *
     * @param fileName the name of the file to load from
     */
    void loadFromFile(String fileName);
}
