package com.amrita.jpl.cys21015.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 *  @author Dyanesh S
 *  @version 1.0
 */

public class QuizGameServer extends QuizGame implements QuizGameListener{

    private  List<String> ques;
    private  List<String> ans_list = Arrays.asList("James Gosling", "Guido van Rossum", "Bjarne Stroustrup");
    //private  List<Socket> clients;
    private int no = 0;
    private Socket socket;
    DataInputStream din;
    DataOutputStream dout;

    int score;

    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }

    /**
     * This Constructor is for creating a server socket and connecting a client
     * @return no return
     */

    public QuizGameServer() {
        try {
            ServerSocket serversocket = new ServerSocket(42011);
            System.out.println("Server started. Waiting for clients to connect...");
            socket = serversocket.accept();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is for initializing the input and output streams and starts the quiz
     * @return no return
     */

        @Override
        void startGame() {
            try {
                System.out.println("Client Connected");
                // Create a DataInputStream to receive messages from the client
                din = new DataInputStream(socket.getInputStream());
                dout = new DataOutputStream(socket.getOutputStream());
                dout.writeUTF("Welcome to JPL Quiz!");
                askQuestion();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


            @Override
    void askQuestion() throws IOException {

        String ans;
        dout.writeUTF("Question 1: Who created Java");
        ans = din.readUTF();
        evaluateAnswer(ans);
        no++;

        dout.writeUTF("Question 2: Who created Python");
        ans = din.readUTF();
        evaluateAnswer(ans);
        no++;

        dout.writeUTF("Question 3: Who created C++");
        ans = din.readUTF();
        evaluateAnswer(ans);
        no++;

        dout.writeUTF("\nCongratulations!, your score is " + score);
    }

    @Override
    void evaluateAnswer(String answer) throws IOException {
        if (answer.equals(ans_list.get(no)))
        {
            score++;
            dout.writeUTF("Correct Answer\n");
        }
        else {
            dout.writeUTF("Wrong Answer");
        }
    }


    @Override
    public void onQuestionAsked(String question) {

    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {

    }
}
