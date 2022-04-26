/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.b1349506;

import java.io.FileNotFoundException;
import java.io.FileReader;

// <-- TODO: Change the package name

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/** Represents a Mengda's Sportymart stock item.
 * @author Steven Mead
 * @version 1.0
 * @since 1.0
 */
public class MSMStockItem {
    private final int departmentId;
    private final String code;
    private final String nameAndDescription;
    private final int unitPrice;
    private int quantityInStock;
    
    
    
    /**
     * Constructor
     * 
     * @param departmentId
     * @param code
     * @param titleAndDescription
     * @param unitPrice
     * @param quantityInStock
     * @since 1.0
     */
    public MSMStockItem(int departmentId, String code, String titleAndDescription, int unitPrice, int quantityInStock) {
        this.departmentId = departmentId;
        this.code = code;
        this.nameAndDescription = titleAndDescription;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Returns the department ID used by Mead's Modernity
     * @return the department id.
     * @since 1.0
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Returns the code of this stock item.
     * @return a string with the 6-digit code.
     * @since 1.0
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Returns the name of this stock item.
     * @return a string with the name.
     * @since 1.0
     */
    public String getName() {            
        return nameAndDescription.substring(0, 59).replaceAll("\u00a0", "").stripTrailing();
    }
    
    /**
     * Return the description of this stock item.
     * @return a string with the description.
     * @since 1.0
     */
    public String getDescription() {
        return nameAndDescription.substring(60, nameAndDescription.length()).replaceAll("\u00a0", "").stripLeading();
    }

    /**
     * Returns the stock item's unit price in pence
     * @return an integer that represents the unit price.
     * @since 1.0
     */
    public int getUnitPrice() {
        return unitPrice;
    }

    /**
     * Return the quantity of this stock item currently available in stock.
     * @return an integer that represents to stock quantity available.
     * @since 1.0
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    public String getHumanFriendlyUnitPrice() {
        
        final int pounds = getUnitPrice() / 100;
        final int pence = getUnitPrice() % 100;
        return String.format("%d.%02d", pounds, pence);
    }
    
    public void setQuanity(int newQuantity) {
        if(newQuantity >= 0) {
            quantityInStock = newQuantity;
        }
    }
        
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%d-%s - %s - %s - UNIT PRICE: £%s - QTY: %d",
                getDepartmentId(),
                getCode(),
                getName(),
                getDescription(),
                getHumanFriendlyUnitPrice(),
                getQuantityInStock());
    }

    /**
     * Load a collection of MSMStockItems into a list
     * @return a list of the Mengda's Sportymart stock items.
     * @since 1.0
     */
    public static List<MSMStockItem> loadStock() {
        final List<MSMStockItem> loadedStock = new ArrayList<>();

        try (final Scanner fileScanner = new Scanner(new FileReader("./assets/MengdasSportyMart.csv"))) {
            // loadedStock = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                final String[] columns = fileScanner.nextLine().split(",");
                MSMStockItem stockItem;
                String idColumn;
                if(columns[0].length() > 1) {
                    idColumn = columns[0].substring(3);
                }else{
                    idColumn = columns[0];
                }
                // System.out.println(idColumn + "<<<<<");
                stockItem = new MSMStockItem( Integer.parseInt(idColumn), columns[1], columns[2].replaceAll("Â", " "), Integer.parseInt(columns[3]), Integer.parseInt(columns[4]));

                loadedStock.add(stockItem);
            }

        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //------------------------------------------------------------------
        // TODO: Add code to load CSV file.
        //------------------------------------------------------------------

        return loadedStock;
    }


    
}
