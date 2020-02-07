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
    private char sympol;
    private int user_id;
    private String level;
    private DBConnection db = new DBConnection();
    
    /**
     * Game constructor
     * @param game_type     solo | dual
     * @param sympol        x | o
     * @param player_id  
     * @param user_id
     * @param result        victory | loss
     */
    public GameModel(String game_type, char sympol, int player_id, int user_id, String result, String level){
        this.game_type = game_type;
        this.sympol = sympol;
        this.player_id = player_id;
        this.result = result;
        this.user_id = user_id;
        this.level = level;
    }
    //insert game to db
    public GameModel save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String mark = String.valueOf(sympol).toLowerCase();
            String queryString = "INSERT INTO 'games'('game_type', 'sympol', 'player_id', 'result', 'user_id', 'level') VALUES ('"+game_type+"', '"+mark+"', '"+player_id+"', '"+result+"', "+user_id+", '"+level+"')";
            stmt.executeUpdate(queryString);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            db.disconnect(conn);
            return this;
        }
        catch(SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    /**
     * member method 
     * @return a collection of steps
     */
    public ArrayList<Step> steps(){
        ArrayList<Step> steps = new ArrayList<>();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM steps WHERE game_id = '"+id+"'";
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

    /**
     *static method that takes
     * @param user_id
     * @param game_no
     * @return a collection of steps
     */
    
    //static method that takes game id and return a collection of steps
    public static ArrayList<Step> getSteps(int game_id){
        ArrayList<Step> steps = new ArrayList<>();
        try {
            DBConnection db = new DBConnection();
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM steps WHERE game_id = '" +game_id+"'";
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
    public void setLevel(String level){
        this.level = level;
    }
    public int getId(){
        return id;
    }
    public String getLevel(){
        return level;
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
    public int getUserId(){
        return user_id;
    }
//    public static void main(String[] args) {
//        GameModel game = new GameModel("solo", 'x', 1, 1, 2, "loss", "easy");
//        game = game.save();
//        //ArrayList<Step> ar = GameModel.getSteps(1);
//        System.out.println(game.getId());
////        for(Step step: ar){
////            System.out.println(step);
////        }
//    }
}