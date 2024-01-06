package com.amrita.jpl.cys21030.p2;

/***Author - Sai Suvarchala
 * Java Programming Lab 2
 * *
 *
 */
public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient();

        server.addListener(client);
        client.addListener(server);

        client.startGame();
    }
}
