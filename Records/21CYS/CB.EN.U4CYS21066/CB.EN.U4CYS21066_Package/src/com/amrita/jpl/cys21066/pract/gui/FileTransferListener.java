package com.amrita.jpl.cys21066.pract.gui;

public interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}
