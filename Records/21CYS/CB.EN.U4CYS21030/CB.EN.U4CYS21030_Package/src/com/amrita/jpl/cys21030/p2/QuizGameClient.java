package com.amrita.jpl.cys21030.p2;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class QuizGameClient extends QuizGame {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;


    public void startGame() {
        try {
            socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            // Initialize input and output streams for communication
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());

            // Start the quiz game by receiving questions from the server
            super.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the socket and streams
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void askQuestion() {
        // Receive the question from the server
        String question = in.nextLine();

        // Display the question to the client
        System.out.println("Question: " + question);
    }


    public void evaluateAnswer(String answer) {
        // Send the answer to the server for evaluation
        out.println(answer);

        // Receive the result from the server
        String result = in.nextLine();

        // Display the result to the client
        System.out.println(result);
    }
}



