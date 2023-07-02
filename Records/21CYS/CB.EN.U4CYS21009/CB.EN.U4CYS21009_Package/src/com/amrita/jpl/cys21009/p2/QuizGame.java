package com.amrita.jpl.cys21009.p2;

/**
 * The Abstract Class and Interface of the Quiz Game
 *
 * @author Aravind
 * @version 1
 */
abstract class QuizGame {
    void startGame(){
        System.out.println("Game Started");
    }
    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener{
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}

