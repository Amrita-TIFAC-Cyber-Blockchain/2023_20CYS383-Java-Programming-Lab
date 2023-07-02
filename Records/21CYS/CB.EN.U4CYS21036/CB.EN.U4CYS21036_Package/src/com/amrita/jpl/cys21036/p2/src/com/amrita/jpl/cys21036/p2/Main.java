package com.amrita.jpl.cys21036.p2.src.com.amrita.jpl.cys21036.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class QuizGame {
    public void startGame() {
        askQuestion();
    }

    public abstract void askQuestion();

    public abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame {
    private List<String> questions;
    private List<QuizGameListener> listeners;
    private List<Integer> usedQuestionIndices;
    private Random rand;

    public QuizGameServer() {
        questions = new ArrayList<>();
        listeners = new ArrayList<>();
        usedQuestionIndices = new ArrayList<>();
        rand = new Random();
        questions.add("What is 1+1?");
        questions.add("Who is the father of our nation?");
        questions.add("How many days are there in a week?");
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }

    private void notifyQuestionAsked(String question) {
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    private void notifyAnswerEvaluated(boolean isCorrect) {
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }

    private int getRandomQuestionIndex() {
        int maxIndex = questions.size();
        int randomIndex = rand.nextInt(maxIndex);
        if (usedQuestionIndices.size() == maxIndex) {
            usedQuestionIndices.clear(); // Reset used questions if all questions have been asked
        }
        while (usedQuestionIndices.contains(randomIndex)) {
            randomIndex = rand.nextInt(maxIndex);
        }
        usedQuestionIndices.add(randomIndex);
        return randomIndex;
    }

    @Override
    public void startGame() {
        System.out.println("Quiz Game Started!");
        askQuestion();
    }

    @Override
    public void askQuestion() {
        int questionIndex = getRandomQuestionIndex();
        String question = questions.get(questionIndex);
        notifyQuestionAsked(question);
    }

    @Override
    public void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        int currentQuestionIndex = usedQuestionIndices.get(usedQuestionIndices.size() - 1);
        String currentQuestion = questions.get(currentQuestionIndex);
        switch (currentQuestion) {
            case "What is 1+1?":
                if (answer.equals("2")) {
                    isCorrect = true;
                }
                break;
            case "Who is the father of our nation?":
                if (answer.equalsIgnoreCase("Gandhi")) {
                    isCorrect = true;
                }
                break;
            case "How many days are there in a week?":
                if (answer.equals("7")) {
                    isCorrect = true;
                }
                break;
        }
        notifyAnswerEvaluated(isCorrect);
    }
}

class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;
    private Scanner scanner;

    public QuizGameClient() {
        server = new QuizGameServer();
        scanner = new Scanner(System.in);
        server.addListener(this);
    }

    @Override
    public void startGame() {
        server.startGame();
    }

    @Override
    public void askQuestion() {
        // No need to implement this method in the client class
    }

    @Override
    public void evaluateAnswer(String answer) {
        // No need to implement this method in the client class
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your Answer: ");
        String answer = scanner.nextLine();
        evaluateAnswer(answer);
        server.evaluateAnswer(answer);
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct Answer!");
        } else {
            System.out.println("Wrong Answer!");
        }
        askQuestion();
    }

    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
