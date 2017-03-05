/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package mycodeSales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Vishaka
 */
public class DB_acc {
    
    public static ResultSet getData(String query) throws SQLException, ClassNotFoundException
    {
        Connection cn;
          cn = SalesManagementDBConnect.connect();
            Statement ps =cn.createStatement();
            ResultSet rset = ps.executeQuery(query);
        return rset;
    }
    
    public static void setData(String query) throws SQLException, ClassNotFoundException
    {
        Connection cn ;
            cn=SalesManagementDBConnect.connect();
            Statement ps = cn.createStatement();
            ps.executeUpdate(query);
        
    }
    
    
   
}
