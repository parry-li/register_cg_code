package com.tdr.registrationV3.bean;

import java.util.List;

public class InsuranceBean {


    /**
     * id : 5
     * name : 意外险
     * subtitle : 测试
     * subsystemId : 13
     * vehicleType : 1
     * isChoose : 1
     * sort : 2
     * invoiceToken : null
     * baseAmount : null
     * packages : [{"id":8,"name":"套餐1","isOnline":0,"onlineConfigId":null,"schemeId":null,"deadline":2,"isOldVehicle":0,"price":20,"displayList":"Police,Registrant","invoiceAmount":null},{"id":10,"name":"套餐2","isOnline":1,"onlineConfigId":1,"schemeId":1,"deadline":1,"isOldVehicle":0,"price":10,"displayList":"Police,Seller,Registrant","invoiceAmount":null}]
     */

    private int id;
    private String name;
    private String subtitle;
    private int subsystemId;
    private int vehicleType;
    private int isChoose;
    private int sort;

    private Object invoiceToken;
    private Object baseAmount;

    private List<PackagesBean> packages;

    /*额外添加，判断是否有选择*/
    private boolean isChecked;


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(int subsystemId) {
        this.subsystemId = subsystemId;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Object getInvoiceToken() {
        return invoiceToken;
    }

    public void setInvoiceToken(Object invoiceToken) {
        this.invoiceToken = invoiceToken;
    }

    public Object getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Object baseAmount) {
        this.baseAmount = baseAmount;
    }

    public List<PackagesBean> getPackages() {
        return packages;
    }

    public void setPackages(List<PackagesBean> packages) {
        this.packages = packages;
    }

    public static class PackagesBean {
        /**
         * id : 8
         * name : 套餐1
         * isOnline : 0
         * onlineConfigId : null
         * schemeId : null
         * deadline : 2
         * isOldVehicle : 0
         * price : 20
         * displayList : Police,Registrant
         * invoiceAmount : null
         */

        private int id;
        private String name;
        private int isOnline;
        private Object onlineConfigId;
        private Object schemeId;
        private int deadline;
        private int isOldVehicle;
        private int price;
        private String displayList;
        private Object invoiceAmount;
        /*额外添加   是否选择*/
        private boolean isCheck;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(int isOnline) {
            this.isOnline = isOnline;
        }

        public Object getOnlineConfigId() {
            return onlineConfigId;
        }

        public void setOnlineConfigId(Object onlineConfigId) {
            this.onlineConfigId = onlineConfigId;
        }

        public Object getSchemeId() {
            return schemeId;
        }

        public void setSchemeId(Object schemeId) {
            this.schemeId = schemeId;
        }

        public int getDeadline() {
            return deadline;
        }

        public void setDeadline(int deadline) {
            this.deadline = deadline;
        }

        public int getIsOldVehicle() {
            return isOldVehicle;
        }

        public void setIsOldVehicle(int isOldVehicle) {
            this.isOldVehicle = isOldVehicle;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDisplayList() {
            return displayList;
        }

        public void setDisplayList(String displayList) {
            this.displayList = displayList;
        }

        public Object getInvoiceAmount() {
            return invoiceAmount;
        }

        public void setInvoiceAmount(Object invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
        }
    }
}
