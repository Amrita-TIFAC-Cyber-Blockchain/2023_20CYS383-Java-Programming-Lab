package com.amrita.jpl.cys21061.pract.QuizGameUI;

import java.io.*;
import java.net.Socket;

public class QuizGameClient02 extends QuizGameUI {
    private Socket cs2;
    private QuizGameListener1 listener;

    public QuizGameClient02(QuizGameListener1 listener) {
        this.listener = listener;
    }

    public void startGame() throws IOException {
        cs2 = new Socket("localhost", 2448);
    }

    public void askQuestion() {
        try {
            DataOutputStream dout = new DataOutputStream(cs2.getOutputStream());
            dout.writeUTF("Question request from client 2");
            dout.flush();
        } catch (IOException e) {
            System.out.println("Error sending question request from client 2.");
            e.printStackTrace();
        }
    }

    public void evaluateAnswer(String[] answer) {
        try {
            DataInputStream dis = new DataInputStream(cs2.getInputStream());
            DataOutputStream dout = new DataOutputStream(cs2.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str;
            do {
                String input = reader.readLine();
                dout.writeUTF(input);
                dout.flush();
                str = dis.readUTF();
                System.out.println("Message: " + str);
            } while (!str.equals("Exit"));

            boolean isCorrect = true; // Replace with your answer evaluation logic
            listener.onAnswerEvaluated(isCorrect);
        } catch (IOException e) {
            System.out.println("Error evaluating answer in client 2.");
            e.printStackTrace();
        }
    }
}
