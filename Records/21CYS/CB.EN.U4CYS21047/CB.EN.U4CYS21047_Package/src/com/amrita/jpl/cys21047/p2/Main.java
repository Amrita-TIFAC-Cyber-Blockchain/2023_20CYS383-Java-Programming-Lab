package com.amrita.jpl.cys21047.p2;

/**
 * com.amrita.jpl.cys21047.p2 is a Java Swing-based client application for a Quiz system.
 * This class Executes the usage of main functions.
 * It checks the quiz questions a true or false.
 *
 * @author vihal roy
 * @version 0.5
 */
public class Main {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client = new QuizGameClient(server);
        client.startgame();
        server = new QuizGameServer();
        client = new QuizGameClient(server);
        client.startgame();
    }
}
