package com.amrita.jpl.cys21074.pract.net.file_transfer;

public class ClientApp implements FileTransferListener {
    private final FileTransferClient fileTransferClient;

    public ClientApp(String serverAddress, int serverPort) {
        fileTransferClient = new FileTransferClient(serverAddress, serverPort, this);
    }

    public void sendFile(String filename) {
        fileTransferClient.sendFile(filename);
    }

    @Override
    public void onFileSent(String filename) {
        System.out.println("File sent: " + filename);
    }

    @Override
    public void onFileSaved(String filename) {
        // Client-side does not save files
    }

    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp("localhost", 12345);
        clientApp.sendFile("C:\\Users\\rtsud\\OneDrive\\Desktop\\College\\java\\jpl74\\src\\com\\amrita\\jpl\\cys21074\\pract\\net\\file_transfer\\client_file.txt");
    }
}

