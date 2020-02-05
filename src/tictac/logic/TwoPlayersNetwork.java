package tictac.logic;

import java.io.*;
import java.net.Socket;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import tictac.animation.GameOver;
import tictac.database.*;
import tictac.game.MainGame;
import tictac.ui.*;

public class TwoPlayersNetwork extends Game {

    private Socket socket;
    private DataInputStream dis;
    private PrintStream printStream;
    private boolean gameFinished;

    public TwoPlayersNetwork(boolean isRecorded, Player oppenent, User user, char myMark, GameBodyB ui, GameOver endUi, Socket socket, boolean myTurn) {
        super(isRecorded, Constants.DUAL, oppenent, user, myMark, ui, endUi);
        gameFinished = false;
        this.myTurn = myTurn;
        if (!myTurn) {
            disableButtons();
        }
        try {
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());

            this.printStream = new PrintStream(socket.getOutputStream());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ui.getScene().getWindow().setOnCloseRequest(ev -> {
            System.exit(0);
        });
        new Reader().start();
    }

    private class ConnectionLost implements Runnable {

        @Override
        public void run() {
            if (gameFinished) {
                closeGame(socket, dis, printStream);
                System.out.println("closed");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Connection lost", ButtonType.OK);
                alert.showAndWait();

                MainGame.game.setParentScene(new Scene(new PlayB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
                ui.stopSound();
            }

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
                    if (!gameFinished) {
                        String move = dis.readLine();
                        if (move != null) {
                            System.out.println(move);
                            String[] pos = move.split(",");
                            int x = Integer.parseInt(pos[0]);
                            int y = Integer.parseInt(pos[1]);
                            System.out.println(x + " , " + y);
                            Platform.runLater(new PlayLater(x, y));
                        } else {
                            System.out.println("ended");
                           Platform.runLater(new ConnectionLost());
                            break;
                        }
                    } else {
                        break;
                    }

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("finished");
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
                    if (result != 4) {
                        gameFinished = true;
                        closeGame(socket, dis, printStream);
                    }
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
                    if (result != 4) {
                        gameFinished = true;
                        closeGame(socket, dis, printStream);

                    }
                }
            }
        }
        showResult(result);
    }
    
    

}
