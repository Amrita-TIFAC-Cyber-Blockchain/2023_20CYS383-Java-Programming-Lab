package com.amrita.jpl.cys21027.practice.net;
/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 *
 * @author Karaka Sri Sai Nitin
 */
import java.io.*;
import java.net.*;

public class SpecialServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        BufferedReader stdIn = null;
        try {
            serverSocket = new ServerSocket(2744); // Choose any available port
            System.out.println("Server started. Listening on port 2744...");

            clientSocket = serverSocket.accept(); // Wait for client connection
            System.out.println("Client connected.");

            // Initialize communication streams
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Conversation loop
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);

                // Check if client wants to exit
                if (inputLine.equalsIgnoreCase("exit")) {
                    System.out.println("Client has exited.");
                    break;
                }

                // Read server's response from console
                System.out.print("Server: ");
                String response = stdIn.readLine();

                // Send response to the client
                out.println(response);

                // Check if server wants to exit
                if (response.equalsIgnoreCase("exit")) {
                    System.out.println("Server has exited.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cleanup resources
            out.close();
            in.close();
            stdIn.close();
            clientSocket.close();
            serverSocket.close();
        }
    }
}


