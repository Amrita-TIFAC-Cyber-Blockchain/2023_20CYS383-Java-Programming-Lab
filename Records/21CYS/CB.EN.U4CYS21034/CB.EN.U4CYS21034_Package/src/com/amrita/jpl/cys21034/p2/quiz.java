package com.amrita.jpl.cys21034.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


abstract class QuizGame {

    void startGame() {

        askQuestion();
        evaluateAnswer("Sample answer");
    }


    abstract String askQuestion();


    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame implements QuizGameListener {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     */

    static int ques = 1;
    int mark = 0;
    /**
     * This method should start the quiz game and handle the overall
     * flow of the game.
     */
    void startGame()
    {
        Scanner input = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(12345);


            Socket s = ss.accept();


            DataInputStream dis = new DataInputStream(s.getInputStream());


            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str;
            String msg = "0";
            System.out.println("Receiving Messages from the client.");
            int i = 1;

            do{
                if(!msg.equals("exit")) {
                    i++;
                    /*str = dis.readUTF();
                    System.out.println("Client Message: " + str);
                    evaluateAnswer(str);
                    System.out.print("server sending message: ");
                    msg = askQuestion();
                    dout.writeUTF(msg);
                    dout.flush();*/
                    msg = askQuestion();
                    dout.writeUTF(msg);
                    dout.flush();
                    str = dis.readUTF();
                    System.out.println("Client Message: " + str);
                    evaluateAnswer(str);

                }
            }
            while(true);



        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
    public void onQuestionAsked(String question)
    {}
    public void onAnswerEvaluated(boolean iscorrect)
    {
        mark++;
    }
    /**
     * asks question to the client
     */
    String askQuestion()
    {
        String a = "1+"+Integer.toString(ques);
        ques+=1;
        return a;
    }

    void evaluateAnswer(String answer)
    {
        if(answer == "2")
        {
            System.out.println("Correct");
            onAnswerEvaluated(true);
        }
        else {
            System.out.println("Wrong");
        }
    }
    QuizGameServer() throws IOException {

    }
}

class QuizGameClient extends QuizGame {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connectio
     */
    void startGame()
    {
        try {

            Socket s = new Socket("localhost", 12345);


            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);


            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println("Messaging to the Server.");

            String msg;
            int i=1;
            do {
                msg = din.readUTF();
                System.out.println("Server: " + msg);
                System.out.print("client sending message: ");
                String str = input.nextLine();
                dout.writeUTF(str);
                dout.flush();

                i++;
                if(!msg.equals("exit")) {
                    System.out.println("Connection closed.");
                    dout.close();
                    din.close();
                    s.close();
                }
            } while (!msg.equals("exit"));

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
    public void onQuestionAsked(String question)
    {}
    public void onAnswerEvaluated(boolean iscorrect)
    {}
    String askQuestion()
    {
        return "0";
    }

    void evaluateAnswer(String answer)
    {}

    public QuizGameClient()
    {
    }
}


public class quiz
{
    public static void main(String args[])
    {
        int port = 1234;
        String host = "localhost";

        try {

            Thread serverThread = new Thread(() -> {
                try {
                    QuizGameServer s = new QuizGameServer();
                    s.startGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverThread.start();


            Thread.sleep(1000);


            QuizGameClient c = new QuizGameClient();
            c.startGame();


            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}