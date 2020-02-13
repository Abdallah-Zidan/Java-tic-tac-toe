package tictac.logic;

import tictac.database.*;
import tictac.ui.GameBodyScreen;

public class SingleMode extends Game {
    Computer comp;
    public SingleMode(boolean isRecorded, Player oppenent, User user, char myMark, int level, GameBodyScreen ui) {
        super(isRecorded, Constants.SOLO, oppenent, user, myMark, level, ui);
        comp = new Computer();
        ui.changeTurn(true);
    }
    
    void insertMove(Position position) {
        board = new Board(board, position, opponentMark);
        ui.setText(buttons[position.getRow()][position.getColumn()], opponentMark);
        recordStep(position.getRow(), position.getColumn(), Constants.OPPONENT);
    }

    /**
     * overriding the abstract function play to suit single mode playing logic
     *
     * @param x : integer (the row number in the board)
     * @param y : integer (the column number in the board)
     */
    @Override
    public void play(int x, int y) {
        int result = 4;
        if (!gameEnded) {
            Position position =null;
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
                switch (level) {
                    case Constants.EASY:
                        position = comp.getRandomMove(board);
                        break;
                    case Constants.HARD:
                        position = comp.findBestPosition(board,myMark , opponentMark);
                        break;
                    default:
                        if(counter <3){
                             position = comp.findBestPosition(board,myMark , opponentMark);
                        }else if(counter <=4){
                              position = comp.getRandomMove(board);
                        }
                        counter++;
                }
                insertMove(position);
                myTurn = !myTurn;
                ui.changeTurn(myTurn);
                result = evaluateGame();
            }
        }
        showResult(result);
    }

}
