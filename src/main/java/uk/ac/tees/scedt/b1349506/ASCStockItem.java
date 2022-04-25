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


/** Represents an Ashers’ Sport Collective stock item.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class ASCStockItem implements ASCStockInterface, Observed{
    
    List<Observer> observer = new ArrayList<>();

    /**
     *
     */
    private String productCode;

    /**
     *
     */
    private String productTitle;

    /**
     *
     */
    private String productDesc;

    /**
     *
     */
    private int productPriceInPounds;

    /**
     *
     */
    private int productPriceInPence;

    /**
     *
     */
    private int qtyInStock;
    

    // public ASCStockItem (String _productCode, String _productTitle, String _productDesc, int _productPriceInPounds, int _productPriceInPence, int _qtyInStock) {
    //     this.productCode = _productCode;
    //     this.productTitle = _productTitle;
    //     this.productDesc = _productDesc;
    //      this.productPriceInPounds = _productPriceInPounds;
    //      this.productPriceInPence = _productPriceInPence;
    //      this.qtyInStock =  _qtyInStock;
    // }

    /**
     *
     * @param productCode
     * @param productTitle
     * @param productDesc
     * @param productPriceInPounds
     * @param productPriceInPence
     * @param qtyInStock
     */
    

    public ASCStockItem(String productCode, String productTitle, String productDesc, int productPriceInPounds,
            int productPriceInPence, int qtyInStock) {
        this.productCode = productCode;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPriceInPounds = productPriceInPounds;
        this.productPriceInPence = productPriceInPence;
        this.qtyInStock = qtyInStock;
        // getProductDepartment(productTitle);
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
     * @return
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

    /**
     *
     * @return
     */
    @Override
    public String getProductCode() {
        return productCode;
    }

    /**
     *
     * @return
     */
    @Override
    public String getProductTitle() {
        return productTitle.substring(0, Math.min(productTitle.length(), 120)).stripTrailing();
    }

    /**
     *
     * @return
     */
    @Override
    public String getProductDesc() {
        return productDesc.substring(0, Math.min(productDesc.length(), 500)).stripTrailing().stripLeading();
    }

    /**
     *
     * @return
     */
    @Override
    public int getProductPriceInPounds() {
        return productPriceInPounds;
    }

    /**
     *
     * @return
     */
    @Override
    public int getProductPriceInPence() {
        return productPriceInPence;
    }

    /**
     *
     * @param newQuantity
     */
    @Override
    public void setQuanity(int newQuantity) {
        if(newQuantity >= 0) {
            qtyInStock = newQuantity;
        }
        
        updateObserver();
    }

    /**
     *
     * @return
     */
    @Override
    public double getUnitPrice() {
        double pence = (double) productPriceInPence;
        double unitPrice = (pence /100) + productPriceInPounds;
        // return String.format("%d.%02d", productPriceInPounds, pence);
        return unitPrice;
    }

    @Override
    public String getHumanFriendlyUnitPrice() {
        
        double pence = (double) productPriceInPence;
        // double unitPrice = (pence /100) + productPriceInPounds;
        return String.format("%d.%02d", productPriceInPounds, productPriceInPence);
    }

    /**
     *
     * @return
     */
    @Override
    public int getQtyInStock() {
        return qtyInStock;
    }

    /**
     *
     */

    /**
     *
     * @return
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

    @Override
    public void registerObserver(Observer o) {
        observer.add(o);
        }

    @Override
    public void updateObserver() {
        for (Observer observers : observer) {
            observers.update();
        }
    
    
    }
   
}
