package com.amrita.jpl.cys21027.exercise.ClientServer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**

 *File_Server_Transfer is an abstract class that provides methods for saving files and sending files.
 *Subclasses must implement these methods according to their specific requirements.
 * @author : K Sri Sai Nitin
 * @version: 1.0
 *
 */
abstract class File_Server_Transfer {

    /**

     *Saves the file data to a specified filename.
     *@param fileData The byte array containing the file data.
     *@param filename The name of the file to save.
     */
    abstract void saveFile(byte[] fileData, String filename);
    /**

     * Sends the file with the specified filename.
     * @param filename The name of the file to send.
     */
    abstract void sendFile(String filename);
}
/**

 * The FileTransferListener interface defines callback methods for file transfer events.
 */
interface FileTransferListener {

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

 * FileTransferServer is a class that extends File_Server_Transfer and implements file transfer functionality on the server side.
 */
class FileTransferServer extends File_Server_Transfer {
    private FileTransferListener listener;

    /**

     * Saves the file data to the specified filename.
     * @param fileData The byte array containing the file data.
     * @param filename The name of the file to save.
     */
    @Override
    void saveFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();

            if (listener != null) {
                listener.onFileSaved(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**

     * Sends the file with the specified filename.
    *  @param filename The name of the file to send.
     */
    @Override
    void sendFile(String filename) {
// Implementation for sending files from server to client
    }
    /**

     * Starts the file transfer server by listening for incoming connections on a specified port.
     * It creates a new thread to handle each client connection.
     */
    void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
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
    /**

     * A private inner class that handles client connections on a separate thread.
     */
    private class ClientHandler implements Runnable {
        private Socket socket;

        /**

         * Constructs a ClientHandler with the specified socket.
         * @param socket The socket representing the client connection.
         */
        ClientHandler(Socket socket) {
            this.socket = socket;
        }
        /**
         * Runs the client handler thread, receiving file data from the client and saving it to a file.
         */
        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String filename = dataInputStream.readUTF();

                FileOutputStream fileOutputStream = new FileOutputStream(filename);

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.close();
                inputStream.close();

                if (listener != null) {
                    listener.onFileSaved(filename);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**

 * FileClientServer is the main class that starts the file transfer server.
 */
public class FileClientServer {

    /**

     * The main method that starts the file transfer server.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        FileTransferServer server = new FileTransferServer();

        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Implementation for handling file sent event
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };

        server.setListener(listener);
        server.start();
    }
}