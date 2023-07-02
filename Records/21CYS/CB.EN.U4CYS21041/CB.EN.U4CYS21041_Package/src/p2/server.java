package com.amrita.jpl.cys21041.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public server() {
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2444);
            Socket s = ss.accept();
            System.out.println("Client Connected");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            String temp;
            do {
                String str = dis.readUTF();
                System.out.println("Client : " + str);
                temp = sc.nextLine();
                dout.writeUTF(temp);
                dout.flush();
            } while(!temp.equals("EXIT"));

            dout.close();
            ss.close();
        } catch (IOException var8) {
            System.out.println("An error occurred: " + var8);
        }

    }
}
