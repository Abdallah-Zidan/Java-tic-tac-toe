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
public class Player {
    private int id;
    private String ip_address;
    private String fname;
    private String lname;
    private int user_id;
    private DBConnection db = new DBConnection();
    
    public Player(){}
    public Player(String fname, String lname, String ip_address, int user_id){
        this.fname = fname;
        this.lname = lname;
        this.ip_address = ip_address;
        this.user_id = user_id;
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
            String queryString = "INSERT INTO 'players'('fname', 'lname', 'ip_address', 'user_id') VALUES ('"+fname+"', '"+lname+"', '"+ip_address+"', '"+user_id+"')";
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
    public boolean playerExist(String ip_address){
        boolean retval = false;
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE ip_address ='" + ip_address + "'";
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
    
    public Player getUserInfo() {
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String queryString = "SELECT * FROM players WHERE ip_address = '" + ip_address + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                setFname(rs.getString("fname"));
                setId(rs.getInt("id"));
                setUserId(rs.getInt("user_id"));
                setIpAddress(rs.getString("ip_adress"));
            }
            stmt.close();
            db.disconnect(conn);
        } catch (SQLException ex) {
        }
        return this;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUserId(int user_id){
        this.user_id = user_id;
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
    public int getUserId(){
        return user_id;
    }
    
//    public static void main(String[] args) {
//        Player player = new Player("test", "test","192.168.1.2");
//        boolean x = player.save();
//
//        player = player.getUserInfo();
//
//        System.out.println(player.getIpAddress() + " " + x);
//    }

}
