package com.amrita.jpl.cys21009.p2;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * The Client of a Quiz Game which gets question from Server
 *
 * @author Aravind
 * @version 1
 */

public class QuizGameClient extends QuizGame{

    void startGame(){
        //no use in here
    }

    void askQuestion(){
        //no use in here
    }

    void evaluateAnswer(String answer) {
        //no use in here
    }

    void onQuestionAsked(String question){

    }

    void onAnswerEvaluated(boolean isCorrect){
        //no use in here
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 8080);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println("Connected to the Server.");
            String msg;
            msg = din.readUTF();
            System.out.println(msg);
            msg = din.readUTF();
            System.out.println(msg);
            String str =sc.next();
            dout.writeUTF(str);
            msg = din.readUTF();
            System.out.println(msg);
            dout.close();
            din.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
