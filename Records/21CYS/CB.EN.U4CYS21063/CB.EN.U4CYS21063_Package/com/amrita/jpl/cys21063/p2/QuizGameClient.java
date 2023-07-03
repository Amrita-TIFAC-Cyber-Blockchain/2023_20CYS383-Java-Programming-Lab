package com.amrita.jpl.cys21063.p2;

import java.util.Scanner;

public class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;
    private Scanner scanner;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        System.out.println("Connecting to the server...");
        server.startGame();
    }

    @Override
    public void askQuestion() {

    }

    @Override
    public void evaluateAnswer(String answer) {

        server.evaluateAnswer(answer);
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Server: " + question);
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();
        evaluateAnswer(answer);
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Server: Correct answer!");
        } else {
            System.out.println("Server: Incorrect answer!");
        }
        server.askQuestion();
    }

    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();
    }
}