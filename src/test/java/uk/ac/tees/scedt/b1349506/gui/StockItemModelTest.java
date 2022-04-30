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
import uk.ac.tees.scedt.b1349506.ASCStockInterface;
import uk.ac.tees.scedt.b1349506.ASCStockItem;
import uk.ac.tees.scedt.b1349506.MSMStockItem;
import uk.ac.tees.scedt.b1349506.MeganAdapter;

/**
 *
 * @author godsw
 */
public class StockItemModelTest {
    
    private static  List<ASCStockItem> allASCStockItem = null;
    private static  List<MSMStockItem> allMeganStockItem = null;
    private static  List<MeganAdapter> allMeganAdaptedStockItem = null;
    private static List<ASCStockInterface> allStockItems = null;
    public StockItemModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        allStockItems = new ArrayList<>();
        allASCStockItem = new ArrayList<>();
        allMeganStockItem = new ArrayList<>();
        allMeganAdaptedStockItem = new ArrayList<>();
        
        ASCStockItem aSCStockItem = new ASCStockItem("RUN1234567", "Run-Tech Running  shorts", "High-quality  running", 10, 0, 10);
        MSMStockItem mSMStockItem = new MSMStockItem(1, "234567", "RunEverywhere                                               Great trainers for running cross country", 8850, 50);
        
        allMeganStockItem.add(mSMStockItem);
        allASCStockItem.add(aSCStockItem);
        for (MSMStockItem stock : allMeganStockItem) {
          MeganAdapter adaptedItem = new MeganAdapter(stock);
            allMeganAdaptedStockItem.add(adaptedItem);
        }
        
        allStockItems.addAll(allASCStockItem);
        allStockItems.addAll(allMeganAdaptedStockItem);
        
        System.out.println(allASCStockItem.size()+" allASCStockItem");
        System.out.println(allMeganAdaptedStockItem.size()+" allMeganAdaptedStockItem");
        System.out.println(allStockItems.size()+" allStockItems");
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRowCount method, of class StockItemModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        setUp();
        StockItemModel instance = new StockItemModel(allStockItems);
        int expResult = 2;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class StockItemModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        setUp();
        StockItemModel instance = new StockItemModel(allStockItems);
        int expResult = 6;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class StockItemModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        StockItemModel instance = new StockItemModel(allStockItems);
        String expResult = "ID";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class StockItemModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        setUp();
        int rowIndex = 0;
        int colIndex = 0;
        StockItemModel instance = new StockItemModel(allStockItems);
        Object expResult = "RUN1234567";
        Object result = instance.getValueAt(rowIndex, colIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
