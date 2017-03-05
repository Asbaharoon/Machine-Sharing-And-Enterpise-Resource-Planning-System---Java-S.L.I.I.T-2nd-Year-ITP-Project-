
package mycodeAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Naduni Samaranayke
 */
public class AccountManagementDBconnect {
    
   public static Connection connect(){
       
        Connection conn = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/VogueTexSystemDatabase","root","");
            //JOptionPane.showMessageDialog(null,"Database connection success");
        
        }catch( Exception e){
            
            JOptionPane.showMessageDialog(null,"Error in database connection");
        
        }
       return conn;
       
   }

    static Connection dbconnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class connect {

        public connect() {
        }
    }
    
    }
    

