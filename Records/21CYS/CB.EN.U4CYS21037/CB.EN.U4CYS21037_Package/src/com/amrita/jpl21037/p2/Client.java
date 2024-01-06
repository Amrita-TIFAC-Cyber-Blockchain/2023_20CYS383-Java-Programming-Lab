package com.amrita.jpl21037.p2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2444);
            Scanner sc = new Scanner(System.in);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str;
            do {
                String temp = sc.nextLine();
                dout.writeUTF(temp);
                dout.flush();
                str = dis.readUTF();
                System.out.println("Server : " + str);
            } while(!str.equals("EXIT"));

            dout.close();
            s.close();
        } catch (IOException var7) {
            System.out.println("An error occurred: " + var7);
        }

    }
}