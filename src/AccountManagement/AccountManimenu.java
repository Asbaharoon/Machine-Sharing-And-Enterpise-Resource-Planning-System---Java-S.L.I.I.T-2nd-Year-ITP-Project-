/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagement;
import java.awt.Toolkit;
import mycodeAccount.AccountManagementDBconnect;
//import static AccountManagement.AccountManagementDBconnect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
import voguetexmachinesharing.managementsystem.*;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Naduni Samaranayke
 */
public class AccountManimenu extends javax.swing.JInternalFrame {

    /**
     * Creates new form AccountManimenu
     */
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs = null; // put results into table 
    
    public AccountManimenu() {
        
        
        
       // DefaultTableModel model;
        con= AccountManagementDBconnect.connect();
        initComponents();
        incometableload();//load the income table
        expensetableload();//lod the expense table
        budgettableload();
        budreturn();
        totexpensereturn();
        valuesreturn();
    }

  public void incometableload()
   {
   
       try{
           String sql1 = "SELECT Code,IncomeDate,Sales,totalExpense,Grossprofit,Interest,Netincome FROM income";
           pst = con.prepareStatement(sql1);
           rs = pst.executeQuery();
       
           incometable.setModel(DbUtils.resultSetToTableModel(rs));
       }catch (Exception e){
       }
   
   }
    
  public void expensetableload()
   {
   
       try{
           String sql1 = "SELECT Id,Date,productioncharges,salaries,travelling,repair,water,insurance,rent,electricity,security,communication,furniture,other FROM expenseactual";
           pst = con.prepareStatement(sql1);
           rs = pst.executeQuery();
       
           expensetable2.setModel(DbUtils.resultSetToTableModel(rs));
       }catch (Exception e){
       }
   
   }
  
  public void budgettableload(){
      
   try{
       String sql1 = "SELECT ID,Frombud,Tobud,budproductioncharges,budsalaries,budtravelling,budrepair,budwater,budelectricity,budinsurance,budrent,budsecurity,budcommunication,budfurniture,budother FROM expensebudget";
      
       pst = con.prepareStatement(sql1);
       rs = pst.executeQuery();
           
       budtable.setModel(DbUtils.resultSetToTableModel(rs));
       
      }
   catch (Exception e){
      
      }
  
  
  }
  
  public void budreturn(){
  //returns budget values from budget table
  try{
       String sql1 = "SELECT budproductioncharges,budsalaries,budtravelling,budrepair,budwater,budelectricity,budinsurance,budrent,budsecurity,budcommunication,budfurniture,budother FROM expensebudget";
      
      pst = con.prepareStatement(sql1);
      rs = pst.executeQuery();
      while(rs.next()){
       probud.setText(rs.getString("budproductioncharges"));
       salbud.setText(rs.getString("budsalaries"));
       trabud.setText(rs.getString("budtravelling"));
       repbud.setText(rs.getString("budrepair"));
       watbud.setText(rs.getString("budwater"));
       elebud.setText(rs.getString("budelectricity"));
       insbud.setText(rs.getString("budrent"));
       renbud.setText(rs.getString("budsecurity"));
       secbud.setText(rs.getString("budsecurity"));
       combud.setText(rs.getString("budcommunication"));
       furbud.setText(rs.getString("budfurniture"));
       otherbudt.setText(rs.getString("budother"));
      }
          
     //  budtable.setModel(DbUtils.resultSetToTableModel(rs));

  
  }catch(Exception e){}
  
}
  public void valuesreturn(){
  //returns  expenses from other tables
  try{
       String sql1 = "SELECT NetSalary FROM salary_info";
      
      pst = con.prepareStatement(sql1);
      rs = pst.executeQuery();
      while(rs.next()){
        salarytxt.setText(rs.getString("NetSalary"));
       
      }
       }catch(Exception e){}
  
} 
  
