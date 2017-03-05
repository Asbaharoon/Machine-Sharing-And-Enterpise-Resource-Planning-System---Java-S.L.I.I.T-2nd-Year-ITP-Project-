/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author Sujani Jayasinghe
 */
public class StockManagementdbconnection{
    
    public static Connection connect(){
       
        Connection conn = null;
        
        try{
            //System.out.println("hello");
            Class.forName("com.mysql.jdbc.Driver");
           // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/VogueTexSystemDatabase","root","sujani");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/VogueTexSystemDatabase","root",""); 
        // JOptionPane.showMessageDialog(null,"Database connection success");
        
        }catch( Exception e){
            
            System.out.println("exception throws"+e);
           //+++ JOptionPane.showMessageDialog(null," Error in Database connection");
            
        
        }
       return conn;
       //throw new UnsupportedOperationException("Not supported yet.");//to change body of generated methods,choose Tools |templates
   }

    static Connection dbconnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class connect {

        public connect() {
        }
    }
    
    }
    
    

