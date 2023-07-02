package com.amrita.cys21049.p2;
import java.util.Scanner;

abstract class QuizGame {
    public void startGame() {
        System.out.println("Welcome to the Online Quiz");
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String ans1, String ans2, String ans3);
}

interface QuizGameListener {
    void onQuestionAsked(String q1, String q2, String q3);

    void onAnswerEvaluated(int mark);
}

class QuizGameServer extends QuizGame {
    QuizGameListener listener;
    String q1 = "Who is the prime minister of India";
    String q2 = "Which is the largest state of India";
    String q3 = "How many oceans are there in the world";

    public QuizGameServer(QuizGameListener listener) {
        this.listener = listener;
    }

    void askQuestion() {
        listener.onQuestionAsked(q1, q2, q3);
    }

    void evaluateAnswer(String ans1, String ans2, String ans3) {
        boolean isCorrect = false;
        int mark = 0;
        if (ans1.equals("Narendra Modi")) {
            isCorrect = true;
            if (isCorrect) {
                mark++;
            }
        }
        if (ans2.equals("Rajasthan")) {
            isCorrect = true;
            if (isCorrect) {
                mark++;
            }
        }
        if (ans3.equals("5")) {
            isCorrect = true;
            if (isCorrect) {
                mark++;
            }
        }
        listener.onAnswerEvaluated(mark);
    }
}
class QuizGameClient extends QuizGame implements QuizGameListener {
    QuizGameServer server;
    public QuizGameClient(QuizGameServer server) {
        this.server = server;
    }
    @Override
    public void startGame() {
        System.out.println("Connecting to the server...");
        server = new QuizGameServer(this);
        server.startGame();
        server.askQuestion();
    }
    public void onQuestionAsked(String q1, String q2, String q3) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Question 1: " + q1);
        String ans1 = scan.nextLine();
        System.out.println("Question 2: " + q2);
        String ans2 = scan.nextLine();
        System.out.println("Question 3: " + q3);
        String ans3 = scan.nextLine();
        server.evaluateAnswer(ans1, ans2, ans3);
    }
    public void onAnswerEvaluated(int mark) {
        System.out.println("Your total score is: " + mark);
    }
    void askQuestion() {
        server.askQuestion();
    }
    void evaluateAnswer(String ans1, String ans2, String ans3) {
    }
}
public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer(new QuizGameClient(null));
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();
    }
}
