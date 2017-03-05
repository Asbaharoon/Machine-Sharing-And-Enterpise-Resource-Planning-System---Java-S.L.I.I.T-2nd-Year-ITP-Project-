/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author isuru
 */
public class DBConnectEmployeeManagement extends DBConnect{
    
    boolean addEmployee(Employee emp){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String getDept = "SELECT DepartmentNo FROM department_info WHERE DepartmentName ='"+emp.getDepartment()+"'";
            pst=con.prepareStatement(getDept);
            rs = pst.executeQuery();
            String deptNo=null;
            if(rs.next()){
                deptNo = rs.getString(1);
            }
            
            String query ="INSERT INTO employee_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?,'"+deptNo+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
            pst.setString(1, emp.getFullName());//add value to the sql query
            pst.setString(2, emp.getEmpNo());
            pst.setString(3, emp.getEpfNo());
            pst.setString(4, emp.getAddress());
            pst.setString(5, emp.getDob());
            pst.setString(6, emp.getNic());
            pst.setString(7, emp.getGender());
            pst.setString(8, emp.getMaritalStatus());
            pst.setString(9, emp.getTitle());
            pst.setString(10, emp.getPhoneNo());
            pst.setString(11, emp.getEmail());
            pst.setString(12, emp.getDateJoined());
            pst.setString(13, emp.getEmpType());
            pst.setString(14, emp.getDesignation());
            pst.setString(15, emp.getLocation());
            pst.setString(16, emp.getRoot());
            pst.setDouble(17, emp.getBasicSalary());
            pst.setString(18, emp.getAcNo());
            pst.setString(19, emp.getOt());
            pst.setString(20, emp.getEpf());
            pst.setString(21, emp.getEtf());
            pst.setString(22, emp.getRemarks());
            pst.setBytes(23, emp.getImage());
            pst.setString(24, emp.getStatus());
            pst.setString(25, emp.getRetirementDate());
            pst.setString(26, emp.getPassword());
            
            pst.executeUpdate();//execute the sql query with these given values and insert that data to db
            return true;
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;
        
        }finally{
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            }catch(Exception e){
                System.out.println("Exception is throws " + e);
            }
        
        }
    }
    
    boolean addDepartment(Department dept){
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO department_info VALUES (?,?) ";

            pst = con.prepareStatement(query); 
            
            pst.setString(1, dept.getDepartmentNo());
            pst.setString(2, dept.getDepartmentName());
            
            pst.executeUpdate();//execute the sql query and insert the values to db table
            return true;
        } catch (Exception e){
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
    
    boolean addLeave(Leave lev){   
            try{
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String getDept = "SELECT DepartmentNo FROM department_info WHERE DepartmentName ='"+lev.getDepartmentNo()+"'";
            pst=con.prepareStatement(getDept);
            rs = pst.executeQuery();
            String deptNo=null;
            if(rs.next()){
                deptNo = rs.getString(1);
            }
            
            String query ="INSERT INTO leave_info VALUES(?,?,'"+deptNo+"',?,?,?,?,?,?,?,?,?)";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
            pst.setString(1, lev.getLeaveNo());//add value to the sql query
            pst.setString(2, lev.getEmpNo());
            pst.setString(3, lev.getType());
            pst.setString(4, lev.getDateFrom());
            pst.setString(5, lev.getDateTo());
            pst.setInt(6, lev.getFullDays());
            pst.setInt(7, lev.getHalfDays());
            pst.setString(8, lev.getReason());
            pst.setString(9, lev.getPhoneNo());
            pst.setString(10, lev.getStatus());
            pst.setString(11, lev.getApprovedBy());
            
            pst.executeUpdate();//execute the sql query with these given values and insert that data to db
            return true;
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;
        
        }finally{
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            }catch(Exception e){
                System.out.println("Exception is throws " + e);
            }
        }    
        }
    
    boolean addSalaryDetail(Salary sal){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="INSERT INTO salary_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
            pst.setInt(1, 0);
            pst.setString(2, sal.getMonth());//add value to the sql query
            pst.setString(3, sal.getYear());
            pst.setString(4, sal.getEmployeeNo());
            pst.setString(5, sal.getName());
            pst.setString(6, sal.getEpfNo());
            pst.setDouble(7, sal.getBasicSalary());
            pst.setDouble(8, sal.getEpf());
            pst.setDouble(9, sal.getEtf());
            pst.setDouble(10, sal.getNoPayLeave());
            pst.setDouble(11, sal.getDeductions());
            pst.setDouble(12, sal.getBonus());
            pst.setDouble(13, sal.getOtAmount());
            pst.setDouble(14, sal.getGrossSalary());
            pst.setDouble(15, sal.getNetSalary());
            
            pst.executeUpdate();//execute the sql query with these given values and insert that data to db
            return true;
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;
        
        }finally{
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            }catch(Exception e){
                System.out.println("Exception is throws " + e);
            }
        
        }
        
    }
    
    boolean markIntime(String empNo){
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="INSERT INTO attendance(EmployeeNo, Intime, Date) VALUES(?,?,?)";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
           // String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            
            pst.setString(1, empNo);//add value to the sql query
            pst.setString(2, timeStamp);
            pst.setString(3, date);
            
            pst.executeUpdate();//execute the sql query with these given values and insert that data to db
            return true;
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;
        
        }finally{
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            }catch(Exception e){
                System.out.println("Exception is throws " + e);
            }
        }    
    }
    
    boolean markOfftime(String empNo){
        
        try{
            
            //String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="UPDATE attendance SET Offtime='"+timeStamp+"' WHERE EmployeeNo='"+empNo+"' AND Date='"+date+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
            pst.executeUpdate();;//execute the sql query with these given values and insert that data to db
            return true;
        }catch(Exception e){
            
            System.out.println("Exception is throws " + e);
            return false;
        
        }finally{
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            }catch(Exception e){
                System.out.println("Exception is throws " + e);
            }
        }    
    }
    
    Salary getEmployeeSalary(String empNo, String month){
        try{
            
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT FullName, EPFNo, BasicSalary from employee_info WHERE EmployeeNo='"+empNo+"'";

            pst = con.prepareStatement(query); 
            rs = pst.executeQuery();
            
            String name = null;
            String epfNo = null;
            String bSalary = null;
            String levCount = null;
            String otHrs = null;
            while(rs.next()){//will ensure that it will execute while it has rows
                name = rs.getString(1);
                epfNo = rs.getString(2);
                bSalary = rs.getString(3);
            }
         //  String query2 = "SELECT COUNT(LeaveNo) FROM leave_info WHERE EmployeeNo='"+empNo+"' AND Type='No-Pay'";
         
            String query2 = "SELECT COUNT(LeaveNo) FROM leave_info WHERE EmployeeNo='"+empNo+"' AND Type='No-Pay' AND MONTHNAME(FromDate)='"+month+"'";
            
            pst = con.prepareStatement(query2); 
            res = pst.executeQuery();
            
            
            String query3 = "SELECT SUM(OtHrs) FROM attendance WHERE EmployeeNo='"+empNo+"' AND MONTHNAME(Date)='"+month+"'";

            pst = con.prepareStatement(query3); 
            ress = pst.executeQuery();
            
            while(ress.next()){
                otHrs = ress.getString(1);
            }
            
            while(res.next()){//will ensure that it will execute while it has rows
                levCount = res.getString(1);
            }
            double epf = Double.parseDouble(bSalary)*0.08;
            double etf = Double.parseDouble(bSalary)*0.03;
            double noPayLev = (Double.parseDouble(bSalary)/30)*Double.parseDouble(levCount);
            double deduct = epf+etf+noPayLev;
            double otAmt = (Double.parseDouble(bSalary)/30/8)*1.5*Double.parseDouble(otHrs);
            
            Salary salObj = new Salary();
            
            salObj.setName(name);
            salObj.setEpfNo(epfNo);
            salObj.setBasicSalary(Double.parseDouble(bSalary));
            salObj.setEpf(epf);
            salObj.setEtf(etf);
            salObj.setNoPayLeave(noPayLev);
            salObj.setDeductions(deduct);
            salObj.setOtAmount(otAmt);
            
           // salObj.setName(name);
           
           return salObj;



        } catch (Exception e){
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
    
        ArrayList<Employee> getEmployee() {
        try {
            ArrayList<Employee> list=new ArrayList<Employee>();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            
         
            String query ="SELECT * FROM employee_info WHERE Status='work'" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Employee empObj=new Employee();
                
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
                list.add(empObj);//add the filled Employee Object to the List of Employee Objects
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
            }

        }
    }
        
        ArrayList<Salary> getSalary() {
        try {
            ArrayList<Salary> list=new ArrayList<Salary>();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            
         
            String query ="SELECT EmployeeNo, EPFNo, BasicSalary, Deductions, Bonus, GrossSalary, NetSalary FROM salary_info" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
            
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Salary salObj=new Salary();
                
                salObj.setEmployeeNo(rs.getString(1));//get the values in column 1 and storing in employee object
                salObj.setEpfNo(rs.getString(2));
                salObj.setBasicSalary(rs.getDouble(3));
                salObj.setDeductions(rs.getDouble(4));
                salObj.setBonus(rs.getDouble(5));
                salObj.setGrossSalary(rs.getDouble(6));
                salObj.setNetSalary(rs.getDouble(7));
                
                list.add(salObj);//add the filled Employee Object to the List of Employee Objects
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
            }

        }
    }
        
        ArrayList<Leave> getLeave() {
            try {
            ArrayList<Leave> list=new ArrayList<Leave>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT li.LeaveNo, li.EmployeeNo, li.DepartmentNo, li.Type, li.FromDate, li.ToDate, li.FullDays, li.HalfDays, li.Reason, li.PhoneNo, li.Status, li.ApprovedBy, ei.FullName FROM leave_info li, employee_info ei  WHERE li.Status='Pending' and li.EmployeeNo=ei.EmployeeNo" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Leave levObj=new Leave();
                
                levObj.setLeaveNo(rs.getString(1));//get the values in column 1 and storing in employee object
                levObj.setEmpNo(rs.getString(2));
                levObj.setDepartmentNo(rs.getString(3));
                levObj.setType(rs.getString(4));
                levObj.setDateFrom(rs.getString(5));
                levObj.setDateTo(rs.getString(6));
                levObj.setFullDays(Integer.parseInt(rs.getString(7)));
                levObj.setHalfDays(Integer.parseInt(rs.getString(8)));
                levObj.setReason(rs.getString(9));
                levObj.setPhoneNo(rs.getString(10));
                levObj.setStatus(rs.getString(11));
                levObj.setApprovedBy(rs.getString(12));
                levObj.setName(rs.getString(13));
                
                list.add(levObj);//add the filled Employee Object to the List of Employee Objects
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
            }
        }
        }
        
        ArrayList<Leave> getSpecificLeave(Leave lev){
            try {
            ArrayList<Leave> list=new ArrayList<Leave>();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="SELECT * FROM leave_info WHERE EmployeeNo='"+lev.getEmpNo()+"'" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Leave levObj=new Leave();
                
                levObj.setLeaveNo(rs.getString(1));//get the values in column 1 and storing in employee object
                levObj.setEmpNo(rs.getString(2));
                levObj.setDepartmentNo(rs.getString(3));
                levObj.setType(rs.getString(4));
                levObj.setDateFrom(rs.getString(5));
                levObj.setDateTo(rs.getString(6));
                levObj.setFullDays(Integer.parseInt(rs.getString(7)));
                levObj.setHalfDays(Integer.parseInt(rs.getString(8)));
                levObj.setReason(rs.getString(9));
                levObj.setPhoneNo(rs.getString(10));
                levObj.setStatus(rs.getString(11));
                levObj.setApprovedBy(rs.getString(12));
                
                list.add(levObj);//add the filled Employee Object to the List of Employee Objects
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
            }
        }
            
        }
        
        ArrayList<Leave> getLeaveHistory(String empNo){
            try {
            ArrayList<Leave> list=new ArrayList<Leave>();
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="SELECT * FROM leave_info WHERE EmployeeNo='"+empNo+"'" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Leave levObj=new Leave();
                
                levObj.setLeaveNo(rs.getString(1));//get the values in column 1 and storing in employee object
                levObj.setEmpNo(rs.getString(2));
                levObj.setDepartmentNo(rs.getString(3));
                levObj.setType(rs.getString(4));
                levObj.setDateFrom(rs.getString(5));
                levObj.setDateTo(rs.getString(6));
                levObj.setFullDays(Integer.parseInt(rs.getString(7)));
                levObj.setHalfDays(Integer.parseInt(rs.getString(8)));
                levObj.setReason(rs.getString(9));
                levObj.setPhoneNo(rs.getString(10));
                levObj.setStatus(rs.getString(11));
                levObj.setApprovedBy(rs.getString(12));
                
                list.add(levObj);//add the filled Employee Object to the List of Employee Objects
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
            }
        }
            
        }
        
        ArrayList<Department> getDepartment() {
            try {
            ArrayList<Department> list=new ArrayList<Department>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM department_info" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Department depObj=new Department();
                
                depObj.setDepartmentNo(rs.getString(1));//get the values in column 1 and storing in employee object
                depObj.setDepartmentName(rs.getString(2));
                
                list.add(depObj);//add the filled Employee Object to the List of Employee Objects
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
        
        ArrayList<Attendance> getAttendance() {
            try {
                
            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
   
            ArrayList<Attendance> list=new ArrayList<Attendance>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT * FROM attendance WHERE Date='"+date+"'" ;
            pst=con.prepareStatement(query);//making a prepared statement
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         
            while(rs.next()){//will ensure that it will execute while it has rows
                Attendance attObj=new Attendance();
                
                attObj.setEmpNo(rs.getString(1));//get the values in column 1 and storing in employee object
                attObj.setInTime(rs.getString(2));
                attObj.setOffTime(rs.getString(3));
                attObj.setDate(rs.getString(4));
                attObj.setOtHrs(rs.getInt(5));
                
                list.add(attObj);//add the filled Employee Object to the List of Employee Objects
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
        
        boolean updateEmployee(Employee oldEmp, Employee newEmp){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String getDept = "SELECT DepartmentNo FROM department_info WHERE DepartmentName ='"+newEmp.getDepartment()+"'";
            pst=con.prepareStatement(getDept);
            rs = pst.executeQuery();
            String deptNo=null;
            if(rs.next()){
                deptNo = rs.getString(1);
            }
            
            String query ="UPDATE employee_info SET EPFNo='"+newEmp.getEpfNo()+"',FullName='"+newEmp.getFullName()+"',"
                    + "Address='"+newEmp.getAddress()+"',DOB='"+newEmp.getDob()+"',Gender='"+newEmp.getGender()+"',"
                    + "MaritalStatus='"+newEmp.getMaritalStatus()+"',Title='"+newEmp.getTitle()+"',NIC='"+newEmp.getNic()+"',"
                    + "PhoneNo='"+newEmp.getPhoneNo()+"',Email='"+newEmp.getEmail()+"',"
                    + "DateJoined='"+newEmp.getDateJoined()+"',EmployeeType='"+newEmp.getEmpType()+"',"
                    + "Department='"+deptNo+"',Location='"+newEmp.getLocation()+"',"
                    +"Designation='"+newEmp.getDesignation()+"',BasicSalary='"+newEmp.getBasicSalary()+"',OT='"+newEmp.getOt()+"',"
                    +"EPF='"+newEmp.getEpf()+"',ETF='"+newEmp.getEtf()+"',Route='"+newEmp.getRoot()+"',AccountNo='"+newEmp.getAcNo()+"',"
                    +"Remarks='"+newEmp.getRemarks()+"',Image='"+newEmp.getImage()+"' WHERE EmployeeNo='"+oldEmp.getEmpNo()+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
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
            }

        }       
        }
        
        boolean updateDepartment(Department oldDep, Department newDep){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query ="UPDATE department_info SET DepartmentName='"+newDep.getDepartmentName()+"' WHERE DepartmentNo='"+oldDep.getDepartmentNo()+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
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
            }

        }
            
            
        }
        
        boolean removeEmployee(Employee emp){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()); //get current date from machine
            
            String query ="UPDATE employee_info SET Status='removed', RetirementDate='"+timeStamp+"' WHERE EmployeeNo='"+emp.getEmpNo()+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
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
            }
        }
        }
        
        boolean approveLeave(Leave lev){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="UPDATE leave_info SET Status='Accepted' WHERE LeaveNo='"+lev.getLeaveNo()+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
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
            }
        }
        }
        
        boolean rejectLeave(Leave lev){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            
            String query ="UPDATE leave_info SET Status='Rejected' WHERE LeaveNo='"+lev.getLeaveNo()+"'";
            
            pst=con.prepareStatement(query);//making a prepared statement
            
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
            }
        }
        }
        
        String generateEmployeeID(){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT EmployeeNo FROM employee_info ORDER BY EmployeeNo DESC LIMIT 1";
            
            pst=con.prepareStatement(query);//making a prepared statement
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            String id = null;
            if(rs.next()){
                id = rs.getString(1);
            }
            
            String newId = null;
            Integer value;
            
            if(id==null){
                value = null;
            } else {
                value = Integer.parseInt(id.substring(4));//split stringID from
            }
             
            if(id==null){
                newId = "emp-0001";
            }
            if(value>=1 && value <=8){
                newId = "emp-000"+(Integer.parseInt(id.substring(7,id.length()))+1);
            }
            else if(value>=9 && value<=98){
                newId = "emp-00"+(Integer.parseInt(id.substring(6,id.length()))+1);
            }
            else if(value>=99 && value<=998){
                newId = "emp-0"+(Integer.parseInt(id.substring(5,id.length()))+1);
            }
            else if(value>=999 && value<=9998){
                newId = "emp-"+(Integer.parseInt(id.substring(4,id.length()))+1);
            }
            else{
                newId = null;
            }
            return newId;
            } catch (Exception e) {
                System.out.println("Error in Employee id");
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
        
        String generateLeaveID(){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT LeaveNo FROM leave_info ORDER BY LeaveNo DESC LIMIT 1";
            
            pst=con.prepareStatement(query);//making a prepared statement
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            String id = null;
            if(rs.next()){
                id = rs.getString(1);
            }
            
            String newId;
            Integer value;
            if(id==null){
                value=null;
            } else {
                value = Integer.parseInt(id.substring(4));
            }
            if(id==null){
                newId = "lev-001";
            }
            else if(value>=1 && value <=8){
                newId = "lev-00"+(Integer.parseInt(id.substring(6,id.length()))+1);
            }
            else if(value>=9 && value<=98){
                newId = "lev-0"+(Integer.parseInt(id.substring(5,id.length()))+1);
            }
            else if(value>=99 && value<=998){
                newId = "lev-"+(Integer.parseInt(id.substring(4,id.length()))+1);
            }
            else{
                newId = null;
            }
            return newId;
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
        
        String generateDepartmentID(){
            try {
            con=DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT DepartmentNo FROM department_info ORDER BY DepartmentNo DESC LIMIT 1";
            
            pst=con.prepareStatement(query);//making a prepare statement
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            String id = null;
            if(rs.next()){
                id = rs.getString(1);
            }
            
            String newId = null;
            Integer value;
            if(id==null){
                value=null;
            } else {
                value = Integer.parseInt(id.substring(4));
            }
            if(id==null){
                newId = "dep-01";
            }
            else if(value>=1 && value <=8){
                newId = "dep-0"+(Integer.parseInt(id.substring(5,id.length()))+1);
            }
            else if(value>=9 && value<=98){
                newId = "dep-"+(Integer.parseInt(id.substring(4,id.length()))+1);
            }
            else{
                newId = null;
            }
           // System.out.println(newId);
            return newId;
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
        
        boolean validateLogin (String employeeNo,String oldPassword, String newPassword){
        
         try{
            
          con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
          String query = "UPDATE employee_info SET Password='"+newPassword+"' WHERE EmployeeNo='"+employeeNo+"' && Password='"+oldPassword+"'";
          
          pst=con.prepareStatement(query);
          
          pst.executeUpdate();  
          
          return true;//the username and  and type provided doesn't exist in the database
          
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
        
    int getRemainingCasualLeaves(String empNo) {

        String count = null;
        //id.substring(4)
        String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()); //get current date from machine

        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));

        //   System.out.println(month);
        //   System.out.println(day);
        if (month == 1 && day == 1) {
            return 21;
        } else {

            try {
                con = DriverManager.getConnection(url, username, password);//get the connection
                String query = "SELECT COUNT(LeaveNo) FROM leave_info WHERE EmployeeNo='" + empNo + "' AND Type='Casual' AND Status!='Rejected'";

                pst = con.prepareStatement(query);//making a prepare statement
                rs = pst.executeQuery();

                //String count=null;
                if (rs.next()) {
                    count = rs.getString(1);
                }
                //  System.out.println(count);

            } catch (Exception e) {
                System.out.println("Exception throws " + e);
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

            return (21 - Integer.parseInt(count));
        }
    }
        
        int getRemainingMedicalLeaves(String empNo){
            
            String count = null;
            //id.substring(4)
            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()); //get current date from machine
            
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6));
            
            if(month == 1 && day == 1){
                return 24;
            } else {

            try {
                con = DriverManager.getConnection(url, username, password);//get the connection
                String query = "SELECT COUNT(LeaveNo) FROM leave_info WHERE EmployeeNo='" + empNo + "' AND Type='Medical' AND Status!='Rejected'";

                pst = con.prepareStatement(query);//making a prepare statement
                rs = pst.executeQuery();

                //String count=null;
                if (rs.next()) {
                    count = rs.getString(1);
                }
                //  System.out.println(count);

            } catch (Exception e) {
                System.out.println("Exception throws " + e);
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

            return (24 - Integer.parseInt(count));
        }
    }
        
        int getUsedMedicalLeaves(String empNo, String type){
            
            String count = null;
            //id.substring(4)
            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()); //get current date from machine
            
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6));
            
            if(month == 1 && day == 1){
                return 0;
            } else {

            try {
                con = DriverManager.getConnection(url, username, password);//get the connection
                String query = "SELECT COUNT(LeaveNo) FROM leave_info WHERE EmployeeNo='" + empNo + "' AND Type='"+type+"' AND Status='Accepted'";

                pst = con.prepareStatement(query);//making a prepare statement
                rs = pst.executeQuery();

                //String count=null;
                if (rs.next()) {
                    count = rs.getString(1);
                }
                //  System.out.println(count);

            } catch (Exception e) {
                System.out.println("Exception throws " + e);
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

            return (24 - Integer.parseInt(count));
        }
    }
        
        
}
