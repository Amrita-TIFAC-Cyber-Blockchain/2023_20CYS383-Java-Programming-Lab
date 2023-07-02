package com.amrita.jpl.cys21005.pract.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The SimpleClient class represents a simple client program.
 * It connects to a server on the specified host and port, sends a message, and closes the connection.
 * This class demonstrates basic network programming using sockets.
 *
 * Note: This is a simple example and does not handle advanced error handling or response handling from the server.
 *
 * Usage:
 * - Run the SimpleServer program to start the server.
 * - Run the SimpleClient program to connect to the server and send a message.
 * - The server receives the message and prints it to the console.
 * - The client program then closes the connection.
 *
 * Note: The server must be running before executing the client program.
 *
 * To change the host and port, modify the arguments of the Socket constructor.
 *
 * @author Alagu Soundarya G
 * @version 1.0
 */
public class SimpleClient {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);


            // Create a DataInputStream to receive messages from the server
            DataInputStream dis = new DataInputStream(s.getInputStream());
            // Send a message to the server
            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            String message, str;

            // Send a message to the server
            do{
                System.out.println("Type your message: ");
                message = input.nextLine();
                dout.writeUTF(message);
                dout.flush();
                if(!message.equals("EXIT")){
                    str = dis.readUTF();
                    System.out.println("Message Received: " + str);
                }
            }while(!message.equals("EXIT"));


            // Close the output stream and the socket
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}