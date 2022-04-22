/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here

        List<ASCStockItem> allAscStockItem = ASCStockItem.loadASCStockItemCSV();
        List<MSMStockItem> allMeganStockItem = MSMStockItem.loadStock();
        List<MeganAdapter> allMeganAdaptedStockItem = new ArrayList<>();
        adapteMsmStockItems(allMeganStockItem, allMeganAdaptedStockItem);
               
        List<ASCStockInterface> allStockItems = new ArrayList<>();

        allStockItems.addAll(allMeganAdaptedStockItem);
        allStockItems.addAll(allAscStockItem);

        for ( ASCStockInterface stock : allStockItems) {
            System.out.println(stock.getProductCode() + " "+ " " + stock.getProductTitle() + stock.getProductDesc() + " " + stock.getProductPriceInPounds() + " " + stock.getProductPriceInPence() + " " + stock.getQtyInStock() );
        }
        

//        for (MSMStockItem stock : allMeganStockItem) {
//            System.out.println(stock.getCode() + " "+ " " + stock.getName() + " "+ " "+stock.getDescription() + " "+ " " +stock.getUnitPrice() + " "+ " "+ stock.getQuantityInStock() );
//        }
    }

    private static void adapteMsmStockItems(List<MSMStockItem> _allMeganStockItem, List<MeganAdapter> allMeganAdaptedStockItem) {
        for (MSMStockItem stock : _allMeganStockItem) {
          MeganAdapter adaptedItem = new MeganAdapter(stock);
            allMeganAdaptedStockItem.add(adaptedItem);
        }
    }
    
}
