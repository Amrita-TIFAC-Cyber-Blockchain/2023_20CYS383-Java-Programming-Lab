package com.amrita.jpl.cys21010.practice.assignment;
import  java.util.*;
import java.net.*;
import java.io.*;
public class fileTransfar {

    public static void main(String[] args) {
        fileTransfar obj = new fileTransfar();

    }
}

abstract  class FileTransfer{
    abstract void sendFile(String filename);
    abstract  void saveFile(byte[] fileData,String filename);

}
interface FileTransferListener{
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

class FileTransferClient extends  FileTransfer{

    @Override
    void sendFile(String filename) {


        try {

            // Create a socket and connect to the server at "localhost" on port 2444
            Socket s = new Socket("localhost", 2444);

            // Create a DataOutputStream to send messages to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);
            // Send a message to the serverz
            while(true) {
                System.out.println("Enter msg to Send:-");
//                String str = scan.nextLine();
                String str = null;
                try {
                    // Change the file path if required
                    String fileName = "example.txt";

                    File myFile = new File(filename);

                    // Create a Scanner to read from the File
                    Scanner myReader = new Scanner(myFile);

                    // Iterate through the file line by line
                    while (myReader.hasNextLine()) {
                        str = myReader.nextLine();
                        System.out.println(str);
                        dout.writeUTF(str);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


                if (str.equals("EXIT")) {
                    System.out.println("Stopping  the Server !!!");
                    break;
                }
                dout.flush();
            }
            // Close the output stream and the socket
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }


    }





    @Override
    void saveFile(byte[] fileData, String filename) {

    }

}

class FileTransferServer extends  FileTransfer{

    @Override
    void sendFile(String filename) {

    }

    @Override
    void saveFile(byte[] fileData, String filename) {

    }
    void start(){};
}
