package com.amrita.jpl.cys21010.p2;

import java.io.IOException;

public class mainServer {
    /***
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        QuizGameServer obj = new QuizGameServer();
        obj.startGame();
        obj.askQuestion();
        obj.evaluateAnswer();


    }
}
