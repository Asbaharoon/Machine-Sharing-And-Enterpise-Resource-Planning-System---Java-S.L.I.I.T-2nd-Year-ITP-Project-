/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voguetexmachinesharing.managementsystem;

/**
 *
 * @author Sampath Rajapakse
 */
import EmployeeManagement.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnect {
 
    public String url = "jdbc:mysql://localhost:3306/VogueTexSystemDatabase";
    public String username = "root";
    public String password = "";
    public Connection con = null;
    public Connection conUpdate = null;
    public PreparedStatement pst = null;
    public PreparedStatement pst2 = null;
    public PreparedStatement pst4 = null;
    public PreparedStatement pst3 = null;
    public PreparedStatement pstUpdate = null;
    public ResultSet rs=null;
    public ResultSet res=null;
     public ResultSet ress=null;
    
    static String userID;

    Employee loadUser(String userN) {
        Employee empObj=new Employee();
        try{
            
          con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
          String query = "SELECT * FROM employee_info WHERE EmployeeNo='"+userN+"' ";
          pst=con.prepareStatement(query);
          
          rs =pst.executeQuery();//since it's a SELECT statement
          
          while(rs.next()){
              
                empObj.setFullName(rs.getString(1));//get the values in column 1 and storing in employee object
                empObj.setEmpNo(rs.getString(2));
                empObj.setEpfNo(rs.getString(3));
                empObj.setAddress(rs.getString(4));
                empObj.setDob(rs.getString(5));
                empObj.setNic(rs.getString(6));
                empObj.setGender(rs.getString(7));
                empObj.setMaritalStatus(rs.getString(8));
                empObj.setTitle(rs.getString(9));
                empObj.setPhoneNo(rs.getString(10));
                empObj.setEmail(rs.getString(11));
                empObj.setDateJoined(rs.getString(12));
                
                String getDept = "SELECT DepartmentName FROM department_info WHERE DepartmentNo ='"+rs.getString(13)+"'";
                pst=con.prepareStatement(getDept);
                res = pst.executeQuery();
                String deptName=null;
                if(res.next()){
                deptName = res.getString(1);
                }

                empObj.setDepartment(deptName);
                empObj.setEmpType(rs.getString(14));
                empObj.setDesignation(rs.getString(15));
                empObj.setLocation(rs.getString(16));
                empObj.setRoot(rs.getString(17));
                empObj.setBasicSalary(rs.getDouble(18));
                empObj.setAcNo(rs.getString(19));
                empObj.setOt(rs.getString(20));
                empObj.setEpf(rs.getString(21));
                empObj.setEtf(rs.getString(22));
                empObj.setRemarks(rs.getString(23));
                empObj.setImage(rs.getBytes(24));
                empObj.setStatus(rs.getString(25));
                empObj.setRetirementDate(rs.getString(26));
                empObj.setPassword(rs.getString(27));
          }
          return empObj;//the username and  and type provided doesn't exist in the database
          
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return empObj;//for an error occured
        } finally {
            
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting

                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }    
    
    }
    
    
    boolean checkLogin(String userID, String uPassword) {
        try{
            
          con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
          String query = "SELECT EmployeeNo,password FROM employee_info ";
          pst=con.prepareStatement(query);
          
          rs =pst.executeQuery();//since it's a SELECT statement
          
          while(rs.next()){
              if(userID.equals(rs.getString(1)) && uPassword.equals(rs.getString(2)) ){//by 1 we are specifying the column user and 2 =password 
                  return true; //the username and password provided  exist in the database
              } 
          }
          return false;//the username and  and type provided doesn't exist in the database
          
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;//for an error occured
        } finally {
            
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting

                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }    
    }
    
}
