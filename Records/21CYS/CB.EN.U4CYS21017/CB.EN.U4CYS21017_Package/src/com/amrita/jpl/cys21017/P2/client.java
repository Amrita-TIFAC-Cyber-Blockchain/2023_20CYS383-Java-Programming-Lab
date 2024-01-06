package com.amrita.jpl.cys21017.p2;

//import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

abstract class QuizGameC{
   void startGame(){
        askQuestion();
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

interface QuizGameListenerClient{

    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}
//class QuizGameClient extends QuizGameC {
//    @Override
//    void startGame() {
//        try {
//            Scanner input = new Scanner(System.in);
//
//            // Created a socket
//            Socket s = new Socket("localhost", 2444);
//
//        } catch (IOException e) {
//            System.out.println("An error occurred: " + e);
//        }
//    }
//
//    @Override
//    void askQuestion() {
//
//        try {
//            Scanner input = new Scanner(System.in);
//
//            // Create a DataOutputStream to send messages to the server
//            HttpClient s = null;
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//            // Create a DataInputStream to receive messages from the client
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//
//            String cmsg;
//
//            // Read the message from the client
//            String str = dis.readUTF();
//            System.out.println("Message: " + str);
//
//            cmsg = input.nextLine();
//
//            // Send a message to the server
//            dout.writeUTF(cmsg);
//            dout.flush();
//
//            // Close the output stream and the socket
//            dis.close();
//            dout.close();
//
//        } catch (){
//
//        }
//
//    }
//
//    @Override
//    void evaluateAnswer(String answer) {
//
//        Scanner input = new Scanner(System.in);
//
//        // Create a DataOutputStream to send messages to the server
//        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//        // Create a DataInputStream to receive messages from the client
//        DataInputStream dis = new DataInputStream(s.getInputStream());
//
//        String cmsg;
//
//        cmsg = input.nextLine();
//        // Send a message to the server
//        dout.writeUTF(cmsg);
//        dout.flush();
//
//        // Read the message from the client
//        String str = dis.readUTF();
//        System.out.println("Message: " + str);
//
//        // Close the output stream and the socket
//        dis.close();
//        dout.close();
//    }
//}
   public class client{
        public static void main(String[] args) {

        }

    }

