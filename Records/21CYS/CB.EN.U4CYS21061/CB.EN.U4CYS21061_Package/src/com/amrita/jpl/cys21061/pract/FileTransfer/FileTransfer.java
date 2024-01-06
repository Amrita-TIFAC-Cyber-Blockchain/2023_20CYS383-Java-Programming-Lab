package com.amrita.jpl.cys21061.pract.FileTransfer;
import java.io.Serializable;

public abstract class FileTransfer {
    private FileTransferListener listener;

    public void setListener(FileTransferListener listener) {
        this.listener = listener;
    }

    public void sendFile(String filename) {
        // Implement sendFile logic
        byte[] fileData = readFromFile(filename);
        saveFile(fileData, filename);
    }

    protected abstract byte[] readFromFile(String filename);

    protected void notifyFileSent(String filename) {
        if (listener != null) {
            listener.onFileSent(filename);
        }
    }

    protected void notifyFileSaved(String filename) {
        if (listener != null) {
            listener.onFileSaved(filename);
        }
    }

    protected abstract void saveFile(byte[] fileData, String filename);
}
