package com.amrita.jpl.cys21017.pract.chat;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class simpleserver {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();
            System.out.println("Connected to server!");

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String smsg;

            do{
                // Read the message from the client
                String str = dis.readUTF();
                System.out.println("Message: " + str);

                smsg = input.nextLine();

                // Send a message to the server
                dout.writeUTF(smsg);
                dout.flush();
            }while (!smsg.equals("exit"));

            // Close the server socket
            dis.close();
            dout.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}

