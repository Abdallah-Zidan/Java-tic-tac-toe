/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author al-haitham
 */
public class Step {
    private int x;
    private int y;
    private int game_id;
    private int step_no;
    private String turn;
    private DBConnection db = new DBConnection();
    
    public Step(){}

    /**
     *
     * @param x
     * @param y
     * @param turn   mine | oponent
     */
    public Step(int x, int y, String turn){
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
    public Step(int x, int y, int game_id, String turn){
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
    //insert step to database
    //setGameId before you save
    public boolean save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "INSERT INTO 'steps'('x', 'y', 'game_id', 'turn') VALUES ('"+x+"', '"+y+"', '"+game_id+"', '"+turn+"')";
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        }
        catch(SQLException se){
            System.err.println("Failed to save the game steps\n"+se.getMessage());
            return false;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getGameId(){
        return game_id;
    }
    public String getTurn(){
        return turn;
    }
    public void setGameId(int game_id){
        this.game_id = game_id;
    }
}
