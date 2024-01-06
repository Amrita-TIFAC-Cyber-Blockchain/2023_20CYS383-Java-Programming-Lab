package com.amrita.jpl.cys21061.pract.QuizGameUI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizGameServer1 extends QuizGameUI {
    private Socket cs1;
    private Socket cs2;

    private QuizGameListener1 listener;

    public QuizGameServer1() {
        this.listener = listener;
    }

    public void startGame() throws IOException {
        ServerSocket ss = new ServerSocket(2444);
        cs1 = ss.accept();
        cs2 = ss.accept();
    }

    public void askQuestion() {
        try {
            DataOutputStream dout = new DataOutputStream(cs1.getOutputStream());
            dout.writeUTF("Your question goes here");
            dout.flush();
        } catch (IOException e) {
            System.out.println("Error sending question to client 1.");
            e.printStackTrace();
        }
    }

    public void evaluateAnswer(String[] answer) {
        boolean isCorrect = true; // Replace with your answer evaluation logic
        if (isCorrect) {
            System.out.println("Yay!!");
            listener.onAnswerEvaluated(true);
        } else {
            System.out.println("nay :(");
            listener.onAnswerEvaluated(false);
        }
    }
}
