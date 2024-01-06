package com.amrita.jpl.cys21013.P2;

import com.amrita.jpl.cys21013.P2.QuizGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * A client class for the quiz game.
 * Author: ROHITH
 * Version: 1.0
 */
class QuizGameClient extends QuizGame {

    /**
     * Starts the game (not used in this class).
     */
    void startGame() {
        // No use in here
    }

    /**
     * Asks a question (not used in this class).
     */
    void askQuestion() {
        // No use in here
    }

    /**
     * Evaluates the answer (not used in this class).
     * @param answer The answer provided by the player.
     */
    void evaluateAnswer(String answer) {
        // No use in here
    }

    /**
     * Called when a question is asked (not used in this class).
     * @param question The question asked.
     */
    void onQuestionAsked(String question) {
        // No use in here
    }

    /**
     * Called when an answer is evaluated (not used in this class).
     * @param isCorrect Indicates whether the answer is correct or not.
     */
    void onAnswerEvaluated(boolean isCorrect) {
        // No use in here
    }

    /**
     * Main method to connect to the server, communicate, and receive game messages.
     * @param args Command line arguments (not used in this class).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            String str = sc.next();
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
