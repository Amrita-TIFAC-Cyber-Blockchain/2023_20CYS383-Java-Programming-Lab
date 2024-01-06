package com.amrita.jpl.cys21067.p2crtsolution;

/**
 * This is the correct solution
 * The Interface of the Quiz Game
 *
 * @author Dharmik S
 * @version 1.0
 */


interface QuizGameListener{
    void onQuestionAsked(String question);

    void onAnswerEvaluated(boolean isCorrect);
}