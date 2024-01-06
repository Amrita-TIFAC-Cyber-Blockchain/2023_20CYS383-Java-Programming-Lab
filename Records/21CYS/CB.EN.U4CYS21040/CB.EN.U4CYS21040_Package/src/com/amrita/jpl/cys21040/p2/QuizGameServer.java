package com.amrita.jpl.cys21040.p2;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


interface QuizGameListener{
    default void onQuestionAsked(String question){}

    default void onAnswerEvaluated(boolean isCorrect){}
}

class QuizGameServer extends QuizGame{
    public List<String> questions = Arrays.asList(
            "What is your name ??"
    );
    public QuizGameListener CL;
    public PrintWriter op;


    void startGame() {
        try {
            ServerSocket sk = new ServerSocket(8080);
            Socket s = sk.accept();
            op = new PrintWriter(s.getOutputStream());
            askQuestion();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    void askQuestion(){

        Random r = new Random();
        int i = r.nextInt(questions.size());
        String q = questions.get(i);
        System.out.println("Server asks, " + q);
        op.println(q);
    }

    void evaluateAnswer(String answer){
        if(answer == "YES"){
            boolean isCorrect = true;
        }
    }
    public static void main(String[] args) {
        QuizGameServer ser = new QuizGameServer();
        ser.startGame();
    }
}













