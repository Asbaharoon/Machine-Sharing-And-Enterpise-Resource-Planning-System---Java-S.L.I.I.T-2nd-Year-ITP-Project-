/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

public class MyReportViewer extends JFrame {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/VogueTexSystemDatabase";
    String username = "root";
    String password = "";
    Connection con = null;

    public MyReportViewer(String fileName) {
        this(fileName, null);
    }

    public MyReportViewer(String fileName, HashMap parameter) {
        super("View Report");
        try {
            DBConnectMaintenance dbOps=new DBConnectMaintenance();
            /* load the required JDBC driver and create the connection
here JDBC-ODBC Bridge Driver is used*/
           Class.forName(driver);
           Connection con = DriverManager.getConnection(url,username,password);
          //Connection con =dbOps.getReport();
//Way 1
/*JasperDesign jasperDesign = JasperManager.loadXmlDesign(fileName);
JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, con);*/
//Way 2
/*JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, con);*/

 /*Way 3 (Here the parameter file should be in .jasper extension i.e., the compiled report)*/
            JasperPrint print = JasperFillManager.fillReport(fileName, parameter, con);

            JRViewer viewer = new JRViewer(print);

            Container c = getContentPane();
            c.add(viewer);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (JRException jre) {
            jre.printStackTrace();
        }

        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String args[]) {
        /* A sample calling */
 /*HashMap param=new HashMap();
param.put("reportParameterName",valueForTheParameter);
MyReportViewer viewer=new MyReportViewer("Report File Name With Extension",param);
viewer.setVisible(true);*/
    }
}
