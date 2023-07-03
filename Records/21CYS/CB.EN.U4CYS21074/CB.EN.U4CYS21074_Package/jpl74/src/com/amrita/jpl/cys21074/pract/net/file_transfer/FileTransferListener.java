package com.amrita.jpl.cys21074.pract.net.file_transfer;

public interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}

