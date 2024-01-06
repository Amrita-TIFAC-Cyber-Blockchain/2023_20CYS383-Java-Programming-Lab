package com.amrita.jpl.cys21067.practice.net;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: Dharmik S
 * Version: 0.5
 */
/**
 * The SimpleServer class represents a simple server application that receives messages from a client.
 * It listens on a specific port and prints the messages received from the client along with the timestamp.
 */
public class SimpleServer {

    /**
     * The main method is the entry point of the server application.
     *
     * @param args the command-line arguments
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