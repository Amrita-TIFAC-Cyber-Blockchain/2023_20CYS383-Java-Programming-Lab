/**
 * @author Nishant V
 * @param - none
 */
package com.amrita.jpl.cys21049.pract.net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleServer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(2444);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str;
            String msg = "0";
            System.out.println("Receiving Messages from the client.");
            do{
                if(!msg.equals("exit")) {
                    str = dis.readUTF();
                    System.out.println("Client Message: " + str);
                    System.out.print("Enter a Message: ");
                    msg = input.nextLine();
                    dout.writeUTF(msg);
                    dout.flush();
                }
            }
            while(true);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}