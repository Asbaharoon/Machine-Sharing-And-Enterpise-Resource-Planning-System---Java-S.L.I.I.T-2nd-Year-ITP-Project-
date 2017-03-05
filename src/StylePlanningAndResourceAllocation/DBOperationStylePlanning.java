/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

import EmployeeManagement.Employee;
import StockManagement.Machine;
import StockManagement.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author Sampath Rajapakse
 */
public class DBOperationStylePlanning extends DBConnect{
    
    boolean addStyle(Style s){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO Style VALUES (?,?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, s.getStyleNo());//add values to the sql query
            pst.setString(2, s.getBuyer());//add values to the sql query
            pst.setString(3, s.getPrototype());//add values to the sql query
            pst.setString(4, s.getFactory());//add values to the sql query
            pst.setString(5, s.getLocation());//add values to the sql query
            pst.setString(6, s.getStartDate());//add values to the sql query
            pst.setString(7, s.getEndDate());//add values to the sql query
            
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
    
    ArrayList<Style> getStyles() {
        try {
            ArrayList<Style> list=new ArrayList<Style>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM style" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Style sObj=new Style();
                
                sObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                sObj.setBuyer(rs.getString(2));
                sObj.setPrototype(rs.getString(3));
                sObj.setFactory(rs.getString(4));
                sObj.setLocation(rs.getString(5));
                sObj.setStartDate(rs.getString(6));
                sObj.setEndDate(rs.getString(7));
                
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
    
    ArrayList<Style> getStylesByBuyer(String buyer) {
        try {
            ArrayList<Style> list=new ArrayList<Style>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM style WHERE buyer LIKE '%"+buyer+"%'" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Style sObj=new Style();
                
                sObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                sObj.setBuyer(rs.getString(2));
                sObj.setPrototype(rs.getString(3));
                sObj.setFactory(rs.getString(4));
                sObj.setLocation(rs.getString(5));
                sObj.setStartDate(rs.getString(6));
                sObj.setEndDate(rs.getString(7));
                
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
     boolean deleteStyle(Style s){
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM style WHERE styleNo='"+s.getStyleNo()+"' AND factory = '"+s.getFactory()+"' AND location='"+s.getLocation()+"'";
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
     
    boolean updateStyle(Style s,Style s1) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE style SET styleNo='"+s.getStyleNo()+"',buyer='"+s.getBuyer()+"',prototype='"+s.getPrototype()+"',factory='"+s.getFactory()+"',location='"+s.getLocation()+"',startDate='"+s.getStartDate()+"',endDate='"+s.getEndDate()+"' WHERE styleNo="+s1.getStyleNo()+" AND location='"+s1.getLocation()+"'";
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
    boolean addOrderQuantity(PurchaseOrder po){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO purchaseorder VALUES (?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(2, po.getStyleNo());//add values to the sql query
            pst.setInt(1, po.getPurchaseOrderNo());
            pst.setString(3, po.getSize());//add values to the sql query
            pst.setString(4, po.getColor());//add values to the sql query
            pst.setInt(5, po.getQuantity());
            pst.setString(6, po.getRemarks());//add values to the sql query
            
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
    ArrayList<PurchaseOrder> getPurchaseOrders() {
        try {
            ArrayList<PurchaseOrder> list=new ArrayList<PurchaseOrder>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM purchaseorder" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                PurchaseOrder poObj=new PurchaseOrder();
                
                poObj.setPurchaseOrderNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                poObj.setStyleNo(rs.getInt(2));
                poObj.setSize(rs.getString(3));
                poObj.setColor(rs.getString(4));
                poObj.setQuantity(rs.getInt(5));
                poObj.setRemarks(rs.getString(6));
                   
                list.add(poObj);//add the filled Style Object to the List of Style Objects
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
    
    boolean addManPower(ManPower mp){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO stylemanamount VALUES (?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, mp.getStyleNo());//add values to the sql query
            pst.setInt(2, mp.getDirect());//add values to the sql query
            pst.setInt(3, mp.getIndirect());//add values to the sql query
            pst.setInt(4, mp.getTotal());//add values to the sql query
            pst.setInt(5, 0);
            pst.setString(6, "s");
            
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
    
    ArrayList<ManPower> getManPowerAllocation() {
        try {
            ArrayList<ManPower> list=new ArrayList<ManPower>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM stylemanamount" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                ManPower mpObj=new ManPower();
                
                mpObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                mpObj.setDirect(rs.getInt(2));
                mpObj.setIndirect(rs.getInt(3));
                mpObj.setTotal(rs.getInt(4));
                mpObj.setDifference(rs.getInt(5));
                mpObj.setType(rs.getString(6));
                   
                list.add(mpObj);//add the filled Style Object to the List of Style Objects
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
    boolean deletePurchaseOrder(PurchaseOrder po){
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM purchaseorder WHERE styleNo='"+po.getStyleNo()+"'AND color = '"+po.getColor()+"' AND purchaseOrderID = '"+po.getPurchaseOrderNo()+"' AND size='"+po.getSize()+"'";
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
    boolean deleteManPower(ManPower mp){
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM stylemanamount WHERE styleNo='"+mp.getStyleNo()+"'";
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
    boolean addMaterialQuantity(StyleMaterial sm){
    try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO styleMaterial VALUES (?,?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, sm.getStyleNo());//add values to the sql query
            pst.setInt(2, sm.getMaterialNo());
            pst.setString(3, sm.getType());//add values to the sql query
            pst.setString(4, sm.getColor());//add values to the sql query
            pst.setFloat(5, sm.getQuantity());
            pst.setString(6, sm.getRemarks());//add values to the sql query
            pst.setInt(7,5);
            
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

    ArrayList<StyleMaterial> getStyleMaterial() {
       try {
            ArrayList<StyleMaterial> list=new ArrayList<StyleMaterial>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM stylematerial" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                StyleMaterial smObj=new StyleMaterial();
                
                smObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                smObj.setMaterialNo(rs.getInt(2));
                smObj.setType(rs.getString(3));
                smObj.setColor(rs.getString(4));
                smObj.setQuantity(rs.getFloat(5));
                smObj.setRemarks(rs.getString(6));
                   
                list.add(smObj);//add the filled Style Object to the List of Style Objects
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

    boolean deleteStyleMaterial(StyleMaterial sm) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM stylematerial WHERE styleNo='"+sm.getStyleNo()+"' AND color = '"+sm.getColor()+"' AND materialNo = '"+sm.getMaterialNo()+"'AND type = '"+sm.getType()+"'";
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

    boolean updateStyleMaterial(StyleMaterial sm, StyleMaterial table) {
         try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE stylematerial SET styleNo='"+sm.getStyleNo()+"',materialNo='"+sm.getMaterialNo()+"',type='"+sm.getType()+"',color='"+sm.getColor()+"',quantity="+sm.getQuantity()+",remarks='"+sm.getRemarks()+"' WHERE styleNo="+table.getStyleNo()+" AND materialNo='"+table.getMaterialNo()+"'AND type='"+table.getType()+"'";
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

    boolean updatePurchaseOrder(PurchaseOrder po, PurchaseOrder table) {
        try {
            System.out.println(po.getQuantity());
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE purchaseorder SET styleNo="+po.getStyleNo()+" ,purchaseOrderID="+po.getPurchaseOrderNo()+" ,size='"+po.getSize()+"' ,color='"+po.getColor()+"' ,quantity="+po.getQuantity()+" ,remarks='"+po.getRemarks()+"' WHERE styleNo="+table.getStyleNo()+" AND purchaseOrderID="+table.getPurchaseOrderNo()+" AND size='"+table.getSize()+"' AND color='"+table.getColor()+"'";
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

    boolean updateManPower(ManPower mp, ManPower table) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE stylemanamount SET styleNo="+mp.getStyleNo()+",direct="+mp.getDirect()+",indirect="+mp.getIndirect()+",total="+mp.getTotal()+" WHERE styleNo="+table.getStyleNo()+"";
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

    boolean addOperation(StyleOperation so) {
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO styleoperation VALUES (?,?,?,?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, so.getStyleNo());//add values to the sql query
            pst.setInt(2, so.getOperationNo());
            pst.setString(3, so.getType());//add values to the sql query
            pst.setString(4, so.getMachine());//add values to the sql query
            pst.setInt(5, so.getQuantity());
            pst.setString(6, so.getSpeciality());
            pst.setString(7, so.getRemarks());//add values to the sql query
            pst.setDouble(8, so.getMc());
            pst.setDouble(9, so.getMa());
            
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

    ArrayList<StyleOperation> getOperation() {
        try {
            ArrayList<StyleOperation> list=new ArrayList<StyleOperation>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM styleoperation" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                StyleOperation soObj=new StyleOperation();
                
                soObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                soObj.setOperationNo(rs.getInt(2));
                soObj.setType(rs.getString(3));
                soObj.setMachine(rs.getString(4));
                soObj.setQuantity(rs.getInt(5));
                soObj.setSpeciality(rs.getString(6));
                soObj.setRemarks(rs.getString(7));
                soObj.setMc(rs.getDouble(8));
                soObj.setMa(rs.getDouble(9));
                   
                list.add(soObj);//add the filled Style Object to the List of Style Objects
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

    boolean updateStyleOperation(StyleOperation so, StyleOperation table) {
       try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE styleoperation SET styleNo='"+so.getStyleNo()+"',operationNo='"+so.getOperationNo()+"',type='"+so.getType()+"',machine='"+so.getMachine()+"',quantity="+so.getQuantity()+",speciality='"+so.getSpeciality()+"',remarks='"+so.getRemarks()+"',mc="+so.getMc()+",ma="+so.getMa()+" WHERE styleNo="+table.getStyleNo()+" AND operationNo='"+table.getOperationNo()+"'";
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

    boolean deleteStyleOperation(StyleOperation so) {
       try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM styleoperation WHERE styleNo='"+so.getStyleNo()+"' AND operationNo = '"+so.getOperationNo()+"'";
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
     Style getCurrentStyleObject(Style s) {
       try {
            
           // Style currentStyle=new Style();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="SELECT * FROM style WHERE factory='"+s.getFactory()+"' AND location='"+s.getLocation()+"' AND startDate <='"+s.getSearchDate()+"' AND endDate >='"+s.getSearchDate()+"'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            
             while (rs.next()) {
                
                s.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                s.setBuyer(rs.getString(2));
                s.setPrototype(rs.getString(3));
                s.setFactory(rs.getString(4));
                s.setLocation(rs.getString(5));
                s.setStartDate(rs.getString(6));
                s.setEndDate(rs.getString(7));
                
             }
             
            return s;
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
    Style getNextStyleObject(Style s) {
       try {
            
           // Style currentStyle=new Style();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            System.out.println(s.getSearchDate());
            System.out.println(s.getFactory());
            System.out.println(s.getLocation());
            String query ="SELECT * FROM style WHERE factory='"+s.getFactory()+"' AND location='"+s.getLocation()+"' AND startDate>='"+s.getSearchDate()+"' AND endDate>='"+s.getSearchDate()+"'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            
             while (rs.next()) {
                
                s.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                s.setBuyer(rs.getString(2));
                s.setPrototype(rs.getString(3));
                s.setFactory(rs.getString(4));
                s.setLocation(rs.getString(5));
                s.setStartDate(rs.getString(6));
                s.setEndDate(rs.getString(7));
                
            }
             System.out.println(s.getStyleNo());
            return s;
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
    int getMachineAmount(String type,Style s) {
       try {      
            con=DriverManager.getConnection(url, username, password);//get the connection   
            String query ="SELECT SUM(quantity) FROM styleoperation WHERE styleNo='"+s.getStyleNo()+"' AND  machine='"+type+"'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            int amount=0;
             while (rs.next()) {
                
                amount=(rs.getInt(1));//get the values in column 1 and storing in Style object
           
                
             }
            return amount;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return 0;
            

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

    ManPower getManPowerAmount(Style s) {
        try {      
            con=DriverManager.getConnection(url, username, password);//get the connection   
            String query ="SELECT direct,indirect FROM stylemanamount WHERE styleNo='"+s.getStyleNo()+"'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
                ManPower mp=new ManPower();
             while (rs.next()) {
                
                mp.setDirect(rs.getInt(1));//get the values in column 1 and storing in Style object
                mp.setIndirect(rs.getInt(2));
                
             }
            return mp;
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
               
            }  
        }
    }

    float getMaterial(String type,Style s) {
        try {      
            con=DriverManager.getConnection(url, username, password);//get the connection   
            String query ="SELECT quantity FROM stylematerial WHERE styleNo='"+s.getStyleNo()+"' AND  type='"+type+"'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            int amount=0;
             while (rs.next()) {
                
                amount=(rs.getInt(1));//get the values in column 1 and storing in Style object
           
                
             }
            return amount;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return 0;
            

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

    boolean addMachineDifference(StyleOperation so, StyleOperation so1, StyleOperation so2, StyleOperation so3,boolean status) {
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO machinedifference VALUES (?,?,?,?) ";

            System.out.println(so.getStyleNo());
            System.out.println(so.getMachine());
            System.out.println(so.getDifference());
            System.out.println(status);
            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, so.getStyleNo());//add values to the sql query
            pst.setString(2, so.getMachine());//add values to the sql query
            pst.setInt(3, so.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            pst.setInt(1, so1.getStyleNo());//add values to the sql query
            pst.setString(2, so1.getMachine());//add values to the sql query
            pst.setInt(3, so1.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();
            
            pst.setInt(1, so2.getStyleNo());//add values to the sql query
            pst.setString(2, so2.getMachine());//add values to the sql query
            pst.setInt(3, so2.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();
            
            pst.setInt(1, so3.getStyleNo());//add values to the sql query
            pst.setString(2, so3.getMachine());//add values to the sql query
            pst.setInt(3, so3.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();
            /*
            pst.setInt(1, so4.getStyleNo());//add values to the sql query
            pst.setString(2, so4.getMachine());//add values to the sql query
            pst.setInt(3, so4.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();
            
            pst.setInt(1, so5.getStyleNo());//add values to the sql query
            pst.setString(2, so5.getMachine());//add values to the sql query
            pst.setInt(3, so5.getDifference());
            pst.setBoolean(4,status);
            pst.executeUpdate();
*/
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

    boolean addManPowerDifference(ManPower mp, ManPower mp1, boolean status) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO manpowerdifference VALUES (?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, mp.getStyleNo());//add values to the sql query
            pst.setString(2, mp.getType());//add values to the sql query
            pst.setInt(3, mp.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table

            pst.setInt(1, mp1.getStyleNo());//add values to the sql query
            pst.setString(2, mp1.getType());//add values to the sql query
            pst.setInt(3, mp1.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table
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

    boolean addMaterialDifference(StyleMaterial sm, StyleMaterial sm1, StyleMaterial sm2, StyleMaterial sm3, boolean status) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO materialdifference VALUES (?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, sm.getStyleNo());//add values to the sql query
            pst.setString(2, sm.getType());//add values to the sql query
            pst.setFloat(3, sm.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table

            pst.setInt(1, sm1.getStyleNo());//add values to the sql query
            pst.setString(2, sm1.getType());//add values to the sql query
            pst.setFloat(3, sm1.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table
            
            pst.setInt(1, sm2.getStyleNo());//add values to the sql query
            pst.setString(2, sm2.getType());//add values to the sql query
            pst.setFloat(3, sm2.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table
            
            pst.setInt(1, sm3.getStyleNo());//add values to the sql query
            pst.setString(2, sm3.getType());//add values to the sql query
            pst.setFloat(3, sm3.getDifference());
            pst.setBoolean(4, status);
            pst.executeUpdate();//execute the sql query and insert the values to db table
            
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

    ArrayList<StyleOperation> getMachineDiff() {
         try {
            ArrayList<StyleOperation> list=new ArrayList<StyleOperation>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM machinedifference" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                StyleOperation soObj=new StyleOperation();
                
                soObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                soObj.setMachine(rs.getString(2));
                soObj.setDifference(rs.getInt(3));
                      
                list.add(soObj);//add the filled Style Object to the List of Style Objects
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

    ArrayList<ManPower> getManPowerDiff() {
        try {
            ArrayList<ManPower> list=new ArrayList<ManPower>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM manpowerdifference" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                ManPower soObj=new ManPower();
                
                soObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                soObj.setType(rs.getString(2));
                soObj.setDifference(rs.getInt(3));
                      
                list.add(soObj);//add the filled Style Object to the List of Style Objects
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

    ArrayList<StyleMaterial> getMaterialDiff() {
        try {
            ArrayList<StyleMaterial> list=new ArrayList<StyleMaterial>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM materialdifference" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                StyleMaterial soObj=new StyleMaterial();
                
                soObj.setStyleNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                soObj.setType(rs.getString(2));
                soObj.setDifference(rs.getFloat(3));
                      
                list.add(soObj);//add the filled Style Object to the List of Style Objects
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

    boolean deleteMachienDiff(StyleOperation get) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM machinedifference WHERE nextStyleNo='"+get.getStyleNo()+"' AND type = '"+get.getMachine()+"'";
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

    boolean deleteManPowerDiff(ManPower get) {
       try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM manpowerdifference WHERE styleNo='"+get.getStyleNo()+"' AND type = '"+get.getType()+"'";
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

    boolean deleteMaterialDiff(StyleMaterial get) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM materialdifference WHERE styleNo='"+get.getStyleNo()+"' AND type = '"+get.getType()+"'";
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

    /**
     * 
     * @param ma
     * @return 
     */
    ArrayList<Machine> getIdleMachine(Machine ma) {
        try {
            ArrayList<Machine> list=new ArrayList<Machine>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT DISTINCT m.assetID,m.factory,m.location,m.type,m.ownership FROM machine m ,style s WHERE m.ownership='"+ma.getOwnership()+"' AND m.factory='"+ma.getFactory()+"' AND m.location='"+ma.getLocation()+"' AND s.factory='"+ma.getFactory()+"' AND s.location='"+ma.getLocation()+"' AND s.endDate <='"+ma.getSearchDate()+"' AND m.assetID NOT IN (SELECT assetID FROM assignmachine)" ;
            pst=con.prepareStatement(query);
            
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Machine mobj=new Machine();
                
                mobj.setAssetID(rs.getString(1));//get the values in column 1 and storing in Style object
                mobj.setFactory(rs.getString(2));
                mobj.setLocation(rs.getString(3));
                mobj.setType(rs.getString(4));
                mobj.setOwnership(rs.getString(5));
                
                list.add(mobj);//add the filled Style Object to the List of Style Objects
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
boolean assignMachine(AssignMachine a){
        try {
            
           con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
           conUpdate = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO assignmachine VALUES (?,?,?,?,?) ";
            String updateQuery = "UPDATE machine SET Factory='"+a.getFactory()+"' ,Location ='"+a.getLocation()+"' WHERE assetID='"+a.getAssetID()+"'";
            pstUpdate=conUpdate.prepareStatement(updateQuery);
            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, a.getAssetID());//add values to the sql query
            pst.setInt(2, a.getStyleNo());//add values to the sql query
            pst.setString(3, a.getType());//add values to the sql query
            pst.setString(4, a.getFactory());//add values to the sql query
            pst.setString(5, a.getLocation());//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to db table
            pstUpdate.executeUpdate();
            //since it's a INSERT statement
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null && pstUpdate !=null) {
                    pst.close();//resetting
                    pstUpdate.close();
                }
                if (con != null && conUpdate !=null) {

                    con.close();//reseting
                    conUpdate.close();

                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    
    }

    ArrayList<AssignMachine> getAssignedMachines() {
         try {
            ArrayList<AssignMachine> list=new ArrayList<AssignMachine>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM assignmachine" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                AssignMachine sObj=new AssignMachine();
                
                sObj.setAssetID(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setStyleNo(rs.getInt(2));
                sObj.setType(rs.getString(3));
                sObj.setFactory(rs.getString(4));
                sObj.setLocation(rs.getString(5));
                
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

    boolean deleteAssignMachine(AssignMachine get) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM assignmachine WHERE styleNo='"+get.getStyleNo()+"' AND type = '"+get.getType()+"' AND factory = '"+get.getFactory()+"' AND location='"+get.getLocation()+"'";
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

    ArrayList<Material> getAvailabaleMaterials(Material ma) {
       try {
            ArrayList<Material> list=new ArrayList<Material>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT DISTINCT m.assetID,m.brand,m.quantity,m.type,m.color FROM material m ,style s WHERE m.factory='"+ma.getFactory()+"' AND m.location='"+ma.getLocation()+"' AND s.factory='"+ma.getFactory()+"' AND s.location='"+ma.getLocation()+"' AND s.endDate <='"+ma.getSearchDate()+"' AND m.assetID NOT IN (SELECT assetID FROM assignmaterial)" ;
            pst=con.prepareStatement(query);
            
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Material mobj=new Material();
                
                mobj.setAssetID(rs.getString(1));//get the values in column 1 and storing in Style object
                mobj.setBrand(rs.getString(2));
                mobj.setQuantity(rs.getFloat(3));
                mobj.setType(rs.getString(4));
                mobj.setColor(rs.getString(5));
                
                list.add(mobj);//add the filled Style Object to the List of Style Objects
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

    boolean assignMaterial(AssignMaterial am, float finalQuantity) {
        try {
            
           con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
           conUpdate = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO assignmaterial VALUES (?,?,?,?,?,?) ";
            String updateQuery = "UPDATE material SET factory='"+am.getFactory()+"' ,location ='"+am.getLocation()+"',quantity='"+finalQuantity+"' WHERE assetID='"+am.getAssetID()+"'";
            pstUpdate=conUpdate.prepareStatement(updateQuery);
            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, am.getAssetID());//add values to the sql query
            pst.setInt(2, am.getStyleNo());//add values to the sql query
            pst.setString(3, am.getType());//add values to the sql query
            pst.setFloat(4, am.getQuantity());
            pst.setString(5, am.getFactory());//add values to the sql query
            pst.setString(6, am.getLocation());//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to db table
            pstUpdate.executeUpdate();
            //since it's a INSERT statement
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null && pstUpdate !=null) {
                    pst.close();//resetting
                    pstUpdate.close();
                }
                if (con != null && conUpdate !=null) {

                    con.close();//reseting
                    conUpdate.close();

                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    
    }

    ArrayList<AssignMaterial> getAssignedMaterial() {
         try {
            ArrayList<AssignMaterial> list=new ArrayList<AssignMaterial>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM assignmaterial" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                AssignMaterial sObj=new AssignMaterial();
                
                sObj.setAssetID(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setStyleNo(rs.getInt(2));
                sObj.setType(rs.getString(3));
                sObj.setQuantity(rs.getFloat(4));
                sObj.setFactory(rs.getString(5));
                sObj.setLocation(rs.getString(6));
                
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

    boolean deleteAssignMaterial(AssignMaterial get) {
        try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM assignmaterial WHERE styleNo='"+get.getStyleNo()+"' AND type = '"+get.getType()+"'AND quantity = '"+get.getQuantity()+"' AND factory = '"+get.getFactory()+"' AND location='"+get.getLocation()+"'";
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

    ArrayList<Employee> getIdleWorker(Employee emp) {
        try {
            ArrayList<Employee> list=new ArrayList<Employee>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT DISTINCT m.EmployeeNo,m.FullName,m.Designation,s.factory,m.Location FROM employee_info m ,style s WHERE m.Designation='"+emp.getDesignation()+"' AND m.Location='"+emp.getLocation()+"' AND s.factory='"+emp.getFactory()+"' AND s.location='"+emp.getLocation()+"' AND s.endDate <='"+emp.getSearchDate()+"' AND m.EmployeeNo NOT IN (SELECT assetID FROM assignworker)" ;
            pst=con.prepareStatement(query);
            
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                Employee mobj=new Employee();
                
                mobj.setEmpNo(rs.getString(1));//get the values in column 1 and storing in Style object
                mobj.setFullName(rs.getString(2));
                mobj.setDesignation(rs.getString(3));
                mobj.setFactory(rs.getString(4));
                mobj.setLocation(rs.getString(5));
                
                list.add(mobj);//add the filled Style Object to the List of Style Objects
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

    ArrayList<AssignWorker> getAssignedWorker() {
        try {
            ArrayList<AssignWorker> list=new ArrayList<AssignWorker>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM assignworker" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                AssignWorker sObj=new AssignWorker();
                
                sObj.setAssetID(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setStyleNo(rs.getInt(2));
                sObj.setType(rs.getString(3));
                sObj.setOperation(rs.getString(4));
                sObj.setFactory(rs.getString(5));
                sObj.setLocation(rs.getString(6));
                
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

    boolean assignWorker(AssignWorker aw) {
        try {
            
           con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
           conUpdate = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO assignworker VALUES (?,?,?,?,?,?) ";
            String updateQuery = "UPDATE employee_info SET Location ='"+aw.getLocation()+"' WHERE EmployeeNo='"+aw.getAssetID()+"'";
            pstUpdate=conUpdate.prepareStatement(updateQuery);
            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, aw.getAssetID());//add values to the sql query
            pst.setInt(2, aw.getStyleNo());//add values to the sql query
            pst.setString(3, aw.getType());//add values to the sql query
            pst.setString(4, aw.getOperation());
            pst.setString(5, aw.getFactory());//add values to the sql query
            pst.setString(6, aw.getLocation());//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to db table
            pstUpdate.executeUpdate();
            //since it's a INSERT statement
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null && pstUpdate !=null) {
                    pst.close();//resetting
                    pstUpdate.close();
                }
                if (con != null && conUpdate !=null) {

                    con.close();//reseting
                    conUpdate.close();

                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    
    }

    boolean deleteAssignWorker(AssignWorker get) {
         try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="DELETE FROM assignworker WHERE styleNo='"+get.getStyleNo()+"' AND type = '"+get.getType()+"'AND operation = '"+get.getOperation()+"' AND factory = '"+get.getFactory()+"' AND location='"+get.getLocation()+"'";
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

    ArrayList<StyleOperation> getOperationType() {
        try {
            ArrayList<StyleOperation> list=new ArrayList<StyleOperation>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT DISTINCT type FROM styleoperation" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute it has rows
                StyleOperation soObj=new StyleOperation();
                        
                soObj.setType(rs.getString(1));
                               
                list.add(soObj);//add the filled Style Object to the List of Style Objects
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

}
