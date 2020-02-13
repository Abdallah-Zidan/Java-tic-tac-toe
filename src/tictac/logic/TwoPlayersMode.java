package tictac.logic;
import tictac.database.*;

import tictac.ui.GameBodyScreen;

public class TwoPlayersMode extends Game {
    public TwoPlayersMode(boolean isRecorded, Player oppenent, User user, char myMark, GameBodyScreen ui) {
        super(isRecorded, Constants.DUAL, oppenent, user, myMark,0, ui);
        ui.changeTurn(true);
    }
    /**
     * overriding the abstract function play to suit two players mode playing logic
     * @param x : integer (the row number in the board)
     * @param y : integer (the column number in the board)
     */
    @Override
    public void play(int x, int y) {
        int result = 4;
        if (!gameEnded) {
            Position position ;
            if (myTurn) {
                position = makeMove(x, y);
                if (position != null) {
                    board = new Board(board, position, myMark);
                    ui.setText(buttons[x][y], myMark);
                    recordStep(x, y, Constants.MINE);
                    myTurn = !myTurn;
                    ui.changeTurn(myTurn);
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
