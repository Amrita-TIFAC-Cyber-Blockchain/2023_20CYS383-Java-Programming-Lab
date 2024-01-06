package com.amrita.jpl.cys21010.p2;

import java.io.IOException;
import java.util.Scanner;

public class p2LabExam {
    public static void main(String[] args) throws IOException {
        /**
         * menu driven code for all
         */
        System.out.println("1)Server\n2)Client");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 1){
            QuizGameServer obj = new QuizGameServer();
            obj.startGame();
            obj.askQuestion();
            obj.evaluateAnswer();
        } else if (x == 2) {
            QuizGameClient obj = new QuizGameClient();
            obj.startGame();
            obj.askQuestion();
            obj.evaluateAnswer();
            
        }
        else{
            System.out.println("Enter a valid menu number");
        }
    }
}
