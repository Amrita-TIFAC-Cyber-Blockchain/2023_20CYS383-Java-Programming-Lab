import java.io.*;
import java.net.*;
import java.util.Scanner;


public class SimpleClient {

    public static void main(String[] args) {

        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);

            // Create a DataInputStream to receive messages from the server.
            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println("Messaging to the Server.");
            // Sending messages to the server by using the Do-While Loop
            String msg;
            do {
                System.out.print("Enter a Message: ");
                String str = input.nextLine();
                dout.writeUTF(str); // sending the message to output stream
                dout.flush();
                msg = din.readUTF(); // reading the message from the input stream of server.
                System.out.println("Server: " + msg);
                if(msg.equals("exit")) {
                    System.out.println("Connection closed.");
                    dout.close();
                    din.close();
                    s.close(); // Close the output stream and the socket if the server sends exit.
                }
            } while (!msg.equals("exit"));

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
