package com.amrita.jpl.cys21022.p2;

/**
 @author:Harshitha
 -chat between server and client for a game.
 -server asks the questions here and client answers.
 -2 classes: QuizGame_sever and QuizGame_client.

 **/

import java.io.*;
import java.net.*;

public class QuizGame_server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2444);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream (s.getInputStream());
            String str = dis.readUTF();
            System.out.println("Are you ready to start?" + "   " + str);
            System.out.println("Choose the level: 1,2 or 3?" + "   " + str);
            //ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
