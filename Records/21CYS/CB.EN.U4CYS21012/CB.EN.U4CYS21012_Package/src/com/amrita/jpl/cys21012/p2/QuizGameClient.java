package com.amrita.jpl.cys21012.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class QuizGameClient extends QuizGame implements QuizGameListener {
    /**
     * Generic variables for the client
     */
    DataOutputStream dis1;
    DataInputStream dis2;

    Scanner scn = new Scanner(System.in);
    int pts = 0;

    public void onQuestionAsked(String a) {
        /**
         * Get question input and answer from user
         */
        String str = null;
        try {
            str = dis2.readUTF();
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (str != null){
            String yourAns = scn.nextLine();
            evaluateAnswer(yourAns);
        }
    }

    public void onAnswerEvaluated(boolean a){
        //Not applicable here
    }

    void startGame(){
        /**
         * Initialize sockets to start program
         */
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 12345);

            // Create a DataOutputStream to send messages to the server
            dis1 = new DataOutputStream(s.getOutputStream());
            dis2 = new DataInputStream(s.getInputStream());

            while (true){
                System.out.println("Enter 1 to ask a question, and anything else to print points and exit");
                int v = scn.nextInt();
                if (v == 1){
                    askQuestion();
                }
                else{
                    System.out.println("Your points are : "+pts);
                    s.close();
                }
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void askQuestion(){
        /**
         * Send input to server to get a question
         */
        try {
            dis1.writeUTF("Ask me a question.");
            dis1.flush();
            String str;
            while (true){
                str = dis2.readUTF();
                System.out.println(str);
                if (str != null){
                    break;
                }
            }
            if (str != null){
                System.out.println("Enter your answer: ");
                String yourAns = scn.next();
                System.out.println(yourAns);
                evaluateAnswer(yourAns);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void evaluateAnswer(String ans){
        /**
         * If answer is right, increment points
         */
        try {
            dis1.writeUTF(ans);
            String val = dis2.readUTF();
            System.out.println(val);

            if (val.equals("Good Job your answer is correct!")){
                pts += 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String args[]){
        QuizGameClient qgc = new QuizGameClient();
        qgc.startGame();
    }
}
