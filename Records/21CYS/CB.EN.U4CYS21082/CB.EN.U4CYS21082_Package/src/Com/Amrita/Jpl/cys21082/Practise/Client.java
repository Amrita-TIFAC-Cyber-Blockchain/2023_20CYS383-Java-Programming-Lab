package Com.Amrita.Jpl.cys21082.Practise;

import java.io.*;
import java.net.*;


public class Client {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends and receives messages, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server at "localhost" on port 2444
            Socket socket = new Socket("localhost", 2444);

            // Create a DataInputStream to receive messages from the server
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Continuously send and receive messages until the server sends an "exit" message
            while (true) {
                // Read the message from the server
                String receivedMessage = dis.readUTF();
                System.out.println("Server: " + receivedMessage);

                // Check if the server sent an "exit" message to terminate the client
                if (receivedMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting...");
                    break;
                }

                // Send a message to the server
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Client: ");
                String messageToSend = br.readLine();
                dos.writeUTF(messageToSend);
                dos.flush();
            }

            // Close the input stream, output stream, and the socket
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
