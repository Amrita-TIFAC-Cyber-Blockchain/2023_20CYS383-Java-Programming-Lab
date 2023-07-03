package com.amrita.jpl.cys21062.pract.net;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ruthwik Krishna Bandreddy
 * @version 0.5
 */
public class Server {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2610);
            System.out.println("Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected:)");
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client port No : " + clientPort);
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";
            while (!message.equalsIgnoreCase("q")) {
                message = dataInputStream.readUTF();
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
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