package com.amrita.jpl.cys21063.endsem;

public abstract class File {
    private String fileName;
    private double fileSize;

    public File(String fileName, double fileSize){
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() { return this.fileName; }
    public double getFileSize() { return this.fileSize; }


    public void setFileName(String name) { this.fileName = name; }
    public void setFileSize(double size) { this.fileSize = size; }


    public abstract void displayFileDetails();
}


