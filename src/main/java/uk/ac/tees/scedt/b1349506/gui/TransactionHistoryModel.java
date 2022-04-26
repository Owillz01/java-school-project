/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.scedt.b1349506.TransactionHistory;

/** Represents a table Model class for Transaction history.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class TransactionHistoryModel extends AbstractTableModel {
    
    private final List<TransactionHistory> allStockItemsSold;
    protected static String[] COLUMN_NAMES = {"Date", "Product Code", "Quantity Sold", "unnit Price"};

    /**
     * @param allStockItemsSold
     */
    public TransactionHistoryModel(List<TransactionHistory> allStockItemsSold) {
        this.allStockItemsSold = allStockItemsSold;
    }

    /**Returns the total rows in allStockItemsSold array list
     * @return an int as ArrayList size
     */
    @Override
    public int getRowCount() {
        return allStockItemsSold.size();
    }
    
    /**
     * Returns the fixed length COLUMN_NAMES array
     * @return an int as COLUMN_NAMES length
     */
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    /** Returns a selected column name
     * @param column
     * @return String as column name
     */
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    /** Returns the value for a selected table cell
     * @param rowIndex
     * @param colIndex
     * @return an object as table cell value
     */
    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        TransactionHistory StockItem = allStockItemsSold.get(rowIndex);
        switch (colIndex) {
            case 0:
                return StockItem.getDateAndTime();
            case 1:
                return StockItem.getProductCode();
            case 2:
                return StockItem.getQuantitySold();
            case 3:
                return StockItem.getUnitPrice();
        }
        return null;
    }
    
}
