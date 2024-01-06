package com.amrita.jpl.cys21046.practice.net;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a simple chat server that accepts messages from a client.
 * It listens on a specified port and prints the received messages along with timestamps.
 * Author: Mukesh SA
 * Version: 0.5
 */
public class chats{

    /**
     * The main method of the ChatServer class.
     * It starts the server, accepts client connections, and receives messages.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Create a server socket to listen for client connections on port 2444
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Get client details
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);

            // Create a data input stream to read messages from the client
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";

            // Keep receiving messages until the client sends an "exit" message
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();

                // Get the current timestamp
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);

                // Print the received message along with the timestamp
                System.out.println("[" + formattedTime + "] Message from client: " + message);
            }

            // Close the server socket
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
