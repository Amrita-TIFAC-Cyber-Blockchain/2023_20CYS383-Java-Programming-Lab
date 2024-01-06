package com.amrita.jpl.cys21060.EndSem;

public class Document extends File {
    private String documentType;

    public Document(String fileName, double fileSize, String documentType){
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() { return this.documentType; }
    public void setDocumentType(String type) { this.documentType = type; }

    @Override
    public void displayFileDetails() {
        System.out.println("com.amrita.jpl.cys21060.endsem.Document: " + getFileName() + ", Size: " + getFileSize() + ", Type: " + getDocumentType());
    }
}

