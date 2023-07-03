package com.amrita.jpl.cys21078.pract.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * SimpleServer is a server program that accepts client connections and exchanges messages with the client.
 * @author suvetha
 * @Version 0.1
 */
public class SimpleServer {
    /**
     * The main method that starts the server.
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

