/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Shan Keerthisinghe
 */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class DBConnectEventHandling {
  
   public static Connection connect(){
       
        Connection conn = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voguetexsystemdatabase","root","");
           
        
        }catch( Exception e){
            
            JOptionPane.showMessageDialog(null,"No Database");
        
        }
       return conn;
       //throw new UnsupportedOperationException("Not supported yet.");//to change body of generated methods,choose Tools |templates
   }
}
