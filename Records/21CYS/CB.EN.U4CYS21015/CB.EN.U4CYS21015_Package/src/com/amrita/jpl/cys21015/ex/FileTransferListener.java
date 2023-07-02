package com.amrita.jpl.cys21015.ex;


public interface FileTransferListener{
    void onFileSent(String filename);
    void onFileSaved(String filename);
}