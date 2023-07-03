package com.amrita.jpl.cys21067.p2crtsolution;

/**This is the correct solution
 * The Abstract Class of the Quiz Game
 *
 * @author Dharmik S
 * @version 1.0
 */
abstract class QuizGame {
    void startGame(){
        System.out.println("Game Started");
    }
    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

