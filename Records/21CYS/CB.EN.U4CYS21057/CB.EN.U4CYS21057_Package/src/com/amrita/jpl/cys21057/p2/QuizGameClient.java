package com.amrita.jpl.cys21057.p2;

import java.util.*;

/**
 * This code is written from the existing code in the system
 * This is a client class
 * It will answer the questions asked by the server
 *
 * @Author - Pushpanth
 */
public class QuizGameClient extends QuizGame implements QuizGameListener {

    private QuizGameServer server;
    private Scanner scanner;

    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        this.server.setListener(this);
        this.scanner = new Scanner(System.in);
    }
    public void startGame(){
        server.startGame();
    }

    public void askQuestion(){

    }

    public void evaluateAnswer(String answer){

    }

    public void onQuestionAsked(String question){

        System.out.println("Question: " + question);
        String answer = scanner.nextLine();
        server.evaluateAnswer(answer);
    }

    public void onAnswerEvaluated(boolean correct){


        if (correct) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is incorrect!");
        }
    }
}