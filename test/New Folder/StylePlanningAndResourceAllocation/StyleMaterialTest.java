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
public class StyleMaterialTest {
    
    public StyleMaterialTest() {
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
     * Test of getStyleNo method, of class StyleMaterial.
     */
    @Test
    public void testGetStyleNo() {
        System.out.println("getStyleNo");
        StyleMaterial instance = new StyleMaterial();
        int expResult = 0;
        int result = instance.getStyleNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStyleNo method, of class StyleMaterial.
     */
    @Test
    public void testSetStyleNo() {
        System.out.println("setStyleNo");
        int styleNo = 0;
        StyleMaterial instance = new StyleMaterial();
        instance.setStyleNo(styleNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterialNo method, of class StyleMaterial.
     */
    @Test
    public void testGetMaterialNo() {
        System.out.println("getMaterialNo");
        StyleMaterial instance = new StyleMaterial();
        int expResult = 0;
        int result = instance.getMaterialNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterialNo method, of class StyleMaterial.
     */
    @Test
    public void testSetMaterialNo() {
        System.out.println("setMaterialNo");
        int materialNo = 0;
        StyleMaterial instance = new StyleMaterial();
        instance.setMaterialNo(materialNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class StyleMaterial.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        StyleMaterial instance = new StyleMaterial();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class StyleMaterial.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        StyleMaterial instance = new StyleMaterial();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class StyleMaterial.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        StyleMaterial instance = new StyleMaterial();
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class StyleMaterial.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        StyleMaterial instance = new StyleMaterial();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class StyleMaterial.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        StyleMaterial instance = new StyleMaterial();
        float expResult = 0.0F;
        float result = instance.getQuantity();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class StyleMaterial.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        float quantity = 0.0F;
        StyleMaterial instance = new StyleMaterial();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemarks method, of class StyleMaterial.
     */
    @Test
    public void testGetRemarks() {
        System.out.println("getRemarks");
        StyleMaterial instance = new StyleMaterial();
        String expResult = "";
        String result = instance.getRemarks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRemarks method, of class StyleMaterial.
     */
    @Test
    public void testSetRemarks() {
        System.out.println("setRemarks");
        String remarks = "";
        StyleMaterial instance = new StyleMaterial();
        instance.setRemarks(remarks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDifference method, of class StyleMaterial.
     */
    @Test
    public void testGetDifference() {
        System.out.println("getDifference");
        StyleMaterial instance = new StyleMaterial();
        float expResult = 0.0F;
        float result = instance.getDifference();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDifference method, of class StyleMaterial.
     */
    @Test
    public void testSetDifference() {
        System.out.println("setDifference");
        float difference = 0.0F;
        StyleMaterial instance = new StyleMaterial();
        instance.setDifference(difference);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
