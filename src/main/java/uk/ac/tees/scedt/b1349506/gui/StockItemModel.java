/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.scedt.b1349506.ASCStockItem;

/**
 *
 * @author godsw
 */
public class StockItemModel extends AbstractTableModel{
    
    
    
    private List<ASCStockItem> allStockItem;
    protected static String[] COLUMN_NAMES = {"ID", "Tile", "Description", "Unit Price (pounds)", "unit Price (pence)", "Quantity"};
    public StockItemModel(List<ASCStockItem> allStockItem) {
        
        this.allStockItem = allStockItem;
    }
    
    @Override
    public int getRowCount() {
        return allStockItem.size();
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
        ASCStockItem StockItem = allStockItem.get(rowIndex);
        switch(colIndex) {
            case 0 :return StockItem.getProductCode();
            case 1 :return StockItem.getProductTitle();
            case 2 : return StockItem.getProductDesc();
            case 3 : return StockItem.getProductPriceInPounds();
            case 4 : return StockItem.getProductPriceInPence();
            case 5 : return StockItem.getQtyInStock();
        }
        return null;
    }
    
}
