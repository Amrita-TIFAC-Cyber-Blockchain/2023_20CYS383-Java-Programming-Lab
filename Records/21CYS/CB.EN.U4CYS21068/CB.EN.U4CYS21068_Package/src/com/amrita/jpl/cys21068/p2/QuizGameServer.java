package com.amrita.jpl.cys21068.p2;

import java.util.ArrayList;
import java.util.List;

public class QuizGameServer extends QuizGame {
    private List<String> questions;
    private List<QuizGameListener> listeners;
    private int ques;

    public QuizGameServer() {
        questions = new ArrayList<>();
        listeners = new ArrayList<>();
        ques = 0;
        questions.add("What is Your Name?");
        questions.add("What is Your RollNumber?");
        questions.add("What is Your Pet's Name?");
    }

    @Override
    public void startGame() {
        askQuestion();
    }

    @Override
    public void askQuestion() {
        if (ques < questions.size()) {
            String question = questions.get(ques);
            notifyQuestionAsked(question);
        } else {
            declareWinner();
        }
    }

    @Override
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
            return answer.equalsIgnoreCase("Saranesh") ? 1 : 0;
        } else if (question.equals("What is Your RollNumber?")) {
            return answer.equalsIgnoreCase("CB.EN.U4CYS21068") ? 1 : 0;
        } else if (question.equals("What is Your Pet's Name?")) {
            return answer.equalsIgnoreCase("Don") ? 1 : 0;
        }
        return 0;
    }

    private void declareWinner() {
        System.out.println("Quiz Over");
    }
}
