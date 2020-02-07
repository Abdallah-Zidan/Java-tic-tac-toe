package tictac.network;

import java.io.IOException;
import java.net.*;
import tictac.game.MainGame;

public class Server {

    Socket client = null;

    public Server() {
        try {
            if (MainGame.gameInfo.serverSocket == null) {
                MainGame.gameInfo.serverSocket = new ServerSocket(5000);
            }
            client = MainGame.gameInfo.serverSocket.accept();
            MainGame.gameInfo.socket = client;
            System.out.println("Client has connected");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public synchronized Socket getSocket() {
        return client;
    }
}
