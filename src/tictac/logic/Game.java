package tictac.logic;

import java.util.ArrayList;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
//import javax.swing.JOptionPane;
class Player{
    
}

class Step{
    
}

public abstract class Game {
  
    protected Board board; //= new Board();
    protected boolean gameEnded; //= false;
    protected boolean myTurn;// = true;
    protected boolean isRecorded ;
    protected Player oppenent;
    protected char oppenentMark ;
    protected char myMark;
   // protected PlayerSign currentPlayerMark;
    protected ArrayList<Step> steps;
    protected Button[][] buttons;
    protected GameTestUi ui;
    protected Position[] winnigPositions = new Position[3];
    public Game(boolean isRecorded , Player oppenent , char myMark , GameTestUi ui  ){
        this.ui = ui;
        buttons = ui.getBoardButtons();
        gameEnded =false;
        myTurn = true;
        board = new Board();
        this.isRecorded = isRecorded;
        this.oppenent = oppenent;
        this.myMark = myMark;
        if(myMark == PlayerSign.Circle){
            oppenentMark =PlayerSign.Cross;
        }else{
             oppenentMark =PlayerSign.Circle;
        }
        if(isRecorded){
            steps = new ArrayList<Step>();
        }
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
    
    public GameTestUi getUi(){
        return ui;
    }
    
    private void disableButtons(){
        for(int i=0;i<3;i++){
                for(int j =0 ; j<3 ;j++){
                    buttons[i][j].setDisable(true);
                }
                
            }
    }
    protected  int evaluateGame(){
        GameState gameState = board.getGameState(myMark , oppenentMark ,winnigPositions);
        int retval =4;
        gameEnded = true;
        switch(gameState){
            case YouWin: 
                System.out.println("You Won!");
                retval =1;
              
                 // JOptionPane.showMessageDialog(null, "you win");
                  disableButtons();
                break;
            case OppWin : 
                System.out.println("openent Won!");
              
                retval =2;
               //  JOptionPane.showMessageDialog(null, "oppenent win");
                  disableButtons();
                break;
            case Draw : 
                System.out.println("Draw!");
                retval =3;
             //  JOptionPane.showMessageDialog(null, "draw");
                disableButtons();
                break;
            default : gameEnded = false;
                retval =4;
                break;
        }
        return retval;
    }

    public  Position makeMove(int x , int y){
        Position position = null;
        position = new Position(y, x);
        if(board.isMarked(position)){
           position = null;
        }
         return position;
    }

  
    public void drawBoardOnButtons(Board board){
        ui.resetButtons();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char sign = board.getBoard()[j][i];
                if(sign!='e'){
                    ui.setText(buttons[i][j],sign);
                }
                
            }
        }
    }
    
    abstract public void play(int x , int y);
}

final class Position {
    private final int column;
    private final int row;

    public Position(int column, int row){
        this.column = column;
        this.row = row;
    }
    public int getRow(){
  	return this.row;
    }
    public int getColumn(){
	return this.column;
    }
}

class PlayerSign{
   public static char Cross ='x', Circle ='o';
}

enum GameState {
    Incomplete, YouWin, OppWin, Draw
}

class Board {
    private char[][] board; //e = empty, x = cross, o = circle.

    public Board(){
        board = new char[3][3];
        for(int y = 0; y < 3; y++)
            for(int x = 0; x < 3; x++)
                board[x][y] = 'e'; //Board initially empty
    }
    public char[][] getBoard(){
        return board;
    }
    public Board(Board from, Position position, char sign){
        board = new char[3][3];
        for(int y = 0; y < 3; y++)
            for(int x = 0; x < 3; x++)
                board[x][y] = from.board[x][y];
        board[position.getColumn()][position.getRow()] = sign==PlayerSign.Cross ? 'x':'o';
    }

    public ArrayList<Position> getFreePositions(){
        ArrayList<Position> retArr = new ArrayList<Position>();     
        for(int y = 0; y < 3; y++)
            for(int x = 0; x < 3; x++)
                if(board[x][y] == 'e')
                    retArr.add(new Position(x, y));
        return retArr;
    }

    public GameState getGameState(char myMark , char oppenentMark , Position[] pos){    
        if(hasWon(myMark , pos))
            return GameState.YouWin;
        else if(hasWon(oppenentMark ,pos))
            return GameState.OppWin;
        else if(getFreePositions().isEmpty())
            return GameState.Draw;
        else return GameState.Incomplete;
    }

    private boolean hasWon(char sign ,Position[] pos){ 
	int x,y;
      //  Button[][] btns = ui.getBoardButtons();
	//Check diagonals
	if(board[0][0]==sign && board[1][1] == sign && board [2][2]==sign){
              
               return true;
        }
	 
	if(board[0][2]==sign && board[1][1] == sign && board [2][0]==sign){
       
                 return true;
        }
	   

	//Check row
	for(x=0;x<3;x++){
            if(board[x][0] == board[x][1] &&board[x][1] ==board[x][2] &&board[x][1] == sign){
            
                return true;
            }
	}

	//Check col
	for(x=0;x<3;x++){
	    for(y=0;y<3;y++)
		if(board[y][x] != sign)
		    break;
	    if(y==3)
		return true;
	}
       	return false;
    }

    public boolean isMarked(Position position){
        if(board[position.getColumn()][position.getRow()] != 'e')
            return true;
        return false;
    }

    public String toString(){
        String retString = "\n";
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                if(board[x][y] ==  'x' || board[x][y] == 'o')
                    retString += "["+board[x][y]+"]";
                else
                    retString += "[ ]";
            }
            retString += "\n";
        }       
        return retString;
    }   

}
