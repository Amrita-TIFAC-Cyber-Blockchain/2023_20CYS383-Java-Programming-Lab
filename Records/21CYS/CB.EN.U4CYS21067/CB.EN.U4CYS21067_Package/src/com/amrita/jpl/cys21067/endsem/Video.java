package com.amrita.jpl.cys21067.endsem;

/**
 * The Video class represents a video file.
 */
public class Video extends File {
    private String duration;

    /**
     * Constructs a Video object with the specified file name, file size, and duration.
     *
     * @param fileName the name of the video file
     * @param fileSize the size of the video file
     * @param duration the duration of the video
     */
    public Video(String fileName, String fileSize, String duration) {
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
     * @param duration the duration of the video
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Displays the details of the video file, including the file name, file size, and duration.
     */
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}
