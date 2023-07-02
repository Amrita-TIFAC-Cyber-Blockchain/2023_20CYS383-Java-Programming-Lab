package com.amrita.jpl.cys21030.pract;

public class Main_prac {
    public static void main(String[] args) {
        server_prac server = new server_prac();
        Client_prac client = new Client_prac();

        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                server.main(new String[]{});
            }
        });

        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                client.main(new String[]{});
            }
        });

        serverThread.start();
        clientThread.start();
    }
}


