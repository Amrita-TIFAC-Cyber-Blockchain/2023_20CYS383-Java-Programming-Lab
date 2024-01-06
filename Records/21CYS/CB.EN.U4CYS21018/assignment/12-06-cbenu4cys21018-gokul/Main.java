import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

  abstract static class FileTransfer {

    void sendFile(String fileName) {
      // Default implementation for sending a file
      System.out.println("Sending file: " + fileName);
    }

    abstract void saveFile(byte[] fileData, String fileName);
  }

  public interface FileTransferListener {
    void onFileSent(String fileName);
    void onFileSaved(String fileName);
  }

  public static class FileTransferClient extends FileTransfer implements FileTransferListener {

    void sendFile(String fileName) {
      // Custom implementation for sending a file using socket programming
      System.out.println("Sending file over the network: " + fileName);
    }

    public void onFileSaved(String fileName) {
      System.out.println("File saved on the client side: " + fileName);
    }

    public void onFileSent(String fileName) {
      System.out.println("File sent from the client side: " + fileName);
    }

    void saveFile(byte[] fileData, String fileName) {
      // Not applicable for the client side
    }
  }

  public static class FileTransferServer extends FileTransfer implements FileTransferListener {

    @Override
    void saveFile(byte[] fileData, String fileName) {
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(fileData);
        fileOutputStream.close();
      } catch (IOException e) {
        System.out.println("Failed to save file: " + fileName);
        return;
      }

      onFileSaved(fileName);
    }

    void sendFile(String fileName) {
      // Not applicable for the server side
    }

    public void onFileSaved(String fileName) {
      System.out.println("File saved on the server side: " + fileName);
    }

    public void onFileSent(String fileName) {
      System.out.println("File sent from the server side: " + fileName);
    }

    void start() {
      // Server initialization and listening for incoming file transfers
      System.out.println("Server started. Listening for incoming file transfers.");
    }
  }

  public static void main(String[] args) {
    FileTransferClient client = new FileTransferClient();
    FileTransferServer server = new FileTransferServer();
    
    // Start the server to listen for incoming file transfers
    server.start();

    // Demonstrate sending a file from the client to the server
    client.sendFile("file.txt");

    // Demonstrate saving a file on the server
    byte[] fileData = "This has been overwritten from here".getBytes();
    server.saveFile(fileData, "file.txt");
    
    // print the contents of the file from server side
    System.out.println("File contents on the server side: " + new String(fileData));
    
  }
}
