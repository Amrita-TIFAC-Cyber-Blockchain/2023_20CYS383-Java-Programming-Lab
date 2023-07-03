package com.amrita.jpl.cys21060.EndSem;

import com.amrita.jpl.cys21060.EndSem.File;

// Interface com.amrita.jpl.cys21060.endsem.FileManager
public interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}

