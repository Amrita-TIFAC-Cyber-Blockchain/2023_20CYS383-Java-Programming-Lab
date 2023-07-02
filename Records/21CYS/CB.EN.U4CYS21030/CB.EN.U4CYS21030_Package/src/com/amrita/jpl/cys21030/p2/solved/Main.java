package com.amrita.jpl.cys21030.p2.solved;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class QuizGame {
    abstract void startGame();
    abstract void askQuestion();
    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame {
    private List<QuizGameListener> listeners;
    private List<String> questions;
    private Random random;

    public QuizGameServer() {
        listeners = new ArrayList<>();
        questions = new ArrayList<>();
        random = new Random();
        // Add some sample questions
        questions.add("What is Your Name?");
        questions.add("Which Branch?");
        questions.add("Which place do you come from?");
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }

    @Override
    void startGame() {
        askQuestion();
    }

    @Override
    void askQuestion() {
        int randomIndex = random.nextInt(questions.size());
        String question = questions.get(randomIndex);

        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    @Override
    void evaluateAnswer(String answer) {
        boolean isCorrect = false;
        
        if (answer.equalsIgnoreCase("Sai")) {
            isCorrect = true;
        }

        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(isCorrect);
        }
    }
}

class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        server.addListener(this);
    }

    @Override
    void startGame() {
        System.out.println("Quiz game started.");
        server.startGame();
    }

    @Override
    void askQuestion() {
        // Implementation specific to client
    }

    @Override
    void evaluateAnswer(String answer) {
        // Implementation specific to client
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        // Additional client-side logic (e.g., displaying the question to the user)
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is incorrect.");
        }
        // Additional client-side logic (e.g., displaying the result to the user)
    }
}

public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();
    }
}
