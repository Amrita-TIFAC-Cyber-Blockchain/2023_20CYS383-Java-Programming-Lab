package com.amrita.jpl.cys21030;

import java.util.Scanner;

/***Author - Sai Suvarchala
 * Java Programming Lab 2
 * *
 *
 */

public class QuizGameClient extends QuizGame implements QuizGameListener {
    private Scanner scanner;

    public QuizGameClient() {
        this.scanner = new Scanner(System.in);
    }


    public void startGame() {
        System.out.println("Connecting to the server...");
        // Code to connect to the server
        System.out.println("Connected to the server.");
        super.startGame();
    }

    @Override
    public void askQuestion() {
        // Code to receive the question from the server
        // Display the question to the client
        String question = "Question received from the server"; // Replace with received question
        System.out.println("Question: " + question);
        evaluateAnswer(getUserAnswer());
    }

    private String getUserAnswer() {
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    @Override
    public void evaluateAnswer(String answer) {
        // Code to send the answer to the server for evaluation
        // Display the evaluation result to the client
        boolean isCorrect = true; // Replace with actual evaluation result
        System.out.println("Your answer is " + (isCorrect ? "correct!" : "incorrect!"));
        notifyAnswerEvaluated(isCorrect);
    }

    @Override
    public void onQuestionAsked(String question) {
        askQuestion();
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        // Handle the answer evaluation result
    }
}
