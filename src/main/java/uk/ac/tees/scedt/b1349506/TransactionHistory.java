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

public class TransactionHistory {
    
    private final String dateAndTime;
    private final String productCode;
    private final int quantitySold;
    private final double unitPrice;
    
    /**
     *
     * @param dateAndTime
     * @param productCode
     * @param quantitySold
     * @param unitPrice
     */
    public TransactionHistory(String dateAndTime, String productCode, int quantitySold, double unitPrice) {
        this.dateAndTime = dateAndTime;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
    }

    /**Returns the date and time of a transaction
     * @return String as date and time value
     */
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**Returns the product code of a transaction
     * @return String as product code value
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Returns the product quantity sold in a selected transaction
     * @return int as product quantity value
     */
    public int getQuantitySold() {
        return quantitySold;
    }
    
    /**
     * Returns the unit price of a transaction
     * @return int as unit price value
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**Returns a collection of transaction history read from a CSV file
     * @return an ArrayList of a transaction
     */
    public static List<TransactionHistory> loadModuleCSV() {
        List<TransactionHistory> allStockItemsSold = null ;
        try (final Scanner fileScanner = new Scanner(new FileReader("./assets/AshersSportsCollectiveSold.csv"))) {
            allStockItemsSold = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                final String[] columns = fileScanner.nextLine().split(",");
                TransactionHistory stockItem;
                stockItem = new TransactionHistory(columns[0].replaceAll("ï»¿", ""), columns[1].replaceAll("Â", " "), Integer.parseInt(columns[2]), Double.parseDouble(columns[3]));
                allStockItemsSold.add(stockItem);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allStockItemsSold;
    }
   
    
    
}
