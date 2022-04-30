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
public class TransactionHistoryTest {
    
    public TransactionHistoryTest() {
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
     * Test of getDateAndTime method, of class TransactionHistory.
     */
    @Test
    public void testGetDateAndTime() {
        System.out.println("getDateAndTime");
        TransactionHistory instance = new TransactionHistory("26/04/2022 18:03:56", "CYC-123456-MSM", 5, 10.99);
        String expResult = "26/04/2022 18:03:56";
        String result = instance.getDateAndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductCode method, of class TransactionHistory.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        TransactionHistory instance = new TransactionHistory("26/04/2022 18:03:56", "CYC-123456-MSM", 5, 10.99);
        String expResult = "CYC-123456-MSM";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantitySold method, of class TransactionHistory.
     */
    @Test
    public void testGetQuantitySold() {
        System.out.println("getQuantitySold");
        TransactionHistory instance = new TransactionHistory("26/04/2022 18:03:56", "CYC-123456-MSM", 5, 10.99);
        int expResult = 5;
        int result = instance.getQuantitySold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class TransactionHistory.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        TransactionHistory instance = new TransactionHistory("26/04/2022 18:03:56", "CYC-123456-MSM", 5, 10.99);
        double expResult = 10.99;
        double result = instance.getUnitPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
