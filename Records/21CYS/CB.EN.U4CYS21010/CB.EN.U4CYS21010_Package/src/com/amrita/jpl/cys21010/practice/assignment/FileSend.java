package com.amrita.jpl.cys21010.practice.assignment;
import java.io.*;
import java.util.*;
import java.net.*;
public class FileSend {
    public static void main(String[] args) {
//        Server obj = new Server();
//        obj.StartServer();
        client obj2 = new client();
        obj2.Stclient();
    }
}


class Server {
    void StartServer(){


        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(1234);

            // Wait for a client to establish a connection
            Socket s = ss.accept();
            // Create a DataInputStream to receive messages from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println("Server is Running");
            while(true) {
                // Read the message from the client
                try{
                    String str = dis.readUTF();
                    System.out.println("Message: " + str);
                    if (str.equals("EXIT")){
                        System.out.println("Stopping  the Server !!!");
                        break;
                    }
                }
                catch (EOFException e){

                }
            }

            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

}
class  client{
    void Stclient(){

        try {
            Socket s = new Socket("localhost", 1234);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());


            String fileName = "example.txt";
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                dout.writeUTF(data);
                dout.flush();


            }

            dout.close();
            s.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
