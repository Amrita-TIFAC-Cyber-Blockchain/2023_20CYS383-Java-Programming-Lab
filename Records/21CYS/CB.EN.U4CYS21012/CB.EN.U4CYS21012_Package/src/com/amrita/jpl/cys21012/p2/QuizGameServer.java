package com.amrita.jpl.cys21012.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.net.Socket;
import java.net.ServerSocket;

public class QuizGameServer extends QuizGame implements QuizGameListener {
    /**
     * Generic Server variables are defined here
     */
    DataOutputStream dis1;
    DataInputStream dis2;
    String questions[] = new String[]{"Capital of India?","Capital of China","Capital of Japan"};
    String answers[] = new String[]{"Delhi","Beijing","Tokyo"};

    int option;

    public void onQuestionAsked(String a){
        //Not applicable here
    }

    public void onAnswerEvaluated(boolean a){
        //Not applicable here
    }
    void evaluateAnswer(String answer){
        /**
         * Checks whether the answer matches with the corresponding option
         */
        if (answer.equals(answers[option])){
            try {
                dis1.writeUTF("Good Job your answer is correct!\n");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                dis1.writeUTF("Try harder next time!\n");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    void askQuestion(){
        /**
         * Ask question randomly from a list of questions
         */
        int qq = new Random().nextInt(questions.length);
        option = qq;
        try {
            dis1.writeUTF(questions[qq]);

            while (true) {
                String str = dis2.readUTF();
                if (str != null) {
                    evaluateAnswer(str);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void startGame(){
        /**
         * Generate the sockets to start the program
         */
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started and listening on port 12345...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            dis1 = new DataOutputStream(clientSocket.getOutputStream());
            dis2 = new DataInputStream(clientSocket.getInputStream());

            while (true){
                String s = dis2.readUTF();
                if (s.equals("Ask me a question.")){
                    askQuestion();
                }
                else{
                    break;
                }
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String args[]){
        QuizGameServer qgz = new QuizGameServer();
        qgz.startGame();
    }
}
