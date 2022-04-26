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


/** Represents Ashers’ Sport Collective stock item class.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class ASCStockItem implements ASCStockInterface, Subject{
    
    List<Observer> observer = new ArrayList<>();

    private String productCode;
    private String productTitle;
    private String productDesc;
    private int productPriceInPounds;
    private int productPriceInPence;
    private int qtyInStock;

    /**
     *
     * @param productCode
     * @param productTitle
     * @param productDesc
     * @param productPriceInPounds
     * @param productPriceInPence
     * @param qtyInStock
     */
    

    public ASCStockItem(String productCode, String productTitle, String productDesc, int productPriceInPounds, int productPriceInPence, int qtyInStock) 
    {
        this.productCode = productCode;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPriceInPounds = productPriceInPounds;
        this.productPriceInPence = productPriceInPence;
        this.qtyInStock = qtyInStock;
    }

    /**
     *
     * @param productDepartment
     * @param productTitle
     * @param productDesc
     * @param productPriceInPounds
     * @param productPriceInPence
     * @param qtyInStock
     */
    public ASCStockItem(int productDepartment, String productTitle, String productDesc, int productPriceInPounds,
            int productPriceInPence, int qtyInStock) {
        this.productCode = getProductDepartment(productDepartment) + 1 + (int) (Math.random() * 10000000);
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPriceInPounds = productPriceInPounds;
        this.productPriceInPence = productPriceInPence;
        this.qtyInStock = qtyInStock;
    }

    /**
     *
     * @param productDept
     * @return a String representing a product department
     */
    private static String getProductDepartment(int productDept){
        String productId = "";
        if(productDept == 1) {
            productId = "RUN";
        }
        if(productDept == 3) {
            productId = "CYC";
        }
        if(productDept == 2) {
            productId = "SWM";
        }
        return productId;
    }

    /** Returns a selected product code
     * @return String as product code
     */
    @Override
    public String getProductCode() {
        return productCode;
    }

    /**Returns a selected product title
     * @return String as product title
     */
    @Override
    public String getProductTitle() {
        return productTitle.substring(0, Math.min(productTitle.length(), 120)).stripTrailing();
    }

    /** Returns a selected product description
     * @return String as product description
     */
    @Override
    public String getProductDesc() {
        return productDesc.substring(0, Math.min(productDesc.length(), 500)).stripTrailing().stripLeading();
    }

    /** Returns the pound price of a product
     *
     * @return int as pounds value
     */
    @Override
    public int getProductPriceInPounds() {
        return productPriceInPounds;
    }

    /**Returns the pence price of a product
     * @return int as pence value
     */
    @Override
    public int getProductPriceInPence() {
        return productPriceInPence;
    }

    /**Used for setting a new quantity value
     * @param newQuantity
     */
    @Override
    public void setQuanity(int newQuantity) {
        if(newQuantity >= 0) {
            qtyInStock = newQuantity;
        }
        
        updateObserver();
    }

    /** Returns the product unit price
     * @return double as unit price value
     */
    @Override
    public double getUnitPrice() {
        double pence = (double) productPriceInPence;
        double unitPrice = (pence /100) + productPriceInPounds;
        // return String.format("%d.%02d", productPriceInPounds, pence);
        return unitPrice;
    }

    /** Returns the product unit price
     * @return a formatted String of product unit price
     */
    @Override
    public String getHumanFriendlyUnitPrice() {        
        double pence = (double) productPriceInPence;
        // double unitPrice = (pence /100) + productPriceInPounds;
        return String.format("%d.%02d", productPriceInPounds, productPriceInPence);
    }

    /** Return the current stock quantity
     * @return an int value as quantity stock
     */
    @Override
    public int getQtyInStock() {
        return qtyInStock;
    }

    /** Return a collection of stock items read from CSV file
     * @return n ArrayList of stock item
     */
    public static List<ASCStockItem> loadASCStockItemCSV() {
        List<ASCStockItem> allAscStockItem = null ;

        try (final Scanner fileScanner = new Scanner(new FileReader("./assets/AshersSportsCollective.csv"))) {
            allAscStockItem = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                final String[] columns = fileScanner.nextLine().split(",");
                ASCStockItem stockItem;

                stockItem = new ASCStockItem(columns[0].replaceAll("ï»¿", ""), columns[1].replaceAll("Â", " "), columns[2].replaceAll("Â", " "), Integer.parseInt(columns[3]), Integer.parseInt(columns[4]), Integer.parseInt(columns[5]));

                allAscStockItem.add(stockItem);
            }

        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allAscStockItem;
    }

    /**Used for registering an Observer type
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observer.add(o);
        }

    /**
     *Used for updating all observers
     */
    @Override
    public void updateObserver() {
        for (Observer observers : observer) {
            observers.update();
        }
    
    
    }
   
}
