/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycodeSales;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author Vishaka
 */
public class SalesManagementDBConnect extends DBConnect{
    
    /**
     *
     * @return
     */
    public static Connection connect()
     {
       Connection connc = null;
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            connc = DriverManager.getConnection("jdbc:mysql://localhost:3306/voguetexsystemdatabase","root","");
            
            if((connc != null))
            {
                System.out.println("Successfull");
            }
         //  JOptionPane.showMessageDialog(null,"database connection success");
            
        }catch(Exception e){
        
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"no database connection");
        }
       
        return connc;
      
    }

   // Connection dbconnection() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  // }
    
  
}
