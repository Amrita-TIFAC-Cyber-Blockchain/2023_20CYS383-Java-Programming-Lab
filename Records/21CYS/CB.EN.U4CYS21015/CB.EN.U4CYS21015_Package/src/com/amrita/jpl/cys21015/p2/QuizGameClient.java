package com.amrita.jpl.cys21015.p2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *  @author Dyanesh S
 *  @version 1.0
 */

public class QuizGameClient extends QuizGame implements QuizGameListener {

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public QuizGameClient() throws IOException {
        socket = new Socket("localhost", 42011);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
    }

    public static void main(String[] args) throws IOException {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }

    @Override
    void startGame() throws IOException {
        System.out.println("Game Started!");
        askQuestion();
    }

    @Override
    void askQuestion() throws IOException {
        String ques = inputStream.readUTF();
        System.out.println(ques);
        Scanner scanner = new Scanner(System.in);
        String reply;
        for(int i = 0; i < 3; i++) {
            ques = inputStream.readUTF();
            System.out.println("Received: " + ques);
            reply = scanner.nextLine();
            outputStream.writeUTF(reply);
            ques = inputStream.readUTF();
            System.out.println("Received: " + ques);
        }

        System.out.println(inputStream.readUTF());
    }

    @Override
    void evaluateAnswer(String answer) {
        System.out.println("Answer sent: " + answer);
        try {
            outputStream.writeUTF(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onQuestionAsked(String question) {
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect){

    }
}
