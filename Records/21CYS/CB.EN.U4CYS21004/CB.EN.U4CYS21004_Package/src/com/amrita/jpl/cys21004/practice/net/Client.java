package com.amrita.jpl.cys21004.practice.net;

/**
 * @author Aishwarya GS
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    /**
     * Chat Client
     * @param cmd lines
     */

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2444);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            DataInputStream dis = new DataInputStream(s.getInputStream());

            Scanner console = new Scanner(System.in);
            String str;
            do {

                String reader = console.nextLine();
                dout.writeUTF(reader);
                dout.flush();

                str = dis.readUTF();
                System.out.println("Message: " + str);

            } while(str.equals("Exit"));

            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
