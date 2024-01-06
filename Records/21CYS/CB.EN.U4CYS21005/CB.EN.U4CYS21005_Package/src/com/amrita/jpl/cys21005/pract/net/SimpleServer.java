package com.amrita.jpl.cys21005.pract.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 * Note: This is a simple example and does not handle multiple clients or advanced error handling.
 *
 * Usage:
 * - Run the SimpleServer program.
 * - Connect to the server using a client program and send a message.
 * - The server receives the message and prints it to the console.
 * - The server then closes the connection.
 *
 * @author Alagu Soundarya G
 * @version 1.0
 */
public class SimpleServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);


            // Wait for a client to establish a connection
            Socket s = ss.accept();
            String str, reply;
            Scanner msg = new Scanner(System.in);

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            // Create a DataOutputStream to send messages to client
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            do {
                // Read the message from the client
                str = dis.readUTF();
                System.out.println("Message Received: " + str);
                if(!str.equals("EXIT")){
                    //Replying to the server
                    System.out.println("Type your reply: ");
                    reply = msg.nextLine();
                    dout.writeUTF(reply);
                    dout.flush();
                }
            }while(!str.equals("EXIT"));

            System.out.println("TERMINATED.");

            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}