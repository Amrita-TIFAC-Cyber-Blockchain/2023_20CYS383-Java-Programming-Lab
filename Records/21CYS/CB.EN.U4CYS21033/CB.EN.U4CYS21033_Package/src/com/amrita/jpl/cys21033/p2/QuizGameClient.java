package com.amrita.jpl.cys21033.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The QuizGameClient class represents a client for the quiz game.
 * It connects to the server, sends user input, and receives server responses.
 * @version: 1.0
 * @author: Suhitha K
 */
public class QuizGameClient {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    /**
     * Starts the quiz game client.
     * It connects to the server, handles communication, and displays server responses.
     */
    public void startGame() {
        try {
            connectToServer();
            System.out.println("Connected to the Quiz Game Server.");

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            String serverResponse = inputStream.readUTF();
            System.out.println(serverResponse);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String userInput = scanner.nextLine();
                outputStream.writeUTF(userInput);

                serverResponse = inputStream.readUTF();
                System.out.println(serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void connectToServer() throws IOException {
        socket = new Socket("localhost", 12345); // Replace with the server IP and port
    }

    /**
     * The main method that creates a QuizGameClient instance and starts the game.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
