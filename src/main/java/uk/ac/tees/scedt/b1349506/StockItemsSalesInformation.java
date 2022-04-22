/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Represents a list of all stock item sold.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class StockItemsSalesInformation {
    
    private String dateAndTime;
    private String productCode;
    private int quantitySold;
    private int unitPrice;
    
    public StockItemsSalesInformation(String dateAndTime, String productCode, int unitPrice, int quantitySold) {
        this.dateAndTime = dateAndTime;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getProductCode() {
        return productCode;
    }


    public int getQuantitySold() {
        return quantitySold;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public static List<StockItemsSalesInformation> loadASCStockItemCSV() {
        List<StockItemsSalesInformation> allStockItemsSold = null ;

        try (final Scanner fileScanner = new Scanner(new FileReader("./assets/AshersSportsCollectiveSold.csv"))) {
            allStockItemsSold = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                final String[] columns = fileScanner.nextLine().split(",");
                StockItemsSalesInformation stockItem;

                stockItem = new StockItemsSalesInformation(columns[0].replaceAll("ï»¿", ""), columns[1].replaceAll("Â", " "), Integer.parseInt(columns[2]), Integer.parseInt(columns[3]));

                allStockItemsSold.add(stockItem);
            }

        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allStockItemsSold;
    }
   
    
    
}
