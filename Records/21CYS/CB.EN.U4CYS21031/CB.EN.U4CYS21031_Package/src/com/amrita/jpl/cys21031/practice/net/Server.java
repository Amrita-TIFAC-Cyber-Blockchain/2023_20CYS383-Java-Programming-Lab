package com.amrita.jpl.cys21031.practice.net;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 * Note: This is a simple example and does not handle multiple clients or advanced error handling.
 *
 * Usage:
 * - Run the SimpleServer program.
 * - Connect to the server using a client program and send a message.
 * - The server receives the message and prints it to the console.
 * - The server then closes the connection.
 *
 * @author Kishanth K
 * @version 0.5
 */
class SimpleServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("com.amrita.jpl.cys21031.p2.Client connected.");
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("com.amrita.jpl.cys21031.p2.Client IP address: " + clientAddress.getHostAddress());
            System.out.println("com.amrita.jpl.cys21031.p2.Client port number: " + clientPort);
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
            System.out.println("com.amrita.jpl.cys21031.p2.Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}

