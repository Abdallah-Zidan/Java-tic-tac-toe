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
public class User {
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
            ex.printStackTrace();
        }
        return retval;
    }
    
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
                ex.printStackTrace();
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
            se.printStackTrace();
            return false;
        }
    }
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
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
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
            ex.printStackTrace();
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
            ex.printStackTrace();
            return false;
        }
    }
//    public static void main(String[] args) {
//        User user = new User("test", "test");
//        
//        user.draw();
//        user = user.getUserInfo();
//        
//        System.out.println(user.getScore());
//    }
}
