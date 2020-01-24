/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.logic;

import java.util.ArrayList;
import javafx.event.ActionEvent;


/**
 *
 * @author zidan
 */
public class SingleMode extends Game{

    public SingleMode(boolean isRecorded, Player oppenent, PlayerSign myMark , GameTestUi ui ) {
        super(isRecorded, oppenent, myMark , ui );      
    }
     public void startActionHandling(){
                 
        
        //  buttons = ui.getBoardButtons();
          buttons[0][0].setOnAction((ActionEvent event) -> {
                    play(0,0);
                });
                 buttons[0][1].setOnAction((ActionEvent event) -> {
                    play(0,1);
                });
                  buttons[0][2].setOnAction((ActionEvent event) -> {
                    play(0,2);
                });
                   buttons[1][0].setOnAction((ActionEvent event) -> {
                    play(1,0);
                });
                    buttons[1][1].setOnAction((ActionEvent event) -> {
                    play(1,1);
                });
                     buttons[1][2].setOnAction((ActionEvent event) -> {
                    play(1,2);
                });
                      buttons[2][0].setOnAction((ActionEvent event) -> {
                    play(2,0);
                });
                       buttons[2][1].setOnAction((ActionEvent event) -> {
                    play(2,1);
                });
                        buttons[2][2].setOnAction((ActionEvent event) -> {
                    play(2,2);
                });
     }   
    
      private  Board findBestMove(Board board) {
        ArrayList<Position> positions = board.getFreePositions();
        Board bestChild = null;
        int previous = Integer.MIN_VALUE;
        for(Position p : positions){
            Board child = new Board(board, p, oppenentMark);
            
            int current = min(child);
            //System.out.println("Child Score: " + current);
            if(current > previous){
                bestChild = child;
                previous = current;
            }
        }
       // drawBoardOnButtons(bestChild);
        return bestChild;
    }

    public int max(Board board){
        GameState gameState = board.getGameState();
        if(null != gameState)
            switch (gameState) {
            case CircleWin:
                return 1;
            case CrossWin:
                return -1;
            case Draw:
                return 0;
            default:
                break;
        }
        ArrayList<Position> positions = board.getFreePositions();
        int best = Integer.MIN_VALUE;
        for(Position p : positions){
            Board b = new Board(board, p, oppenentMark);
            int move = min(b);
            if(move > best)
                best = move;
        }       
        return best;
    }
    
    public  int min(Board board){
        GameState gameState = board.getGameState();
        if(null != gameState)
            switch (gameState) {
            case CircleWin:
                return 1;
            case CrossWin:
                return -1;
            case Draw:
                return 0;
            default:
                break;
        }
        ArrayList<Position> positions = board.getFreePositions();
        int best = Integer.MAX_VALUE;
        for(Position p : positions){
            Board b = new Board(board, p, myMark);
            int move = max(b);
            if(move < best)
                best = move;
        }
        return best;
    } 
  @Override 
  public void play(int x , int y){
        System.out.println(board);
        if(!gameEnded){
            Position position = null;
            if(myTurn){
                position = makeMove(x , y);
                if(position !=null){
                     board = new Board(board, position, myMark);
                     buttons[x][y].setText(String.valueOf(myMark));
                     myTurn = !myTurn;
                }
               
            }   
           
            evaluateGame();
             if(!myTurn){
                board = findBestMove(board);
                 myTurn = !myTurn;
                 drawBoardOnButtons(board);
             }
                 
           // myTurn = !myTurn;
                System.out.println(board);
                evaluateGame();
        }
        
    }
    
}
