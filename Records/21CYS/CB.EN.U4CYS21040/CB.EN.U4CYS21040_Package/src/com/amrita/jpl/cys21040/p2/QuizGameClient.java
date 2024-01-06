package com.amrita.jpl.cys21040.p2;


import java.net.Socket;
import java.io.*;
class QuizGameClient extends QuizGame{

    boolean isCorrect = false;

    Socket sk = new Socket("localhost", 8080);

    QuizGameClient() throws IOException {
    }

    /*
    * The startGame function connects to the server
    * with the port number 8080 in the same machine
    * @return void*/
    public void startGame(){
        if(this.sk != null) {
            System.out.println("Connected to server.");
        }
        else{
            System.out.println("Failed");
        }
        askQuestion();

    }

    /*
    * askQuestion method gets the question from the server
    * and reads it to the client*/
    void askQuestion(){
        try
            {

                BufferedReader ip = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                System.out.print("Enter your answer: ");
                BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
                String a = op.readLine();
                evaluateAnswer(a);
            }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    void evaluateAnswer(String answer){
        System.out.println("Client: Answer evaluated - " + (answer == "YES"  ? "Correct" : "Incorrect"));
    }
    public static void main(String[] args) throws IOException {
        QuizGameClient cli = new QuizGameClient();
        cli.startGame();
    }

}