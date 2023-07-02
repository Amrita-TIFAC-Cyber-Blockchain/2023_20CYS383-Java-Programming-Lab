package com.amrita.jpl.cys21015.ex;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileTransferClient extends FileTransfer implements FileTransferListener {

    @Override
    public void sendFile(String filename) {
        super.sendFile(filename);
        // Implementation for sending the file to the server using socket programming
        try {
            Socket socket = new Socket("localhost", 12345);
            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(filename);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            fileInputStream.close();
            outputStream.close();
            socket.close();

            onFileSent(filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename to send: ");
        String filename = scanner.next();
        FileTransferClient client = new FileTransferClient();
        client.sendFile(filename);
    }

    @Override
    public void saveFile(byte[] fileData, String filename){
        // Not applicable for the client
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("File sent: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
        // Not applicable for the client
    }
}
