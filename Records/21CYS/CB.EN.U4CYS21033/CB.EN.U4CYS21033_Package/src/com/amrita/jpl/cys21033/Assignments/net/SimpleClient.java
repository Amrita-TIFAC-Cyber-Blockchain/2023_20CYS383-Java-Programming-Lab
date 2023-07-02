package com.amrita.jpl.cys21033.Assignments.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * This class represents a simple client that connects to a server and sends messages.
 * It uses a socket connection and DataOutputStream to send messages to the server.
 * The client can enter messages through the command line.
 * The client can exit by entering the message 'exit'.
 *
 * @author Suhitha
 * @version 0.5
 */
public class SimpleClient {

    /**
     * The main method of the client application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 2444
            Socket socket = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Create a scanner to read user input from the command line
            Scanner scanner = new Scanner(System.in);

            String message = "";
            do {
                // Prompt the user to enter a message or 'exit'
                System.out.print("Enter a message or 'exit': ");
                message = scanner.nextLine();

                // Send the message to the server
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));

            // Close the dataOutputStream and socket
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
