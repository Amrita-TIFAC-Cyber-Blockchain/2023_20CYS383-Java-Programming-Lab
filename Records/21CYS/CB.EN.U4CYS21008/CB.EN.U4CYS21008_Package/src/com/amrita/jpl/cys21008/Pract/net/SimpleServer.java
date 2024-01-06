package com.amrita.jpl.cys21008.Pract.net;

import java.io.*;
import java.net.*;

/**
 * A simple server program that listens for client connections and receives messages from clients.
 * @author: Anuvarshini M K
 */
public class SimpleServer {
    /**
     * Main method to run the server program.
     *
     * @param args  command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Waiting for a client to connect...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Get client information
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());

            // Read messages from the client
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = dataInputStream.readUTF();
                System.out.println("Received from client: " + message);
            }

            // Close the server socket
            serverSocket.close();
            System.out.println("Server socket closed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
