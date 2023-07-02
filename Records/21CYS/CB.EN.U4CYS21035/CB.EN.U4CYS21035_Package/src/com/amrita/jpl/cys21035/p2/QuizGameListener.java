package com.amrita.jpl.cys21035.p2;
/**
 * Interface
 * @author M C Vivek Veera
 * Refered ChatClient.java ChatServer.java
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}

