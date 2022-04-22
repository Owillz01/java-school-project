/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.scedt.b1349506.TransactionHistory;

/**
 *
 * @author godsw
 */
public class TransactionHistoryModel extends AbstractTableModel {
    
    private List<TransactionHistory> allStockItemsSold;
    protected static String[] COLUMN_NAMES = {"Date", "Product Code", "Quantity Sold", "unnit Price"};

    public TransactionHistoryModel(List<TransactionHistory> allStockItemsSold) {

        this.allStockItemsSold = allStockItemsSold;
    }

    @Override
    public int getRowCount() {
        return allStockItemsSold.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
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
