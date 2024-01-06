package com.amrita.jpl.cys21046.endsem;

/**
 * The Video class represents a video file that extends the File class.
 */
public class Video extends File {
    private String duration;

    /**
     * Constructs a Video object with the specified file name, file size, and duration.
     *
     * @param fileName  the name of the video file
     * @param fileSize  the size of the video file
     * @param duration  the duration of the video
     */
    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    /**
     * Retrieves the duration of the video.
     *
     * @return the duration of the video
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the video.
     *
     * @param duration  the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Displays the details of the video, including the file details and the duration.
     */
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}
