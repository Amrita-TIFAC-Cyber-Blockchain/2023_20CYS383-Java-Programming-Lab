/**
 * Package com.amrita.jpl.cys21046.practice.net contains classes for networking practice.
 */
package com.amrita.jpl.cys21046.practice.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * The chatc class is a client application that allows users to send messages to a server.
 * It establishes a connection with the server and sends messages until the user chooses to exit.
 *
 * @author Mukesh SA
 * @version 0.5
 */
public class chatc {

    /**
     * The main method is the entry point of the chatc application.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            // Create a socket and establish a connection with the server
            Socket socket = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Create a Scanner to read user input
            Scanner scanner = new Scanner(System.in);

            String message = "";

            // Loop until the user enters "exit"
            do {
                System.out.print("Enter a message (or 'exit' to quit): ");
                message = scanner.nextLine();

                // Send the message to the server
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));

            // Close the output stream and the socket
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
