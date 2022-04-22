/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

/** Takes an object of Mengda's Sport Collective stock item
 * and adapts it to Ashers’ Sport Collective stock item.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class MeganAdapter implements ASCStockInterface{

    /**
     *
     */
    MSMStockItem mSMStockItem;

    /**
     *
     * @param _mSMStockItem
     */
    public MeganAdapter (MSMStockItem _mSMStockItem) {
        this.mSMStockItem = _mSMStockItem;
    }

    /**
     *
     * @return
     */
    @Override
    public String getProductCode() {
        String _code = mSMStockItem.getCode();
        int _id = mSMStockItem.getDepartmentId();
        String _dept = "";
        switch (_id) {
            case 1:_dept = "RUN";
            case 2: _dept = "SWM";
            case 3:_dept = "CYC";
        }
        
        return _dept+"-"+_code+"-MSM";
    }

    /**
     *
     * @return
     */
    @Override
    public String getProductTitle() {
        return mSMStockItem.getName();
    }

    /**
     *
     * @return
     */
    @Override
    public String getProductDesc() {
        return mSMStockItem.getDescription();
    }

    /**
     *
     * @return
     */
    @Override
    public int getProductPriceInPence() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pence = unitePrice % 100;
        return pence;
    }

    /**
     *
     * @param newValue
     */
    @Override
    public void setQuanity(int newValue) {
         mSMStockItem.setQuanity(newValue);
        // int pence = unitePrice % 100;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getProductPriceInPounds() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pounds = unitePrice / 100;
        return pounds;
    }

    /**
     *
     * @return
     */
    @Override
    public double getUnitPrice() {
        return mSMStockItem.getUnitPrice();
    }

    @Override
    public String getHumanFriendlyUnitPrice() {
        return mSMStockItem.getHumanFriendlyUnitPrice();
    }

    /**
     *
     * @return
     */
    @Override
    public int getQtyInStock() {
        return mSMStockItem.getQuantityInStock();
    }

    /**
     *
     */
    
}
