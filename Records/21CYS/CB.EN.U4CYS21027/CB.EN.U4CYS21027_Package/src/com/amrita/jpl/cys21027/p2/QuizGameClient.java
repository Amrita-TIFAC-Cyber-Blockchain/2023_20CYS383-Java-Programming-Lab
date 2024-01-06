/**
 * The QuizGameClient class represents a client that connects to a QuizGameServer
 * and participates in a quiz game.
 */

package com.amrita.jpl.cys21027.p2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * The QuizGameClient class represents a client that connects to a QuizGameServer
 * and participate in a quiz game
 * @author K Sri Sai Nitin
 * @version 1.0
 */

public class QuizGameClient {
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



    /**
     *
     * @param args Main
     */
    public static void main(String[] args) {
        com.amrita.jpl.cys21027.p2.QuizGameClient client = new com.amrita.jpl.cys21027.p2.QuizGameClient();
        client.startGame();
    }
}
