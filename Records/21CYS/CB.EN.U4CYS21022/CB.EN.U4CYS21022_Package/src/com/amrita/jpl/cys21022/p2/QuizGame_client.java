package com.amrita.jpl.cys21022.p2;

/**
 @author:Harshitha
 -chat between server and client for a game.
 -server asks the questions here and client answers.
 -2 classes: QuizGame_sever and QuizGame_client.

 **/

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class QuizGame_client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2444);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Yes.Ready to start!");
            dout.writeUTF("I will go for level 2.");
            dout.flush();


            //dout.close();
            //s.close();
        } catch (IOException e) {
            System.out.println("An error occured" + e);
        }
    }
}

