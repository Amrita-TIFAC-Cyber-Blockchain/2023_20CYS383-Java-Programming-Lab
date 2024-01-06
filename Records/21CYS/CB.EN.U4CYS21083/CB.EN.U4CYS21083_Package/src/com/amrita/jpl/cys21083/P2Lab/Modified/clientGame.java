package com.amrita.jpl.cys21083.P2Lab.Modified;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Venkata Revan Nagireddy - CB.EN.U4CYS21082
 */

public class clientGame extends quizGame {

    @Override
    public void startGame() {
        System.out.println("Connecting to the server..");

        try (Socket socket = new Socket("localhost", 1234)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                String q = (String) inputStream.readObject();
                if (q.equals("Game Over")) {
                    break;
                }

                System.out.println("Received question: " + q);
                System.out.print("Your answer: ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();

                outputStream.writeObject(answer);
                outputStream.flush();

                boolean isCorrect = (boolean) inputStream.readObject();
                System.out.println("Result: " + (isCorrect ? "Correct" : "Incorrect"));
            }

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error connecting to the server.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void askQuestion() {
        //Nothing
    }

    @Override
    public void evaluateAnswer(String answer) {
        //Nothing
    }

    public static void main(String[] args) {
        clientGame client = new clientGame();
        client.startGame();
    }
}
