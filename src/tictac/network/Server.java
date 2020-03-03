package tictac.network;

import java.io.IOException;
import java.net.*;
import tictac.game.MainGame;

public class Server {
    public Server() {
        try {
            if (MainGame.gameInfo.serverSocket == null)
                MainGame.gameInfo.serverSocket = new ServerSocket(5000);

            MainGame.gameInfo.socket = MainGame.gameInfo.serverSocket.accept();
            System.out.println("Client has connected");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
