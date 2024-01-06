/**
 * @author Nishant V
 * @param - none
 */


package com.amrita.jpl.cys21049.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class SimpleClient {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 2444);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println("Sending message to the Server.");
            String msg;
            do {
                System.out.print("Enter a Message: ");
                String str = input.nextLine();
                dout.writeUTF(str);
                dout.flush();
                msg = din.readUTF();
                System.out.println("Server: " + msg);
                if(msg.equals("exit")) {
                    System.out.println("Connection closed.");
                    dout.close();
                    din.close();
                    s.close();
                }
            } while (!msg.equals("exit"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}