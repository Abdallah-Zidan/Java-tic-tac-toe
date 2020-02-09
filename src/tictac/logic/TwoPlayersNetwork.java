package tictac.logic;

import java.io.*;
import java.net.Socket;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import tictac.database.*;
import tictac.game.MainGame;
import tictac.ui.*;

public class TwoPlayersNetwork extends Game {

   // private Socket socket;
    private DataInputStream dis;
    private PrintStream printStream;
    public TwoPlayersNetwork(boolean isRecorded, Player oppenent, User user, char myMark, GameBodyScreen ui, Socket socket, boolean myTurn) {
        super(isRecorded, Constants.DUAL, oppenent, user, myMark, ui);
        this.myTurn = myTurn;
        if (!myTurn) {
            disableButtons();
        }
        try {
          //  this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new Reader().start();
    }
    private class ConnectionLost implements Runnable {
        @Override
        public void run() {
                closeGame(MainGame.gameInfo.socket, dis, printStream);
               
                System.out.println("closed");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Connection lost", ButtonType.OK);
                alert.showAndWait();
                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
                ui.stopSound();
        }
    }
    private class PlayLater implements Runnable {
        int x;
        int y;
        PlayLater(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void run() {
            playATurn(x, y);
            myTurn = true;
            if (!gameEnded) {
                enableButtons();
            }
        }
    }
    class Reader extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("reading");
                    String move = dis.readLine();
                    if (move != null) {
                        System.out.println(move);
                        if (move.length() > 2) {
                            String[] pos = move.split(",");
                            int x = Integer.parseInt(pos[0]);
                            int y = Integer.parseInt(pos[1]);
                            System.out.println(x + " , " + y);
                            Platform.runLater(new PlayLater(x, y));
                        } else {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    enableButtons();
                                }
                            });
                        }
                    } else {
                        System.out.println("ended");
                        System.out.println("user left null");
                        Platform.runLater(new ConnectionLost());
                        break;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("finished");
                     System.out.println("user left exception");
                    Platform.runLater(new ConnectionLost());
                    break;
                }
            }
        }
    }
    public void playATurn(int x, int y) {
        play(x, y);
    }
    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }
    public void resetGame(boolean enabled) {
        board = new Board();
        if (enabled) {
            myTurn = true;
        } else {
            disableButtons();
            myTurn = false;
            printStream.println(1);
        }
        clearButtons();
        gameEnded = false;
    }
    @Override
    public void play(int x, int y) {
        int result = 4;
        if (!gameEnded) {
            Position position = null;
            if (myTurn) {
                enableButtons();
                position = makeMove(x, y);
                if (position != null) {
                    board = new Board(board, position, myMark);
                    ui.setText(buttons[x][y], myMark);
                    printStream.println(x + "," + y);
                    printStream.flush();
                    recordStep(x, y, Constants.MINE);
                    myTurn = !myTurn;
                    disableButtons();
                    result = evaluateGame();
                }
            }
            if (!myTurn && !board.getFreePositions().isEmpty()) {
                position = makeMove(x, y);
                if (position != null) {
                    board = new Board(board, position, oppenentMark);
                    ui.setText(buttons[x][y], oppenentMark);
                    recordStep(x, y, Constants.OPPENENT);
                    myTurn = !myTurn;
                    result = evaluateGame();
                }
            }
        }
        showResult(result);
    }
}
