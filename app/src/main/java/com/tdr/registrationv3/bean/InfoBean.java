package com.tdr.registrationv3.bean;

import java.util.List;

public class InfoBean {


    /**
     * electriccars : {"id":1582077024357,"ecid":null,"plateNumber":"886603","engineNumber":"DJH","shelvesNumber":"CJH","vehicleBrand":"218","vehicleBrandName":"欧陵","colorId":"4","colorName":null,"colorSecondId":"3","colorSecondName":"绿色","buyDate":"2020-02-18","buyPrice":800,"vehicleType":1,"vehicleModels":null,"isOldVehicle":0,"photoList":"[{\"index\":1,\"photo\":\"e38493e56cd28907ddb1a5199be63323\",\"photoType\":1},{\"index\":2,\"photo\":\"1c8843865f85063896b625738118cc4c\",\"photoType\":2}]","ownerName":"iOS","cardId":"123","cardName":"台胞证","cardType":3,"residentAddress":"稳住","phone1":"13163240531","phone2":"","unitId":null,"unitNo":"410148000000","unitName":"郑州市公安局建设路派出所","source":null,"preRegisterNo":null,"isHasRfid":null,"plateType":null,"changeState":0,"transferState":0,"transferSource":null,"isInvalid":0,"invalidTime":null,"invalidBy":null,"invalidRemak":null,"isLock":0,"isScrap":0,"scrapTime":null,"scrapBy":null,"scrapRemark":null,"isGrantDeploy":0,"invoiceOption":null,"invoiceState":2,"invoiceOrderNo":null,"dataIp":"10.1.30.121","createBy":410,"createTime":"2020-02-19T09:50:24","alterBy":null,"alterTime":null,"operationBy":null,"operationTime":null,"subsystemId":13,"oldInvalidBy":null,"oldScrapBy":null,"oldCreateBy":null,"oldAlterBy":null,"oldOperationBy":null,"remark":"测试","createUserType":"Police"}
     * photoList : [{"index":1,"photoType":1,"photo":"e38493e56cd28907ddb1a5199be63323","photoName":null},{"index":2,"photoType":2,"photo":"1c8843865f85063896b625738118cc4c","photoName":null}]
     * electriccarsMapList : [{"id":1582077024373,"electriccarsId":1582077024357,"ecid":null,"plateNumber":"886603","lableType":32803,"lableNumber":"4433221103","originalLableNumber":"80234433221103","lableOrdinal":1,"isDelete":0,"isDeploy":0,"bindTime":"2020-02-19T09:50:24","untyingTime":null,"operationTime":"2020-02-19T09:50:24","subsystemId":13},{"id":1582077024418,"electriccarsId":1582077024357,"ecid":null,"plateNumber":"886603","lableType":32769,"lableNumber":"4433221103","originalLableNumber":"80014433221103","lableOrdinal":2,"isDelete":0,"isDeploy":0,"bindTime":"2020-02-19T09:50:24","untyingTime":null,"operationTime":"2020-02-19T09:50:24","subsystemId":13}]
     * policyList : [{"id":1582077025405,"policyid":null,"policyNumber":"6eb46eb9-c0e8-4d0f-bed1-a501b48272cd","orderId":1582077025405,"insuranceConfigId":8,"insurancePackageId":15,"insuranceType":2,"price":20,"deadLine":1,"insuranceBuyDate":"2020-02-19","policyStartDate":"2020-02-20","policyEndDate":"2021-02-19T23:59:59","insuranceCompanyType":2,"insuranceStatus":0,"policyStatus":0,"cancelTime":null,"cancelBy":null,"alterTime":null,"electriccarsId":1582077024357,"plateNumber":"886603","vehicleBrand":"218","engineNumber":"DJH","shelvesNumber":"CJH","colorId":"4","buyDate":"2020-02-18","ownerName":"iOS","cardId":"123","cardType":3,"phone1":"13163240531","residentAddress":"稳住","source":0,"dataIp":"10.1.30.121","createBy":410,"createUserName":null,"unitId":null,"unitNo":"410148000000","unitName":"郑州市公安局建设路派出所","createTime":"2020-02-19T09:50:24","oldCancelBy":null,"oldCreateBy":null,"subsystemId":13,"message":"推送成功","error":0}]
     */

