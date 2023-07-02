package com.amrita.jpl.cys21043.pract;

import java.util.ArrayList;
import java.util.List;

// Abstract class FileTransfer
abstract class FileTransfer {
    List<FileTransferListener> listeners;

    public FileTransfer() {
        listeners = new ArrayList<>();
    }

    public void addListener(FileTransferListener listener) {
        listeners.add(listener);
    }

    public void removeListener(FileTransferListener listener) {
        listeners.remove(listener);
    }

    public void sendFile(String filename) {
        System.out.println("Sending file: " + filename);
        // Implement file sending logic

        for (FileTransferListener listener : listeners) {
            listener.onFileSent(filename);
        }
    }

    abstract void saveFile(byte[] fileData, String filename);
}

// Interface FileTransferListener
interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

// FileTransferClient class
class FileTransferClient extends FileTransfer {
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Not required for the client-side
    }

    @Override
    public void sendFile(String filename) {
        super.sendFile(filename);
        // Implement file sending logic using socket programming
    }
}

// FileTransferServer class
class FileTransferServer extends FileTransfer {
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Implement file saving logic on the server's disk
        System.out.println("Saving file: " + filename);

        FileTransferListener[] listeners = this.listeners.toArray(new FileTransferListener[0]);
        for (FileTransferListener listener : listeners) {
            listener.onFileSaved(filename);
        }
    }

    public void start() {
        // Implement server startup and file transfer listening logic
    }
}

// Main class to demonstrate the functionality
public class File {
    public static void main(String[] args) {
        // Create instances of client and server
        FileTransferClient client = new FileTransferClient();
        FileTransferServer server = new FileTransferServer();

        // Add listeners to client and server
        client.addListener(new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("Client: File sent - " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                // Not required for the client-side
            }
        });

        server.addListener(new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Not required for the server-side
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("Server: File saved - " + filename);
            }
        });

        // Demonstrate functionality
        client.sendFile("example.txt"); // Sending file: example.txt

        server.saveFile(new byte[]{}, "example.txt"); // Saving file: example.txt
    }
}

