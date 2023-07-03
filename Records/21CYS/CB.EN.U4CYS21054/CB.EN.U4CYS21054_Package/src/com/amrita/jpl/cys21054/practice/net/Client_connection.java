package com.amrita.jpl.cys21054.practice.net;


import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * The TCPClient class represents the client side of the TCP client-server application.
 * It connects to the server and sends requests.
 */
public class Client_connection {

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

            // Create a scanner to read user input
            Scanner scanner = new Scanner(System.in);

            // Continuous interaction with the server until "exit" is entered
            while (true) {
                // Prompt the user for input
                System.out.print("Enter your message: ");
                String message = scanner.nextLine();

                // Send request to the server
                outToServer.writeBytes(message + '\n');
                System.out.println("Sent to server: " + message);

                System.out.println("Message sent to Server successfully");

                if (message.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if "exit" is entered
                }
            }

            // Close the client socket and scanner
            clientSocket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

