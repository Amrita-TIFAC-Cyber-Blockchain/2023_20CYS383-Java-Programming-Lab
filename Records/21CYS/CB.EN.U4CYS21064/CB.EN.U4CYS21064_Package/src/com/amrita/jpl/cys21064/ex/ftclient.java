package com.amrita.jpl.cys21064.ex;


import com.amrita.jpl.cys21064.pract.general.FileTransfer;
import com.amrita.jpl.cys21064.pract.general.FileTransferListener;

import java.io.*;
import java.net.Socket;

class FileTransferClient extends FileTransfer
{
    private Socket socket;
    private FileTransferListener listener;

    public FileTransferClient(FileTransferListener ilistener) {
        this.listener = ilistener;
    }

    public void sendFile(String filename)
    {
        try {
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);

            socket = new Socket("localhost", 8080);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(file.getName());
            dataOutputStream.writeLong(fileData.length);
            dataOutputStream.write(fileData, 0, fileData.length);
            dataOutputStream.flush();

            listener.onFileSent(file.getName());

            dataOutputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void saveFile(byte[] fileData, String filename)
    {

    }
}
public class ftclient {
    public static void main(String[] args) {
        FileTransferListener listener = new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("File sent: " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                // Not used in the client
            }
        };

        FileTransferClient client = new FileTransferClient(listener);
        client.sendFile("/Users/rajendraprasad/Desktop/sem4/java/tester/sample.txt");
    }

}

