package com.amrita.jpl.cys21033.Assignments.net;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a simple server that listens for client connections
 * and receives messages from the client.
 * It uses ServerSocket to listen for connections and DataInputStream to receive messages.
 * The server displays the client's IP address and port number when connected.
 * The server displays the received messages along with the current timestamp.
 * The server can be terminated by sending the message 'exit' from the client.
 *
 * @author Suhitha
 * @version 0.5
 */
public class SimpleServer {

    /**
     * The main method of the server application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Get the client's IP address and port number
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);

            // Create a DataInputStream to receive messages from the client
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                // Receive a message from the client
                message = dataInputStream.readUTF();

                // Get the current timestamp and format it
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);

                // Display the received message along with the current timestamp
                System.out.println("[" + formattedTime + "] Message from client: " + message);
            }

            // Close the serverSocket
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
