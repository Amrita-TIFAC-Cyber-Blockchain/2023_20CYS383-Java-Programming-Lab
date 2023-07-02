package com.amrita.jpl.cys21050.P2;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class QuizGameClient extends QuizGame
{

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private QuizGameListener listener;

    private List<String> answers = Arrays.asList(
            "JK Rowling",
            "cbenu4cys21050",
            "Pacific Ocean"
    );
    public QuizGameClient(QuizGameListener listener)
    {
        this.listener = listener;
    }

    @Override
    void startGame() {
        try {
            socket = new Socket("localhost", 1234);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    int askQuestion() {
        try {
            String question = in.readLine();
            System.out.println("Question: " + question);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }



    int evaluateAnswer(String answer, int ind) {
        try {
            Random random = new Random();
            int index = random.nextInt(answers.size());
            String ans = answers.get(index);
            out.println(ans);
            System.out.println("Client answer: "+ans);
            String result = in.readLine();
            if (result != null) {
                boolean isCorrect = Boolean.parseBoolean(result);
                if (isCorrect) {
                    System.out.println("Correct answer!");
                } else {
                    System.out.println("Incorrect answer!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}



public class Client {
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient(new QuizGameListener() {
            @Override
            public void onQuestionAsked(String question) {
                System.out.println("Question: " + question);
            }

            @Override
            public void onAnswerEvaluated(boolean isCorrect) {
                if (isCorrect) {
                    System.out.println("Correct answer!");
                } else {
                    System.out.println("Incorrect answer!");
                }
            }
        });

        client.startGame();
        for(int i=0;i<10;i++) {
            client.askQuestion();
            client.evaluateAnswer("", 0);
        }
    }
}