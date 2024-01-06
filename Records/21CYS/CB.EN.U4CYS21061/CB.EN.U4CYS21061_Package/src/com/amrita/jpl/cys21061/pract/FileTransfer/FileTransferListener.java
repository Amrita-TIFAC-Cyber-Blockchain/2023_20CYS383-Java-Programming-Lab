package com.amrita.jpl.cys21061.pract.FileTransfer;
public interface FileTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}
