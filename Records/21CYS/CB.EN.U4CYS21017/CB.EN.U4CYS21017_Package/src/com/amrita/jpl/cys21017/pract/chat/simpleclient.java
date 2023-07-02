package com.amrita.jpl.cys21017.pract.chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class simpleclient {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
            try {
                Scanner input = new Scanner(System.in);
                
                // Create a socket and connect to the server at "localhost" on port 2444
                Socket s = new Socket("localhost", 2444);

                // Create a DataOutputStream to send messages to the server
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                // Create a DataInputStream to receive messages from the client
                DataInputStream dis = new DataInputStream(s.getInputStream());

                String cmsg;

                do {
                    cmsg = input.nextLine();
                    // Send a message to the server
                    dout.writeUTF(cmsg);
                    dout.flush();

                    // Read the message from the client
                    String str = dis.readUTF();
                    System.out.println("Message: " + str);
                } while (!cmsg.equals("exit"));

                // Close the output stream and the socket
                dis.close();
                dout.close();
                s.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e);
            }
    }
}
