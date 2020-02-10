package com.tdr.registration.bean;

import java.util.List;

public class EditInfoBean {


    /**
     * id : 1
     * subsystemId : null
     * billType : null
     * baseInfo : {"vehicleType":1,"vehicleBrand":"1","vehicleBrandName":"ces ","colorId":"1","colorName":"23432","colorSecondId":"2","colorSecondName":"cees","plateNumber":"12"}
     * labelInfo : {"lableList":[{"index":1,"lableType":"8102","lableNumber":"81021234567890"},{"index":2,"lableType":"8102","lableNumber":"81021112223336"}],"engineNumber":"123","shelvesNumber":"123"}
     * buyInfo : {"buyDate":"2020-01-16","buyPrice":null,"photoList":[{"index":1,"photoType":1,"photo":"photo address"},{"index":2,"photoType":2,"photo":"图片地址222222"},{"index":3,"photoType":3,"photo":"图片地址3"}]}
     * ownerInfo : {"ownerName":"新车主姓名6","cardType":1,"cardName":"身份证","cardId":"370724199406024785","phone1":"新车主联系电话6","phone2":"新车主备用电话6","residentAddress":"新车主居住地址6","remark":null}
     * insuranceInfo : null
     * createTime : 2020-01-10T14:43:52
     * alterTime : 2020-01-10T15:00:16
     * policyList : []
     */

    private int id;
    private Object subsystemId;
    private Object billType;
    private BaseInfoBean baseInfo;
    private LabelInfoBean labelInfo;
    private BuyInfoBean buyInfo;
    private OwnerInfoBean ownerInfo;
    private Object insuranceInfo;
    private String createTime;
    private String alterTime;
    private List<?> policyList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }

    public List<?> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<?> policyList) {
        this.policyList = policyList;
    }

    public static class BaseInfoBean {
        /**
         * vehicleType : 1
         * vehicleBrand : 1
         * vehicleBrandName : ces
         * colorId : 1
         * colorName : 23432
         * colorSecondId : 2
         * colorSecondName : cees
         * plateNumber : 12
         */

        private int vehicleType;
        private String vehicleBrand;
        private String vehicleBrandName;
        private String colorId;
        private String colorName;
        private String colorSecondId;
        private String colorSecondName;
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

        public String getColorSecondName() {
            return colorSecondName;
        }

        public void setColorSecondName(String colorSecondName) {
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
         * lableList : [{"index":1,"lableType":"8102","lableNumber":"81021234567890"},{"index":2,"lableType":"8102","lableNumber":"81021112223336"}]
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
             * lableType : 8102
             * lableNumber : 81021234567890
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
         * buyDate : 2020-01-16
         * buyPrice : null
         * photoList : [{"index":1,"photoType":1,"photo":"photo address"},{"index":2,"photoType":2,"photo":"图片地址222222"},{"index":3,"photoType":3,"photo":"图片地址3"}]
         */

        private String buyDate;
        private Object buyPrice;
        private List<PhotoListBean> photoList;

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
        }

        public Object getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(Object buyPrice) {
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
             * photo : photo address
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
         * ownerName : 新车主姓名6
         * cardType : 1
         * cardName : 身份证
         * cardId : 370724199406024785
         * phone1 : 新车主联系电话6
         * phone2 : 新车主备用电话6
         * residentAddress : 新车主居住地址6
         * remark : null
         */

        private String ownerName;
        private int cardType;
        private String cardName;
        private String cardId;
        private String phone1;
        private String phone2;
        private String residentAddress;
        private Object remark;

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

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
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

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }
    }
}
