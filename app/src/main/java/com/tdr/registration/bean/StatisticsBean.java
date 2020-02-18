package com.tdr.registration.bean;

import java.util.List;

public class StatisticsBean  {


    /**
     * totalNumber : 10
     * hasRfidNumber : 9
     * noRfidNumber : 0
     * newVehicleNumber : 9
     * oldVehicleNumber : 0
     * plateChangeNumber : 0
     * allChangeNumber : 0
     * hasPolicyNumber : 6
     * totalAmount : 462
     * policyList : [{"name":"意外险","quantity":14,"amount":190,"details":[{"name":"套餐1","quantity":5,"amount":100,"details":[]},{"name":"套餐2","quantity":9,"amount":90,"details":[]}]},{"name":"yjs保险","quantity":10,"amount":136,"details":[{"name":"啥都保","quantity":3,"amount":36,"details":[]},{"name":"啥都保","quantity":3,"amount":60,"details":[]},{"name":"啥都保(续)","quantity":4,"amount":40,"details":[]}]},{"name":"有保险","quantity":8,"amount":136,"details":[{"name":"啊手动阀","quantity":3,"amount":36,"details":[]},{"name":"阿斯蒂","quantity":5,"amount":100,"details":[]}]}]
     */

    private int totalNumber;
    private int hasRfidNumber;
    private int noRfidNumber;
    private int newVehicleNumber;
    private int oldVehicleNumber;
    private int plateChangeNumber;
    private int allChangeNumber;
    private int hasPolicyNumber;
    private int totalAmount;
    private List<PolicyListBean> policyList;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getHasRfidNumber() {
        return hasRfidNumber;
    }

    public void setHasRfidNumber(int hasRfidNumber) {
        this.hasRfidNumber = hasRfidNumber;
    }

    public int getNoRfidNumber() {
        return noRfidNumber;
    }

    public void setNoRfidNumber(int noRfidNumber) {
        this.noRfidNumber = noRfidNumber;
    }

    public int getNewVehicleNumber() {
        return newVehicleNumber;
    }

    public void setNewVehicleNumber(int newVehicleNumber) {
        this.newVehicleNumber = newVehicleNumber;
    }

    public int getOldVehicleNumber() {
        return oldVehicleNumber;
    }

    public void setOldVehicleNumber(int oldVehicleNumber) {
        this.oldVehicleNumber = oldVehicleNumber;
    }

    public int getPlateChangeNumber() {
        return plateChangeNumber;
    }

    public void setPlateChangeNumber(int plateChangeNumber) {
        this.plateChangeNumber = plateChangeNumber;
    }

    public int getAllChangeNumber() {
        return allChangeNumber;
    }

    public void setAllChangeNumber(int allChangeNumber) {
        this.allChangeNumber = allChangeNumber;
    }

    public int getHasPolicyNumber() {
        return hasPolicyNumber;
    }

    public void setHasPolicyNumber(int hasPolicyNumber) {
        this.hasPolicyNumber = hasPolicyNumber;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<PolicyListBean> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<PolicyListBean> policyList) {
        this.policyList = policyList;
    }

    public static class PolicyListBean {
        /**
         * name : 意外险
         * quantity : 14
         * amount : 190
         * details : [{"name":"套餐1","quantity":5,"amount":100,"details":[]},{"name":"套餐2","quantity":9,"amount":90,"details":[]}]
         */

        private String name;
        private int quantity;
        private int amount;
        private List<DetailsBean> details;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public List<DetailsBean> getDetails() {
            return details;
        }

        public void setDetails(List<DetailsBean> details) {
            this.details = details;
        }

        public static class DetailsBean {
            /**
             * name : 套餐1
             * quantity : 5
             * amount : 100
             * details : []
             */

            private String name;
            private int quantity;
            private int amount;
            private List<?> details;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public List<?> getDetails() {
                return details;
            }

            public void setDetails(List<?> details) {
                this.details = details;
            }
        }
    }
}
