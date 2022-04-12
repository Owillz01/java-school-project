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

/**
 *
 * @author godsw
 */


public class ASCStockItem {
    private String productCode;
    private String productTitle;
    private String productDesc;
    private double productPriceInPounds;
    private int productPriceInPence;
    private int qtyInStock;
    

    // public ASCStockItem (String _productCode, String _productTitle, String _productDesc, int _productPriceInPounds, int _productPriceInPence, int _qtyInStock) {
    //     this.productCode = _productCode;
    //     this.productTitle = _productTitle;
    //     this.productDesc = _productDesc;
    //      this.productPriceInPounds = _productPriceInPounds;
    //      this.productPriceInPence = _productPriceInPence;
    //      this.qtyInStock =  _qtyInStock;
    // }
    

    public ASCStockItem(String productCode, String productTitle, String productDesc, int productPriceInPounds,
            int productPriceInPence, int qtyInStock) {
        this.productCode = productCode;
        this.productTitle = productTitle.substring(0, Math.min(productTitle.length(), 120));
        this.productDesc = productDesc.substring(0, Math.min(productTitle.length(), 500));
        this.productPriceInPounds = productPriceInPounds;
        this.productPriceInPence = productPriceInPence;
        this.qtyInStock = qtyInStock;
        getProductDepartment(productTitle);
    }

    public ASCStockItem(String productTitle, String productDesc, int productPriceInPounds,
            int productPriceInPence, int qtyInStock) {
        this.productCode = getProductDepartment(productTitle) + 1 + (int) (Math.random() * 10000000);
        this.productTitle = productTitle.substring(0, Math.min(productTitle.length(), 120));
        this.productDesc = productDesc.substring(0, Math.min(productTitle.length(), 500));
        this.productPriceInPounds = +productPriceInPounds;
        this.productPriceInPence = +productPriceInPence;
        this.qtyInStock = qtyInStock;
    }

    private static String getProductDepartment(String productTitle){
        String productId = "";
        if(productTitle.toUpperCase().contains("RUN")) {
            productId = "RUN";
        }
        if(productTitle.toUpperCase().contains("CYC")) {
            productId = "CYC";
        }
        if(productTitle.toUpperCase().contains("SWIM")) {
            productId = "SWM";
        }
        return productId;
    }

    public String getProductCode() {
        return productCode;
    }



    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public double getProductPriceInPounds() {
        return productPriceInPounds;
    }

    public int getProductPriceInPence() {
        return productPriceInPence;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void addStockQuantity() {
        qtyInStock++;
    }

    public void removeStockQuantity() {
        qtyInStock--;
    }

    public static List<ASCStockItem> loadASCStockItemCSV() {
        List<ASCStockItem> allStockItem = null ;

        try (final Scanner fileScanner = new Scanner(new FileReader("./assets/AshersSportsCollective.csv"))) {
            allStockItem = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                final String[] columns = fileScanner.nextLine().split(",");
                ASCStockItem stockItem;

                stockItem = new ASCStockItem(columns[0], columns[1], columns[2], Integer.parseInt(columns[3]), Integer.parseInt(columns[4]), Integer.parseInt(columns[5]));

                allStockItem.add(stockItem);
            }

        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allStockItem;
    }


//      public String moduleResults() {
//         // TODO - Build a string that is a summary of all the marks
//         modulesMarks.forEach((key, value) -> {  
//            String grade = markToLetterGrade(value);
//            Module module = key;
//            sBuilder.append("      ");
//            sBuilder.append(module.getCode());
//            sBuilder.append(" : ");
//            sBuilder.append(grade);
//            sBuilder.append("\t");
// //            
//          });
        
//         return sBuilder.toString();
//     }

    
}
