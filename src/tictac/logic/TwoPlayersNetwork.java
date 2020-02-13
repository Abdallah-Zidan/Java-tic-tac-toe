package tictac.logic;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import tictac.database.*;
import tictac.ui.*;

public class TwoPlayersNetwork extends Game {

    DataInputStream dis;
    PrintStream printStream;

    public TwoPlayersNetwork(boolean isRecorded, Player oppenent, User user, char myMark, GameBodyScreen ui, Socket socket, boolean myTurn) {
        super(isRecorded, Constants.DUAL, oppenent, user, myMark,0, ui);
        this.myTurn = myTurn;
        ui.changeTurn(myTurn);
        if (!myTurn) {
            ui.disableButtons();
        }
        try {
            this.dis = new DataInputStream(socket.getInputStream());
            this.printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Reader reader = new Reader(this);
        reader.start();
    }

    @Override
    public void resetGame(boolean enabled) {
        board = new Board();
        if(isRecorded){
            steps = new ArrayList<>();
        }
        if (enabled) {
            myTurn = true;
        } else {
            ui.disableButtons();
            myTurn = false;
            printStream.println(1);
        }
        ui.clearButtons();
        gameEnded = false;
        ui.playSound();
    }
    @Override
    public void play(int x, int y) {
        int result = 4;
        if (!gameEnded) {
            Position position;
            if (myTurn) {
                ui.enableButtons();
                position = makeMove(x, y);
                if (position != null) {
                    board = new Board(board, position, myMark);
                    ui.setText(buttons[x][y], myMark);
                    printStream.println(x + "," + y);
                    printStream.flush();
                    recordStep(x, y, Constants.MINE);
                    myTurn = !myTurn;
                    ui.changeTurn(myTurn);
                    ui.disableButtons();
                    result = evaluateGame();
                }
            }
            if (!myTurn && !board.getFreePositions().isEmpty()) {
                position = makeMove(x, y);
                if (position != null) {
                    board = new Board(board, position, opponentMark);
                    ui.setText(buttons[x][y], opponentMark);
                    recordStep(x, y, Constants.OPPONENT);
                    myTurn = !myTurn;
                    ui.changeTurn(myTurn);
                    result = evaluateGame();
                }
            }
        }
        showResult(result);
    }
}
