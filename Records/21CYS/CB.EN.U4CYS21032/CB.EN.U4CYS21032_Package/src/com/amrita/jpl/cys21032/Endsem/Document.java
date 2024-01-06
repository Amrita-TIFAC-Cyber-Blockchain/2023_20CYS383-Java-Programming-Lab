
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
        System.out.println("Document: " + getFileName() + ", Size: " + getFileSize() + ", Type: " + getDocumentType());
    }
}

