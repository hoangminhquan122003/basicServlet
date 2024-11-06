/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection c=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mySQL://localhost:3306/websach";
            String password="";
            String username="root";
            c=DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c){
        
            try {
                if(c!=null){
                    c.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
    } 
    
}
