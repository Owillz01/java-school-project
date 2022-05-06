/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1349506.gui;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uk.ac.tees.scedt.b1349506.TransactionHistory;

/**
 *
 * @author godsw
 */
public class TransactionHistoryModelTest {
    private List<TransactionHistory> allStockItemsSold = null;
    
    public TransactionHistoryModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        allStockItemsSold = new ArrayList();
        TransactionHistory stock = new TransactionHistory("26/04/2022 18:03:56", "CYC-123456-MSM", 5, "10.99");
        allStockItemsSold.add(stock);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRowCount method, of class TransactionHistoryModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        setUp();
        TransactionHistoryModel instance = new TransactionHistoryModel(allStockItemsSold);
        int expResult = 1;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class TransactionHistoryModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        setUp();
        TransactionHistoryModel instance = new TransactionHistoryModel(allStockItemsSold);
        int expResult = 4;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class TransactionHistoryModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        setUp();
        TransactionHistoryModel instance = new TransactionHistoryModel(allStockItemsSold);
        String expResult = "Date";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TransactionHistoryModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int colIndex = 0;
        setUp();
        TransactionHistoryModel instance = new TransactionHistoryModel(allStockItemsSold);
        Object expResult = "26/04/2022 18:03:56";
        Object result = instance.getValueAt(rowIndex, colIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
