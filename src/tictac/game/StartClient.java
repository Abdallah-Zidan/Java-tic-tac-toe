/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;
import network.Client;
import network.Client;

/**
 *
 * @author Rola
 */
public class StartClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client application; // declare client application 
        // if no command line args 
        if ( args.length == 0 ) 
          application = new Client( "127.0.0.1" ); // localhost 
        else 
          application = new Client(args[ 0 ]); // use args 
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    }
    
}
