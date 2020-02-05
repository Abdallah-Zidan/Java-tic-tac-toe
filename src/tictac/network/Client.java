package tictac.network;

import java.io.*;
import java.net.*;

public class Client  {

   Socket mainSocket =null;


    public Client(String ip) {

        try {
            mainSocket = new Socket(ip, 5000);
        } catch (IOException ex) {
          //  System.out.println("Something went Wrong");
           // System.exit(0);
        }
    }

synchronized public Socket getSocket(){
    return mainSocket;
}

}
