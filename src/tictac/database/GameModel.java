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
import java.util.ArrayList;

/**
 *
 * @author al-haitham
 */
public class GameModel {
    private int id;
    private String game_type;
    private int player_id;
    private String result;
    private String sympol;
    private int user_id;
    private int game_no;
    private DBConnection db = new DBConnection();
    
    /**
     *
     * @param game_type     solo or dual
     * @param sympol        x or o
     * @param player_id  
     * @param user_id
     * @param game_no       game_count in user model
     * @param result        victory or loss
     */
    public GameModel(String game_type, char sympol, int player_id, int user_id, int game_no, String result){
        this.game_type = game_type;
        this.sympol =String.valueOf(sympol).toLowerCase() ;
        this.player_id = player_id;
        this.result = result;
        this.user_id = user_id;
        this.game_no = game_no;
    }
    public boolean save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "INSERT INTO 'games'('game_type', 'sympol', 'player_id', 'result','game_no', 'user_id') VALUES ('"+game_type+"', '"+sympol+"', '"+player_id+"', '"+result+"', '"+game_no+"', "+user_id+")";
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
   
    public  ArrayList<Step> steps(){
        ArrayList<Step> steps = new ArrayList<>();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM steps WHERE game_id = (SELECT id from games WHERE game_no = '"+game_no+"' AND user_id = '"+user_id+"')";
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                Step s = new Step(rs.getInt("x"), rs.getInt("y"), rs.getInt("game_id"), rs.getString("turn"));
                steps.add(s);
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return steps;
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
//    public char getSympol(){
//        return sympol;
//    }
    public String getResult(){
        return result;
    }
    public int getUserId(){
        return user_id;
    }
    
    public static ArrayList<Step> getSteps(int gameId){
        ArrayList<Step> steps = new ArrayList<>();
        DBConnection dbCon = new DBConnection();
        Connection con = dbCon.connect();
        Statement stmt =null;
        try{
            stmt = con.createStatement();
            String queryString = "SELECT * FROM steps WHERE game_id ="+gameId;
             ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                Step s = new Step(rs.getInt("x"), rs.getInt("y"), rs.getInt("game_id"), rs.getString("turn"));
                steps.add(s);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                stmt.close();
                dbCon.disconnect(con);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return steps;
        
    }
//    public static void main(String[] args) {
//        GameModel game = new GameModel("dual", 'x', 1, 1, 1, "loss");
//        game.save();
//        ArrayList<Step> ar = game.steps();
//        for(Step step: ar){
//            System.out.println(step.getTurn());
//        }
//    }
}
