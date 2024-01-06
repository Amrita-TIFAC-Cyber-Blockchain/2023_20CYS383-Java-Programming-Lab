package com.amrita.jpl.cys21010.p2;

import java.io.IOException;

public class mainClient {
    public static void main(String[] args) throws IOException {
        QuizGameClient obj = new QuizGameClient();
        obj.startGame();
        obj.askQuestion();
        obj.evaluateAnswer();
}}

