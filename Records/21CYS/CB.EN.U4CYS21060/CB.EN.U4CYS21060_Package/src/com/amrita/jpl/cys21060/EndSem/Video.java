package com.amrita.jpl.cys21060.EndSem;

import com.amrita.jpl.cys21060.EndSem.File;

public class Video extends File {
    private double duration;

    public Video(String fileName, double fileSize, double duration){
        super(fileName, fileSize);
        this.duration=duration;
    }

    public double getduration() { return this.duration; }
    public void setduration(String type) { this.duration = Double.parseDouble(type); }

    @Override
    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21060.endsem.File Name: " + getFileName() + ", com.amrita.jpl.cys21060.endsem.File Size: " + getFileSize() + ", Duration: " + getduration());
    }
}

