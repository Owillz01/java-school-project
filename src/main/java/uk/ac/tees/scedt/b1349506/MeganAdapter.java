/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

import java.util.ArrayList;
import java.util.List;

/** Takes an object of Mengda's Sport Collective stock item
 * and adapts it to Ashers’ Sport Collective stock item format.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class MeganAdapter implements ASCStockInterface{
    
    MSMStockItem mSMStockItem;
    List<Observer> observer = new ArrayList<>();
    /**
     *
     * @param _mSMStockItem
     */
    public MeganAdapter (MSMStockItem _mSMStockItem) {
        this.mSMStockItem = _mSMStockItem;
    }

    /** Returns an adapted product code
     * @return a string value as product code
     */
    @Override
    public String getProductCode() {
        String _code = mSMStockItem.getCode();
        int _id = mSMStockItem.getDepartmentId();
        
        String _dept = "";
        switch (_id) {
            case 1:_dept = "RUN";
                    break;
            case 2: _dept = "SWM";
                    break;
            case 3:_dept = "CYC";
                    break;
        }     
        return _dept+"-"+_code+"-MSM";
    }

    /** Returns an adapted product title
     * @return String a product name
     */
    @Override
    public String getProductTitle() {
        return mSMStockItem.getName();
    }

    /** Returns an adapted product description
     * @return String value as product description
     */
    @Override
    public String getProductDesc() {
        return mSMStockItem.getDescription().replaceAll("\u00a0", "").stripLeading();
    }

    /** Returns an adapted product pence price
     * @return an int a pence price
     */
    @Override
    public int getProductPriceInPence() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pence = unitePrice % 100;
        return pence;
    }

    /**Used for setting new value for stock 
     * @param newValue
     */
    @Override
    public void setQuanity(int newValue) {
         mSMStockItem.setQuanity(newValue);
         
         if(mSMStockItem.getQuantityInStock() <= 5) {
             System.out.println("newValue " + newValue);
             updateObserver();
         }
        // int pence = unitePrice % 100;
    }
    
    /** Returns an adapted product pounds price
     * @return an int a pound price value
     */
    @Override
    public int getProductPriceInPounds() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pounds = unitePrice / 100;
        return pounds;
    }

    /**Returns an adapted product unit price
     * @return a double a unit price
     */
    @Override
    public double getUnitPrice() {
        return mSMStockItem.getUnitPrice();
    }

    /**Returns an adapted product human readable unit price
     * @return a formatted String as product price
     */
    @Override
    public String getHumanFriendlyUnitPrice() {
        return mSMStockItem.getHumanFriendlyUnitPrice();
    }

    /** Returns an adapted product stock quantity
     * @return an int a quantity in stock
     */
    @Override
    public int getQtyInStock() {
        return mSMStockItem.getQuantityInStock();
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("Meg register");
                
        observer.add(o);
    }

    @Override
    public void updateObserver() {
        for (Observer observers : observer) {
            System.out.println(this);
            observers.notifyObserver(this);
        }
    }
    
}
