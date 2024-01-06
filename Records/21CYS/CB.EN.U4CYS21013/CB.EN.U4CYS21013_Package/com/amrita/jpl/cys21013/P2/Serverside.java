package com.amrita.jpl.cys21013.P2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: ROHITH
 * Version: 1.0
 * An abstract class representing a quiz game.
 */
abstract class QuizGame {
    /**
     * Starts the game.
     */
    void startGame(){
        System.out.println("Game Started");
    }

    /**
     * Asks a question.
     */
    abstract void askQuestion();

    /**
     * Evaluates the answer.
     * @param answer The answer provided by the player.
     */
    abstract void evaluateAnswer(String answer);
}

/**
 * A listener interface for quiz game events.
 */
interface QuizGameListener {
    /**
     * Called when a question is asked.
     * @param question The question asked.
     */
    void onQuestionAsked(String question);

    /**
     * Called when an answer is evaluated.
     * @param isCorrect Indicates whether the answer is correct or not.
     */
    void onAnswerEvaluated(boolean isCorrect);
}

/**
 * A server class for the quiz game.
 */
class QuizGameServer extends QuizGame {
    public static String msg;
    public static String str;
    public static boolean val;

    /**
     * Starts the game.
     */
    void startGame() {
        msg = "[Server] Game Started";
    }

    /**
     * Asks a question.
     */
    void askQuestion() {
        String[] ques = {"what is the largest planet in our solar system?", "1+1=", "how many stars are in our solar system?", "how many stars are in our galaxy?", "which country does river Ganga flow in?"};
        double random = Math.random() * 5;
        int rand = (int) random;
        msg = "[Server] " + ques[rand];
    }

    /**
     * Evaluates the answer.
     * @param answer The answer provided by the client.
     */
    void evaluateAnswer(String answer) {
        switch (msg) {
            case "[Server] what is the largest planet in our solar system?":
                val = answer.equalsIgnoreCase("Jupiter");
                break;
            case "[Server] 1+1=":
                val = answer.equalsIgnoreCase("2");
                break;
            case "[Server] how many stars are in our solar system?":
                val = answer.equalsIgnoreCase("1");
                break;
            case "[Server] how many stars are in our galaxy?":
                val = answer.equalsIgnoreCase("Infinite");
                break;
            case "[Server] which country does river Ganga flow in?":
                val = answer.equalsIgnoreCase("India");
                break;
        }
    }

    /**
     * Called when a question is asked.
     * @param question The question asked.
     */
    void onQuestionAsked(String question) {
        // No need to implement here
    }

    /**
     * Called when an answer is evaluated.
     * @param isCorrect Indicates whether the answer is correct or not.
     */
    void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            msg = "[Server] The Answer is correct!";
        } else {
            msg = "[Server] The Answer is incorrect!";
        }
    }

    public static void main(String[] args) {
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

            str = din.readUTF();
            ob.evaluateAnswer(str);
            ob.onAnswerEvaluated(val);
            System.out.println("[Client] Answer=" + str);
            if (val) {
                System.out.println("Correct Answer by Client!");
            } else {
                System.out.println("Incorrect Answer by Client!");
            }
            dout.writeUTF(msg);
            din.close();
            dout.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
