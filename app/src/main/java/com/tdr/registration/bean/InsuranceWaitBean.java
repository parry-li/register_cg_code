package com.tdr.registration.bean;

import java.io.Serializable;
import java.util.List;

public class InsuranceWaitBean implements Serializable {

    /**
     * id : 1579596175184
     * plateNumber : 1265
     * ownerName : yjs
     * cardId : 9876511
     * cardType : 3
     * vehicleBrand : 11123
     * vehicleBrandName : 我被噶掉了-
     * colorId : 3
     * colorName : 绿色
     * colorSecondId : 9
     * colorSecondName : 香槟银
     * engineNumber : 123
     * shelvesNumber : 123
     * phone1 : 13423451234
     * residentAddress : 类型类型类型类型类型
     * policyList : [{"policyId":15228883194990592,"policyNumber":null,"insuranceConfigId":5,"insurancePackageId":10,"insuranceType":"意外险","insuranceSubtitle":"测试","price":10,"deadLine":1,"insuranceBuyDate":"2020-01-21","policyStartDate":"2020-01-22","message":"推送失败","error":1}]
     */

    private long id;
    private String plateNumber;
    private String ownerName;
    private String cardId;
    private int cardType;
    private String cardName;
    private String vehicleBrand;
    private String vehicleBrandName;
    private String colorId;
    private String colorName;
    private String colorSecondId;
    private String colorSecondName;
    private String engineNumber;
    private String shelvesNumber;
    private String phone1;
    private String residentAddress;
    private List<PolicyListBean> policyList;


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorSecondId() {
        return colorSecondId;
    }

    public void setColorSecondId(String colorSecondId) {
        this.colorSecondId = colorSecondId;
    }

    public String getColorSecondName() {
        return colorSecondName;
    }

    public void setColorSecondName(String colorSecondName) {
        this.colorSecondName = colorSecondName;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getShelvesNumber() {
        return shelvesNumber;
    }

    public void setShelvesNumber(String shelvesNumber) {
        this.shelvesNumber = shelvesNumber;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    public List<PolicyListBean> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<PolicyListBean> policyList) {
        this.policyList = policyList;
    }

    public static class PolicyListBean {
        /**
         * policyId : 15228883194990592
         * policyNumber : null
         * insuranceConfigId : 5
         * insurancePackageId : 10
         * insuranceType : 意外险
         * insuranceSubtitle : 测试
         * price : 10.0
         * deadLine : 1
         * insuranceBuyDate : 2020-01-21
         * policyStartDate : 2020-01-22
         * message : 推送失败
         * error : 1
         */

        private long policyId;
        private Object policyNumber;
        private int insuranceConfigId;
        private int insurancePackageId;
        private String insuranceType;
        private String insuranceSubtitle;
        private double price;
        private int deadLine;
        private String insuranceBuyDate;
        private String policyStartDate;
        private String message;
        private int error;

        public long getPolicyId() {
            return policyId;
        }

        public void setPolicyId(long policyId) {
            this.policyId = policyId;
        }

        public Object getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(Object policyNumber) {
            this.policyNumber = policyNumber;
        }

        public int getInsuranceConfigId() {
            return insuranceConfigId;
        }

        public void setInsuranceConfigId(int insuranceConfigId) {
            this.insuranceConfigId = insuranceConfigId;
        }

        public int getInsurancePackageId() {
            return insurancePackageId;
        }

        public void setInsurancePackageId(int insurancePackageId) {
            this.insurancePackageId = insurancePackageId;
        }

        public String getInsuranceType() {
            return insuranceType;
        }

        public void setInsuranceType(String insuranceType) {
            this.insuranceType = insuranceType;
        }

        public String getInsuranceSubtitle() {
            return insuranceSubtitle;
        }

        public void setInsuranceSubtitle(String insuranceSubtitle) {
            this.insuranceSubtitle = insuranceSubtitle;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getDeadLine() {
            return deadLine;
        }

        public void setDeadLine(int deadLine) {
            this.deadLine = deadLine;
        }

        public String getInsuranceBuyDate() {
            return insuranceBuyDate;
        }

        public void setInsuranceBuyDate(String insuranceBuyDate) {
            this.insuranceBuyDate = insuranceBuyDate;
        }

        public String getPolicyStartDate() {
            return policyStartDate;
        }

        public void setPolicyStartDate(String policyStartDate) {
            this.policyStartDate = policyStartDate;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }
    }
}
