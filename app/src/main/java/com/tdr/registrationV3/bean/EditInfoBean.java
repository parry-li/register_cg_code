package com.tdr.registrationV3.bean;

import java.util.List;

public class EditInfoBean {


    /**
     * id : 1579395071326
     * subsystemId : null
     * billType : null
     * baseInfo : {"vehicleType":1,"vehicleBrand":"11123","vehicleBrandName":null,"colorId":"3","colorName":null,"colorSecondId":"3","colorSecondName":null,"plateNumber":"1234"}
     * labelInfo : {"lableList":[{"index":1,"lableType":"8001","lableNumber":"80010000150596"},{"index":2,"lableType":"8701","lableNumber":"87010000194584"}],"engineNumber":"123","shelvesNumber":"123"}
     * buyInfo : {"buyDate":"2020-01-01","buyPrice":123,"photoList":[{"index":1,"photoType":1,"photo":"bcf89084042f337439d39d754f146939"},{"index":2,"photoType":2,"photo":"29690c1e3ddc6569b28df2a662072f5a"}]}
     * ownerInfo : {"ownerName":"13","cardType":4,"cardName":null,"cardId":"123","phone1":"13212312312","phone2":"13212312312","residentAddress":"123123","remark":"12313"}
     * insuranceInfo : null
     * createTime : 2020-01-19T08:51:14
     * alterTime : null
     * policyList : [{"policyNumber":null,"insuranceConfigId":5,"insurancePackageId":10,"insuranceType":"意外险","price":10,"deadLine":1,"insuranceBuyDate":"2020-01-19"}]
     */

    private long id;
    private Object subsystemId;
    private Object billType;
    private BaseInfoBean baseInfo;
    private LabelInfoBean labelInfo;
    private BuyInfoBean buyInfo;
    private OwnerInfoBean ownerInfo;
    private Object insuranceInfo;
    private String createTime;
    private Object alterTime;
    private List<PolicyListBean> policyList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(Object subsystemId) {
        this.subsystemId = subsystemId;
    }

    public Object getBillType() {
        return billType;
    }

    public void setBillType(Object billType) {
        this.billType = billType;
    }

    public BaseInfoBean getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfoBean baseInfo) {
        this.baseInfo = baseInfo;
    }

    public LabelInfoBean getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(LabelInfoBean labelInfo) {
        this.labelInfo = labelInfo;
    }

    public BuyInfoBean getBuyInfo() {
        return buyInfo;
    }

    public void setBuyInfo(BuyInfoBean buyInfo) {
        this.buyInfo = buyInfo;
    }

    public OwnerInfoBean getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(OwnerInfoBean ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public Object getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(Object insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Object alterTime) {
        this.alterTime = alterTime;
    }

    public List<PolicyListBean> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<PolicyListBean> policyList) {
        this.policyList = policyList;
    }

    public static class BaseInfoBean {
        /**
         * vehicleType : 1
         * vehicleBrand : 11123
         * vehicleBrandName : null
         * colorId : 3
         * colorName : null
         * colorSecondId : 3
         * colorSecondName : null
         * plateNumber : 1234
         */

        private int vehicleType;
        private String vehicleBrand;
        private String vehicleBrandName;
        private String colorId;
        private String colorName;
        private String colorSecondId;
        private Object colorSecondName;
        private String plateNumber;

        public int getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(int vehicleType) {
            this.vehicleType = vehicleType;
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

        public Object getColorSecondName() {
            return colorSecondName;
        }

        public void setColorSecondName(Object colorSecondName) {
            this.colorSecondName = colorSecondName;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }
    }

    public static class LabelInfoBean {
        /**
         * lableList : [{"index":1,"lableType":"8001","lableNumber":"80010000150596"},{"index":2,"lableType":"8701","lableNumber":"87010000194584"}]
         * engineNumber : 123
         * shelvesNumber : 123
         */

        private String engineNumber;
        private String shelvesNumber;
        private List<LableListBean> lableList;

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

        public List<LableListBean> getLableList() {
            return lableList;
        }

        public void setLableList(List<LableListBean> lableList) {
            this.lableList = lableList;
        }

        public static class LableListBean {
            /**
             * index : 1
             * lableType : 8001
             * lableNumber : 80010000150596
             */

            private int index;
            private String lableType;
            private String lableNumber;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getLableType() {
                return lableType;
            }

            public void setLableType(String lableType) {
                this.lableType = lableType;
            }

            public String getLableNumber() {
                return lableNumber;
            }

            public void setLableNumber(String lableNumber) {
                this.lableNumber = lableNumber;
            }
        }
    }

    public static class BuyInfoBean {
        /**
         * buyDate : 2020-01-01
         * buyPrice : 123.0
         * photoList : [{"index":1,"photoType":1,"photo":"bcf89084042f337439d39d754f146939"},{"index":2,"photoType":2,"photo":"29690c1e3ddc6569b28df2a662072f5a"}]
         */

        private String buyDate;
        private double buyPrice;
        private List<PhotoListBean> photoList;

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
        }

        public double getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(double buyPrice) {
            this.buyPrice = buyPrice;
        }

        public List<PhotoListBean> getPhotoList() {
            return photoList;
        }

        public void setPhotoList(List<PhotoListBean> photoList) {
            this.photoList = photoList;
        }

        public static class PhotoListBean {
            /**
             * index : 1
             * photoType : 1
             * photo : bcf89084042f337439d39d754f146939
             */

            private int index;
            private int photoType;
            private String photo;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public int getPhotoType() {
                return photoType;
            }

            public void setPhotoType(int photoType) {
                this.photoType = photoType;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }

    public static class OwnerInfoBean {
        /**
         * ownerName : 13
         * cardType : 4
         * cardName : null
         * cardId : 123
         * phone1 : 13212312312
         * phone2 : 13212312312
         * residentAddress : 123123
         * remark : 12313
         */

        private String ownerName;
        private int cardType;
        private Object cardName;
        private String cardId;
        private String phone1;
        private String phone2;
        private String residentAddress;
        private String remark;

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public int getCardType() {
            return cardType;
        }

        public void setCardType(int cardType) {
            this.cardType = cardType;
        }

        public Object getCardName() {
            return cardName;
        }

        public void setCardName(Object cardName) {
            this.cardName = cardName;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getPhone1() {
            return phone1;
        }

        public void setPhone1(String phone1) {
            this.phone1 = phone1;
        }

        public String getPhone2() {
            return phone2;
        }

        public void setPhone2(String phone2) {
            this.phone2 = phone2;
        }

        public String getResidentAddress() {
            return residentAddress;
        }

        public void setResidentAddress(String residentAddress) {
            this.residentAddress = residentAddress;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static class PolicyListBean {
        /**
         * policyNumber : null
         * insuranceConfigId : 5
         * insurancePackageId : 10
         * insuranceType : 意外险
         * price : 10.0
         * deadLine : 1
         * insuranceBuyDate : 2020-01-19
         */

        private Object policyNumber;
        private int insuranceConfigId;
        private int insurancePackageId;
        private String insuranceType;
        private double price;
        private int deadLine;
        private String insuranceBuyDate;



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
    }
}
