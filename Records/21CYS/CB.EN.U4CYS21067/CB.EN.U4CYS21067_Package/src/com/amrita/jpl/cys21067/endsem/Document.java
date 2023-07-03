package com.amrita.jpl.cys21067.endsem;

/**
 * The Document class represents a document file with additional properties such as document type.
 * It is a subclass of the File class.
 */
public class Document extends File {
    private String documentType;

    /**
     * Creates a Document object with the specified file name, file size, and document type.
     *
     * @param fileName     The name of the document file.
     * @param fileSize     The size of the document file.
     * @param documentType The type of the document file.
     */
    public Document(String fileName, String fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    /**
     * Gets the document type of the document file.
     *
     * @return The document type of the document file.
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the document type of the document file.
     *
     * @param documentType The document type of the document file.
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Displays the details of the document file, including the file name, file size, and document type.
     */
    @Override
    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}
