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
 * Class representing the Quiz Game Client.
 */

class QuizGameClient extends QuizGame
{

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private QuizGameListener listener;

    private List<String> answers = Arrays.asList(
            "19",
            "cbenu4cys21064",
            "Macbook Pro"
    );
    /**
     * Constructs a QuizGameClient with the specified listener.
     *
     * @param listener The listener for quiz game events.
     */
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


/**
 * Main class representing the Quiz Game Client program.
 */
public class qclient {
    public static void main(String[] args) {
        QuizGameClient client1 = new QuizGameClient(new QuizGameListener() {
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

        client1.startGame();
        for(int i=0;i<10;i++) {
            client1.askQuestion();
            client1.evaluateAnswer("", 0);
        }

//        QuizGameClient client2 = new QuizGameClient(new QuizGameListener() {
//            @Override
//            public void onQuestionAsked(String question) {
//                System.out.println("Question: " + question);
//            }
//
//            @Override
//            public void onAnswerEvaluated(boolean isCorrect) {
//                if (isCorrect) {
//                    System.out.println("Correct answer!");
//                } else {
//                    System.out.println("Incorrect answer!");
//                }
//            }
//        });
//
//        client2.startGame();
//        for(int i=0;i<10;i++) {
//            client2.askQuestion();
//            client2.evaluateAnswer("", 0);
//        }
//
//        QuizGameClient client3 = new QuizGameClient(new QuizGameListener() {
//            @Override
//            public void onQuestionAsked(String question) {
//                System.out.println("Question: " + question);
//            }
//
//            @Override
//            public void onAnswerEvaluated(boolean isCorrect) {
//                if (isCorrect) {
//                    System.out.println("Correct answer!");
//                } else {
//                    System.out.println("Incorrect answer!");
//                }
//            }
//        });
//
//        client3.startGame();
//        for(int i=0;i<10;i++) {
//            client3.askQuestion();
//            client3.evaluateAnswer("", 0);
//        }
//
//        QuizGameClient client4 = new QuizGameClient(new QuizGameListener() {
//            @Override
//            public void onQuestionAsked(String question) {
//                System.out.println("Question: " + question);
//            }
//
//            @Override
//            public void onAnswerEvaluated(boolean isCorrect) {
//                if (isCorrect) {
//                    System.out.println("Correct answer!");
//                } else {
//                    System.out.println("Incorrect answer!");
//                }
//            }
//        });
//
//        client4.startGame();
//        for(int i=0;i<10;i++) {
//            client4.askQuestion();
//            client4.evaluateAnswer("", 0);
//        }
    }
}

