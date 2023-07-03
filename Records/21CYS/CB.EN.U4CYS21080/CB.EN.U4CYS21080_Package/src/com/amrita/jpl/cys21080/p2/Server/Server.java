package com.amrita.jpl.cys21080.p2.Server;

import java.util.*;
import java.io.*;
import java.net.*;


/**
 * @author T Pavan Kumar Reddy
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

class Server extends QuizGame {
    public static String msg;
    public static String str;
    public static boolean val;
    void startGame() {
        msg="[Server] Game Started";
    }

    void askQuestion() {
        String[] ques={"Which is most populated country in the World?","Is 1000 a Perfect Square?","Which state has highest literacy rate in India?", "Which is largest state in India?", "Where is grand canyon of India located?"};
        double random=Math.random()*5;
        int rand=(int)random;
        msg="[Server] "+ques[rand];
    }

    void evaluateAnswer(String answer) {
        switch(msg){
            case "[Server] Which is most populated country in the World?":
                val= answer.equals("India");
                break;
            case "[Server] Is 1000 a Perfect Square?":
                val= answer.equals("no");
                break;
            case "[Server] Which state has highest literacy rate in India?":
                val= answer.equals("Kerala");
                break;
            case "[Server] Which is largest state in India?":
                val= answer.equals("Rajasthan");
                break;
            case "[Server] Where is grand canyon of India located?":
                val= answer.equals("Gandikota");
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
            Server ob = new Server();
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