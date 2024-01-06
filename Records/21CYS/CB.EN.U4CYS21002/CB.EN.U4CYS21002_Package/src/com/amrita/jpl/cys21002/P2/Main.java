package com.amrita.jpl.cys21002.P2;

public class Main {
    public static void main(String[] args) {
        QuizGameListener serverListener = new QuizGameClient(null); // Replace null with the appropriate listener
        QuizGameServer server = new QuizGameServer(serverListener);
        server.startGame();

        QuizGameClient client = new QuizGameClient(serverListener);
        client.startGame();
    }
}
