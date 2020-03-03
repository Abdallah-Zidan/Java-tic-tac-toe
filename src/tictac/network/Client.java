package tictac.network;

import java.io.*;
import java.net.*;
import tictac.game.MainGame;

public class Client  {
    public Client(String ip) {
        try {
            MainGame.gameInfo.socket = new Socket(ip, 5000);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
