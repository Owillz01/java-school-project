/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.List;

/**
 *
 * @author godsw
 */
public interface ASCStockInterface {
       
    public String getProductCode();
    public String getProductTitle();
    public String getProductDesc();
    public int getProductPriceInPence();
    public double getProductPriceInPounds();
    public double getUnitPrice();
    public int getQtyInStock();
    public void addStockQuantity(); 
    public void removeStockQuantity();
    // public List<ASCStockItem> loadASCStockItemCSV();
    
}
