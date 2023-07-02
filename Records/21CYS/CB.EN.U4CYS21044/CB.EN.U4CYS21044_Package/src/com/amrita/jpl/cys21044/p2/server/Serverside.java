package com.amrita.jpl.cys21044.p2.server;

import java.util.*;
import java.io.*;
import java.net.*;


/**
 * @author ravi
 * @version 1.0
 */


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

class QuizGameServer extends QuizGame {
    public static String msg;
    public static String str;
    public static boolean val;
    void startGame() {
        msg="[Server] Game Started";
    }

    void askQuestion() {
        String[] ques={"what is captial of India?","is 6 perfectsquare","how many states are there in India?", "which is largest continent?", " who is the PM of India?"};
        double random=Math.random()*5;
        int rand=(int)random;
        msg="[Server] "+ques[rand];
    }

    void evaluateAnswer(String answer) {
        switch(msg){
            case "[Server] what is captial of India?":
                val= answer.equals("Delhi");
                break;
            case "[Server] is 6 perfectsquare":
                val= answer.equals("no");
                break;
            case "[Server] how many states are there in India?":
                val= answer.equals("29");
                break;
            case "[Server] which is largest continent?":
                val= answer.equals("Asia");
                break;
            case "[Server] who is the PM of India?":
                val= answer.equals("Modi");
                break;
        }
        /**
         * @param answer - answer given by client
         * @param val -  stores answer is correct or incorrect
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
            System.out.println("Waiting for client...");
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