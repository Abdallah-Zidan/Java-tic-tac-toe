/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 *
 * @author al-haitham
 */
public class DBConnection {
    private Connection conn;

    public Connection connect(){
        try {
            String url = "jdbc:sqlite:TTTDB";
            conn = DriverManager.getConnection(url);            
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Faild to connect to database\n"+e.getMessage());
        }
        return conn;
    }
    public void disconnect(Connection connection){
        try {
            connection.close();
            //System.out.println("Connection to SQLite has been closed.");
        } catch (SQLException ex) {
            System.out.println("Faild to close connection with database\n"+ex.getMessage());
        }
    }
}
