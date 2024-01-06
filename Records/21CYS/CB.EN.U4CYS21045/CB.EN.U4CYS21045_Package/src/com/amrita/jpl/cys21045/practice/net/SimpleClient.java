package com.amrita.jpl.cys21045.practice.net;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @author Dharmik S
 * @version 0.5
 */
/**
 * The SimpleClient class represents a simple client application that sends messages to a server.
 * It connects to a server socket and sends messages entered by the user through the command line.
 */
public class SimpleClient {

    /**
     * The main method is the entry point of the client application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2444);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                System.out.print("Enter a message (or 'exit' to quit): ");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            } while (!message.equalsIgnoreCase("exit"));
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}