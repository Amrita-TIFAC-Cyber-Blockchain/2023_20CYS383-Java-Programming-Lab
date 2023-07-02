package com.amrita.jpl.cys21004.practice.net;

/**
 * @author Aishwarya GS
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    /**
     * Chat Server
     * @param cmd lines
     */

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2444);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            Scanner console = new Scanner(System.in);

            while(true) {

                String str = dis.readUTF();
                System.out.println("Message: " + str);

                if(str.equals("Exit"))
                    break;

                String reader = console.nextLine();
                dout.writeUTF(reader);
                dout.flush();

            }

            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}

