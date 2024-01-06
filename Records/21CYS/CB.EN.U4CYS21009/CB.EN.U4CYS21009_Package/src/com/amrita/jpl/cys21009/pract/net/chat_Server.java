package com.amrita.jpl.cys21009.pract.net;

import java.io.*;
import java.net.*;
import java.util.*;

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
 * @author Aravind
 * @version 1
 */
public class chat_Server {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();
            /**
             * @param ss Server Socket Variable
             * @param s Socket Variable
             * @param dout Data Output Stream
             * @param din Data Input Stream
             */

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Create a DataOutputStream to send messages to the client.
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str;
            String msg = "0";

            /**
             * @param msg Server input message
             * @param str Client mesasge
             */
            System.out.println("Client connected.");
            // Read the message from the client using Do-While loop.
            do{
                if(!msg.equals("exit")) {
                    str = dis.readUTF();
                    System.out.println("Client Message: " + str);
                    msg = sc.nextLine();
                    dout.writeUTF(msg);
                    dout.flush();
                }
                else{
                    ss.close();
                    break;
                }
            }
            while(true);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
