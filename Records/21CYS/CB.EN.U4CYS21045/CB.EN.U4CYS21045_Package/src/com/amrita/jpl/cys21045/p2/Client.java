package com.amrita.jpl.cys21045.p2;

class QuizGameClient extends quizGame implements QuizGameListener {
    private QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        server.addListener(this);
    }

    @Override
    void startGame() {
        server.startGame();
    }

    @Override
    void askQuestion() {
        // The server will notify the client about the question
    }

    @Override
    void evaluateAnswer(String answer) {
        // The server will notify the client about the answer evaluation
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        // Display the question to the client
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is incorrect.");
        }
        // Display the result to the client
    }
}
public class Client {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        // Start the game (Client-side)
        client.startGame();
        // Simulating user input for answer evaluation (Client-side)
        client.evaluateAnswer("Paris");
        client.evaluateAnswer("Leonardo da Vinci");
        client.evaluateAnswer("Saturn");
    }
}