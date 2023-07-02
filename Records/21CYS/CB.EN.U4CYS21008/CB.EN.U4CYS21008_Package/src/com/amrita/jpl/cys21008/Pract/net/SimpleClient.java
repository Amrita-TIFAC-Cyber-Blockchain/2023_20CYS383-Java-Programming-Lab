package com.amrita.jpl.cys21008.Pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * A simple client program that connects to a server and sends messages.
 * @author: Anuvarshini M K
 */
public class SimpleClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 2444;

    /**
     * Main method to run the client program.
     *
     * @param args  command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read user input
            Scanner scanner = new Scanner(System.in);
            String message;

            // Send messages to the server until 'exit' is entered
            do {
                System.out.print("Enter a message: ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));

            // Close the connections
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}

