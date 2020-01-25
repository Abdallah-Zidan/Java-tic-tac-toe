/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author al-haitham
 */
public class Game {
    private int id;
    private String game_type;
    private int player_id;
    private String result;
    private char sympol;
    private DBConnection db = new DBConnection();
    
    public Game(){}
    public Game(String game_type, char sympol){
        this.game_type = game_type;
        this.sympol = sympol;
    }
    public Game(String game_type, char sympol, int player_id){
        this.game_type = game_type;
        this.sympol = sympol;
        this.player_id = player_id;
    }
    public boolean save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "INSERT INTO 'games'('game_type', 'sympol', 'player_id', 'result') VALUES ('"+game_type+"', '"+sympol+"', '"+player_id+"', '"+result+"')";
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        }
        catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    
    public void setResult (String result){
        this.result = result;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return game_type;
    }
    public char getSympol(){
        return sympol;
    }
    public String getResult(){
        return result;
    }
}
