package com.amrita.jpl.cys21014.endsem;

/**

 * Class 'com.amrita.jpl.cys21014.endsem.Image' inherits from com.amrita.jpl.cys21014.endsem.File
 * Attributes: resolution
 * Methods: getters and setters for resolution, displayFileDetails()
 */

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public String getResolution() {
        return resolution;
    }
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);    }
}