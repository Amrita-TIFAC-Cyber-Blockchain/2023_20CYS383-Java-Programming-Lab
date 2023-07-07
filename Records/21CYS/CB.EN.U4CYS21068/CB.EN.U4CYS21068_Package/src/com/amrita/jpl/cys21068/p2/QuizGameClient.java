package com.amrita.jpl.cys21068.p2;

import java.util.Scanner;

public class QuizGameClient implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        promptUserForAnswer();
    }

    @Override
    public void onAnswerEvaluated(int correctness) {
        String result = (correctness == 1) ? "Correct" : "Incorrect";
        System.out.println("Answer evaluated. Result: " + result);
    }

    public void startGame() {
        server.addListener(this);
        server.startGame();
    }

    private void promptUserForAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine();
        sendAnswer(answer);
    }

    public void sendAnswer(String answer) {
        server.evaluateAnswer(answer);
    }
}
