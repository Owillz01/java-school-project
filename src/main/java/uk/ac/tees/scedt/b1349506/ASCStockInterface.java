/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.List;

/** Represents an Ashers’ Sport Collective stock item Interface.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public interface ASCStockInterface {
       
    /**
     * Returns the product code of the selected Ashers’ stock item object
     * @return a string representing a product code.
     * @since 1.0
     */
    public String getProductCode();

    /**
     *
     * @return String
     */
    public String getProductTitle();

    /**
     *
     * @return String
     */
    public String getProductDesc();

    /**
     *
     * @return int
     */
    public int getProductPriceInPence();

    public int getProductPriceInPounds();

    public double getUnitPrice();

    public String getHumanFriendlyUnitPrice();

    public int getQtyInStock();


    /**
     *
     * @param value
     */
    public void setQuanity(int value);
    
    
}
