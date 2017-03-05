/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transportation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author Dasuni Anupama
 */
public class DBOperationTransportation extends DBConnect{
    

   boolean getEmployeeTransportDetails(int seatsRequired,String vehiclenum)
    {
        //ResultSet employeeSeatsRequired = null;  
        
        String getEmployeeTransportQ = "update vehicle set avalable_capacity=(avalable_capacity -'"+seatsRequired+"') WHERE vehicle_number='"+vehiclenum+"'";
         try {
             con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
             pst = con.prepareStatement(getEmployeeTransportQ);
          
             pst.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperationTransportation.class.getName()).log(Level.SEVERE, null, ex);
             
            return false;
         }
         
        //return employeeSeatsRequired;
    }


ArrayList<Emp> getEmpT() {
        try {
            ArrayList<Emp> list=new ArrayList<Emp>();
            con=DriverManager.getConnection(url, username, password);//get the connection
        
               String empRouteDetailsQuery= "select a.Date as date, e.Route as route, count(e.EmployeeNo) as no_of_employees\n" +
                            "from employee_info e, attendance a\n" +
                            "where a.EmployeeNo = e.EmployeeNo\n" +
                            "and a.Date = DATE_FORMAT(sysdate(),\"%Y-%m-%d\")" +
                            "and a.Intime is not null\n" +
                            "group by e.Route;";
            pst=con.prepareStatement(empRouteDetailsQuery);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Emp sObe=new Emp();
                
                sObe.setDate(rs.getDate(1));//get the values in column 1 and storing in object
                sObe.setRoute(rs.getString(2));
                sObe.setEmployeeCount(rs.getInt(3));
 
                
                list.add(sObe);//add the filled  Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

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
                return null;
            }

        }
    }



ResultSet getAvailableSeatCapacities(String route)
    {
        ResultSet availableSeatCapRS = null;  
        
        String getAvailableSeatCapacitiesQ = "select avalable_capacity from vehicle where route = '"+route+"' and avalable_capacity >0 and avalable_capacity<70";
         try {
             con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
             pst = con.prepareStatement(getAvailableSeatCapacitiesQ);
          
             availableSeatCapRS=pst.executeQuery();
         } catch (Exception e) {
             Logger.getLogger(DBOperationTransportation.class.getName()).log(Level.SEVERE, null, e);
         }
         
        return availableSeatCapRS;
    }

