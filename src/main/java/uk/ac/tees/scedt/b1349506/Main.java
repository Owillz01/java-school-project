/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.List;

/**
 *
 * @author godsw
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here

        List<ASCStockItem> allStockItem = ASCStockItem.loadASCStockItemCSV();

        for ( ASCStockItem stock : allStockItem) {
            System.out.println(stock.getProductCode() + " "+ " " + stock.getProductTitle() + stock.getProductDesc() + " " + stock.getProductPriceInPounds() + " " + stock.getProductPriceInPence() + " " + stock.getQtyInStock() );
        }
    }
    
}
