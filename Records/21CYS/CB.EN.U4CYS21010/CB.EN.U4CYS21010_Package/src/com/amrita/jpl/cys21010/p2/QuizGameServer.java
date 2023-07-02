package com.amrita.jpl.cys21010.p2;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizGameServer extends QuizGame {
    private DataInputStream dis;
    private  DataOutputStream dout;
    private  ServerSocket ss;
    private  Socket s;
    private  double r;
    QuizGameServer() throws IOException {
        try {
            this.ss = new ServerSocket(1234);

            this.s = ss.accept();
            System.out.println("got it");
             this.dis = new DataInputStream(this.s.getInputStream());
             this.dout = new DataOutputStream(this.s.getOutputStream());
            System.out.println("Server is Running");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
        dout.flush();
    }
    void startGame() throws IOException {
        dout.writeUTF("welcome to the game");
//        dout.flush();
    }


    @Override
    void askQuestion() throws IOException {
        this.r = Math.random();
        dout.writeUTF("what is "+this.r);
//        dout.flush();
    }

    @Override
    void evaluateAnswer() throws IOException {
        double answer = 0;
        boolean flag;
//        while(answer ){
//        answer = dis.readUTF();
//        dis.readDouble()
//            System.out.println(answer);
//        }
         answer = dis.readDouble();
//        while (true){
//            answer = dis.readUTF();
//            if (answer != null){
//                break;
//            }
//        }
//        dout.flush();
        System.out.println(answer);
//        dout = new DataOutputStream(this.s.getOutputStream());
        if (answer == this.r){
            System.out.println("yes correct");
            this.dout.writeUTF("correct ans");
        }
        else{
            this.dout.writeUTF("wrong ans");
        }
        dout.flush();

    }

//    public static void main(String[] args) {
//        new QuizGameServer();
//    }
}
