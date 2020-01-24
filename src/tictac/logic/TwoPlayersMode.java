///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package tictac.logic;
//
///**
// *
// * @author zidan
// */
public class TwoPlayersMode extends Game {

    public TwoPlayersMode(boolean isRecorded, Player  oppenent, char myMark,GameTestUi ui) {
        super(isRecorded, oppenent, myMark,ui);
    }

   

    @Override
    public void play(int x , int y) {
         System.out.println(board);
        if(!gameEnded){
            Position position = null;
            if(myTurn){
                position = makeMove(x,y);
                if(position !=null){
                     board = new Board(board, position, myMark);
                     ui.setText(buttons[x][y], myMark);
                    
                     myTurn = !myTurn;
                    
                     evaluateGame() ;
                }else{
                    System.out.println("Already marked!");
                }
            }
            if(!myTurn && !board.getFreePositions().isEmpty()){
                 position = makeMove(x,y);
                if(position !=null){
                     board = new Board(board, position, oppenentMark);
                     ui.setText(buttons[x][y], oppenentMark);
                    
                     myTurn = !myTurn;
                    
                     evaluateGame() ;
                }else{
                    System.out.println("Already marked!");
                }
            }
        }
    }
    
}
