package com.amrita.jpl.cys21047.p2;
/**
 * com.amrita.jpl.cys21047.p2 is a Java Swing-based client application for a Quiz system.
 * It is an interface that asks the string questions and checks the answer isCorrect.
 * it asks onquestionasked and onanswerevaluted.
 *
 * @author vihal roy
 * @version 0.5
 */
public interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
