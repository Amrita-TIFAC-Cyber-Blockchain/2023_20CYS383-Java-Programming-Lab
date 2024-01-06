package com.amrita.jpl.cys21061.pract.FileTransfer;

public class Main {
    public static void main(String[] args) {
        FileTransferClient client = new FileTransferClient();
        FileTransferServer server = new FileTransferServer();

        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("File sent: " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("File saved: " + filename);
            }
        };

        client.setListener(listener);
        server.setListener(listener);

        // Start the server in a separate thread
        Thread serverThread = new Thread(server::start);
        serverThread.start();

        // Wait for a moment to ensure the server is up and running
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Send a file from the client
        String filename = "C:\\Users\\roshn\\OneDrive\\Desktop\\Java Programming\\maven.txt";
        client.sendFile(filename);
    }
}
