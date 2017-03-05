/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

import EmployeeManagement.Employee;
import StockManagement.Machine;
import StockManagement.Material;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sampath Rajapakse
 */
public class DBOperationStylePlanningTest {
    
    public DBOperationStylePlanningTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStyle method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddStyle() {
        System.out.println("addStyle");
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addStyle(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStyles method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetStyles() {
        System.out.println("getStyles");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<Style> expResult = null;
        ArrayList<Style> result = instance.getStyles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStylesByBuyer method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetStylesByBuyer() {
        System.out.println("getStylesByBuyer");
        String buyer = "";
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<Style> expResult = null;
        ArrayList<Style> result = instance.getStylesByBuyer(buyer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStyle method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteStyle() {
        System.out.println("deleteStyle");
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteStyle(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStyle method, of class DBOperationStylePlanning.
     */
    @Test
    public void testUpdateStyle() {
        System.out.println("updateStyle");
        Style s = null;
        Style s1 = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.updateStyle(s, s1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrderQuantity method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddOrderQuantity() {
        System.out.println("addOrderQuantity");
        PurchaseOrder po = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addOrderQuantity(po);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPurchaseOrders method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetPurchaseOrders() {
        System.out.println("getPurchaseOrders");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<PurchaseOrder> expResult = null;
        ArrayList<PurchaseOrder> result = instance.getPurchaseOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addManPower method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddManPower() {
        System.out.println("addManPower");
        ManPower mp = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addManPower(mp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManPowerAllocation method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetManPowerAllocation() {
        System.out.println("getManPowerAllocation");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<ManPower> expResult = null;
        ArrayList<ManPower> result = instance.getManPowerAllocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePurchaseOrder method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeletePurchaseOrder() {
        System.out.println("deletePurchaseOrder");
        PurchaseOrder po = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deletePurchaseOrder(po);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteManPower method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteManPower() {
        System.out.println("deleteManPower");
        ManPower mp = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteManPower(mp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMaterialQuantity method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddMaterialQuantity() {
        System.out.println("addMaterialQuantity");
        StyleMaterial sm = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addMaterialQuantity(sm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStyleMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetStyleMaterial() {
        System.out.println("getStyleMaterial");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<StyleMaterial> expResult = null;
        ArrayList<StyleMaterial> result = instance.getStyleMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStyleMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteStyleMaterial() {
        System.out.println("deleteStyleMaterial");
        StyleMaterial sm = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteStyleMaterial(sm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStyleMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testUpdateStyleMaterial() {
        System.out.println("updateStyleMaterial");
        StyleMaterial sm = null;
        StyleMaterial table = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.updateStyleMaterial(sm, table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePurchaseOrder method, of class DBOperationStylePlanning.
     */
    @Test
    public void testUpdatePurchaseOrder() {
        System.out.println("updatePurchaseOrder");
        PurchaseOrder po = null;
        PurchaseOrder table = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.updatePurchaseOrder(po, table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateManPower method, of class DBOperationStylePlanning.
     */
    @Test
    public void testUpdateManPower() {
        System.out.println("updateManPower");
        ManPower mp = null;
        ManPower table = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.updateManPower(mp, table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOperation method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddOperation() {
        System.out.println("addOperation");
        StyleOperation so = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addOperation(so);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperation method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<StyleOperation> expResult = null;
        ArrayList<StyleOperation> result = instance.getOperation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStyleOperation method, of class DBOperationStylePlanning.
     */
    @Test
    public void testUpdateStyleOperation() {
        System.out.println("updateStyleOperation");
        StyleOperation so = null;
        StyleOperation table = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.updateStyleOperation(so, table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStyleOperation method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteStyleOperation() {
        System.out.println("deleteStyleOperation");
        StyleOperation so = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteStyleOperation(so);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentStyleObject method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetCurrentStyleObject() {
        System.out.println("getCurrentStyleObject");
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        Style expResult = null;
        Style result = instance.getCurrentStyleObject(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextStyleObject method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetNextStyleObject() {
        System.out.println("getNextStyleObject");
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        Style expResult = null;
        Style result = instance.getNextStyleObject(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMachineAmount method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetMachineAmount() {
        System.out.println("getMachineAmount");
        String type = "";
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        int expResult = 0;
        int result = instance.getMachineAmount(type, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManPowerAmount method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetManPowerAmount() {
        System.out.println("getManPowerAmount");
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ManPower expResult = null;
        ManPower result = instance.getManPowerAmount(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        String type = "";
        Style s = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        float expResult = 0.0F;
        float result = instance.getMaterial(type, s);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMachineDifference method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddMachineDifference() {
        System.out.println("addMachineDifference");
        StyleOperation so = null;
        StyleOperation so1 = null;
        StyleOperation so2 = null;
        StyleOperation so3 = null;
        boolean status = false;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addMachineDifference(so, so1, so2, so3, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addManPowerDifference method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddManPowerDifference() {
        System.out.println("addManPowerDifference");
        ManPower mp = null;
        ManPower mp1 = null;
        boolean status = false;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addManPowerDifference(mp, mp1, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMaterialDifference method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAddMaterialDifference() {
        System.out.println("addMaterialDifference");
        StyleMaterial sm = null;
        StyleMaterial sm1 = null;
        StyleMaterial sm2 = null;
        StyleMaterial sm3 = null;
        boolean status = false;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.addMaterialDifference(sm, sm1, sm2, sm3, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMachineDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetMachineDiff() {
        System.out.println("getMachineDiff");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<StyleOperation> expResult = null;
        ArrayList<StyleOperation> result = instance.getMachineDiff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManPowerDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetManPowerDiff() {
        System.out.println("getManPowerDiff");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<ManPower> expResult = null;
        ArrayList<ManPower> result = instance.getManPowerDiff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterialDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetMaterialDiff() {
        System.out.println("getMaterialDiff");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<StyleMaterial> expResult = null;
        ArrayList<StyleMaterial> result = instance.getMaterialDiff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMachienDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteMachienDiff() {
        System.out.println("deleteMachienDiff");
        StyleOperation get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteMachienDiff(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteManPowerDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteManPowerDiff() {
        System.out.println("deleteManPowerDiff");
        ManPower get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteManPowerDiff(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMaterialDiff method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteMaterialDiff() {
        System.out.println("deleteMaterialDiff");
        StyleMaterial get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteMaterialDiff(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdleMachine method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetIdleMachine() {
        System.out.println("getIdleMachine");
        Machine ma = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<Machine> expResult = null;
        ArrayList<Machine> result = instance.getIdleMachine(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignMachine method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAssignMachine() {
        System.out.println("assignMachine");
        AssignMachine a = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.assignMachine(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedMachines method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetAssignedMachines() {
        System.out.println("getAssignedMachines");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<AssignMachine> expResult = null;
        ArrayList<AssignMachine> result = instance.getAssignedMachines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAssignMachine method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteAssignMachine() {
        System.out.println("deleteAssignMachine");
        AssignMachine get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteAssignMachine(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailabaleMaterials method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetAvailabaleMaterials() {
        System.out.println("getAvailabaleMaterials");
        Material ma = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getAvailabaleMaterials(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAssignMaterial() {
        System.out.println("assignMaterial");
        AssignMaterial am = null;
        float finalQuantity = 0.0F;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.assignMaterial(am, finalQuantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetAssignedMaterial() {
        System.out.println("getAssignedMaterial");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<AssignMaterial> expResult = null;
        ArrayList<AssignMaterial> result = instance.getAssignedMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAssignMaterial method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteAssignMaterial() {
        System.out.println("deleteAssignMaterial");
        AssignMaterial get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteAssignMaterial(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdleWorker method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetIdleWorker() {
        System.out.println("getIdleWorker");
        Employee emp = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = instance.getIdleWorker(emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedWorker method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetAssignedWorker() {
        System.out.println("getAssignedWorker");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<AssignWorker> expResult = null;
        ArrayList<AssignWorker> result = instance.getAssignedWorker();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignWorker method, of class DBOperationStylePlanning.
     */
    @Test
    public void testAssignWorker() {
        System.out.println("assignWorker");
        AssignWorker aw = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.assignWorker(aw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAssignWorker method, of class DBOperationStylePlanning.
     */
    @Test
    public void testDeleteAssignWorker() {
        System.out.println("deleteAssignWorker");
        AssignWorker get = null;
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        boolean expResult = false;
        boolean result = instance.deleteAssignWorker(get);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperationType method, of class DBOperationStylePlanning.
     */
    @Test
    public void testGetOperationType() {
        System.out.println("getOperationType");
        DBOperationStylePlanning instance = new DBOperationStylePlanning();
        ArrayList<StyleOperation> expResult = null;
        ArrayList<StyleOperation> result = instance.getOperationType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
