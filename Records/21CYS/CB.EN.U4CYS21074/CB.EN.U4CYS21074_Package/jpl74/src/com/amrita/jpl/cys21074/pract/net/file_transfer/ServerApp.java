package com.amrita.jpl.cys21074.pract.net.file_transfer;

public class ServerApp implements FileTransferListener {
    private final FileTransferServer fileTransferServer;

    public ServerApp(int serverPort) {
        fileTransferServer = new FileTransferServer(serverPort, this);
    }

    public void startServer() {
        fileTransferServer.start();
    }

    @Override
    public void onFileSent(String filename) {
        // Server-side does not send files
    }

    @Override
    public void onFileSaved(String filename) {
        System.out.println("File saved: " + filename);
    }

    public static void main(String[] args) {
        ServerApp serverApp = new ServerApp(12345);
        serverApp.startServer();
    }
}

