/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

/**
 *
 * @author Sampath Rajapakse
 */
import EmployeeManagement.Employee;
import StockManagement.Machine;
import StockManagement.Material;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import voguetexmachinesharing.managementsystem.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.validation.api.Problem;
import org.netbeans.validation.api.Problems;
import org.netbeans.validation.api.Severity;
import org.netbeans.validation.api.Validator;
import org.netbeans.validation.api.ValidatorUtils;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.GroupValidator;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.ValidationGroupProvider;
import org.netbeans.validation.api.ui.swing.SwingValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ModuleMainMenu extends javax.swing.JInternalFrame {

    /**
     * Creates new form ModuleMainMenu
     */
     
    public ModuleMainMenu() {
        initComponents();
        clearFieldsStyle();
        clearFieldsOrderQunatity();
        clearFieldsManPower();
        clearFieldsMaterialQunatity();
        clearFieldsOperation();
        clearFieldsMachineDifference();
        clearFieldsManPowerDiff();
        clearFieldsMaterialDiff();
        clearFieldsAssignedMachine();
        populateStyleTable();
        populateOrderQuantityTable();
        populateBudgetedCadre();
        populateDDStyleNo();
        populateDDOperation();
        populateManPowerTable();
        populateMaterialQuantityTable();
        
        populateOperationTable();
        populateMachineDiffTable();
        populateManPowerDiffTable();
        populateMaterialDiffTable();
        populateAssignMachineTable();
        populateIdleMachineTable();
        populateAssignMaterialTable();
        populateIdleMaterialTable();
        populateAssignWorkerTable();
        populateIdleWorkerTable();
        validateManPower();
        validateNewStyle();
        validateAddCadre();
        validateAddMaterial();
        validateAddOperation();
        validateAddQuantity();
        validateMaterialAllocation();
        validateSendMail();
        addlistener();
        disableDateChooser();
        
       // Document doc=validationPanelNewStyle.getD
        /*
        validationPanelNewStyle.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    btnSubmit.setEnabled(false);
                }
            });
        
                
                if (validationPanelNewStyle.getProblem().toString().equals("")) {
                btnSubmit.setEnabled(true);
            } else {
                btnSubmit.setEnabled(false);
            }
        */
        
       
    }
    void refresh(){
        
        clearFieldsStyle();
        clearFieldsOrderQunatity();
        clearFieldsManPower();
        clearFieldsMaterialQunatity();
        clearFieldsOperation();
        clearFieldsMachineDifference();
        clearFieldsManPowerDiff();
        clearFieldsMaterialDiff();
        clearFieldsAssignedMachine();
        populateStyleTable();
        populateOrderQuantityTable();
        populateBudgetedCadre();
        populateDDStyleNo();
        populateDDOperation();
        populateManPowerTable();
        populateOperationTable();
        
        populateMaterialQuantityTable();
        populateMachineDiffTable();
        populateManPowerDiffTable();
        populateMaterialDiffTable();
        populateAssignMachineTable();
        populateIdleMachineTable();
        populateAssignMaterialTable();
        populateIdleMaterialTable();
        populateAssignWorkerTable();
        populateIdleWorkerTable();
        validateManPower();
        validateNewStyle();
        validateSendMail();
    
    }
  
    ArrayList<Style> styleList ;
    ArrayList<PurchaseOrder> orderList ;
    ArrayList<ManPower> manPowerList ;
    ArrayList<StyleMaterial> materialList ;
    ArrayList<StyleOperation> operationList ;
    ArrayList<Machine> machineList ;
    ArrayList<Material> materialsearchList ;
    ArrayList<Employee> employeeList ;
    ArrayList<AssignMachine> assignmachineList ;
    ArrayList<AssignMaterial> assignmaterialList ;
    ArrayList<AssignWorker> assignworkerList ;
    
    
    Style s =new Style();
    PurchaseOrder po=new PurchaseOrder();
    ManPower mp=new ManPower();
    StyleMaterial sm=new StyleMaterial();
    StyleOperation so=new StyleOperation();
    
    Machine m=new Machine();
    Material ma=new Material();
    Employee emp=new Employee();
    DBOperationStylePlanning dbOps = new DBOperationStylePlanning();
    
    static int direct=42;
    static int indirect=8;
    static int total=50;
    
    void clearFieldsStyle(){
       txtStyleNo.setText("");
       txtBuyer.setText("");
       txtPrototype.setText("");
       ((JTextField)txtStartDate.getDateEditor().getUiComponent()).setText(" ");
       ((JTextField)txtEndDate.getDateEditor().getUiComponent()).setText(" ");
    }
    
    
    
    void clearFieldsOrderQunatity(){
        
        txtPurchaceOrderNo.setText("");
        txtQuantityQ.setText("");
        txtRemarksQ.setText("");
    
    }
     void clearFieldsMaterialQunatity(){
        
        txtMaterialAllocationNo.setText("");
        txtQuantityMaterial.setText("");
        txtRemarksMaterial.setText("");
    
    }
      void clearFieldsOperation(){
        
        txtOperationNo.setText("");
        txtOperationMachineQuantity.setText("");
        txtRemarksOperation.setText("");
        txtMC.setText("");
        txtMA.setText("");
    
    }
       void clearFieldsMachineDifference(){
        
        txtSingleNeedleC.setText("");
        txtSingleNeedleN.setText("");
        txtSingleNeedleD.setText("");
        txt5ThreadOverlockC.setText("");
        txt5ThreadOverlockN.setText("");
        txt5ThreadOverlockD.setText("");
        txtFlatLockC.setText("");
        txtFlatLockN.setText("");
        txtFlatLockD.setText("");
        txtPearlStitchC.setText("");
        txtPearlStitchN.setText("");
        txtPearlStitchD.setText("");
        txtOverlockC.setText("");
        txtOverlockN.setText("");
        txtOverlockD.setText("");
        txtIronC.setText("");
        txtIronN.setText("");
        txtIronD.setText("");
        txtTotalMachineDifference.setText("");
    
    }
       void clearFieldsManPowerDiff(){
        
        txtDirectC.setText("");
        txtDirectN.setText("");
        txtDirectD.setText("");
        txtIndirectC.setText("");
        txtIndirectN.setText("");
        txtIndirectD.setText("");
        txtTotalManPowerDifference.setText("");
    
    }
       void clearFieldsMaterialDiff(){
        
        txtWoolFabricC.setText("");
        txtWoolFabricN.setText("");
        txtWoolFabricD.setText("");
        txtSilkFabricC.setText("");
        txtSilkFabricsN.setText("");
        txtSilkFabricD.setText("");
        txtCottonFabricC.setText("");
        txtCottonFabricN.setText("");
        txtCottonFabricD.setText("");
        txtNylonFabricC.setText("");
        txtNylonFabricN.setText("");
        txtNylonFabricsD.setText("");
        
        txtTotalMaterialDifference.setText("");
    
    }
      
    void clearFieldsManPower(){
        
        txtDirect.setText("");
        txtIndirect.setText("");
        txtTotal.setText("");
    
    }
    
    void clearFieldsAssignedMachine(){
        
        txtAssetIDMachine.setText("");
        txtTypeMachine.setText("");
        txtOwnership.setText("");
        txtPreviousFactoryMachine.setText("");
        txtPreviousLocationMachine.setText("");
    
    }
    
    void clearFieldsAssignedMaterial(){
        
        txtAssetIDMachine1.setText("");
        txtTypeMachine1.setText("");
        txtPreviousQuantity.setText("");
        txtPreviousFactoryMachine1.setText("");
        txtPreviousLocationMachine1.setText("");
        txtQuantityAssigned.setText("");
    
    }
    
    void clearFieldsAssignedWorker(){
        
        txtAssetIDMachine2.setText("");
        txtTypeMachine2.setText("");
        txtEmployeeName.setText("");
        txtPreviousFactoryMachine2.setText("");
        txtPreviousLocationMachine2.setText("");
    
    }
    
    void populateStyleTable(){
        styleList=dbOps.getStyles();
        StyleDetails styleModel =new StyleDetails(styleList);
        tblStyle.setModel(styleModel);  
    }
    
    void populateOrderQuantityTable(){
        orderList=dbOps.getPurchaseOrders();
        PurchaseOrderDetails orderModel =new PurchaseOrderDetails(orderList);
        tblOrder.setModel(orderModel);  
    }
    void populateMaterialQuantityTable(){
        materialList=dbOps.getStyleMaterial();
        StyleMaterialDetails materialModel =new StyleMaterialDetails(materialList);
        tblMaterial.setModel(materialModel);  
    }
    
    void populateBudgetedCadre(){
        txtDirectE.setText(Integer.toString(direct));
        txtIndirectE.setText(Integer.toString(indirect));
        txtTotalE.setText(Integer.toString(total));
    }
    
    void populateDDStyleNo(){
        
        ddStyleNoM.removeAllItems();
        ddStyleNoM1.removeAllItems();
        ddStyleNoM2.removeAllItems();
        ddStyleNoM3.removeAllItems();
        ddStyleNoM4.removeAllItems();
        ddStyleNoM5.removeAllItems();
        ddStyleNoM6.removeAllItems();
        ddStyleNoM7.removeAllItems();
        
        styleList=dbOps.getStyles();
        int[] arr=new int[styleList.size()];
        for (int i=0;i<styleList.size();i++){
            arr[i]=styleList.get(i).getStyleNo();       
        }
        for (int i=0;i<styleList.size();i++){
            ddStyleNoM.addItem(Integer.toString(arr[i]));
            ddStyleNoM1.addItem(Integer.toString(arr[i]));
            ddStyleNoM2.addItem(Integer.toString(arr[i]));
            ddStyleNoM3.addItem(Integer.toString(arr[i]));
            ddStyleNoM4.addItem(Integer.toString(arr[i]));
            ddStyleNoM5.addItem(Integer.toString(arr[i]));
            ddStyleNoM6.addItem(Integer.toString(arr[i]));
            ddStyleNoM7.addItem(Integer.toString(arr[i]));
            ddStyleNoM8.addItem(Integer.toString(arr[i]));
        }  
    }
    
    void populateDDOperation(){
        operationList=dbOps.getOperationType();
        String[] arr=new String[operationList.size()];
        for (int i=0;i<operationList.size();i++){
            arr[i]=operationList.get(i).getType(); 
            
        }
        for (int i=0;i<operationList.size();i++){
            ddOperationAssignWorker.addItem((arr[i]));
        }  
    }
    
    void populateManPowerTable(){
        manPowerList=dbOps.getManPowerAllocation();
        ManPowerDetails manPowerModel =new ManPowerDetails(manPowerList);
        tblManPower.setModel(manPowerModel);  
    }
    void populateOperationTable(){
        operationList=dbOps.getOperation();
        StyleOperationDetails operationModel =new StyleOperationDetails(operationList);
        tblOperation.setModel(operationModel);  
    }
    
    void populateMachineDiffTable(){
        operationList=dbOps.getMachineDiff();
        MachineDiffDetails machineDiffModel =new MachineDiffDetails(operationList);
        tblMachineDiff.setModel(machineDiffModel);  
    }
    
    void populateManPowerDiffTable(){
        manPowerList=dbOps.getManPowerDiff();
        ManPowerDiffDetails manPowerDiffModel =new ManPowerDiffDetails(manPowerList);
        tblManPowerDiff.setModel(manPowerDiffModel);  
    }
    
    void populateMaterialDiffTable(){
        materialList=dbOps.getMaterialDiff();
        MaterialDiffDetails materialDiffModel =new MaterialDiffDetails(materialList);
        tblMaterialDiff.setModel(materialDiffModel);  
    }
    void populateAssignMachineTable(){
        assignmachineList=dbOps.getAssignedMachines();
        AssignMachineDetails assignedMachineModel =new AssignMachineDetails(assignmachineList);
        tblAssignMachine.setModel(assignedMachineModel);  
    }
    
    void populateAssignMaterialTable(){
        assignmaterialList=dbOps.getAssignedMaterial();
        AssignMaterialDetails assignedMaterialModel =new AssignMaterialDetails(assignmaterialList);
        tblAssignMaterial.setModel(assignedMaterialModel);  
    }
    
    void populateAssignWorkerTable(){
        assignworkerList=dbOps.getAssignedWorker();
        AssignWorkerDetails assignedWorkerModel =new AssignWorkerDetails(assignworkerList);
        tblAssignWorker.setModel(assignedWorkerModel);  
    }
    
    void populateIdleMachineTable(){
        machineList=dbOps.getIdleMachine(m);
        IdleMachineDetails idleMachineModel =new IdleMachineDetails(machineList);
        tblIdleMachines.setModel(idleMachineModel);  
    }
    
    void populateIdleMaterialTable(){
        materialsearchList=dbOps.getAvailabaleMaterials(ma);
        AvailableMaterialDetails idleMaterialModel =new AvailableMaterialDetails(materialsearchList);
        tblIdleMaterial.setModel(idleMaterialModel);  
    }
    
    void populateIdleWorkerTable(){
        employeeList=dbOps.getIdleWorker(emp);
        IdleWorkerDetails idleWorkerModel =new IdleWorkerDetails(employeeList);
        tblIdleWorker.setModel(idleWorkerModel);  
    }
   
    
    void validateManPower() {
        try {
            SwingValidationGroup group = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtDirect.setName("Direct");
            txtIndirect.setName("Indirect");

            group.add(txtDirect, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    StringValidators.numberRange(0,60),
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_INTEGER);

            group.add(txtIndirect, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    StringValidators.numberRange(0,20),
                   // StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_INTEGER);

            JComponent validationLabel = group.createProblemLabel();
            validationPanelManPower.add(validationLabel);

            if (validationPanelManPower.getProblem().toString().equals("")) {
                btnSubmitMan.setEnabled(true);
            } else {
                btnSubmitMan.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    
    void validateNewStyle() {
        try {
            SwingValidationGroup group1 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtStyleNo.setName("StyleNo");
            txtBuyer.setName("Buyer");
            txtPrototype.setName("Prototype");
            txtSearchStyleByBuyer.setName("SearchStyle");

            group1.add(txtStyleNo, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    StringValidators.minLength(4),
                    StringValidators.maxLength(4),
                   // StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_NUMBER,
                    StringValidators.REQUIRE_VALID_INTEGER);

            group1.add(txtBuyer, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.MAY_NOT_START_WITH_DIGIT
                    );
            
            group1.add(txtPrototype, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.MAY_NOT_START_WITH_DIGIT
                    );
            
            group1.add(txtSearchStyleByBuyer,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.MAY_NOT_START_WITH_DIGIT
                    );

            JComponent validationLabel1 = group1.createProblemLabel();
            validationPanelNewStyle.add(validationLabel1);

            if (validationPanelNewStyle.getProblem().toString().equals("")) {
                btnSubmit.setEnabled(true);
            } else {
                btnSubmit.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }

    void validateSendMail() {
        try {
            SwingValidationGroup group1 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtUsername.setName("Username");
            txtPassword.setName("Password");
            txtReceiver.setName("Reciever");
           

            group1.add(txtUsername, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.EMAIL_ADDRESS
                   );

            group1.add(txtPassword, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE                   
                    );
            
            group1.add(txtReceiver, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.EMAIL_ADDRESS
                    );
            
            

            JComponent validationLabel1 = group1.createProblemLabel();
            validationPanelSendMail.add(validationLabel1);

            if (validationPanelSendMail.getProblem().toString().equals("")) {
                btnSendMail.setEnabled(true);
            } else {
                btnSendMail.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    void validateAddQuantity() {
        try {
            SwingValidationGroup group2 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtPurchaceOrderNo.setName("Purchase Order");
            txtQuantityQ.setName("Quantity");
           

            group2.add(txtPurchaceOrderNo, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                   // StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_NUMBER,
                    StringValidators.REQUIRE_VALID_INTEGER);

            group2.add(txtQuantityQ, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_NUMBER,
                    StringValidators.REQUIRE_VALID_INTEGER);

            JComponent validationLabel2 = group2.createProblemLabel();
            validationPanelAddQuantity.add(validationLabel2);

            if (validationPanelAddQuantity.getProblem().toString().equals("")) {
                btnSubmitQ.setEnabled(true);
            } else {
                btnSubmitQ.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    
    void validateAddMaterial() {
        try {
            SwingValidationGroup group3 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtMaterialAllocationNo.setName("Material Allocation");
            txtQuantityMaterial.setName("Quantity");
           

            group3.add(txtMaterialAllocationNo, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                   // StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_INTEGER);

            group3.add(txtQuantityMaterial, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                  //  StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_NUMBER);

            JComponent validationLabel3 = group3.createProblemLabel();
            validationPanelAddMaterial.add(validationLabel3);

            if (validationPanelAddMaterial.getProblem().toString().equals("")) {
                btnSubmitQ1.setEnabled(true);
            } else {
                btnSubmitQ1.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    
    void validateAddOperation() {
        try {
            SwingValidationGroup group4 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtOperationNo.setName("Operation No");
            txtOperationMachineQuantity.setName("Quantity");
           

            group4.add(txtOperationNo, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_INTEGER);

            group4.add(txtOperationMachineQuantity, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_INTEGER);

            JComponent validationLabel4 = group4.createProblemLabel();
            validationPanelAddOperation.add(validationLabel4);

            if (validationPanelAddOperation.getProblem().toString().equals("")) {
                btnSubmitOperation.setEnabled(true);
            } else {
                btnSubmitOperation.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    
    void validateAddCadre() {
        try {
            SwingValidationGroup group5 = SwingValidationGroup.create();;
            //SwingValidationGroup group1 = SwingValidationGroup.create();;

            txtDirectE1.setName("Direct");
            txtIndirectE1.setName("Indirect");
           

            group5.add(txtDirectE1, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                   // StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.numberRange(0, 60),
                    StringValidators.REQUIRE_VALID_INTEGER);

            group5.add(txtIndirectE1, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.numberRange(0, 60),
                    StringValidators.REQUIRE_VALID_INTEGER);

            JComponent validationLabel5 = group5.createProblemLabel();
            validationAddCadre.add(validationLabel5);

            if (validationAddCadre.getProblem().toString().equals("")) {
                jButton2.setEnabled(true);
            } else {
                jButton2.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
    
     void validateMaterialAllocation() {
        try {
            SwingValidationGroup group6 = SwingValidationGroup.create();;

            txtQuantityAssigned.setName("Quantity");
           
            group6.add(txtQuantityAssigned, StringValidators.REQUIRE_NON_EMPTY_STRING,
                    StringValidators.NO_WHITESPACE,
                    StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,
                    //StringValidators.MAY_NOT_END_WITH_PERIOD,
                    StringValidators.REQUIRE_VALID_NUMBER);

            JComponent validationLabel6 = group6.createProblemLabel();
            validationPanelMaterialAllocation.add(validationLabel6);

            if (validationPanelMaterialAllocation.getProblem().toString().equals("")) {
                btnAssignMaterial.setEnabled(true);
            } else {
                btnAssignMaterial.setEnabled(false);
            }

        } catch (Exception e) {

        }
    }
      void addlistener(){
          if(txtIndirectE1.getText().equals("")){
              txtIndirectE1.setText(null);
          }else{
            txtDirectE1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                add();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                add();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                add();
            }
            void add(){
                int newtotal=Integer.parseInt(txtDirectE1.getText())+Integer.parseInt(txtIndirectE1.getText());
                txtTotalE1.setText(Integer.toString(newtotal));
            
            }
        });
      
          }
      
      }
      
      void disableDateChooser(){
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtSearchDateDiff.getDateEditor();
        editor.setEditable(false);
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) txtSearchIdleSearch.getDateEditor();
        editor1.setEditable(false);
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) txtSearchIdleSearch1.getDateEditor();
        editor2.setEditable(false);
        JTextFieldDateEditor editor3 = (JTextFieldDateEditor) txtSearchIdleSearch2.getDateEditor();
        editor3.setEditable(false);
        JTextFieldDateEditor editor4 = (JTextFieldDateEditor) txtStartDate.getDateEditor();
        editor4.setEditable(false);
        JTextFieldDateEditor editor5 = (JTextFieldDateEditor) txtEndDate.getDateEditor();
        editor5.setEditable(false);
      
      }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStyleNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBuyer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrototype = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ddFactory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ddLocation = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStyle = new javax.swing.JTable();
        btnDemoStyle = new javax.swing.JButton();
        btnRefreshStyle = new javax.swing.JButton();
        validationPanelNewStyle = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        txtSearchStyleByBuyer = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPurchaceOrderNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ddSize = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRemarksQ = new javax.swing.JTextArea();
        txtQuantityQ = new javax.swing.JTextField();
        ddColor = new javax.swing.JComboBox<>();
        ddStyleNoM2 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        validationPanelAddQuantity = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        btnUpdateQ = new javax.swing.JButton();
        btnSubmitQ = new javax.swing.JButton();
        btnRemoveQ = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnRefreshPurchaseOrder = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        ddStyleNoM = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtDirectE = new javax.swing.JTextField();
        txtIndirectE = new javax.swing.JTextField();
        txtTotalE = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtDirect = new javax.swing.JTextField();
        txtIndirect = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnUpdateMan = new javax.swing.JButton();
        btnSubmitMan = new javax.swing.JButton();
        btnRemoveMan = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblManPower = new javax.swing.JTable();
        lblerrorManPower = new javax.swing.JLabel();
        btnRefreshManPower = new javax.swing.JButton();
        validationPanelManPower = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtMaterialAllocationNo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        ddType = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtRemarksMaterial = new javax.swing.JTextArea();
        txtQuantityMaterial = new javax.swing.JTextField();
        ddColorMaterial = new javax.swing.JComboBox<>();
        ddStyleNoM1 = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        btnUpdateMaterial = new javax.swing.JButton();
        btnSubmitQ1 = new javax.swing.JButton();
        btnRemoveMaterial = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnRefreshPurchaseOrder1 = new javax.swing.JButton();
        validationPanelAddMaterial = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtOperationNo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        ddOperationType = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRemarksOperation = new javax.swing.JTextArea();
        txtOperationMachineQuantity = new javax.swing.JTextField();
        ddMachine = new javax.swing.JComboBox<>();
        ddStyleNoM3 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        ddSpeciality = new javax.swing.JComboBox<>();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblOperation = new javax.swing.JTable();
        btnUpdateOperation = new javax.swing.JButton();
        btnSubmitOperation = new javax.swing.JButton();
        btnRemoveOperation = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnRefreshOperation = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtMC = new javax.swing.JTextField();
        txtMA = new javax.swing.JTextField();
        validationPanelAddOperation = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtDirectE1 = new javax.swing.JTextField();
        txtIndirectE1 = new javax.swing.JTextField();
        txtTotalE1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        validationAddCadre = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        ddFactoryDiff = new javax.swing.JComboBox<>();
        ddLocationDiff = new javax.swing.JComboBox<>();
        txtSearchDateDiff = new com.toedter.calendar.JDateChooser();
        btnSearchDiff = new javax.swing.JButton();
        btnRefreshDiff = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtCurrentStyleNo = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtNextStyle = new javax.swing.JTextField();
        txtCurrentStartDate = new javax.swing.JTextField();
        txtNextStyleStartDate = new javax.swing.JTextField();
        txtCurrentEndDate = new javax.swing.JTextField();
        txtNextStyleEndDate = new javax.swing.JTextField();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel37 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        txtPearlStitch = new javax.swing.JTextField();
        txtSingleNeedle = new javax.swing.JTextField();
        txt5ThreadOverlock = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        txtIron = new javax.swing.JTextField();
        txtOverlock = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtTotalMachineDifference = new javax.swing.JTextField();
        btnSaveMachineDiff = new javax.swing.JButton();
        txtFlatLock = new javax.swing.JTextField();
        txtSingleNeedleC = new javax.swing.JTextField();
        txt5ThreadOverlockC = new javax.swing.JTextField();
        txtFlatLockC = new javax.swing.JTextField();
        txtPearlStitchC = new javax.swing.JTextField();
        txtIronC = new javax.swing.JTextField();
        txtOverlockC = new javax.swing.JTextField();
        txtSingleNeedleN = new javax.swing.JTextField();
        txt5ThreadOverlockN = new javax.swing.JTextField();
        txtFlatLockN = new javax.swing.JTextField();
        txtPearlStitchN = new javax.swing.JTextField();
        txtIronN = new javax.swing.JTextField();
        txtOverlockN = new javax.swing.JTextField();
        txtSingleNeedleD = new javax.swing.JTextField();
        txt5ThreadOverlockD = new javax.swing.JTextField();
        txtFlatLockD = new javax.swing.JTextField();
        txtPearlStitchD = new javax.swing.JTextField();
        txtIronD = new javax.swing.JTextField();
        txtOverlockD = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        chkStatusMachine = new javax.swing.JCheckBox();
        jPanel38 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jTextField21 = new javax.swing.JTextField();
        txtDirectDiff = new javax.swing.JTextField();
        txtIndirectDiff = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtTotalManPowerDifference = new javax.swing.JTextField();
        btnSaveManPowerDiff = new javax.swing.JButton();
        txtDirectC = new javax.swing.JTextField();
        txtIndirectC = new javax.swing.JTextField();
        txtDirectN = new javax.swing.JTextField();
        txtIndirectN = new javax.swing.JTextField();
        txtDirectD = new javax.swing.JTextField();
        txtIndirectD = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        chkStatusManPower = new javax.swing.JCheckBox();
        jPanel39 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtTotalMaterialDifference = new javax.swing.JTextField();
        btnSaveMaterialDiff = new javax.swing.JButton();
        jTextField20 = new javax.swing.JTextField();
        txtWoolFabricC = new javax.swing.JTextField();
        txtSilkFabricC = new javax.swing.JTextField();
        txtCottonFabricC = new javax.swing.JTextField();
        txtNylonFabricC = new javax.swing.JTextField();
        txtWoolFabricN = new javax.swing.JTextField();
        txtSilkFabricsN = new javax.swing.JTextField();
        txtCottonFabricN = new javax.swing.JTextField();
        txtNylonFabricN = new javax.swing.JTextField();
        txtWoolFabricD = new javax.swing.JTextField();
        txtSilkFabricD = new javax.swing.JTextField();
        txtCottonFabricD = new javax.swing.JTextField();
        txtNylonFabricsD = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        chkStatusMaterial = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblMachineDiff = new javax.swing.JTable();
        btnDeleteMachineDiff = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblManPowerDiff = new javax.swing.JTable();
        btnDeleteManPowerDiff = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblMaterialDiff = new javax.swing.JTable();
        btnDeleteMaterialDiff = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ddFactoryIdleSearch = new javax.swing.JComboBox<>();
        ddLocationIdleSearch = new javax.swing.JComboBox<>();
        ddOwnershipIdleSearch = new javax.swing.JComboBox<>();
        txtSearchIdleSearch = new com.toedter.calendar.JDateChooser();
        btnSearchMachine = new javax.swing.JButton();
        btnChooseMachine = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblIdleMachines = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtAssetIDMachine = new javax.swing.JTextField();
        txtTypeMachine = new javax.swing.JTextField();
        txtOwnership = new javax.swing.JTextField();
        txtPreviousFactoryMachine = new javax.swing.JTextField();
        txtPreviousLocationMachine = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ddFactoryMachine = new javax.swing.JComboBox<>();
        ddLocationMachine = new javax.swing.JComboBox<>();
        btnAssignMachine = new javax.swing.JButton();
        btnRemoveMachine = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAssignMachine = new javax.swing.JTable();
        ddStyleNoM4 = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        ddFactoryIdleSearch1 = new javax.swing.JComboBox<>();
        ddLocationIdleSearch1 = new javax.swing.JComboBox<>();
        txtSearchIdleSearch1 = new com.toedter.calendar.JDateChooser();
        btnSearchMaterial = new javax.swing.JButton();
        btnChooseMaterial = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblIdleMaterial = new javax.swing.JTable();
        validationPanelMaterialAllocation = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtAssetIDMachine1 = new javax.swing.JTextField();
        txtTypeMachine1 = new javax.swing.JTextField();
        txtPreviousQuantity = new javax.swing.JTextField();
        txtPreviousFactoryMachine1 = new javax.swing.JTextField();
        txtPreviousLocationMachine1 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        ddFactoryMachine1 = new javax.swing.JComboBox<>();
        ddLocationMachine1 = new javax.swing.JComboBox<>();
        btnAssignMaterial = new javax.swing.JButton();
        btnRemoveAssignedMaterial = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblAssignMaterial = new javax.swing.JTable();
        ddStyleNoM5 = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        txtQuantityAssigned = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        ddFactoryIdleSearch2 = new javax.swing.JComboBox<>();
        ddLocationIdleSearch2 = new javax.swing.JComboBox<>();
        ddTypeIdleWorker = new javax.swing.JComboBox<>();
        txtSearchIdleSearch2 = new com.toedter.calendar.JDateChooser();
        btnSearchWorker = new javax.swing.JButton();
        btnChooseWorker = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblIdleWorker = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        txtAssetIDMachine2 = new javax.swing.JTextField();
        txtTypeMachine2 = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        txtPreviousFactoryMachine2 = new javax.swing.JTextField();
        txtPreviousLocationMachine2 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        ddFactoryMachine2 = new javax.swing.JComboBox<>();
        ddLocationMachine2 = new javax.swing.JComboBox<>();
        btnAssignWorker = new javax.swing.JButton();
        btnRemoveWorker = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblAssignWorker = new javax.swing.JTable();
        ddStyleNoM6 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        ddOperationAssignWorker = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel59 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        ddStyleNoM7 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        ddMachine1 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        ddStyleNoM8 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        ddType1 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtSubject = new javax.swing.JTextField();
        jScrollPane21 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jLabel96 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel97 = new javax.swing.JLabel();
        txtReceiver = new javax.swing.JTextField();
        btnSendMail = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        validationPanelSendMail = new org.netbeans.validation.api.ui.swing.ValidationPanel();

        setTitle("Style Planning And Resource Allocation Module");

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Style"));

        jLabel1.setText("StyleNo");

        jLabel2.setText("Buyer");

        jLabel3.setText("Prototype");

        jLabel4.setText("Factory");

        ddFactory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        jLabel5.setText("Location");

        ddLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        jLabel6.setText("Start Date");

        jLabel7.setText("End Date");

        txtStartDate.setDateFormatString("yyyy-MM-dd");

        txtEndDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(ddLocation, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ddFactory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrototype, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBuyer, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtStyleNo, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStyleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrototype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ddFactory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Style Summary"));

        tblStyle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStyle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStyleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStyle);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnDemoStyle.setText("Demo");
        btnDemoStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoStyleActionPerformed(evt);
            }
        });

        btnRefreshStyle.setText("Refresh");
        btnRefreshStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStyleActionPerformed(evt);
            }
        });

        txtSearchStyleByBuyer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchStyleByBuyerKeyPressed(evt);
            }
        });

        jLabel91.setText("Search By buyer");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnDemoStyle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshStyle))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validationPanelNewStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchStyleByBuyer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchStyleByBuyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91))
                        .addGap(18, 18, 18)
                        .addComponent(validationPanelNewStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSubmit)
                    .addComponent(btnRemove)
                    .addComponent(btnDemoStyle)
                    .addComponent(btnRefreshStyle))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("New Style", jPanel9);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity"));

        jLabel8.setText("StyleNo");

        jLabel9.setText("Purchase Order No");

        jLabel10.setText("Size");

        jLabel11.setText("Color");

        jLabel12.setText("Quantity");

        ddSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XXXL", "XXL", "XL", "L", "M", "S", "XS", "XXS" }));

        jLabel13.setText("Remarks");

        txtRemarksQ.setColumns(20);
        txtRemarksQ.setRows(5);
        jScrollPane2.setViewportView(txtRemarksQ);

        ddColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "White", "Pumice", "Silver", "Baltic", "Berry", "Grey", "Taupe Mix", "Grey Zipper", "Cedar", "Ginger" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(39, 39, 39)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ddSize, 0, 106, Short.MAX_VALUE)
                    .addComponent(txtPurchaceOrderNo)
                    .addComponent(ddStyleNoM2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuantityQ)
                    .addComponent(ddColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ddStyleNoM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPurchaceOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ddSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ddColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtQuantityQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity Summary"));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOrder);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(validationPanelAddQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(validationPanelAddQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnUpdateQ.setText("Update");
        btnUpdateQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQActionPerformed(evt);
            }
        });

        btnSubmitQ.setText("Submit");
        btnSubmitQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitQActionPerformed(evt);
            }
        });

        btnRemoveQ.setText("Remove");
        btnRemoveQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveQActionPerformed(evt);
            }
        });

        jButton1.setText("Demo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRefreshPurchaseOrder.setText("Refresh");
        btnRefreshPurchaseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPurchaseOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnUpdateQ)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmitQ)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveQ)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(btnRefreshPurchaseOrder))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateQ)
                    .addComponent(btnSubmitQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveQ)
                    .addComponent(jButton1)
                    .addComponent(btnRefreshPurchaseOrder))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Quantity", jPanel10);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Man Power Registrstation"));

        jLabel26.setText("Style");

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Budgeted Cadre"));

        jLabel27.setText("Direct");

        jLabel28.setText("Indirect");

        jLabel29.setText("Total");

        txtDirectE.setEditable(false);
        txtDirectE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirectEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirectEKeyTyped(evt);
            }
        });

        txtIndirectE.setEditable(false);

        txtTotalE.setEditable(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDirectE, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(txtIndirectE)
                    .addComponent(txtTotalE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtDirectE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIndirectE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtTotalE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel30.setText("Direct");

        jLabel31.setText("Indirect");

        jLabel32.setText("Total");

        txtDirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirectActionPerformed(evt);
            }
        });
        txtDirect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirectKeyTyped(evt);
            }
        });

        txtIndirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectActionPerformed(evt);
            }
        });
        txtIndirect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndirectKeyTyped(evt);
            }
        });

        txtTotal.setEditable(false);

        btnUpdateMan.setText("Update");
        btnUpdateMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateManActionPerformed(evt);
            }
        });

        btnSubmitMan.setText("Submit");
        btnSubmitMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitManActionPerformed(evt);
            }
        });

        btnRemoveMan.setText("Remove");
        btnRemoveMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveManActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDirect, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(txtIndirect)
                                    .addComponent(txtTotal)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(51, 51, 51)
                                .addComponent(ddStyleNoM, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(btnUpdateMan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubmitMan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveMan)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(ddStyleNoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtDirect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(txtIndirect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateMan)
                    .addComponent(btnSubmitMan)
                    .addComponent(btnRemoveMan))
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Allocation Summary"));

        tblManPower.setModel(new javax.swing.table.DefaultTableModel(
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
        tblManPower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManPowerMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblManPower);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblerrorManPower.setForeground(new java.awt.Color(255, 51, 51));

        btnRefreshManPower.setText("Refresh");
        btnRefreshManPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshManPowerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnRefreshManPower)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerrorManPower))
                    .addComponent(validationPanelManPower, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(validationPanelManPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblerrorManPower))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnRefreshManPower)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Man Power Allocation", jPanel11);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Material"));

        jLabel38.setText("StyleNo");

        jLabel39.setText("Material Allocation  No");

        jLabel40.setText("Type");

        jLabel41.setText("Color");

        jLabel42.setText("Quantity(Yards)");

        ddType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wool Fabric", "Cotton Fabric", "Silk Fabric", "Nylon Fabric" }));

        jLabel43.setText("Remarks");

        txtRemarksMaterial.setColumns(20);
        txtRemarksMaterial.setRows(5);
        jScrollPane7.setViewportView(txtRemarksMaterial);

        ddColorMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "White", "Pumice", "Silver", "Baltic", "Berry", "Grey", "Taupe Mix", "Grey Zipper", "Cedar", "Ginger" }));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ddType, 0, 129, Short.MAX_VALUE)
                    .addComponent(txtMaterialAllocationNo)
                    .addComponent(ddStyleNoM1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuantityMaterial)
                    .addComponent(ddColorMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(ddStyleNoM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtMaterialAllocationNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(ddType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(ddColorMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtQuantityMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity Summary"));

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMaterial);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnUpdateMaterial.setText("Update");
        btnUpdateMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMaterialActionPerformed(evt);
            }
        });

        btnSubmitQ1.setText("Submit");
        btnSubmitQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitQ1ActionPerformed(evt);
            }
        });

        btnRemoveMaterial.setText("Remove");
        btnRemoveMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMaterialActionPerformed(evt);
            }
        });

        jButton3.setText("Demo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnRefreshPurchaseOrder1.setText("Refresh");
        btnRefreshPurchaseOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPurchaseOrder1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(validationPanelAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnUpdateMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmitQ1)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshPurchaseOrder1)
                        .addGap(0, 729, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(validationPanelAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateMaterial)
                    .addComponent(btnSubmitQ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveMaterial)
                    .addComponent(jButton3)
                    .addComponent(btnRefreshPurchaseOrder1))
                .addGap(18, 18, 18))
        );

        jTabbedPane2.addTab("Material Allocation", jPanel12);

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Machine"));

        jLabel44.setText("StyleNo");

        jLabel45.setText("Operation  No");

        jLabel46.setText("Type");

        jLabel47.setText("Machine");

        jLabel48.setText("Quantity");

        ddOperationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tack Lable", "Bundle & sort", "Sew loop", "Measure & cut loop", "Mark elastic(back center & side seam)", "Join waist band", "Tack fly box Ovl thread edge", "Fold & iron waist band", "Sew waist band corner with use pattern", "Fuse front pkt mouth", "Attach bottom pocket facing to pocket bag", "Sew side seam" }));

        jLabel49.setText("Remarks");

        txtRemarksOperation.setColumns(20);
        txtRemarksOperation.setRows(5);
        jScrollPane9.setViewportView(txtRemarksOperation);

        ddMachine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Needle", "5 Thread Overlock", "Overlock", "Pearl Stitch", "Iron", "Flat Lock" }));
        ddMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddMachineMouseClicked(evt);
            }
        });
        ddMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddMachineActionPerformed(evt);
            }
        });

        jLabel33.setText("Speciality");

        ddSpeciality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Without Lights", "With Light", "Extra Table" }));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOperationMachineQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(ddMachine, 0, 129, Short.MAX_VALUE)
                            .addComponent(ddOperationType, 0, 129, Short.MAX_VALUE)
                            .addComponent(txtOperationNo, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(ddStyleNoM3, 0, 129, Short.MAX_VALUE)
                            .addComponent(ddSpeciality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(ddStyleNoM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtOperationNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(ddOperationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(ddMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtOperationMachineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(ddSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity Summary"));

        tblOperation.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOperation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOperationMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblOperation);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnUpdateOperation.setText("Update");
        btnUpdateOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOperationActionPerformed(evt);
            }
        });

        btnSubmitOperation.setText("Submit");
        btnSubmitOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitOperationActionPerformed(evt);
            }
        });

        btnRemoveOperation.setText("Remove");
        btnRemoveOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOperationActionPerformed(evt);
            }
        });

        jButton4.setText("Demo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnRefreshOperation.setText("Refresh");
        btnRefreshOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshOperationActionPerformed(evt);
            }
        });

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("SMV"));

        jLabel34.setText("M/C");

        jLabel50.setText("M/A");

        txtMC.setEditable(false);

        txtMA.setEditable(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel50))
                .addGap(36, 36, 36)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMA, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(txtMC))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(validationPanelAddOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 205, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnUpdateOperation)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmitOperation)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveOperation)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshOperation)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(validationPanelAddOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateOperation)
                    .addComponent(btnSubmitOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveOperation)
                    .addComponent(jButton4)
                    .addComponent(btnRefreshOperation))
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Operation Breakdown", jPanel13);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Budgeted Cadre"));

        jLabel35.setText("Direct");

        jLabel36.setText("Indirect");

        jLabel37.setText("Total");

        txtDirectE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirectE1ActionPerformed(evt);
            }
        });
        txtDirectE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirectE1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirectE1KeyTyped(evt);
            }
        });

        txtIndirectE1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtIndirectE1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtIndirectE1InputMethodTextChanged(evt);
            }
        });
        txtIndirectE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectE1ActionPerformed(evt);
            }
        });
        txtIndirectE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndirectE1KeyTyped(evt);
            }
        });

        txtTotalE1.setEditable(false);
        txtTotalE1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalE1FocusGained(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDirectE1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(txtIndirectE1)
                        .addComponent(txtTotalE1)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtDirectE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIndirectE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtTotalE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationAddCadre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(validationAddCadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(647, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Enter Budgeted Cadre", jPanel27);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Style Registration", jPanel2);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Selection Criteria"));

        jLabel51.setText("Factory");

        jLabel52.setText("Location");

        jLabel53.setText("Date");

        ddFactoryDiff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationDiff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        txtSearchDateDiff.setDateFormatString("YYYY-MM-dd");

        btnSearchDiff.setText("Search");
        btnSearchDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDiffActionPerformed(evt);
            }
        });

        btnRefreshDiff.setText("Refresh");
        btnRefreshDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshDiffActionPerformed(evt);
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
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchDateDiff, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(ddLocationDiff, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ddFactoryDiff, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(btnSearchDiff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshDiff)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(ddFactoryDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(ddLocationDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(txtSearchDateDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchDiff)
                    .addComponent(btnRefreshDiff))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Style Details"));

        jLabel54.setText("Style No");

        jLabel55.setText("Start Date");

        jLabel56.setText("End Date");

        txtCurrentStyleNo.setEditable(false);

        jLabel57.setText("Current Style");

        jLabel58.setText("Next Style");

        txtNextStyle.setEditable(false);

        txtCurrentStartDate.setEditable(false);

        txtNextStyleStartDate.setEditable(false);

        txtCurrentEndDate.setEditable(false);
        txtCurrentEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentEndDateActionPerformed(evt);
            }
        });

        txtNextStyleEndDate.setEditable(false);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(25, 25, 25)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCurrentStyleNo)
                    .addComponent(txtCurrentEndDate)
                    .addComponent(txtCurrentStartDate))
                .addGap(29, 29, 29)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel58)
                    .addComponent(txtNextStyle, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(txtNextStyleStartDate)
                    .addComponent(txtNextStyleEndDate))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtCurrentStyleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNextStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtCurrentStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNextStyleStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtCurrentEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNextStyleEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPearlStitch.setEditable(false);
        txtPearlStitch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPearlStitch.setText("Pearl Stitch");

        txtSingleNeedle.setEditable(false);
        txtSingleNeedle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSingleNeedle.setText("Single Needle");

        txt5ThreadOverlock.setEditable(false);
        txt5ThreadOverlock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5ThreadOverlock.setText("Thread Overlock");
        txt5ThreadOverlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ThreadOverlockActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Current Style");

        jTextField6.setEditable(false);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Next Style");

        jTextField7.setEditable(false);
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Difference");

        txtIron.setEditable(false);
        txtIron.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIron.setText("Iron");

        txtOverlock.setEditable(false);
        txtOverlock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOverlock.setText("Overlock");

        jLabel59.setText("Total Difference");

        txtTotalMachineDifference.setEditable(false);

        btnSaveMachineDiff.setText("Save");
        btnSaveMachineDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMachineDiffActionPerformed(evt);
            }
        });

        txtFlatLock.setEditable(false);
        txtFlatLock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFlatLock.setText("Flat Lock");

        txtSingleNeedleC.setEditable(false);
        txtSingleNeedleC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt5ThreadOverlockC.setEditable(false);
        txt5ThreadOverlockC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5ThreadOverlockC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ThreadOverlockCActionPerformed(evt);
            }
        });

        txtFlatLockC.setEditable(false);
        txtFlatLockC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPearlStitchC.setEditable(false);
        txtPearlStitchC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIronC.setEditable(false);
        txtIronC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtOverlockC.setEditable(false);
        txtOverlockC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSingleNeedleN.setEditable(false);
        txtSingleNeedleN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt5ThreadOverlockN.setEditable(false);
        txt5ThreadOverlockN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5ThreadOverlockN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ThreadOverlockNActionPerformed(evt);
            }
        });

        txtFlatLockN.setEditable(false);
        txtFlatLockN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPearlStitchN.setEditable(false);
        txtPearlStitchN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIronN.setEditable(false);
        txtIronN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtOverlockN.setEditable(false);
        txtOverlockN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSingleNeedleD.setEditable(false);
        txtSingleNeedleD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt5ThreadOverlockD.setEditable(false);
        txt5ThreadOverlockD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5ThreadOverlockD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ThreadOverlockDActionPerformed(evt);
            }
        });

        txtFlatLockD.setEditable(false);
        txtFlatLockD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFlatLockD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlatLockDActionPerformed(evt);
            }
        });

        txtPearlStitchD.setEditable(false);
        txtPearlStitchD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIronD.setEditable(false);
        txtIronD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtOverlockD.setEditable(false);
        txtOverlockD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel62.setText("Status");

        chkStatusMachine.setText("True");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMachineDifference, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(chkStatusMachine))
                    .addComponent(btnSaveMachineDiff)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(txtSingleNeedleN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5ThreadOverlockN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlatLockN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPearlStitchN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIronN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOverlockN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(txtSingleNeedleD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5ThreadOverlockD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlatLockD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPearlStitchD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIronD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOverlockD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(txtSingleNeedleC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5ThreadOverlockC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlatLockC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPearlStitchC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIronC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOverlockC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                .addComponent(txtSingleNeedle, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5ThreadOverlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlatLock, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPearlStitch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIron, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOverlock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPearlStitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSingleNeedle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5ThreadOverlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFlatLock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOverlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPearlStitchC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSingleNeedleC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt5ThreadOverlockC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFlatLockC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIronC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOverlockC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPearlStitchN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSingleNeedleN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt5ThreadOverlockN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFlatLockN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIronN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOverlockN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPearlStitchD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSingleNeedleD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt5ThreadOverlockD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFlatLockD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIronD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOverlockD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtTotalMachineDifference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(chkStatusMachine))
                .addGap(18, 18, 18)
                .addComponent(btnSaveMachineDiff)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Machine Difference", jPanel37);

        jTextField21.setEditable(false);
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDirectDiff.setEditable(false);
        txtDirectDiff.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirectDiff.setText("Direct");

        txtIndirectDiff.setEditable(false);
        txtIndirectDiff.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndirectDiff.setText("Indirect");
        txtIndirectDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectDiffActionPerformed(evt);
            }
        });

        jTextField25.setEditable(false);
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText("Current Style");

        jTextField26.setEditable(false);
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setText("Next Style");

        jTextField27.setEditable(false);
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setText("Difference");

        jLabel61.setText("Total Difference");

        txtTotalManPowerDifference.setEditable(false);

        btnSaveManPowerDiff.setText("Save");
        btnSaveManPowerDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveManPowerDiffActionPerformed(evt);
            }
        });

        txtDirectC.setEditable(false);
        txtDirectC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIndirectC.setEditable(false);
        txtIndirectC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndirectC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectCActionPerformed(evt);
            }
        });

        txtDirectN.setEditable(false);
        txtDirectN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIndirectN.setEditable(false);
        txtIndirectN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndirectN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectNActionPerformed(evt);
            }
        });

        txtDirectD.setEditable(false);
        txtDirectD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIndirectD.setEditable(false);
        txtIndirectD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndirectD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirectDActionPerformed(evt);
            }
        });

        jLabel63.setText("Status");

        chkStatusManPower.setText("True");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalManPowerDifference, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel63)
                        .addGap(18, 18, 18)
                        .addComponent(chkStatusManPower))
                    .addComponent(btnSaveManPowerDiff)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField21)
                            .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField27, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtDirectDiff, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIndirectDiff, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addComponent(txtDirectN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIndirectN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addComponent(txtDirectC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIndirectC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                        .addComponent(txtDirectD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIndirectD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirectDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndirectDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirectC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndirectC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirectN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndirectN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirectD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndirectD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(chkStatusManPower))
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(txtTotalManPowerDifference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSaveManPowerDiff)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Man Power Difference", jPanel38);

        jTextField10.setEditable(false);
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField11.setEditable(false);
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("Nylon F");

        jTextField12.setEditable(false);
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("Wool F");

        jTextField13.setEditable(false);
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("Silk F");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.setEditable(false);
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("Current Style");

        jTextField15.setEditable(false);
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("Next Style");

        jTextField16.setEditable(false);
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("Difference");

        jLabel60.setText("Total Difference");

        txtTotalMaterialDifference.setEditable(false);

        btnSaveMaterialDiff.setText("Save");
        btnSaveMaterialDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMaterialDiffActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("Cotton F");

        txtWoolFabricC.setEditable(false);
        txtWoolFabricC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSilkFabricC.setEditable(false);
        txtSilkFabricC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSilkFabricC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSilkFabricCActionPerformed(evt);
            }
        });

        txtCottonFabricC.setEditable(false);
        txtCottonFabricC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNylonFabricC.setEditable(false);
        txtNylonFabricC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtWoolFabricN.setEditable(false);
        txtWoolFabricN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSilkFabricsN.setEditable(false);
        txtSilkFabricsN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSilkFabricsN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSilkFabricsNActionPerformed(evt);
            }
        });

        txtCottonFabricN.setEditable(false);
        txtCottonFabricN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNylonFabricN.setEditable(false);
        txtNylonFabricN.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtWoolFabricD.setEditable(false);
        txtWoolFabricD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSilkFabricD.setEditable(false);
        txtSilkFabricD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSilkFabricD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSilkFabricDActionPerformed(evt);
            }
        });

        txtCottonFabricD.setEditable(false);
        txtCottonFabricD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCottonFabricD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCottonFabricDActionPerformed(evt);
            }
        });

        txtNylonFabricsD.setEditable(false);
        txtNylonFabricsD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel64.setText("Status");

        chkStatusMaterial.setText("True");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMaterialDifference, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(chkStatusMaterial))
                    .addComponent(btnSaveMaterialDiff)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField10)
                            .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(txtWoolFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSilkFabricsN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCottonFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNylonFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(txtWoolFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSilkFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCottonFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNylonFabricsD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel41Layout.createSequentialGroup()
                                        .addComponent(txtWoolFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSilkFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addComponent(txtCottonFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNylonFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)))))))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNylonFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWoolFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSilkFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCottonFabricC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNylonFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWoolFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSilkFabricsN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCottonFabricN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNylonFabricsD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWoolFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSilkFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCottonFabricD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel64)
                        .addComponent(chkStatusMaterial))
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(txtTotalMaterialDifference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSaveMaterialDiff)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Material Difference", jPanel39);

        tblMachineDiff.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(tblMachineDiff);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel46);

        btnDeleteMachineDiff.setText("Delete");
        btnDeleteMachineDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMachineDiffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteMachineDiff)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(btnDeleteMachineDiff)
                        .addGap(0, 241, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("View Machine Difference", jPanel6);

        tblManPowerDiff.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(tblManPowerDiff);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane13.setViewportView(jPanel49);

        btnDeleteManPowerDiff.setText("Delete");
        btnDeleteManPowerDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteManPowerDiffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteManPowerDiff)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(btnDeleteManPowerDiff)
                        .addGap(0, 241, Short.MAX_VALUE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("View Man Power Difference ", jPanel43);

        tblMaterialDiff.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(tblMaterialDiff);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane15.setViewportView(jPanel52);

        btnDeleteMaterialDiff.setText("Delete");
        btnDeleteMaterialDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMaterialDiffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteMaterialDiff)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(btnDeleteMaterialDiff)
                        .addGap(0, 241, Short.MAX_VALUE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("View Material Difference", jPanel44);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Style Resource Difference", jPanel3);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Idle Machines"));

        jLabel14.setText("Factory");

        jLabel15.setText("Location");

        jLabel16.setText("Ownership");

        jLabel17.setText("Date");

        ddFactoryIdleSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationIdleSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        ddOwnershipIdleSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rent", "Company Owned" }));

        txtSearchIdleSearch.setDateFormatString("yyyy-MM-dd");

        btnSearchMachine.setText("Search");
        btnSearchMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMachineActionPerformed(evt);
            }
        });

        btnChooseMachine.setText("Choose");
        btnChooseMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseMachineActionPerformed(evt);
            }
        });

        tblIdleMachines.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblIdleMachines);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ddOwnershipIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddLocationIdleSearch, 0, 91, Short.MAX_VALUE)
                            .addComponent(ddFactoryIdleSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(34, 34, 34)
                        .addComponent(txtSearchIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnChooseMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ddFactoryIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(ddLocationIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchMachine)))
                            .addComponent(txtSearchIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ddOwnershipIdleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChooseMachine)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign machine"));

        jLabel18.setText("AssetID");

        jLabel19.setText("Type");

        jLabel20.setText("Ownership");

        jLabel21.setText("Previous Factory");

        jLabel22.setText("Previous Location");

        txtAssetIDMachine.setEditable(false);

        txtTypeMachine.setEditable(false);

        txtOwnership.setEditable(false);

        txtPreviousFactoryMachine.setEditable(false);

        txtPreviousLocationMachine.setEditable(false);

        jLabel23.setText("New Factory");

        jLabel24.setText("New Location");

        jLabel25.setText("StyleNo");

        ddFactoryMachine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationMachine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        btnAssignMachine.setText("Assign");
        btnAssignMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignMachineActionPerformed(evt);
            }
        });

        btnRemoveMachine.setText("Remove");
        btnRemoveMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMachineActionPerformed(evt);
            }
        });

        tblAssignMachine.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblAssignMachine);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAssetIDMachine, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(txtTypeMachine)
                            .addComponent(txtOwnership)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreviousLocationMachine)
                            .addComponent(txtPreviousFactoryMachine))))
                .addGap(26, 26, 26)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(btnAssignMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ddFactoryMachine, 0, 100, Short.MAX_VALUE)
                    .addComponent(ddLocationMachine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddStyleNoM4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtAssetIDMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(ddFactoryMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTypeMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(ddLocationMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(txtOwnership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))
                            .addComponent(ddStyleNoM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtPreviousFactoryMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAssignMachine)
                            .addComponent(btnRemoveMachine))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtPreviousLocationMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Machine Allocation", jPanel18);

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Materials"));

        jLabel65.setText("Factory");

        jLabel66.setText("Location");

        jLabel68.setText("Date");

        ddFactoryIdleSearch1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationIdleSearch1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        txtSearchIdleSearch1.setDateFormatString("yyyy-MM-dd");

        btnSearchMaterial.setText("Search");
        btnSearchMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMaterialActionPerformed(evt);
            }
        });

        btnChooseMaterial.setText("Choose");
        btnChooseMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseMaterialActionPerformed(evt);
            }
        });

        tblIdleMaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(tblIdleMaterial);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddLocationIdleSearch1, 0, 91, Short.MAX_VALUE)
                            .addComponent(ddFactoryIdleSearch1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68))
                    .addComponent(validationPanelMaterialAllocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChooseMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchIdleSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel54Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel54Layout.createSequentialGroup()
                                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65)
                                    .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ddFactoryIdleSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel68)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchMaterial)
                                    .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel66)
                                        .addComponent(ddLocationIdleSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtSearchIdleSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnChooseMaterial)
                            .addComponent(validationPanelMaterialAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign material"));

        jLabel69.setText("AssetID");

        jLabel70.setText("Type");

        jLabel71.setText("Previous Quantity");

        jLabel72.setText("Previous Factory");

        jLabel73.setText("Previous Location");

        txtAssetIDMachine1.setEditable(false);

        txtTypeMachine1.setEditable(false);

        txtPreviousQuantity.setEditable(false);

        txtPreviousFactoryMachine1.setEditable(false);

        txtPreviousLocationMachine1.setEditable(false);

        jLabel74.setText("New Factory");

        jLabel75.setText("New Location");

        jLabel76.setText("StyleNo");

        ddFactoryMachine1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationMachine1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        btnAssignMaterial.setText("Assign");
        btnAssignMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignMaterialActionPerformed(evt);
            }
        });

        btnRemoveAssignedMaterial.setText("Remove");
        btnRemoveAssignedMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAssignedMaterialActionPerformed(evt);
            }
        });

        tblAssignMaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(tblAssignMaterial);

        jLabel67.setText("Qunatity");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTypeMachine1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txtAssetIDMachine1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreviousQuantity)))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreviousLocationMachine1)
                            .addComponent(txtPreviousFactoryMachine1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAssignMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoveAssignedMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel74)
                            .addComponent(jLabel76)
                            .addComponent(jLabel67))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddLocationMachine1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ddFactoryMachine1, 0, 92, Short.MAX_VALUE)
                            .addComponent(ddStyleNoM5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantityAssigned))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(txtAssetIDMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74)
                            .addComponent(ddFactoryMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70)
                            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTypeMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel75)
                                .addComponent(ddLocationMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(txtPreviousQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addComponent(ddStyleNoM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(txtPreviousFactoryMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67)
                            .addComponent(txtQuantityAssigned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txtPreviousLocationMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignMaterial)
                    .addComponent(btnRemoveAssignedMaterial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Material Allocation", jPanel19);

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder("Idle Workers"));

        jLabel77.setText("Factory");

        jLabel78.setText("Location");

        jLabel79.setText("Type");

        jLabel80.setText("Date");

        ddFactoryIdleSearch2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationIdleSearch2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        ddTypeIdleWorker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Worker", "Manager" }));

        txtSearchIdleSearch2.setDateFormatString("yyyy-MM-dd");

        btnSearchWorker.setText("Search");
        btnSearchWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchWorkerActionPerformed(evt);
            }
        });

        btnChooseWorker.setText("Choose");
        btnChooseWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseWorkerActionPerformed(evt);
            }
        });

        tblIdleWorker.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(tblIdleWorker);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ddTypeIdleWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddLocationIdleSearch2, 0, 91, Short.MAX_VALUE)
                            .addComponent(ddFactoryIdleSearch2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addGap(34, 34, 34)
                        .addComponent(txtSearchIdleSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnChooseWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel77)
                                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ddFactoryIdleSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel80)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel78)
                                    .addComponent(ddLocationIdleSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchWorker)))
                            .addComponent(txtSearchIdleSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ddTypeIdleWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChooseWorker))))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign Worker"));

        jLabel81.setText("AssetID");

        jLabel82.setText("Type");

        jLabel83.setText("Name");

        jLabel84.setText("Previous Factory");

        jLabel85.setText("Previous Location");

        txtAssetIDMachine2.setEditable(false);

        txtTypeMachine2.setEditable(false);

        txtEmployeeName.setEditable(false);

        txtPreviousFactoryMachine2.setEditable(false);

        txtPreviousLocationMachine2.setEditable(false);

        jLabel86.setText("New Factory");

        jLabel87.setText("New Location");

        jLabel88.setText("StyleNo");

        ddFactoryMachine2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VTW", "TGK", "TGZ", "VTH" }));

        ddLocationMachine2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "Sample" }));

        btnAssignWorker.setText("Assign");
        btnAssignWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignWorkerActionPerformed(evt);
            }
        });

        btnRemoveWorker.setText("Remove");
        btnRemoveWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveWorkerActionPerformed(evt);
            }
        });

        tblAssignWorker.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(tblAssignWorker);

        jLabel89.setText("Operation");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAssetIDMachine2)
                            .addComponent(txtTypeMachine2)
                            .addComponent(txtEmployeeName)))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreviousLocationMachine2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txtPreviousFactoryMachine2))))
                .addGap(26, 26, 26)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88)
                    .addComponent(btnAssignWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addGap(18, 18, 18)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ddOperationAssignWorker, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddStyleNoM6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddLocationMachine2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddFactoryMachine2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveWorker, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(txtAssetIDMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86)
                            .addComponent(ddFactoryMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTypeMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel87)
                                .addComponent(ddLocationMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel83)
                                .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel88))
                            .addComponent(ddStyleNoM6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(txtPreviousFactoryMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89)
                            .addComponent(ddOperationAssignWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(txtPreviousLocationMachine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAssignWorker)
                            .addComponent(btnRemoveWorker))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Worker Allocation", jPanel20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Resource Allocation", jPanel4);

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel90.setText("Style No");

        jButton6.setText("Generate Full Style Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Generate Style Report ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel90)
                .addGap(73, 73, 73)
                .addComponent(ddStyleNoM7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap(639, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(ddStyleNoM7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Style", jPanel59);

        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder("Machine Allocation Reports"));

        jLabel98.setText("Machine Type");

        ddMachine1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Needle", "5 Thread Overlock", "Overlock", "Pearl Stitch", "Iron", "Flat Lock" }));
        ddMachine1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddMachine1MouseClicked(evt);
            }
        });
        ddMachine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddMachine1ActionPerformed(evt);
            }
        });

        jButton8.setText("Generate Report");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel98)
                .addGap(18, 18, 18)
                .addComponent(ddMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(639, 639, 639))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(ddMachine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel99.setText("Style No");

        jButton9.setText("Generate Full Report");

        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder("Material Allocation Reports"));

        jLabel100.setText("Material Type");

        ddType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wool Fabric", "Cotton Fabric", "Silk Fabric", "Nylon Fabric" }));

        jButton10.setText("Generate Report");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel100)
                .addGap(18, 18, 18)
                .addComponent(ddType1, 0, 129, Short.MAX_VALUE)
                .addGap(123, 123, 123)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(640, 640, 640))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(ddType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel99)
                        .addGap(40, 40, 40)
                        .addComponent(ddStyleNoM8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(ddStyleNoM8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Resource Allocation", jPanel58);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Reports", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Send Mail"));

        jLabel92.setText("Username");

        jLabel93.setText("Password");

        jLabel94.setText("Message");

        jLabel95.setText("Subject");

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane21.setViewportView(txtMessage);

        jLabel96.setText("Attachment");

        jLabel97.setText("To");

        txtReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiverActionPerformed(evt);
            }
        });

        btnSendMail.setText("Send Mail");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        jButton7.setText("Demo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93)
                    .addComponent(jLabel95)
                    .addComponent(jLabel94)
                    .addComponent(jLabel97))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSendMail)
                        .addGap(39, 39, 39)
                        .addComponent(jButton7)
                        .addGap(131, 131, 131)
                        .addComponent(validationPanelSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtReceiver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSubject, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel96))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel94)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendMail)
                    .addComponent(jButton7)
                    .addComponent(validationPanelSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Send Email ", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(383, 383, 383))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCottonFabricDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCottonFabricDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCottonFabricDActionPerformed

    private void txtSilkFabricDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSilkFabricDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSilkFabricDActionPerformed

    private void txtSilkFabricsNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSilkFabricsNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSilkFabricsNActionPerformed

    private void txtSilkFabricCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSilkFabricCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSilkFabricCActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void txtIndirectDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndirectDActionPerformed

    private void txtIndirectNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndirectNActionPerformed

    private void txtIndirectCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndirectCActionPerformed

    private void txtIndirectDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectDiffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndirectDiffActionPerformed

    private void txtFlatLockDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlatLockDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlatLockDActionPerformed

    private void txt5ThreadOverlockDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ThreadOverlockDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ThreadOverlockDActionPerformed

    private void txt5ThreadOverlockNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ThreadOverlockNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ThreadOverlockNActionPerformed

    private void txt5ThreadOverlockCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ThreadOverlockCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ThreadOverlockCActionPerformed

    private void btnSaveMachineDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMachineDiffActionPerformed
        try{
        if (txtCurrentStyleNo.getText().equals("") || txtNextStyle.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Search Before Saving !!!");

        } else {

            boolean status=chkStatusMachine.isSelected();
            if(status){
            
            so.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so.setMachine(txtSingleNeedle.getText());
            so.setDifference(Integer.parseInt(txtSingleNeedleD.getText()));

            StyleOperation so1=new StyleOperation();
            so1.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so1.setMachine(txt5ThreadOverlock.getText());
            so1.setDifference(Integer.parseInt(txt5ThreadOverlockD.getText()));
            
            StyleOperation so2=new StyleOperation();
            so2.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so2.setMachine(txtFlatLock.getText());
            so2.setDifference(Integer.parseInt(txtFlatLockD.getText()));
            
            StyleOperation so3=new StyleOperation();
            so3.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so3.setMachine(txtPearlStitch.getText());
            so3.setDifference(Integer.parseInt(txtPearlStitchD.getText()));
            
            /*
            StyleOperation so4=new StyleOperation();
            so4.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so4.setMachine(txtIron.getText());
            so4.setDifference(Integer.parseInt(txtIronD.getText()));
            
            StyleOperation so5=new StyleOperation();
            so5.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
            so5.setMachine(txtOverlock.getText());
            so5.setDifference(Integer.parseInt(txtOverlockD.getText()));
            
            System.out.println(so5.getStyleNo());
            System.out.println(so5.getMachine());
            System.out.println(so5.getDifference());
*/
            if (dbOps.addMachineDifference(so,so1,so2,so3,status)) {

                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsMachineDifference();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }
            }else{
                JOptionPane.showMessageDialog(this, "Rejected Successfully !!!");
                clearFieldsMachineDifference();
            }
        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSaveMachineDiffActionPerformed

    private void txt5ThreadOverlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ThreadOverlockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ThreadOverlockActionPerformed

    private void txtCurrentEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentEndDateActionPerformed

    private void btnSearchDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDiffActionPerformed
        try{
        if (ddFactoryDiff.getSelectedItem().toString().equals("") || ddLocationDiff.getSelectedItem().toString().equals("") || ((JTextField) txtStartDate.getDateEditor().getUiComponent()).getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill Required Fields !!!");

        } else {

            s.setFactory(ddFactoryDiff.getSelectedItem().toString());
            s.setLocation(ddLocationDiff.getSelectedItem().toString());
            s.setSearchDate(((JTextField) txtSearchDateDiff.getDateEditor().getUiComponent()).getText());

            Style currentStyle = dbOps.getCurrentStyleObject(s);
            if (currentStyle == null) {
                JOptionPane.showMessageDialog(this, "Their is no style running for given criterias !!!");
            } else {
                txtCurrentStyleNo.setText(Integer.toString(currentStyle.getStyleNo()));
                txtCurrentStartDate.setText(currentStyle.getStartDate());
                txtCurrentEndDate.setText(currentStyle.getEndDate());

            }
            Style sn = new Style();
            sn.setFactory(s.getFactory());
            sn.setLocation(s.getLocation());
            sn.setSearchDate(currentStyle.getEndDate());
            DBOperationStylePlanning dbOpsn = new DBOperationStylePlanning();
            Style NextStyle = dbOpsn.getNextStyleObject(sn);
            if (NextStyle == null) {
                JOptionPane.showMessageDialog(this, "Their is no Next style running for given criterias !!!");
            } else {
                txtNextStyleStartDate.setText(NextStyle.getStartDate());
                txtNextStyleEndDate.setText(NextStyle.getEndDate());
                txtNextStyle.setText(Integer.toString(NextStyle.getStyleNo()));
            }

            int cSingleNeedle = dbOps.getMachineAmount("Single needle", currentStyle);
            txtSingleNeedleC.setText(Integer.toString(cSingleNeedle));

            int c5ThreadOverclock = dbOps.getMachineAmount("5 Thread overlock", currentStyle);
            txt5ThreadOverlockC.setText(Integer.toString(c5ThreadOverclock));

            int cFlatLock = dbOps.getMachineAmount("Flat lock", currentStyle);
            txtFlatLockC.setText(Integer.toString(cFlatLock));

            int cPearlSnitch = dbOps.getMachineAmount("Pearl stitch", currentStyle);
            txtPearlStitchC.setText(Integer.toString(cPearlSnitch));
            
             int cIron = dbOps.getMachineAmount("Iron", currentStyle);
            txtIronC.setText(Integer.toString(cIron));

            int cOverlock = dbOps.getMachineAmount("Overlock", currentStyle);
            txtOverlockC.setText(Integer.toString(cOverlock));

            int nSingleNeedle = dbOps.getMachineAmount("Single needle", NextStyle);
            txtSingleNeedleN.setText(Integer.toString(nSingleNeedle));

            int n5ThreadOverclock = dbOps.getMachineAmount("5 Thread overlock", NextStyle);
            txt5ThreadOverlockN.setText(Integer.toString(n5ThreadOverclock));

            int nFlatLock = dbOps.getMachineAmount("Flat lock", NextStyle);
            txtFlatLockN.setText(Integer.toString(nFlatLock));
            
            int nIron = dbOps.getMachineAmount("Iron", NextStyle);
            txtIronN.setText(Integer.toString(nIron));

            int nOverlock = dbOps.getMachineAmount("Overlock", NextStyle);
            txtOverlockN.setText(Integer.toString(nOverlock));

            int nPearlSnitch = dbOps.getMachineAmount("Pearl stitch", NextStyle);
            txtPearlStitchN.setText(Integer.toString(nPearlSnitch));

            int dSingleNeedle = cSingleNeedle - nSingleNeedle;
            txtSingleNeedleD.setText(Integer.toString(dSingleNeedle));

            int d5ThreadOverclock = c5ThreadOverclock - n5ThreadOverclock;
            txt5ThreadOverlockD.setText(Integer.toString(d5ThreadOverclock));

            int dFlatLock = cFlatLock - nFlatLock;
            txtFlatLockD.setText(Integer.toString(dFlatLock));

            int dPearlSnitch = cPearlSnitch - nPearlSnitch;
            txtPearlStitchD.setText(Integer.toString(dPearlSnitch));
            
            int dIron = cIron-nIron;
            txtIronD.setText(Integer.toString(dIron));

            int dOverlock = cOverlock - nOverlock;
            txtOverlockD.setText(Integer.toString(dOverlock));

            int total = dSingleNeedle + d5ThreadOverclock + dFlatLock + dPearlSnitch + dIron + dOverlock;
            txtTotalMachineDifference.setText(Integer.toString(total));

            ManPower currentManPower=dbOps.getManPowerAmount(currentStyle);
            ManPower nextManPower=dbOps.getManPowerAmount(NextStyle);
            txtDirectC.setText(Integer.toString(currentManPower.getDirect()));
            txtIndirectC.setText(Integer.toString(currentManPower.getIndirect()));
            txtDirectN.setText(Integer.toString(nextManPower.getDirect()));
            txtIndirectN.setText(Integer.toString(nextManPower.getIndirect()));
            int directDiff=Integer.parseInt(txtDirectC.getText())-Integer.parseInt(txtDirectN.getText());
            int indirectDiff=Integer.parseInt(txtIndirectC.getText())-Integer.parseInt(txtIndirectN.getText());
            txtDirectD.setText(Integer.toString(directDiff));
            txtIndirectD.setText(Integer.toString(indirectDiff));
            int TotalDiff=Integer.parseInt(txtDirectD.getText())+Integer.parseInt(txtIndirectD.getText());
            txtTotalManPowerDifference.setText(Integer.toString(TotalDiff));

            float cWool = dbOps.getMaterial("Wool Fabric", currentStyle);
            txtWoolFabricC.setText(Float.toString(cWool));

            float cSilk = dbOps.getMaterial("Silk Fabric", currentStyle);
            txtSilkFabricC.setText(Float.toString(cSilk));

            float cCotton = dbOps.getMaterial("Cotton Fabric", currentStyle);
            txtCottonFabricC.setText(Float.toString(cCotton));

            float cNylon = dbOps.getMaterial("Nylon Fabric", currentStyle);
            txtNylonFabricC.setText(Float.toString(cNylon));

            float nWool = dbOps.getMaterial("Wool Fabric", NextStyle);
            txtWoolFabricN.setText(Float.toString(nWool));

            float nSilk = dbOps.getMaterial("Silk Fabric", NextStyle);
            txtSilkFabricsN.setText(Float.toString(nSilk));

            float nCotton = dbOps.getMaterial("Cotton Fabric", NextStyle);
            txtCottonFabricN.setText(Float.toString(nCotton));

            float nNylon = dbOps.getMaterial("Nylon Fabric", NextStyle);
            txtNylonFabricN.setText(Float.toString(nNylon));

            float dWool = cWool-nWool;
            txtWoolFabricD.setText(Float.toString(dWool));

            float dSilk = cSilk-nSilk;
            txtSilkFabricD.setText(Float.toString(dSilk));

            float dCotton = cCotton-nCotton;
            txtCottonFabricD.setText(Float.toString(dCotton));

            float dNylon = cNylon-nNylon;
            txtNylonFabricsD.setText(Float.toString(dNylon));

            float materialDiff=dWool+dSilk+dCotton+dNylon;
            txtTotalMaterialDifference.setText(Float.toString(materialDiff));

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSearchDiffActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
        direct=Integer.parseInt(txtDirectE1.getText());
        indirect=Integer.parseInt(txtIndirectE1.getText());
        //total=direct+indirect;
        total=Integer.parseInt(txtTotalE1.getText());
        populateBudgetedCadre();
         JOptionPane.showMessageDialog(this, " Submitted Successfully !!!");
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRefreshOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshOperationActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshOperationActionPerformed

    private void btnRemoveOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOperationActionPerformed
        if(dbOps.deleteStyleOperation(operationList.get(tblOperation.getSelectedRow()))){
            populateOperationTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
            clearFieldsOperation();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveOperationActionPerformed

    private void btnSubmitOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitOperationActionPerformed
        try{
        if (ddStyleNoM3.getSelectedItem().toString().equals("") || txtOperationNo.getText().equals("") || ddOperationType.getSelectedItem().toString().equals("") || ddMachine.getSelectedItem().toString().equals("") || txtOperationMachineQuantity.getText().equals("") || ddSpeciality.getSelectedItem().toString().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill Required Fields !!!");

        } else {

            so.setStyleNo(Integer.parseInt(ddStyleNoM3.getSelectedItem().toString()));
            so.setOperationNo(Integer.parseInt(txtOperationNo.getText()));
            so.setType(ddOperationType.getSelectedItem().toString());
            so.setMachine(ddMachine.getSelectedItem().toString());
            so.setQuantity(Integer.parseInt(txtOperationMachineQuantity.getText()));
            so.setSpeciality(ddSpeciality.getSelectedItem().toString());
            so.setRemarks(txtRemarksOperation.getText());

            double MCTotal=Double.parseDouble(txtMC.getText())*Integer.parseInt(txtOperationMachineQuantity.getText());
            double MATotal=Double.parseDouble(txtMA.getText())*Integer.parseInt(txtOperationMachineQuantity.getText());
            so.setMc(MCTotal);
            so.setMa(MATotal);

            if (dbOps.addOperation(so)) {
                populateOperationTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsOperation();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSubmitOperationActionPerformed

    private void btnUpdateOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOperationActionPerformed
        try{
        if (ddStyleNoM3.getSelectedItem().toString().equals("") || txtOperationNo.getText().equals("") || ddOperationType.getSelectedItem().toString().equals("") || ddMachine.getSelectedItem().toString().equals("") || txtOperationMachineQuantity.getText().equals("") || ddSpeciality.getSelectedItem().toString().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            so.setStyleNo(Integer.parseInt(ddStyleNoM3.getSelectedItem().toString()));
            so.setOperationNo(Integer.parseInt(txtOperationNo.getText()));
            so.setType(ddOperationType.getSelectedItem().toString());
            so.setMachine(ddMachine.getSelectedItem().toString());
            so.setQuantity(Integer.parseInt(txtOperationMachineQuantity.getText()));
            so.setSpeciality(ddSpeciality.getSelectedItem().toString());
            so.setRemarks(txtRemarksOperation.getText());

            double MCTotal=Double.parseDouble(txtMC.getText())*Integer.parseInt(txtOperationMachineQuantity.getText());
            double MATotal=Double.parseDouble(txtMA.getText())*Integer.parseInt(txtOperationMachineQuantity.getText());
            so.setMc(MCTotal);
            so.setMa(MATotal);

            if (dbOps.updateStyleOperation(so,operationList.get(tblOperation.getSelectedRow()))) {
                populateOperationTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
                clearFieldsOperation();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnUpdateOperationActionPerformed

    private void tblOperationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOperationMouseClicked
        try {

            StyleOperation so=operationList.get(tblOperation.getSelectedRow());

            ddStyleNoM3.setSelectedItem(Integer.toString(so.getStyleNo()));
            txtOperationNo.setText(Integer.toString(so.getOperationNo()));
            ddOperationType.setSelectedItem(so.getType());
            ddMachine.setSelectedItem(so.getMachine());
            txtOperationMachineQuantity.setText(Integer.toString(so.getQuantity()));
            ddSpeciality.setSelectedItem(so.getSpeciality());
            txtRemarksOperation.setText(so.getRemarks());
            txtMC.setText(Double.toString(so.getMc()));
            txtMA.setText(Double.toString(so.getMa()));

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    }//GEN-LAST:event_tblOperationMouseClicked

    private void ddMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddMachineMouseClicked
        String machine= ddMachine.getSelectedItem().toString();

        switch(machine){
            case "Single Needle":
            txtMC.setText("0.12");
            txtMA.setText("0.15");
            break;
            case "5 Thread Overlock":
            txtMC.setText("0.15");
            txtMA.setText("0.20");
            break;
            case "Pearl Stitch":
            txtMC.setText("0.13");
            txtMA.setText("0.15");
            break;
            case "Overlock":
            txtMC.setText("0.16");
            txtMA.setText("0.19");
            break;
            case "Iron":
            txtMC.setText("1.30");
            txtMA.setText("1.45");
            break;
            case "Flat Lock":
            txtMC.setText("0.30");
            txtMA.setText("0.45");
            break;
            
        }
    }//GEN-LAST:event_ddMachineMouseClicked

    private void btnRefreshPurchaseOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPurchaseOrder1ActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshPurchaseOrder1ActionPerformed

    private void btnRemoveMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMaterialActionPerformed
        if(dbOps.deleteStyleMaterial(materialList.get(tblMaterial.getSelectedRow()))){
            populateMaterialQuantityTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
            clearFieldsMaterialQunatity();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveMaterialActionPerformed

    private void btnSubmitQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitQ1ActionPerformed
        
        try{
        if (txtMaterialAllocationNo.getText().equals("") || ddType.getSelectedItem().toString().equals("") || ddColorMaterial.getSelectedItem().toString().equals("") || txtQuantityMaterial.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill Required Fields !!!");

        } else {

            sm.setStyleNo(Integer.parseInt(ddStyleNoM1.getSelectedItem().toString()));
            sm.setMaterialNo(Integer.parseInt(txtMaterialAllocationNo.getText()));
            sm.setType(ddType.getSelectedItem().toString());
            sm.setColor(ddColorMaterial.getSelectedItem().toString());
            sm.setQuantity(Integer.parseInt(txtQuantityMaterial.getText()));
            sm.setRemarks(txtRemarksMaterial.getText());

            if (dbOps.addMaterialQuantity(sm)) {
                populateMaterialQuantityTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsMaterialQunatity();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSubmitQ1ActionPerformed

    private void btnUpdateMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMaterialActionPerformed
        try{
        if (txtMaterialAllocationNo.getText().equals("") || ddType.getSelectedItem().toString().equals("") || ddColorMaterial.getSelectedItem().toString().equals("") || txtQuantityMaterial.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            sm.setStyleNo(Integer.parseInt(ddStyleNoM1.getSelectedItem().toString()));
            sm.setMaterialNo(Integer.parseInt(txtMaterialAllocationNo.getText()));
            sm.setType(ddType.getSelectedItem().toString());
            sm.setColor(ddColorMaterial.getSelectedItem().toString());
            sm.setQuantity(Float.parseFloat(txtQuantityMaterial.getText()));
            sm.setRemarks(txtRemarksMaterial.getText());

            if (dbOps.updateStyleMaterial(sm,materialList.get(tblMaterial.getSelectedRow()))) {
                populateMaterialQuantityTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
                clearFieldsMaterialQunatity();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnUpdateMaterialActionPerformed

    private void tblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialMouseClicked
        try {
            System.out.println("material");
            StyleMaterial sm=materialList.get(tblMaterial.getSelectedRow());

            System.out.println(sm.getStyleNo());
            System.out.println(sm.getMaterialNo());
            System.out.println(sm.getType());
            System.out.println(sm.getColor());
            System.out.println(sm.getQuantity());
            System.out.println(sm.getRemarks());
            ddStyleNoM1.setSelectedItem(Integer.toString(sm.getStyleNo()));
            txtMaterialAllocationNo.setText(Integer.toString(sm.getMaterialNo()));
            ddType.setSelectedItem(sm.getType());
            ddColorMaterial.setSelectedItem(sm.getColor());
            txtQuantityMaterial.setText(Float.toString(sm.getQuantity()));
            txtRemarksMaterial.setText(sm.getRemarks());

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    }//GEN-LAST:event_tblMaterialMouseClicked

    private void btnRefreshManPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshManPowerActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshManPowerActionPerformed

    private void btnRemoveManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveManActionPerformed
        if(dbOps.deleteManPower(manPowerList.get(tblManPower.getSelectedRow()))){
            populateManPowerTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
            clearFieldsManPower();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveManActionPerformed

    private void btnSubmitManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitManActionPerformed
        // TODO add your handling code here:
        try{
        if (txtDirect.getText().equals("") || txtIndirect.getText().equals("") || ddStyleNoM.getSelectedItem().toString().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill Required Fields !!!");

        } else {

            mp.setStyleNo(Integer.parseInt(ddStyleNoM.getSelectedItem().toString()));
            mp.setDirect(Integer.parseInt(txtDirect.getText()));
            mp.setIndirect(Integer.parseInt(txtIndirect.getText()));
            mp.setTotal(Integer.parseInt(txtDirect.getText())+Integer.parseInt(txtIndirect.getText()));

            if (dbOps.addManPower(mp)) {
                populateManPowerTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsManPower();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }

    }//GEN-LAST:event_btnSubmitManActionPerformed

    private void btnUpdateManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateManActionPerformed
        try{
        if (txtDirect.getText().equals("") || txtIndirect.getText().equals("") || ddStyleNoM.getSelectedItem().toString().equals("")  ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            mp.setStyleNo(Integer.parseInt(ddStyleNoM.getSelectedItem().toString()));
            mp.setDirect(Integer.parseInt(txtDirect.getText()));
            mp.setIndirect(Integer.parseInt(txtIndirect.getText()));
            mp.setTotal(Integer.parseInt(txtDirect.getText())+Integer.parseInt(txtIndirect.getText()));

            if (dbOps.updateManPower(mp,manPowerList.get(tblManPower.getSelectedRow()))) {
                populateManPowerTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
                clearFieldsManPower();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnUpdateManActionPerformed

    private void tblManPowerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManPowerMouseClicked

        try {
            System.out.println("test");
            ManPower mp=manPowerList.get(tblManPower.getSelectedRow());
            
            System.out.println(mp.getStyleNo());
            ddStyleNoM.setSelectedItem(Integer.toString(mp.getStyleNo()));
            txtDirect.setText(Integer.toString(mp.getDirect()));
            txtIndirect.setText(Integer.toString(mp.getIndirect()));
            txtTotal.setText(Integer.toString(mp.getTotal()));
            

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    }//GEN-LAST:event_tblManPowerMouseClicked

    private void txtIndirectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndirectKeyTyped
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtIndirectKeyTyped

    private void txtIndirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectActionPerformed
        // TODO add your handling code here:
        int total=Integer.parseInt(txtDirect.getText())+ Integer.parseInt(txtIndirect.getText());
        txtTotal.setText(Integer.toString(total));
    }//GEN-LAST:event_txtIndirectActionPerformed

    private void txtDirectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectKeyTyped
        // TODO add your handling code here:
        //ManPowerfieldValidator();
        validateManPower();
    }//GEN-LAST:event_txtDirectKeyTyped

    private void txtDirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirectActionPerformed
        // TODO add your handling code here:
        int total=Integer.parseInt(txtDirect.getText())+ Integer.parseInt(txtIndirect.getText());
        txtTotal.setText(Integer.toString(total));
    }//GEN-LAST:event_txtDirectActionPerformed

    private void btnRefreshPurchaseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPurchaseOrderActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshPurchaseOrderActionPerformed

    private void btnRemoveQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveQActionPerformed
        if(dbOps.deletePurchaseOrder(orderList.get(tblOrder.getSelectedRow()))){
            populateOrderQuantityTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
            clearFieldsOrderQunatity();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveQActionPerformed

    private void btnSubmitQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitQActionPerformed
        // TODO add your handling code here:
        try{
        if (ddStyleNoM2.getSelectedItem().toString().equals("") || txtPurchaceOrderNo.getText().equals("") || ddSize.getSelectedItem().toString().equals("") || ddColor.getSelectedItem().toString().equals("") || txtQuantityQ.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Fill Required Fields !!!");

        } else {

            po.setStyleNo(Integer.parseInt(ddStyleNoM2.getSelectedItem().toString()));
            po.setPurchaseOrderNo(Integer.parseInt(txtPurchaceOrderNo.getText()));
            po.setSize(ddSize.getSelectedItem().toString());
            po.setColor(ddColor.getSelectedItem().toString());
            po.setQuantity(Integer.parseInt(txtQuantityQ.getText()));
            po.setRemarks(txtRemarksQ.getText());

            if (dbOps.addOrderQuantity(po)) {
                populateOrderQuantityTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsOrderQunatity();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSubmitQActionPerformed

    private void btnUpdateQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateQActionPerformed
        try{
        if (ddStyleNoM2.getSelectedItem().toString().equals("") || txtPurchaceOrderNo.getText().equals("") || ddSize.getSelectedItem().toString().equals("") || ddColor.getSelectedItem().toString().equals("") || txtQuantityQ.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            po.setStyleNo(Integer.parseInt(ddStyleNoM2.getSelectedItem().toString()));
            po.setPurchaseOrderNo(Integer.parseInt(txtPurchaceOrderNo.getText()));
            po.setSize(ddSize.getSelectedItem().toString());
            po.setColor(ddColor.getSelectedItem().toString());
            po.setQuantity(Integer.parseInt(txtQuantityQ.getText()));
            po.setRemarks(txtRemarksQ.getText());

            if (dbOps.updatePurchaseOrder(po,orderList.get(tblOrder.getSelectedRow()))) {
                populateOrderQuantityTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
                clearFieldsOrderQunatity();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnUpdateQActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked

        try {

            PurchaseOrder po=orderList.get(tblOrder.getSelectedRow());

            ddStyleNoM2.setSelectedItem(Integer.toString(po.getStyleNo()));
            txtPurchaceOrderNo.setText(Integer.toString(po.getPurchaseOrderNo()));
            ddSize.setSelectedItem(po.getSize());
            ddColor.setSelectedItem(po.getColor());
            txtQuantityQ.setText(Integer.toString(po.getQuantity()));
            txtRemarksQ.setText(po.getRemarks());

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnRefreshStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStyleActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshStyleActionPerformed

    private void btnDemoStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoStyleActionPerformed
        // TODO add your handling code here:
        try {

            txtStyleNo.setText(Integer.toString(4567));
            txtBuyer.setText("Tommy");
            txtPrototype.setText("Touser");
            ddFactory.setSelectedItem("TGK");
            ddLocation.setSelectedItem("V2");
            ((JTextField)txtStartDate.getDateEditor().getUiComponent()).setText("2016-08-18");
            ((JTextField)txtEndDate.getDateEditor().getUiComponent()).setText("2016-08-30");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error !!!");

        }
    }//GEN-LAST:event_btnDemoStyleActionPerformed

    private void tblStyleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStyleMouseClicked
        // TODO add your handling code here:
        try {

            Style s=styleList.get(tblStyle.getSelectedRow());

            txtStyleNo.setText(Integer.toString(s.getStyleNo()));
            txtBuyer.setText(s.getBuyer());
            txtPrototype.setText(s.getPrototype());
            ddFactory.setSelectedItem(s.getFactory());
            ddLocation.setSelectedItem(s.getLocation());
            ((JTextField)txtStartDate.getDateEditor().getUiComponent()).setText(s.getStartDate());
            ((JTextField)txtEndDate.getDateEditor().getUiComponent()).setText(s.getEndDate());

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");

        }
    }//GEN-LAST:event_tblStyleMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(dbOps.deleteStyle(styleList.get(tblStyle.getSelectedRow()))){
            populateStyleTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
            clearFieldsStyle();
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        try{
        if (txtStyleNo.getText().equals("") || txtBuyer.getText().equals("") || txtPrototype.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            s.setStyleNo(Integer.parseInt(txtStyleNo.getText()));
            s.setBuyer(txtBuyer.getText());
            s.setPrototype(txtPrototype.getText());
            s.setFactory(ddFactory.getSelectedItem().toString());
            s.setLocation(ddLocation.getSelectedItem().toString());
            s.setStartDate(((JTextField)txtStartDate.getDateEditor().getUiComponent()).getText());
            s.setEndDate(((JTextField)txtEndDate.getDateEditor().getUiComponent()).getText());

            if (dbOps.addStyle(s)) {
                populateStyleTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsStyle();

            } else {

                JOptionPane.showMessageDialog(this, " Error While Insertion !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
        if (txtStyleNo.getText().equals("") || txtBuyer.getText().equals("") || txtPrototype.getText().equals("") ) {

            JOptionPane.showMessageDialog(this, "Please Fill All The Fields !!!");

        } else {

            s.setStyleNo(Integer.parseInt(txtStyleNo.getText()));
            s.setBuyer(txtBuyer.getText());
            s.setPrototype(txtPrototype.getText());
            s.setFactory(ddFactory.getSelectedItem().toString());
            s.setLocation(ddLocation.getSelectedItem().toString());
            s.setStartDate(((JTextField)txtStartDate.getDateEditor().getUiComponent()).getText());
            s.setEndDate(((JTextField)txtEndDate.getDateEditor().getUiComponent()).getText());

            if (dbOps.updateStyle(s,styleList.get(tblStyle.getSelectedRow()))) {
                populateStyleTable();
                JOptionPane.showMessageDialog(this, "Data Updated Successfully !!!");
                clearFieldsStyle();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Updating !!!");

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveManPowerDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveManPowerDiffActionPerformed
        try{
        if (txtCurrentStyleNo.getText().equals("") || txtNextStyle.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Search Before Saving !!!");

        } else {

            boolean status = chkStatusManPower.isSelected();
            if (status) {

                mp.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                mp.setType(txtDirectDiff.getText());
                mp.setDifference(Integer.parseInt(txtDirectD.getText()));

                ManPower mp1 = new ManPower();
                mp1.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                mp1.setType(txtIndirectDiff.getText());
                mp1.setDifference(Integer.parseInt(txtIndirectD.getText()));

                if (dbOps.addManPowerDifference(mp, mp1, status)) {

                    JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                    clearFieldsManPowerDiff();

                } else {

                    JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

                }

            } else {
                JOptionPane.showMessageDialog(this, "Rejected Successfully !!!");
                clearFieldsMachineDifference();

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSaveManPowerDiffActionPerformed

    private void btnSaveMaterialDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMaterialDiffActionPerformed
        
        try{
        if (txtCurrentStyleNo.getText().equals("") || txtNextStyle.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please Search Before Saving !!!");

        } else {

            boolean status = chkStatusMaterial.isSelected();
            if (status) {

                sm.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                sm.setType("Wool Fabric");
                sm.setDifference(Float.parseFloat(txtWoolFabricD.getText()));

                StyleMaterial sm1 = new StyleMaterial();
                sm1.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                sm1.setType("Silk Fabric");
                sm1.setDifference(Float.parseFloat(txtSilkFabricD.getText()));
                
                StyleMaterial sm2 = new StyleMaterial();
                sm2.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                sm2.setType("Cotton Fabric");
                sm2.setDifference(Float.parseFloat(txtCottonFabricD.getText()));
                
                StyleMaterial sm3 = new StyleMaterial();
                sm3.setStyleNo(Integer.parseInt(txtNextStyle.getText()));
                sm3.setType("Nylon Fabric");
               sm3.setDifference(Float.parseFloat(txtNylonFabricsD.getText()));

                if (dbOps.addMaterialDifference(sm, sm1,sm2,sm3, status)) {

                    JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                    clearFieldsMaterialDiff();

                } else {

                    JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

                }

            } else {
                JOptionPane.showMessageDialog(this, "Rejected Successfully !!!");
                clearFieldsMachineDifference();

            }

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSaveMaterialDiffActionPerformed

    private void btnDeleteMachineDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMachineDiffActionPerformed
        try{
        if(dbOps.deleteMachienDiff(operationList.get(tblMachineDiff.getSelectedRow()))){
            populateMachineDiffTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnDeleteMachineDiffActionPerformed

    private void btnDeleteManPowerDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteManPowerDiffActionPerformed
        try{
        if(dbOps.deleteManPowerDiff(manPowerList.get(tblManPowerDiff.getSelectedRow()))){
            populateManPowerDiffTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnDeleteManPowerDiffActionPerformed

    private void btnDeleteMaterialDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMaterialDiffActionPerformed
       try{
        if(dbOps.deleteMaterialDiff(materialList.get(tblMaterialDiff.getSelectedRow()))){
            populateMaterialDiffTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnDeleteMaterialDiffActionPerformed

    private void btnRefreshDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshDiffActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshDiffActionPerformed

    private void btnSearchMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMachineActionPerformed
        
        m.setFactory(ddFactoryIdleSearch.getSelectedItem().toString());
        m.setLocation(ddLocationIdleSearch.getSelectedItem().toString());
        m.setOwnership(ddOwnershipIdleSearch.getSelectedItem().toString());
        m.setSearchDate(((JTextField) txtSearchIdleSearch.getDateEditor().getUiComponent()).getText());
        machineList = dbOps.getIdleMachine(m);
        IdleMachineDetails machineDetails=new IdleMachineDetails(machineList);
        tblIdleMachines.setModel(machineDetails);

    }//GEN-LAST:event_btnSearchMachineActionPerformed

    private void btnChooseMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseMachineActionPerformed
        try {
            
            Machine m=machineList.get(tblIdleMachines.getSelectedRow());
            
            txtAssetIDMachine.setText(m.getAssetID());
            txtTypeMachine.setText(m.getType());
            txtOwnership.setText(m.getOwnership());
            txtPreviousFactoryMachine.setText(m.getFactory());
            txtPreviousLocationMachine.setText(m.getLocation());
            
            
           
        } catch (ArrayIndexOutOfBoundsException e) {
            
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
            
        }
    }//GEN-LAST:event_btnChooseMachineActionPerformed

    private void btnAssignMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignMachineActionPerformed
       try{
        AssignMachine am=new AssignMachine();
        am.setAssetID(txtAssetIDMachine.getText());
        am.setStyleNo(Integer.parseInt(ddStyleNoM4.getSelectedItem().toString()));
        am.setLocation(ddLocationMachine.getSelectedItem().toString());
        am.setFactory(ddFactoryMachine.getSelectedItem().toString());
        am.setType(txtTypeMachine.getText());
        
        if(dbOps.assignMachine(am)){
            populateAssignMachineTable();
            populateIdleMachineTable();
            JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
            clearFieldsAssignedMachine();
             
        }else{
            
             JOptionPane.showMessageDialog(this, "Error While Insertion !!!");
             
        }  
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
           
    }//GEN-LAST:event_btnAssignMachineActionPerformed

    private void btnRemoveMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMachineActionPerformed
        if(dbOps.deleteAssignMachine(assignmachineList.get(tblAssignMachine.getSelectedRow()))){
            populateAssignMachineTable();
            populateIdleMachineTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveMachineActionPerformed

    private void btnSearchMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMaterialActionPerformed
        ma.setFactory(ddFactoryIdleSearch1.getSelectedItem().toString());
        ma.setLocation(ddLocationIdleSearch1.getSelectedItem().toString());
        ma.setSearchDate(((JTextField) txtSearchIdleSearch1.getDateEditor().getUiComponent()).getText());
        materialsearchList = dbOps.getAvailabaleMaterials(ma);
        AvailableMaterialDetails materialDetails=new AvailableMaterialDetails(materialsearchList);
        tblIdleMaterial.setModel(materialDetails);

    }//GEN-LAST:event_btnSearchMaterialActionPerformed

    private void btnChooseMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseMaterialActionPerformed
       try {
            
            Material m=materialsearchList.get(tblIdleMaterial.getSelectedRow());
            
            txtAssetIDMachine1.setText(m.getAssetID());
            txtTypeMachine1.setText(m.getType());
            txtPreviousQuantity.setText(Float.toString(m.getQuantity()));
            txtPreviousFactoryMachine1.setText(ddFactoryIdleSearch1.getSelectedItem().toString());
            txtPreviousLocationMachine1.setText(ddLocationIdleSearch1.getSelectedItem().toString());
            
            
           
        } catch (ArrayIndexOutOfBoundsException e) {
            
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
            
        }
    }//GEN-LAST:event_btnChooseMaterialActionPerformed

    private void btnAssignMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignMaterialActionPerformed
        
        try{
        AssignMaterial am = new AssignMaterial();
        am.setAssetID(txtAssetIDMachine1.getText());
        am.setStyleNo(Integer.parseInt(ddStyleNoM5.getSelectedItem().toString()));
        am.setLocation(ddLocationMachine1.getSelectedItem().toString());
        am.setFactory(ddFactoryMachine1.getSelectedItem().toString());
        am.setType(txtTypeMachine1.getText());
        float finalQuantity = Float.parseFloat(txtPreviousQuantity.getText()) - Float.parseFloat(txtQuantityAssigned.getText());
        am.setQuantity(Float.parseFloat(txtQuantityAssigned.getText()));
        if (finalQuantity > 0) {
            if (dbOps.assignMaterial(am,finalQuantity)) {
                populateAssignMaterialTable();
                populateIdleMaterialTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsAssignedMaterial();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }
        } else {
            JOptionPane.showMessageDialog(this, "Quantity shouldn't be greater than actual amount !!!");

        }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnAssignMaterialActionPerformed

    private void btnRemoveAssignedMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAssignedMaterialActionPerformed
        if(dbOps.deleteAssignMaterial(assignmaterialList.get(tblAssignMaterial.getSelectedRow()))){
            populateAssignMaterialTable();
            populateIdleMaterialTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveAssignedMaterialActionPerformed

    private void btnSearchWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchWorkerActionPerformed
        try{
        emp.setFactory(ddFactoryIdleSearch2.getSelectedItem().toString());
        emp.setLocation(ddLocationIdleSearch2.getSelectedItem().toString());
        emp.setDesignation(ddTypeIdleWorker.getSelectedItem().toString());// changed
        emp.setSearchDate(((JTextField) txtSearchIdleSearch2.getDateEditor().getUiComponent()).getText());
        employeeList = dbOps.getIdleWorker(emp);
        IdleWorkerDetails employeeDetails=new IdleWorkerDetails(employeeList);
        tblIdleWorker.setModel(employeeDetails);
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnSearchWorkerActionPerformed

    private void btnChooseWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseWorkerActionPerformed
        try {
            
            Employee m=employeeList.get(tblIdleWorker.getSelectedRow());
            
            txtAssetIDMachine2.setText(m.getEmpNo());
            txtTypeMachine2.setText(m.getDesignation());
            txtEmployeeName.setText(m.getFullName());
            txtPreviousFactoryMachine2.setText(ddFactoryIdleSearch2.getSelectedItem().toString());
            txtPreviousLocationMachine2.setText(ddLocationIdleSearch2.getSelectedItem().toString());
            
            
           
        } catch (ArrayIndexOutOfBoundsException e) {
            
            JOptionPane.showMessageDialog(this, "Select a row to Assign!!!");
            
        }
    }//GEN-LAST:event_btnChooseWorkerActionPerformed

    private void btnAssignWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignWorkerActionPerformed
        try{
        AssignWorker aw = new AssignWorker();
        
        aw.setAssetID(txtAssetIDMachine2.getText());
        aw.setStyleNo(Integer.parseInt(ddStyleNoM6.getSelectedItem().toString()));
        aw.setType(txtTypeMachine2.getText());
        aw.setLocation(ddLocationMachine2.getSelectedItem().toString());
        aw.setFactory(ddFactoryMachine2.getSelectedItem().toString());
        aw.setOperation(ddOperationAssignWorker.getSelectedItem().toString());
        
            if (dbOps.assignWorker(aw)) {
                populateAssignWorkerTable();
                populateIdleWorkerTable();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully !!!");
                clearFieldsAssignedWorker();

            } else {

                JOptionPane.showMessageDialog(this, "Error While Insertion !!!");

            }
            }catch(Exception e){
        
            JOptionPane.showMessageDialog(this, " Validation Failed!!!");
        }
    }//GEN-LAST:event_btnAssignWorkerActionPerformed

    private void btnRemoveWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveWorkerActionPerformed
        if(dbOps.deleteAssignWorker(assignworkerList.get(tblAssignWorker.getSelectedRow()))){
            populateAssignWorkerTable();
            populateIdleWorkerTable();
            JOptionPane.showMessageDialog(this,"Successfully Deleted Record!!!");//imported java.swing class
        }else{
            JOptionPane.showMessageDialog(this,"Error While Deleting!!! Please Select A record to delete");
        }
    }//GEN-LAST:event_btnRemoveWorkerActionPerformed

    private void txtDirectEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectEKeyTyped
        //validateManPower();
    }//GEN-LAST:event_txtDirectEKeyTyped

    private void txtDirectEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectEKeyPressed
        validateManPower();
    }//GEN-LAST:event_txtDirectEKeyPressed

    private void txtIndirectE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndirectE1KeyTyped
   
    }//GEN-LAST:event_txtIndirectE1KeyTyped

    private void txtDirectE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirectE1ActionPerformed
       
    }//GEN-LAST:event_txtDirectE1ActionPerformed

    private void txtIndirectE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirectE1ActionPerformed
     
    }//GEN-LAST:event_txtIndirectE1ActionPerformed

    private void ddMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddMachineActionPerformed
         String machine= ddMachine.getSelectedItem().toString();

        switch(machine){
            case "Single Needle":
            txtMC.setText("0.12");
            txtMA.setText("0.15");
            break;
            case "5 Thread Overlock":
            txtMC.setText("0.15");
            txtMA.setText("0.20");
            break;
            case "Pearl Stitch":
            txtMC.setText("0.13");
            txtMA.setText("0.15");
            break;
            case "Overlock":
            txtMC.setText("0.16");
            txtMA.setText("0.19");
            break;
            case "Iron":
            txtMC.setText("1.30");
            txtMA.setText("1.45");
            break;
            case "Flat Lock":
            txtMC.setText("0.30");
            txtMA.setText("0.45");
            break;
        }
    }//GEN-LAST:event_ddMachineActionPerformed

    private void txtDirectE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectE1KeyTyped
       
     
    }//GEN-LAST:event_txtDirectE1KeyTyped

    private void txtDirectE1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectE1KeyPressed
        
    }//GEN-LAST:event_txtDirectE1KeyPressed

    private void txtIndirectE1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtIndirectE1InputMethodTextChanged
     
    }//GEN-LAST:event_txtIndirectE1InputMethodTextChanged

    private void txtIndirectE1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtIndirectE1CaretPositionChanged
        
    }//GEN-LAST:event_txtIndirectE1CaretPositionChanged

    private void txtTotalE1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalE1FocusGained
        if(txtDirectE1.getText().equals("")){
              txtDirectE1.setText(null);
          }else{
        int newtotal=Integer.parseInt(txtDirectE1.getText())+Integer.parseInt(txtIndirectE1.getText());
        txtTotalE1.setText(Integer.toString(newtotal));
        }
    }//GEN-LAST:event_txtTotalE1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            ddStyleNoM2.setSelectedItem(Integer.toString(4567));
            txtPurchaceOrderNo.setText(Integer.toString(1));
            ddSize.setSelectedItem("M");
            ddColor.setSelectedItem("White");
            txtQuantityQ.setText(Integer.toString(1000));
            txtRemarksQ.setText("First Order");
           

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error !!!");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {

            ddStyleNoM1.setSelectedItem(Integer.toString(4567));
           txtMaterialAllocationNo.setText(Integer.toString(1));
            ddType.setSelectedItem("Silk Fabric");
            ddColorMaterial.setSelectedItem("White");
            txtQuantityMaterial.setText("3000");
           txtRemarksMaterial.setText("First Order");
           

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error !!!");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            ddStyleNoM3.setSelectedItem(Integer.toString(4567));
            txtOperationNo.setText(Integer.toString(1));
            ddOperationType.setSelectedItem("Tack Lable");
            ddMachine.setSelectedItem("5 Thread Overlock");
            txtOperationMachineQuantity.setText(Integer.toString(5));
            ddSpeciality.setSelectedItem("With Light");
            txtRemarksOperation.setText("First Order");
           

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error !!!");

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HashMap param = new HashMap();
        param.put("styleNo", Integer.parseInt(ddStyleNoM7.getSelectedItem().toString()));
        MyReportViewer viewer = new MyReportViewer("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\StylePlanningAndResourceAllocation\\ParamaterizedStyleReport.jasper", param);
        viewer.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MyReportViewer r=new MyReportViewer("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\StylePlanningAndResourceAllocation\\FullStyle Report.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtSearchStyleByBuyerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStyleByBuyerKeyPressed
        styleList=dbOps.getStylesByBuyer(txtSearchStyleByBuyer.getText());
        StyleDetails styleModel =new StyleDetails(styleList);
        tblStyle.setModel(styleModel);
    }//GEN-LAST:event_txtSearchStyleByBuyerKeyPressed

    private void txtReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiverActionPerformed

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
        final String username = txtUsername.getText();
        final String password = txtPassword.getText();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(txtUsername.getText()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtReceiver.getText()));
            message.setSubject(txtSubject.getText());
            // message.setText(txtMessage.getText());
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(txtMessage.getText());

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            File f = jFileChooser1.getSelectedFile();
            String filename = f.getAbsolutePath();

            messageBodyPart = new MimeBodyPart();
            //String filename = "/home/manisha/file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Done");
            JOptionPane.showMessageDialog(this, " Email Sent Successfully !!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnSendMailActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        txtUsername.setText("itpproject2016@gmail.com");
        txtPassword.setText("sampath123");
        txtReceiver.setText("srrajapakse1@gmail.com");
        txtSubject.setText("Demo Test");
        txtMessage.setText("ITP project demo with attachments");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ddMachine1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddMachine1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ddMachine1MouseClicked

    private void ddMachine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddMachine1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddMachine1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignMachine;
    private javax.swing.JButton btnAssignMaterial;
    private javax.swing.JButton btnAssignWorker;
    private javax.swing.JButton btnChooseMachine;
    private javax.swing.JButton btnChooseMaterial;
    private javax.swing.JButton btnChooseWorker;
    private javax.swing.JButton btnDeleteMachineDiff;
    private javax.swing.JButton btnDeleteManPowerDiff;
    private javax.swing.JButton btnDeleteMaterialDiff;
    private javax.swing.JButton btnDemoStyle;
    private javax.swing.JButton btnRefreshDiff;
    private javax.swing.JButton btnRefreshManPower;
    private javax.swing.JButton btnRefreshOperation;
    private javax.swing.JButton btnRefreshPurchaseOrder;
    private javax.swing.JButton btnRefreshPurchaseOrder1;
    private javax.swing.JButton btnRefreshStyle;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveAssignedMaterial;
    private javax.swing.JButton btnRemoveMachine;
    private javax.swing.JButton btnRemoveMan;
    private javax.swing.JButton btnRemoveMaterial;
    private javax.swing.JButton btnRemoveOperation;
    private javax.swing.JButton btnRemoveQ;
    private javax.swing.JButton btnRemoveWorker;
    private javax.swing.JButton btnSaveMachineDiff;
    private javax.swing.JButton btnSaveManPowerDiff;
    private javax.swing.JButton btnSaveMaterialDiff;
    private javax.swing.JButton btnSearchDiff;
    private javax.swing.JButton btnSearchMachine;
    private javax.swing.JButton btnSearchMaterial;
    private javax.swing.JButton btnSearchWorker;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitMan;
    private javax.swing.JButton btnSubmitOperation;
    private javax.swing.JButton btnSubmitQ;
    private javax.swing.JButton btnSubmitQ1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateMan;
    private javax.swing.JButton btnUpdateMaterial;
    private javax.swing.JButton btnUpdateOperation;
    private javax.swing.JButton btnUpdateQ;
    private javax.swing.JCheckBox chkStatusMachine;
    private javax.swing.JCheckBox chkStatusManPower;
    private javax.swing.JCheckBox chkStatusMaterial;
    private javax.swing.JComboBox<String> ddColor;
    private javax.swing.JComboBox<String> ddColorMaterial;
    private javax.swing.JComboBox<String> ddFactory;
    private javax.swing.JComboBox<String> ddFactoryDiff;
    private javax.swing.JComboBox<String> ddFactoryIdleSearch;
    private javax.swing.JComboBox<String> ddFactoryIdleSearch1;
    private javax.swing.JComboBox<String> ddFactoryIdleSearch2;
    private javax.swing.JComboBox<String> ddFactoryMachine;
    private javax.swing.JComboBox<String> ddFactoryMachine1;
    private javax.swing.JComboBox<String> ddFactoryMachine2;
    private javax.swing.JComboBox<String> ddLocation;
    private javax.swing.JComboBox<String> ddLocationDiff;
    private javax.swing.JComboBox<String> ddLocationIdleSearch;
    private javax.swing.JComboBox<String> ddLocationIdleSearch1;
    private javax.swing.JComboBox<String> ddLocationIdleSearch2;
    private javax.swing.JComboBox<String> ddLocationMachine;
    private javax.swing.JComboBox<String> ddLocationMachine1;
    private javax.swing.JComboBox<String> ddLocationMachine2;
    private javax.swing.JComboBox<String> ddMachine;
    private javax.swing.JComboBox<String> ddMachine1;
    private javax.swing.JComboBox<String> ddOperationAssignWorker;
    private javax.swing.JComboBox<String> ddOperationType;
    private javax.swing.JComboBox<String> ddOwnershipIdleSearch;
    private javax.swing.JComboBox<String> ddSize;
    private javax.swing.JComboBox<String> ddSpeciality;
    private javax.swing.JComboBox<String> ddStyleNoM;
    private javax.swing.JComboBox<String> ddStyleNoM1;
    private javax.swing.JComboBox<String> ddStyleNoM2;
    private javax.swing.JComboBox<String> ddStyleNoM3;
    private javax.swing.JComboBox<String> ddStyleNoM4;
    private javax.swing.JComboBox<String> ddStyleNoM5;
    private javax.swing.JComboBox<String> ddStyleNoM6;
    private javax.swing.JComboBox<String> ddStyleNoM7;
    private javax.swing.JComboBox<String> ddStyleNoM8;
    private javax.swing.JComboBox<String> ddType;
    private javax.swing.JComboBox<String> ddType1;
    private javax.swing.JComboBox<String> ddTypeIdleWorker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
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
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblerrorManPower;
    private javax.swing.JTable tblAssignMachine;
    private javax.swing.JTable tblAssignMaterial;
    private javax.swing.JTable tblAssignWorker;
    private javax.swing.JTable tblIdleMachines;
    private javax.swing.JTable tblIdleMaterial;
    private javax.swing.JTable tblIdleWorker;
    private javax.swing.JTable tblMachineDiff;
    private javax.swing.JTable tblManPower;
    private javax.swing.JTable tblManPowerDiff;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTable tblMaterialDiff;
    private javax.swing.JTable tblOperation;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblStyle;
    private javax.swing.JTextField txt5ThreadOverlock;
    private javax.swing.JTextField txt5ThreadOverlockC;
    private javax.swing.JTextField txt5ThreadOverlockD;
    private javax.swing.JTextField txt5ThreadOverlockN;
    private javax.swing.JTextField txtAssetIDMachine;
    private javax.swing.JTextField txtAssetIDMachine1;
    private javax.swing.JTextField txtAssetIDMachine2;
    private javax.swing.JTextField txtBuyer;
    private javax.swing.JTextField txtCottonFabricC;
    private javax.swing.JTextField txtCottonFabricD;
    private javax.swing.JTextField txtCottonFabricN;
    private javax.swing.JTextField txtCurrentEndDate;
    private javax.swing.JTextField txtCurrentStartDate;
    private javax.swing.JTextField txtCurrentStyleNo;
    private javax.swing.JTextField txtDirect;
    private javax.swing.JTextField txtDirectC;
    private javax.swing.JTextField txtDirectD;
    private javax.swing.JTextField txtDirectDiff;
    private javax.swing.JTextField txtDirectE;
    private javax.swing.JTextField txtDirectE1;
    private javax.swing.JTextField txtDirectN;
    private javax.swing.JTextField txtEmployeeName;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtFlatLock;
    private javax.swing.JTextField txtFlatLockC;
    private javax.swing.JTextField txtFlatLockD;
    private javax.swing.JTextField txtFlatLockN;
    private javax.swing.JTextField txtIndirect;
    private javax.swing.JTextField txtIndirectC;
    private javax.swing.JTextField txtIndirectD;
    private javax.swing.JTextField txtIndirectDiff;
    private javax.swing.JTextField txtIndirectE;
    private javax.swing.JTextField txtIndirectE1;
    private javax.swing.JTextField txtIndirectN;
    private javax.swing.JTextField txtIron;
    private javax.swing.JTextField txtIronC;
    private javax.swing.JTextField txtIronD;
    private javax.swing.JTextField txtIronN;
    private javax.swing.JTextField txtMA;
    private javax.swing.JTextField txtMC;
    private javax.swing.JTextField txtMaterialAllocationNo;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtNextStyle;
    private javax.swing.JTextField txtNextStyleEndDate;
    private javax.swing.JTextField txtNextStyleStartDate;
    private javax.swing.JTextField txtNylonFabricC;
    private javax.swing.JTextField txtNylonFabricN;
    private javax.swing.JTextField txtNylonFabricsD;
    private javax.swing.JTextField txtOperationMachineQuantity;
    private javax.swing.JTextField txtOperationNo;
    private javax.swing.JTextField txtOverlock;
    private javax.swing.JTextField txtOverlockC;
    private javax.swing.JTextField txtOverlockD;
    private javax.swing.JTextField txtOverlockN;
    private javax.swing.JTextField txtOwnership;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPearlStitch;
    private javax.swing.JTextField txtPearlStitchC;
    private javax.swing.JTextField txtPearlStitchD;
    private javax.swing.JTextField txtPearlStitchN;
    private javax.swing.JTextField txtPreviousFactoryMachine;
    private javax.swing.JTextField txtPreviousFactoryMachine1;
    private javax.swing.JTextField txtPreviousFactoryMachine2;
    private javax.swing.JTextField txtPreviousLocationMachine;
    private javax.swing.JTextField txtPreviousLocationMachine1;
    private javax.swing.JTextField txtPreviousLocationMachine2;
    private javax.swing.JTextField txtPreviousQuantity;
    private javax.swing.JTextField txtPrototype;
    private javax.swing.JTextField txtPurchaceOrderNo;
    private javax.swing.JTextField txtQuantityAssigned;
    private javax.swing.JTextField txtQuantityMaterial;
    private javax.swing.JTextField txtQuantityQ;
    private javax.swing.JTextField txtReceiver;
    private javax.swing.JTextArea txtRemarksMaterial;
    private javax.swing.JTextArea txtRemarksOperation;
    private javax.swing.JTextArea txtRemarksQ;
    private com.toedter.calendar.JDateChooser txtSearchDateDiff;
    private com.toedter.calendar.JDateChooser txtSearchIdleSearch;
    private com.toedter.calendar.JDateChooser txtSearchIdleSearch1;
    private com.toedter.calendar.JDateChooser txtSearchIdleSearch2;
    private javax.swing.JTextField txtSearchStyleByBuyer;
    private javax.swing.JTextField txtSilkFabricC;
    private javax.swing.JTextField txtSilkFabricD;
    private javax.swing.JTextField txtSilkFabricsN;
    private javax.swing.JTextField txtSingleNeedle;
    private javax.swing.JTextField txtSingleNeedleC;
    private javax.swing.JTextField txtSingleNeedleD;
    private javax.swing.JTextField txtSingleNeedleN;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtStyleNo;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalE;
    private javax.swing.JTextField txtTotalE1;
    private javax.swing.JTextField txtTotalMachineDifference;
    private javax.swing.JTextField txtTotalManPowerDifference;
    private javax.swing.JTextField txtTotalMaterialDifference;
    private javax.swing.JTextField txtTypeMachine;
    private javax.swing.JTextField txtTypeMachine1;
    private javax.swing.JTextField txtTypeMachine2;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtWoolFabricC;
    private javax.swing.JTextField txtWoolFabricD;
    private javax.swing.JTextField txtWoolFabricN;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationAddCadre;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelAddMaterial;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelAddOperation;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelAddQuantity;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelManPower;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelMaterialAllocation;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelNewStyle;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelSendMail;
    // End of variables declaration//GEN-END:variables
}
