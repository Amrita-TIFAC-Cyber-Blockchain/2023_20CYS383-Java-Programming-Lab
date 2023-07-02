package com.amrita.jpl.cys21009.p2;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * The Server of a Quiz Game which gives question to Client
 *
 * @author Aravind
 * @version 1
 */

class QuizGameServer extends QuizGame {
    public static String msg;
    public static String str;
    public static boolean val;
    void startGame() {
        msg="[Server] Game Started";
    }

    void askQuestion() {
        String[] ques={"1+2=?","2+3=?","3+4=?", "4+5=?", "5+6=?"};
        double random=Math.random()*5;
        int rand=(int)random;
        msg="[Server] "+ques[rand];
    }

    void evaluateAnswer(String answer) {
        switch(msg){
            case "[Server] 1+2=?":
                val= answer.equals("3");
                break;
            case "[Server] 2+3=?":
                val= answer.equals("5");
                break;
            case "[Server] 3+4=?":
                val= answer.equals("7");
                break;
            case "[Server] 4+5=?":
                val= answer.equals("9");
                break;
            case "[Server] 5+6=?":
                val= answer.equals("11");
                break;
        }
        /**
         *
         * @param answer Holds the answer given by user
         * @param val Holds boolean value which says if the answer is correct or incorrect
         */
    }

    void onQuestionAsked(String question){
        //no use in here
    }

    void onAnswerEvaluated(boolean isCorrect){
        if(isCorrect){
            msg="[Server] The Answer is correct!";
        }
        else{
            msg="[Server] The Answer is incorrect!";
        }

    }
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("Waiting for client connection...");
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Client connected.");
            System.out.println("Waiting for Client Answer");
            QuizGameServer ob = new QuizGameServer();
            ob.startGame();
            dout.writeUTF(msg);
            ob.askQuestion();
            dout.writeUTF(msg);

            str=din.readUTF();
            ob.evaluateAnswer(str);
            ob.onAnswerEvaluated(val);
            System.out.println("[Client] Answer="+str);
            if(val){
                System.out.println("Correct Answer by Client!");
            }else{
                System.out.println("Incorrect Answer by Client!");
            }
            dout.writeUTF(msg);
            din.close();
            dout.close();
            ss.close();
        }catch (IOException e){
            System.out.println("An error occurred: "+e);
        }
    }
}
