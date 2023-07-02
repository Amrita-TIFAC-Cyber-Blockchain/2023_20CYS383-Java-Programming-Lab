package com.amrita.jpl.cys21046.endsem;

/**
 * The Document class represents a document file that extends the File class.
 */
public class Document extends File {
    private String documentType;

    /**
     * Constructs a Document object with the specified file name, file size, and document type.
     *
     * @param fileName      the name of the document file
     * @param fileSize      the size of the document file
     * @param documentType  the type of the document
     */
    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    /**
     * Retrieves the type of the document.
     *
     * @return the document type
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the type of the document.
     *
     * @param documentType  the document type to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Displays the details of the document, including the file details and the document type.
     */
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}
