package com.amrita.jpl.cys21046.endsem;

/**
 * The Image class represents an image file, extending the File class.
 */
public class Image extends File {
    private String resolution;

    /**
     * Constructs an Image object with the specified file name, file size, and resolution.
     *
     * @param fileName   the name of the image file
     * @param fileSize   the size of the image file in bytes
     * @param resolution the resolution of the image
     */
    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    /**
     * Retrieves the resolution of the image.
     *
     * @return the resolution of the image
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the resolution of the image.
     *
     * @param resolution the resolution of the image
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * Displays the details of the image file, including the file name, file size, and resolution.
     */
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}
