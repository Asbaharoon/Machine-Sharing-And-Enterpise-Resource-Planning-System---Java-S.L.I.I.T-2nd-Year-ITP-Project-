/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sujani Jayasinghe
 */
public class dbAccessStock {
    
     public static ResultSet getData(String query) throws SQLException, ClassNotFoundException
    {
        
        Connection cn;
            cn= StockManagementdbconnection.dbconnection();
            Statement ps = cn.createStatement();
            ResultSet rs2 = ps.executeQuery(query);
            return rs2;
    }
    
      public static void setData(String query) throws SQLException, ClassNotFoundException
    {
        
        Connection cn;
            cn= StockManagementdbconnection.dbconnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate(query);
                   
    }
    
}
