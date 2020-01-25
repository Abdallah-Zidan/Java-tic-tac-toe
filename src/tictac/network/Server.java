/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.logging.Level;

/**
 *
 * @author Rola
 */
public class Server {
    private int port;
    private ServerSocket listener;
    private boolean running;
    
    public void startServer(){
        try
        {
            listener = new ServerSocket(getPort(),2); 
            running = true;
            System.out.println("Tic Tac Toe Server is Running");
        }catch(IOException e){
           LOGGER.log(Level.SEVERE, "Exception occur", e);
        }    
    }
    
    public void stopServer(){
        running = false;
        try{
            listener.close();
        }catch(IOException ioex){
        }
    }
    

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerSocket getListener() {
        return listener;
    }

    public void setListener(ServerSocket listener) {
        this.listener = listener;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
    
   
    
}
