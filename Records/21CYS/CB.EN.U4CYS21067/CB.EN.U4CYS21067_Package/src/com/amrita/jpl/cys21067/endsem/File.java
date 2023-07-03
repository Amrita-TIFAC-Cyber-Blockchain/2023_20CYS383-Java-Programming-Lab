package com.amrita.jpl.cys21067.endsem;

/**
 * The File class represents a generic file with basic properties such as file name and file size.
 */
public class File {
    private String fileName;
    private String fileSize;

    /**
     * Creates a File object with the specified file name and file size.
     *
     * @param fileName The name of the file.
     * @param fileSize The size of the file.
     */
    public File(String fileName, String fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    /**
     * Gets the name of the file.
     *
     * @return The name of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the name of the file.
     *
     * @param fileName The name of the file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the size of the file.
     *
     * @return The size of the file.
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * Sets the size of the file.
     *
     * @param fileSize The size of the file.
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Displays the details of the file, including the file name and file size.
     */
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}
