package com.amrita.jpl.cys21062.p2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient() {
        server = new QuizGameServer(this);
    }

    @Override
    protected void askQuestion() {
        // No implementation needed for the client
    }

    @Override
    protected void evaluateAnswer(String answer) {
        // No implementation needed for the client
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        System.out.println("Answer: " + (isCorrect ? "Correct" : "Incorrect"));
    }

    public void startGame() {
        server.startGame();
    }

    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
