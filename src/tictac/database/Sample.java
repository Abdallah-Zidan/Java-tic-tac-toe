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
 * @author zidan
 */
public class Sample {
    public static void main(String[] args) {
        connect();
    }
    public static void connect(){
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:TTTDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
