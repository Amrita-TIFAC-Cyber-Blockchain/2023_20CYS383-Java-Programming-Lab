package com.amrita.jpl.cys21016.p2;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 * A simple program that conducts the quiz online.
 * The server poses the question to the client and client answers it
 * based on the answer the server declares the winner
 *
 * @author G H Hem Sagar
 * @version 1.0
 * */

abstract class QuizGame{
  void startGame(){
    System.out.println("Quiz Started! (All the best)");
  };
  abstract void askQuestion();
  abstract void evaluateAnswer(String answer);
}
interface QuizGamelistener{
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame implements QuizGamelistener{
    private ArrayList<String> questions; // to store the questions of the quiz.
    private ArrayList<String> answers; // to store the answers for each question.
    private int QuestionIndex;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream sout;
    private DataInputStream sin;
    public QuizGameServer(){
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        //listeners = new ArrayList<>();
        QuestionIndex = 0;

        // sample questions and answers
        questions.add("23 + 13?");
        answers.add("36");
        questions.add("22 * 11?");
        answers.add("242");
        questions.add("272/4?");
        answers.add("68");
        questions.add("103 - 8?");
        answers.add("95");

    }
    @Override
    void startGame() {
        /**
         * It starts the server socket & waits for the client connection
         * Once the client is connected it asks the question to the client.*/
        try{
            serverSocket = new ServerSocket(21016);
            System.out.println("QuizGame Server started. Waiting for the clients!");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: "+clientSocket.getInetAddress());
            super.startGame();
            askQuestion();
            serverSocket.close();
        }catch(IOException e){
            System.out.println("Error in starting the server.");
        }


    }

    @Override
    void askQuestion() {
        /**
         * It selects a question from the list of questions and send it to the client.
         * Upon receiving the answer from the client it evaluates it.*/
        try{
            sout = new DataOutputStream(clientSocket.getOutputStream());
            sin = new DataInputStream(clientSocket.getInputStream());
            String question = questions.get(QuestionIndex);
            sout.writeUTF(question);
            onQuestionAsked(question);
            String answer = sin.readUTF();
            evaluateAnswer(answer);
        }catch(IOException e){
            System.out.println("Error in sending Question");
        }

    }

    @Override
    public void onQuestionAsked(String question) {
        /**
         * it displays if the question is asked.
         * @param question -> the question that is sent. */
        System.out.println("[Server]Question is Asked.");

    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        /**
         * after the answer is evaluated it send the result to the client.
         * @param isCorrect boolean values that represents if the answer is correct or not.
        * */
        try{
            sout.writeUTF(isCorrect? "Correct":"Incorrect");
            System.out.println("[Server] Answer is evaluated.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    void evaluateAnswer(String answer) {
        /**
         * It evaluates the answer received from the client.
         * @param answer answer received from the client.*/
        boolean isCorrect = answer.equalsIgnoreCase(answers.get(QuestionIndex));
        QuestionIndex++;
        onAnswerEvaluated(isCorrect);
    }
}

class QuizGameClient extends QuizGame implements QuizGamelistener {
    private Socket clientSocket;
    private DataOutputStream cout;
    private DataInputStream cin;

    @Override
    void startGame(){
        try{
            clientSocket = new Socket("localhost",21016);
            super.startGame();
            askQuestion();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Override
    void askQuestion() {
        /**
         * It displays the question to the client and asks the user inout as the answer and sends it to the server
         */
        try{
            cin = new DataInputStream(clientSocket.getInputStream());
            cout = new DataOutputStream(clientSocket.getOutputStream());
            String question = cin.readUTF();
            System.out.println("Question asked: "+question);
            Scanner input= new Scanner(System.in);
            System.out.print("Enter the answer: ");
            String answer = input.nextLine();
            onQuestionAsked(question);
            evaluateAnswer(answer);
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    void evaluateAnswer(String answer) {
        /**
        * Sends the answer to the client
        * @param answer -> answer to the question asked.
         * */
        try{
            cin = new DataInputStream(clientSocket.getInputStream());
            cout = new DataOutputStream(clientSocket.getOutputStream());
            cout.writeUTF(answer);
            String result = cin.readUTF();
            boolean isCorrect = result.equalsIgnoreCase("Correct");
            onAnswerEvaluated(isCorrect);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Override
    public void onQuestionAsked(String question) {
        System.out.println("[Client] Answered the question.");
    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect){
            System.out.println("The answer is correct. ");
            System.out.println("You are the Winner");
        }
        else {
            System.out.println("The answer is incorrect");
        }

    }
}
public class simpleOnlineQuiz extends Thread{
    @Override
    public void run() {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }

    public static void main(String[] args){
        QuizGameServer server = new QuizGameServer();
        simpleOnlineQuiz thread1 = new simpleOnlineQuiz();
        thread1.start();
        server.startGame();
    }
}
