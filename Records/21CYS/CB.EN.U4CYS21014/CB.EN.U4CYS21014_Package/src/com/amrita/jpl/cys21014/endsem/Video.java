package com.amrita.jpl.cys21014.endsem;

/**
 * Class 'com.amrita.jpl.cys21014.endsem.Video' inherits from com.amrita.jpl.cys21014.endsem.File
 * Attributes: duration
 * Methods: getters and setters for duration, displayFileDetails()
 */

class Video extends File {
    private String duration;

    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {

        this.duration = duration;
    }
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

