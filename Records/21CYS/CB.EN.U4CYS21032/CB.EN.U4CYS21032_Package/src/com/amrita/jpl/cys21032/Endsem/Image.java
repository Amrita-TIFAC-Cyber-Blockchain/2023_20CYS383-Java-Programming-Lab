public class Image extends File {
    private String resolution;

    public Image(String fileName, double fileSize, String resolution){
        super(fileName, fileSize);
        this.resolution=resolution;
    }

    public String getresolution() { return this.resolution; }
    public void setDocumentType(String type) { this.resolution = type; }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + getFileName() + ", File Size: " + getFileSize() + ", Resolution: " + getresolution());
    }
}

