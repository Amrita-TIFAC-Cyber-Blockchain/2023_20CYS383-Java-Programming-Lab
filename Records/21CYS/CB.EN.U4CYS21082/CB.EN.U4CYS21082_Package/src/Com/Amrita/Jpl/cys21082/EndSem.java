package Com.Amrita.Jpl.cys21082;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}

class File {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize + " KB");
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
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

    public Image(String fileName, int fileSize, String resolution) {
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

    public Video(String fileName, int fileSize, String duration) {
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
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                files.remove(file);
                break;
            }
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println(); // Add a newline for separation
        }
    }
}

public class EndSem {
    private static FileManager fileManager;
    private JPanel panel1;

    public static void main(String[] args) {
        fileManager = new FileManagerImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("File Management System");
            System.out.println("1. Add Document");
            System.out.println("2. Add Image");
            System.out.println("3. Add Video");
            System.out.println("4. Delete File");
            System.out.println("5. Display All Files");
            System.out.println("6. Save File Details to Text File");
            System.out.println("7. Load File Details from Text File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addDocument(scanner);
                    break;
                case 2:
                    addImage(scanner);
                    break;
                case 3:
                    addVideo(scanner);
                    break;
                case 4:
                    deleteFile(scanner);
                    break;
                case 5:
                    displayAllFiles();
                    break;
                case 6:
                    saveToFile(scanner);
                    break;
                case 7:
                    loadFromFile(scanner);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Add a newline for separation
        }

        scanner.close();
    }

    private static void addDocument(Scanner scanner) {
        System.out.print("Enter document name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter document size (KB): ");
        int fileSize = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter document type: ");
        String documentType = scanner.nextLine();

        Document document = new Document(fileName, fileSize, documentType);
        fileManager.addFile(document);
        System.out.println("Document added successfully.");
    }

    private static void addImage(Scanner scanner) {
        System.out.print("Enter image name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter image size (KB): ");
        int fileSize = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter image resolution: ");
        String resolution = scanner.nextLine();

        Image image = new Image(fileName, fileSize, resolution);
        fileManager.addFile(image);
        System.out.println("Image added successfully.");
    }

    private static void addVideo(Scanner scanner) {
        System.out.print("Enter video name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter video size (KB): ");
        int fileSize = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter video duration: ");
        String duration = scanner.nextLine();

        Video video = new Video(fileName, fileSize, duration);
        fileManager.addFile(video);
        System.out.println("Video added successfully.");
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();
        fileManager.deleteFile(fileName);
        System.out.println("File deleted successfully.");
    }

    private static void displayAllFiles() {
        fileManager.displayAllFiles();
    }

    private static void saveToFile(Scanner scanner) {
        // Implement file handling methods to save the file details to a text file
        // You can use FileOutputStream and ObjectOutputStream to write the file details
        System.out.println("File details saved to a text file.");
    }

    private static void loadFromFile(Scanner scanner) {
        // Implement file handling methods to load the file details from a text file
        // You can use FileInputStream and ObjectInputStream to read the file details
        System.out.println("File details loaded from a text file.");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
