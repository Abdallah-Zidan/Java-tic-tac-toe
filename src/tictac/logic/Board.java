/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.logic;

import java.util.ArrayList;


public class Board {
    char[][] board; //e = empty, x = cross, o = circle.
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
        board[position.getColumn()][position.getRow()] = sign==PlayerSign.Cross ? 'X':'O';
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
   public static char Cross ='X', Circle ='O';
}

enum GameState {
    Incomplete, YouWin, OppWin, Draw
}