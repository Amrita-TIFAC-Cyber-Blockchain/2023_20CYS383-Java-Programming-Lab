package com.amrita.jpl.cys21028.Practice.net;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: Hitesh
 * Version: 0.5
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
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();
                System.out.println(" from client: " + message);
            }
            serverSocket.close();
            System.out.println("Server-socket closed.");
        } catch (IOException e) {
            System.out.println(" error occurred: " + e);
        }
    }
}
