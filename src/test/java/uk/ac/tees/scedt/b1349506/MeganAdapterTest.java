/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

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
public class MeganAdapterTest {
    
    public MeganAdapterTest() {
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
     * Test of getProductCode method, of class MeganAdapter.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        MSMStockItem stock = new MSMStockItem(1,"234567","RunEverywhere                                               Great trainers for running cross country",8850,50);
        MeganAdapter instance = new MeganAdapter(stock);
        String expResult = "RUN-234567-MSM";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductTitle method, of class MeganAdapter.
     */
    @Test
    public void testGetProductTitle() {
        System.out.println("getProductTitle");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        String expResult = "RunEverywhere";
        String result = instance.getProductTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductDesc method, of class MeganAdapter.
     */
    @Test
    public void testGetProductDesc() {
        System.out.println("getProductDesc");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        String expResult = "Greattrainersforrunningcrosscountry";
        String result = instance.getProductDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductPriceInPence method, of class MeganAdapter.
     */
    @Test
    public void testGetProductPriceInPence() {
        System.out.println("getProductPriceInPence");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        int expResult = 50;
        int result = instance.getProductPriceInPence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuanity method, of class MeganAdapter.
     */
    @Test
    public void testSetQuanity() {
        System.out.println("setQuanity");
        int newValue = 20;
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        instance.setQuanity(newValue);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductPriceInPounds method, of class MeganAdapter.
     */
    @Test
    public void testGetProductPriceInPounds() {
        System.out.println("getProductPriceInPounds");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        int expResult = 88;
        int result = instance.getProductPriceInPounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class MeganAdapter.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        double expResult = 8850.0;
        double result = instance.getUnitPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getHumanFriendlyUnitPrice method, of class MeganAdapter.
     */
    @Test
    public void testGetHumanFriendlyUnitPrice() {
        System.out.println("getHumanFriendlyUnitPrice");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        String expResult = "88.50";
        String result = instance.getHumanFriendlyUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQtyInStock method, of class MeganAdapter.
     */
    @Test
    public void testGetQtyInStock() {
        System.out.println("getQtyInStock");
        MSMStockItem stock = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        MeganAdapter instance = new MeganAdapter(stock);
        int expResult = 50;
        int result = instance.getQtyInStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }  
}
