package com.amrita.jpl.cys21044.p2.client;
/**
* @author ravi
 * @version 1.0
 */
import java.util.*;
import java.io.*;
import java.net.*;


abstract class QuizGame {
    void startGame(){
        System.out.println("Game Started");
    }
    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener{
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameClient extends QuizGame{

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