package com.ramaguru.amrita.cys.jpl.net;

import java.io.*;
import java.net.*;

/**
 * The TCPClient class represents the client side of the TCP client-server application.
 * It connects to the server and sends requests.
 */
public class TCPClient {

    /**
     * The main method is the entry point of the client application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 4424
            Socket clientSocket = new Socket("localhost", 4424);

            // Create input and output streams for client communication
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            // Send request to the server
            String request = "Hello, server!";
            outToServer.writeBytes(request + '\n');
            System.out.println("Sent to server: " + request);

            // Receive response from the server
            String response = inFromServer.readLine();
            System.out.println("Received from server: " + response);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
