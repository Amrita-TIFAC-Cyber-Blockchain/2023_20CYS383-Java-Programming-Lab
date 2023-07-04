package com.amrita.jpl.cys21085.endsem;

import java.util.ArrayList;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 */
interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}

class File {
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
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private String duration;

    public Video(String fileName, long fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        files.removeIf(file -> file.getFileName().equals(fileName));
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }
}

public class FileManage {
    public static void main(String[] args) {
        FileManagerImpl fileManager = new FileManagerImpl();

        // Adding files
        Document document = new Document("Document1", 1024, "PDF");
        Image image = new Image("Image1", 2048, "1920x1080");
        Video video = new Video("Video1", 4096, "10 mins");

        fileManager.addFile(document);
        fileManager.addFile(image);
        fileManager.addFile(video);

        // Displaying all files
        fileManager.displayAllFiles();

        // Deleting a file
        fileManager.deleteFile("Image1");

        // Displaying all files after deletion
        fileManager.displayAllFiles();
    }
}
