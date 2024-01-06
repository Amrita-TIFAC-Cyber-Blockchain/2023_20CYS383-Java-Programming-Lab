package com.amrita.jpl.cys21047.p2;
/**
 * com.amrita.jpl.cys21047.p2 is a Java Swing-based client application for a Quiz system.
 * This is an abstract class which named QuizGame .
 * It starts the game and askquestions and evaluateAnswers.
 * It is useful for the QuizGameClient and QuizGameServer.
 *
 * @author vihal roy
 * @version 0.5
 */
abstract class QuizGame {
    abstract void startgame();
    abstract void askquestions();
    abstract void evaluateAnswer(String answer);
}
