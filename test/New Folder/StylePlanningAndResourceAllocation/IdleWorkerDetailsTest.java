/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

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
public class IdleWorkerDetailsTest {
    
    public IdleWorkerDetailsTest() {
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
     * Test of getRowCount method, of class IdleWorkerDetails.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        IdleWorkerDetails instance = null;
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class IdleWorkerDetails.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        IdleWorkerDetails instance = null;
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class IdleWorkerDetails.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int columnIndex = 0;
        IdleWorkerDetails instance = null;
        String expResult = "";
        String result = instance.getColumnName(columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class IdleWorkerDetails.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        IdleWorkerDetails instance = null;
        Object expResult = null;
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
