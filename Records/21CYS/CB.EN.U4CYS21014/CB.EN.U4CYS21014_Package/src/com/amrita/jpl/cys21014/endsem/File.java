package com.amrita.jpl.cys21014.endsem;

/**
 *Creating an Abstract class 'com.amrita.jpl.cys21014.endsem.File'
 *Attributes: fileName, fileSize
 *Methods: getters and setters for all attributes, displayFileDetails()
 */
class File{
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
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + " KB");
    }
}