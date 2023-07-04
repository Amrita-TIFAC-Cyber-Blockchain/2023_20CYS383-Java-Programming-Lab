package com.amrita.jpl.cys21023.p2;

import java.io.*;
import java.net.Socket;

public class QuizGameClient {
    public void startGame() {
        System.out.println("Client initiated the QuizGame!");

        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String question;
            while ((question = in.readLine()) != null) {
                if (question.equals("All questions have been asked.")) {
                    System.out.println(question);
                    break;
                }

                System.out.println("Server's question: " + question);

                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Write your answer (true/false): ");
                String answer = consoleReader.readLine();
                out.println(answer);
            }

            String marks = in.readLine();
            System.out.println(marks);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QuizGameClient qgc = new QuizGameClient();
        qgc.startGame();
    }
}