ResultSet getVehicleNmsDependingOnSeatings(String route, String capacity)
    {
        ResultSet availVehicleNmsRS = null;  
        
        String getAvailVehNmsQ = "select vehicle_number from vehicle where route = '"+route+"' and avalable_capacity = '"+capacity+"'";
         try {
             con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
             pst = con.prepareStatement(getAvailVehNmsQ);
          
             availVehicleNmsRS=pst.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(DBOperationTransportation.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return availVehicleNmsRS;
    }





    ResultSet getAvailableVehicles(String vehicleType)
    {
        ResultSet availableVehiclesRS = null;  
        
        String availVehicleQuery = "select vehicle_number from vehicle where vehicle_type = '"+vehicleType+"' AND driverAssigned = ?";
         try {
             con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
             pst = con.prepareStatement(availVehicleQuery);
             pst.setString(1, "N");
             availableVehiclesRS=pst.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(DBOperationTransportation.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return availableVehiclesRS;
    }


boolean addvehicle(Vehicle v){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
           
            String query = "INSERT INTO vehicle (vehicle_number,vehicle_type,vehicle_capacity,route, driverAssigned, avalable_capacity) VALUES (?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, v.getVehicleNUm());//add values to the sql query
            pst.setString(2, v.getType());//add values to the sql query
            pst.setInt(3, v.getCapacity());//add values to the sql query
            pst.setString(4, v.getRoute());
            pst.setString(5, "N");
            pst.setInt(6, v.getCapacity());
            
            
            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
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


ArrayList<Vehicle> getvehicle() {
        try {
            ArrayList<Vehicle> list=new ArrayList<Vehicle>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM vehicle" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Vehicle sObj=new Vehicle();
                
                sObj.setVehicleNUm(rs.getString(1));
                sObj.setType(rs.getString(2));//get the values in column 1 and storing in Style object
                sObj.setCapacity(rs.getInt(3));
                sObj.setRoute(rs.getString(4));
                sObj.setDriverAssigned(rs.getString(5));
                sObj.setAvailableCapacity(rs.getInt(6));
           
             
            
 
                
                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

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
                return null;
            }

        }
    }


boolean deletevehicle(String vehicleNum){
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String deleteVehicleQuery ="DELETE FROM vehicle WHERE vehicle_number='"+vehicleNum+"'";
            String updateDriverQuery = "Update driver set vNumber = null where vNumber = '"+vehicleNum+"'";
            pst=con.prepareStatement(deleteVehicleQuery);
            pst2 = con.prepareStatement(updateDriverQuery);
            
            pst.executeUpdate();  
            pst2.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (pst2 != null) {
                    pst2.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    
    }

boolean updateVehicle(String vehicleNum, String route) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE vehicle SET route='"+route+"' WHERE vehicle_number='"+vehicleNum+"'";
            pst=con.prepareStatement(query);
            
            pst.executeUpdate();  
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

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
                return false;
            }

        }
    }

    ResultSet updateAvailableVehicles(String availableVehicle)
    {
        ResultSet updateVehiclesRS = null;  
        
        String updateVehicleQuery="update vehicle set availability='N' where vehicle_number= '"+availableVehicle;
        //String updateVehicleQuery ="select vehicle_number from vehicle where availability= '"+availableVehicle; 
   
         try {
             con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
             pst = con.prepareStatement(updateVehicleQuery);
            // pst.setString(1, "N");
             updateVehiclesRS=pst.executeQuery();
         } catch (SQLException e) {
            // Logger.getLogger(DBOperationTransportation.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return updateVehiclesRS;
    }

boolean AddAssingDriver(AssingDriver asg){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String asgnDriverquery = "INSERT INTO driver  VALUES (?,?,?,?,?,?) ";
            //   String updateAvailable="update vehicle set availability='N' where vehicle_number= "+asg.getVehicleNumber();
               
            pst = con.prepareStatement(asgnDriverquery);//making a prepared statement
           
            pst.setString(1, asg.getDriverName());
            pst.setString(2, asg.getDriverNIC());//add values to the sql query
            pst.setString(3, asg.getDob());//add values to the sql query
            pst.setString(4, asg.getGender());
            if(asg.getVehicleNumber().equals("select one"))
            {
                pst.setString(5, null);//add values to the sql query
            pst.setString(6, null);
            }
            else
            {
            pst.setString(5, asg.getVehicleType());//add values to the sql query
            pst.setString(6, asg.getVehicleNumber());
            
            String updateDriverTbl = "Update vehicle set driverAssigned = ? where vehicle_number = '"+asg.getVehicleNumber()+"'";
            pst2 = con.prepareStatement(updateDriverTbl);
            }
            pst.executeUpdate();//execute the sql query and insert the values to db table
            String avail_y = "Y";
            pst2.setString(1, avail_y);
            pst2.executeUpdate();
            //since it's a INSERT statement
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
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


ArrayList<AssingDriver> getAssingDriver() {
        try {
            ArrayList<AssingDriver> list=new ArrayList<AssingDriver>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM driver" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                AssingDriver sObj=new AssingDriver();
                
                sObj.setDriverName(rs.getString(1));
                sObj.setDriverNIC(rs.getString(2));
                sObj.setDob(rs.getString(3));//get the values in column 1 and storing in  object
                sObj.setGender(rs.getString(4));
                sObj.setVehicleType(rs.getString(5));
                sObj.setVehicleNumber(rs.getString(6));
            
                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

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
                return null;
            }

        }
    }


boolean DeleteAssignDriver(String nicNum){
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
             String deleteDriverQuery ="DELETE FROM driver WHERE d_NIC='"+nicNum+"'";
            pst=con.prepareStatement(deleteDriverQuery);
            String ds = "N";
            pst.executeUpdate();  
            
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

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
                return false;
            }

        }
    
    }

boolean UpdateAssingDriver(AssingDriver asg,AssingDriver asg1) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
             String assignedVNumOldQ = "SELECT vNumber from driver where d_NIC = '"+asg.getDriverNIC()+"'";
             
             pst4 = con.prepareStatement(assignedVNumOldQ);
             ResultSet oldVNumRS = pst4.executeQuery();
             
             String assignedVNum_old = null;
             while(oldVNumRS.next()){
                assignedVNum_old = oldVNumRS.getString("vNumber");
             }
            //System.out.println("assignedVNum_old: " + assignedVNum_old);
            String updateDriverQuery ="UPDATE driver SET vType='"+asg.getVehicleType()+"',vNumber='"+asg.getVehicleNumber()+"' WHERE d_NIC='"+asg1.getDriverNIC()+"'";
            String avail_n = "N";
            String avail_y = "Y";
            
            //System.out.println("assignedVNum_new: " + asg.getVehicleNumber());
            String updateDriverAssigned_newV = "UPDATE vehicle set driverAssigned = '"+avail_y+"' WHERE vehicle_number = '"+asg.getVehicleNumber()+"'";
            String updateDriverAssigned_oldV = "UPDATE vehicle set driverAssigned = '"+avail_n+"' WHERE vehicle_number = '"+assignedVNum_old+"'";
            
            
            pst=con.prepareStatement(updateDriverQuery);
            pst2=con.prepareStatement(updateDriverAssigned_newV);
            if(!assignedVNum_old.equals(null)){
            pst3=con.prepareStatement(updateDriverAssigned_oldV);
            }
            
            //pst.setString(1, "Y");
            
            pst.executeUpdate();  
            pst2.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (pst2 != null) {
                    pst2.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }



}
    
   