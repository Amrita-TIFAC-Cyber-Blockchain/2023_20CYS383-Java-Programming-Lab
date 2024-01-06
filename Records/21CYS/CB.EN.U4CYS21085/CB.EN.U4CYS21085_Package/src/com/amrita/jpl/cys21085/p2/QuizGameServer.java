/**
 * * I am getting error,not able to resolve, so i commented it!



 package com.amrita.jpl.cys21085.p2;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
class QuizGameServer extends QuizGame {
    private List<String> questions;
    public List<QuizGameListener> listeners = new ArrayList<>();
    private int ques;

    public QuizGameServer() {
        questions = new ArrayList<>();
        ques = 0;
        questions.add("What is Your Name?");
        questions.add("What is Your RollNumber?");
        questions.add("What is Your Pet's Name?");
    }

    public void startGame() {
        askQuestion();
    }

    public void askQuestion() {
        if (ques < questions.size()) {
            String question = questions.get(ques);
            notifyQuestionAsked(question);
        }
        else {
            declareWinner();
        }
    }

    public void evaluateAnswer(String answer) {
        String currentQuestion = questions.get(ques);
        int correctness = checkAnswer(currentQuestion, answer);
        notifyAnswerEvaluated(correctness);
        ques++;
        askQuestion();
    }

    public void addListener(QuizGameListener listener) {
        listeners.add(listener);
    }

    private void notifyQuestionAsked(String question) {
        for (QuizGameListener listener : listeners) {
            listener.onQuestionAsked(question);
        }
    }

    private void notifyAnswerEvaluated(int correctness) {
        for (QuizGameListener listener : listeners) {
            listener.onAnswerEvaluated(correctness);
        }
    }

    private int checkAnswer(String question, String answer) {
        if (question.equals("What is Your Name?")) {
            return answer.equalsIgnoreCase("Vinoth") ? 1 : 0;
        } else if (question.equals("What is Your RollNumber?")) {
            return answer.equalsIgnoreCase("CB.EN.U4CYS21085") ? 1 : 0;
        } else if (question.equals("What is Your Pet's Name?")) {
            return answer.equalsIgnoreCase("Don") ? 1 : 0;
        }
        return 0;
    }

    private void declareWinner() {
        System.out.println("Quiz Over");
    }
}


**/