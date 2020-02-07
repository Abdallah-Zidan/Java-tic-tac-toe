package tictac.logic;

import java.io.*;
import java.net.Socket;
import tictac.database.*;
import tictac.ui.*;

public class TwoPlayersNetwork extends Game {

    DataInputStream dis;
    PrintStream printStream;

    public TwoPlayersNetwork(boolean isRecorded, Player oppenent, User user, char myMark, GameBodyB ui, Socket socket, boolean myTurn) {
        super(isRecorded, Constants.DUAL, oppenent, user, myMark,0, ui);
        this.myTurn = myTurn;
        if (!myTurn) {
            disableButtons();
        }
        try {
            this.dis = new DataInputStream(socket.getInputStream());
            this.printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new Reader(this).start();
    }

    @Override
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
        ui.playSound();
    }

    @Override
    public void play(int x, int y) {
        int result = 4;
        if (!gameEnded) {
            Position position;
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
