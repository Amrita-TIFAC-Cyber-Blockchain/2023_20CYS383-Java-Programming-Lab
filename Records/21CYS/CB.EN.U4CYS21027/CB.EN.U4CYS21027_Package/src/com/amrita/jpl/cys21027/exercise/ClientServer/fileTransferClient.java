package com.amrita.jpl.cys21027.exercise.ClientServer;

import java.io.*;
import java.net.Socket;


/**

 * File_Client_Transfer is an abstract class that provides methods for saving files and sending files from the client side.
 * Subclasses must implement these methods according to their specific requirements.
 * @author : K Sri Sai Nitin
 * @version: 1.0

 */
abstract class File_Client_Transfer {

    /**

     * Saves the file data to a specified filename.
     * @param fileData The byte array containing the file data.
     * @param filename The name of the file to save.
     */
    abstract void saveFile(byte[] fileData, String filename);
    /**

     * Sends the file with the specified filename.
     * @param filename The name of the file to send.
     */
    abstract void sendFile(String filename);
}
/**

 * The File_Client_Transfer_Listener interface defines callback methods for file transfer events on the client side.
 */
interface File_Client_Transfer_Listener {

    /**

     * Called when a file is successfully sent.
     * @param filename The name of the sent file.
     */
    void onFileSent(String filename);
    /**

     * Called when a file is successfully saved.
     * @param filename The name of the saved file.
     */
    void onFileSaved(String filename);
}
/**

 * FileTransferClient is a class that extends File_Client_Transfer and implements file transfer functionality on the client side.
 */
class FileTransferClient extends File_Client_Transfer {
    private FileTransferListener listener;

    /**

     * Saves the file data to the specified filename.
     * @param fileData The byte array containing the file data.
     * @param filename The name of the file to save.
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
// Implementation for saving files on the client side
    }
    /**

     * Sends the file with the specified filename.
     * @param filename The name of the file to send.
     */
    @Override
    void sendFile(String filename) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream outputStream = socket.getOutputStream();
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            fileInputStream.close();
            outputStream.close();
            socket.close();
            // Notify listener
            if (listener != null) {
                listener.onFileSent(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the listener for file transfer events.
     * @param listener The FileTransferListener to set.
     */
    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }
}
/**

 * The fileTransferClient class is the main class that demonstrates sending a file from the client to the server.
 */
public class fileTransferClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    /**

     * The main method that sends a file from the client to the server.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        String filename = "file.txt";
        String serverFilename = "received.txt";

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(serverFilename);

            FileInputStream fileInputStream = new FileInputStream(filename);
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            fileInputStream.close();
            socket.close();

            System.out.println("File sent successfully: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}