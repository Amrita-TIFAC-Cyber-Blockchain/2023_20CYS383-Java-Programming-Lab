package com.amrita.jpl.cys21074.p2;

import com.amrita.jpl.cys21074.pract.net.file_transfer.FileTransferServer;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Abstract class representing a Quiz Game.
 */
abstract class QuizGame {

    /**
     * Starts the quiz game.
     */
    public abstract void startGame();

    /**
     * Asks a question to the player.
     *
     * @param socket The socket representing the player's connection.
     */
    protected abstract void askQuestion(Socket socket);

    /**
     * Evaluates the player's answer.
     *
     * @param socket The socket representing the player's connection.
     */
    protected abstract void evaluateAnswer(Socket socket);
}

/**
 * Interface for listening to Quiz Game events.
 */
interface QuizGameListener {
    /**
     * Called when a question is asked.
     *
     * @param question The question asked.
     */
    void onQuestionAsked(String question);

    /**
     * Called when an answer is evaluated.
     *
     * @param isCorrect Indicates whether the answer is correct or not.
     */
    void onAnswerEvaluated(boolean isCorrect);
}

/**
 * Represents the server side of the Quiz Game.
 */
class QuizGameServer extends QuizGame {

    /**
     * Starts the quiz game on the server side.
     */
    public void startGame() {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Server started and listening on port 2444");

            Socket socket = serverSocket.accept();
            askQuestion(socket);
            evaluateAnswer(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void askQuestion(Socket socket) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String message = "An over in cricket contains 6 legal deliveries. true or false \t(check server for result)\nAns:";
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void evaluateAnswer(Socket socket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String ans = dataInputStream.readUTF();
            if (ans.equalsIgnoreCase("true")) {
                System.out.println("You win! Your answer was correct.");
            } else {
                System.out.println("You lost! Your answer was wrong.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * Represents the client side of the Quiz Game.
 */
class QuizGameClient extends QuizGame {

    @Override
    public void startGame() {
        try {
            Socket socket = new Socket("localhost", 2444);
            System.out.println("Client connected on port 2444");
            askQuestion(socket);
            evaluateAnswer(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void askQuestion(Socket socket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String ques = dataInputStream.readUTF();
            System.out.println(ques);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void evaluateAnswer(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * Main class to run the Quiz Game program.
 */
public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();

        server.startGame();

    }
}