    private ElectriccarsBean electriccars;
    private List<PhotoListBean> photoList;
    private List<ElectriccarsMapListBean> electriccarsMapList;
    private List<PolicyListBean> policyList;

    public ElectriccarsBean getElectriccars() {
        return electriccars;
    }

    public void setElectriccars(ElectriccarsBean electriccars) {
        this.electriccars = electriccars;
    }

    public List<PhotoListBean> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoListBean> photoList) {
        this.photoList = photoList;
    }

    public List<ElectriccarsMapListBean> getElectriccarsMapList() {
        return electriccarsMapList;
    }

    public void setElectriccarsMapList(List<ElectriccarsMapListBean> electriccarsMapList) {
        this.electriccarsMapList = electriccarsMapList;
    }

    public List<PolicyListBean> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<PolicyListBean> policyList) {
        this.policyList = policyList;
    }

    public static class ElectriccarsBean {
        /**
         * id : 1582077024357
         * ecid : null
         * plateNumber : 886603
         * engineNumber : DJH
         * shelvesNumber : CJH
         * vehicleBrand : 218
         * vehicleBrandName : 欧陵
         * colorId : 4
         * colorName : null
         * colorSecondId : 3
         * colorSecondName : 绿色
         * buyDate : 2020-02-18
         * buyPrice : 800.0
         * vehicleType : 1
         * vehicleModels : null
         * isOldVehicle : 0
         * photoList : [{"index":1,"photo":"e38493e56cd28907ddb1a5199be63323","photoType":1},{"index":2,"photo":"1c8843865f85063896b625738118cc4c","photoType":2}]
         * ownerName : iOS
         * cardId : 123
         * cardName : 台胞证
         * cardType : 3
         * residentAddress : 稳住
         * phone1 : 13163240531
         * phone2 :
         * unitId : null
         * unitNo : 410148000000
         * unitName : 郑州市公安局建设路派出所
         * source : null
         * preRegisterNo : null
         * isHasRfid : null
         * plateType : null
         * changeState : 0
         * transferState : 0
         * transferSource : null
         * isInvalid : 0
         * invalidTime : null
         * invalidBy : null
         * invalidRemak : null
         * isLock : 0
         * isScrap : 0
         * scrapTime : null
         * scrapBy : null
         * scrapRemark : null
         * isGrantDeploy : 0
         * invoiceOption : null
         * invoiceState : 2
         * invoiceOrderNo : null
         * dataIp : 10.1.30.121
         * createBy : 410
         * createTime : 2020-02-19T09:50:24
         * alterBy : null
         * alterTime : null
         * operationBy : null
         * operationTime : null
         * subsystemId : 13
         * oldInvalidBy : null
         * oldScrapBy : null
         * oldCreateBy : null
         * oldAlterBy : null
         * oldOperationBy : null
         * remark : 测试
         * createUserType : Police
         */

        private long id;
        private Object ecid;
        private String plateNumber;
        private String engineNumber;
        private String shelvesNumber;
        private String vehicleBrand;
        private String vehicleBrandName;
        private String colorId;
        private String colorName;
        private String colorSecondId;
        private String colorSecondName;
        private String buyDate;
        private double buyPrice;
        private int vehicleType;
        private Object vehicleModels;
        private int isOldVehicle;
        private String photoList;
        private String ownerName;
        private String cardId;
        private String cardName;
        private int cardType;
        private String residentAddress;
        private String phone1;
        private String phone2;
        private Object unitId;
        private String unitNo;
        private String unitName;
        private Object source;
        private Object preRegisterNo;
        private Object isHasRfid;
        private Object plateType;
        private int changeState;
        private int transferState;
        private Object transferSource;
        private int isInvalid;
        private Object invalidTime;
        private Object invalidBy;
        private Object invalidRemak;
        private int isLock;
        private int isScrap;
        private Object scrapTime;
        private Object scrapBy;
        private Object scrapRemark;
        private int isGrantDeploy;
        private Object invoiceOption;
        private int invoiceState;
        private Object invoiceOrderNo;
        private String dataIp;
        private int createBy;
        private String createTime;
        private Object alterBy;
        private Object alterTime;
        private Object operationBy;
        private Object operationTime;
        private int subsystemId;
        private Object oldInvalidBy;
        private Object oldScrapBy;
        private Object oldCreateBy;
        private Object oldAlterBy;
        private Object oldOperationBy;
        private String remark;
        private String createUserType;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Object getEcid() {
            return ecid;
        }

        public void setEcid(Object ecid) {
            this.ecid = ecid;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
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

        public int getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(int vehicleType) {
            this.vehicleType = vehicleType;
        }

        public Object getVehicleModels() {
            return vehicleModels;
        }

        public void setVehicleModels(Object vehicleModels) {
            this.vehicleModels = vehicleModels;
        }

        public int getIsOldVehicle() {
            return isOldVehicle;
        }

        public void setIsOldVehicle(int isOldVehicle) {
            this.isOldVehicle = isOldVehicle;
        }

        public String getPhotoList() {
            return photoList;
        }

        public void setPhotoList(String photoList) {
            this.photoList = photoList;
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

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public int getCardType() {
            return cardType;
        }

        public void setCardType(int cardType) {
            this.cardType = cardType;
        }

        public String getResidentAddress() {
            return residentAddress;
        }

        public void setResidentAddress(String residentAddress) {
            this.residentAddress = residentAddress;
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

        public Object getUnitId() {
            return unitId;
        }

        public void setUnitId(Object unitId) {
            this.unitId = unitId;
        }

        public String getUnitNo() {
            return unitNo;
        }

        public void setUnitNo(String unitNo) {
            this.unitNo = unitNo;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getPreRegisterNo() {
            return preRegisterNo;
        }

        public void setPreRegisterNo(Object preRegisterNo) {
            this.preRegisterNo = preRegisterNo;
        }

        public Object getIsHasRfid() {
            return isHasRfid;
        }

        public void setIsHasRfid(Object isHasRfid) {
            this.isHasRfid = isHasRfid;
        }

        public Object getPlateType() {
            return plateType;
        }

        public void setPlateType(Object plateType) {
            this.plateType = plateType;
        }

        public int getChangeState() {
            return changeState;
        }

        public void setChangeState(int changeState) {
            this.changeState = changeState;
        }

        public int getTransferState() {
            return transferState;
        }

        public void setTransferState(int transferState) {
            this.transferState = transferState;
        }

        public Object getTransferSource() {
            return transferSource;
        }

        public void setTransferSource(Object transferSource) {
            this.transferSource = transferSource;
        }

        public int getIsInvalid() {
            return isInvalid;
        }

        public void setIsInvalid(int isInvalid) {
            this.isInvalid = isInvalid;
        }

        public Object getInvalidTime() {
            return invalidTime;
        }

        public void setInvalidTime(Object invalidTime) {
            this.invalidTime = invalidTime;
        }

        public Object getInvalidBy() {
            return invalidBy;
        }

        public void setInvalidBy(Object invalidBy) {
            this.invalidBy = invalidBy;
        }

        public Object getInvalidRemak() {
            return invalidRemak;
        }

        public void setInvalidRemak(Object invalidRemak) {
            this.invalidRemak = invalidRemak;
        }

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public int getIsScrap() {
            return isScrap;
        }

        public void setIsScrap(int isScrap) {
            this.isScrap = isScrap;
        }

        public Object getScrapTime() {
            return scrapTime;
        }

        public void setScrapTime(Object scrapTime) {
            this.scrapTime = scrapTime;
        }

        public Object getScrapBy() {
            return scrapBy;
        }

        public void setScrapBy(Object scrapBy) {
            this.scrapBy = scrapBy;
        }

        public Object getScrapRemark() {
            return scrapRemark;
        }

        public void setScrapRemark(Object scrapRemark) {
            this.scrapRemark = scrapRemark;
        }

        public int getIsGrantDeploy() {
            return isGrantDeploy;
        }

        public void setIsGrantDeploy(int isGrantDeploy) {
            this.isGrantDeploy = isGrantDeploy;
        }

        public Object getInvoiceOption() {
            return invoiceOption;
        }

        public void setInvoiceOption(Object invoiceOption) {
            this.invoiceOption = invoiceOption;
        }

        public int getInvoiceState() {
            return invoiceState;
        }

        public void setInvoiceState(int invoiceState) {
            this.invoiceState = invoiceState;
        }

        public Object getInvoiceOrderNo() {
            return invoiceOrderNo;
        }

        public void setInvoiceOrderNo(Object invoiceOrderNo) {
            this.invoiceOrderNo = invoiceOrderNo;
        }

        public String getDataIp() {
            return dataIp;
        }

        public void setDataIp(String dataIp) {
            this.dataIp = dataIp;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getAlterBy() {
            return alterBy;
        }

        public void setAlterBy(Object alterBy) {
            this.alterBy = alterBy;
        }

        public Object getAlterTime() {
            return alterTime;
        }

        public void setAlterTime(Object alterTime) {
            this.alterTime = alterTime;
        }

        public Object getOperationBy() {
            return operationBy;
        }

        public void setOperationBy(Object operationBy) {
            this.operationBy = operationBy;
        }

        public Object getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(Object operationTime) {
            this.operationTime = operationTime;
        }

        public int getSubsystemId() {
            return subsystemId;
        }

        public void setSubsystemId(int subsystemId) {
            this.subsystemId = subsystemId;
        }

        public Object getOldInvalidBy() {
            return oldInvalidBy;
        }

        public void setOldInvalidBy(Object oldInvalidBy) {
            this.oldInvalidBy = oldInvalidBy;
        }

        public Object getOldScrapBy() {
            return oldScrapBy;
        }

        public void setOldScrapBy(Object oldScrapBy) {
            this.oldScrapBy = oldScrapBy;
        }

        public Object getOldCreateBy() {
            return oldCreateBy;
        }

        public void setOldCreateBy(Object oldCreateBy) {
            this.oldCreateBy = oldCreateBy;
        }

        public Object getOldAlterBy() {
            return oldAlterBy;
        }

        public void setOldAlterBy(Object oldAlterBy) {
            this.oldAlterBy = oldAlterBy;
        }

        public Object getOldOperationBy() {
            return oldOperationBy;
        }

        public void setOldOperationBy(Object oldOperationBy) {
            this.oldOperationBy = oldOperationBy;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreateUserType() {
            return createUserType;
        }

        public void setCreateUserType(String createUserType) {
            this.createUserType = createUserType;
        }
    }

    public static class PhotoListBean {
        /**
         * index : 1
         * photoType : 1
         * photo : e38493e56cd28907ddb1a5199be63323
         * photoName : null
         */

        private int index;
        private int photoType;
        private String photo;
        private Object photoName;

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

        public Object getPhotoName() {
            return photoName;
        }

        public void setPhotoName(Object photoName) {
            this.photoName = photoName;
        }
    }

    public static class ElectriccarsMapListBean {
        /**
         * id : 1582077024373
         * electriccarsId : 1582077024357
         * ecid : null
         * plateNumber : 886603
         * lableType : 32803
         * lableNumber : 4433221103
         * originalLableNumber : 80234433221103
         * lableOrdinal : 1
         * isDelete : 0
         * isDeploy : 0
         * bindTime : 2020-02-19T09:50:24
         * untyingTime : null
         * operationTime : 2020-02-19T09:50:24
         * subsystemId : 13
         */

        private long id;
        private long electriccarsId;
        private Object ecid;
        private String plateNumber;
        private int lableType;
        private String lableNumber;
        private String originalLableNumber;
        private int lableOrdinal;
        private int isDelete;
        private int isDeploy;
        private String bindTime;
        private Object untyingTime;
        private String operationTime;
        private int subsystemId;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getElectriccarsId() {
            return electriccarsId;
        }

        public void setElectriccarsId(long electriccarsId) {
            this.electriccarsId = electriccarsId;
        }

        public Object getEcid() {
            return ecid;
        }

        public void setEcid(Object ecid) {
            this.ecid = ecid;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }

        public int getLableType() {
            return lableType;
        }

        public void setLableType(int lableType) {
            this.lableType = lableType;
        }

        public String getLableNumber() {
            return lableNumber;
        }

        public void setLableNumber(String lableNumber) {
            this.lableNumber = lableNumber;
        }

        public String getOriginalLableNumber() {
            return originalLableNumber;
        }

        public void setOriginalLableNumber(String originalLableNumber) {
            this.originalLableNumber = originalLableNumber;
        }

        public int getLableOrdinal() {
            return lableOrdinal;
        }

        public void setLableOrdinal(int lableOrdinal) {
            this.lableOrdinal = lableOrdinal;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public int getIsDeploy() {
            return isDeploy;
        }

        public void setIsDeploy(int isDeploy) {
            this.isDeploy = isDeploy;
        }

        public String getBindTime() {
            return bindTime;
        }

        public void setBindTime(String bindTime) {
            this.bindTime = bindTime;
        }

        public Object getUntyingTime() {
            return untyingTime;
        }

        public void setUntyingTime(Object untyingTime) {
            this.untyingTime = untyingTime;
        }

        public String getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(String operationTime) {
            this.operationTime = operationTime;
        }

        public int getSubsystemId() {
            return subsystemId;
        }

        public void setSubsystemId(int subsystemId) {
            this.subsystemId = subsystemId;
        }
    }

    public static class PolicyListBean {
        /**
         * id : 1582077025405
         * policyid : null
         * policyNumber : 6eb46eb9-c0e8-4d0f-bed1-a501b48272cd
         * orderId : 1582077025405
         * insuranceConfigId : 8
         * insurancePackageId : 15
         * insuranceType : 2
         * price : 20.0
         * deadLine : 1
         * insuranceBuyDate : 2020-02-19
         * policyStartDate : 2020-02-20
         * policyEndDate : 2021-02-19T23:59:59
         * insuranceCompanyType : 2
         * insuranceStatus : 0
         * policyStatus : 0
         * cancelTime : null
         * cancelBy : null
         * alterTime : null
         * electriccarsId : 1582077024357
         * plateNumber : 886603
         * vehicleBrand : 218
         * engineNumber : DJH
         * shelvesNumber : CJH
         * colorId : 4
         * buyDate : 2020-02-18
         * ownerName : iOS
         * cardId : 123
         * cardType : 3
         * phone1 : 13163240531
         * residentAddress : 稳住
         * source : 0
         * dataIp : 10.1.30.121
         * createBy : 410
         * createUserName : null
         * unitId : null
         * unitNo : 410148000000
         * unitName : 郑州市公安局建设路派出所
         * createTime : 2020-02-19T09:50:24
         * oldCancelBy : null
         * oldCreateBy : null
         * subsystemId : 13
         * message : 推送成功
         * error : 0
         */

        private long id;
        private Object policyid;
        private String policyNumber;
        private long orderId;
        private int insuranceConfigId;
        private int insurancePackageId;
        private int insuranceType;
        private double price;
        private int deadLine;
        private String insuranceBuyDate;
        private String policyStartDate;
        private String policyEndDate;
        private int insuranceCompanyType;
        private int insuranceStatus;
        private int policyStatus;
        private Object cancelTime;
        private Object cancelBy;
        private Object alterTime;
        private long electriccarsId;
        private String plateNumber;
        private String vehicleBrand;
        private String engineNumber;
        private String shelvesNumber;
        private String colorId;
        private String buyDate;
        private String ownerName;
        private String cardId;
        private int cardType;
        private String phone1;
        private String residentAddress;
        private int source;
        private String dataIp;
        private int createBy;
        private Object createUserName;
        private Object unitId;
        private String unitNo;
        private String unitName;
        private String createTime;
        private Object oldCancelBy;
        private Object oldCreateBy;
        private int subsystemId;
        private String message;
        private int error;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Object getPolicyid() {
            return policyid;
        }

        public void setPolicyid(Object policyid) {
            this.policyid = policyid;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
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

        public int getInsuranceType() {
            return insuranceType;
        }

        public void setInsuranceType(int insuranceType) {
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

        public String getPolicyStartDate() {
            return policyStartDate;
        }

        public void setPolicyStartDate(String policyStartDate) {
            this.policyStartDate = policyStartDate;
        }

        public String getPolicyEndDate() {
            return policyEndDate;
        }

        public void setPolicyEndDate(String policyEndDate) {
            this.policyEndDate = policyEndDate;
        }

        public int getInsuranceCompanyType() {
            return insuranceCompanyType;
        }

        public void setInsuranceCompanyType(int insuranceCompanyType) {
            this.insuranceCompanyType = insuranceCompanyType;
        }

        public int getInsuranceStatus() {
            return insuranceStatus;
        }

        public void setInsuranceStatus(int insuranceStatus) {
            this.insuranceStatus = insuranceStatus;
        }

        public int getPolicyStatus() {
            return policyStatus;
        }

        public void setPolicyStatus(int policyStatus) {
            this.policyStatus = policyStatus;
        }

        public Object getCancelTime() {
            return cancelTime;
        }

        public void setCancelTime(Object cancelTime) {
            this.cancelTime = cancelTime;
        }

        public Object getCancelBy() {
            return cancelBy;
        }

        public void setCancelBy(Object cancelBy) {
            this.cancelBy = cancelBy;
        }

        public Object getAlterTime() {
            return alterTime;
        }

        public void setAlterTime(Object alterTime) {
            this.alterTime = alterTime;
        }

        public long getElectriccarsId() {
            return electriccarsId;
        }

        public void setElectriccarsId(long electriccarsId) {
            this.electriccarsId = electriccarsId;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }

        public String getVehicleBrand() {
            return vehicleBrand;
        }

        public void setVehicleBrand(String vehicleBrand) {
            this.vehicleBrand = vehicleBrand;
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

        public String getColorId() {
            return colorId;
        }

        public void setColorId(String colorId) {
            this.colorId = colorId;
        }

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
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

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public String getDataIp() {
            return dataIp;
        }

        public void setDataIp(String dataIp) {
            this.dataIp = dataIp;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public Object getCreateUserName() {
            return createUserName;
        }

        public void setCreateUserName(Object createUserName) {
            this.createUserName = createUserName;
        }

        public Object getUnitId() {
            return unitId;
        }

        public void setUnitId(Object unitId) {
            this.unitId = unitId;
        }

        public String getUnitNo() {
            return unitNo;
        }

        public void setUnitNo(String unitNo) {
            this.unitNo = unitNo;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getOldCancelBy() {
            return oldCancelBy;
        }

        public void setOldCancelBy(Object oldCancelBy) {
            this.oldCancelBy = oldCancelBy;
        }

        public Object getOldCreateBy() {
            return oldCreateBy;
        }

        public void setOldCreateBy(Object oldCreateBy) {
            this.oldCreateBy = oldCreateBy;
        }

        public int getSubsystemId() {
            return subsystemId;
        }

        public void setSubsystemId(int subsystemId) {
            this.subsystemId = subsystemId;
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
