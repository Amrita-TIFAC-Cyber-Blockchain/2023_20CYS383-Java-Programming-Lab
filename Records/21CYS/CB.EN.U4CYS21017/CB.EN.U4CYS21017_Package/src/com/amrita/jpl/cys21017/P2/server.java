package com.amrita.jpl.cys21017.p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


abstract class QuizGame{

    void startGame(){
        askQuestion();
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener{

    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}
class QuizGameServer extends QuizGame {

    @Override
    void startGame() {

//        try {
//            // Create a DataOutputStream to send messages to the server
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//            // Send a message to the server
//            dout.writeUTF("Game begins!");
//            dout.flush();
//
//            dout.close();
//        } catch (){
//
//        }


    }

    @Override
    void askQuestion() {

        String q1 = "What's the capital of India?";

//        try {
//            // Create a DataOutputStream to send messages to the server
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//            // Send a message to the server
//            dout.writeUTF("What's the capital of India?");
//            dout.flush();
//            dout.close();
//        } catch (){
//
//        }


    }

    @Override
    void evaluateAnswer(String answer) {
        // Create a DataInputStream to receive messages from the client
        //DataInputStream dis = new DataInputStream(s.getInputStream());

        // Read the message from the client
        //String str = dis.readUTF();

        //if(str == "Delhi"){
        //    System.out.println("Correct");
        //}
        //else {
        //    System.out.println("Better luck next time");
        //}


    }

}

public class server {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Created a server socket
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a connection to be established
            Socket s = ss.accept();
            System.out.println("Connected to server!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
