package com.amrita.jpl.cys21033.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The QuizGameServer class represents a server for a quiz game.
 * It listens for client connections and handles the quiz game logic.
 * @version: 1.0
 * @author: Suhitha K
 */
public class QuizGameServer {
    private ServerSocket serverSocket;

    /**
     * Constructs a QuizGameServer and initializes the server socket.
     */
    public QuizGameServer() {
        try {
            serverSocket = new ServerSocket(12345); // Set the server port here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the quiz game server.
     * It accepts client connections and starts a new thread to handle each client.
     */
    public void startGame() {
        System.out.println("Quiz Game Server started. Waiting for clients to connect...");

        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method that creates a QuizGameServer instance and starts the game.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }

    /**
     * The ClientHandler class handles communication with a client.
     * It receives requests from the client and sends appropriate responses.
     */
    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream inputStream;
        private DataOutputStream outputStream;

        /**
         * Constructs a ClientHandler for the given client socket.
         *
         * @param clientSocket the client socket
         */
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                inputStream = new DataInputStream(clientSocket.getInputStream());
                outputStream = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                outputStream.writeUTF("Welcome to the Quiz Game!");

                while (true) {
                    String request = inputStream.readUTF();
                    if (request.equals("question")) {
                        String question = askQuestion();
                        outputStream.writeUTF(question);
                    } else {
                        evaluateAnswer(request);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Generates a question for the client to answer.
         *
         * @return the question string
         */
        private String askQuestion() {
            // Implement your question selection logic here

            String question = "What is my Name";
            return question;
        }

        /**
         * Evaluates the client's answer and sends the result back to the client.
         *
         * @param answer the client's answer
         */
        private void evaluateAnswer(String answer) {
            // Implement your answer evaluation logic here
            boolean isCorrect = answer.equalsIgnoreCase("Suhitha");
            if (isCorrect) {
                try {
                    outputStream.writeUTF("Correct answer!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    outputStream.writeUTF("Wrong answer!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
