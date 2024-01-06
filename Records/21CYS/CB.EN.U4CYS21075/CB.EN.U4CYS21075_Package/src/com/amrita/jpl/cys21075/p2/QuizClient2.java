package com.amrita.jpl.cys21075.p2;

import java.io.*;
import java.net.*;
import java.util.*;



class QuizGameClientUser2 extends QuizGame{

    @Override
    public void askQuestion() {

    }

    @Override
    public void evaluateAnswer(String answer) {

    }
}
public class QuizClient2 implements QuizGameListener{

    public static void main(String args[]){
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2445);
            Scanner sc = new Scanner(System.in);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            QuizGame temp = new QuizGameClientUser();
            temp.startGame();
            String tem;
            String str;
            int n = 1;

            do {
                str = dis.readUTF();
                System.out.println("Q.) "+str);


                // Send a message to the server
                tem = sc.nextLine();
                dout.writeUTF(tem);
                dout.flush();
                n++;
                if(n==6){
                    break;
                }

                // Close the output stream and the socket
            }while(!str.equals("END"));
            dout.close();

            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }


    @Override
    public void onQuestionAsked(String question) {

    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {

    }
}


