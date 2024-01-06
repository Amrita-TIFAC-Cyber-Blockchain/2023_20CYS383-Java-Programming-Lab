package com.amrita.jpl.cys21023.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String clientmsg;

            do {
                clientmsg = input.nextLine();
                // Send a message to the server
                dout.writeUTF(clientmsg);
                dout.flush();

                // Read the message from the client
                String str = dis.readUTF();
                System.out.println("Message: " + str);
            } while (!clientmsg.equals("exit"));

            // Close the output stream and the socket
            dis.close();
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
