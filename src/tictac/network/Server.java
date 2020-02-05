package tictac.network;

import java.io.IOException;
import java.net.*;
import tictac.game.MainGame;

public class Server {

    ServerSocket serverSocket;
    Socket client = null;

    public Server() {
        try {
            serverSocket = new ServerSocket(5000);
            MainGame.gameInfo.serverSocket = serverSocket;

            //  while(client == null){
            client = serverSocket.accept();
            MainGame.gameInfo.socket = client;
            //    }

            System.out.println("Client has connected");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public synchronized Socket getSocket() {
        return client;
    }
}
