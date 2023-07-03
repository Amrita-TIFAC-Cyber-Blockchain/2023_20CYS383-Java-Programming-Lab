package com.amrita.jpl.cys21062.pract.File;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FILE {

        public static void main(String[] args) {
            try {
                File myFile = new File("20cys383.txt");
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                } else {
                    System.out.println("[INFO] File Exists.");
                }

                System.out.println("Absolute path: " + myFile.getAbsolutePath());
                System.out.println("Writable: " + myFile.canWrite());
                System.out.println("Readable: " + myFile.canRead());
                System.out.println("Size: " + myFile.length());
                System.out.println("Hash code: " + myFile.hashCode());

                FileWriter myWriter = new FileWriter("20cys383.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();

                // Optionally, uncomment the section to read the file using the Scanner class.
            /*
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            */
            } catch (IOException e) {
                System.out.println("[ERROR] Input Output Exception");
                e.printStackTrace();
            }
        }
    }

