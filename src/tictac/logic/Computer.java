/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author zidan
 */
public class Computer {
    
       /**
     * this function return a new board with computer movement depending on the
     * min and max algorithm
     * @param board : Board
     * @return bestChild : Board
     */
      Position findBestPosition(Board board ,char myMark , char opponentMark) {
        ArrayList<Position> positions = board.getFreePositions();
        Position bestPosition = null;
        int previous = Integer.MIN_VALUE;
        for (Position p : positions) {
            Board child = new Board(board, p, opponentMark);
            int current = min(child,myMark,opponentMark);
            if (current > previous) {
                bestPosition = p;
                previous = current;
            }
        }
        return bestPosition;
    }

    public int max(Board board,char myMark , char opponentMark) {
        GameState gameState = board.getGameState(myMark, opponentMark);
        if (null != gameState) {
            switch (gameState) {
                case YouLose:
                    return 1;
                case YouWin:
                    return -1;
                case Draw:
                    return 0;
                default:
                    break;
            }
        }
        ArrayList<Position> positions = board.getFreePositions();
        int best = Integer.MIN_VALUE;
        for (Position p : positions) {
            Board b = new Board(board, p, opponentMark);
            int move = min(b,myMark , opponentMark);
            if (move > best) {
                best = move;
            }
        }
        return best;
    }

    public int min(Board board , char myMark , char opponentMark) {
        GameState gameState = board.getGameState(myMark, opponentMark);
        if (null != gameState) {
            switch (gameState) {
                case YouLose:
                    return 1;
                case YouWin:
                    return -1;
                case Draw:
                    return 0;
                default:
                    break;
            }
        }
        ArrayList<Position> positions = board.getFreePositions();
        int best = Integer.MAX_VALUE;
        for (Position p : positions) {
            Board b = new Board(board, p, myMark);
            int move = max(b,myMark, opponentMark);
            if (move < best) {
                best = move;
            }
        }
        return best;
    }
     Position getRandomMove(Board board) {
        Random rand = new Random();
        Position pos;
        int x;
        int y;
        // Generate random move
        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (board.getBoard()[x][y] == Constants.CROSS || board.getBoard()[x][y] == Constants.CIRCLE);
        pos = new Position(x, y);
        return pos;
    }

}
