package com.amrita.jpl.cys21061.p2;

import java.io.*;
import java.util.Scanner;

public abstract class QuizGame {
    public void startGame() throws IOException {
        try {
            File qFile = new File("../Question.txt");
            Scanner reader = new Scanner(qFile);
            while (reader.hasNextLine()) {
                String nextQ = reader.nextLine();
                System.out.println(nextQ);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Question file not found.");
            e.printStackTrace();
        }
    }

    public abstract void askQuestion();

    public abstract void evaluateAnswer(String[] answer);
}
