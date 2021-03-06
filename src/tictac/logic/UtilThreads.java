package tictac.logic;

import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.*;
import tictac.animation.CustomAlert;
import tictac.game.MainGame;


/**
 * this thread is used to take the read position from the reader thread in order
 * to draw the opponent mark in the right position it must be run using
 * (Platform.runLater) method as it changes the scene and must be run in
 * application thread constructor takes the row and column numbers as integer
 * values and a reference to the current TwoPlayersNetwork object
 */
class PlayLater implements Runnable {

    TwoPlayersNetwork tpn;
    int x;
    int y;

    PlayLater(int x, int y, TwoPlayersNetwork tpn) {
        this.x = x;
        this.y = y;
        this.tpn = tpn;
    }

    public void run() {
        tpn.play(x, y);
        tpn.myTurn = true;
        if (!tpn.gameEnded) {
            tpn.ui.enableButtons();
        }
    }
}

/**
 * this thread is to be run when one of the players leave the game or exit the
 * application it must be run using Platform.runLater method as it changes the
 * scene and must be run in application thread constructor takes a reference to
 * the current TwoPlayersNetwork object
 */
class ConnectionLost implements Runnable {
    TwoPlayersNetwork tpn;
    public ConnectionLost(TwoPlayersNetwork tpn) {
        this.tpn = tpn;
    }

    @Override
    public void run() {        
        tpn.closeGame(MainGame.gameInfo.socket, tpn.dis, tpn.printStream);
        tpn.ui.stopSound();
        CustomAlert alert = new CustomAlert();  
    }
}

/**
 * this thread is the one responsible for reading data sent from the other
 * player through the network constructor takes a reference to the current
 * TwoPlayersNetwork object
 */
class Reader extends Thread {

    TwoPlayersNetwork tpn;

    public Reader(TwoPlayersNetwork tpn) {
        this.tpn = tpn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String move = tpn.dis.readLine();
                if (move != null) {
                    if (move.length() > 2) {
                        String[] pos = move.split(",");
                        int x = Integer.parseInt(pos[0]);
                        int y = Integer.parseInt(pos[1]);
                        System.out.println(x + " , " + y);
                        Platform.runLater(new PlayLater(x, y, tpn));
                    } else if(move.equals("1")) {
                        Platform.runLater(() -> {
                            tpn.ui.enableButtons();
                        });
                    }
                } else {
                    Platform.runLater(new ConnectionLost(tpn));
                    break;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                Platform.runLater(new ConnectionLost(tpn));
                break;
            }
        }
    }
}
