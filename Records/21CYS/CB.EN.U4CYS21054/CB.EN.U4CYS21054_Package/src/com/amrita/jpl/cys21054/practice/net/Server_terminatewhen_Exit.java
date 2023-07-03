package com.amrita.jpl.cys21054.practice.net;

import java.io.*;
import java.net.*;

/**
 * The TCPServer class represents the server side of the TCP client-server application.
 * It listens for client connections and processes client requests.
 */
public class Server_terminatewhen_Exit {

    /**
     * The main method is the entry point of the server application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 4424
            ServerSocket serverSocket = new ServerSocket(4424);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create input and output streams for client communication
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Process client requests until "exit" is received
                String clientRequest;
                while ((clientRequest = inFromClient.readLine()) != null) {
                    System.out.println("Received from client: " + clientRequest);

                    if (clientRequest.equalsIgnoreCase("exit")) {
                        break; // Exit the loop if "exit" is received
                    }
                }

                // Close client connection
                clientSocket.close();
                break; // Exit the server loop
            }

            // Close the server socket
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

