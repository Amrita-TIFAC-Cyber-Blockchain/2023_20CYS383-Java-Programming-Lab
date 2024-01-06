package com.amrita.jpl.cys21050.P2;



import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

abstract class QuizGame
{
    void startGame()
    {

    }

    abstract int askQuestion();

    abstract int evaluateAnswer(String answer, int ind);
}

interface QuizGameListener
{
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private QuizGameListener listener;

    private List<String> questions = Arrays.asList(
            "who is the author of harry potter?",
            "What is the rollno of the user?",
            "Which is the Largest ocean?"
    );

    private List<String> answers = Arrays.asList(
            "JK rowling",
            "50",
            "Pacific Oceanma"

    );
    public QuizGameServer(QuizGameListener listener)
    {
        this.listener = listener;
    }

    @Override
    void startGame()
    {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for clients to connect...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            int correct = 0;
            for(int i=0;i<10;i++) {
                int ind = askQuestion();
                String answer = in.readLine();
                correct += evaluateAnswer(answer, ind);
            }

            System.out.println("Score :"+correct);
            out.println("Score :"+correct);
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int askQuestion()
    {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        String question = questions.get(index);

        out.println(question);

        if (listener != null) {
            listener.onQuestionAsked(question);
        }
        return index;
    }

    int evaluateAnswer(String answer, int ind)
    {
        boolean isCorrect = false;
        System.out.println("Received answer: "+answer);

        if (answer != null && answer.equalsIgnoreCase(answers.get(ind))) {
            isCorrect = true;
        }

        out.println(isCorrect);

        if (listener != null) {
            listener.onAnswerEvaluated(isCorrect);
        }

        if (isCorrect)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }


}


public class Server {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer(new QuizGameListener() {
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

        server.startGame();
    }
}