/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dbConnector {
    public Connection connect;
     public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/2025", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
     
     //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
        //Function to save data
        public boolean insertData(String sql){
           try {
        PreparedStatement pst = connect.prepareStatement(sql);
        int rowsUpdated = pst.executeUpdate();
        pst.close();
        return rowsUpdated > 0; // Returns true if at least one row was updated
    } catch (SQLException ex) {
        System.out.println("Connection Error: " + ex);
        return false;
    }
        }
        
        //Function to update data
        public boolean updateData(String sql){
          try {
        PreparedStatement pst = connect.prepareStatement(sql);
        int rowsUpdated = pst.executeUpdate();
        pst.close();
        return rowsUpdated > 0; // Returns true if at least one row was updated
    } catch (SQLException ex) {
        System.out.println("Connection Error: " + ex);
        return false;
    }
        
        }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
