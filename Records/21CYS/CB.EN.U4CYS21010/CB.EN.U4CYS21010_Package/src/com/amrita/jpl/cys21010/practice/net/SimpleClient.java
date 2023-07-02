package com.amrita.jpl.cys21010.practice.net;
import java.io.*;
import java.net.*;
import java.util.Scanner;



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

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);
            // Send a message to the server
            /**
             * loop to send msg
             */
            while(true) {
                System.out.println("Enter msg to Send:-");
                String str = scan.nextLine();

                dout.writeUTF(str);
                if (str.equals("EXIT")){
                    System.out.println("Stopping  the Server !!!");
                    break;
                }
                dout.flush();
            }
            // Close the output stream and the socket
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}