  public void totexpensereturn(){
  //returns total expense from expense table
  try{
       String sql1 = "SELECT totalexpense FROM expenseactual";
      
       pst = con.prepareStatement(sql1);
       rs = pst.executeQuery();
       while(rs.next()){
         totex.setText(rs.getString("totalexpense"));
       
      }
          
     //  budtable.setModel(DbUtils.resultSetToTableModel(rs));

  
  }catch(Exception e){
  
  }
  
} 
  
  
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        production1xt = new javax.swing.JTextField();
        salary1txt = new javax.swing.JTextField();
        travel1txt = new javax.swing.JTextField();
        repair1txt = new javax.swing.JTextField();
        water1txt = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        elect1xt = new javax.swing.JTextField();
        insu1txt = new javax.swing.JTextField();
        rent1txt = new javax.swing.JTextField();
        sec1txt = new javax.swing.JTextField();
        com1txt = new javax.swing.JTextField();
        fur1txt = new javax.swing.JTextField();
        other1txt = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        budtable = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        dateboxfrom = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        dateboxto = new com.toedter.calendar.JDateChooser();
        jSeparator12 = new javax.swing.JSeparator();
        lblb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        productiontxt = new javax.swing.JTextField();
        salarytxt = new javax.swing.JTextField();
        traveltxt = new javax.swing.JTextField();
        repairtxt = new javax.swing.JTextField();
        watertxt = new javax.swing.JTextField();
        electxt = new javax.swing.JTextField();
        insutxt = new javax.swing.JTextField();
        renttxt = new javax.swing.JTextField();
        sectxt = new javax.swing.JTextField();
        comtxt = new javax.swing.JTextField();
        furtxt = new javax.swing.JTextField();
        othertxt = new javax.swing.JTextField();
        probud = new javax.swing.JTextField();
        salbud = new javax.swing.JTextField();
        trabud = new javax.swing.JTextField();
        repbud = new javax.swing.JTextField();
        watbud = new javax.swing.JTextField();
        elebud = new javax.swing.JTextField();
        insbud = new javax.swing.JTextField();
        renbud = new javax.swing.JTextField();
        secbud = new javax.swing.JTextField();
        combud = new javax.swing.JTextField();
        furbud = new javax.swing.JTextField();
        otherbudt = new javax.swing.JTextField();
        d1 = new javax.swing.JTextField();
        d2 = new javax.swing.JTextField();
        d3 = new javax.swing.JTextField();
        d4 = new javax.swing.JTextField();
        d6 = new javax.swing.JTextField();
        d7 = new javax.swing.JTextField();
        d8 = new javax.swing.JTextField();
        d9 = new javax.swing.JTextField();
        d10 = new javax.swing.JTextField();
        d11 = new javax.swing.JTextField();
        d12 = new javax.swing.JTextField();
        d13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        tottxt = new javax.swing.JTextField();
        budtxt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        d14 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        expensetable2 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        datebox = new com.toedter.calendar.JDateChooser();
        idtxt = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lble = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        saletxt = new javax.swing.JTextField();
        grosstxt = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        intxt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        netincome = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        totex = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        incometable = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        Demo = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        datebox1 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setText("Communication");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel40.setText("Security");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jLabel41.setText("Rent");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel34.setText("Production Charges");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel35.setText("Salaries and related Charges");
        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel36.setText("Travelling and Subsistince");
        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel38.setText("Repair and maintainence");
        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel42.setText("Water");
        jPanel8.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel43.setText("Electricity");
        jPanel8.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel44.setText("Insurance");
        jPanel8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        production1xt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                production1xtActionPerformed(evt);
            }
        });
        production1xt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                production1xtKeyTyped(evt);
            }
        });
        jPanel8.add(production1xt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 90, -1));

        salary1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary1txtActionPerformed(evt);
            }
        });
        salary1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salary1txtKeyTyped(evt);
            }
        });
        jPanel8.add(salary1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 90, -1));

        travel1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                travel1txtActionPerformed(evt);
            }
        });
        travel1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                travel1txtKeyTyped(evt);
            }
        });
        jPanel8.add(travel1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 90, -1));

        repair1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repair1txtActionPerformed(evt);
            }
        });
        repair1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                repair1txtKeyTyped(evt);
            }
        });
        jPanel8.add(repair1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 90, -1));

        water1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                water1txtActionPerformed(evt);
            }
        });
        water1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                water1txtKeyTyped(evt);
            }
        });
        jPanel8.add(water1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 90, -1));

        jLabel45.setText("Furniture,Equipment and software");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel46.setText("Other");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        elect1xt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elect1xtActionPerformed(evt);
            }
        });
        elect1xt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                elect1xtKeyTyped(evt);
            }
        });
        jPanel8.add(elect1xt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 90, -1));

        insu1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                insu1txtKeyTyped(evt);
            }
        });
        jPanel8.add(insu1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 80, -1));

        rent1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rent1txtActionPerformed(evt);
            }
        });
        rent1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rent1txtKeyTyped(evt);
            }
        });
        jPanel8.add(rent1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 80, 30));

        sec1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sec1txtActionPerformed(evt);
            }
        });
        sec1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sec1txtKeyTyped(evt);
            }
        });
        jPanel8.add(sec1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 80, -1));

        com1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com1txtActionPerformed(evt);
            }
        });
        com1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                com1txtKeyTyped(evt);
            }
        });
        jPanel8.add(com1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 80, -1));

        fur1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fur1txtActionPerformed(evt);
            }
        });
        fur1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fur1txtKeyTyped(evt);
            }
        });
        jPanel8.add(fur1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 80, -1));

        other1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other1txtActionPerformed(evt);
            }
        });
        other1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                other1txtKeyTyped(evt);
            }
        });
        jPanel8.add(other1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 80, -1));

        jButton13.setText("Insert");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        budtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fromm", "To", "Production", "Salary", "Travelling", "Repair", "Depreciation", "Water", "Electricity", "Insurance", "Rent", "Security", "Communication", "Furniture", "Other", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, true, true, true, true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        budtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budtableMouseClicked(evt);
            }
        });
        budtable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                budtableCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                budtableInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(budtable);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 590, 160));

        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        jButton18.setText("Demo");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, -1));

        jLabel47.setText("Date");

        dateboxfrom.setDateFormatString("yyyy-MM-dd");

        jLabel50.setText("ID");

        jLabel51.setText("to");

        jLabel52.setText("From");

        dateboxto.setDateFormatString("yyyy-MM-dd");

        lblb.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateboxfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateboxto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(144, 144, 144)
                        .addComponent(jLabel50)
                        .addGap(37, 37, 37)
                        .addComponent(lblb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addGap(4, 4, 4)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(lblb)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateboxfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel52)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateboxto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Budget", jPanel1);

        jLabel1.setText("Date");

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Operating Expenses");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setText("Production Charges");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel5.setText("Salaries and related Charges");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel6.setText("Travelling and substince");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 138, -1));

        jLabel7.setText("Repair and maintainence");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 153, -1));

        jLabel9.setText("Water");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel10.setText("Electricity");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel11.setText("Insurance");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel12.setText("Rent");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel13.setText("Security");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel14.setText("Communication");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel15.setText("Actual");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel16.setText("Budget");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel17.setText("Difference");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jLabel18.setText("Non Operating Expenses");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel19.setText("Furniture,Equipment & software");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel20.setText("Other");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        productiontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productiontxtActionPerformed(evt);
            }
        });
        productiontxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productiontxtKeyTyped(evt);
            }
        });
        jPanel5.add(productiontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 70, -1));

        salarytxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarytxtKeyTyped(evt);
            }
        });
        jPanel5.add(salarytxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 70, -1));

        traveltxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                traveltxtKeyTyped(evt);
            }
        });
        jPanel5.add(traveltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 70, -1));

        repairtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                repairtxtKeyTyped(evt);
            }
        });
        jPanel5.add(repairtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 70, -1));

        watertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watertxtActionPerformed(evt);
            }
        });
        watertxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                watertxtKeyTyped(evt);
            }
        });
        jPanel5.add(watertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 70, -1));

        electxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                electxtKeyTyped(evt);
            }
        });
        jPanel5.add(electxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 70, -1));

        insutxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                insutxtKeyTyped(evt);
            }
        });
        jPanel5.add(insutxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 70, -1));

        renttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renttxtActionPerformed(evt);
            }
        });
        renttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                renttxtKeyTyped(evt);
            }
        });
        jPanel5.add(renttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 70, -1));

        sectxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sectxtKeyTyped(evt);
            }
        });
        jPanel5.add(sectxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 70, -1));

        comtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comtxtKeyTyped(evt);
            }
        });
        jPanel5.add(comtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 70, -1));

        furtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                furtxtKeyTyped(evt);
            }
        });
        jPanel5.add(furtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 70, -1));

        othertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othertxtActionPerformed(evt);
            }
        });
        othertxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                othertxtKeyTyped(evt);
            }
        });
        jPanel5.add(othertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 70, -1));

        probud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probudActionPerformed(evt);
            }
        });
        jPanel5.add(probud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 71, -1));
        jPanel5.add(salbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 71, -1));

        trabud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabudActionPerformed(evt);
            }
        });
        jPanel5.add(trabud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 71, -1));
        jPanel5.add(repbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 71, -1));

        watbud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watbudActionPerformed(evt);
            }
        });
        jPanel5.add(watbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 71, -1));
        jPanel5.add(elebud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 71, -1));
        jPanel5.add(insbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 71, -1));
        jPanel5.add(renbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 71, -1));

        secbud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secbudActionPerformed(evt);
            }
        });
        jPanel5.add(secbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 71, -1));
        jPanel5.add(combud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 71, -1));
        jPanel5.add(furbud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 71, -1));
        jPanel5.add(otherbudt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 71, -1));
        jPanel5.add(d1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 69, -1));
        jPanel5.add(d2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 69, -1));
        jPanel5.add(d3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 69, -1));
        jPanel5.add(d4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 69, -1));

        d6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d6ActionPerformed(evt);
            }
        });
        jPanel5.add(d6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 69, -1));
        jPanel5.add(d7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 69, -1));
        jPanel5.add(d8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 69, -1));
        jPanel5.add(d9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 69, -1));

        d10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d10ActionPerformed(evt);
            }
        });
        jPanel5.add(d10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 69, -1));
        jPanel5.add(d11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 69, -1));
        jPanel5.add(d12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 69, -1));

        d13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d13ActionPerformed(evt);
            }
        });
        jPanel5.add(d13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 69, -1));

        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jLabel21.setText("Total Expenses");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));
        jPanel5.add(tottxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 70, -1));
        jPanel5.add(budtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 71, -1));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 251, 10));

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jButton12.setText("Clear");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, -1));

        jButton5.setText("Insert");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));
        jPanel5.add(d14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 69, -1));
        jPanel5.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 10));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 10));

        expensetable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Production", "Salaries", "Travelling", "Repair", "Water", "Electricity", "Insurance", "Rent", "Security", "Communication", "Furniture", "Other"
            }
        ));
        expensetable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expensetable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(expensetable2);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 780, 100));

        jButton17.setText("Demo");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        datebox.setDateFormatString("yyyy-MM-dd");

        jLabel48.setText("ID");

        lble.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel48)
                        .addGap(31, 31, 31)
                        .addComponent(lble))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idtxt)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(lble)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(idtxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Expenses", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setText("Sales");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Gross profit");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        saletxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saletxtActionPerformed(evt);
            }
        });
        saletxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                saletxtKeyTyped(evt);
            }
        });
        jPanel6.add(saletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 144, -1));
        jPanel6.add(grosstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 144, -1));

        jLabel26.setText("Other Non Operating  Income");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel27.setText("Interest Received");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        intxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intxtActionPerformed(evt);
            }
        });
        intxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                intxtKeyTyped(evt);
            }
        });
        jPanel6.add(intxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 144, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Net Income");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 94, -1));
        jPanel6.add(netincome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 184, -1));

        jButton2.setText("Calculate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 417, 10));

        jLabel30.setText("Total  Expenses");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        totex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totexActionPerformed(evt);
            }
        });
        totex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totexKeyTyped(evt);
            }
        });
        jPanel6.add(totex, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 144, -1));
        jPanel6.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 144, -1));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 250, 190, 10));

        incometable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Date", "Sales", "Total Expense", "Grossprofit", "Interest", "NetIncome"
            }
        ));
        incometable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                incometableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(incometable);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 740, 241));

        jButton8.setText("Insert");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        label.setText("ID");
        jPanel6.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 40, -1));

        jButton15.setText("Clear");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        Demo.setText("Demo");
        Demo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemoActionPerformed(evt);
            }
        });
        jPanel6.add(Demo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        lbl.setText("ID");
        jPanel6.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 20, -1, -1));

        jLabel8.setText("Date");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 20, -1, -1));

        datebox1.setDateFormatString("yyyy-MM-dd");
        jPanel6.add(datebox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 20, 212, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Income", jPanel3);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel32.setText("Date");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Reports");

        jButton3.setText("Generate  Income Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generate Expenditure  Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(34, 34, 34)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton3)
                .addGap(35, 35, 35)
                .addComponent(jButton4)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(691, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saletxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saletxtActionPerformed
        //grab to below feild after pressing enter
       
    }//GEN-LAST:event_saletxtActionPerformed

    private void production1xtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_production1xtActionPerformed
        salary1txt.grabFocus();
    }//GEN-LAST:event_production1xtActionPerformed

    private void other1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other1txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other1txtActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        String stringg1="2016-01-01";
        SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
            //DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault());

       String datex = bdf.format(datebox.getDate());
       
        
        
        if((productiontxt.getText().equals("")|| salarytxt.getText().equals("")||traveltxt.getText().equals("")||repairtxt.getText().equals("")||watertxt.getText().equals("")||electxt.getText().equals("")||insutxt.getText().equals("")||renttxt.getText().equals("")||sectxt.getText().equals("")||comtxt.getText().equals("")||furtxt.getText().equals("")||othertxt.getText().equals(""))){
            JOptionPane.showMessageDialog(rootPane,"Fields are empty");
        }
        
        if(stringg1.compareTo(datex) > 0){
                JOptionPane.showMessageDialog(rootPane,"please enter a valid date");
            
        }
          
        else {
 
        double production =Double.parseDouble(productiontxt.getText());
        double salary = Double.parseDouble(salarytxt.getText());
        double travelling = Double.parseDouble(traveltxt.getText());
        double repair = Double.parseDouble(repairtxt.getText());
        double water =Double.parseDouble(watertxt.getText());
        double electricity = Double.parseDouble(electxt.getText());
        double insurance = Double.parseDouble(insutxt.getText());
        double rent =Double.parseDouble(renttxt.getText());
        double security = Double.parseDouble(sectxt.getText());
        double communication = Double.parseDouble(comtxt.getText());
        double furniture = Double.parseDouble(furtxt.getText());
        double other = Double.parseDouble(othertxt.getText());
        double totalex=Double.parseDouble(tottxt.getText());
        double totbudgt=Double.parseDouble(budtxt.getText());        
       // ((JTextField)datebox.getDateEditor().getUiComponent()).getText();
        
            try{
                String q = "INSERT INTO expenseactual (Date,productioncharges,salaries,travelling,repair,water,insurance,rent,electricity,security,communication,furniture,other,totalexpense,totalbudget)  values ('"+ datex +"', '"+ production +"', '"+ salary +"', '"+ travelling +"', '"+ repair +"','"+ water +"', '"+ insurance +"', '"+ rent +"', '"+ electricity +"', '"+ security +"', '"+ communication +"', '"+ furniture +"', '"+ other +"','"+ totalex +"','"+ totbudgt +"')";

        
                pst=con.prepareStatement(q);
                pst.execute();
                expensetableload();//load the expense table
            
                JOptionPane.showMessageDialog(rootPane, "successfully inserted");
            }
                catch( Exception e) {
                    
                    System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
         
    private void d13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d13ActionPerformed

    private void d10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d10ActionPerformed

    private void d6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d6ActionPerformed

    private void watbudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watbudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_watbudActionPerformed

    private void trabudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trabudActionPerformed

    private void probudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_probudActionPerformed

    private void othertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_othertxtActionPerformed

    private void renttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renttxtActionPerformed

    private void watertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_watertxtActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      //delete a record
        
        int x = JOptionPane.showConfirmDialog(null,"Do you want to delete ?");
        
        if (x==0)
        {
        
        String id=lble.getText();
        
        String sql="Delete from expenseactual where id = '"+ id +"'";
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            expensetableload();
            JOptionPane.showMessageDialog(rootPane, "successfully deleted");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         //update expense table
       
       int x = JOptionPane.showConfirmDialog(null, "Do you want to update?");
       
       //0=yes,1=no,2,cancel
       if (x==0)
       {
           
           SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
           
           String id=lble.getText();
           String date = bdf.format(datebox.getDate());
           double production =Double.parseDouble(productiontxt.getText());
           double salary = Double.parseDouble(salarytxt.getText());
           double travelling = Double.parseDouble(traveltxt.getText());
           double repair = Double.parseDouble(repairtxt.getText());
           double water = Double.parseDouble(watertxt.getText());
           double electricity =Double.parseDouble(electxt.getText());
           double insurance = Double.parseDouble(insutxt.getText());
           double rent= Double.parseDouble(renttxt.getText());
           double security=Double.parseDouble(sectxt.getText());
           double communi=Double.parseDouble(comtxt.getText());
           double furniture =Double.parseDouble(furtxt.getText());
           double other=Double.parseDouble(othertxt.getText());
           
           String sql="UPDATE expenseactual SET Date='"+ date +"',productioncharges='"+ production +"',salaries='"+ salary +"',travelling='"+ travelling +"',repair='"+ repair +"',water='"+ water +"',insurance='"+ insurance +"',rent='"+ rent +"',electricity='"+ electricity +"',security='"+ security +"',communication='"+ communi +"',furniture='"+ furniture +"',other='"+ other +"' where id= '"+ id +"'";
          
           try{
           
           pst = con.prepareStatement(sql);
           pst.execute();
           expensetableload();
           
           }catch(Exception e){
           
           }
      
       }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       //insert values into budget 
       SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        
        String stringg1="2016-01-01";
       // String idd2 = (budidd.getText());  
        String datefrom = bdf.format(dateboxfrom.getDate());
        String dateto =bdf.format(dateboxto.getDate());
        //String production1=production1xt.getText();
       if(dateboxfrom.getDate().equals("")||dateboxto.getDate().equals("")||production1xt.getText().equals("")|| salary1txt.getText().equals("")||travel1txt.getText().equals("")||repair1txt.getText().equals("")||water1txt.getText().equals("")||elect1xt.getText().equals("")||insu1txt.getText().equals("")||rent1txt.getText().equals("")||sec1txt.getText().equals("")||com1txt.getText().equals("")||fur1txt.getText().equals("")||other1txt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Fields are empty");
        }
       
       if((dateboxfrom.getCalendar().getTime().after(dateboxto.getCalendar().getTime()))||((stringg1.compareTo(datefrom) > 0)||(stringg1.compareTo(dateto) > 0))){
           JOptionPane.showMessageDialog(rootPane,"Invalid  date");
       }
       
       else{
        {
        // String idd2 = (budidd.getText());  
        //String production1=production1xt.getText();
        double production1 = Double.parseDouble(production1xt.getText());
        double salary1 = Double.parseDouble(salary1txt.getText());
        double travelling1 = Double.parseDouble(travel1txt.getText());
        double repair1 = Double.parseDouble(repair1txt.getText());
        double water1 = Double.parseDouble(water1txt.getText());
        double electricity1 = Double.parseDouble(elect1xt.getText());
        double insurance1 = Double.parseDouble(insu1txt.getText());
        double rent1 = Double.parseDouble(rent1txt.getText());
        double security1 = Double.parseDouble(sec1txt.getText());
        double communication1 = Double.parseDouble(com1txt.getText());
        double furniture1 = Double.parseDouble(fur1txt.getText());
        double other1 = Double.parseDouble(other1txt.getText());
        
      
        
        String q = "INSERT INTO expensebudget(Frombud,Tobud,budproductioncharges,budsalaries,budtravelling,budrepair,budwater,budelectricity,budinsurance,budrent,budsecurity,budcommunication,budfurniture,budother)values ('"+ datefrom +"','"+ dateto +"','"+ production1 +"', '"+ salary1 +"', '"+ travelling1 +"', '"+ repair1 +"','"+ water1 +"', '"+ insurance1 +"', '"+ rent1 +"', '"+ electricity1 +"', '"+ security1 +"', '"+ communication1 +"', '"+ furniture1 +"','"+ other1 +"')";
  
        try{
    
            
            pst=con.prepareStatement(q);
            pst.execute();
            budgettableload();
            budreturn();

            JOptionPane.showMessageDialog(rootPane, "successfully inserted");
        
        }catch( Exception e) { 
            System.out.println("Exception Thorw"+e);
        }
    }//GEN-LAST:event_jButton13ActionPerformed
    }
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        //clear budget tabe
        
         lblb.setText("");
         ((JTextField)dateboxfrom.getDateEditor().getUiComponent()).setText("");
         ((JTextField)dateboxto.getDateEditor().getUiComponent()).setText("");
         production1xt.setText("");
         salary1txt.setText("");
         travel1txt.setText("");
         repair1txt.setText("");
         water1txt.setText("");
         elect1xt.setText("");
         insu1txt.setText("");
         rent1txt.setText("");
         sec1txt.setText("");
         com1txt.setText("");
         fur1txt.setText("");
         other1txt.setText("");
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void production1xtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_production1xtKeyTyped
        // validate for not entering string values to txt fields
        try{
         
            char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
                
        
        }catch(Exception e){
        
        }
         
        
    }//GEN-LAST:event_production1xtKeyTyped

    private void salary1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salary1txtKeyTyped
       // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_salary1txtKeyTyped

    private void travel1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_travel1txtKeyTyped
        // validate for not entering string values to txt fields
        try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
         
        
    }//GEN-LAST:event_travel1txtKeyTyped

    private void repair1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repair1txtKeyTyped
         // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_repair1txtKeyTyped

    private void water1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_water1txtKeyTyped
         // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_water1txtKeyTyped

    private void elect1xtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_elect1xtKeyTyped
         // validate for not entering string values to txt fields
      try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_elect1xtKeyTyped

    private void insu1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insu1txtKeyTyped
         // validate for not entering string values to txt fields
        try{
            char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep(); 
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_insu1txtKeyTyped

    private void rent1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rent1txtKeyTyped
         // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_rent1txtKeyTyped

    private void sec1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sec1txtKeyTyped
        // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_sec1txtKeyTyped

    private void com1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_com1txtKeyTyped
        // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_com1txtKeyTyped

    private void fur1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fur1txtKeyTyped
         // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_fur1txtKeyTyped

    private void other1txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_other1txtKeyTyped
        // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_other1txtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //calculate total expense
        try{
        double production =Double.parseDouble(productiontxt.getText());
        double salary = Double.parseDouble(salarytxt.getText());
        double travelling = Double.parseDouble(traveltxt.getText());
        double repair = Double.parseDouble(repairtxt.getText());
        double water =Double.parseDouble(watertxt.getText());
        double electricity = Double.parseDouble(electxt.getText());
        double insurance = Double.parseDouble(insutxt.getText());
        double rent =Double.parseDouble(renttxt.getText());
        double security = Double.parseDouble(sectxt.getText());
        double communication = Double.parseDouble(comtxt.getText());
        double furniture = Double.parseDouble(furtxt.getText());
        double other = Double.parseDouble(othertxt.getText());
        
       
        
        
        double tot=(production+salary+travelling+repair+water+electricity+insurance+rent+security+communication+furniture+other);
      tottxt.setText(Double.toString(tot));
       //DecimalFormat dc=new DecimalFormat("#.##");
        //tottxt.setText(dc.format(tot));
        
        
       //calculate total budget
       double productionbud =Double.parseDouble(probud.getText());
        double salarybud = Double.parseDouble(salbud.getText());
        double travellingbud = Double.parseDouble(trabud.getText());
        double repairbud = Double.parseDouble(repbud.getText());
        double waterbud =Double.parseDouble(watbud.getText());
        double electricitybud = Double.parseDouble(elebud.getText());
        double insurancebud = Double.parseDouble(insbud.getText());
        double rentbud =Double.parseDouble(renbud.getText());
        double securitybud = Double.parseDouble(secbud.getText());
        double communicationbud = Double.parseDouble(combud.getText());
        double furniturebud = Double.parseDouble(furbud.getText());
        double otherbud = Double.parseDouble(otherbudt.getText());
        
        
        double totbud=(productionbud+salarybud+travellingbud+repairbud+waterbud+electricitybud+insurancebud+rentbud+securitybud+communicationbud+furniturebud+otherbud);
       budtxt.setText(Double.toString(totbud));
       
       //calculate the diffrence row
       double diffpro = (production-productionbud);
       d1.setText(Double.toString(diffpro));
       
       double diffsal = (salary-salarybud);
       d2.setText(Double.toString(diffsal));
       
       double difftrav = (travelling-travellingbud);
       d3.setText(Double.toString(difftrav));
       
       double difftrep = (repair-repairbud);
       d4.setText(Double.toString(difftrep));
       
       
       double diffwater = (water-waterbud);
       d6.setText(Double.toString(diffwater));
       
       double diffele = (electricity-electricitybud);
       d7.setText(Double.toString(diffele));
       
       double diffinsu = (insurance-insurancebud);
       d8.setText(Double.toString(diffinsu));
       
       double diffrent = (rent-rentbud);
       d9.setText(Double.toString(diffrent));
       
       double diffsecu= (security-securitybud);
       d10.setText(Double.toString(diffsecu));
       
       double diffcommu = (communication-communicationbud);
       d11.setText(Double.toString(diffcommu));
       
       double difffur = (furniture-furniturebud);
       d12.setText(Double.toString(difffur));
       
       double diffother = (other-otherbud);
       d13.setText(Double.toString(diffother));
       
       //calculate total difference
       double totaldiff=(diffpro+diffsal+difftrav+difftrep+diffwater+diffele+diffinsu+diffrent+diffsecu+diffcommu+difffur+diffother);
       d14.setText(Double.toString(totaldiff));
       
       
        
        }catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void expensetable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensetable2MouseClicked
        // select items from table when mouse points
        int r= expensetable2.getSelectedRow();
        
        String id2=expensetable2.getValueAt(r, 0).toString();
        String dat=expensetable2.getValueAt(r, 1).toString();
        String prod=expensetable2.getValueAt(r, 2).toString();
        String sal=expensetable2.getValueAt(r, 3).toString();
        String tra=expensetable2.getValueAt(r, 4).toString();
        String rep=expensetable2.getValueAt(r, 5).toString();   
        String wat=expensetable2.getValueAt(r, 6).toString();
        String ele=expensetable2.getValueAt(r, 7).toString();
        String ins=expensetable2.getValueAt(r, 8).toString();
        String ren=expensetable2.getValueAt(r, 9).toString();
        String secu=expensetable2.getValueAt(r, 10).toString();
        String comm=expensetable2.getValueAt(r, 11).toString();
        String fur=expensetable2.getValueAt(r, 12).toString();
        String ot=expensetable2.getValueAt(r, 13).toString();
        
        lble.setText(id2);
        ((JTextField)datebox.getDateEditor().getUiComponent()).setText(dat);
        productiontxt.setText(prod);
        salarytxt.setText(sal);
       traveltxt.setText(tra);
        repairtxt.setText(rep);
        watertxt.setText(wat);
        electxt.setText(ele);
       insutxt.setText(ins);
        renttxt.setText(ren);
        sectxt.setText(secu);
        comtxt.setText(comm);
        furtxt.setText(fur);
        othertxt.setText(ot);
    }//GEN-LAST:event_expensetable2MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //clear the text feilds
        
         lble.setText("");
         ((JTextField)datebox.getDateEditor().getUiComponent()).setText("");
         productiontxt.setText("");
         salarytxt.setText("");
         traveltxt.setText("");
         repairtxt.setText("");
         watertxt.setText("");
         electxt.setText("");
         insutxt.setText("");
         renttxt.setText("");
         sectxt.setText("");
         comtxt.setText("");
         furtxt.setText("");
         othertxt.setText("");
         tottxt.setText("");
         
         probud.setText("");
         salbud.setText("");
         trabud.setText("");
         repbud.setText("");
         watbud.setText("");
         elebud.setText("");
         insbud.setText("");
         renbud.setText("");
         secbud.setText("");
         combud.setText("");
         furbud.setText("");
         otherbudt.setText("");
         budtxt.setText("");
        
         d1.setText("");
         d2.setText("");
         d3.setText("");
         d4.setText("");
       //  d5.setText("");
         d6.setText("");
         d7.setText("");
         d8.setText("");
         d9.setText("");
         d10.setText("");
         d11.setText("");
         d12.setText("");
         d13.setText("");
         d14.setText("");
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       //insert vales into income table
     
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd" );
        String string1="2016-01-01";
        SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
            //DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault());

  
            
       String exdat = bdf.format(datebox1.getDate());
        System.out.println(exdat);
       
        
       if(saletxt.getText().equals("")||intxt.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane,"Fields are empty");
        }
     
       if (((JTextField)datebox1.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Date should be filled");
        }
       if (string1.compareTo(exdat)>0) {
                JOptionPane.showMessageDialog(rootPane,"please enter a valid date");
            
        }
      
       
       else {
           
          // String string1="2016-01-31";
           
        
      // SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
            //DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault());

  
            
       //String exdat = bdf.format(incodatebox.getDate());
       
        //String exdat =bdf.format(incodatebox.getCalendar().getTime());
        double sales = Double.parseDouble(saletxt.getText());
        double totalEx = Double.parseDouble(totex.getText());
        double grosspr = Double.parseDouble(grosstxt.getText());
        double interest = Double.parseDouble(intxt.getText());
        double netin = Double.parseDouble(netincome.getText());
        
           
           
        
      
       try{ 
           //System.out.println("sss " + exdat);
        String q = "INSERT INTO income (Incomedate,Sales,totalExpense,Grossprofit,Interest,Netincome)  values ('"+exdat+"', "+ sales +", "+ totalEx +", "+ grosspr +","+ interest +","+ netin +")";
          // System.out.println("date : " + q);
        
            pst=con.prepareStatement(q);
            pst.execute();
            incometableload();

       JOptionPane.showMessageDialog(rootPane, "successfully inserted");
        
        }catch( Exception e) { 
            
            System.out.println(e);
        }
                                          
   
       }
         
    }//GEN-LAST:event_jButton8ActionPerformed

    private void incometableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incometableMouseClicked
        // show income table text feilds when mouse clicked
        
        int r=incometable.getSelectedRow();
        
        String numin=incometable.getValueAt(r, 0).toString();
        String dateinc=incometable.getValueAt(r, 1).toString();
        String salein=incometable.getValueAt(r, 2).toString();
        String totexp=incometable.getValueAt(r, 3).toString();
        String gross=incometable.getValueAt(r, 4).toString();
        String interin=incometable.getValueAt(r, 5).toString();
        String netinc=incometable.getValueAt(r, 6).toString();
        
        lbl.setText(numin);
        ((JTextField)datebox1.getDateEditor().getUiComponent()).setText(dateinc);
        saletxt.setText(salein);
        totex.setText(totexp);
        grosstxt.setText(gross);
        intxt.setText(interin);
        netincome.setText(netinc);
       
       
    }//GEN-LAST:event_incometableMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // update income table :
        
         int x = JOptionPane.showConfirmDialog(null, "Do you want to update?");
       
       //0=yes,1=no,2,cancel
       if (x==0)
       {
       
            SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
           
           String num1=lbl.getText();
           String date1 = bdf.format(datebox1.getDate());
          // System.out.println("up : " + date1);
           double sale1 =Double.parseDouble(saletxt.getText());
           double interest1 = Double.parseDouble(intxt.getText());

           
           
           String sql="UPDATE income SET Sales='"+ sale1 +"',Incomedate='"+ date1 +"',Interest='"+ interest1 +"' where Code='"+ num1 +"'";
           System.out.println("sql up : " + sql);
           try{
           
           pst = con.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(rootPane, "successfully updated");
           incometableload();
           
           }catch(Exception e){
           //JOptionPane.showMessageDialog(rootPane, " not successfull");
           }
      
       }
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //delete a record
        
        int x = JOptionPane.showConfirmDialog(null,"Do you want to delete ?");
        
        if (x==0)
        {
        
        String numb=lbl.getText();
        
        String sql="Delete from income where Code = '"+ numb +"'";
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            incometableload();
        }catch(Exception e){
            System.out.println(e);
        
        }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // clear the income table:
        
         lbl.setText("");
         saletxt.setText("");
         totex.setText("");
         grosstxt.setText("");
         intxt.setText("");
         netincome.setText("");
         ((JTextField)datebox1.getDateEditor().getUiComponent()).setText("");
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void productiontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productiontxtActionPerformed
        salarytxt.grabFocus();//enters to below text
    }//GEN-LAST:event_productiontxtActionPerformed

    private void productiontxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productiontxtKeyTyped
        // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_productiontxtKeyTyped

    private void saletxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saletxtKeyTyped
        // validate for not entering string values to txt fields
       try{
          char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_saletxtKeyTyped

    private void totexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totexKeyTyped
       // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_totexKeyTyped

    private void intxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_intxtKeyTyped
       // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_intxtKeyTyped

    private void salarytxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarytxtKeyTyped
       // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_salarytxtKeyTyped

    private void traveltxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_traveltxtKeyTyped
        // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_traveltxtKeyTyped

    private void repairtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repairtxtKeyTyped
        // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_repairtxtKeyTyped

    private void watertxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_watertxtKeyTyped
       // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_watertxtKeyTyped

    private void electxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_electxtKeyTyped
        // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_electxtKeyTyped

    private void insutxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insutxtKeyTyped
        // validate for not entering string values to txt fields
        try{
         char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_insutxtKeyTyped

    private void renttxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_renttxtKeyTyped
        // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_renttxtKeyTyped

    private void sectxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sectxtKeyTyped
        // validate for not entering string values to txt fields
       try{
        char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_sectxtKeyTyped

    private void comtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comtxtKeyTyped
        // validate for not entering string values to txt fields
       try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_comtxtKeyTyped

    private void furtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_furtxtKeyTyped
        // validate for not entering string values to txt fields
       try{
         char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_furtxtKeyTyped

    private void othertxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_othertxtKeyTyped
         // validate for not entering string values to txt fields
        try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_othertxtKeyTyped

    private void budtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budtableMouseClicked
         // select items from table when mouse points
        int r= budtable.getSelectedRow();
       
        String id22=budtable.getValueAt(r, 0).toString();
        String datefrm1=budtable.getValueAt(r, 1).toString();
        String dateto1=budtable.getValueAt(r, 2).toString();
        String prodbud1=budtable.getValueAt(r, 3).toString();
        String salbud1=budtable.getValueAt(r, 4).toString();
        String trabud1=budtable.getValueAt(r, 5).toString();
        String repbud1=budtable.getValueAt(r, 6).toString();
        String watbud1=budtable.getValueAt(r, 7).toString();
        String elebud1=budtable.getValueAt(r, 8).toString();
        String insbud1=budtable.getValueAt(r, 9).toString();
        String renbud1=budtable.getValueAt(r, 10).toString();
        String secubud1=budtable.getValueAt(r, 11).toString();
        String commbud1=budtable.getValueAt(r, 12).toString();
        String furbud1=budtable.getValueAt(r, 13).toString();
        String otbud1=budtable.getValueAt(r, 14).toString();
        
        
        lblb.setText(id22);
        ((JTextField)dateboxfrom.getDateEditor().getUiComponent()).setText(datefrm1);
        ((JTextField)dateboxto.getDateEditor().getUiComponent()).setText(dateto1);
        production1xt.setText(prodbud1);
       salary1txt.setText(salbud1);
       travel1txt.setText(trabud1);
        repair1txt.setText(repbud1);
        water1txt.setText(watbud1);
        elect1xt.setText(elebud1);
       insu1txt.setText(insbud1);
        rent1txt.setText(renbud1);
        sec1txt.setText(secubud1);
        com1txt.setText(commbud1);
        fur1txt.setText(furbud1);
        other1txt.setText(otbud1);
        
        
    }//GEN-LAST:event_budtableMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void budtableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_budtableCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_budtableCaretPositionChanged

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
     
           //update budget table
        
       int x = JOptionPane.showConfirmDialog(null, "Do you want to update?");
       
       //0=yes,1=no,2,cancel
       if (x==0)
       {
           SimpleDateFormat bdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
           
           String idb=lblb.getText();
           String datefromb = bdf.format(dateboxfrom.getDate());
           String datetob =bdf.format(dateboxto.getDate());
           double productionb =Double.parseDouble(production1xt.getText());
           double salaryb = Double.parseDouble(salary1txt.getText());
           double travellingb = Double.parseDouble(travel1txt.getText());
           double repairb = Double.parseDouble(repair1txt.getText());
           double waterb = Double.parseDouble(water1txt.getText());
           double electricityb =Double.parseDouble(elect1xt.getText());
           double insuranceb = Double.parseDouble(insu1txt.getText());
           double rentb= Double.parseDouble(rent1txt.getText());
           double securityb=Double.parseDouble(sec1txt.getText());
           double communib=Double.parseDouble(com1txt.getText());
           double furnitureb =Double.parseDouble(fur1txt.getText());
           double otherb=Double.parseDouble(other1txt.getText());
           
           String sql="UPDATE expensebudget SET Frombud='"+ datefromb +"',Tobud='"+ datetob +"',budproductioncharges='"+ productionb +"',budsalaries='"+ salaryb +"',budtravelling='"+ travellingb +"',budrepair='"+ repairb +"',budwater='"+ waterb +"',budelectricity='"+ electricityb +"',budinsurance='"+ insuranceb +"',budrent='"+ rentb +"',budsecurity='"+ securityb +"',budcommunication='"+ communib +"',budfurniture='"+ furnitureb +"',budother='"+ otherb +"' where ID = '"+ idb +"' ";
          
           try{
           
           pst = con.prepareStatement(sql);
           pst.execute();
           budgettableload();
           
           }catch(Exception e){
              System.out.println("Exception Thorw"+e); 
           
           }
      
       }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void budtableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_budtableInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_budtableInputMethodTextChanged

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         //delete a record
        
        int x = JOptionPane.showConfirmDialog(null,"Do you want to delete ?");
        
        if (x==0)
        {
        
        String numb=lblb.getText();
        
        String sql="Delete from expensebudget where ID = '"+ numb +"'";
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            budgettableload();
        }catch(Exception e){
        
        }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // calculate income
        
         try{
        double sale1 =Double.parseDouble(saletxt.getText());
        double tot1expen=Double.parseDouble(totex.getText());
        
        double gross=(sale1-tot1expen);
        grosstxt.setText(Double.toString(gross));
        
        double gross1 =Double.parseDouble(grosstxt.getText());
        
        
        double interest =Double.parseDouble(intxt.getText());
        
   
        double netincome1=(gross1+interest);
        netincome.setText(Double.toString(netincome1));
 
         }catch(Exception e){
             System.out.println(e);
         
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salary1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary1txtActionPerformed
        //grab to below text after pressing enter
        travel1txt.grabFocus();
    }//GEN-LAST:event_salary1txtActionPerformed

    private void travel1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_travel1txtActionPerformed
        //grab to below text after pressing enter
        repair1txt.grabFocus();
    }//GEN-LAST:event_travel1txtActionPerformed

    private void repair1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repair1txtActionPerformed
        //grab to below text after pressing enter
        
    }//GEN-LAST:event_repair1txtActionPerformed

    private void elect1xtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elect1xtActionPerformed
        //grab to below text after pressing enter
        insu1txt.grabFocus();
    }//GEN-LAST:event_elect1xtActionPerformed

    private void rent1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rent1txtActionPerformed
       //grab to below text after pressing enter
        sec1txt.grabFocus();
    }//GEN-LAST:event_rent1txtActionPerformed

    private void sec1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sec1txtActionPerformed
       //grab to below text after pressing enter
        com1txt.grabFocus();
    }//GEN-LAST:event_sec1txtActionPerformed

    private void com1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com1txtActionPerformed
        //grab to below text after pressing enter
        fur1txt.grabFocus();
    }//GEN-LAST:event_com1txtActionPerformed

    private void fur1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fur1txtActionPerformed
       //grab to below text after pressing enter
        other1txt.grabFocus();
    }//GEN-LAST:event_fur1txtActionPerformed

    private void totexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totexActionPerformed
       //grab to below text after pressing enter
        intxt.grabFocus();
    }//GEN-LAST:event_totexActionPerformed

    private void intxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intxtActionPerformed
         //grab to below text after pressing enter
    }//GEN-LAST:event_intxtActionPerformed

    private void water1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_water1txtActionPerformed
        //grab to below text after pressing enter
        elect1xt.grabFocus();
    }//GEN-LAST:event_water1txtActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        //demo button
        
        
         //iddtxt.setText("1");
         productiontxt.setText("100000.00");
         //salarytxt.setText("10000.00");
         traveltxt.setText("100000.00");
         repairtxt.setText("10000.00");
         watertxt.setText("10000.00");
         electxt.setText("12395.00");
         insutxt.setText("15678.00");
         renttxt.setText("45789.00");
         sectxt.setText("10569.00");
         comtxt.setText("15908.00");
         furtxt.setText("12967.00");
         othertxt.setText("12890.00");
         
    }//GEN-LAST:event_jButton17ActionPerformed

    private void DemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemoActionPerformed
        //demo income table
        
         // datebox1.setDate("2016-09-30");
        
         ((JTextField)datebox1.getDateEditor().getUiComponent()).setText("2016-09-30");
         saletxt.setText("1000000.00");
         intxt.setText("10000.00");
         

    }//GEN-LAST:event_DemoActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // demo budget table
         //budidd.setText("1");
         production1xt.setText("20000.00");
         salary1txt.setText("15500.00");
         travel1txt.setText("15500.00");
         repair1txt.setText("2000.00");
         water1txt.setText("5500.00");
         elect1xt.setText("8200.00");
         insu1txt.setText("5000.00");
         rent1txt.setText("1400.00");
         sec1txt.setText("5000.00");
         com1txt.setText("5000.00");
         fur1txt.setText("5000.00");
         other1txt.setText("14500.00");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void secbudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secbudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secbudActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
            //generate income report
          
           try{
              
            String report="C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\AccountModule\\report3.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr ,null,con);
            JasperViewer.viewReport(jp,false);
        }
        catch(Exception e){
            System.out.println(e);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //generate expense report
        try{
              
            String report="C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\AccountModule\\report1.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr ,null,con);
            JasperViewer.viewReport(jp,false);
        }
        catch(Exception e){
            System.out.println(e);
            }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Demo;
    private javax.swing.JTable budtable;
    private javax.swing.JTextField budtxt;
    private javax.swing.JTextField com1txt;
    private javax.swing.JTextField combud;
    private javax.swing.JTextField comtxt;
    private javax.swing.JTextField d1;
    private javax.swing.JTextField d10;
    private javax.swing.JTextField d11;
    private javax.swing.JTextField d12;
    private javax.swing.JTextField d13;
    private javax.swing.JTextField d14;
    private javax.swing.JTextField d2;
    private javax.swing.JTextField d3;
    private javax.swing.JTextField d4;
    private javax.swing.JTextField d6;
    private javax.swing.JTextField d7;
    private javax.swing.JTextField d8;
    private javax.swing.JTextField d9;
    private com.toedter.calendar.JDateChooser datebox;
    private com.toedter.calendar.JDateChooser datebox1;
    private com.toedter.calendar.JDateChooser dateboxfrom;
    private com.toedter.calendar.JDateChooser dateboxto;
    private javax.swing.JTextField elebud;
    private javax.swing.JTextField elect1xt;
    private javax.swing.JTextField electxt;
    private javax.swing.JTable expensetable2;
    private javax.swing.JTextField fur1txt;
    private javax.swing.JTextField furbud;
    private javax.swing.JTextField furtxt;
    private javax.swing.JTextField grosstxt;
    private javax.swing.JLabel idtxt;
    private javax.swing.JTable incometable;
    private javax.swing.JTextField insbud;
    private javax.swing.JTextField insu1txt;
    private javax.swing.JTextField insutxt;
    private javax.swing.JTextField intxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblb;
    private javax.swing.JLabel lble;
    private javax.swing.JTextField netincome;
    private javax.swing.JTextField other1txt;
    private javax.swing.JTextField otherbudt;
    private javax.swing.JTextField othertxt;
    private javax.swing.JTextField probud;
    private javax.swing.JTextField production1xt;
    private javax.swing.JTextField productiontxt;
    private javax.swing.JTextField renbud;
    private javax.swing.JTextField rent1txt;
    private javax.swing.JTextField renttxt;
    private javax.swing.JTextField repair1txt;
    private javax.swing.JTextField repairtxt;
    private javax.swing.JTextField repbud;
    private javax.swing.JTextField salary1txt;
    private javax.swing.JTextField salarytxt;
    private javax.swing.JTextField salbud;
    private javax.swing.JTextField saletxt;
    private javax.swing.JTextField sec1txt;
    private javax.swing.JTextField secbud;
    private javax.swing.JTextField sectxt;
    private javax.swing.JTextField totex;
    private javax.swing.JTextField tottxt;
    private javax.swing.JTextField trabud;
    private javax.swing.JTextField travel1txt;
    private javax.swing.JTextField traveltxt;
    private javax.swing.JTextField watbud;
    private javax.swing.JTextField water1txt;
    private javax.swing.JTextField watertxt;
    // End of variables declaration//GEN-END:variables
}
