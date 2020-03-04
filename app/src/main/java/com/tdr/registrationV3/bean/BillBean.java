package com.tdr.registrationV3.bean;

public class BillBean {


    /**
     * billType : 3
     * id : 66
     * isBill : true
     */

    private int billType;
    private int id;
    private boolean isBill;

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsBill() {
        return isBill;
    }

    public void setIsBill(boolean isBill) {
        this.isBill = isBill;
    }
}
