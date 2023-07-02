package com.amrita.jpl.cys21014.endsem;

/**
 * class 'com.amrita.jpl.cys21014.endsem.Document' inherits from com.amrita.jpl.cys21014.endsem.File
 * Attributes: documentType
 * Methods: getters and setters for documentType, displayFileDetails()
 */
public class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getDocumentType() {
        return documentType;
    }
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document: " + documentType );
    }
}

