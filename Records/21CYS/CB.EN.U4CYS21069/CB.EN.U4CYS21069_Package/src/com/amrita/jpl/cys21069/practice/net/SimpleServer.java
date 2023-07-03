package com.amrita.jpl.cys21069.practice.net;


import java.io.*;
import java.net.*;
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
 * - The server receives the messages and prints them to the console.
 *
 *
 * @author Seran Pandiyan I P
 * @version 0.1
 */
public class SimpleServer {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Create a DataOutputStream to send messages to the client.
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str;
            String msg = "0";
            System.out.println("Receiving Messages from the client.");
            // Read the message from the client using Do-While loop.
            do{
                if(!msg.equals("exit")) { // checks if the server reply is not empty then proceeds to receive the msg from client.
                    str = dis.readUTF();
                    System.out.println("Client Message: " + str);
                    System.out.print("Enter a Message: ");
                    msg = input.nextLine();
                    dout.writeUTF(msg);
                    dout.flush();
                }
            }
            while(true);


            // Close the server socket
            //ss.close(); // server socket is not closed even after the client socket is closed and it's always listening.
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
