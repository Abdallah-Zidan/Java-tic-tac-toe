
package tictac.logic;

import java.util.ArrayList;

public class SingleMode extends Game{

    public SingleMode(boolean isRecorded, int oppenent_id,int user_id, char myMark , GameTestUi ui , EndGameUi endUi ) {
        super(isRecorded,Constants.SOLO,oppenent_id,user_id, myMark , ui , endUi);  
    }
    
      private  Board findBestMove(Board board) {
        ArrayList<Position> positions = board.getFreePositions();
        Board bestChild = null;
        int previous = Integer.MIN_VALUE;
        for(Position p : positions){
            Board child = new Board(board, p, oppenentMark);
            int current = min(child);
        
            if(current > previous){
                bestChild = child;
                previous = current;
            }
        }
        return bestChild;
    }

    public int max(Board board){
        GameState gameState = board.getGameState(myMark , oppenentMark , winnigPositions);
        if(null != gameState)
            switch (gameState) {
            case OppWin:
                return 1;
            case YouWin:
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
        GameState gameState = board.getGameState(myMark , oppenentMark,winnigPositions);
        if(null != gameState)
            switch (gameState) {
            case OppWin:
                return 1;
            case YouWin:
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
        int result = 4;
        if(!gameEnded){
            Position position = null;
            if(myTurn){
                position = makeMove(x , y);
                if(position !=null){
                     board = new Board(board, position, myMark);
                     ui.setText(buttons[x][y], myMark);
                    
                     myTurn = !myTurn;
                    
                   result =  evaluateGame() ;
                }else{
                    System.out.println("Already marked!");
                }
               
            }   
           
         
             if(!myTurn && !board.getFreePositions().isEmpty()){
                board = findBestMove(board);
                myTurn = !myTurn;
                drawBoardOnButtons(board);
               
               result =  evaluateGame();
             }
            
        }
        
           
           showResult(result);
        
    }
    
}
