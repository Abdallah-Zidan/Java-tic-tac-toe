package tictac.logic;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.*;
class Player{
    
}

class Step{
    
}

public abstract class Game {
    private static Scanner in = new Scanner(System.in);
    protected Board board; //= new Board();
    protected boolean gameEnded; //= false;
    protected boolean myTurn;// = true;
    protected boolean isRecorded ;
    protected Player oppenent;
    protected PlayerSign oppenentMark ;
    protected PlayerSign myMark;
    protected PlayerSign currentPlayerMark;
    protected ArrayList<Step> steps;
    protected Button[][] buttons;
    protected GameTestUi ui;
    public Game(boolean isRecorded , Player oppenent , PlayerSign myMark , GameTestUi ui  ){
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
    public GameTestUi getUi(){
        return ui;
    }
    protected  void evaluateGame(){
        GameState gameState = board.getGameState();
        gameEnded = true;
        switch(gameState){
            case CrossWin : 
                System.out.println("You Won!");
                break;
            case CircleWin : 
                System.out.println("openent Won!");
                break;
            case Draw : 
                System.out.println("Draw!");
                break;
            default : gameEnded = false;
                break;
        }
    }

    public  Position makeMove(int x , int y){
        Position position = null;
//        while(true){
//            System.out.print("Pick 0, 1 or 2 for column: ");
//            int column = getColOrRow();
//            System.out.print("Pick 0, 1 or 2 for row: ");
//            int row = getColOrRow();
//            position = new Position(column, row);
//            if(board.isMarked(position))
//                System.out.println("Already marked!");
//            else break;
//        }
        position = new Position(y, x);
        if(board.isMarked(position)){
           position = null;
        }
         return position;
    }

    private  int getColOrRow(){
        int ret = -1;
        while(true){
            try{
                ret = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e){}
            if(ret < 0 | ret > 2)
                System.out.print("\nInvalid input. Please pick 0, 1 or 2: ");
            else break;
        }
        return ret;
    }
    public void drawBoardOnButtons(Board board){
        ui.resetButtons();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ui.setText(buttons[i][j],board.getBoard()[j][i]);
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

enum PlayerSign{
    Cross, Circle
}

enum GameState {
    Incomplete, CrossWin, CircleWin, Draw
}

class Board {
    private char[][] board; //e = empty, x = cross, o = circle.

    public Board(){
        board = new char[3][3];
        for(int y = 0; y < 3; y++)
            for(int x = 0; x < 3; x++)
                board[x][y] = ' '; //Board initially empty
    }
    public char[][] getBoard(){
        return board;
    }
    public Board(Board from, Position position, PlayerSign sign){
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
                if(board[x][y] == ' ')
                    retArr.add(new Position(x, y));
        return retArr;
    }

    public GameState getGameState(){    
        if(hasWon('x'))
            return GameState.CrossWin;
        else if(hasWon('o'))
            return GameState.CircleWin;
        else if(getFreePositions().isEmpty())
            return GameState.Draw;
        else return GameState.Incomplete;
    }

    private boolean hasWon(char sign){ 
	int x,y;

	//Check diagonals
	if(board[0][0]==sign && board[1][1] == sign && board [2][2]==sign)
	    return true;
	if(board[0][2]==sign && board[1][1] == sign && board [2][0]==sign)
	    return true;

	//Check row
	for(x=0;x<3;x++){
	    for(y=0;y<3;y++)
		if(board[x][y] != sign)
		    break;
	    if(y==3)
		return true;
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
