/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import static EmployeeManagement.ValidationEmployeeManagement.checkNIC;
import static EmployeeManagement.ValidationEmployeeManagement.checkPhone;
import static EmployeeManagement.ValidationEmployeeManagement.chkEpf;
import static EmployeeManagement.ValidationEmployeeManagement.isValidEmailAddress;
import com.mysql.jdbc.StringUtils;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import voguetexmachinesharing.managementsystem.DBConnect;
import voguetexmachinesharing.managementsystem.MyReportViewer;

/**
 *
 * @author isuru
 */
public class EmployeeInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Employee
     * 
     */
    
   // private String gender=null;
   // private String empType=null;
   // private String ot=null;
   // private String epf=null;
   // private String etf=null;
    
    private ImageIcon format;
   // String filename = null;
   // int s=0;
    byte[] person_image=null;
    
   // DBConnectEmployeeManagement dbcEmp = new DBConnectEmployeeManagement();
    ArrayList<Employee> employeeList ;
    Employee emp =new Employee();
    ArrayList<Leave> leaveList;
    ArrayList<Leave> specificLeaveList;
    ArrayList<Leave> specificLeave;
    ArrayList<Department> departmentList;
    ArrayList<Attendance> attendanceList;
    ArrayList<Salary> salaryList;
    Leave lev = new Leave();
    Leave le = new Leave();
    Department dept = new Department();
    DBConnectEmployeeManagement dbCon = new DBConnectEmployeeManagement();
    DBConnect dbConn = new DBConnect();
    ValidationEmployeeManagement validation = new ValidationEmployeeManagement();
    Salary salaryObj = new Salary();
    
    
    public EmployeeInfo(Employee emp) {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //remove title bar from internal frame
        initComponents();
        populateEmployeeTable();
      //  clearFieldsEmployee();
      //  clearFieldsRequetLeave();
        populateApproveLeaveTable();
        populateDepartment();
        txtEmployeeNoRL.setText(emp.getEmpNo());
        txtDepartmentNoRL.setText(emp.getDepartment());
        populateLeaveHistoryTable();
     //   clearFieldsDepartment();
        populateCmbDepartment();
        setLeaves(emp);
        populateAttendanceTable();
        populateSalaryTable();
      //  loadUser();
      //  DBConnect dbs=new DBConnect();
      //  Employee logEmp=dbConn.loadUser(dbConn.userID);
     //   txtEmployeeNoRL.setText(logEmp.getEmpNo());
        txtArReasonRL.setText("Personal");
       // dbCon.getEmployeeSalary(emp.getEmpNo(), "September");
        
        
        if(dbCon.generateEmployeeID().equals(null)){
            JOptionPane.showMessageDialog(this, "Cannot generate unique Employee No !!!");
        } else {
               txtEmployeeNo.setText(dbCon.generateEmployeeID());  
        }
        if(dbCon.generateLeaveID().equals(null)){
            JOptionPane.showMessageDialog(this, "Cannot generate unique Leave No !!!");
        } else {
               txtLeaveNo.setText(dbCon.generateLeaveID());  
        }
        if(dbCon.generateDepartmentID().equals(null)){
            JOptionPane.showMessageDialog(this, "Cannot generate unique Department No !!!");
        } else {
            txtDepartmentNo.setText(dbCon.generateDepartmentID());
        }
    }
    
    void populateEmployeeTable(){
        employeeList=dbCon.getEmployee();
        EmployeeDetails EmployeeModel =new EmployeeDetails(employeeList);
        tblEmployee.setModel(EmployeeModel);
    }
    
    void populateSalaryTable(){
        salaryList=dbCon.getSalary();
        SalaryDetails SalaryModel =new SalaryDetails(salaryList);
        tblSalary.setModel(SalaryModel);
    }
    
    void populateApproveLeaveTable(){
        leaveList=dbCon.getLeave();
        PendingLeaveDetails LeaveModel = new PendingLeaveDetails(leaveList);
        tblApproveLeave.setModel(LeaveModel);
    }
    
    void populateDepartment(){
        departmentList=dbCon.getDepartment();
        DepartmentDetails DepartmentModel = new DepartmentDetails(departmentList);
        tblDepartment.setModel(DepartmentModel);
    }
    
   void populateSpecificLeaveDetailTable(){
        // leaveList=dbCon.getSpecificLeave();
        SpecificLeaveDetails LeaveModel = new SpecificLeaveDetails(specificLeaveList);
        tblSpecificLeave.setModel(LeaveModel);
    }
    
    void populateLeaveHistoryTable(){
        specificLeaveList=dbCon.getLeaveHistory(txtEmployeeNoRL.getText());
        SpecificLeaveDetails LeaveModel = new SpecificLeaveDetails(specificLeaveList);
        tblLeaveHistory.setModel(LeaveModel);
    }
    
    void populateAttendanceTable(){
        attendanceList=dbCon.getAttendance();
        TimeCardDetails TimeCardModel = new TimeCardDetails(attendanceList);
        tblAttendance.setModel(TimeCardModel);
    }
    
    void populatePayrollForm(){
        String date = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        txtPayYear.setText(date);
    }
    
    void clearFieldsEmployee(){
       txtEmployeeNo.setText(dbCon.generateEmployeeID());
       txtEpfNo.setText("");
       txtFullName.setText("");
       txtAddress.setText("");
       ((JTextField)dChoDob.getDateEditor().getUiComponent()).setText("");
       btnGrpGender.clearSelection();
       cmbMaritalStatus.setSelectedIndex(0);
       cmbTitle.setSelectedIndex(0);
       txtNic.setText("");
       ((JTextField)dChoDateJoined.getDateEditor().getUiComponent()).setText("");
       btnGrpEmployeeType.clearSelection();
       cmbEmployeeType.setSelectedIndex(0);
       cmbDepartment.setSelectedIndex(0);
       cmbDesignation.setSelectedIndex(0);
       txtBasicSalary.setText("");
       btnGrpOt.clearSelection();
       btnGrpEpf.clearSelection();
       btnGrpEtf.clearSelection();
       cmbRoot.setSelectedIndex(0);
       txtAccountNo.setText("");
       txtArRemarks.setText("");
       ImageIcon icon=new ImageIcon("C:\\Users\\isuru\\Documents\\images\\default.png");
       lblImage.setIcon(icon);
    }
    
  /*  void clearFieldsRequetLeave(){
       txtLeaveNo.setText(dbCon.generateLeaveID());
       txtEmployeeNoRL.setText("");
       txtNameRL.setText("");
       txtDepartmentNoRL.setText("");
       cmbDepartmentRL.setSelectedIndex(0);
       cmbTypeRL.setSelectedIndex(0);
       ((JTextField)dChoFromRL.getDateEditor().getUiComponent()).setText("");
       ((JTextField)dChoToRL.getDateEditor().getUiComponent()).setText("");
       txtArReasonRL.setText("");
    }*/
    
    void clearFieldsDepartment(){
        txtDepartmentNo.setText(dbCon.generateDepartmentID());
        txtDepartmentName.setText("");
 
    }
    
    void populateCmbDepartment(){
        
        cmbDepartment.removeAllItems();
        
        departmentList=dbCon.getDepartment();
        String[] arr=new String[departmentList.size()];
        //System.out.println(departmentList.size());
        for (int i=0;i<departmentList.size();i++){
            arr[i]=departmentList.get(i).getDepartmentName();       
        }
        for (int i=0;i<departmentList.size();i++){
            cmbDepartment.addItem((arr[i]));
        }  
    }
    
    void setLeaves(Employee emp){
        int casLevCount = dbCon.getRemainingCasualLeaves(emp.getEmpNo());
        txtRemainingCasual.setText(String.valueOf(casLevCount));
        int medLevCount = dbCon.getRemainingMedicalLeaves(emp.getEmpNo());
        txtRemainingMedical.setText(String.valueOf(medLevCount));
        txtRequestedCasual.setText(String.valueOf(21-casLevCount));
        txtRequestedMedical.setText(String.valueOf(24 - medLevCount));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnGrpGender = new javax.swing.ButtonGroup();
        btnGrpEtf = new javax.swing.ButtonGroup();
        btnGrpEpf = new javax.swing.ButtonGroup();
        btnGrpOt = new javax.swing.ButtonGroup();
        btnGrpEmployeeType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dChoDateJoined = new com.toedter.calendar.JDateChooser();
        cmbEmployeeType = new javax.swing.JComboBox<>();
        cmbLocation = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cmbRoot = new javax.swing.JComboBox<>();
        cmbDesignation = new javax.swing.JComboBox<>();
        cmbDepartment = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblImage = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtFullName = new javax.swing.JTextField();
        txtEmployeeNo = new javax.swing.JTextField();
        txtEpfNo = new javax.swing.JTextField();
        dChoDob = new com.toedter.calendar.JDateChooser();
        txtAddress = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        rdoMaleGender = new javax.swing.JRadioButton();
        rdoFemaleGender = new javax.swing.JRadioButton();
        cmbTitle = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtPhoneNo = new javax.swing.JTextField();
        cmbMaritalStatus = new javax.swing.JComboBox<>();
        jPanel37 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtAccountNo = new javax.swing.JTextField();
        rdoYesEtf = new javax.swing.JRadioButton();
        rdoNoEtf = new javax.swing.JRadioButton();
        rdoYesEpf = new javax.swing.JRadioButton();
        rdoNoEpf = new javax.swing.JRadioButton();
        rdoYesOt = new javax.swing.JRadioButton();
        rdoNoOt = new javax.swing.JRadioButton();
        txtBasicSalary = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArRemarks = new javax.swing.JTextArea();
        btnDemo = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtDepartmentNo = new javax.swing.JTextField();
        txtDepartmentName = new javax.swing.JTextField();
        btnAddDepartment = new javax.swing.JButton();
        btnUpdateDepartment = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtEmployeeNoRL = new javax.swing.JTextField();
        cmbTypeRL = new javax.swing.JComboBox<>();
        dChoFromRL = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        dChoToRL = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtArReasonRL = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        txtLeaveNo = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneNoRL = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        spnNoOfFullDays = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        spnNoOfHalfDays = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        txtDepartmentNoRL = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        JScrollPane = new javax.swing.JScrollPane();
        tblLeaveHistory = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtRemainingCasual = new javax.swing.JTextField();
        txtRemainingMedical = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtRequestedCasual = new javax.swing.JTextField();
        txtRequestedMedical = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtEmployeeNoAL = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtUsedAL = new javax.swing.JTextField();
        txtNameAL = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtRemainingAL = new javax.swing.JTextField();
        btnApproveAL = new javax.swing.JButton();
        btnRejectAL = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtArReasonAL = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSpecificLeave = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblApproveLeave = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtEmployeeNoEA = new javax.swing.JTextField();
        dChoDateEA = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        dChoFromEA = new com.toedter.calendar.JDateChooser();
        dChoToEA = new com.toedter.calendar.JDateChooser();
        btnSearchEA = new javax.swing.JButton();
        btnDAReport = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblAttendance = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtEmployeeNoLD = new javax.swing.JTextField();
        txtPreviousPasswordLD = new javax.swing.JTextField();
        txtNewPasswordLD = new javax.swing.JTextField();
        btnResetLD = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        cmbPayMonth = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        txtPayYear = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtPayEmployeeNo = new javax.swing.JTextField();
        btnPaySearch = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtPayName = new javax.swing.JTextField();
        txtPayEpfNo = new javax.swing.JTextField();
        txtPayBasicSalary = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtPayDeductions = new javax.swing.JTextField();
        btnPayCalculate = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        txtPayEpf = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtPayEtf = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txtPayOtAmount = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtBonus = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtPayGrossSalary = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtPayNetSalary = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtNoPayLeaveTaken = new javax.swing.JTextField();
        btnPaySheet = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1356, 577));

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Summary"));

        jScrollPane1.setName(""); // NOI18N

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setText("Date Joined");

        jLabel14.setText("Employee Type");

        jLabel10.setText("Location");

        dChoDateJoined.setDateFormatString("yyyy-MM-dd");

        cmbEmployeeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trainee", "Probation", "Confirm" }));
        cmbEmployeeType.setToolTipText("");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10" }));

        jLabel15.setText("Department");

        jLabel16.setText("Designation");

        jLabel21.setText("Root");

        cmbRoot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Route A", "Route B", "Route C", "Route D" }));
        cmbRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRootActionPerformed(evt);
            }
        });

        cmbDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "General Manager", "Factory Manager", "Manager", "Engineer", "Employee", "Worker" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEmployeeType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dChoDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(dChoDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cmbEmployeeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel10)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(lblImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        btnSelectImage.setText("Select Image");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSelectImage))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectImage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFullNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFullNameKeyTyped(evt);
            }
        });

        txtEmployeeNo.setEditable(false);

        txtEpfNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEpfNoMouseExited(evt);
            }
        });
        txtEpfNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEpfNoActionPerformed(evt);
            }
        });
        txtEpfNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEpfNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEpfNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEpfNoKeyTyped(evt);
            }
        });

        dChoDob.setDateFormatString("yyyy-MM-dd");

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNicKeyTyped(evt);
            }
        });

        btnGrpGender.add(rdoMaleGender);
        rdoMaleGender.setText("Male");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpGender, org.jdesktop.beansbinding.ELProperty.create("Male"), rdoMaleGender, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoMaleGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleGenderActionPerformed(evt);
            }
        });

        btnGrpGender.add(rdoFemaleGender);
        rdoFemaleGender.setText("Female");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpGender, org.jdesktop.beansbinding.ELProperty.create("Female"), rdoFemaleGender, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoFemaleGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleGenderActionPerformed(evt);
            }
        });

        cmbTitle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Ms.", "Mrs." }));

        jLabel34.setText("E-mail");

        jLabel9.setText("Title");

        jLabel7.setText("Gender");

        jLabel6.setText("Date of Birth");

        jLabel3.setText("EPF No");

        jLabel4.setText("Full Name");

        jLabel2.setText("Employee No.");

        jLabel5.setText("Address");

        jLabel1.setText("NIC");

        jLabel8.setText("Marital Status");

        jLabel32.setText("Phone No.");

        txtPhoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNoKeyTyped(evt);
            }
        });

        cmbMaritalStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Unamrried" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMaritalStatus, 0, 160, Short.MAX_VALUE)
                            .addComponent(txtEmployeeNo)
                            .addComponent(txtAddress)
                            .addComponent(txtNic)
                            .addComponent(txtPhoneNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdoMaleGender)
                                .addGap(18, 18, 18)
                                .addComponent(rdoFemaleGender))
                            .addComponent(dChoDob, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtEpfNo)
                            .addComponent(cmbTitle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFullName))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtEpfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(dChoDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdoMaleGender)
                    .addComponent(rdoFemaleGender))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cmbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("Basic Salary");

        jLabel18.setText("OT");

        jLabel19.setText("EPF");

        jLabel20.setText("ETF");

        jLabel22.setText("Account No.");

        jLabel23.setText("Remarks");

        txtAccountNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccountNoKeyTyped(evt);
            }
        });

        btnGrpEtf.add(rdoYesEtf);
        rdoYesEtf.setText("Yes");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpEtf, org.jdesktop.beansbinding.ELProperty.create("Yes"), rdoYesEtf, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoYesEtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoYesEtfActionPerformed(evt);
            }
        });

        btnGrpEtf.add(rdoNoEtf);
        rdoNoEtf.setText("No");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpEtf, org.jdesktop.beansbinding.ELProperty.create("No"), rdoNoEtf, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoNoEtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoEtfActionPerformed(evt);
            }
        });

        btnGrpEpf.add(rdoYesEpf);
        rdoYesEpf.setText("Yes");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpEpf, org.jdesktop.beansbinding.ELProperty.create("Yes"), rdoYesEpf, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoYesEpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoYesEpfActionPerformed(evt);
            }
        });

        btnGrpEpf.add(rdoNoEpf);
        rdoNoEpf.setText("No");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpEpf, org.jdesktop.beansbinding.ELProperty.create("No"), rdoNoEpf, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoNoEpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoEpfActionPerformed(evt);
            }
        });

        btnGrpOt.add(rdoYesOt);
        rdoYesOt.setText("Yes");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpOt, org.jdesktop.beansbinding.ELProperty.create("Yes"), rdoYesOt, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoYesOt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoYesOtActionPerformed(evt);
            }
        });

        btnGrpOt.add(rdoNoOt);
        rdoNoOt.setText("No");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrpOt, org.jdesktop.beansbinding.ELProperty.create("No"), rdoNoOt, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        rdoNoOt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoOtActionPerformed(evt);
            }
        });

        txtBasicSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBasicSalaryKeyTyped(evt);
            }
        });

        txtArRemarks.setColumns(20);
        txtArRemarks.setRows(5);
        jScrollPane3.setViewportView(txtArRemarks);

        btnDemo.setText("Demo");
        btnDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)))
                .addGap(32, 32, 32)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(rdoYesOt)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNoOt)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(rdoYesEpf)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNoEpf))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(txtAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(rdoYesEtf)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove)
                                .addGap(18, 18, 18)
                                .addComponent(btnDemo))
                            .addComponent(rdoNoEtf))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(rdoYesOt)
                        .addComponent(rdoNoOt)
                        .addComponent(jLabel19)
                        .addComponent(rdoYesEpf)
                        .addComponent(rdoNoEpf))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(rdoYesEtf)
                    .addComponent(rdoNoEtf))
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnRemove)
                            .addComponent(btnDemo)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employee", jPanel7);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Department Detail"));

        jLabel44.setText("Department No.");

        jLabel45.setText("Department Name");

        txtDepartmentNo.setEditable(false);

        btnAddDepartment.setText("Add");
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });

        btnUpdateDepartment.setText("Update");
        btnUpdateDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(98, 98, 98)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(btnAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdateDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDepartmentName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addComponent(txtDepartmentNo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtDepartmentNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDepartment)
                    .addComponent(btnUpdateDepartment))
                .addContainerGap(494, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Department Summary"));

        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblDepartment);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 408, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Department", jPanel14);

        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel24.setText("Employee No.");

        jLabel27.setText("Type");

        jLabel28.setText("From Date");

        txtEmployeeNoRL.setEditable(false);

        cmbTypeRL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casual", "Medical", "No Pay" }));

        dChoFromRL.setDateFormatString("yyyy-MM-dd");

        jLabel29.setText("To Date");

        dChoToRL.setDateFormatString("yyyy-MM-dd");

        jLabel30.setText("Reason");

        txtArReasonRL.setColumns(20);
        txtArReasonRL.setRows(5);
        jScrollPane4.setViewportView(txtArReasonRL);

        jLabel43.setText("Leave No.");

        txtLeaveNo.setEditable(false);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel11.setText("Phone No.");

        jLabel13.setText("No of Full Days");

        jLabel25.setText("No of Half Days");

        jLabel47.setText("Department");

        txtDepartmentNoRL.setEditable(false);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addContainerGap(460, Short.MAX_VALUE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtLeaveNo)
                                                .addComponent(cmbTypeRL, 0, 130, Short.MAX_VALUE))
                                            .addComponent(dChoFromRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnNoOfFullDays, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel13))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel47))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnNoOfHalfDays)
                                    .addComponent(txtEmployeeNoRL)
                                    .addComponent(txtDepartmentNoRL)
                                    .addComponent(dChoToRL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(40, 40, 40)
                                .addComponent(txtPhoneNoRL, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubmit))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtLeaveNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cmbTypeRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28)
                                .addComponent(dChoFromRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(spnNoOfFullDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(txtEmployeeNoRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(txtDepartmentNoRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addComponent(dChoToRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(spnNoOfHalfDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(jLabel11)
                    .addComponent(txtPhoneNoRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(351, Short.MAX_VALUE))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Leave History"));

        tblLeaveHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JScrollPane.setViewportView(tblLeaveHistory);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel26.setText("Remaining Leaves");

        jLabel35.setText("Casual");

        jLabel46.setText("Medical");

        txtRemainingCasual.setEditable(false);

        txtRemainingMedical.setEditable(false);

        jLabel48.setText("Used Leaves");

        txtRequestedCasual.setEditable(false);

        txtRequestedMedical.setEditable(false);

        jLabel53.setText("Casual");

        jLabel54.setText("Medical");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(txtRemainingCasual, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(txtRemainingMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel53)
                        .addGap(18, 18, 18)
                        .addComponent(txtRequestedCasual, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel54)
                        .addGap(39, 39, 39)
                        .addComponent(txtRequestedMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(252, 252, 252)
                        .addComponent(jLabel48))
                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel46)
                            .addComponent(txtRemainingCasual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRemainingMedical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRequestedCasual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRequestedMedical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54))
                        .addGap(57, 57, 57)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane7.addTab("Request Leave", jPanel10);

        jLabel31.setText("Employee No.");

        txtEmployeeNoAL.setEditable(false);

        jLabel33.setText("Name");

        jLabel36.setText("Used");

        txtUsedAL.setEditable(false);

        txtNameAL.setEditable(false);
        txtNameAL.setAutoscrolls(false);

        jLabel37.setText("Remaining");

        txtRemainingAL.setEditable(false);

        btnApproveAL.setText("Approve");
        btnApproveAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveALActionPerformed(evt);
            }
        });

        btnRejectAL.setText("Reject");
        btnRejectAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectALActionPerformed(evt);
            }
        });

        jLabel52.setText("Reason");

        txtArReasonAL.setEditable(false);
        txtArReasonAL.setColumns(20);
        txtArReasonAL.setRows(5);
        jScrollPane12.setViewportView(txtArReasonAL);

        tblSpecificLeave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tblSpecificLeave);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(txtUsedAL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel37))
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(txtEmployeeNoAL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRemainingAL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(txtNameAL))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                                .addComponent(btnApproveAL)
                                .addGap(18, 18, 18)
                                .addComponent(btnRejectAL, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtEmployeeNoAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txtNameAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtUsedAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(txtRemainingAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproveAL)
                    .addComponent(btnRejectAL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblApproveLeave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblApproveLeave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblApproveLeaveMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblApproveLeave);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane7.addTab("Approve Leave", jPanel12);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Leave", jPanel3);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel38.setText("Employee No.");

        jLabel39.setText("Date");

        jLabel40.setText("Date Range");

        dChoDateEA.setDateFormatString("yyyy-MM-dd");

        jLabel41.setText("From");

        jLabel42.setText("To");

        dChoFromEA.setDateFormatString("yyyy-MM-dd");

        dChoToEA.setDateFormatString("yyyy-MM-dd");

        btnSearchEA.setText("Search");

        btnDAReport.setText("Daily Attendance Report");
        btnDAReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSearchEA)
                                    .addComponent(txtEmployeeNoEA)
                                    .addComponent(dChoDateEA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dChoFromEA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dChoToEA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDAReport)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtEmployeeNoEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39))
                    .addComponent(dChoDateEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(dChoFromEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42))
                    .addComponent(dChoToEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnSearchEA)
                .addGap(55, 55, 55)
                .addComponent(btnDAReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tblAttendance);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Employee Attendance", jPanel19);

        jButton1.setText("Mark In Time");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mark Off Time");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(952, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(599, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Daily Attendance", jPanel20);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Attendance", jPanel4);

        jLabel49.setText("Employee No.");

        jLabel50.setText("Previous Password");

        jLabel51.setText("New Password");

        btnResetLD.setText("Reset");
        btnResetLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addGap(66, 66, 66)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetLD)
                    .addComponent(txtEmployeeNoLD, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(txtPreviousPasswordLD)
                    .addComponent(txtNewPasswordLD))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtEmployeeNoLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtPreviousPasswordLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtNewPasswordLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnResetLD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(792, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Login Details", jPanel30);

        jLabel55.setText("Create Payslip For Month");

        cmbPayMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel56.setText("Year");

        jLabel57.setText("Employee No.");

        txtPayEmployeeNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPayEmployeeNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPayEmployeeNoKeyTyped(evt);
            }
        });

        btnPaySearch.setText("Search");
        btnPaySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaySearchActionPerformed(evt);
            }
        });

        jLabel58.setText("Name");

        jLabel59.setText("EPF No.");

        jLabel60.setText("Basic Salary");

        txtPayName.setEditable(false);

        txtPayEpfNo.setEditable(false);

        txtPayBasicSalary.setEditable(false);

        jLabel63.setText("Deductions");

        txtPayDeductions.setEditable(false);

        btnPayCalculate.setText("Calculate");
        btnPayCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayCalculateActionPerformed(evt);
            }
        });

        jLabel64.setText("EPF 8%");

        txtPayEpf.setEditable(false);

        jLabel65.setText("ETF 3%");

        txtPayEtf.setEditable(false);

        jLabel66.setText("OT Amount");

        txtPayOtAmount.setEditable(false);

        jLabel70.setText("Bonus");

        txtBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBonusKeyTyped(evt);
            }
        });

        jLabel67.setText("Gross Salary");

        txtPayGrossSalary.setEditable(false);

        jLabel62.setText("Net Salary");

        txtPayNetSalary.setEditable(false);

        jLabel69.setText("No Pay Leave");

        txtNoPayLeaveTaken.setEditable(false);

        btnPaySheet.setText("Generate Pay Sheet");
        btnPaySheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaySheetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(18, 18, 18)
                                .addComponent(txtPayEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(52, 52, 52)
                                .addComponent(cmbPayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPaySearch)
                            .addComponent(txtPayYear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel60))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPayBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPayName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPayEpf, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel67))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPayGrossSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoPayLeaveTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnPayCalculate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPaySheet)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel63)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPayDeductions, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel66)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel59))
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPayEpfNo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPayOtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPayNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(txtPayEtf, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 26, Short.MAX_VALUE))))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(cmbPayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(txtPayYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtPayEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaySearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtPayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(txtPayEpfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtPayBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtPayEpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(txtPayEtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtNoPayLeaveTaken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(txtPayDeductions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(txtPayOtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(txtPayGrossSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(txtPayNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayCalculate)
                    .addComponent(btnPaySheet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblSalary);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Payroll", jPanel13);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoMaleGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleGenderActionPerformed
        //gender="Male";
    }//GEN-LAST:event_rdoMaleGenderActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        // Employee employee = new Employee();
        /*    if(StringUtils.isEmptyOrWhitespaceOnly(txtNic.getText())){
           txtNic.setBackground(Color.PINK);
            //JOptionPane.showMessageDialog(this, "Required Field !!!");
       }
       else if(ValidationEmployeeManagement.chkNic(txtNic.getText())){
           txtNic.setBackground(Color.PINK);
           // JOptionPane.showMessageDialog(this, "Invalid NIC !!!");
       }
        else
           txtNic.setBackground(Color.WHITE);*/
        if (txtEpfNo.getText().equals("") || txtFullName.getText().equals("") || txtAddress.getText().equals("") || ((JTextField) dChoDob.getDateEditor().getUiComponent()).getText().equals("")
                || btnGrpGender.getSelection() == null || cmbMaritalStatus.getSelectedItem().toString().equals("") || cmbTitle.getSelectedItem().toString().equals("") || txtNic.getText().equals("")
                || txtPhoneNo.getText().equals("")
                || ((JTextField) dChoDateJoined.getDateEditor().getUiComponent()).getText().equals("")
                || cmbDepartment.getSelectedItem().toString().equals("") || cmbEmployeeType.getSelectedItem().toString().equals("") || cmbDesignation.getSelectedItem().toString().equals("") || txtBasicSalary.getText().equals("") || btnGrpOt.getSelection() == null
                || btnGrpEpf.getSelection() == null || btnGrpEtf.getSelection() == null || txtAccountNo.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill All the Required Fields !!!");

        } else if (!checkNIC(txtNic.getText())) {

            JOptionPane.showMessageDialog(this, "Invalid NIC !!!");
        } else if (!isValidEmailAddress(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Email !!!");
        } else {

            emp.setFullName(txtFullName.getText());
            emp.setEmpNo(txtEmployeeNo.getText());
            emp.setEpfNo(txtEpfNo.getText());
            emp.setAddress(txtAddress.getText());
            emp.setDob(((JTextField) dChoDob.getDateEditor().getUiComponent()).getText());
            emp.setNic(txtNic.getText());
            emp.setGender(btnGrpGender.getSelection().getActionCommand());
            emp.setMaritalStatus(cmbMaritalStatus.getSelectedItem().toString());
            emp.setTitle(cmbTitle.getSelectedItem().toString());
            emp.setPhoneNo(txtPhoneNo.getText());
            emp.setEmail(txtEmail.getText());
            emp.setDateJoined(((JTextField) dChoDateJoined.getDateEditor().getUiComponent()).getText());
            emp.setDepartment(cmbDepartment.getSelectedItem().toString());
            emp.setEmpType(cmbEmployeeType.getSelectedItem().toString());
            emp.setDesignation(cmbDesignation.getSelectedItem().toString());
            emp.setLocation(cmbLocation.getSelectedItem().toString());
            emp.setRoot(cmbRoot.getSelectedItem().toString());
            emp.setBasicSalary(Double.parseDouble(txtBasicSalary.getText()));
            emp.setAcNo(txtAccountNo.getText());
            emp.setOt(btnGrpOt.getSelection().getActionCommand());
            emp.setEpf(btnGrpEpf.getSelection().getActionCommand());
            emp.setEtf(btnGrpEtf.getSelection().getActionCommand());
            emp.setRemarks(txtArRemarks.getText());
            emp.setImage(person_image);
            emp.setPassword(txtEmployeeNo.getText());
            ///     System.out.println(cmbPermenantType.getSelectedItem().toString());

            if (dbCon.addEmployee(emp)) {
                populateEmployeeTable();
                JOptionPane.showMessageDialog(this, "Successfully Inserted!!!");//imported java.swing class
                //   clearFieldsEmployee();//method is defined above
                //this.dispose();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Inserting!!!");
                // clearFileds();

            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void rdoFemaleGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleGenderActionPerformed
        //gender="Female";
    }//GEN-LAST:event_rdoFemaleGenderActionPerformed

    private void rdoYesOtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoYesOtActionPerformed
        //ot="Yes";
    }//GEN-LAST:event_rdoYesOtActionPerformed

    private void rdoNoOtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoOtActionPerformed
        //ot="No";
    }//GEN-LAST:event_rdoNoOtActionPerformed

    private void rdoYesEpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoYesEpfActionPerformed
       // epf="Yes";
    }//GEN-LAST:event_rdoYesEpfActionPerformed

    private void rdoNoEpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoEpfActionPerformed
       // epf="No";
    }//GEN-LAST:event_rdoNoEpfActionPerformed

    private void rdoYesEtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoYesEtfActionPerformed
        //etf="Yes";
    }//GEN-LAST:event_rdoYesEtfActionPerformed

    private void rdoNoEtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoEtfActionPerformed
       // etf="No";
    }//GEN-LAST:event_rdoNoEtfActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        //path.setText(filename);
        ImageIcon icon=new ImageIcon(filename);
        lblImage.setIcon(icon);
        
        try{
            File image = new File(filename);
            FileInputStream fis= new FileInputStream(image);
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            for(int readNum; (readNum=fis.read(buf))!= -1;){
                bos.write(buf,0,readNum);
            }
            person_image = bos.toByteArray();
        }
        catch(Exception e){
            System.out.println("Exception is throws " + e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        // TODO add your handling code here:
        try {
            //clearFieldsEmployee();
            Employee emp=employeeList.get(tblEmployee.getSelectedRow());
            
            txtEmployeeNo.setText(emp.getEmpNo());
            txtEpfNo.setText(emp.getEpfNo());
            txtFullName.setText(emp.getFullName());
            txtAddress.setText(emp.getAddress());
            ((JTextField)dChoDob.getDateEditor().getUiComponent()).setText(emp.getDob());
            String sex = emp.getGender();
            if(sex.equalsIgnoreCase("Male")){
                    rdoMaleGender.setSelected(true);
                }
                else{
                    rdoFemaleGender.setSelected(true);
                }
            cmbMaritalStatus.setSelectedItem(emp.getMaritalStatus());
            cmbTitle.setSelectedItem(emp.getTitle());
            txtNic.setText(emp.getNic());
            txtPhoneNo.setText(emp.getPhoneNo());
            txtEmail.setText(emp.getEmail());
            ((JTextField)dChoDateJoined.getDateEditor().getUiComponent()).setText(emp.getDateJoined());
            cmbEmployeeType.setSelectedItem(emp.getEmpType());
            cmbLocation.setSelectedItem(emp.getLocation());
            cmbDepartment.setSelectedItem(emp.getDepartment());
            cmbDesignation.setSelectedItem(emp.getDesignation());
            cmbRoot.setSelectedItem(emp.getRoot());
            txtBasicSalary.setText(Double.toString(emp.getBasicSalary()));
            String empOt = emp.getOt();
            if(empOt.equalsIgnoreCase("Yes")){
                    rdoYesOt.setSelected(true);
                }
                else{
                    rdoNoOt.setSelected(true);
                }
            String empEpf = emp.getEpf();
            if(empEpf.equalsIgnoreCase("Yes")){
                    rdoYesEpf.setSelected(true);
                }
                else{
                    rdoNoEpf.setSelected(true);
                }
            String empEtf = emp.getEtf();
            if(empEtf.equalsIgnoreCase("Yes")){
                    rdoYesEtf.setSelected(true);
                }
                else{
                    rdoNoEtf.setSelected(true);
                }
            
            txtAccountNo.setText(emp.getAcNo());
            txtArRemarks.setText(emp.getRemarks());
            if(emp.getImage()==null){
                ImageIcon icon=new ImageIcon("C:\\Users\\isuru\\Documents\\images\\default.png");
                lblImage.setIcon(icon);   
            }else{
                format = new ImageIcon(emp.getImage());
                lblImage.setIcon(format);
            }
            
                 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception is throws " + e);
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
            
        } catch (Exception e3) {
            System.out.println("Exception is throws " + e3);
            e3.printStackTrace();
        }
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtEpfNo.getText().equals("") || txtFullName.getText().equals("") || txtAddress.getText().equals("") || ((JTextField)dChoDob.getDateEditor().getUiComponent()).getText().equals("") || 
               btnGrpGender.getSelection()==null || cmbMaritalStatus.getSelectedItem().toString().equals("") || cmbTitle.getSelectedItem().toString().equals("") || txtNic.getText().equals("") || 
               ((JTextField)dChoDateJoined.getDateEditor().getUiComponent()).getText().equals("") ||  txtPhoneNo.getText().equals("") || cmbEmployeeType.getSelectedItem().toString().equals("") ||
               cmbDepartment.getSelectedItem().toString().equals("") || cmbDesignation.getSelectedItem().toString().equals("") || txtBasicSalary.getText().equals("") || btnGrpOt.getSelection()==null || 
               btnGrpEpf.getSelection()==null || btnGrpEtf.getSelection()==null || txtAccountNo.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {
            emp.setEpfNo(txtEpfNo.getText());
            emp.setFullName(txtFullName.getText());
            emp.setAddress(txtAddress.getText());
            emp.setDob(((JTextField)dChoDob.getDateEditor().getUiComponent()).getText());
            emp.setGender(btnGrpGender.getSelection().getActionCommand());
            emp.setMaritalStatus(cmbMaritalStatus.getSelectedItem().toString());
            emp.setTitle(cmbTitle.getSelectedItem().toString());
            emp.setNic(txtNic.getText());
            emp.setPhoneNo(txtPhoneNo.getText());
            emp.setEmail(txtEmail.getText());
            emp.setDateJoined(((JTextField)dChoDateJoined.getDateEditor().getUiComponent()).getText());
            emp.setEmpType(cmbEmployeeType.getSelectedItem().toString());
            emp.setLocation(cmbLocation.getSelectedItem().toString());
            emp.setDepartment(cmbDepartment.getSelectedItem().toString());
            emp.setDesignation(cmbDesignation.getSelectedItem().toString());
            emp.setBasicSalary(Double.parseDouble(txtBasicSalary.getText()));
            emp.setOt(btnGrpOt.getSelection().getActionCommand());
            emp.setEpf(btnGrpEpf.getSelection().getActionCommand());
            emp.setEtf(btnGrpEtf.getSelection().getActionCommand());
            emp.setRoot(cmbRoot.getSelectedItem().toString());
            emp.setAcNo(txtAccountNo.getText());
            emp.setRemarks(txtArRemarks.getText());
            emp.setImage(person_image);

            if (dbCon.updateEmployee((employeeList.get(tblEmployee.getSelectedRow())),emp)) {
                populateEmployeeTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
              //  clearFieldsEmployee();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(dbCon.removeEmployee(employeeList.get(tblEmployee.getSelectedRow()))){
            populateEmployeeTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
         //   clearFieldsEmployee();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if (txtLeaveNo.getText().equals("") || cmbTypeRL.getSelectedItem().toString().equals("") ||
                ((JTextField)dChoFromRL.getDateEditor().getUiComponent()).getText().equals("") || 
                ((JTextField)dChoToRL.getDateEditor().getUiComponent()).getText().equals("") || txtArReasonRL.getText().equals("") ||
                txtPhoneNoRL.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill All the Required Fields !!!");
// || spnNoOfFullDays.getValue().equals("") || spnNoOfHalfDays.getValue().equals("")
        } else {
            
            lev.setLeaveNo(txtLeaveNo.getText());
            lev.setEmpNo(txtEmployeeNoRL.getText());
            lev.setDepartmentNo(txtDepartmentNoRL.getText());
            lev.setType(cmbTypeRL.getSelectedItem().toString());
            lev.setDateFrom(((JTextField)dChoFromRL.getDateEditor().getUiComponent()).getText());
            lev.setDateTo(((JTextField)dChoToRL.getDateEditor().getUiComponent()).getText());
            lev.setReason(txtArReasonRL.getText());
            lev.setPhoneNo(txtPhoneNoRL.getText());
            lev.setFullDays(Integer.parseInt(spnNoOfFullDays.getValue().toString()));
            lev.setHalfDays(Integer.parseInt(spnNoOfHalfDays.getValue().toString()));
       }
    

        if (dbCon.addLeave(lev)) {
            populateLeaveHistoryTable();
            populateApproveLeaveTable();
            JOptionPane.showMessageDialog(this, "Successfully Inserted!!!");//imported java.swing class
          //  clearFieldsRequetLeave();//method is defined above
            //this.dispose();

        } else {

            JOptionPane.showMessageDialog(this, "Error While Inserting!!!");
            // clearFileds();

        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUpdateDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDepartmentActionPerformed
        // TODO add your handling code here:
        if (txtDepartmentName.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {
            dept.setDepartmentName(txtDepartmentName.getText());

            if (dbCon.updateDepartment((departmentList.get(tblDepartment.getSelectedRow())),dept)) {
                populateDepartment();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
              //  clearFieldsDepartment();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
    }//GEN-LAST:event_btnUpdateDepartmentActionPerformed

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        // TODO add your handling code here:
        if (txtDepartmentNo.getText().equals("") || txtDepartmentName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");
        } else{
            
            dept.setDepartmentNo(txtDepartmentNo.getText());
            dept.setDepartmentName(txtDepartmentName.getText());
            
            if (dbCon.addDepartment(dept)){
                populateDepartment();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
             //   clearFieldsDepartment();
            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            } 
        }
    }//GEN-LAST:event_btnAddDepartmentActionPerformed

    private void btnResetLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLDActionPerformed
        // TODO add your handling code here:
        if (txtEmployeeNoLD.getText().equals("") || txtPreviousPasswordLD.getText().equals("") || 
                txtNewPasswordLD.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");
        } 
            
           else if (dbCon.validateLogin(txtEmployeeNoLD.getText(), txtPreviousPasswordLD.getText(), txtNewPasswordLD.getText())){
                JOptionPane.showMessageDialog(this, "Password Updated Successfully !!!");
                //clearFieldsDepartment();
            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            } 
        
        
    }//GEN-LAST:event_btnResetLDActionPerformed

    private void txtNicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNicKeyTyped

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        // TODO add your handling code here:
    /*    if(StringUtils.isEmptyOrWhitespaceOnly(txtIdNo.getText())){
           txtIdNo.setBackground(Color.PINK);
            //JOptionPane.showMessageDialog(this, "Required Field !!!");
       }
       else if(ValidationEmployeeManagement.chkNic(txtIdNo.getText())){
           txtIdNo.setBackground(Color.PINK);
           // JOptionPane.showMessageDialog(this, "Invalid NIC !!!");
       }
        else
           txtIdNo.setBackground(Color.WHITE);*/
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtFullNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullNameKeyReleased
        // TODO add your handling code here:
       /* if(StringUtils.isEmptyOrWhitespaceOnly(txtFullName.getText())){
            txtFullName.setBackground(Color.PINK);
           // JOptionPane.showMessageDialog(this, "Required Field !!!");
        } 
        else
            txtFullName.setBackground(Color.WHITE);
        */
    }//GEN-LAST:event_txtFullNameKeyReleased

    private void txtEpfNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEpfNoKeyReleased
        // TODO add your handling code here:
     /*   if(StringUtils.isEmptyOrWhitespaceOnly(txtEpfNo.getText())){
            txtEpfNo.setBackground(Color.PINK);
           // JOptionPane.showMessageDialog(this, "Required Field !!!");

        } else if(ValidationEmployeeManagement.chkEpf(txtIdNo.getText())){
            txtEpfNo.setBackground(Color.PINK);
        } 
        else
            txtIdNo.setBackground(Color.WHITE);*/
    }//GEN-LAST:event_txtEpfNoKeyReleased

    private void txtEpfNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEpfNoMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtEpfNoMouseExited

    private void txtEpfNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEpfNoKeyTyped
        // TODO add your handling code here:
         try{
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
        
    }//GEN-LAST:event_txtEpfNoKeyTyped

    private void txtEpfNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEpfNoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtEpfNoActionPerformed

    private void btnDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoActionPerformed
        // TODO add your handling code here:
        try {

            txtEpfNo.setText("99664");
            txtFullName.setText("A.D. Karunarathne");
            txtAddress.setText("No.215, New Kandy Rd, Malabe");
            ((JTextField)dChoDob.getDateEditor().getUiComponent()).setText("1985-08-20");
            rdoMaleGender.setSelected(true);
            rdoFemaleGender.setSelected(false);
            cmbMaritalStatus.setSelectedIndex(0);
            cmbTitle.setSelectedIndex(0);
            txtNic.setText("863123450V");
            cmbTitle.setSelectedIndex(0);
            ((JTextField)dChoDateJoined.getDateEditor().getUiComponent()).setText("214-04-10");
            cmbEmployeeType.setSelectedIndex(2);
            cmbLocation.setSelectedIndex(3);
            cmbDepartment.setSelectedIndex(1);
            cmbDesignation.setSelectedItem(5);
            txtBasicSalary.setText("25000");
            rdoYesOt.setSelected(true);
            rdoNoOt.setSelected(false);
            rdoYesEpf.setSelected(true);
            rdoNoEpf.setSelected(false);
            rdoYesEtf.setSelected(false);
            rdoNoEtf.setSelected(true);
            cmbRoot.setSelectedIndex(2);
            txtAccountNo.setText("558844331");
            txtArRemarks.setText("shows enthusiasm for work place activities.");
            txtPhoneNo.setText("0112833235");
            txtEmail.setText("karuna@gmail.com");

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    
    }//GEN-LAST:event_btnDemoActionPerformed

    private void cmbRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRootActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRootActionPerformed

    private void tblDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentMouseClicked
        // TODO add your handling code here:
        try{
            Department dept = departmentList.get(tblDepartment.getSelectedRow());
        
            txtDepartmentNo.setText(dept.getDepartmentNo());
            txtDepartmentName.setText(dept.getDepartmentName());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception is throws "+e);
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
        }
    }//GEN-LAST:event_tblDepartmentMouseClicked

    private void tblApproveLeaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblApproveLeaveMouseClicked
        // TODO add your handling code here:
        try {
            //clearFieldsEmployee();
            le=leaveList.get(tblApproveLeave.getSelectedRow());
            
            txtEmployeeNoAL.setText(le.getEmpNo());
            txtArReasonAL.setText(le.getReason());
            txtNameAL.setText(le.getName());
        //    txtUsedAL.setText();
            
                 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception is throws " + e);
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
            
        } catch (Exception e3) {
            System.out.println("Exception is throws " + e3);
            e3.printStackTrace();
        }
        

        
        specificLeave=dbCon.getLeaveHistory(le.getEmpNo());
        SpecificLeaveDetails LeaveModel2 = new SpecificLeaveDetails(specificLeave);
        tblSpecificLeave.setModel(LeaveModel2);
    }//GEN-LAST:event_tblApproveLeaveMouseClicked

    private void btnApproveALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveALActionPerformed
        // TODO add your handling code here:
        if(dbCon.approveLeave(leaveList.get(tblApproveLeave.getSelectedRow()))){
            populateApproveLeaveTable();
            JOptionPane.showMessageDialog(this,"Leave Accepted!!!");//imported java.swing class
         //   clearFieldsEmployee();
        }else{
            JOptionPane.showMessageDialog(this,"Error!!! Please Select A record to accept");
        }
    }//GEN-LAST:event_btnApproveALActionPerformed

    private void btnRejectALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectALActionPerformed
        // TODO add your handling code here:
        if(dbCon.rejectLeave(leaveList.get(tblApproveLeave.getSelectedRow()))){
            populateApproveLeaveTable();
            JOptionPane.showMessageDialog(this,"Leave Rejected!!!");//imported java.swing class
         //   clearFieldsEmployee();
        }else{
            JOptionPane.showMessageDialog(this,"Error!!! Please Select A record to reject");
        }
    }//GEN-LAST:event_btnRejectALActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(dbCon.markIntime(txtEmployeeNoRL.getText())){
            JOptionPane.showMessageDialog(this,"Thank you !!!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Please try again !!!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(dbCon.markOfftime(txtEmployeeNoRL.getText())){
            JOptionPane.showMessageDialog(this,"Thank you !!!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Please try again !!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDAReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAReportActionPerformed
        // TODO add your handling code here:
        
        String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        HashMap param = new HashMap();
        param.put("date", date);
        MyReportViewer viewer = new MyReportViewer("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\EmployeeManagement\\report1.jasper", param);
        viewer.setVisible(true);
         
    }//GEN-LAST:event_btnDAReportActionPerformed

    private void txtEpfNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEpfNoKeyPressed
/*        // TODO add your handling code here:
        if(chkEpf(txtEpfNo.getText())){
            txtEpfNo.setBackground(Color.WHITE);
        }
        else{
            System.out.println("Correct");
            txtEpfNo.setBackground(Color.PINK);
        }
            
          */  
    }//GEN-LAST:event_txtEpfNoKeyPressed

    private void txtPayEmployeeNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayEmployeeNoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPayEmployeeNoKeyTyped

    private void txtPayEmployeeNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayEmployeeNoKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPayEmployeeNoKeyReleased

    private void btnPaySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaySearchActionPerformed
        // TODO add your handling code here:
        salaryObj = dbCon.getEmployeeSalary(txtPayEmployeeNo.getText(),cmbPayMonth.getSelectedItem().toString());
        
        txtPayName.setText(salaryObj.getName());
        txtPayEpfNo.setText(salaryObj.getEpfNo());
        txtPayBasicSalary.setText(String.valueOf(salaryObj.getBasicSalary()));
        txtPayEpf.setText(String.valueOf(salaryObj.getEpf()));
        txtPayEtf.setText(String.valueOf(salaryObj.getEtf()));
        txtNoPayLeaveTaken.setText(String.valueOf(salaryObj.getNoPayLeave()));;
        txtPayDeductions.setText(String.valueOf(salaryObj.getDeductions()));
        txtPayOtAmount.setText(String.valueOf(salaryObj.getOtAmount()));
        
        
    }//GEN-LAST:event_btnPaySearchActionPerformed

    private void btnPayCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayCalculateActionPerformed
        // TODO add your handling code here:
        double grossPay = salaryObj.getOtAmount()+salaryObj.getBasicSalary()+Double.parseDouble(txtBonus.getText());
        txtPayGrossSalary.setText(String.valueOf(grossPay));
        txtPayNetSalary.setText(String.valueOf(grossPay-salaryObj.getDeductions()));
        
        if (txtPayEmployeeNo.getText().equals("") || txtPayYear.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All the Required Fields !!!");
            

        }
       
       else {
           
            salaryObj.setMonth(cmbPayMonth.getSelectedItem().toString());
            salaryObj.setYear(txtPayYear.getText());
            salaryObj.setEmployeeNo(txtPayEmployeeNo.getText());
            salaryObj.setName(txtPayName.getText());
            salaryObj.setEpfNo(txtPayEpfNo.getText());
            salaryObj.setBasicSalary(Double.parseDouble(txtPayBasicSalary.getText()));
            salaryObj.setEpf(Double.parseDouble(txtPayEpf.getText()));
            salaryObj.setEtf(Double.parseDouble(txtPayEtf.getText()));
            salaryObj.setNoPayLeave(Double.parseDouble(txtNoPayLeaveTaken.getText()));
            salaryObj.setDeductions(Double.parseDouble(txtPayDeductions.getText()));
            salaryObj.setBonus(Double.parseDouble(txtBonus.getText()));
            salaryObj.setOtAmount(Double.parseDouble(txtPayOtAmount.getText()));
            salaryObj.setGrossSalary(Double.parseDouble(txtPayGrossSalary.getText()));
            salaryObj.setNetSalary(Double.parseDouble(txtPayNetSalary.getText()));
           
            
            if (dbCon.addSalaryDetail(salaryObj)) {
           // populateEmployeeTable();
            JOptionPane.showMessageDialog(this, "Successfully Inserted!!!");//imported java.swing class
         //   clearFieldsEmployee();//method is defined above
            //this.dispose();

        } else {

            JOptionPane.showMessageDialog(this, "Error While Inserting!!!");
            // clearFileds();

        }
       }
    }//GEN-LAST:event_btnPayCalculateActionPerformed

    private void txtPhoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNoKeyTyped
        // TODO add your handling code here:
        try{
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_txtPhoneNoKeyTyped

    private void txtBonusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonusKeyTyped
        // TODO add your handling code here:
         try{
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_txtBonusKeyTyped

    private void txtAccountNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountNoKeyTyped
        // TODO add your handling code here:
        try{
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_txtAccountNoKeyTyped

    private void txtBasicSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBasicSalaryKeyTyped
        // TODO add your handling code here:
        try{
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_txtBasicSalaryKeyTyped

    private void txtFullNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullNameKeyTyped
        // TODO add your handling code here:
        try{
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        }catch(Exception e){
        
        }
        
    }//GEN-LAST:event_txtFullNameKeyTyped

    private void btnPaySheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaySheetActionPerformed
        // TODO add your handling code here:
        HashMap param = new HashMap();
        param.put("empid", Integer.parseInt(txtPayEmployeeNo.getText()));
        MyReportViewer viewer = new MyReportViewer("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\EmployeeManagement\\report1.jasper", param);
        viewer.setVisible(true);
    }//GEN-LAST:event_btnPaySheetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnApproveAL;
    private javax.swing.JButton btnDAReport;
    private javax.swing.JButton btnDemo;
    private javax.swing.ButtonGroup btnGrpEmployeeType;
    private javax.swing.ButtonGroup btnGrpEpf;
    private javax.swing.ButtonGroup btnGrpEtf;
    private javax.swing.ButtonGroup btnGrpGender;
    private javax.swing.ButtonGroup btnGrpOt;
    private javax.swing.JButton btnPayCalculate;
    private javax.swing.JButton btnPaySearch;
    private javax.swing.JButton btnPaySheet;
    private javax.swing.JButton btnRejectAL;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnResetLD;
    private javax.swing.JButton btnSearchEA;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateDepartment;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbDesignation;
    private javax.swing.JComboBox<String> cmbEmployeeType;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JComboBox<String> cmbMaritalStatus;
    private javax.swing.JComboBox<String> cmbPayMonth;
    private javax.swing.JComboBox<String> cmbRoot;
    private javax.swing.JComboBox<String> cmbTitle;
    private javax.swing.JComboBox<String> cmbTypeRL;
    private com.toedter.calendar.JDateChooser dChoDateEA;
    private com.toedter.calendar.JDateChooser dChoDateJoined;
    private com.toedter.calendar.JDateChooser dChoDob;
    private com.toedter.calendar.JDateChooser dChoFromEA;
    private com.toedter.calendar.JDateChooser dChoFromRL;
    private com.toedter.calendar.JDateChooser dChoToEA;
    private com.toedter.calendar.JDateChooser dChoToRL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdoFemaleGender;
    private javax.swing.JRadioButton rdoMaleGender;
    private javax.swing.JRadioButton rdoNoEpf;
    private javax.swing.JRadioButton rdoNoEtf;
    private javax.swing.JRadioButton rdoNoOt;
    private javax.swing.JRadioButton rdoYesEpf;
    private javax.swing.JRadioButton rdoYesEtf;
    private javax.swing.JRadioButton rdoYesOt;
    private javax.swing.JSpinner spnNoOfFullDays;
    private javax.swing.JSpinner spnNoOfHalfDays;
    private javax.swing.JTable tblApproveLeave;
    private javax.swing.JTable tblAttendance;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblLeaveHistory;
    private javax.swing.JTable tblSalary;
    private javax.swing.JTable tblSpecificLeave;
    private javax.swing.JTextField txtAccountNo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtArReasonAL;
    private javax.swing.JTextArea txtArReasonRL;
    private javax.swing.JTextArea txtArRemarks;
    private javax.swing.JTextField txtBasicSalary;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JTextField txtDepartmentName;
    private javax.swing.JTextField txtDepartmentNo;
    private javax.swing.JTextField txtDepartmentNoRL;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeNo;
    private javax.swing.JTextField txtEmployeeNoAL;
    private javax.swing.JTextField txtEmployeeNoEA;
    private javax.swing.JTextField txtEmployeeNoLD;
    private javax.swing.JTextField txtEmployeeNoRL;
    private javax.swing.JTextField txtEpfNo;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtLeaveNo;
    private javax.swing.JTextField txtNameAL;
    private javax.swing.JTextField txtNewPasswordLD;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtNoPayLeaveTaken;
    private javax.swing.JTextField txtPayBasicSalary;
    private javax.swing.JTextField txtPayDeductions;
    private javax.swing.JTextField txtPayEmployeeNo;
    private javax.swing.JTextField txtPayEpf;
    private javax.swing.JTextField txtPayEpfNo;
    private javax.swing.JTextField txtPayEtf;
    private javax.swing.JTextField txtPayGrossSalary;
    private javax.swing.JTextField txtPayName;
    private javax.swing.JTextField txtPayNetSalary;
    private javax.swing.JTextField txtPayOtAmount;
    private javax.swing.JTextField txtPayYear;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtPhoneNoRL;
    private javax.swing.JTextField txtPreviousPasswordLD;
    private javax.swing.JTextField txtRemainingAL;
    private javax.swing.JTextField txtRemainingCasual;
    private javax.swing.JTextField txtRemainingMedical;
    private javax.swing.JTextField txtRequestedCasual;
    private javax.swing.JTextField txtRequestedMedical;
    private javax.swing.JTextField txtUsedAL;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
