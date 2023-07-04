package com.amrita.jpl.cys21023.ex;
import java.io.*;
import java.net.*;

public class FileTransferClient {
    private Socket socket;

    public FileTransferClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String filename) {
        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send the filename and file size to the server
            dos.writeUTF(file.getName());
            dos.writeInt((int) file.length());


            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent: " + filename);

            fis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;
        FileTransferClient client = new FileTransferClient(host, port);

        // Send a file to the server
        String filename = "C:\\Users\\Iniyan Raja\\Desktop\\Semester 4\\Java Programming - LAB\\java_programming _lab_u4cys23\\src\\com\\amrita\\jpl\\cys21023\\samplefile.txt";
        client.sendFile(filename);

        // Close the client connection
        client.close();
    }
}
