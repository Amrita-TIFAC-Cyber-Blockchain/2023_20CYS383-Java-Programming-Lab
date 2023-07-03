package com.amrita.jpl.cys21057.p2;

import java.util.*;

/**
 * This code is written from the existing code in the system
 * This is a server class
 * It will ask questoins to the client
 *
 * @Author - Pushpanth
 */
public class QuizGameServer extends QuizGame {
    private QuizGameListener listener;
    private String[] questions = {
            "What is 1+1 = ?"
    };

    public void setListener(QuizGameListener listener) {
        this.listener = listener;
    }

    public void startGame(){

        askQuestion();
    }

    public void  askQuestion(){

        String question = questions[0];

        if (listener != null) {
            listener.onQuestionAsked(question);
        }


    }

    public void  evaluateAnswer(String answer){

        boolean val;
        if(answer.equals("2")){
            val = true;
        }else{
            val = false;
        }

        if (listener != null) {
            listener.onAnswerEvaluated(val);
        }
    }
}

