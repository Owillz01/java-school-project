/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author godsw
 */
public class ASCStockItemTest {
    
    public ASCStockItemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getProductCode method, of class ASCStockItem.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        String expResult = "RUN1234567";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductTitle method, of class ASCStockItem.
     */
    @Test
    public void testGetProductTitle() {
        System.out.println("getProductTitle");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        String expResult = "Run-Tech Running  shorts";
        String result = instance.getProductTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductDesc method, of class ASCStockItem.
     */
    @Test
    public void testGetProductDesc() {
        System.out.println("getProductDesc");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        String expResult = "High-quality  running";
        String result = instance.getProductDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductPriceInPounds method, of class ASCStockItem.
     */
    @Test
    public void testGetProductPriceInPounds() {
        System.out.println("getProductPriceInPounds");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        int expResult = 10;
        int result = instance.getProductPriceInPounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductPriceInPence method, of class ASCStockItem.
     */
    @Test
    public void testGetProductPriceInPence() {
        System.out.println("getProductPriceInPence");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        int expResult = 0;
        int result = instance.getProductPriceInPence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuanity method, of class ASCStockItem.
     */
    @Test
    public void testSetQuanity() {
        System.out.println("setQuanity");
        int newQuantity = 0;
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        instance.setQuanity(newQuantity);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class ASCStockItem.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        double expResult = 10.0;
        double result = instance.getUnitPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getHumanFriendlyUnitPrice method, of class ASCStockItem.
     */
    @Test
    public void testGetHumanFriendlyUnitPrice() {
        System.out.println("getHumanFriendlyUnitPrice");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        String expResult = "10.00";
        String result = instance.getHumanFriendlyUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQtyInStock method, of class ASCStockItem.
     */
    @Test
    public void testGetQtyInStock() {
        System.out.println("getQtyInStock");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        int expResult = 10;
        int result = instance.getQtyInStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of loadASCStockItemCSV method, of class ASCStockItem.
     */
   
}
