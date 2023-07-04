package com.amrita.jpl.cys21066.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleServer {
    public SimpleServer() {
    }

    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket serverSocket = new ServerSocket(2444);

            // Print a message indicating that the server is waiting for a client to connect
            System.out.println("Waiting for a client to connect...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Print a message indicating that the client has connected
            System.out.println("Client connected.");

            // Get the client's IP address and port number
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());
            System.out.println("Client port number: " + clientPort);

            // Create a data input stream to receive data from the client
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

            // Initialize a variable to store the received message
            String message = "";

            // Read messages from the client until "exit" is received
            while (!message.equalsIgnoreCase("exit")) {
                // Read the message from the data input stream
                message = dataInputStream.readUTF();

                // Get the current time and format it
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);

                // Print the received message and the current time
                System.out.println("[" + formattedTime + "] Message from client: " + message);
            }

            // Close the server socket
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException var10) {
            // Handle any IO errors that occur
            System.out.println("An error occurred: " + var10);
        }
    }
}
