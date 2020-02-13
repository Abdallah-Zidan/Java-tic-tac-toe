/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author al-haitham
 */
public class Player implements Serializable {
    private transient int id;
    private String ip_address;
    private String fname;
    private String lname;
    private transient DBConnection db = new DBConnection();
    
    public Player(){}
    public Player(String fname, String lname, String ip_address){
        this.fname = fname;
        this.lname = lname;
        this.ip_address = ip_address;
        
    }
    public Player(String ip_address){
        this.ip_address = ip_address;
    }
    
    //insert player to database
    public boolean save()
    {
        try{
            Connection conn;
            conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "INSERT INTO 'players'('fname', 'lname', 'ip_address') VALUES ('"+fname+"', '"+lname+"', '"+ip_address+"')";
            stmt.executeUpdate(queryString);
            stmt.close();
            db.disconnect(conn);
            return true;
        }
        catch(SQLException se){
            System.err.println("Failed to save player\n"+se.getMessage());
            return false;
        }
    }
    //check if ip already exist in db
    public boolean playerExist(String ip_address){
        boolean retval = false;
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE ip_address ='" + ip_address+"'";
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                retval = true;
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to check if player exist\n"+ex.getMessage());
        }
        return retval;
    }
    //to get player info
    //to be used with constructor that takes ip only
    public Player getPlayerInfo() {
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE ip_address = '" + ip_address + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                setFname(rs.getString("fname"));
                setLname(rs.getString("lname"));
                setId(rs.getInt("id"));
                setIpAddress(rs.getString("ip_address"));
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to retrieve player info from database\n"+ex.getMessage());
        }
        return this;
    }
    //static method that returns a player by it's id
    public static Player getPlayer(int id) {
        Player p = null;
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                p = new Player(rs.getString("fname"), rs.getString("lname"), rs.getString("ip_address"));
                p.setId(rs.getInt("id"));
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
            System.err.println("Failed to retrieve player info from database\n"+ex.getMessage());
        }
        return p;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setFname(String fname){
        this.fname = fname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public void setIpAddress(String ip_address){
        this.ip_address = ip_address;
    }
    public int getId(){
        return id;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getIpAddress(){
        return ip_address;
    }
}
