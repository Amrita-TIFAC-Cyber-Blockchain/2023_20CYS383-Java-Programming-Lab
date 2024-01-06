package com.amrita.jpl.cys21012.endsem;

import java.io.File;
import java.io.IOException;

public interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
}
