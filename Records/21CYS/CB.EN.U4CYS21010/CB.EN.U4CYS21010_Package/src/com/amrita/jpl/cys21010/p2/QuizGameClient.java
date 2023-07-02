package com.amrita.jpl.cys21010.p2;

import java.awt.geom.Arc2D;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class QuizGameClient extends  QuizGame {
    private DataInputStream dis;
    private DataOutputStream dout;

    /***
     *
     */
    void startGame(){// renave this to startGame

        try {
            Socket s = new Socket("localhost", 1234);
            this.dis = new DataInputStream(s.getInputStream());
            this.dout = new DataOutputStream(s.getOutputStream());
            String str = dis.readUTF();
            System.out.println(str);



        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }


    @Override
    void askQuestion() throws IOException {
        String str = dis.readUTF();
        System.out.println(str);





    }

    @Override
    void evaluateAnswer() throws IOException {
//        Arc2D.Double input;
        Double input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextDouble();
        dout.writeDouble(input);
        dout.flush();
        String str = dis.readUTF();
        System.out.println(str);


    }

}
