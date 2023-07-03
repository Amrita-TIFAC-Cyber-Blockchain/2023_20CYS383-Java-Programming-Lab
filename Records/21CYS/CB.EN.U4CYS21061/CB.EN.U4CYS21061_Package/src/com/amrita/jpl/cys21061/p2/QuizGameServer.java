package com.amrita.jpl.cys21061.p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizGameServer extends QuizGame {
    /**
     * Instantiates the methods for server when called
     * @param ss,cs1, cs2
     */
    private Socket cs1;
    private Socket cs2;

    public void startGame() throws IOException {
        ServerSocket ss = new ServerSocket(2444);
        cs1 = ss.accept();
        cs2 = ss.accept();
    }
    /**
     * Question to the client
     */
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
    /**
     * Gives Solution results
     */
    public void evaluateAnswer(String[] answer) {
        boolean isCorrect = true; // Replace with your answer evaluation logic
        if (isCorrect) {
            System.out.println("Yay!!");
        } else {
            System.out.println("nay :(");
        }
    }
}
