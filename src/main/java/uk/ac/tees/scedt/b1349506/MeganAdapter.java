/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1349506;

/**
 *
 * @author godsw
 */
public class MeganAdapter implements ASCStockInterface{
    MSMStockItem mSMStockItem;
    public MeganAdapter (MSMStockItem _mSMStockItem) {
        this.mSMStockItem = _mSMStockItem;
    }

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

    @Override
    public String getProductTitle() {
        return mSMStockItem.getName();
    }

    @Override
    public String getProductDesc() {
        return mSMStockItem.getDescription();
    }

    @Override
    public int getProductPriceInPence() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pence = unitePrice % 100;
        return pence;
    }
    
    @Override
    public double getProductPriceInPounds() {
        int unitePrice = mSMStockItem.getUnitPrice();
        int pounds = unitePrice / 100;
        return pounds;
    }

    @Override
    public double getUnitPrice() {
        return mSMStockItem.getUnitPrice();
    }

    @Override
    public int getQtyInStock() {
        return mSMStockItem.getQuantityInStock();
    }

     @Override
     public void addStockQuantity() {
//         return true;
        mSMStockItem.addStock();
     }

     @Override
     public void removeStockQuantity() {
         mSMStockItem.sellStock();
     }
    
}
