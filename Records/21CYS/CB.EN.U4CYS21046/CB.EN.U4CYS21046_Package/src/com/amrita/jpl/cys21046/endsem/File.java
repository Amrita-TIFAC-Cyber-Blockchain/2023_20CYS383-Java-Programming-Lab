package com.amrita.jpl.cys21046.endsem;

/**
 * The File class represents a generic file.
 */
public class File {
    private String fileName;
    private int fileSize;

    /**
     * Constructs a File object with the specified file name and file size.
     *
     * @param fileName  the name of the file
     * @param fileSize  the size of the file in kilobytes (KB)
     */
    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    /**
     * Retrieves the name of the file.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the name of the file.
     *
     * @param fileName  the file name to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Retrieves the size of the file.
     *
     * @return the file size in kilobytes (KB)
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * Sets the size of the file.
     *
     * @param fileSize  the file size to set in kilobytes (KB)
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Displays the details of the file, including the file name and file size.
     */
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + "KB");
    }
}
