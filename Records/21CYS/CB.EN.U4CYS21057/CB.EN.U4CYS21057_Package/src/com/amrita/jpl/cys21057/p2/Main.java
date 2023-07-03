package com.amrita.jpl.cys21057.p2;

public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startGame();
    }
}
