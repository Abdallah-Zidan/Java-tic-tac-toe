/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;
import network.ServerGUI;

/**
 *
 * @author Rola
 */
public class StartServer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerGUI application = new ServerGUI();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.execute();
    }
}
