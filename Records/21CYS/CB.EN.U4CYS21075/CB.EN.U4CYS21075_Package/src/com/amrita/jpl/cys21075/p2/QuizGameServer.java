package com.amrita.jpl.cys21075.p2;

import java.io.*;
import java.net.*;
import java.util.*;

abstract class QuizGame{
    public void startGame(){
        System.out.println("Following are the rules for the quiz : ");
        System.out.println("1.) Client will be offered only one chance to answer the a question");
        System.out.println("2.) Clients can skip the question by pressing enter");
        System.out.println("3.) Answers should be in small letters only or else it would be marked as incorrect");
        System.out.println("So, Let's Start the Quiz");
        System.out.println("Best of luck to all the participants");

    }

    public abstract void askQuestion();

    public abstract void evaluateAnswer(String answer);


}

class QuizGameServerUse extends QuizGame{

    @Override
    public void askQuestion() {

    }

    @Override
    public void evaluateAnswer(String answer) {

    }
}
public class QuizGameServer implements QuizGameListener{

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2444);
            ServerSocket sj = new ServerSocket(2445);


            Socket s = ss.accept();
            Socket j = sj.accept();
            System.out.println("Client Connected");


            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataInputStream jis = new DataInputStream(j.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataOutputStream jout = new DataOutputStream(j.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String temp;
            String jemp;
            int marks = 0;
            int markj = 0;
            int n = 1;
            //dout.writeUTF("You are C");

            do {


                temp = Question(n);
                jemp = Question(n);
                dout.writeUTF(temp);
                jout.writeUTF(temp);
                String str = dis.readUTF();
                String jtr = jis.readUTF();
                if(str.equals(Answers(n))){
                    marks+=10;
                }
                if(jtr.equals(Answers(n))){
                    marks+=10;
                }

                n++;
                dout.flush();
            }while(n<6);
            if(marks > markj){
                dout.writeUTF("Your Marks = "+marks +"/nYOU WON!");
                jout.writeUTF("Your marks = "+markj+"YOU LOST");
            }
            else if(markj > marks){
                jout.writeUTF("Your marks = "+markj+"YOU WON");
                dout.writeUTF("Your Marks = "+marks +"YOU LOST");
            }
            else{
                dout.writeUTF("Your marks = "+marks+"It was a draw");
                jout.writeUTF("Your Marks = "+markj +"It was a draw");
            }
            dout.writeUTF("END");
            jout.writeUTF("END");
            // Close the output stream and the socket
            dout.close();
            jout.close();

            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public static String Question(int n){
        switch (n){
            case 1 : return "Where is Taj Mahal ?";
            case 2 : return "Who is the President of United States of America ?";
            case 3 : return "What is the Captal of United Kingdom ?";
            case 4 : return "Which is the last point of India ?";
            case 5 : return "In which country Eiffel Tower is located ?";
        }
        return "";
    }

    public static String Answers(int n){
        switch (n){
            case 1 : return "agra";
            case 2 : return "joe biden";
            case 3 : return "london";
            case 4 : return "kanyakumari";
            case 5 : return "france";
        }
        return "";
    }





    @Override
    public void onQuestionAsked(String question) {

    }

    @Override
    public void onAnswerEvaluated(boolean isCorrect) {

    }
}
