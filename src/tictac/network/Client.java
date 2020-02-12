package tictac.network;

import java.io.*;
import java.net.*;
import tictac.game.MainGame;

public class Client {

    Socket mainSocket = null;

    public Client(String ip) {

        try {
            mainSocket = new Socket(ip, 5000);
            MainGame.gameInfo.socket = mainSocket;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    synchronized public Socket getSocket() {
        return mainSocket;
    }

}
