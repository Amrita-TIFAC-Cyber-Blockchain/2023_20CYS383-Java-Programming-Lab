/**
 * I am getting error,not able to resolve, so i commented it!


package com.amrita.jpl.cys21085.p2;

import java.net.*;
import java.io.*;
import java.util.*;
class QuizGameClient implements QuizGameListener {
    public QuizGameServer server;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
    }

    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    public void onAnswerEvaluated(int correctness) {
        String result = (correctness == 1) ? "Correct" : "Incorrect";
        System.out.println("Answer evaluated. Result: " + result);
    }

    public void startGame() {
        server.addListener(this);
        server.startGame();
    }

    public void sendAnswer(String answer) {
        server.evaluateAnswer(answer);
    }
}


**/
