package com.amrita.jpl.cys21035.ex;

interface FileTransferListener {
    void onFileSent(String filename);

    void onFileSaved(String filename);
}
