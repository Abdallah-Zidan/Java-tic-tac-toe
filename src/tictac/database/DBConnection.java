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
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void disconnect(Connection connection){
        try {
            connection.close();
            //System.out.println("Connection to SQLite has been closed.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}