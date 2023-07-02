package com.amrita.jpl.cys21020.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Hemesh sai
 * @version 1.0
 * The Client class represents a client that communicates with a server using sockets.
 */
public class Client {
    /**
     * Constructs a new Client object.
     */
    public Client() {
    }

    /**
     * The main method that runs the client application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 2444
            Socket socket = new Socket("localhost", 2444);

            // Create a scanner to read user input
            Scanner scanner = new Scanner(System.in);

            // Create input and output streams to communicate with the server
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message;
            do {
                // Read user input
                String input = scanner.nextLine();

                // Send the user input to the server
                outputStream.writeUTF(input);
                outputStream.flush();

                // Receive a response from the server
                message = inputStream.readUTF();
                System.out.println("Server: " + message);
            } while (!message.equals("EXIT"));

            // Close the input and output streams
            outputStream.close();

            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
