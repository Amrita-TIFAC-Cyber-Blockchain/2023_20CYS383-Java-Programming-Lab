package com.amrita.jpl.cys21027.practice.net;

/**
 * The SimpleClient class represents a simple client program.
 * It connects to a server on the specified host and port, sends a message, and closes the connection.
 * This class demonstrates basic network programming using sockets.
 *
 *
 * @author Karaka Sri Sai Nitin
 */

import java.io.*;
import java.net.*;

public class SpecialClient {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket("localhost", 2744); // Connect to server on localhost, port 8080
            System.out.println("Connected to server.");

            // Initialize communication streams
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput;

            // Conversation loop
            while ((userInput = stdIn.readLine()) != null) {
                // Send user input to the server
                out.println(userInput);

                // Check if client wants to exit
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Client has exited.");
                    break;
                }

                // Receive and print server's response
                String serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);

                // Check if server wants to exit
                if (serverResponse.equalsIgnoreCase("exit")) {
                    System.out.println("Server has exited.");
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to localhost");
            System.exit(1);
        } finally {
            // Cleanup resources
            out.close();
            in.close();
            clientSocket.close();
        }
    }
}