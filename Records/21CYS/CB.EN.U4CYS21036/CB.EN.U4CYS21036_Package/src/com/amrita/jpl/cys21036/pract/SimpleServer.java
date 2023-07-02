package com.amrita.jpl.cys21036.pract;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleServer {

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