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
public class User {
    private int id;
    private int score;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private DBConnection db = new DBConnection();
    
    public User(){}
    //signup constructor
    public User(String username, String password, String fname, String lname)
    {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }
    
  
    //login constructor
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    //check if the username already exist in db
    public boolean userExist(String username){
        boolean retval = false;
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM users WHERE username ='" + username + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                retval = true;
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to check if user exist\n"+ex.getMessage());
        }
        return retval;
    }
    //check if user is authentic or not
    public boolean isAuthentic(){
        boolean retval = false;
        if (userExist(username)) {
            try {
                Connection conn = db.connect();
                Statement stmt = conn.createStatement();
                String queryString = "SELECT * FROM users WHERE username ='" + username + "' and password='" + password + "'";
                ResultSet rs = stmt.executeQuery(queryString);
                if (rs.next()) {
                    retval = true;
                }
                stmt.close();
                db.disconnect(conn);
            } catch (SQLException ex) {
            System.err.println("Failed to check if user is authentic\n"+ex.getMessage());
            }
        }
        return retval;
    }
    
    //insert user to database
    public boolean save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "INSERT INTO 'users'('username', 'password', 'fname', 'lname') VALUES ('"+username+"', '"+password+"', '"+fname+"', '"+lname+"')";
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        }
        catch(SQLException se){
            System.err.println("Failed to save the game\n"+se.getMessage());
            return false;
        }
    }
    // can be used with the login constructor to get the user info from database if authenticated
    public User getUserInfo() {
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                setFname(rs.getString("fname"));
                setLname(rs.getString("lname"));
                setUsername(rs.getString("username"));
                setScore(rs.getInt("score"));
                setId(rs.getInt("id"));
            }
            stmt.close();
            db.disconnect(conn);
        }
        catch (SQLException ex) {
            System.err.println("Failed to retrieve the user info from database\n"+ex.getMessage());
        }
        return this;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFname(String fname){
        this.fname = fname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public int getScore(){
        return score;
    }
    public int getId(){
        return id;
    }

    //increment score by 3 in case of victory
    public boolean victory() {
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "UPDATE users SET score = score+3  WHERE username = '" + username + "' ";
            
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        } catch (SQLException ex) {
            System.err.println("Failed to increment the score by 3\n"+ex.getMessage());
            return false;
        }
    }
    //increment score by 1 in case of draw
    public boolean draw() {
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "UPDATE users SET score = score+1  WHERE username = '" + username + "' ";
            
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        } catch (SQLException ex) {
            System.err.println("Failed to increment the score by 1\n"+ex.getMessage());
            return false;
        }
    }
    //returns a collection of games that the user played
    public ArrayList<GameModel> games() {
        ArrayList<GameModel> games = new ArrayList<>();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM games WHERE user_id = "+id;
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                GameModel g = new GameModel(rs.getString("game_type"), rs.getString("Sympol").charAt(0), rs.getInt("player_id"),rs.getInt("user_id") ,rs.getString("result"), rs.getString("level"));
                g.setId(rs.getInt("id"));
                g.setTimestamp(rs.getString("timestamp"));
                games.add(g);
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to retrieve the user games from database\n"+ex.getMessage());
        }
        return games;
    }
    //static method that returns a collectopn of players who played with this user
    public ArrayList<Player> players() {
        ArrayList<Player> players = new ArrayList<>();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE user_id = "+id;
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                Player p = new Player(rs.getString("fname"), rs.getString("lname"), rs.getString("ip_address"), rs.getInt("user_id"));
                players.add(p);
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to retrieve players from database\n"+ex.getMessage());
        }
        return players;
    }
}
