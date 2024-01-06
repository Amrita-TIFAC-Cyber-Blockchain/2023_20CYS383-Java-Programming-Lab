package com.amrita.jpl.cys21061.p2;
import java.io.IOException;
/**
 * Calls server, client1 and client 2 along with their constructor
 */
public class Main {
    public static void main(String[] args) {
        QuizGameServer s = new QuizGameServer();
        QuizGameClient1 c1 = new QuizGameClient1();
        QuizGameClient2 c2 = new QuizGameClient2();

        try {
            s.startGame();
            c1.startGame();
            c2.startGame();
        } catch (IOException e) {
            System.out.println("Error starting the game.");
            e.printStackTrace();
        }
    }
}

