package com.amrita.jpl.cys21074.pract.net.file_transfer;

import java.io.File;

public abstract class FileTransfer {
    public abstract void sendFile(String filename);

    public abstract void saveFile(byte[] fileData, String filename);

    protected String getFileNameFromPath(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }
}

