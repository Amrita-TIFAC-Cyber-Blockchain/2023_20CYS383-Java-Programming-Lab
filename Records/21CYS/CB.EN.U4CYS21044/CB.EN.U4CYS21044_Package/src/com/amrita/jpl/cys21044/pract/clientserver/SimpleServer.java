package com.amrita.jpl.cys21044.pract.clientserver;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: ravi
 */
public class SimpleServer {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);
                System.out.println("[" + formattedTime + "] Message from client: " + message);
            }
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
