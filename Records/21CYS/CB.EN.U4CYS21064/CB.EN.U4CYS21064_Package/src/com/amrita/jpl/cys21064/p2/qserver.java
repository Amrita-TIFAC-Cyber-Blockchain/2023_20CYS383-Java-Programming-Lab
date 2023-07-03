package com.amrita.jpl.cys21064.p2;



import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Author: Rajendraprasad S
 * Roll No: CB.EN.U4CYS21064
 */

/**
 * Abstract class representing a Quiz Game.
 */
abstract class QuizGame
{
    /**
     * Method to start the quiz game which will be overriden.
     */
    void startGame()
    {

    }

    /**
     * Abstract method to ask a question.
     *
     * @return The index of the question asked.
     */
    abstract int askQuestion();

    /**
     * Abstract method to evaluate an answer.
     *
     * @param answer The answer provided by the player.
     * @param ind    The index of the question being answered.
     * @return 1 if the answer is correct, 0 otherwise.
     */
    abstract int evaluateAnswer(String answer, int ind);
}

/**
 * Interface for listening to quiz game events.
 */
interface QuizGameListener
{
    /**
     * Called when a question is asked.
     *
     * @param question The question asked.
     */
    void onQuestionAsked(String question);
    /**
     * Called when an answer is evaluated.
     *
     * @param isCorrect true if the answer is correct, false otherwise.
     */
    void onAnswerEvaluated(boolean isCorrect);
}

/**
 * Class representing the Quiz Game Server.
 */
class QuizGameServer extends QuizGame
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private QuizGameListener listener;

    private List<String> questions = Arrays.asList(
            "What is the name of this device?",
            "What is the age of the programmer?",
            "What is the roll number of the author?"
    );

    private List<String> answers = Arrays.asList(
            "Macbook Pro",
            "19",
            "cbenu4cys21064"

    );

    /**
     * Constructs a QuizGameServer with the specified listener.
     *
     * @param listener The listener for quiz game events.
     */
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

/**
 * Main class representing the Quiz Game Server program.
 */
public class qserver {
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
